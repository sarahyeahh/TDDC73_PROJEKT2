package com.example.sarah.tddc73_projekt2;

import android.content.Context;


public class TextChecker implements CheckField {

    public boolean checkUser;

    public TextChecker(Context context) {
    }

    @Override
    public boolean checkField(String fieldText) {
        if(fieldText.matches("")){
            checkUser = false;
            System.out.println("User FALSE");
        }
        else{
            //If user field is filled correctly, set true.
            checkUser = true;
            System.out.println("User TRUE");
        }

        return checkUser;
    }

}
