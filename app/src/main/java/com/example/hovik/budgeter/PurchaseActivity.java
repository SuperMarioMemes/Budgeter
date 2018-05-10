//PurchaseActivity used to add a new purchase and adjust budger
package com.example.hovik.budgeter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class PurchaseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        final EditText newPurchaseamt = (EditText) findViewById(R.id.PurchaseValIn);


        final Spinner spinner = (Spinner) findViewById(R.id.spin);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //Back button will go back to Info Intent when pressed
        Button backbtn = (Button) findViewById(R.id.purchBackButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infointent = new Intent(PurchaseActivity.this, InfoActivity.class);
                startActivity(infointent);
                finish();
            }
        });

        //Finish Button should save the changed made to the budget and go back to Info Intent
        Button finishbtn = (Button) findViewById(R.id.PurchaseFinButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = variables.edit();

                float purchaseDvalue = Float.parseFloat(newPurchaseamt.getText().toString());
                Intent infoActivity = new Intent(PurchaseActivity.this, InfoActivity.class);
                // subtracts the user defined amount from the selected category
                if(spinner.getSelectedItem().toString().equals("Utilities"))
                {
                    float currentbudget = variables.getFloat("utilCopy",0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("utilCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Food"))
                {
                    float currentbudget = variables.getFloat("foodCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("foodCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Housing"))
                {
                    float currentbudget = variables.getFloat("housingCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("housingCopy", newvalue);
                }
                else if (spinner.getSelectedItem().toString().equals("Debt"))
                {
                    float currentbudget = variables.getFloat("debtCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("debtCopy", newvalue);
                }
                else if (spinner.getSelectedItem().toString().equals("Savings"))
                {
                    float currentbudget = variables.getFloat("savingsCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("savingsCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Entertainment"))
                {
                    float currentbudget = variables.getFloat("entertainmentCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("entertainmentCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Personal Care"))
                {
                    float currentbudget = variables.getFloat("personalCareCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("personalCareCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Health Care"))
                {
                    float currentbudget = variables.getFloat("healthCareCopy", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    editor.putFloat("healthCareCopy", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Surplus"))
                {
                    float currentbudget = variables.getFloat("surplusCopy", 0);
                    float newvalue = currentbudget + purchaseDvalue;
                    editor.putFloat("surplusCopy", newvalue);
                }
                editor.commit();
                startActivity(infoActivity); // goes to info activity
                finish(); // ends the current activity
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
