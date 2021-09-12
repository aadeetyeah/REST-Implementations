package com.aditya.UserService.controller;

import com.aditya.UserService.User;
import com.aditya.UserService.UserServiceC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServiceController {

    @Autowired
    private UserServiceC userServiceC;

    @GetMapping("/ping")
    public String ping(){
        return "Pong";
    }

    /*TO insert data in our Database. use JSON Format to insert User Object.*/
    @PostMapping("/store/userInfo")
    public String storeUserInfo(@RequestBody User user){
        return userServiceC.storeUser(user);
    }


    /* http://localhost:8080/fetch/userInfo?email=adityaanerao@gmail.com
    * use the Variable NAME : email (which we are passing in below method
    *
    * To Get the requested data. Pass email ID so to get its corresponding user object. */
    @GetMapping("/fetch/userInfo")
    public User fetchUserInfo(@RequestParam String email ){
        return userServiceC.fetchUser(email);
    }

}

/*TO send large amount of data use POST API
* To get not very sensitive information use GET API. */