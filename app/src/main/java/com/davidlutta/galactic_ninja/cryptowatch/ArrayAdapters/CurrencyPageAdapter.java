package com.davidlutta.galactic_ninja.cryptowatch.ArrayAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.davidlutta.galactic_ninja.cryptowatch.UI.CurrencyDetailFragment;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;

import java.util.ArrayList;

public class CurrencyPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Results> mResults;

    public CurrencyDetailFragment(FragmentManager fm, ArrayList<Results> results){
        super(fm);
        mResults = results;
    }


    @Override
    public Fragment getItem(int position){
        return CurrencyDetailFragment.newInstace(mResults.get(position));
    }
    @Override
    public int getCount() {
        return mResults.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mResults.get(position).getName();
    }
}
