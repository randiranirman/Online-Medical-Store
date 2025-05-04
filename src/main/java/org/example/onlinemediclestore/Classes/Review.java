package org.example.onlinemediclestore.Classes;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private String userId;
    private String productId;
    private String content;
    private int rating; // 1-5 stars
    private LocalDateTime dateCreated;
    private boolean isVerified;

    public Review() {
        this.dateCreated = LocalDateTime.now();
        this.isVerified = false;
    }

    public Review(String id, String userId, String productId, String content, int rating) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.content = content;
        this.rating = rating;
        this.dateCreated = LocalDateTime.now();
        this.isVerified = false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}