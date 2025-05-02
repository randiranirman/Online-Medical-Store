package org.example.onlinemediclestore.Classes;

public class VerifiedReview  extends  Review{


    private String verifiedByUserId;
    private String verificationDate;
    private String  verificationNotes;


    public VerifiedReview() {
        super();
        this.setVerified(true);
    }

    public VerifiedReview(String id, String medicineId, String medicineName, String userId, String userName,
                          int rating, String comments, String verifiedByUserId,
                          String verificationDate, String verificationNotes) {
        super(id, medicineId, medicineName, userId, userName, rating, comments);
        this.setVerified(true);
        this.verifiedByUserId = verifiedByUserId;
        this.verificationDate = verificationDate;
        this.verificationNotes = verificationNotes;
    }
    public String getVerifiedByUserId() {
        return verifiedByUserId;
    }

    public void setVerifiedByUserId(String verifiedByUserId) {
        this.verifiedByUserId = verifiedByUserId;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerificationNotes() {
        return verificationNotes;
    }

    public void setVerificationNotes(String verificationNotes) {
        this.verificationNotes = verificationNotes;
    }

    // Overridden display method (Polymorphism)
    @Override
    public String display() {
        return "VERIFIED: " + super.display() + " (Verified by Admin)";
    }
}
