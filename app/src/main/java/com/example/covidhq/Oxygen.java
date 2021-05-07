package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.TextView;

public class Oxygen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        TextView link;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen);

        link = findViewById(R.id.link);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString = "https://www.digit.in/news/general/online-covid-19-resources-hospital-beds-medicines-oxygen-supply-59297.html";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                startActivity(intent);

            }
        });



    }
}





