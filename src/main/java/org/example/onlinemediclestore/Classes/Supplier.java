package org.example.onlinemediclestore.Classes;

import java.util.ArrayList;

public class Supplier extends User {

    private String companyName;
    private ArrayList<Medicine> medicineList;

    private String address;

    // Full constructor for creating a new supplier
    public Supplier(String name, String username, String password, String email, String companyName, String address) {
        super(name, username, password, "supplier", email);
        this.companyName = companyName;
        this.address = address;

    }

    // Constructor for updating supplier (assuming password and role remain unchanged)
    public Supplier(String name, String username, String email, String companyName, String address) {
        super(name, username, null, "supplier", email); // password is null if not updated
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", companyName=" + companyName +
                ", address='" + address + '\'' +
                ", medicines=" + medicineList +
                ", address=" + address +

                '}';
    }
}
