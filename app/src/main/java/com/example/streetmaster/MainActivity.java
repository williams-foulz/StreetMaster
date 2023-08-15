package com.example.streetmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    EditText etLoginMail,etLoginPassword;
    Button btnLogin,btnSignup;
    TextView btnForget,tvMissEmail,tvMissPassword;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoginMail = findViewById(R.id.etLoginMail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnForget = findViewById(R.id.btnForget);
        btnSignup = findViewById(R.id.btnSignup);
        tvMissEmail = findViewById(R.id.tvMissEmail);
        tvMissPassword = findViewById(R.id.tvMissPassword);


        mAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser= mAuth.getCurrentUser();

        if(currentUser==null){

        }
        else {
           // Toast.makeText(this, "welcome back", Toast.LENGTH_SHORT).show();
          //ToScreeOne();
           ToHomePage();
        }

        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forget_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvMissEmail.setText("");
                tvMissPassword.setText("");

                String loginEmail =etLoginMail.getText().toString();
                String loginPass =etLoginPassword.getText().toString();
                if (loginEmail.length()==0){
                    tvMissEmail.setText("Email is missing");
                }
                if (loginPass.length()==0){
                    tvMissPassword.setText("Password is missing");
                }
                if (loginEmail.length()>0 && loginPass.length()>0) {
                    mAuth.signInWithEmailAndPassword(loginEmail, loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                               //ToScreeOne();
                                ToHomePage();
                            } else {
                                Toast.makeText(MainActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else{
                  //  Toast.makeText(MainActivity.this, "Please type your email & password", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup_Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void ToHomePage() {
        Intent intent = new Intent(MainActivity.this, Home_Page_Activity.class);
        startActivity(intent);
        finish();
    }

}