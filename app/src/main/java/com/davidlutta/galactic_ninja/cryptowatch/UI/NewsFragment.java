package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.NewsFeedArrayAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.Services.NewsApiService;
import com.davidlutta.galactic_ninja.cryptowatch.models.Articles;

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
public class NewsFragment extends Fragment {
    @Bind(R.id.newsRecyclerView) RecyclerView mRecyclerView;
    public ArrayList<Articles> mArticles = new ArrayList<>();
    private NewsFeedArrayAdapter mNewsFeedArrayAdapter;

    public static NewsFragment newInstance(){
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this,root);
        getArticles();
        return root;
    }

    private void getArticles(){
        final NewsApiService service = new NewsApiService();
        service.loadArticles(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mArticles = service.processArticles(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mNewsFeedArrayAdapter = new NewsFeedArrayAdapter(getContext(),mArticles);
                        mRecyclerView.setAdapter(mNewsFeedArrayAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }

}
