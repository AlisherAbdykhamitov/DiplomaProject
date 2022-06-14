package com.example.diplomaproject.Database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.diplomaproject.User.UserDashboard;
import com.example.diplomaproject.User.UserProfile;

import java.util.HashMap;

public class SessionClassManager {

    //Variables
    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context context;


    private static final String IS_LIGIN = "IsLoggedIn";

    public static final String KEY_FULLNAME = "fullName";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENUMBER = "phoneN";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_DATE = "date";
    public static final String KEY_GENDER = "gender";

    public SessionClassManager(Context _context){
        context = _context;
        userSession = context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);
        editor = userSession.edit();
    }

    public void createLoginSession(String fullName, String username, String email, String phoneN, String password, String date, String gender){

        editor.putBoolean(IS_LIGIN, true);

        editor.putString(KEY_FULLNAME, fullName);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHONENUMBER, phoneN);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_DATE, date);
        editor.putString(KEY_GENDER, gender);

        editor.commit();
    }

    public HashMap<String, String> getUserDetailFromSession(){
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put(KEY_FULLNAME, userSession.getString(KEY_FULLNAME, null));
        userData.put(KEY_USERNAME, userSession.getString(KEY_USERNAME, null));
        userData.put(KEY_EMAIL, userSession.getString(KEY_EMAIL, null));
        userData.put(KEY_PHONENUMBER, userSession.getString(KEY_PHONENUMBER, null));
        userData.put(KEY_PASSWORD, userSession.getString(KEY_PASSWORD, null));
        userData.put(KEY_DATE, userSession.getString(KEY_DATE, null));
        userData.put(KEY_GENDER, userSession.getString(KEY_GENDER, null));

        return userData;

    }

    public boolean checkLoginUser(){
        if(userSession.getBoolean(IS_LIGIN, true)){
            return true;
        }
        else{
            return false;
        }
    }

    public void logoutUserFormSession(){
        editor.clear();
        editor.commit();
    }
}
