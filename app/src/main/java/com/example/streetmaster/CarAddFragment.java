package com.example.streetmaster;

import static com.example.streetmaster.Home_Page_Activity.currentUserIn;

import android.app.DatePickerDialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarAddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarAddFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarAddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarAddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarAddFragment newInstance(String param1, String param2) {
        CarAddFragment fragment = new CarAddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    EditText etModel, etNumber, etYear, etKm, etSchool;

    TextView etExLicense, etExInsurance;
    Button btnSave, btnCal1, btnCal2;
    ImageView btnBack;
    String model, number, year, km, transmission, school, exi;
    String exl;
    ToggleButton btnTransmission;
    FirebaseFirestore db;
    //ArrayList<CarStatus> cars;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_add, container, false);

        Toast.makeText(getContext(), currentUserIn, Toast.LENGTH_SHORT).show();

        etModel = view.findViewById(R.id.etModel);
        etNumber = view.findViewById(R.id.etNumber);
        etYear = view.findViewById(R.id.etYear);
        etKm = view.findViewById(R.id.etKm);
        etExLicense = view.findViewById(R.id.etExLicense);
        etExInsurance = view.findViewById(R.id.etExInsurance);
        btnTransmission = view.findViewById(R.id.btnTransmission);
        etSchool = view.findViewById(R.id.etSchool);
        btnCal1 = view.findViewById(R.id.btnCal1);
        btnCal2 = view.findViewById(R.id.btnCal2);
        btnSave = view.findViewById(R.id.btnSave);
        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fts = getFragmentManager().beginTransaction();
                fts.replace(R.id.frmContent, new CarInfoFragment());
                fts.addToBackStack(null);
                fts.commit();
            }
        });

        btnCal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate(etExLicense);
            }
        });
        btnCal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate(etExInsurance);
            }
        });

        btnTransmission.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (btnTransmission.isChecked()) {
                    transmission = btnTransmission.getTextOn().toString();
                } else {
                    transmission = btnTransmission.getTextOff().toString();
                }
            }
        });

       // cars = new ArrayList<>();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model = etModel.getText().toString();
                number = etNumber.getText().toString();
                year = etYear.getText().toString();
                km = etKm.getText().toString();
                exl = etExLicense.getText().toString();
                exi = etExInsurance.getText().toString();
                school = etSchool.getText().toString();
                CarStatus cs = new CarStatus(model, number, year, km, exl, exi, transmission, school);
               // cars.add(cs);

                db.getInstance().collection(currentUserIn + "-car").document(model).set(cs).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "New Car Added", Toast.LENGTH_SHORT).show();
                            FragmentTransaction fts = getFragmentManager().beginTransaction();
                            fts.replace(R.id.frmContent, new CarInfoFragment());
                            fts.addToBackStack(null);
                            fts.commit();
                        } else {
                            Toast.makeText(getContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        return view;
    }

    private void pickDate(TextView tv) {
        android.icu.util.Calendar cal = android.icu.util.Calendar.getInstance();
        int month = cal.get(android.icu.util.Calendar.MONTH);
        int day = cal.get(android.icu.util.Calendar.DAY_OF_MONTH);
        int year = cal.get(android.icu.util.Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(tv.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(dayOfMonth + "/" + month + "/" + year);

            }
        }, year, month, day);
        datePickerDialog.show();

    }
}