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

    float tempNums[] = {foodpercent, 2f, 3f, 4f, 5f, 6f, 7f, 8f};
    String categories[] = {"Utilities", "Food", "Housing", "Debt", "Savings", "Entertainment",
                            "Personal Care", "Health Care"};
    int chartColors[] = {Color.GREEN, Color.CYAN, Color.RED, Color.BLUE, Color.MAGENTA,
                        Color.YELLOW, Color.GRAY, Color.CYAN};

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
