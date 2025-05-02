package org.example.onlinemediclestore.Classes;

import java.time.LocalDateTime;

public class Review {


    private String id ;
    private String medicineId;
    private String username;
    private String comments;
    private int rating;

    private LocalDateTime reviewDate;
    private String medicineName;
    public Review() {
        this.reviewDate = LocalDateTime.now();
    }

    private String userID ;
    


    private boolean isVerified;

    public Review(String id , String medicineId,String medicineName,String userID , String username,int rating, String comments){


        this.id= id;
        this.medicineId= medicineId;
        this.isVerified=  false;
        this.rating= rating;
        this.userID=userID;
        this.medicineName =medicineName;
        this.comments= comments;
        this.reviewDate= LocalDateTime.now();
        this.username= username;


    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getMedicineId() {
        return medicineId;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }



    public void setComments(String comments) {
        this.comments = comments;
    }
    // display method will be overrittten in chilc classses
    public String display() {
        return "Review for " + medicineName + " by " + username + ": " + rating + "/5 stars";
    }






}
