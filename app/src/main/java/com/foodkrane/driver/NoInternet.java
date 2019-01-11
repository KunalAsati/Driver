package com.foodkrane.driver;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class NoInternet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        if(isOnline()){
            startActivity(new Intent(NoInternet.this , SplashActivity.class));
            finish();
        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            return true;
        } else {
            // not connected to the internet
            return false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isOnline()){
            startActivity(new Intent(NoInternet.this , SplashActivity.class));
            finish();
        }
    }
}
