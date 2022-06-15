package com.example.diplomaproject.Donation;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList;


    public CustomPagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);

        this.fragmentList=fragmentList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }



}