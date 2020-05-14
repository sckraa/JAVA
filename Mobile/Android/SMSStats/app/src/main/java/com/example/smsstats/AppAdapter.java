package com.example.smsstats;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AppAdapter extends FragmentPagerAdapter {

    private Context context;
    int countTabs;

    public AppAdapter(Context context, FragmentManager fm, int countTabs) {
        super(fm);
        this.context = context;
        this.countTabs = countTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;
            case 1:
                SmsFragment smsFragment = new SmsFragment();
                return smsFragment;
            case 2:
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if( position == 0 ) {
            return "Contacts";
        } else if ( position == 1 ) {
            return "SMS";
        } else if ( position == 2 ) {
            return "Settings";
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return countTabs;
    }


}
