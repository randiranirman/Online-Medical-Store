package org.example.onlinemediclestore.Classes;

public class Customer extends  User{


    public Customer(String name, String username, String password, String role,String email) {
        super(name, username, password, role,email);
    }

    public Customer(String updatedUsername, String name, String email) {
        super(updatedUsername, name,null,"customer", email);
    }


}
