package org.example.onlinemediclestore.Classes;

import java.time.LocalDateTime;

public class VerifiedReview extends Review {
    private LocalDateTime verificationDate;
    private String verifiedBy; // admin ID

    public VerifiedReview() {
        super();
        setVerified(true);
        this.verificationDate = LocalDateTime.now();
    }

    public VerifiedReview(String id, String userId, String productId, String content, int rating, String verifiedBy) {
        super(id, userId, productId, content, rating);
        setVerified(true);
        this.verificationDate = LocalDateTime.now();
        this.verifiedBy = verifiedBy;
    }

    // This can be used to create a verified review from a base review
    public static VerifiedReview fromReview(Review review, String adminId) {
        VerifiedReview verifiedReview = new VerifiedReview();
        verifiedReview.setId(review.getId());
        verifiedReview.setUserId(review.getUserId());
        verifiedReview.setProductId(review.getProductId());
        verifiedReview.setContent(review.getContent());
        verifiedReview.setRating(review.getRating());
        verifiedReview.setDateCreated(review.getDateCreated());
        verifiedReview.setVerified(true);
        verifiedReview.setVerificationDate(LocalDateTime.now());
        verifiedReview.setVerifiedBy(adminId);
        return verifiedReview;
    }

    public LocalDateTime getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDateTime verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }
}