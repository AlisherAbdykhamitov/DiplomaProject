package com.example.diplomaproject.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diplomaproject.Adapter.SliderAdapter;
import com.example.diplomaproject.R;


public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        //hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);

        //call adapter
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter((sliderAdapter));

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i = 0; i <dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}