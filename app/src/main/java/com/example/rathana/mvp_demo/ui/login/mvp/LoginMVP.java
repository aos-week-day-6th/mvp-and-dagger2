package com.example.rathana.mvp_demo.ui.login.mvp;

public interface LoginMVP {

    interface  View{
        void onShowLoading();
        void onHideLoading();
        void onFailLogin(String error);
        <T> void  onSuccessLogin(T t);
    }

    interface Presenter{
        void setView(View view);
        void login(String username,String password);
    }
    interface Interactor{
        void attemptLogin(String username,String password,InteractorResponse response);

    }

    interface InteractorResponse{
        <T> void onSuccess(T t);
        void onFailLogin(String error);
    }
}
