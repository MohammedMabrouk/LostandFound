package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

public class LoginRegisterContract {
    interface LoginView{
        void showProgress();
        void hideProgress();
        void setErrorMsg(String error);
        void showErrorMsg();
        void hideErrorMsg();
        void navigateToHome();
    }

    interface RegisterView{
        void showProgress();
        void hideProgress();
        void setErrorMsg(String error);
        void showErrorMsg();
        void hideErrorMsg();
        void navigateToHome();
    }

    interface LoginPresenter{
        void onLoginButtonClick(String email, String password);
        void onLoginSuccess();
        void onLoginFailure(String error);
        void onDestroy();
    }

    interface RegisterPresenter{
        void onRegisterButtonClick();
        void onDestroy();
    }

    interface FireBaseRepository{
        void loginWithMail(String email, String password);
        void registerWithMail(String email, String password);
    }
}
