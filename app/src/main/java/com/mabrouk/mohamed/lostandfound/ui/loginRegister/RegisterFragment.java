package com.mabrouk.mohamed.lostandfound.ui.loginRegister;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mabrouk.mohamed.lostandfound.R;


public class RegisterFragment extends Fragment {
    private final static String TAG = RegisterFragment.class.getSimpleName() + "TAG";


    OnLoginButtonClickListener mCallBack;
    View root;
    EditText nameEditText, emailEditText, passwordEditText;
    Button registerButton;
    TextView loginTextView;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_register, container, false);

        nameEditText = (EditText) root.findViewById(R.id.input_name);
        emailEditText = (EditText) root.findViewById(R.id.input_email);
        passwordEditText = (EditText) root.findViewById(R.id.input_password);
        registerButton = (Button) root.findViewById(R.id.register_btn);
        loginTextView = (TextView) root.findViewById(R.id.login_tv);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: validate register form
                validate();
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "login link clicked!");
                mCallBack.onLoginButtonClicked();
            }
        });

        return root;
    }

    public void setOnLoginButtonClickListener(RegisterFragment.OnLoginButtonClickListener listener) {
        mCallBack = listener;
    }

    public interface OnLoginButtonClickListener {
        void onLoginButtonClicked();
    }


    public boolean validate() {
        boolean valid = true;

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (name.isEmpty() || name.length() < 6) {
            nameEditText.setError(getString(R.string.register_form_short_name));
            valid = false;
        } else {
            nameEditText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError(getString(R.string.register_form_email_syntax_error));
            valid = false;
        } else {
            emailEditText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4) {
            passwordEditText.setError(getString(R.string.register_form_short_password_error));
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }


}
