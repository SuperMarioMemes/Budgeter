package com.example.hovik.budgeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateSalaryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_salary);

        final EditText SalaryText = (EditText) findViewById(R.id.NewSalaryTxtIn);

        final CheckBox retainRatio = (CheckBox) findViewById(R.id.RetainRatioBox);
        //
        final float salary = getIntent().getFloatExtra("incomeCopy", 0);
        final float foodcost = getIntent().getFloatExtra("foodCopy",0);
        final float utilcost = getIntent().getFloatExtra("utilCopy",0);
        final float housingcost = getIntent().getFloatExtra("housingCopy",0);
        final float debtcost = getIntent().getFloatExtra("debtCopy",0);
        final float savingscost = getIntent().getFloatExtra("savingsCopy",0);
        final float entertainmentcost = getIntent().getFloatExtra("entertainmentCopy",0);
        final float personalCarecost = getIntent().getFloatExtra("personalCareCopy",0);
        final float healthCarecost = getIntent().getFloatExtra("healthCareCopy",0);
        //
        final float oldsalary = getIntent().getFloatExtra("income", 0);
        final float oldfoodcost = getIntent().getFloatExtra("food",0);
        final float oldutilcost = getIntent().getFloatExtra("util",0);
        final float oldhousingcost = getIntent().getFloatExtra("housing",0);
        final float olddebtcost = getIntent().getFloatExtra("debt",0);
        final float oldsavingscost = getIntent().getFloatExtra("savings",0);
        final float oldentertainmentcost = getIntent().getFloatExtra("entertainment",0);
        final float oldpersonalCarecost = getIntent().getFloatExtra("personalCare",0);
        final float oldhealthCarecost = getIntent().getFloatExtra("healthCare",0);
        //
        final float salarydif = oldsalary - salary;
        final float foodcostdif = oldfoodcost - foodcost;
        final float utilcostdif = oldutilcost - utilcost;
        final float housingcostdif = oldhousingcost - housingcost;
        final float debtcostdif = olddebtcost - debtcost;
        final float savingscostdif = oldsavingscost - savingscost;
        final float entertainmentcostdif = oldentertainmentcost - entertainmentcost;
        final float personalCarecostdif = oldpersonalCarecost - personalCarecost;
        final float healthCarecostdif = oldhealthCarecost - healthCarecost;


        final Button finishbtn = (Button) findViewById(R.id.FinishNewSalaryButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (retainRatio.isChecked())
                {
                    float newRatio = Float.parseFloat(SalaryText.getText().toString())/salary;
                    float newfood = oldfoodcost * newRatio;
                    float newfoodcur = newfood - foodcostdif;
                    float newutil = oldutilcost * newRatio;
                    float newutilcur = newutil - utilcostdif;
                    float newhousing = oldhousingcost * newRatio;
                    float newhousingcur = newhousing - housingcostdif;
                    float newdebt = olddebtcost * newRatio;
                    float newdebtcur = newdebt - debtcostdif;
                    float newsavings = oldsavingscost * newRatio;
                    float newsavingscur = newsavings - savingscostdif;
                    float newentertainment = oldentertainmentcost * newRatio;
                    float newentertainmentcur = newentertainment - entertainmentcostdif;
                    float newpercare = oldpersonalCarecost * newRatio;
                    float newpercarecur = newpercare - personalCarecostdif;
                    float newhealthcare = oldhealthCarecost * newRatio;
                    float newhealthcarecur = newhealthcare - healthCarecostdif;



                }

            }
        });

    }
}
