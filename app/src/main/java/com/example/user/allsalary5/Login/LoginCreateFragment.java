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
public class LoginCreateFragment extends Fragment {
    private LoginCreateListener LoginCreateListener;

    protected EditText usernameEditText;
    protected EditText passwordEditText;
    protected Button CreateButton;
    protected String username;
    protected String password;
    protected Button moveToLoginfragmentButton;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            LoginCreateListener = (LoginCreateListener) context;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LoginCreateListener = null;
    }


    public LoginCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_login_create, container, false);

        intView(view);









        return view;
    }

    private void intView(View view) {
        usernameEditText = (EditText)view.findViewById(R.id.login_username);
        passwordEditText = (EditText)view.findViewById(R.id.login_password);
        CreateButton = (Button)view.findViewById(R.id.Create_button);
        moveToLoginfragmentButton=(Button)view.findViewById(R.id.move_to_Login_fragment_button);

        moveToLoginfragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginCreateListener.moveToLoginFragment();
            }
        });


        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });


    }

    private void createAccount() {
        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        LoginCreateListener.createAccount( username,password);

    }



    }

