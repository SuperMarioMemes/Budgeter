package com.example.hovik.budgeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Surface;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setupPieChart();

        Button newpurchase = (Button) findViewById(R.id.AddPurchase);
        newpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent purchaseintent = new Intent(InfoActivity.this, PurchaseActivity.class);
                startActivity(purchaseintent);
                finish();
            }
        });

    }

    private void setupPieChart() {
        /*String food = getIntent().getFloatExtra("food",0);
        String util = getIntent().getStringExtra("util");
        String housing = getIntent().getStringExtra("housing");
        String debt = getIntent().getStringExtra("debt");
        String savings = getIntent().getStringExtra("savings");
        String entertainment = getIntent().getStringExtra("entertainment");
        String personalCare = getIntent().getStringExtra("personalCare");
        String healthcare = getIntent().getStringExtra("healthCare"); */

        //values used for pie chart
        float foodcost = getIntent().getFloatExtra("food",0);
        float utilcost = getIntent().getFloatExtra("util",0);
        float housingcost = getIntent().getFloatExtra("housing",0);
        float debtcost = getIntent().getFloatExtra("debt",0);
        float savingscost = getIntent().getFloatExtra("savings",0);
        float entertainmentcost = getIntent().getFloatExtra("entertainment",0);
        float personalCarecost = getIntent().getFloatExtra("personalCare",0);
        float healthCarecost = getIntent().getFloatExtra("healthCare",0);

        float tempNums[] = {utilcost, foodcost, housingcost, debtcost, savingscost, entertainmentcost, personalCarecost, healthCarecost};
        String categories[] = {"Utilities", "Food", "Housing", "Debt", "Savings", "Entertainment",
                "Personal Care", "Health Care"};
        int chartColors[] = {Color.GREEN, Color.CYAN, Color.RED, Color.BLUE, Color.MAGENTA,
                Color.YELLOW, Color.GRAY, Color.CYAN};

        // Populate chart
        List<PieEntry> CatEntries = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            CatEntries.add(new PieEntry(tempNums[i], categories[i]));
        }

        PieDataSet CatDataSet = new PieDataSet(CatEntries, "Categories");
        CatDataSet.setColors(chartColors);
        PieData data = new PieData(CatDataSet);
        data.setValueTextSize(11);

        // Get chart
        PieChart currentChart = (PieChart) findViewById(R.id.CurrentPieChart);
        currentChart.setRotationEnabled(true);
        currentChart.animateY(800);
        currentChart.setData(data);
        currentChart.setHoleRadius(14f);
        currentChart.setCenterTextSize(11);
        currentChart.setEntryLabelColor(Color.BLACK);
        currentChart.getDescription().setText("Current Budget");
        currentChart.getDescription().setTextSize(14);
    }
}
