package com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.UI.CurrencyDetailsActivity;
import com.davidlutta.galactic_ninja.cryptowatch.models.Articles;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.net.URL;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsFeedArrayAdapter extends RecyclerView.Adapter<NewsFeedArrayAdapter.NewsViewHolder>{
    private ArrayList<Articles> mArticles = new ArrayList<>();
    private Context mContext;

    public NewsFeedArrayAdapter(Context context, ArrayList<Articles> results){
        mContext = context;
        mArticles = results;
    }

    @Override
    public NewsFeedArrayAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        NewsFeedArrayAdapter.NewsViewHolder viewHolder1 = new NewsFeedArrayAdapter.NewsViewHolder(view);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(NewsFeedArrayAdapter.NewsViewHolder holder, int position){
        holder.bindResults(mArticles.get(position));
    }
    @Override
    public int getItemCount(){
        return mArticles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.image) ImageView mImage;
        @Bind(R.id.titleTextView) TextView mArticleName;
        @Bind(R.id.descriptionTextView) TextView mDescription;
        public NewsViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
//            int itemPosition = getLayoutPosition();
//            //Change to NewsDetails Activity
//            Intent intent = new Intent(mContext, CurrencyDetailsActivity.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("articles", Parcels.wrap(mArticles));
//            mContext.startActivity(intent);
        }

        public void bindResults(Articles articlesModel){

            Picasso.with(mContext).load(articlesModel.getUrlToImage()).fit().into(mImage);
            mArticleName.setText(articlesModel.getTitle());
            mDescription.setText(articlesModel.getDescription());
        }
    }
}
