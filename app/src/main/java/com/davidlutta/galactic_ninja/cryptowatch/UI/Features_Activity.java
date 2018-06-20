package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Features_Activity extends AppCompatActivity {
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.featuresTextView) TextView mFeaturesTextView;
    @Bind(R.id.nextButton) Button mNextButton;
    private String[] features = {"find the latest prices of CryptoCurrencies","find out the market capital of CryptoCurrencies"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features_);

        ButterKnife.bind(this);
        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mFeaturesTextView.setTypeface(cool);
        mNextButton.setTypeface(cool);
        FeaturesArrayAdapter adapter = new FeaturesArrayAdapter(this, android.R.layout.simple_list_item_1, features);
        mListView.setAdapter(adapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String feature = ((TextView)view).getText().toString();
//                Toast.makeText(Features_Activity.this, feature,Toast.LENGTH_LONG).show();
//            }
//        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Features_Activity.this, FeedActivity.class);
                startActivity(intent);
            }
        });

    }
}
