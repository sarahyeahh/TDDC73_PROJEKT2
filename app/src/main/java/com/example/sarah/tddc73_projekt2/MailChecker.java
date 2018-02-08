package com.example.sarah.tddc73_projekt2;


import android.content.Context;

public class MailChecker implements CheckField{

    public boolean checkMail;

    public MailChecker(Context context) {
    }

    @Override
    public boolean checkField(String mail) {
        if(mail.contains("@")){

            if(mail.endsWith(".se") || mail.endsWith(".com") || mail.endsWith(".nu") ){
                checkMail = true;
                System.out.println("Mail TRUE");
            }
            else{
                System.out.println("Mail FALSE");
                checkMail = false;
            }
        }
        return checkMail;
    }
}
