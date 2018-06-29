package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.FireBaseViewHolder;
import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.FirebaseResultListAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.Constants;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedCoinsActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView2) RecyclerView mRecyclerView;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter mFirebaseRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_coins);

        ButterKnife.bind(this);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COIN);
        setUpFirebaseAdapter();

    }
    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_COIN)
                .child(userId);
        FirebaseRecyclerOptions<Results> options = new FirebaseRecyclerOptions.Builder<Results>()
                .setQuery(query, Results.class)
                .build();
        mFirebaseRecyclerAdapter = new FirebaseResultListAdapter(options);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseRecyclerAdapter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mFirebaseRecyclerAdapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseRecyclerAdapter.startListening();
    }
}
