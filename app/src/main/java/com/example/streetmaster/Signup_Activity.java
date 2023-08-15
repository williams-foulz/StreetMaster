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
import com.google.firebase.firestore.FirebaseFirestore;

public class Signup_Activity extends AppCompatActivity {
    String Fname, Lname, Phone, Mail, Pass;

    EditText etFirstname, etLastname, etEmail, etPhone, etPassword;
    TextView miss1, miss2, miss3, miss4, miss5;
    Button btnSubmit;
    private FirebaseAuth mAuth;
    private FirebaseFirestore dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFirstname = findViewById(R.id.etFirstname);
        etLastname = findViewById(R.id.etLastname);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etLoginPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        //missing text view
        miss1 = findViewById(R.id.miss1);
        miss2 = findViewById(R.id.miss2);
        miss3 = findViewById(R.id.miss3);
        miss4 = findViewById(R.id.miss4);
        miss5 = findViewById(R.id.miss5);
        //filled edit text
        Fname = etFirstname.getText().toString();
        Lname = etLastname.getText().toString();
        Mail = etEmail.getText().toString();
        Phone = etPhone.getText().toString();
        Pass = etPassword.getText().toString();

        mAuth = FirebaseAuth.getInstance();
        dp = FirebaseFirestore.getInstance();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearField();

                Fname = etFirstname.getText().toString();
                Lname = etLastname.getText().toString();
                Mail = etEmail.getText().toString();
                Phone = etPhone.getText().toString();
                Pass = etPassword.getText().toString();

                if (Fname.length() == 0) {
                    miss1.setText("missing first name ");
                }
                if (Lname.length() == 0) {
                    miss2.setText("missing last name ");
                }
                if (Mail.length() == 0) {
                    miss3.setText("missing email");
                }
                if (Phone.length() == 0) {
                    miss4.setText("missing phone number");
                }
                if (Pass.length() == 0) {
                    miss5.setText("missing password");
                }

                if(allFilled()==true)

                    mAuth.createUserWithEmailAndPassword(Mail, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(Signup_Activity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                mAuth.signOut();
                                cancelUp();

                            } else {
                                Toast.makeText(Signup_Activity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


            }
        });

    }

    public void clearField() {
        miss1.setText("");
        miss2.setText("");
        miss3.setText("");
        miss4.setText("");
        miss5.setText("");
    }

    public void cancel(View view) {

        cancelUp();
    }

    public void cancelUp() {
        Intent intent = new Intent(Signup_Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public boolean allFilled(){
        if (Mail.length() > 0
                && Pass.length() > 0
                && Fname.length() > 0
                && Lname.length() > 0
                && Phone.length() > 0)
          {
              SMuser user = new SMuser(Mail,Fname,Lname,Mail,Phone,Pass);
              dp.collection("users").document(user.getId()).set(user);
              return true;}
        else{
            return false;
        }

    }

}