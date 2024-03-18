package com.example.portfolio;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class IntroPagerAdapter extends FragmentStatePagerAdapter {
    public IntroPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IntroSlider1Fragment();
            case 1:
                return new IntroSlider2Fragment();
            case 2:
                return new IntroSlider3Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Number of intro sliders
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}




