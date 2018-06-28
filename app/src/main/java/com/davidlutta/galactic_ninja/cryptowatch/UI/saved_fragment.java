package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.FireBaseViewHolder;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class saved_fragment extends Fragment {
    @Bind(R.id.recyclerView2 )
    RecyclerView mRecyclerView;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter mFirebaseRecyclerAdapter;


    public saved_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_fragment, container, false);
        ButterKnife.bind(this,view);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COIN);
        setUpFirebaseAdapter();
        return view;
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
        mFirebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<Results, FireBaseViewHolder>
                (options) {
            @NonNull
            @Override
            public FireBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.style_card,parent,false);
                return new FireBaseViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FireBaseViewHolder holder, int position, @NonNull Results model) {
                holder.bindCoins(model);

            }

        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseRecyclerAdapter);
    }

    @Override
    public void onStop(){
        super.onStop();
        mFirebaseRecyclerAdapter.stopListening();
    }

}
