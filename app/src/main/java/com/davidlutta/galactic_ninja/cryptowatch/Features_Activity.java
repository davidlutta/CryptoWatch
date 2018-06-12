package com.davidlutta.galactic_ninja.cryptowatch;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Features_Activity extends AppCompatActivity {
    @Bind(R.id.listView)
    ListView mlistView;
    @Bind(R.id.featuresTextView)
    TextView mFeaturesTextView;
    private String[] features = {"find the latest prices of CryptoCurrencies","find out the market capital of CryptoCurrencies"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_);

        ButterKnife.bind(this);
        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mFeaturesTextView.setTypeface(cool);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        mlistView.setAdapter(adapter);
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String feature = ((TextView)view).getText().toString();
                Toast.makeText(Features_Activity.this, feature,Toast.LENGTH_LONG).show();
            }
        });

    }
}
