package com.example.hovik.budgeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView dollarDisplay;
    TextView percentDisplay;
    TextView foodpercentview;
    TextView utilpercentview;
    TextView housingpercentview;
    TextView debtpercentview;
    TextView Savingspercentview;
    TextView entpercentview;
    TextView personalpercentview;
    TextView healthpercentageview;

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

                income = (EditText) findViewById(R.id.incomeTxt);
                float incomevalue = Float.parseFloat(income.getText().toString());

                food = (EditText) findViewById(R.id.FoodTxt);
                foodpercentview = (TextView) findViewById(R.id.FoodViewPerc);
                float foodDvalue = Float.parseFloat(food.getText().toString());
                float foodpercent = (foodDvalue / incomevalue) * 100;
                foodpercentview.setText(Float.toString(foodpercent));

                util = (EditText) findViewById(R.id.UtilTxt);
                utilpercentview = (TextView) findViewById(R.id.UtilViewPerc);
                float utilDvalue = Float.parseFloat((util.getText().toString()));
                float utilpercent = (utilDvalue / incomevalue) * 100;
                utilpercentview.setText(Float.toString(utilpercent));




                /*Intent infoactivity = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(infoactivity);
                finish(); */
            }
        });

    }
}
