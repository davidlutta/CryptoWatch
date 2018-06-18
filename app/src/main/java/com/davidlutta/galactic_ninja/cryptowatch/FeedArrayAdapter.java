package com.davidlutta.galactic_ninja.cryptowatch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FeedArrayAdapter extends RecyclerView.Adapter<FeedArrayAdapter.FeedViewHolder> {
    private ArrayList<Results> mResults = new ArrayList<>();
    private Context mContext;

    public FeedArrayAdapter(Context context, ArrayList<Results> results){
        mContext = context;
        mResults = results;
    }

    @Override
    public FeedArrayAdapter.FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_card, parent, false);
        FeedViewHolder viewHolder = new FeedViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(FeedArrayAdapter.FeedViewHolder holder, int position) {
        holder.bindResults(mResults.get(position));
    }
    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameTextView)TextView mCurrencyName;

        public FeedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindResults(Results currencyModel) {
            mCurrencyName.setText(currencyModel.getName());
            Log.d("recyclerview", "bindResults: " + currencyModel.getName());
        }
    }
}
