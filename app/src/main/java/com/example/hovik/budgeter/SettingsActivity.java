//SettingsActivity Used for making overall changes to budget
package com.example.hovik.budgeter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button budget = (Button) findViewById(R.id.changeBudgetButton);
        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeintent = new Intent(SettingsActivity.this, HomeActivity.class);
                startActivity(homeintent);
                finish();
            }
        });
        Button back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infointent = new Intent(SettingsActivity.this, InfoActivity.class);
                startActivity(infointent);
                finish();
            }
        });
        Button salary = (Button) findViewById(R.id.ChangeSalaryButton);
        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salaryintent = new Intent(SettingsActivity.this, UpdateSalaryActivity.class);
                startActivity(salaryintent);
                finish();
            }
        });
        Button reset = (Button) findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetintent = new Intent(SettingsActivity.this, InfoActivity.class);
                SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = variables.edit();
                float oldsalary = variables.getFloat("income", 0);
                float oldfoodcost = variables.getFloat("food",0);
                float oldutilcost = variables.getFloat("util",0);
                float oldhousingcost = variables.getFloat("housing",0);
                float olddebtcost = variables.getFloat("debt",0);
                float oldsavingscost = variables.getFloat("savings",0);
                float oldentertainmentcost = variables.getFloat("entertainment",0);
                float oldpersonalCarecost = variables.getFloat("personalCare",0);
                float oldhealthCarecost = variables.getFloat("healthCare",0);
                editor.putFloat("incomeCopy", oldsalary);
                editor.putFloat("foodCopy", oldfoodcost);
                editor.putFloat("utilCopy", oldutilcost);
                editor.putFloat("housingCopy", oldhousingcost);
                editor.putFloat("debtCopy", olddebtcost);
                editor.putFloat("savingsCopy", oldsavingscost);
                editor.putFloat("personalCareCopy", oldpersonalCarecost);
                editor.putFloat("entertainmentCopy", oldentertainmentcost);
                editor.putFloat("healthCareCopy", oldhealthCarecost);
                final Float surplus = oldsalary - oldfoodcost
                        - oldutilcost - oldhousingcost
                        - olddebtcost - oldsavingscost
                        - oldpersonalCarecost - oldentertainmentcost
                        - oldhealthCarecost;
                editor.putFloat("surplusCopy", Float.parseFloat(String.valueOf(surplus)));
                editor.commit();
                startActivity(resetintent);
                finish();
            }
        });
    }
}
