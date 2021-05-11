package com.example.covidhq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhq.models.RegisterModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText emailid, name, age, password,mobno;
    TextView alreadyhaveaccount, forgotPassword;
    Button register;
    ProgressBar loader;
    ScrollView scrollview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        alreadyhaveaccount = findViewById(R.id.alreadyhaveaccount);
        forgotPassword = findViewById(R.id.forgotPassword);
        register = findViewById(R.id.register);
        fAuth = FirebaseAuth.getInstance();
        loader = findViewById(R.id.loader);
        scrollview = findViewById(R.id.scrollview);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Registration Details");
        mobno = findViewById(R.id.mobno);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        register.setOnClickListener(view -> {

            String sEmail = emailid.getText().toString().trim();
            String sPassword = password.getText().toString().trim();
            String sAge = age.getText().toString();
            String sName = name.getText().toString().trim();
            String sGender = spinner.getSelectedItem().toString();
            String sMobno = mobno.getText().toString();


             if (TextUtils.isEmpty(sEmail)) {
                Toast.makeText(getApplicationContext(),"Email is required",Toast.LENGTH_SHORT).show();
                emailid.setError("Email is required");
            }


             else if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                 Toast.makeText(getApplicationContext(),"Please enter a valid email address",Toast.LENGTH_SHORT).show();
                 emailid.setError("Please enter a valid email address");
             }

            else if (TextUtils.isEmpty(sName)){
                name.setError("Please enter your name");
            }
            else if (TextUtils.isEmpty(sPassword)) {
                Toast.makeText(getApplicationContext(),"Password is required",Toast.LENGTH_SHORT).show();
                password.setError("Password is required");
            }
            else if (sPassword.length()<6) {
                Toast.makeText(getApplicationContext(),"Please enter more than six characters",Toast.LENGTH_SHORT).show();
                password.setError("Please enter more than six characters");
            }

            else if (!validateAge(sAge) || TextUtils.isEmpty(sAge)) {
                Toast.makeText(getApplicationContext(),"Please enter a valid age",Toast.LENGTH_SHORT).show();
                age.setError("Please enter a valid age" );
            }
            else{
                scrollview.animate().alpha(0f);
                scrollview.setVisibility(GONE);
                loader.setVisibility(VISIBLE);

                fAuth.createUserWithEmailAndPassword(sEmail,sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            registerUser(sName,Integer.parseInt(sAge),sGender,sEmail,sMobno);
                        }else {
                            Toast.makeText(getApplicationContext(),"Error Occurred: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            scrollview.setVisibility(VISIBLE);
                            scrollview.animate().alpha(1.0f);
                            loader.setVisibility(GONE);

                        }
                    }
                });
            }



        });






    }

    public  void registerUser (String name, int age, String gender, String emailid, String mobno){
        RegisterModel obj1 = new RegisterModel(name,gender,emailid,mobno,age);
        databaseReference.child(fAuth.getUid()).setValue(obj1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"User created successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }


    boolean validateAge(String Input){
        Pattern p = Pattern.compile("[0-9]{1,2}");
        Matcher m = p.matcher(Input);
        return m.matches();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

