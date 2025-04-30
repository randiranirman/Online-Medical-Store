package org.example.onlinemediclestore.Classes;

public class Order {


    private String medicineName;
    private int qunatity;
    private Medicine medicine;
    private Customer customer;

    private double totalPrice ;


     public Order( String medicineName , Customer customer , Medicine medicine){
         this.medicine= medicine;
         this.customer = customer;
         this.medicineName= medicineName;

     }

    public String getMedicineName() {
        return medicineName;
    }

    public Medicine getMedicine() {
        return medicine;
    }


    public int getQunatity() {
        return qunatity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public Customer getCustomer() {
        return customer;
    }


    //

}

