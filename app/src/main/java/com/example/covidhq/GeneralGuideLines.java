package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GeneralGuideLines extends AppCompatActivity {

    TextView guidelines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_guide_lines);

        guidelines = findViewById(R.id.guidelines);

        guidelines.setText(R.string.general_guidelines);



    }
}