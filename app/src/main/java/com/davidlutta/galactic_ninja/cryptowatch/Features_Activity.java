package com.davidlutta.galactic_ninja.cryptowatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Features_Activity extends AppCompatActivity {
    @Bind(R.id.listView)
    ListView mlistView;
    @Bind(R.id.featuresTextView)
    TextView mFeaturesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_);

        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

    }
}
