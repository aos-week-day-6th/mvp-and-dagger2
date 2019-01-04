package com.example.rathana.mvp_demo.data;

import com.example.rathana.mvp_demo.model.User;

public class UserRepository {

    private User user;

    public UserRepository(){
        user=new User();

        user.setName("admin");
        user.setId(1);
        user.setPassword("admin");
    }

    public User authenticate(String name,String password){
        if(user.getName().equals(name) &&
                user.getPassword().equals(password))
            return user;
        else
            return null;
    }

}
