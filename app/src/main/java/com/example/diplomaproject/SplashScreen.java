package com.example.diplomaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diplomaproject.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    //Variables
    ImageView backgroundImage;
    TextView textBackgroundImage;

    //Animations
    Animation sideAnimation, bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


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
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
            }
        },SPLASH_TIMER);


    }
}