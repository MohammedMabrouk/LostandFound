package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import com.mabrouk.mohamed.lostandfound.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnRegisterButtonClickListener, RegisterFragment.OnLoginButtonClickListener {
    private final static String TAG = LoginActivity.class.getSimpleName() + "TAG";

    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;


    @Override
    protected void onResume() {
        super.onResume();
        // prevent auto keyboard - hiding ui
        getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // init


        mLoginFragment = new LoginFragment();
        mLoginFragment.setOnRegisterButtonClickListener(this);
        mRegisterFragment = new RegisterFragment();
        mRegisterFragment.setOnLoginButtonClickListener(this);
        // Start State: with login fragment
        showLoginFragment();


    }

    /*@Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof LoginFragment) {
            Log.v(TAG, "on attach fragment -> login fragment");


        } else if (fragment instanceof RegisterFragment) {
            Log.v(TAG, "on attach fragment -> register fragment");


        }
    }*/


    private void showLoginFragment() {
        Log.v(TAG, "show login");
        getSupportFragmentManager().beginTransaction()
              .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.login_register_fragment_placeholder, mLoginFragment).commit();
    }

    private void showRegisterFragment() {
        Log.v(TAG, "show register");

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.login_register_fragment_placeholder, mRegisterFragment).commit();
    }

    @Override
    public void onRegisterButtonClicked() {
        Log.v(TAG, "login activity -> showing register fragment...");
        showRegisterFragment();
    }

    @Override
    public void onLoginButtonClicked() {
        Log.v(TAG, "login activity -> showing login fragment...");
        showLoginFragment();
    }
}
