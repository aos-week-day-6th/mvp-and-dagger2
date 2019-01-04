package com.example.rathana.mvp_demo.ui.login.mvp;

import android.os.Handler;

import com.example.rathana.mvp_demo.data.Database;
import com.example.rathana.mvp_demo.data.UserRepository;
import com.example.rathana.mvp_demo.model.User;
public class LoginInteractor implements LoginMVP.Interactor {

    UserRepository userRepository;
    public LoginInteractor(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void attemptLogin(String username,
                             String password,
                             LoginMVP.InteractorResponse response)
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user=authenticate(username,password);
                if(user==null)
                    response.onFailLogin("wrong username or password");
                else
                    response.onSuccess(user);
            }
        }, 1500);

    }

    private User authenticate(String username, String password){
        return userRepository.authenticate(username,password);
    }

}
