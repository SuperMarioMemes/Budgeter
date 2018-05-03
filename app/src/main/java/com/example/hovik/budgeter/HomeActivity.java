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
    TextView savingspercentview;
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

                Housing = (EditText) findViewById(R.id.HousingTxt);
                housingpercentview = (TextView) findViewById(R.id.HousingViewPerc);
                float housingDvalue = Float.parseFloat((Housing.getText().toString()));
                float housingpercent = (housingDvalue/ incomevalue) * 100;
                housingpercentview.setText(Float.toString(housingpercent));

                Debt = findViewById(R.id.DebtTxt);
                debtpercentview = findViewById(R.id.DebtViewPerc);
                float debtDvakue = Float.parseFloat(Debt.getText().toString());
                float debtpercent = (debtDvakue /incomevalue) * 100;
                debtpercentview.setText(Float.toString(debtpercent));

                Savings = findViewById(R.id.SavingsTxt);
                savingspercentview = findViewById(R.id.SavingsViewPerc);
                float savingsDvalue = Float.parseFloat(Savings.getText().toString());
                float savingspercent = (savingsDvalue / incomevalue) * 100;
                savingspercentview.setText(Float.toString(savingspercent));

                entertainment = findViewById(R.id.EntertainmentTxt);
                entpercentview = findViewById(R.id.EntertainViewPerc);
                float entDvalue = Float.parseFloat(entertainment.getText().toString());
                float entpercent = (entDvalue / incomevalue) * 100;
                entpercentview.setText(Float.toString(entpercent));

                personalCare = findViewById(R.id.PersonalCareDisplay);
                personalpercentview = findViewById(R.id.PerCareViewPerc);
                float pcareDvalue = Float.parseFloat(personalCare.getText().toString());
                float pcarepercent = (pcareDvalue / incomevalue) * 100;
                personalpercentview.setText(Float.toString(entpercent));

                healthCare = findViewById(R.id.HealthCareTxt);
                healthpercentageview = findViewById(R.id.healthcarepercentview);
                float hcareDvalue = Float.parseFloat(personalCare.getText().toString());
                float hcarepercent = (hcareDvalue / incomevalue);
                healthpercentageview.setText(Float.toString(hcarepercent));



                /*Intent infoactivity = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(infoactivity);
                finish(); */
            }
        });

    }
}
