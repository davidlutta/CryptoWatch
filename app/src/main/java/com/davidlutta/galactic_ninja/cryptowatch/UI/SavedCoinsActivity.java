package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davidlutta.galactic_ninja.cryptowatch.Constants;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SavedCoinsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_coins);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid =user.getUid();

        mResult = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_COIN)
                .child(uid);
        setUpFirebaseAdapter();
    }
}
