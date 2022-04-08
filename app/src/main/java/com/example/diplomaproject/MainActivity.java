package com.example.diplomaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diplomaproject.Common.OnBoarding;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    //Variables
    ImageView backgroundImage;
    TextView textBackgroundImage;

    //Animations
    Animation sideAnimation, bottomAnimation;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        textBackgroundImage = findViewById(R.id.text_background_image);

        //Animations
        sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        bottomAnimation =AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        //set Animations on elements
        backgroundImage.setAnimation(sideAnimation);
        textBackgroundImage.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_TIMER);


    }
}