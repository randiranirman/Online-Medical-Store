package org.example.onlinemediclestore.utils;

import org.example.onlinemediclestore.Classes.Review;
import org.example.onlinemediclestore.Classes.VerifiedReview;
import org.example.onlinemediclestore.Classes.PublicReview;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReviewManager {
    private static final String REVIEWS_FILE_PATH = "data/reviews.json";
    private final GenericCRUD<Review> reviewCRUD;

    // Singleton pattern
    private static ReviewManager instance;

    private ReviewManager() {
        this.reviewCRUD = new GenericCRUD<>(Review.class, REVIEWS_FILE_PATH);
    }

    public static synchronized ReviewManager getInstance() {
        if (instance == null) {
            instance = new ReviewManager();
        }
        return instance;
    }

    // Add a new review (unverified by default)
    public Review addReview(String userId, String productId, String content, int rating) {
        Review review = new Review();
        review.setId(UUID.randomUUID().toString());
        review.setUserId(userId);
        review.setProductId(productId);
        review.setContent(content);
        review.setRating(rating);

        reviewCRUD.add(review);
        return review;
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewCRUD.getAll();
    }

    // Get all reviews for a specific product
    public List<Review> getReviewsByProductId(String productId) {
        return reviewCRUD.getAll().stream()
                .filter(review -> review.getProductId().equals(productId))
                .collect(Collectors.toList());
    }

    // Get only verified reviews for a product (public facing)
    public List<Review> getVerifiedReviewsByProductId(String productId) {
        return reviewCRUD.getAll().stream()
                .filter(review -> review.getProductId().equals(productId) && review.isVerified())
                .collect(Collectors.toList());
    }

    // Get pending reviews (for admin)
    public List<Review> getPendingReviews() {
        return reviewCRUD.getAll().stream()
                .filter(review -> !review.isVerified())
                .collect(Collectors.toList());
    }

    // Get a review by ID
    public Optional<Review> getReviewById(String reviewId) {
        return reviewCRUD.findOneById(reviewId);
    }

    // Verify a review (admin function)
    public VerifiedReview verifyReview(String reviewId, String adminId) {
        Optional<Review> reviewOpt = getReviewById(reviewId);

        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            VerifiedReview verifiedReview = VerifiedReview.fromReview(review, adminId);

            // Update the review in storage
            reviewCRUD.update(r -> r.getId().equals(reviewId), verifiedReview);

            return verifiedReview;
        }

        return null;
    }

    // Reject and delete a review (admin function)
    public boolean rejectReview(String reviewId) {
        Optional<Review> reviewOpt = getReviewById(reviewId);
        if (reviewOpt.isPresent()) {
            reviewCRUD.delete(review -> review.getId().equals(reviewId));
            return true;
        }
        return false;
    }

    // Calculate average rating for a product
    public double getAverageRating(String productId) {
        List<Review> verifiedReviews = getVerifiedReviewsByProductId(productId);

        if (verifiedReviews.isEmpty()) {
            return 0.0;
        }

        double sum = verifiedReviews.stream()
                .mapToInt(Review::getRating)
                .sum();

        return sum / verifiedReviews.size();
    }
}