package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.*;
import com.mabrouk.mohamed.lostandfound.R;


public class FireBaseRepositoryImpl implements LoginRegisterContract.FireBaseRepository {
    private static final String TAG = FireBaseRepositoryImpl.class.getSimpleName() + "TAGG";

    private FirebaseAuth mAuth;
    private Activity mActivity;
    private LoginRegisterContract.LoginPresenter mPresenter;

    public FireBaseRepositoryImpl(Activity mActivity, LoginPresenterImpl mPresenter) {
        mAuth = FirebaseAuth.getInstance();
        this.mActivity = mActivity;
        this.mPresenter = mPresenter;
    }


    @Override
    public void loginWithMail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser currentUser = mAuth.getCurrentUser();

                            Log.d(TAG, "signInWithEmail:success");
                            if (currentUser != null) {
                                Log.d(TAG, "Hello: " + currentUser.getEmail());
                            }
                            // inform presenter
                            mPresenter.onLoginSuccess();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d(TAG, "signInWithEmail: error -> " + task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // wrong password
                                mPresenter.onLoginFailure(mActivity.getString(R.string.fragment_login_wrong_pass));
                            } else if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                // invalid user
                                mPresenter.onLoginFailure(mActivity.getString(R.string.fragment_login_email_does_not_exist));
                            } else if(task.getException() instanceof FirebaseTooManyRequestsException){
                                mPresenter.onLoginFailure(mActivity.getString(R.string.fragment_login_too_many_unsuccessful_login));
                                //TODO: include reCaptcha verification
                            }

                        }

                    }
                });
    }

    @Override
    public void registerWithMail(String email, String password) {

    }
}
