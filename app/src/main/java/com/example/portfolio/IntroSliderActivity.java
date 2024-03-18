package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class IntroSliderActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro_slider);

        viewPager = findViewById(R.id.viewpager);
        BtnNext = findViewById(R.id.BtnNext);

        // Set up ViewPager with the adapter
        IntroPagerAdapter introPagerAdapter = new IntroPagerAdapter();
        viewPager.setAdapter(introPagerAdapter);

        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if this is the last slide
                if (viewPager.getCurrentItem() == introPagerAdapter.getCount() - 1) {
                    // If it is the last slide, start the MainActivity
                    startActivity(new Intent(IntroSliderActivity.this, MainActivity.class));
                    finish(); // Close the intro slider activity
                } else {
                    // Move to the next slide
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
    }

    private class IntroPagerAdapter extends PagerAdapter {

        private int[] layouts = {R.layout.fragment_introslider1, R.layout.fragment_introslider2, R.layout.fragment_introslider3};

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(IntroSliderActivity.this);
            View layout = inflater.inflate(layouts[position], container, false);
            container.addView(layout);
            return layout;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
