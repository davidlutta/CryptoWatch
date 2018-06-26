package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.logOutButton) Button mLogOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.logOutButton:
                logOut();
                break;
        }
    }

    private void logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(ProfileActivity.this, Login_Activity.class);
        startActivity(intent);
    }
}
