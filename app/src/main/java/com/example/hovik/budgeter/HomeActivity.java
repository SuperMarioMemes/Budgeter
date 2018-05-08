package com.example.hovik.budgeter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       final  EditText income = (EditText) findViewById(R.id.incomeTxt);
       final EditText food = (EditText) findViewById(R.id.FoodTxt);
       final EditText util = (EditText) findViewById(R.id.UtilTxt);
       final  EditText Housing = (EditText) findViewById(R.id.HousingTxt);
       final  EditText Debt = findViewById(R.id.DebtTxt);
       final EditText Savings = findViewById(R.id.SavingsTxt);
       final EditText entertainment = findViewById(R.id.EntertainmentTxt);
       final  EditText personalCare = findViewById(R.id.PersonalCareDisplay);
       final EditText healthCare = findViewById(R.id.HealthCareTxt);

       // calculate surplus

        //updates
        final Button finishbtn = (Button) findViewById(R.id.AccountFinButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent infointent = new Intent(HomeActivity.this, InfoActivity.class);
                infointent.putExtra("income", Float.parseFloat(income.getText().toString()));
                infointent.putExtra("food", Float.parseFloat(food.getText().toString()));
                infointent.putExtra("util", Float.parseFloat(util.getText().toString()));
                infointent.putExtra("housing", Float.parseFloat(Housing.getText().toString()));
                infointent.putExtra("debt", Float.parseFloat(Debt.getText().toString()));
                infointent.putExtra("savings", Float.parseFloat(Savings.getText().toString()));
                infointent.putExtra("personalCare", Float.parseFloat(personalCare.getText().toString()));
                infointent.putExtra("entertainment", Float.parseFloat(entertainment.getText().toString()));
                infointent.putExtra("healthCare", Float.parseFloat(healthCare.getText().toString()));
                infointent.putExtra("incomeCopy", Float.parseFloat(income.getText().toString()));
                infointent.putExtra("foodCopy", Float.parseFloat(food.getText().toString()));
                infointent.putExtra("utilCopy", Float.parseFloat(util.getText().toString()));
                infointent.putExtra("housingCopy", Float.parseFloat(Housing.getText().toString()));
                infointent.putExtra("debtCopy", Float.parseFloat(Debt.getText().toString()));
                infointent.putExtra("savingsCopy", Float.parseFloat(Savings.getText().toString()));
                infointent.putExtra("personalCareCopy", Float.parseFloat(personalCare.getText().toString()));
                infointent.putExtra("entertainmentCopy", Float.parseFloat(entertainment.getText().toString()));
                infointent.putExtra("healthCareCopy", Float.parseFloat(healthCare.getText().toString()));

                final Float surplus = Float.parseFloat(income.getText().toString()) - Float.parseFloat(food.getText().toString())
                        - Float.parseFloat(util.getText().toString()) - Float.parseFloat(Housing.getText().toString())
                        - Float.parseFloat(Debt.getText().toString()) - Float.parseFloat(Savings.getText().toString())
                        - Float.parseFloat(personalCare.getText().toString()) - Float.parseFloat(entertainment.getText().toString())
                        - Float.parseFloat(healthCare.getText().toString());
                final Float surplusPerc = (surplus / Float.parseFloat(income.getText().toString())) * 100;
                infointent.putExtra("surplus", Float.parseFloat(String.valueOf(surplusPerc)));
                infointent.putExtra("surplusCopy", Float.parseFloat(String.valueOf(surplusPerc)));

                startActivity(infointent);
                finish();

            }

        });
        final Button calculatepercentages = (Button) findViewById(R.id.AccountCalcButton);
        calculatepercentages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                float incomevalue = Float.parseFloat(income.getText().toString());


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

                // saveData(finishbtn);


            }
        });

    }
}
    //function for saving data entered in the text fields, so they can be reused when app is reopened
   /* public void saveData(View view) {

        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor outfile = sharedpref.edit();
        outfile.putString("income", income.getText().toString());
        outfile.putString("food", food.getText().toString());
        outfile.putString("util", util.getText().toString());
        outfile.putString("housing", Housing.getText().toString());
        outfile.putString("debt", Debt.getText().toString());
        outfile.putString("savings", Savings.getText().toString());
        outfile.putString("entertainment", entertainment.getText().toString());
        outfile.putString("personalCare", personalCare.getText().toString());
        outfile.putString("healthCare",healthCare.getText().toString());
        outfile.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}
*/
