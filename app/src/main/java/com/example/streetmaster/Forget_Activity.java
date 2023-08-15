package com.example.streetmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_Activity extends AppCompatActivity {

    EditText etForgetMail;
    TextView tvForgetMiss;
    Button btnResetPassword;
    FirebaseAuth mAuth;
    AlertDialog dialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        etForgetMail = findViewById(R.id.etForgetMail);
        tvForgetMiss = findViewById(R.id.tvForgetMiss);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        mAuth = FirebaseAuth.getInstance();

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvForgetMiss.setText("");
                String ForMail = etForgetMail.getText().toString();
                if(ForMail.length()>0){

                    mAuth.sendPasswordResetEmail(ForMail)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        builder = new AlertDialog.Builder(Forget_Activity.this);
                                        builder.setTitle("Reset password");
                                        builder.setMessage("Sending to mail");
                                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(Forget_Activity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                                        dialog = builder.create();
                                        dialog.show();

                                    }
                                }
                            });
                }else{
                    tvForgetMiss.setText("your email is missing");
                }


            }
        });



    }
}


