package com.example.hovik.budgeter;

import android.content.Intent;
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




        Button finishbtn = (Button) findViewById(R.id.PurchaseFinButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float purchaseDvalue = Float.parseFloat(newPurchaseamt.getText().toString());
                Intent infoActivity = new Intent(PurchaseActivity.this, InfoActivity.class);
                if(spinner.getSelectedItem().toString().equals("Utilities"))
                {
                    float currentbudget = getIntent().getFloatExtra("util", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("util", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Food"))
                {
                    float currentbudget = getIntent().getFloatExtra("food", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("food", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Housing"))
                {
                    float currentbudget = getIntent().getFloatExtra("housing", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("housing", newvalue);
                }
                else if (spinner.getSelectedItem().toString().equals("Debt"))
                {
                    float currentbudget = getIntent().getFloatExtra("debt", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("debt", newvalue);
                }
                else if (spinner.getSelectedItem().toString().equals("Savings"))
                {
                    float currentbudget = getIntent().getFloatExtra("savings", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("savings", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Entertainment"))
                {
                    float currentbudget = getIntent().getFloatExtra("entertainment", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("entertainment", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Personal Care"))
                {
                    float currentbudget = getIntent().getFloatExtra("personalCare", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("personalCare", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Health Care"))
                {
                    float currentbudget = getIntent().getFloatExtra("healthCare", 0);
                    float newvalue = currentbudget - purchaseDvalue;
                    infoActivity.putExtra("healthCare", newvalue);
                }
                else if(spinner.getSelectedItem().toString().equals("Surplus"))
                {
                    float currentbudget = getIntent().getFloatExtra("surplus", 0);
                    float newvalue = currentbudget + purchaseDvalue;
                    infoActivity.putExtra("surplus", newvalue);
                }
                startActivity(infoActivity);
                finish();
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
