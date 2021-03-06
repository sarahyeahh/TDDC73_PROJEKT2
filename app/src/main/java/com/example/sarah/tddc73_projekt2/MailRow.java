package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MailRow extends LinearLayout implements AccountRow{

    LinearLayout layout;
    EditText mail;
    boolean theMail;

    Check check;
    public void setCheck(Check check) {
        this.check = check;
    }

    MailChecker mailChecker;
    public void setMailChecker(MailChecker mailChecker) {
        this.mailChecker = mailChecker;
    }

    public MailRow(Context context, String inputText) {
        super(context);

        check = new Check(context);
        setCheck(check);

        mailChecker = new MailChecker(context);
        setMailChecker(mailChecker);

        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        //Create a new TextField
        TextView text = new TextView(context);
        text.setText(inputText);

        mail = new EditText(context);
        mail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        mail.setSingleLine(true);

        layout.addView(text);
        layout.addView(mail);
        layout.setLayoutParams(params);
        this.addView(layout);

        addListeners(context);

    }

    private void addListeners(Context context) {

        //Add TextWatcher to mail field
        mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                //Get the current string in EditText
                String mailAdress = mail.getText().toString();
                //Check if EditText is filled correctly
                theMail = mailChecker.checkField(mailAdress);

                //Set background color to red until it is correct
                mail.setBackgroundColor(0x80ff0000); //Opaque red

                if(theMail){
                    mail.setBackgroundColor(0x8000ff00); //Opaque green
                }
                else{
                    //Do nothing?
                }
                //Send to the class Check
                send();
            }
        });

    }

    public void send(){
        check.mailReceive(theMail);
        check.checkAndCall();
    }

    @Override
    public LinearLayout getData() {
        return this;
    }

}
