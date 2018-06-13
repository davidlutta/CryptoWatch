package com.davidlutta.galactic_ninja.cryptowatch;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FeaturesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mFeatures;

    public FeaturesArrayAdapter(Context mContext,int resource, String[] mFeatures){
        super(mContext,resource);
        this.mContext = mContext;
        this.mFeatures = mFeatures;
    }

    @Override
    public Object getItem(int position) {
        String feature = mFeatures[position];
        return String.format("- %s", feature);
    }

    @Override
    public int getCount() {
        return mFeatures.length;
    }
}
