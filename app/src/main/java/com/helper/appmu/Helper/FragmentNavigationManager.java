package com.helper.appmu.Helper;

import androidx.fragment.app.FragmentManager;

import com.helper.appmu.Interface.NavigationManager;
import com.helper.appmu.MainActivity;

public class FragmentNavigationManager implements NavigationManager {
    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragmentManager;
    private MainActivity mainActivity;

    public static FragmentNavigationManager getmInstance(MainActivity mainActivity)
    {
        if (mInstance == null)
            mInstance = new FragmentNavigationManager();
        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity) {
        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }


    @Override
    public void showFragment(String title) {

    }
}
