package org.example.onlinemediclestore.Classes;

public class Supplier extends  User {


    private String companyName;
    private String address;
    public Supplier(String name,String username,String password, String email, String companyName,String address){
        super(name,username,password,"supplier",email);
        this.companyName= companyName;
        this.address= address;

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

}

