package com.example.rathana.mvp_demo.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rathana.mvp_demo.R;
import com.example.rathana.mvp_demo.app.ActivityComponent;
import com.example.rathana.mvp_demo.app.DaggerActivityComponent;
import com.example.rathana.mvp_demo.app.di.ActivityModule;
import com.example.rathana.mvp_demo.model.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    ActivityComponent component;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        component=DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .build();

        component.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user.setId(2);
        user.setName("reksmey");
        user.setPassword("123456");

        Log.e("ieject","User :"+user.toString());

    }
}
