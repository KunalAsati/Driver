package com.foodkrane.driver;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(isOnline()){
            startActivity(new Intent(SplashActivity.this , NoInternet.class));
            finish();

        }else {
            Thread background = new Thread() {
                public void run() {

                    try {
                        // Thread will sleep for 5 seconds
                        sleep(2 * 1000);


                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if (user == null) {
                            // user auth state is changed - user is null
                            // launch login activity
                            startActivity(new Intent(SplashActivity.this, Login.class));
                            finish();
                        } else {

                            Intent intent = new Intent(SplashActivity.this, Home.class);
                            startActivity(intent);
                        }
                        // After 5 seconds redirect to another intent


                        //Remove activity
                        finish();

                    } catch (Exception e) {

                    }
                }
            };


            // start thread
            background.start();

        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            return false;
        } else {
            // not connected to the internet
            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isOnline()){
            startActivity(new Intent(SplashActivity.this , NoInternet.class));
            finish();
        }
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
