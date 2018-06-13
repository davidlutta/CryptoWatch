package com.davidlutta.galactic_ninja.cryptowatch;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ResultArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCryptoCurrencies;

    public ResultArrayAdapter(Context mContext, int resource, String[] mCryptoCurrencies){
        super(mContext,resource);
        this.mContext = mContext;
        this.mCryptoCurrencies = mCryptoCurrencies;
    }

    @Override
    public Object getItem(int position) {
        String currency = mCryptoCurrencies[position];
        return String.format("We %s", currency);
    }

    @Override
    public int getCount() {
        return mCryptoCurrencies.length;
    }
}
