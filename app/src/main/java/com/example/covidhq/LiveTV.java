package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class LiveTV extends AppCompatActivity {

    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, ll10, ll11, ll12, ll13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tv);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        ll4 = findViewById(R.id.ll4);
        ll5 = findViewById(R.id.ll5);
        ll6 = findViewById(R.id.ll6);
        ll7 = findViewById(R.id.ll7);
        ll8 = findViewById(R.id.ll8);
        ll9 = findViewById(R.id.ll9);
        ll10 = findViewById(R.id.ll10);
        ll11 = findViewById(R.id.ll11);
        ll12 = findViewById(R.id.ll12);
        ll13 = findViewById(R.id.ll13);

        String tv1 = "rDDfv3fZGVk";
        String tv2 = "wuAX15qlv98";
        String tv3 = "wc3Y6vI-poI";
        String tv4 = "a5RnRNNDykw";
        String tv5 = "qS7Q_nZGXnU";
        String tv6 = "WB-y7_ymPJ4";
        String tv7 = "k7X1_ded0aY";
        String tv8 = "Q6QR4979KIQ";
        String tv9 = "jdJoOhqCipA";
        String tv10 = "jjH6v95z3Nw";
        String tv11 = "UUxkVYP36gA";
        String tv12 = "-Ku6BOxFIkc";
        String tv13 = "BtenRwisLFM";


        ll1.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv1);
        });

        ll2.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv2);
        });

        ll3.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv3);
        });

        ll4.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv4);
        });

        ll5.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv5);
        });

        ll6.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv6);
        });

        ll7.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv7);
        });

        ll8.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv8);
        });

        ll9.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv9);
        });

        ll10.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv10);
        });

        ll11.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv11);
        });

        ll12.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv12);
        });

        ll13.setOnClickListener(view -> {
            watchYoutubeVideo(this,tv13);
        });




    }

    public static void watchYoutubeVideo(Context context, String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
    }


}