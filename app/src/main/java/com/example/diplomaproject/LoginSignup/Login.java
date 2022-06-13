package com.example.diplomaproject.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.diplomaproject.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    TextInputLayout phoneNumber, password;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        phoneNumber = findViewById(R.id.user_phone_number);
        password = findViewById(R.id.password_one);
        relativeLayout = findViewById(R.id.login_progress_bar);
    }

    public void theUserLoggedIn(View view){


//        if(!isConnected(Login.this)){
//            showCustomDialog();
//        }

        //validate username and password
//        if(!validateFields()){
//            return;
//        }

        relativeLayout.setVisibility(View.VISIBLE);

        //get data
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        String _completePhoneNumber = "+" + "7" + _phoneNumber;


        //Database
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneN").equalTo(_completePhoneNumber);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);

                    String systemPassword = snapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                    if(systemPassword.equals(_password)){
                        password.setError(null);
                        password.setErrorEnabled(false);

                        String _fullname = snapshot.child(_completePhoneNumber).child("fullName").getValue(String.class);
                        String _username = snapshot.child(_completePhoneNumber).child("username").getValue(String.class);
                        String _email = snapshot.child(_completePhoneNumber).child("email").getValue(String.class);
                        String _phoneN = snapshot.child(_completePhoneNumber).child("phoneN").getValue(String.class);
                        String _password = snapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                        String _dateOfBirth = snapshot.child(_completePhoneNumber).child("date").getValue(String.class);
                        String _gender = snapshot.child(_completePhoneNumber).child("gender").getValue(String.class);

                        Toast.makeText(Login.this,
                                _fullname+"\n"+
                                        _email+"\n"+
                                        _username+"\n"+
                                _phoneN+"\n"+
                                _password+"\n"+
                                _dateOfBirth+"\n"+
                                _gender+"\n", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        relativeLayout.setVisibility(View.GONE);
                        Toast.makeText(Login.this, "Password not correct", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    relativeLayout.setVisibility(View.GONE);
                    Toast.makeText(Login.this, "Data not exist", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                relativeLayout.setVisibility(View.GONE);
                Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setMessage("Please connect to the internet")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), StartUpScreen.class));
                    }
                });

    }

//    private boolean isConnected(Login login) {
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) login.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobileConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if((wifi != null && wifi.isConnected())|| (mobileConnection != null && mobileConnection.isConnected())){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }


//    private void validateFields(){
//        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
//        String _password = password.getEditText().getText().toString().trim();
//
//    }
}