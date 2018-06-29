package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters.CurrencyPageAdapter;
import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class
CurrencyDetailsActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private CurrencyPageAdapter mCurrencyPageAdapter;
    ArrayList<Results> mResults = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_details);
        ButterKnife.bind(this);

        mResults = Parcels.unwrap(getIntent().getParcelableExtra("results"));
        int startingPosition = getIntent().getIntExtra("position",0);

        mCurrencyPageAdapter = new CurrencyPageAdapter(getSupportFragmentManager(),mResults);
        mViewPager.setAdapter(mCurrencyPageAdapter);
        mViewPager.setCurrentItem(startingPosition);
    }
}
