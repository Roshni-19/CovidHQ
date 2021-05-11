package com.example.covidhq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhq.models.RegisterModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;



public class LoginActivity extends AppCompatActivity{


    EditText emailid, password;
    Button login;
    TextView forgotPassword,donthaveaccount;
    ProgressBar loader;









    FirebaseAuth fAuth;
    DatabaseReference databaseReference;

    private ImageView bookIconImageView;
    private TextView bookITextView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;


    @Override
    protected void onResume() {
        super.onResume();
        afterAnimationView.animate().alpha(1.0f);
        loader.setVisibility(GONE);
    }


    @Override
    protected void onStart() {
        super.onStart();

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                     FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                            if(user!=null){
                                                bookIconImageView.animate().alpha(0f);
                                                bookITextView.animate().alpha(0f);
                                                loadingProgressBar.animate().alpha(0f);

                                                bookITextView.setVisibility(GONE);
                                                loadingProgressBar.setVisibility(GONE);
                                                bookIconImageView.setVisibility(GONE);

                                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                finish();
                                            }

                                }

        },3000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        bookIconImageView = findViewById(R.id.bookIconImageView);
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);

        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        forgotPassword = findViewById(R.id.forgotPassword);
        loader = findViewById(R.id.loader);
        donthaveaccount = findViewById(R.id.donthaveaccount);

        fAuth = FirebaseAuth.getInstance();





        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                bookITextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSplashText));
                bookIconImageView.setImageResource(R.drawable.welcomelogo);

                bookIconImageView.animate().alpha(0f);

                final Handler handler1 = new Handler(Looper.getMainLooper());
                handler1.postDelayed(() -> {
                    afterAnimationView.setAlpha(0f);
                    afterAnimationView.setVisibility(VISIBLE);
                    afterAnimationView.animate().alpha(1.0f);
                },500);
            }
        }, 3000);

        donthaveaccount.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        });


        login.setOnClickListener(view -> {

            String sEmail = emailid.getText().toString().trim();
            String sPassword = password.getText().toString().trim();

            if (TextUtils.isEmpty(sEmail)) {
                Toast.makeText(getApplicationContext(),"Email is required",Toast.LENGTH_SHORT).show();
                emailid.setError("Email is required");
                return;
            }

            if (Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()){


            }else {
                Toast.makeText(getApplicationContext(),"Please enter a valid email address",Toast.LENGTH_SHORT).show();
                password.setError("Please enter a valid email address");
                return;
            }

            if (TextUtils.isEmpty(sPassword)) {
                Toast.makeText(getApplicationContext(),"Password is required",Toast.LENGTH_SHORT).show();
                password.setError("Password is required");
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(getApplicationContext(),"Please enter more than six characters",Toast.LENGTH_SHORT).show();
                password.setError("Please enter more than six characters");
                return;
            }
            afterAnimationView.animate().alpha(0f);
            loader.setVisibility(VISIBLE);

            fAuth.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        afterAnimationView.animate().alpha(1.0f);
                        loader.setVisibility(GONE);
                    }
                }
            });
        });



        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ForgotPassword.class));
            }
        });

    }





}


//










