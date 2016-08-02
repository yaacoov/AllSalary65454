package com.example.user.allsalary5.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.allsalary5.MainActivity.MainActivity;
import com.example.user.allsalary5.R;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements LoginListener,LoginCreateListener {

    private Firebase myFirebaseRef;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_main);

        Firebase.setAndroidContext(this);


        //firebase creator
        myFirebaseRef = new Firebase(Constants.url);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);




        //show fragment Login

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentFragment, new LoginFragment())
                .commit();




    }


    @Override
    public void tryLogin(String username, String password) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

        //TODO: send to Firebase username and password
        myFirebaseRef.authWithPassword(username, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);



            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
                //TODO: show error
            }
        });
    }

    @Override
    public void moveToCreateFragment() {



        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentFragment, new LoginCreateFragment())
                .commit();

    }










    @Override
    public void createAccount(String username, String password) {
        myFirebaseRef.createUser(username, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error
            }
        });
    }

    @Override
    public void moveToLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentFragment, new LoginFragment())
                .commit();

    }

    public FirebaseAnalytics getmFirebaseAnalytics() {
        return mFirebaseAnalytics;
    }

    public void setmFirebaseAnalytics(FirebaseAnalytics mFirebaseAnalytics) {
        this.mFirebaseAnalytics = mFirebaseAnalytics;
    }
}
