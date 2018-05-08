package com.example.hovik.budgeter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import java.util.Vector;

public class InfoActivity extends AppCompatActivity {


    boolean isCurrent = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final PieChart Chart = (PieChart) findViewById(R.id.CurrentPieChart);
        Chart.invalidate();
        Chart.notifyDataSetChanged();
        setupCurrentPieChart(Chart);

        Button newpurchase = (Button) findViewById(R.id.AddPurchase);
        newpurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent purchaseintent = new Intent(InfoActivity.this, PurchaseActivity.class);
                startActivity(purchaseintent);
                finish();
            }
        });

        Button settings = (Button) findViewById(R.id.seettingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsintent = new Intent(InfoActivity.this, SettingsActivity.class);
                startActivity(settingsintent);
                finish();
            }
        });

        Button changegraph = (Button) findViewById(R.id.switchGraphButton);
        changegraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCurrent == true) {
                    Chart.notifyDataSetChanged();
                    Chart.invalidate();
                    setupInitialPieChart(Chart);
                    isCurrent = false;
                }
                else
                {
                    Chart.notifyDataSetChanged();
                    Chart.invalidate();
                    setupCurrentPieChart(Chart);
                    isCurrent = true;
                }

            }
        });

    }

    private void setupCurrentPieChart(PieChart currentChart) {
        //values used for pie chart
        SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = variables.edit();
        float foodcost = variables.getFloat("foodCopy",0);
        float utilcost = variables.getFloat("utilCopy",0);
        float housingcost = variables.getFloat("housingCopy",0);
        float debtcost = variables.getFloat("debtCopy",0);
        float savingscost = variables.getFloat("savingsCopy",0);
        float entertainmentcost = variables.getFloat("entertainmentCopy",0);
        float personalCarecost = variables.getFloat("personalCareCopy",0);
        float healthCarecost = variables.getFloat("healthCareCopy",0);
        float surplus = variables.getFloat("surplusCopy", 0);

        /*float foodcost = getIntent().getFloatExtra("foodCopy",0);
        float utilcost = getIntent().getFloatExtra("utilCopy",0);
        float housingcost = getIntent().getFloatExtra("housingCopy",0);
        float debtcost = getIntent().getFloatExtra("debtCopy",0);
        float savingscost = getIntent().getFloatExtra("savingsCopy",0);
        float entertainmentcost = getIntent().getFloatExtra("entertainmentCopy",0);
        float personalCarecost = getIntent().getFloatExtra("personalCareCopy",0);
        float healthCarecost = getIntent().getFloatExtra("healthCareCopy",0);
        float surplus = getIntent().getFloatExtra("surplusCopy", 0); */

        float tempNums[] = {utilcost, foodcost, housingcost, debtcost, savingscost, entertainmentcost, personalCarecost, healthCarecost, surplus};
        String categories[] = {"Utilities", "Food", "Housing", "Debt", "Savings", "Entertainment",
                "Personal Care", "Health Care", "Surplus"};
        int chartColors[] = {Color.GREEN, Color.CYAN, Color.RED, Color.BLUE, Color.MAGENTA,
                Color.YELLOW, Color.GRAY, Color.CYAN, Color.DKGRAY};

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
        currentChart.setRotationEnabled(true);
        currentChart.animateY(800);
        currentChart.setData(data);
        currentChart.setHoleRadius(14f);
        currentChart.setCenterTextSize(11);
        currentChart.setEntryLabelColor(Color.BLACK);
        currentChart.getDescription().setText("Current Budget");
        currentChart.getDescription().setTextSize(14);
    }
    private void setupInitialPieChart(PieChart currentChart) {
        //values used for pie chart
       /* float foodcost = getIntent().getFloatExtra("food",0);
        float utilcost = getIntent().getFloatExtra("util",0);
        float housingcost = getIntent().getFloatExtra("housing",0);
        float debtcost = getIntent().getFloatExtra("debt",0);
        float savingscost = getIntent().getFloatExtra("savings",0);
        float entertainmentcost = getIntent().getFloatExtra("entertainment",0);
        float personalCarecost = getIntent().getFloatExtra("personalCare",0);
        float healthCarecost = getIntent().getFloatExtra("healthCare",0);
        float surplus = getIntent().getFloatExtra("surplus", 0); */

        SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = variables.edit();
        float foodcost = variables.getFloat("food",0);
        float utilcost = variables.getFloat("util",0);
        float housingcost = variables.getFloat("housing",0);
        float debtcost = variables.getFloat("debt",0);
        float savingscost = variables.getFloat("savings",0);
        float entertainmentcost = variables.getFloat("entertainment",0);
        float personalCarecost = variables.getFloat("personalCare",0);
        float healthCarecost = variables.getFloat("healthCare",0);
        float surplus = variables.getFloat("surplus", 0);
        editor.commit();


        float tempNums[] = {utilcost, foodcost, housingcost, debtcost, savingscost, entertainmentcost, personalCarecost, healthCarecost, surplus};
        String categories[] = {"Utilities", "Food", "Housing", "Debt", "Savings", "Entertainment",
                "Personal Care", "Health Care", "Surplus"};
        int chartColors[] = {Color.GREEN, Color.CYAN, Color.RED, Color.BLUE, Color.MAGENTA,
                Color.YELLOW, Color.GRAY, Color.CYAN, Color.DKGRAY};

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
        currentChart.setRotationEnabled(true);
        currentChart.animateY(800);
        currentChart.setData(data);
        currentChart.setHoleRadius(14f);
        currentChart.setCenterTextSize(11);
        currentChart.setEntryLabelColor(Color.BLACK);
        currentChart.getDescription().setText("Starting Budget");
        currentChart.getDescription().setTextSize(14);
    }
}
