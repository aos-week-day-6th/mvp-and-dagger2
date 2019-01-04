package com.example.rathana.mvp_demo.app.di;

import com.example.rathana.mvp_demo.data.Database;
import com.example.rathana.mvp_demo.data.UserRepository;
import com.example.rathana.mvp_demo.model.User;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginInteractor;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    public User provideUser(){
        return  new User();
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginInteractor loginInteractor){
        return  new LoginPresenter(loginInteractor);
    }

    @Provides
    public LoginInteractor provideLoginInteractor(UserRepository userRepository){
        return new LoginInteractor(userRepository);
    }

    @Provides
    public UserRepository provideUserRepository(){
        return Database.getUserRepository();
    }

}
