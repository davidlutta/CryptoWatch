package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Search_Activity extends AppCompatActivity {
    @Bind(R.id.searchTextView) TextView mSearchTextView;
    @Bind(R.id.searchEditText) EditText mSearchEditText;
    @Bind(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        ButterKnife.bind(this);
        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mSearchButton.setTypeface(cool);
        mSearchEditText.setTypeface(cool);
        mSearchTextView.setTypeface(cool);
        
        String currency = mSearchEditText.getText().toString();
        Intent intent =new Intent(Search_Activity.this,Results_Activity.class);
        intent.putExtra("currency",currency);
        startActivity(intent);
    }
}
