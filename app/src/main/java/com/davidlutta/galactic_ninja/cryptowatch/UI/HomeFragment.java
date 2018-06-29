package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.FeedArrayAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.Services.coinMarketService;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    public ArrayList<Results> mResults = new ArrayList<>();
    private FeedArrayAdapter mFeedArrayAdapter;

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,root);
        getFeed();
        return root;
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mFeedArrayAdapter = new FeedArrayAdapter(getContext(), mResults);
                        mRecyclerView.setAdapter(mFeedArrayAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }


        });

    }

    @Override
    public void onStop() {
        super.onStop();
        coinMarketService.cancelAllRequest();
    }
}
