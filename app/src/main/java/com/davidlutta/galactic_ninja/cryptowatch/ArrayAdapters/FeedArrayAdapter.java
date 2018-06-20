package com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.davidlutta.galactic_ninja.cryptowatch.R;
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
        @Bind(R.id.symbol) ImageView mSymbol;
        @Bind(R.id.priceTextView) TextView mPrice;
        @Bind(R.id.rankTextView) TextView mRank;
        @Bind(R.id.changeTextView) TextView mChange;
        public FeedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindResults(Results currencyModel) {
            String first = currencyModel.getSymbol();

            ColorGenerator colorGenerator = ColorGenerator.MATERIAL;
            int color = colorGenerator.getRandomColor();

            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(first, color);
            mSymbol.setImageDrawable(drawable);
            mCurrencyName.setText(currencyModel.getName());
            mRank.setText("Rank: "+ currencyModel.getRank());
            mPrice.setText("Price: $    "+currencyModel.getQuotes().getUSD().getPrice());

        }
    }
}
