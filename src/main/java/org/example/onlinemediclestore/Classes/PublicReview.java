package org.example.onlinemediclestore.Classes;

public class PublicReview extends Review {

    public PublicReview() {
        super();
    }

    public PublicReview(String id, String userId, String productId, String content, int rating) {
        super(id, userId, productId, content, rating);
    }

    // This can be used to create a public review from a base review
    public static PublicReview fromReview(Review review) {
        PublicReview publicReview = new PublicReview();
        publicReview.setId(review.getId());
        publicReview.setUserId(review.getUserId());
        publicReview.setProductId(review.getProductId());
        publicReview.setContent(review.getContent());
        publicReview.setRating(review.getRating());
        publicReview.setDateCreated(review.getDateCreated());
        publicReview.setVerified(false);
        return publicReview;
    }
}