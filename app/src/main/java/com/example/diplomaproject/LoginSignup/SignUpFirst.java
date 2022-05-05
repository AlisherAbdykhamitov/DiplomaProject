package com.example.diplomaproject.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diplomaproject.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFirst extends AppCompatActivity {

    Button next, login;
    ImageView backBtn;
    TextView titleText;

    //
    TextInputLayout fullName, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //for anim
        backBtn = findViewById(R.id.signup_back_button_first);
        next = findViewById(R.id.sign_next_btn_first);
        login = findViewById(R.id.sign_login_btn_first);
        titleText = findViewById(R.id.signup_title_text);


        //for data
        fullName = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

    }

    public void callNextSignupScreen(View view) {

//        if(!valFullName()| valUsername() | !valEmail() | !valPassword()){
//            return;
//        }

        Intent intent = new Intent(getApplicationContext(), SignUpSecond.class);

        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUpFirst.this, pairs);
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }

    }
//
//    public void loginFromSignUp(View view){
//        startActivity(new Intent(getApplicationContext(),Login.class));
//        finish();
//    }

//    private boolean valFullName(){
//        String val = fullName.getEditText().getText().toString().trim();
//
//        if(val.isEmpty()){
//            fullName.setError("Can not be empty");
//            return false;
//        }
//        else{
//            fullName.setError(null);
//            fullName.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean valUsername(){
//        String val = username.getEditText().getText().toString().trim();
//        String chekspace = "\\A\\w{1,20}\\z";
//
//        if(val.isEmpty()){
//            username.setError("Can not be empty");
//            return false;
//        }else if(val.length()>20){
//            username.setError("Is to large");
//            return false;
//        }
//        else if(!val.matches(chekspace)){
//            username.setError("No white spaces");
//            return false;
//        }
//        else{
//            username.setError(null);
//            username.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean valEmail(){
//        String val = email.getEditText().getText().toString().trim();
//        String chekEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//        if(val.isEmpty()){
//            email.setError("Can not be empty");
//            return false;
//        }
//        else if(!val.matches(chekEmail)){
//            email.setError("Invalid Email");
//            return false;
//        }
//        else{
//            email.setError(null);
//            email.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean valPassword(){
//        String val = password.getEditText().getText().toString().trim();
//        String chekPassword = "";
//
//        if(val.isEmpty()){
//            password.setError("Can not be empty");
//            return false;
//        }
//        else if(!val.matches(chekPassword)){
//            password.setError("Invalid Password");
//            return false;
//        }
//        else{
//            password.setError(null);
//            password.setErrorEnabled(false);
//            return true;
//        }
//    }
}