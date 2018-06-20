package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.FeedArrayAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.Services.coinMarketService;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import java.io.IOException;
import java.util.ArrayList;


import okhttp3.Call;
import okhttp3.Callback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;

public class FeedActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    public ArrayList<Results> mResults = new ArrayList<>();
    private FeedArrayAdapter mFeedArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);

        getFeed();
    }
    private void getFeed(){
        final coinMarketService service = new coinMarketService();
        service.loadResults(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mResults = service.processResults(response);
                FeedActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mFeedArrayAdapter = new FeedArrayAdapter(getApplicationContext(), mResults);
                        mRecyclerView.setAdapter(mFeedArrayAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FeedActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });

    }
}
