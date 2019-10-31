package com.asslan.jumana.jumanataskmanger.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.asslan.jumana.jumanataskmanger.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MyfragmentsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    //
    private  AllTasksFragment allTasksFragment;
    private HistoryFragment historyFragment;
    private RemoveFragment removeFragment;

    public MyfragmentsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        //2
        allTasksFragment=new AllTasksFragment();
        historyFragment=new HistoryFragment();
        removeFragment=new RemoveFragment();
    }

    /**
     *
     * @param position rakam al tab
     * @return
     */

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //3
        if (position==0)
            return allTasksFragment;
        if (position==1)
            return historyFragment;
        if (position==2)
            return removeFragment;
        return null;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}