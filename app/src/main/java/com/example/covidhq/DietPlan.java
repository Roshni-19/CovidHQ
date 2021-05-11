package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DietPlan extends AppCompatActivity {

    TextView calories, ons, forCovidPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        calories = findViewById(R.id.calories);
        ons = findViewById(R.id.ons);
        forCovidPatients = findViewById(R.id.forCovidPatients);

        calories.setText(R.string.calories);
        ons.setText(R.string.ons);
        forCovidPatients.setText(R.string.covidguidelinesnutrition);

    }
}