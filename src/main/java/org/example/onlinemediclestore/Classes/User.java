package org.example.onlinemediclestore.Classes;

public class User {

    private   String username;
    private
    String password;

    protected String id ;
    private   String email;

    protected  String name;
    private String role;
    private  String userID;

    public User(String userID,String name, String username, String password, String role,String email) {
        this.userID= userID;
        this.name= name;
        this.username= username;
        this.password= password;
        this.role= role;
        this.email= email;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;

    }

    public  String getName(){
        return this.name;
    }

    public String getRole() {
        return role;
    }
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +

                ", name=" + name +
                ", role='" + role + '\'' +
                ", password=" + password +

                '}';
    }
}