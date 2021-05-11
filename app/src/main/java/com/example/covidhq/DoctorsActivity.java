package com.example.covidhq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.covidhq.models.DoctorModel;
import com.example.covidhq.models.DoctorModelListItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class DoctorsActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    LinearLayout ll1, ll2, ll3;

    TextView name1, name2, name3, dept1, dept2, dept3, number1, number2, number3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);

        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);

        dept1 = findViewById(R.id.dept1);
        dept2 = findViewById(R.id.dept2);
        dept3 = findViewById(R.id.dept3);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Doctors");

        ll1.setOnClickListener(view -> {
            String number=number1.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number));
            startActivity(callIntent);
        });

        ll2.setOnClickListener(view -> {
            String number=number2.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number));
            startActivity(callIntent);
        });

        ll3.setOnClickListener(view -> {
            String number=number3.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number));
            startActivity(callIntent);
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    DoctorModel doctorModel = snapshot.getValue(DoctorModel.class);

                    assert doctorModel != null;
                    int size = doctorModel.doctorsList.size();


                    if(size == 1){
                        ll1.setVisibility(View.VISIBLE);
                        name1.setText(doctorModel.doctorsList.get(0).getDoctorName());
                        dept1.setText(doctorModel.doctorsList.get(0).getDoctorDept());
                        number1.setText(doctorModel.doctorsList.get(0).getDoctNumber());

                    }
                    if(size == 2){

                        ll1.setVisibility(View.VISIBLE);
                        name1.setText(doctorModel.doctorsList.get(0).getDoctorName());
                        dept1.setText(doctorModel.doctorsList.get(0).getDoctorDept());
                        number1.setText(doctorModel.doctorsList.get(0).getDoctNumber());


                        ll2.setVisibility(View.VISIBLE);
                        name2.setText(doctorModel.doctorsList.get(1).getDoctorName());
                        dept2.setText(doctorModel.doctorsList.get(1).getDoctorDept());
                        number2.setText(doctorModel.doctorsList.get(1).getDoctNumber());
                    }
                    if(size == 3){

                        ll1.setVisibility(View.VISIBLE);
                        name1.setText(doctorModel.doctorsList.get(0).getDoctorName());
                        dept1.setText(doctorModel.doctorsList.get(0).getDoctorDept());
                        number1.setText(doctorModel.doctorsList.get(0).getDoctNumber());


                        ll2.setVisibility(View.VISIBLE);
                        name2.setText(doctorModel.doctorsList.get(1).getDoctorName());
                        dept2.setText(doctorModel.doctorsList.get(1).getDoctorDept());
                        number2.setText(doctorModel.doctorsList.get(1).getDoctNumber());

                        ll3.setVisibility(View.VISIBLE);
                        name3.setText(doctorModel.doctorsList.get(2).getDoctorName());
                        dept3.setText(doctorModel.doctorsList.get(2).getDoctorDept());
                        number3.setText(doctorModel.doctorsList.get(2).getDoctNumber());
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}