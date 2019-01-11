package com.foodkrane.driver;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Transformation;
//import com.steponengineers.eta.Activities.attendance.DailyLogin;
//import com.steponengineers.eta.Activities.attendance.RoundedCornersTransformation;
//import com.steponengineers.eta.Modellclass.UserDetails;
//import com.steponengineers.eta.R;
//import com.steponengineers.eta.authentication.EditProfile;
//import com.steponengineers.eta.authentication.Login;
//import com.steponengineers.eta.authentication.Registration;
//import com.steponengineers.eta.authentication.RegistrationDetails;

public class Profile extends AppCompatActivity {



    TextView email,phone,name;
    Button logout;
    ImageView profiledp;
    private FirebaseAuth mAuth;
    FirebaseUser user;

    ScrollView sc;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth = FirebaseAuth.getInstance();
        user= mAuth.getCurrentUser();
        logout = findViewById(R.id.logoutprofile);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(Profile.this, "Redirecting to login...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Profile.this,Login.class);
                finishAffinity();
                startActivity(intent);
            }
        });

        email =findViewById(R.id.emailprofile);
        phone = findViewById(R.id.phone);
        name = findViewById(R.id.Name);
        profiledp = findViewById(R.id.profiledp);



        name.setText(user.getDisplayName());
        email.setText(user.getEmail());
        phone.setText(user.getPhoneNumber());



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editprof, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.edit:
//                Intent i=new Intent(Profile.this, EditProfile.class);
//                i.putExtra("userDetails", userDetails);
//                startActivity(i);
                Toast.makeText(this, "Edit Profile clicked", Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

}
