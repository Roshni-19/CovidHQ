package com.example.covidhq.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.covidhq.AllopathyMedication;
import com.example.covidhq.AyurvedaMedication;
import com.example.covidhq.R;
import com.example.covidhq.SiddhaMedication;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllopathyMedication allopathyMedication = new AllopathyMedication();
                return allopathyMedication;
            case 1:
                SiddhaMedication siddhaMedication = new SiddhaMedication();
                return siddhaMedication;
            case 2:
                AyurvedaMedication ayurvedaMedication = new AyurvedaMedication();
                return ayurvedaMedication;
            default:
                return null;
        }
    }
}