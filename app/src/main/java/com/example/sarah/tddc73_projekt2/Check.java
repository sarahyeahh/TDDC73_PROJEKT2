package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.widget.LinearLayout;

public class Check extends LinearLayout{

    //Listeners
    TheListener listener;

    //Booleans
    boolean textCheck;
    boolean passwordCheck;
    boolean mailCheck;

    public Check(Context context) {
        super(context);

    }

    public void checkAndCall() {

        System.out.println("-------------------------------");
        //System.out.println( "Text checker " +  textCheck);
        //System.out.println( "Mail checker " +  mailCheck);
        //System.out.println( "Password checker " +  passwordCheck);
        //System.out.println( "Listener " + listener);

        System.out.println("Text checker: " +  textCheck +  " , Mail checker: " +  mailCheck + " , Password checker: " +  passwordCheck);

        if(textCheck && mailCheck && passwordCheck){

            if (listener != null){
                //canCreate() is called which enables the "Create account"-button.
                listener.canCreate();
            }
            else{
                //System.out.println("True, Did not work.");
            }
        }
        else{

            if (listener != null){
                listener.canNotCreate();
            }
            else{
                //System.out.println("False, Did not work. ");
            }
        }
    }

    public void setOnPandClickListener(TheListener listener) {
        this.listener = listener;
    }

    public void userReceive(boolean theUser){
        textCheck = theUser;
    }

    public void mailReceive(boolean theMail) {
        mailCheck = theMail;
    }

    public void passwordReceive(boolean thePassword) {
        passwordCheck = thePassword;
    }
}
