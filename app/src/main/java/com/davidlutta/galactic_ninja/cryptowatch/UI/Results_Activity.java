package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.ResultArrayAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Results_Activity extends AppCompatActivity {
    @Bind(R.id.resultTextView) TextView mResultView;
    @Bind(R.id.ResultlistView) ListView mResultListView;
    private String[] cryptoCurrencies = {"bitcoin","Etherium","lightCoin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_);
        ButterKnife.bind(this);
        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mResultView.setTypeface(cool);
        ResultArrayAdapter adapter = new ResultArrayAdapter(this,android.R.layout.simple_list_item_1, cryptoCurrencies);
        mResultListView.setAdapter(adapter);
        mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String feature = ((TextView)view).getText().toString();
                Toast.makeText(Results_Activity.this, feature,Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String currency = intent.getStringExtra("currency");
        mResultView.setText("Search Results for : " + currency);
    }
}