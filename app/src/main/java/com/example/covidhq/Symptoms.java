package com.example.covidhq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhq.models.PrescriptionListItem;
import com.example.covidhq.models.PrescriptionModel;
import com.example.covidhq.models.SymptomsModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.view.View.GONE;

public class Symptoms extends AppCompatActivity {

    CheckBox normal, runningNose, bodyAche, mildFever, lossTasteSmell, vomit, breathDifficulty;
    EditText temperature;
    TextView normalText, mildText, alertText,prescription;
    Button submit;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth auth;

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
        prescription = findViewById(R.id.prescription);
        firebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("Registration Details").child(auth.getUid());

        normalText.setVisibility(GONE);
        mildText.setVisibility(GONE);
        alertText.setVisibility(GONE);

        submit = findViewById(R.id.submit);



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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double tempVal = 0;
                String temp = temperature.getText().toString();
                if(!"".equals(temp)) {
                    tempVal = Double.parseDouble(String.valueOf(tempVal));
                }
                double finalTempVal = tempVal;


                if(!(normal.isChecked() || runningNose.isChecked() || bodyAche.isChecked() || mildFever.isChecked()
                        || lossTasteSmell.isChecked() || vomit.isChecked() || breathDifficulty.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Please select an option.", Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(temp)) {
                    Toast.makeText(getApplicationContext(), "Please Enter your body temperature.", Toast.LENGTH_LONG).show();
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

                String Normal = "NO";
                String RunningNose = "NO";
                String BodyAche = "NO";
                String Feverish = "NO";
                String LossOfTaste = "NO";
                String Nausia = "NO";
                String BreathingDifficulty = "NO";
                String Temp = "NO";

                PrescriptionModel prescriptionModel = new PrescriptionModel();

                if(runningNose.isChecked()){
                    RunningNose = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Ipratropium Bromide 0.03% Nasal Spray","NO","YES","NO","NO","NO","YES"));
                    prescriptionModel.prescription.add(new PrescriptionListItem("Antihistaminesy","NO","YES","NO","NO","NO","YES"));
                }
                if(bodyAche.isChecked()){
                    BodyAche = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Tab. Aspirin","NO","YES","NO","YES","NO","YES"));

                }
                if(mildFever.isChecked()){
                    Feverish = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Tab. Dolo 650","NO","YES","NO","YES","NO","YES"));

                }
                if(lossTasteSmell.isChecked()){
                    LossOfTaste = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Antihistamines and Decongestant","NO","YES","NO","YES","NO","YES"));

                }
                if(vomit.isChecked()){
                    Nausia = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Aprepitant","NO","YES","NO","NO","NO","YES"));

                }
                if(breathDifficulty.isChecked()){
                    BreathingDifficulty = "YES";
                    prescriptionModel.prescription.add(new PrescriptionListItem("Albuterol or Anticholinergic Agent","NO","YES","NO","NO","NO","YES"));

                }

                Temp = temp;


                if(normal.isChecked()){
                    Normal = "YES";
                    RunningNose = "NO";
                    BodyAche = "NO";
                    Feverish = "NO";
                    LossOfTaste = "NO";
                    Nausia = "NO";
                    BreathingDifficulty = "NO";
                }


                SymptomsModel symptomsModel = new SymptomsModel(Normal,RunningNose,BodyAche,Feverish,LossOfTaste,Nausia,BreathingDifficulty,Temp);

                String key = String.valueOf(System.currentTimeMillis());


                databaseReference.child("Symptoms").child(key).child("Noted Symptoms").setValue(symptomsModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        databaseReference.child("Symptoms").child(key).child("Given Prescription").setValue(prescriptionModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(),"Your data is saved in our servers!",Toast.LENGTH_SHORT).show();
                                int i=1;
                                String pr = "\n\nPlease follow the below Prescription with Medical Advice\n\n";
                                for(PrescriptionListItem p: prescriptionModel.prescription){
                                    pr += i+". "+p.getMedicineName()+"\n\nMorning: \nBefore Food: "+p.getMorningbeforefood()+"\nAfter Food: "+p.getMorningafterfood()+"\n\nAfternoon: \nBefore Food: "+p.getAfternoonbeforefood()+"\nAfter Food: "+p.getAfternoonafterfood()+"\n\nNight: \nBefore Food: "+p.getNightbeforefood()+"\nAfter Food: "+p.getNightafterfood()+"\n\n\n";
                                    i++;
                                }
                                prescription.setText(pr);
                            }
                        });
                    }
                });

            }
        });
    }
}