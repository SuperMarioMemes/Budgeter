//UpdateSalary does as the name implies
package com.example.hovik.budgeter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class  UpdateSalaryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_salary);

        final EditText SalaryText = (EditText) findViewById(R.id.NewSalaryTxtIn);
        final CheckBox retainRatio = (CheckBox) findViewById(R.id.RetainRatioBox);





        Button finishbtn = (Button) findViewById(R.id.FinishNewSalaryButton);
        finishbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                SharedPreferences variables = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = variables.edit();
                // store the current budge values into floats
                float salary = variables.getFloat("incomeCopy", 0);
                float foodcost = variables.getFloat("foodCopy",0);
                float utilcost = variables.getFloat("utilCopy",0);
                float housingcost = variables.getFloat("housingCopy",0);
                float debtcost = variables.getFloat("debtCopy",0);
                float savingscost = variables.getFloat("savingsCopy",0);
                float entertainmentcost = variables.getFloat("entertainmentCopy",0);
                float personalCarecost = variables.getFloat("personalCareCopy",0);
                float healthCarecost = variables.getFloat("healthCareCopy",0);
                // store the starting budget values into floats
                float oldsalary = variables.getFloat("income", 0);
                float oldfoodcost = variables.getFloat("food",0);
                float oldutilcost = variables.getFloat("util",0);
                float oldhousingcost = variables.getFloat("housing",0);
                float olddebtcost = variables.getFloat("debt",0);
                float oldsavingscost = variables.getFloat("savings",0);
                float oldentertainmentcost = variables.getFloat("entertainment",0);
                float oldpersonalCarecost = variables.getFloat("personalCare",0);
                float oldhealthCarecost = variables.getFloat("healthCare",0);
                // calculates the change between the two
                float foodcostdif = oldfoodcost - foodcost;
                float utilcostdif = oldutilcost - utilcost;
                float housingcostdif = oldhousingcost - housingcost;
                float debtcostdif = olddebtcost - debtcost;
                float savingscostdif = oldsavingscost - savingscost;
                float entertainmentcostdif = oldentertainmentcost - entertainmentcost;
                float personalCarecostdif = oldpersonalCarecost - personalCarecost;
                float healthCarecostdif = oldhealthCarecost - healthCarecost;

                // if the user decides to maintain there old budget ration
                if (retainRatio.isChecked())
                {
                    Intent infointent = new Intent(UpdateSalaryActivity.this, InfoActivity.class);
                    float newRatio = (Float.parseFloat(SalaryText.getText().toString())/oldsalary);
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
                    editor.putFloat("income", Float.parseFloat(SalaryText.getText().toString()));
                    editor.putFloat("food", newfood);
                    editor.putFloat("util", newutil);
                    editor.putFloat("housing", newhousing);
                    editor.putFloat("debt", newdebt);
                    editor.putFloat("savings", newsavings);
                    editor.putFloat("personalCare", newpercare);
                    editor.putFloat("entertainment", newentertainment);
                    editor.putFloat("healthCare", newhealthcare);
                    editor.putFloat("incomeCopy", Float.parseFloat(SalaryText.getText().toString()));
                    editor.putFloat("foodCopy", newfoodcur);
                    editor.putFloat("utilCopy", newutilcur);
                    editor.putFloat("housingCopy", newhousingcur);
                    editor.putFloat("debtCopy", newdebtcur);
                    editor.putFloat("savingsCopy", newsavingscur);
                    editor.putFloat("personalCareCopy", newpercarecur);
                    editor.putFloat("entertainmentCopy", newentertainmentcur);
                    editor.putFloat("healthCareCopy", newhealthcarecur);

                    final Float surplus = Float.parseFloat(SalaryText.getText().toString()) - newfood
                            - newutil - newhousing
                            - newdebt - newsavings
                            - newpercare - newentertainment
                            - newhealthcare;
                    editor.putFloat("surplus", Float.parseFloat(String.valueOf(surplus)));
                    editor.putFloat("surplusCopy", Float.parseFloat(String.valueOf(surplus)));
                    editor.commit();
                    startActivity(infointent);
                    finish();
                }

                // if the user just decides to add to the salary
                else
                {
                    Intent infointent = new Intent(UpdateSalaryActivity.this, InfoActivity.class);
                    editor.putFloat("income", Float.parseFloat(SalaryText.getText().toString()));
                    editor.putFloat("incomeCopy", Float.parseFloat(SalaryText.getText().toString()));
                    float surplus = Float.parseFloat(SalaryText.getText().toString()) - foodcost
                            - utilcost - housingcost
                            - debtcost - savingscost
                            - personalCarecost - entertainmentcost
                            - healthCarecost;
                    editor.putFloat("surplus", surplus);
                    editor.putFloat("surplusCopy", surplus);
                    editor.commit();
                    startActivity(infointent);
                    finish();

                }

            }
        });

    }
}
