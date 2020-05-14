package com.example.tasklist;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public Adapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TaskFragment taskFragment = new TaskFragment();
                return taskFragment;
            case 1:
                AddFragment addFragment = new AddFragment();
                return addFragment;
            case 2:
                CalendarFragment calendarFragment = new CalendarFragment();
                return calendarFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}