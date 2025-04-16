package org.example.onlinemediclestore.FileHandlers;

import com.sun.security.auth.login.ConfigFile;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.Interfaces.IUserFileHandler;
import org.example.onlinemediclestore.utils.JsonHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandler implements IUserFileHandler {
    private  final  String FILE_PATH= Config.USERS.getPath();    ;
    public UserFileHandler(){
        File dir = new File("medicare");
        if( !dir.exists()){
            dir.mkdirs();
        }
    }





    @Override
    public void saveUser(User user) throws IOException {
        System.out.println("Function is working ");
        List<User> users = new ArrayList<>();

        try {
            // Try to read existing users if file exists
            FileReader reader = new FileReader(FILE_PATH);
            String content = readerToString(reader);
            if (!content.isEmpty()) {
                users = JsonHelper.fromJsonToList(content, User.class);
                if (users == null) {
                    users = new ArrayList<>();
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, which is fine for first use
            System.out.println("Creating new users file");
            // We'll continue with the empty users list
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Re-throw to notify caller of other IO issues
        }

        // Add new user
        users.add(user);

        // Save updated list back to file
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(JsonHelper.toJson(users));
            writer.write("\n");
            System.out.println("User saved successfully to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String readerToString(FileReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        reader.close();
        return sb.toString();
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        try(FileReader reader = new FileReader(FILE_PATH) ){
            String json = readerToString(reader);
            List<User> users = JsonHelper.fromJsonToList(json,User.class);
            return users != null ? users : new ArrayList<>();

        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }
}
