package com.example.streetmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Home_Page_Activity extends AppCompatActivity {

    BottomNavigationView navigationBar;
    FrameLayout frmContent;
    ImageView btnLogOut;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    FirebaseAuth mAuth;

    DailyFragment dailyFragment;
    CarInfoFragment carFragment;
    StudentsFragment studentsFragment;
    static String currentUserIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        currentUserIn=FirebaseAuth.getInstance().getCurrentUser().getEmail();


        Toast.makeText(this, currentUserIn, Toast.LENGTH_SHORT).show();


        btnLogOut = findViewById(R.id.btnLogOut);
        navigationBar = findViewById(R.id.navigationBar);
        frmContent = findViewById(R.id.frmContent);

        dailyFragment = new DailyFragment();
        carFragment = new CarInfoFragment();
        studentsFragment = new StudentsFragment();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               logoutDialog();
            }
        });
        navigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selectedId = item.getItemId();
                // navigation between fragments in one frame
                if(selectedId==R.id.mnuDaily){
                    //Toast.makeText(Home_Page_Activity.this, "daily", Toast.LENGTH_SHORT).show();
                   FragmentMoveTo(dailyFragment);
                }
                else if(selectedId==R.id.mnuStudents){
                   // Toast.makeText(Home_Page_Activity.this, "students", Toast.LENGTH_SHORT).show();
                    FragmentMoveTo(studentsFragment);
                }
                else if(selectedId==R.id.mnuCarInfo){
                   // Toast.makeText(Home_Page_Activity.this, "car", Toast.LENGTH_SHORT).show();
                    FragmentMoveTo(carFragment);
                }
                return true;
            }
        });
    }
    public void logoutDialog(){
        builder = new AlertDialog.Builder(Home_Page_Activity.this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAuth.getInstance().signOut();
                Intent intent = new Intent(Home_Page_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog = builder.create();
        dialog.show();

    }
    // navigation between fragments in one frame
    public void FragmentMoveTo(Fragment fragment){
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.frmContent,fragment);
        fts.commit();
    }
}