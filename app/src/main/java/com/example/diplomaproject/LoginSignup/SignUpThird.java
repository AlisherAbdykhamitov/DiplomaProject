package com.example.diplomaproject.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.example.diplomaproject.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUpThird extends AppCompatActivity {

    ScrollView scrollView;
    TextInputLayout phoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_third);

        scrollView = findViewById(R.id.signup_third_scroll_view);
        phoneNumber = findViewById(R.id.signup_phone_number);
    }

    public void callVerifyScreen(View view){

//        //Check Internet Connection
//        CheckInternet checkInternet = new CheckInternet();
//        if (!checkInternet.isConnected(this)) {
//            showCustomDialog();
//            return;
//        }

        //if(!validatePhoneNumber()){
          //  return;
        //}

        //get all data from registration
        final String _fullName = getIntent().getStringExtra("fullName");
        final String _email = getIntent().getStringExtra("email");
        final String _username = getIntent().getStringExtra("username");
        final String _password = getIntent().getStringExtra("password");
        final String _date = getIntent().getStringExtra("date");
        final String _gender = getIntent().getStringExtra("gender");



        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim(); //Get Phone Number
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }

        String _phoneN = "+" + "7" + _getUserEnteredPhoneNumber;




        Intent intent = new Intent(getApplicationContext(),VerifyScreen.class);

        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _username);
        intent.putExtra("password", _password);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        intent.putExtra("phoneN", _phoneN);



        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(scrollView, "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpThird.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}