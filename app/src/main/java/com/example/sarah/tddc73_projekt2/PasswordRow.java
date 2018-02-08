package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class PasswordRow extends LinearLayout implements AccountRow {

    LinearLayout layout;
    public RatingBar r;
    private TextView starText;
    public EditText password;
    boolean thePassword;

    PasswordChecker pwChecker;
    public void setPwChecker(PasswordChecker pwChecker) {
        this.pwChecker = pwChecker;
    }

    Check check;
    public void setCheck(Check check) {
        this.check = check;
    }

    //Constructor for password row.
    public PasswordRow(Context context, String inputText) {
        super(context);

        check = new Check(context);
        setCheck(check);

        pwChecker = new PasswordChecker(context);
        setPwChecker(pwChecker);

        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;

        TextView text = new TextView(context);
        text.setText(inputText);

        password = new EditText(context);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        password.setSingleLine(true);

        //RatingBar
        r = new RatingBar(context);
        r.setLayoutParams(params);
        r.setActivated(false);
        r.setRating(0);

        //Description for the stars
        starText = new TextView(context);
        starText.setText("Security level");
        starText.setGravity(Gravity.CENTER);

        layout.addView(text);
        layout.addView(password);
        layout.addView(r);
        layout.addView(starText);
        this.addView(layout);

        addListeners(context);
    }

    private void addListeners(final Context context) {

        //Add TextWatcher to password field
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //Sets rating depending on how secure the password is.
                thePassword = pwChecker.checkField(password.getText().toString());
                int rating = pwChecker.getRating();

                r.setRating(rating);
                int starColor = pwChecker.setStarColor(rating);

                if(thePassword){
                    password.setBackgroundColor(0x8000ff00);
                }
                else{
                    password.setBackgroundColor(0x80ff0000); //Opaque red
                    Toast.makeText(context,"Create a safer password!", Toast.LENGTH_SHORT).show();
                }

                //Add the color to the stars
                LayerDrawable stars = (LayerDrawable) r.getProgressDrawable();
                stars.getDrawable(2).setColorFilter(starColor, PorterDuff.Mode.SRC_ATOP);

                send();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Makes the rating bar unclickable
        r.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void send() {
        check.passwordReceive(thePassword);
        check.checkAndCall();
    }

    @Override
    public LinearLayout getData() {
        return this;
    }


}
