package com.example.sarah.tddc73_projekt2;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;


public class AccountRegistration extends LinearLayout {

    ArrayList<AccountRow> rows;

    public AccountRegistration(Context context){
        super(context);
        setOrientation(VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);

        rows = new ArrayList<AccountRow>();
    }

    public void addRow(AccountRow newRow){
        rows.add(newRow);
        addView(newRow.getData());
    }

}
