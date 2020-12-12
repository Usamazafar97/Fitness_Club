package com.example.fitnessclub;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    //String firstName, String lastName, String date,String gender, String bio

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUserStatus(String status ){ //1 for Admin , 2 for Trainee
        prefs.edit().putString("status", status).commit();
    }

    public String getUserStatus() {
        String status = prefs.getString("status","");
        return status;
    }


    public void setEmail(String email) {
        prefs.edit().putString("email", email).commit();
    }

    public String getEmail() {
        String email = prefs.getString("email","");
        return email;
    }
}
