package com.foodkrane.driver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.foodkrane.driver.fragments.HomeFragment;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment f=new HomeFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.contenthome, f);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.profile) {
            startActivity(new Intent(Home.this , Profile.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment f=null;

        switch (id) {
            case R.id.dashboard:
                Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.ongoing:
                Toast.makeText(this, "Ongoing Orders", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.orderlist:
                Toast.makeText(this, "Order List", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.delivered:
                Toast.makeText(this, "Delivered", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.pending:
                Toast.makeText(this, "Pending", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.rejected:
                Toast.makeText(this, "Rejected", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.payment:
                Toast.makeText(this, "Payment", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.paytmqr:
                Toast.makeText(this, "Paytm QR code", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.bugreport:
                Toast.makeText(this, "Bug Report", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            case R.id.contactus:
                Toast.makeText(this, "Contact Us 24*7", Toast.LENGTH_SHORT).show();
                f = new HomeFragment();
                break;
            default:

                break;
        }

        if (f != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contenthome, f);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
