package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;

public class Symptoms extends AppCompatActivity {

    CheckBox normal, runningNose, bodyAche, mildFever, lossTasteSmell, vomit, breathDifficulty;
    EditText temperature;
    TextView normalText, mildText, alertText;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        normal = findViewById(R.id.normal);
        runningNose = findViewById(R.id.runningnose);
        bodyAche = findViewById(R.id.body_ache);
        mildFever = findViewById(R.id.mild_fever);
        lossTasteSmell = findViewById(R.id.losstaste);
        vomit = findViewById(R.id.vomit);
        breathDifficulty = findViewById(R.id.breath_difficulty);
        temperature = findViewById(R.id.temperature);
        normalText = findViewById(R.id.normal_text);
        mildText = findViewById(R.id.mild_text);
        alertText = findViewById(R.id.alert_text);

        normalText.setVisibility(GONE);
        mildText.setVisibility(GONE);
        alertText.setVisibility(GONE);

        submit = findViewById(R.id.submit);

        double tempVal = 0;
        String temp = temperature.getText().toString();
        if(!"".equals(temp)) {
            tempVal = Double.parseDouble(String.valueOf(tempVal));
        }

        normal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    runningNose.setEnabled(false);
                    bodyAche.setEnabled(false);
                    mildFever.setEnabled(false);
                    lossTasteSmell.setEnabled(false);
                    vomit.setEnabled(false);
                    breathDifficulty.setEnabled(false);
                } else {
                    runningNose.setEnabled(true);
                    bodyAche.setEnabled(true);
                    mildFever.setEnabled(true);
                    lossTasteSmell.setEnabled(true);
                    vomit.setEnabled(true);
                    breathDifficulty.setEnabled(true);
                }
            }
        });
        double finalTempVal = tempVal;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(normal.isChecked() || runningNose.isChecked() || bodyAche.isChecked() || mildFever.isChecked()
                        || lossTasteSmell.isChecked() || vomit.isChecked() || breathDifficulty.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Please select an option.", Toast.LENGTH_LONG);
                } else if(temp == "") {
                    Toast.makeText(getApplicationContext(), "Please Enter your body temperature.", Toast.LENGTH_LONG);
                } else if(normal.isChecked()) {
                    normalText.setVisibility(View.VISIBLE);
                    mildText.setVisibility(GONE);
                    alertText.setVisibility(GONE);
                } else if(runningNose.isChecked() || bodyAche.isChecked() || mildFever.isChecked() ||
                        (finalTempVal >= 100 && finalTempVal < 102)) {
                    normalText.setVisibility(GONE);
                    mildText.setVisibility(View.VISIBLE);
                    alertText.setVisibility(GONE);
                } else {
                    normalText.setVisibility(GONE);
                    mildText.setVisibility(GONE);
                    alertText.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}