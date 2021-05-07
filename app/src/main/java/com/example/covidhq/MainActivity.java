package com.example.covidhq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhq.models.RegisterModel;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends Activity {



    MaterialButton genGuidelines, medications;
    MaterialButton symptoms;
    TextView welc,oxygen;
    Button logout;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welc = findViewById(R.id.welcome);
        symptoms = findViewById(R.id.symptoms);
        genGuidelines = findViewById(R.id.gen_guidelines);
        medications = findViewById(R.id.medications);
        fAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.buttonLogout);
        oxygen = findViewById(R.id.oxygen);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Registeration details");

        databaseReference.child(fAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                RegisterModel obj2 = snapshot.getValue(RegisterModel.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this,"Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });

        genGuidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), GeneralGuideLines.class);
                startActivity(i1);
            }
        });

        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), Symptoms.class);
                startActivity(i2);
            }
        });

        medications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(), Medications.class);
                startActivity(i3);
            }
        });

        oxygen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Oxygen.class));
            }
        });

    }
}

//String.valueOf(obj2.getAge()















