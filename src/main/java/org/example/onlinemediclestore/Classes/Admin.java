package org.example.onlinemediclestore.Classes;

public class Admin extends  User{

    private String role = "admin";
    public Admin(String name, String username, String password, String role, String email) {
        super(name, username, password, role, email);
    }


}
