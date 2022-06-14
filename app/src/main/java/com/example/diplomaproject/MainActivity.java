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
import com.example.diplomaproject.User.UserDashboard;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    //Variables
    ImageView backgroundImage;
    TextView textBackgroundImage;

    //Animations
    Animation sideAnimation, bottomAnimation;

    SharedPreferences onBoardingScreen;

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

        new Handler().postDelayed(new Runnable()  {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent1 = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent1);
                    finish();
                }
               else{
                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_TIMER);

    }





}