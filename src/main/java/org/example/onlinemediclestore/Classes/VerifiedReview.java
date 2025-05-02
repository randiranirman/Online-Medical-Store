package org.example.onlinemediclestore.Classes;

public class VerifiedReview  extends  Review{
    public VerifiedReview(Medicine medicine, Customer customer, String review, boolean isVerified) {
        super(medicine, customer, review, isVerified);
    }
}
