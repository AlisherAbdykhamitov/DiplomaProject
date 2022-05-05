package com.example.diplomaproject.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.chaos.view.PinView;
import com.example.diplomaproject.R;

public class VerifyScreen extends AppCompatActivity {


    PinView pinView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verify_screen);

        pinView = findViewById(R.id.verify_code);

        String _phoneN = getIntent().getStringExtra("phoneN");
        
        sendVerificationCodeToUser();
    }

    private void sendVerificationCodeToUser() {
    }


    public void callNextScreenFromVerification(View view){

    }
}