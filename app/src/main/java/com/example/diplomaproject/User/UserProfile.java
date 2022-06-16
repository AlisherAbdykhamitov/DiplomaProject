package com.example.diplomaproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diplomaproject.Database.SessionClassManager;
import com.example.diplomaproject.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class UserProfile extends AppCompatActivity {

    SessionClassManager sessionClassManager;

    TextInputLayout fullNameUser, email, phoneN, usernameUser;
    TextView fullNameLabel, usernameLabel;
//    String _FULLNAME, _USERNAME, _EMAIL, _PHONENOMBER, _PASSWORD, _GENDER, _DATE;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        //databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        fullNameLabel = findViewById(R.id.full_name);
        usernameLabel = findViewById(R.id.username_id_profile_main);
        sessionClassManager = new SessionClassManager(this);
        HashMap<String, String> userDetails = sessionClassManager.getUserDetailFromSession();


        fullNameUser = findViewById(R.id.full_name_profile);
        usernameUser = findViewById(R.id.username_id_profile);
        email = findViewById(R.id.email_profile);
        phoneN = findViewById(R.id.phoneNumber_profile);

        String fullName = userDetails.get(SessionClassManager.KEY_FULLNAME);
        String username = userDetails.get(SessionClassManager.KEY_USERNAME);
        String emailUser = userDetails.get(SessionClassManager.KEY_EMAIL);
        String phoneNUser = userDetails.get(SessionClassManager.KEY_PHONENUMBER);

        fullNameLabel.setText(fullName);
        usernameLabel.setText(username);
        fullNameUser.getEditText().setText(fullName);
        usernameUser.getEditText().setText(username);
        email.getEditText().setText(emailUser);
        phoneN.getEditText().setText(phoneNUser);




        //showAllDataUser();
    }

//    private void showAllDataUser() {
//
//        Intent intent = getIntent();
//        _FULLNAME = intent.getStringExtra("fullName");
//        _USERNAME = intent.getStringExtra("username");
//        _EMAIL = intent.getStringExtra("email");
//        _PHONENOMBER = intent.getStringExtra("phoneN");
//
////        sessionClassManager.createLoginSession(_FULLNAME,_USERNAME,_EMAIL,_PHONENOMBER, _PASSWORD, _DATE, _GENDER);
////        sessionClassManager.getUserDetailFromSession();
//
//
//        fullNameLabel.setText(_FULLNAME);
//        usernameLabel.setText(_USERNAME);
//        fullName.getEditText().setText(_FULLNAME);
//        email.getEditText().setText(_EMAIL);
//        username.getEditText().setText(_USERNAME);
//        phoneN.getEditText().setText(_PHONENOMBER);
//    }

//    public void updateData(){
//        if(isNameChanged() || isPasswordChanged()){
//            Toast.makeText(this, "Data has been changed", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "Data is same", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private boolean isPasswordChanged() {
//        if(!_PHONENOMBER.equals(phoneN.getEditText().getText().toString())){
//            databaseReference.child(_FULLNAME).child("phoneN").setValue(phoneN.getEditText().getText().toString());
//            _PHONENOMBER = phoneN.getEditText().getText().toString();
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    private boolean isNameChanged() {
//        if(!_FULLNAME.equals(fullName.getEditText().getText().toString())){
//            databaseReference.child(_FULLNAME).child("username").setValue(fullName.getEditText().getText().toString());
//            _FULLNAME = fullName.getEditText().getText().toString();
//            return true;
//        }else{
//            return false;
//        }
//    }

    public void goToUserDashBoard(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }

    public void logOutFromUserSession(View view){
        SessionClassManager sessionClassManager = new SessionClassManager(this);
        sessionClassManager.logoutUserFormSession();
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
    }

}