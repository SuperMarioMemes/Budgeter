package com.example.hovik.budgeter;

import android.content.Intent;
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
        Button salary = (Button) findViewById(R.id.ChangeSalaryButton);
        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salaryintent = new Intent(SettingsActivity.this, UpdateSalaryActivity.class);
                startActivity(salaryintent);
                finish();
            }
        });
    }
}
