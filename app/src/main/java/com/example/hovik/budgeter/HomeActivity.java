package com.example.hovik.budgeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView dollarDisplay;
    TextView percentDisplay;
    EditText income;
    EditText food;
    EditText util;
    EditText Housing;
    EditText Debt;
    EditText Savings;
    EditText entertainment;
    EditText personalCare;
    EditText healthCare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button finishbtn = (Button) findViewById(R.id.AccountFinButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoactivity = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(infoactivity);
                finish();
            }
        });

    }
}
