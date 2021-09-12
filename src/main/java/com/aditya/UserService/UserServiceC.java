package com.aditya.UserService;

import org.springframework.stereotype.Service;

import java.util.HashMap;

//This will help Spring Boot to identify the class to use it for Dependency Injection.
@Service
public class UserServiceC {
    HashMap<String,User> userDb=new HashMap<>();

    public String storeUser(User user){
        String emailID=user.getEmailID();
        if(userDb.containsKey(emailID)){
            return "This user is already created.";
        }
        userDb.put(emailID,user);
        return "User added successfully";
    }

    public User fetchUser(String emailID){
        if(userDb.containsKey(emailID)){
            return userDb.get(emailID);
        }else{

            return null;
        }
    }
}
