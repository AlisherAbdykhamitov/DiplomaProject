package com.example.diplomaproject.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diplomaproject.R;

import java.util.Calendar;

public class SignUpSecond extends AppCompatActivity {

    ImageView backBtn;
    Button next, login;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_second);

        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.sign_next_btn);
        login = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_text);
        radioGroup = findViewById(R.id.sigup_radio_group);
        datePicker = findViewById(R.id.age_picker);
    }


    public void callThirdNextSignupScreen(View view){
//        if(!validateAge() | !validateGender()){
//            return;
//        }
//
//        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
//        String _age = radioButton.getText().toString();

        Intent intent = new Intent(getApplicationContext(), SignUpThird.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpSecond.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    private boolean validateGender(){
        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Select Ganede", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private boolean validateAge(){
       int year = Calendar.getInstance().get(Calendar.YEAR);
       int userAge = datePicker.getYear();
       int isAgeValid = year - userAge;

       if(isAgeValid < 14){
           Toast.makeText(this, "not apply", Toast.LENGTH_SHORT).show();
           return false;
       }
       else
           return true;
    }
}