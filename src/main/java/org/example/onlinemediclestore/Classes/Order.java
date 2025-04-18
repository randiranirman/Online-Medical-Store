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




}
