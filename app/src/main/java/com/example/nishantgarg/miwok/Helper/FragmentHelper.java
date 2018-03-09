package com.example.nishantgarg.miwok.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nishantgarg.miwok.Fragments.ColorsFragment;
import com.example.nishantgarg.miwok.Fragments.FamilyFragment;
import com.example.nishantgarg.miwok.Fragments.NumbersFragment;
import com.example.nishantgarg.miwok.Fragments.PhrasesFragment;

/**
 * Created by Nishant Garg on 09-03-2018.
 */

public class FragmentHelper extends FragmentPagerAdapter {

    public FragmentHelper(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            default:
                return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}