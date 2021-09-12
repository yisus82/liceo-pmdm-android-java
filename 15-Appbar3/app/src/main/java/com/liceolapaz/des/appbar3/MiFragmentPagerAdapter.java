package com.liceolapaz.des.appbar3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiFragmentPagerAdapter extends FragmentStateAdapter {
    final int PAGE_COUNT = 6;
    private String tabTitles[] =
            new String[]{"Tab Uno", "Tab Dos", "Tab Tres", "Tab Cuatro", "Tab Cinco", "Tab Seis"};

    public MiFragmentPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    public String[] getTabTitles() {
        return tabTitles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment f = null;

        switch (position) {
            case 0:
            case 2:
            case 4:
                f = Fragment1.newInstance();
                break;
            case 1:
            case 3:
            case 5:
            default:
                f = Fragment2.newInstance();
                break;
        }

        return f;
    }

    @Override
    public int getItemCount() {
        return PAGE_COUNT;
    }
}
