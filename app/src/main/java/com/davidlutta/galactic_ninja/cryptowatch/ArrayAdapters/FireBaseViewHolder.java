package com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.Constants;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.UI.CurrencyDetailsActivity;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FireBaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FireBaseViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCoins(Results results){
        TextView nameTextView = (TextView) mView.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) mView.findViewById(R.id.priceTextView);
        TextView rankTextView = (TextView) mView.findViewById(R.id.rankTextView);

        nameTextView.setText(results.getName());
        priceTextView.setText("Price: $ "+results.getQuotes().getUSD().getPrice().toString());
        rankTextView.setText("Rank: "+results.getRank());
}

        @Override
        public void onClick(View view){
            final ArrayList<Results> results = new ArrayList<>();
            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COIN);
            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        results.add(snapshot.getValue(Results.class));

                    }
                    int itemPostion = getLayoutPosition();
                    Intent intent = new Intent(mContext, CurrencyDetailsActivity.class);
                    intent.putExtra("position", itemPostion + "");
                    intent.putExtra("results", Parcels.wrap(results));
                    mContext.startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            }
}