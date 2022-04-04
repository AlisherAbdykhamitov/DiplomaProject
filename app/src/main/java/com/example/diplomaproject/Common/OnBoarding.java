package com.example.diplomaproject.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.diplomaproject.Adapter.SliderAdapter;
import com.example.diplomaproject.R;
import com.example.diplomaproject.User.UserDashboard;


public class OnBoarding extends AppCompatActivity {

    //Variables
    ViewPager viewPager;
    LinearLayout dotsLayout;
    TextView[] dots;
    Button btn;
    Animation animation;
    int curruntPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        btn = findViewById(R.id.get_started_btn);

        //call adapter
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter((sliderAdapter));

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }



    public void skip(View view){
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(curruntPosition + 1);
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
            curruntPosition = position;
            if (position == 0) {
                btn.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                btn.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                btn.setVisibility(View.INVISIBLE);
            }
            else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_animation);
                btn.setAnimation(animation);
                btn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}