package io.mechatron.thesis.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.mechatron.thesis.fragments.CafesFragment;
import io.mechatron.thesis.fragments.ReservationsFragment;

/**
 * Created by migz on 1/2/17.
 */

public class MyTabsAdapter extends FragmentPagerAdapter {

    public static final String[] TABS = {"Cafes", "Reservations"};

    public MyTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CafesFragment();
        }

        return new ReservationsFragment();
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABS[position];
    }
}
