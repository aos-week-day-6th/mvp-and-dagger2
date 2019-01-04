package com.example.rathana.mvp_demo.ui.login.mvp;

public class LoginPresenter implements LoginMVP.Presenter {
    private LoginMVP.Interactor interactor;
    private LoginMVP.View view;

    public LoginPresenter(LoginInteractor loginInteractor){
        interactor=loginInteractor;
    }
    @Override
    public void setView(LoginMVP.View view) {
            this.view=view;
    }
    @Override
    public void login(String username, String password) {
        if(view!=null)
            view.onShowLoading();
        interactor.attemptLogin(username, password, new LoginMVP.InteractorResponse() {
            @Override
            public <User> void onSuccess(User user) {
                if(view!=null){
                    view.onSuccessLogin(user);
                    view.onShowLoading();
                }
            }
            @Override
            public void onFailLogin(String error) {
                if(view!=null){
                    view.onFailLogin(error);
                    view.onHideLoading();
                }
            }
        });
    }
}
