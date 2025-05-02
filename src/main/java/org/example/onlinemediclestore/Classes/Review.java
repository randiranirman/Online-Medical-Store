package org.example.onlinemediclestore.Classes;

public class Review {
    private Medicine medicine;
    private Customer customer ;

    private String review;

    private boolean isVerified;


    public Review(Medicine medicine, Customer customer, String review, boolean isVerified){
        this.customer= customer;
        this.medicine= medicine;
        this.review= review;
        this.isVerified= isVerified;


    }



}
