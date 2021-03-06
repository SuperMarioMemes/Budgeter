//HomeActivity used for setting up an initial account
package com.example.hovik.budgeter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    // declares text views
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // declare texts that are used to input and display
       final  EditText income = (EditText) findViewById(R.id.incomeTxt);
       final EditText food = (EditText) findViewById(R.id.FoodTxt);
       final EditText util = (EditText) findViewById(R.id.UtilTxt);
       final  EditText Housing = (EditText) findViewById(R.id.HousingTxt);
       final  EditText Debt = findViewById(R.id.DebtTxt);
       final EditText Savings = findViewById(R.id.SavingsTxt);
       final EditText entertainment = findViewById(R.id.EntertainmentTxt);
       final  EditText personalCare = findViewById(R.id.PersonalCareDisplay);
       final EditText healthCare = findViewById(R.id.HealthCareTxt);

        //updates
        final Button finishbtn = (Button) findViewById(R.id.AccountFinButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent infointent = new Intent(HomeActivity.this, InfoActivity.class);
                // declares the shared preferences
                SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = variables.edit();
                // stores the original values
                editor.putFloat("income",Float.parseFloat(income.getText().toString()));
                editor.putFloat("food", Float.parseFloat(food.getText().toString()));
                editor.putFloat("util", Float.parseFloat(util.getText().toString()));
                editor.putFloat("housing",  Float.parseFloat(Housing.getText().toString()));
                editor.putFloat("debt",  Float.parseFloat(Debt.getText().toString()));
                editor.putFloat("savings", Float.parseFloat(Savings.getText().toString()));
                editor.putFloat("personalCare", Float.parseFloat(personalCare.getText().toString()));
                editor.putFloat("entertainment", Float.parseFloat(entertainment.getText().toString()));
                editor.putFloat("healthCare", Float.parseFloat(healthCare.getText().toString()));

                // stores a copy of the original
                editor.putFloat("incomeCopy",Float.parseFloat(income.getText().toString()));
                editor.putFloat("foodCopy", Float.parseFloat(food.getText().toString()));
                editor.putFloat("utilCopy", Float.parseFloat(util.getText().toString()));
                editor.putFloat("housingCopy",  Float.parseFloat(Housing.getText().toString()));
                editor.putFloat("debtCopy",  Float.parseFloat(Debt.getText().toString()));
                editor.putFloat("savingsCopy", Float.parseFloat(Savings.getText().toString()));
                editor.putFloat("personalCareCopy", Float.parseFloat(personalCare.getText().toString()));
                editor.putFloat("entertainmentCopy", Float.parseFloat(entertainment.getText().toString()));
                editor.putFloat("healthCareCopy", Float.parseFloat(healthCare.getText().toString()));

                // calculates the surplus (remainder)
                final Float surplus = Float.parseFloat(income.getText().toString()) - Float.parseFloat(food.getText().toString())
                        - Float.parseFloat(util.getText().toString()) - Float.parseFloat(Housing.getText().toString())
                        - Float.parseFloat(Debt.getText().toString()) - Float.parseFloat(Savings.getText().toString())
                        - Float.parseFloat(personalCare.getText().toString()) - Float.parseFloat(entertainment.getText().toString())
                        - Float.parseFloat(healthCare.getText().toString());
                // stores the surplus and the copy
                editor.putFloat("surplus",surplus);
                editor.putFloat("surplusCopy", surplus);
                editor.commit();
                startActivity(infointent); // sends the user to the info activity
                finish(); // finishes this activity

            }

        });
        final Button calculatepercentages = (Button) findViewById(R.id.AccountCalcButton); // button to calculate the percents
        calculatepercentages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                float incomevalue = Float.parseFloat(income.getText().toString());

                // calculates and displays percentages
                foodpercentview = (TextView) findViewById(R.id.FoodViewPerc);
                float foodDvalue = Float.parseFloat(food.getText().toString());
                float foodpercent = (foodDvalue / incomevalue) * 100;
                foodpercentview.setText(Float.toString(foodpercent));


                utilpercentview = (TextView) findViewById(R.id.UtilViewPerc);
                float utilDvalue = Float.parseFloat((util.getText().toString()));
                float utilpercent = (utilDvalue / incomevalue) * 100;
                utilpercentview.setText(Float.toString(utilpercent));


                housingpercentview = (TextView) findViewById(R.id.HousingViewPerc);
                float housingDvalue = Float.parseFloat((Housing.getText().toString()));
                float housingpercent = (housingDvalue / incomevalue) * 100;
                housingpercentview.setText(Float.toString(housingpercent));


                debtpercentview = findViewById(R.id.DebtViewPerc);
                float debtDvakue = Float.parseFloat(Debt.getText().toString());
                float debtpercent = (debtDvakue / incomevalue) * 100;
                debtpercentview.setText(Float.toString(debtpercent));


                savingspercentview = findViewById(R.id.SavingsViewPerc);
                float savingsDvalue = Float.parseFloat(Savings.getText().toString());
                float savingspercent = (savingsDvalue / incomevalue) * 100;
                savingspercentview.setText(Float.toString(savingspercent));


                entpercentview = findViewById(R.id.EntertainViewPerc);
                float entDvalue = Float.parseFloat(entertainment.getText().toString());
                float entpercent = (entDvalue / incomevalue) * 100;
                entpercentview.setText(Float.toString(entpercent));


                personalpercentview = findViewById(R.id.PerCareViewPerc);
                float pcareDvalue = Float.parseFloat(personalCare.getText().toString());
                float pcarepercent = (pcareDvalue / incomevalue) * 100;
                personalpercentview.setText(Float.toString(pcarepercent));


                healthpercentageview = findViewById(R.id.healthcarepercentview);
                float hcareDvalue = Float.parseFloat(healthCare.getText().toString());
                float hcarepercent = (hcareDvalue / incomevalue) * 100;
                healthpercentageview.setText(Float.toString(hcarepercent));

            }
        });

    }


}
