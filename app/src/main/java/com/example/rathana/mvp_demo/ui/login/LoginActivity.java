package com.example.rathana.mvp_demo.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rathana.mvp_demo.R;
import com.example.rathana.mvp_demo.app.ActivityComponent;
import com.example.rathana.mvp_demo.app.DaggerActivityComponent;
import com.example.rathana.mvp_demo.app.di.ActivityModule;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginMVP;
import com.example.rathana.mvp_demo.ui.login.mvp.LoginPresenter;
import com.example.rathana.mvp_demo.ui.main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity
implements LoginMVP.View {

    ActivityComponent component;

    @Inject
    LoginPresenter presenter;

    private EditText username,password;
    private Button btnLogin;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        component= DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .build();
        component.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        initObjects();
        presenter.setView(this);
        //set event login
        btnLogin.setOnClickListener(v->{
            //login
            presenter.login(
                    username.getText().toString(),
                    password.getText().toString()
            );
        });

    }
    private void setupUI() {
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        progressBar=findViewById(R.id.progressBar);
    }

    void initObjects(){
        //presenter= new LoginPresenter();
    }
    //update View MVP


    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public <User> void onSuccessLogin(User user) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onFailLogin(String error) {
        username.setFocusable(true);
        Toast.makeText(this, "Login failed. wrong user name or password", Toast.LENGTH_SHORT).show();
    }
}
