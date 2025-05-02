package org.example.onlinemediclestore.Classes;

public class PublicReview extends  Review {
    private boolean isAnonymous;

    public PublicReview() {
        super();
        this.isAnonymous = false;
    }


    public PublicReview(String id , String medicineId, String medicineName,String userID,String username,int rating,String comment,boolean isAnonymous){
            super(id,medicineId,medicineName,userID,username,rating,comment);
            this.isAnonymous= isAnonymous;




    }
    public boolean isAnonymous(){
        return isAnonymous;
    }
    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    @Override
    public String display() {
        if (isAnonymous) {
            return "Review for " + getMedicineName() + " by Anonymous: " + getRating() + "/5 stars";
        } else {
            return super.display();
        }

    }

}



