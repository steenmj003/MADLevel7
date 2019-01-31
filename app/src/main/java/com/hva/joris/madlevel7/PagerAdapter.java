package com.hva.joris.madlevel7;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MainActivity.recipes.size();
    }
}
