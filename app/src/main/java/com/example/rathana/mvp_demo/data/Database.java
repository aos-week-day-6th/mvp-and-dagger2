package com.example.rathana.mvp_demo.data;

public class Database {
    private static UserRepository userRepository;

    public static UserRepository getUserRepository(){
        if(userRepository==null)
            userRepository=new UserRepository();

        return userRepository;
    }
}
