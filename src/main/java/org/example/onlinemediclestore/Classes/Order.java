package org.example.onlinemediclestore.Classes;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private String id;
    private String medicineName;
    private int quantity;
    private String address;
    private Medicine medicine;
    private Customer customer;
    private double totalPrice;
    private String status;
    private LocalDateTime orderDate;

    // Default constructor required for serialization
    public Order() {
    }

    public Order(String id, String medicineName, Customer customer, Medicine medicine,
                 int quantity, String address, double totalPrice, String status, LocalDateTime orderDate) {
        this.id = id;
        this.medicineName = medicineName;
        this.customer = customer;
        this.medicine = medicine;
        this.quantity = quantity;
        this.address = address;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
    }

    // Simpler constructor matching your original
    public Order(String medicineName, Customer customer, Medicine medicine) {
        this.medicineName = medicineName;
        this.customer = customer;
        this.medicine = medicine;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                ", medicine=" + medicine +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}