package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.graphics.Color;


public class PasswordChecker implements CheckField{

    public int points;
    public boolean checkLength;
    public boolean checkPassword;

    public PasswordChecker(Context context) {
    }

    public int getRating(){
        return points;
    }

    public int setStarColor(int rating){

        int starColor;

        switch (rating) {
            case 1: starColor = Color.RED;
                break;
            case 2: starColor = Color.RED;
                break;
            case 3: starColor = Color.YELLOW;
                break;
            case 4: starColor = Color.YELLOW;
                break;
            case 5: starColor = Color.GREEN;
                break;
            default: starColor = Color.WHITE; //If the password are lower than one star.
                break;
        }

        return starColor;
    }

    @Override
    public boolean checkField(String password) {

        //Get password length
        int length = password.length();

        //A counter, add a point for every security level.
        points = 0;

        //LowerCase too see if the password changes.
        String low = password.toLowerCase();
        String high = password.toUpperCase();

        //Create regex to compare with the password
        String numRegex   = ".*[0-9].*";
        String specialRegex = ".*[:;!@#$%&*()_+=|<>¤/´`?{}\\[\\]~-].*";

        System.out.println("LENGTH " + length);

        // 1. More than 8 characters
        if(length>8){

            checkLength = true;

            //System.out.println("Adding one point... more than 8 letters ");
            points++;

            // 2. More than 12 characters
            if(length>12){
                // System.out.println("Adding one point... more than 12 letters");
                points++;
            }
        }

        // 3. Big and small letters
        if(password != low){
            if(password != high){
                // System.out.println("Adding one point... contains big and small letters");
                points++;
            }
        }

        // 4. Contains numbers?
        if (password.matches(numRegex)) {
            //  System.out.println("Adding one point... contains numbers ");
            points++;
        }

        // 5. Special characters
        if(password.matches(specialRegex)){
            // System.out.println("Adding one point... contains special characters ");
            points++;
        }

        if(points>2 && checkLength){
            checkPassword = true;
            System.out.println("CHECK PASSWORD " +  checkPassword);

            return checkPassword;
        }
        else{
            checkPassword = false;
            System.out.println("CHECK PASSWORD " +  checkPassword);

            return checkPassword;
        }
    }
}
