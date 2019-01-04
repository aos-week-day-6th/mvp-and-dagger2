package com.example.rathana.mvp_demo.app;

import com.example.rathana.mvp_demo.app.di.ActivityModule;
import com.example.rathana.mvp_demo.ui.login.LoginActivity;
import com.example.rathana.mvp_demo.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);
}
