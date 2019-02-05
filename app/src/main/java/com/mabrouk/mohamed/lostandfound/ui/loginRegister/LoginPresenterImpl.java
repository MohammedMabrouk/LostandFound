package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

import android.app.Activity;

public class LoginPresenterImpl implements LoginRegisterContract.LoginPresenter {

    private LoginRegisterContract.LoginView loginView;
    private LoginRegisterContract.FireBaseRepository repository;


    public LoginPresenterImpl(LoginRegisterContract.LoginView loginView, Activity mActivity) {
        this.loginView = loginView;
        this.repository = new FireBaseRepositoryImpl(mActivity, this);
    }

    @Override
    public void onLoginButtonClick(String email, String password) {
        // start
        loginView.hideErrorMsg();
        loginView.showProgress();
        repository.loginWithMail(email, password);
    }

    @Override
    public void onLoginSuccess() {
        loginView.hideProgress();
        loginView.navigateToHome();
    }

    @Override
    public void onLoginFailure(String error) {
        loginView.hideProgress();
        loginView.showErrorMsg();
        loginView.setErrorMsg(error);
    }

    @Override
    public void onDestroy() {

    }
}
