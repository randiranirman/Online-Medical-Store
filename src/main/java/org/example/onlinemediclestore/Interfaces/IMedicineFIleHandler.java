package org.example.onlinemediclestore.Interfaces;

import org.example.onlinemediclestore.Classes.User;

import java.util.List;

public interface IMedicineFIleHandler {
    void saveUser(User user);
    User getUserById(String id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(String id);



}
