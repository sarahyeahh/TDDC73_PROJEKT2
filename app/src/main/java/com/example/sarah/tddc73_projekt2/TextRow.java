package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TextRow extends LinearLayout implements AccountRow{

    LinearLayout layout;
    private EditText edit;
    public boolean theUser;

    Check check;

    public TextRow(Context context) {
        super(context);
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    //Add text checker.
    TextChecker textChecker;
    public void setTextChecker(TextChecker textChecker) {
        this.textChecker = textChecker;
    }

    //Constructor
    public TextRow(Context context, String inputText) {
        super(context);

        check = new Check(context);
        setCheck(check);

        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        //Imlement text checker
        textChecker = new TextChecker(context);
        setTextChecker(textChecker);

        TextView text = new TextView(context);
        text.setText(inputText);
        edit = new EditText(context);
        edit.setSingleLine(true);

        //Add text fields.
        layout.addView(text);
        layout.addView(edit);
        layout.setLayoutParams(params);
        this.addView(layout);
        
        addListeners(context);
    }

    private void addListeners(final Context context) {

        //Add TextWatcher to user field
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //Get the current string in EditText
                String userName = edit.getText().toString();
                //Check if EditText is filled correctly
                theUser = textChecker.checkField(userName);
                System.out.println( "THE USER AFTER TEXT" + theUser);

                //Set background color to red until it is correct
                edit.setBackgroundColor(0x80ff0000); //Opaque red

                if(theUser){
                    edit.setBackgroundColor(0x8000ff00); //Opaque green
                }
                else{
                    Toast.makeText(context, "There has to be a Username", Toast.LENGTH_SHORT).show();
                }
                send();
            }
        });
    }

    public void send(){
        check.userReceive(theUser);
        check.checkAndCall();
    }

    public TextRow getData(){
        return this;
    }

}
