package com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FirebaseResultListAdapter extends FirebaseRecyclerAdapter<Results, FireBaseViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseResultListAdapter(@NonNull FirebaseRecyclerOptions<Results> options) {
        super(options);
    }
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


}
