package com.example.sarah.tddc73_projekt2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    AccountRegistration account;
    Check check;
    Button b;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        //Header
        description = new TextView(this);
        description.setText("Create a new user");
        description.setLayoutParams(params);
        description.setTextSize(30);
        description.setTypeface(Typeface.DEFAULT_BOLD);

        //Create account button
        b = new Button(this);
        b.setText("Create account");
        //Initialize it as disabled
        b.setEnabled(false);

        check = new Check(this);

        //Layout
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        account = new AccountRegistration(this);
        account.addRow(new TextRow(this, "User"));
        account.addRow(new MailRow(this, "Mail"));
        account.addRow(new PasswordRow(this, "Password"));

        //If all the fields are filled correctly, this function will be called.
        check.setOnPandClickListener(new TheListener() {
            @Override
            public void canCreate() {
                Toast.makeText(MainActivity.this, "Account can be created", Toast.LENGTH_SHORT).show();
                //Enables Create button.
                b.setEnabled(true);
            }

            @Override
            public void canNotCreate() {
                //Enables Create button.
                b.setEnabled(false);
            }
        });

        layout.addView(description);
        account.setLayoutParams(params);
        layout.addView(account);
        layout.addView(b);
        setContentView(layout);
    }

}
