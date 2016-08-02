package com.example.user.allsalary5.Login;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.allsalary5.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private LoginListener loginListener;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button moveToCreateFragmentButton;

    private String username;
    private String password;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            loginListener = (LoginListener) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loginListener = null;
    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        initViews(v);


        return v;
    }

    private void initViews(View v) {
        usernameEditText = (EditText)v.findViewById(R.id.login_username);
        passwordEditText = (EditText)v.findViewById(R.id.login_password);
        loginButton = (Button)v.findViewById(R.id.login_button);
        moveToCreateFragmentButton=(Button)v.findViewById(R.id.move_to_create_fragment);

        moveToCreateFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToCreateFragment();


            }
        });




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryLogin();
            }
        });
    }

    private void moveToCreateFragment() {
        loginListener.moveToCreateFragment();

    }

    private void tryLogin() {
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        //TODO: check if user or password is ok
        loginListener.tryLogin(username, password);
    }

}
