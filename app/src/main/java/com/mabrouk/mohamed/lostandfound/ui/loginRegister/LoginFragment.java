package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mabrouk.mohamed.lostandfound.R;


public class LoginFragment extends Fragment implements LoginRegisterContract.LoginView {
    private final static String TAG = LoginFragment.class.getSimpleName() + "TAGG";


    OnRegisterButtonClickListener mCallBack;
    View root;
    EditText emailEditText, passwordEditText;
    Button loginButton, facebookButton, googleButton, twitterButton;
    TextView signupTextView, loginErrorTextView;
    ProgressBar loginPb;

    private LoginRegisterContract.LoginPresenter mPresenter;

    private Activity mActivity;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_login, container, false);

        emailEditText = (EditText) root.findViewById(R.id.input_email);
        passwordEditText = (EditText) root.findViewById(R.id.input_password);
        loginButton = (Button) root.findViewById(R.id.login_btn);
        facebookButton = (Button) root.findViewById(R.id.facebook_login_btn);
        googleButton = (Button) root.findViewById(R.id.google_login_btn);
        twitterButton = (Button) root.findViewById(R.id.twitter_login_btn);
        signupTextView = (TextView) root.findViewById(R.id.sign_up_tv);
        loginPb = (ProgressBar) root.findViewById(R.id.login_pb);
        loginErrorTextView = (TextView) root.findViewById(R.id.login_error_tv);

        //init
        mPresenter = new LoginPresenterImpl(this, mActivity);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    mPresenter.onLoginButtonClick(
                            emailEditText.getText().toString(),
                            passwordEditText.getText().toString()
                    );
                }

            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "sign up link clicked!");
                mCallBack.onRegisterButtonClicked();
            }
        });

        return root;
    }

    // communicate with holder activity
    public void setOnRegisterButtonClickListener(OnRegisterButtonClickListener listener) {
        mCallBack = listener;
    }

    @Override
    public void showProgress() {
        loginPb.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        loginPb.setVisibility(View.GONE);
        loginButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void setErrorMsg(String error) {
        if (loginErrorTextView.getVisibility() == View.VISIBLE) {
            loginErrorTextView.setText(error);
        }
    }

    @Override
    public void showErrorMsg() {
        loginErrorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMsg() {
        loginErrorTextView.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        Log.v(TAG, "Navigating to home...");
    }

    public interface OnRegisterButtonClickListener {
        void onRegisterButtonClicked();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public boolean validate() {
        boolean valid = true;

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError(getString(R.string.login_form_email_syntax_error));
            valid = false;
        } else {
            emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
            passwordEditText.setError(getString(R.string.login_form_short_password_error));
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
