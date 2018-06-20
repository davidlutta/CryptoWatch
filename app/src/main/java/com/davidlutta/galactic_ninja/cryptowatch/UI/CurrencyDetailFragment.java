package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyDetailFragment extends Fragment {
    @Bind(R.id.CurrencyNameTextView) TextView mCurrencyName;
    @Bind(R.id.rankTextView) TextView mRank;
    @Bind(R.id.priceTextView) TextView mPrice;
    @Bind(R.id.MaximumSupTextView) TextView mMaximumSup;
    @Bind(R.id.CirculatingSupTextView) TextView mCirculatingSup;
    @Bind(R.id.MarkCapTextView) TextView mMarkCap;
    @Bind(R.id.percDayTextView) TextView mPercDay;
    @Bind(R.id.percWeekTextView) TextView mPercWeek;
    @Bind(R.id.saveCurrencyButton) Button mSaveCurrency;
    @Bind(R.id.symbol) ImageView mSymbol;

    private Results mResults;

    public CurrencyDetailFragment() {
        // Required empty public constructor


    }

    public static CurrencyDetailFragment newInstace(Results results){
        CurrencyDetailFragment currencyDetailFragment = new CurrencyDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("results", Parcels.wrap(results));
        currencyDetailFragment.setArguments(args);
        return currencyDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mResults = Parcels.unwrap(getArguments().getParcelable("results"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency_detail, container, false);
        ButterKnife.bind(this, view);

        mCurrencyName.setText(mResults.getName());
        mRank.setText("Rank: "+mResults.getRank());
        mPrice.setText("Price: $"+mResults.getQuotes().getUSD().getPrice());
        mMaximumSup.setText("Maximum Supply: "+mResults.getMaxSupply());
        mCirculatingSup.setText("Circulating Supply: "+mResults.getCirculatingSupply());
        mMarkCap.setText("Market Supply: "+mResults.getQuotes().getUSD().getMarketCap());
        mPercDay.setText("Percentage Change Every 24 hours: "+mResults.getQuotes().getUSD().getPercentChange24h()+"%");
        mPercWeek.setText("Percentage Change Every Week: "+mResults.getQuotes().getUSD().getPercentChange7d()+"%");
        return view;

    }

}
