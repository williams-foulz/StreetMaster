package com.example.streetmaster;


import static com.example.streetmaster.Home_Page_Activity.currentUserIn;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.hardware.camera2.params.BlackLevelPattern;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarInfoFragment newInstance(String param1, String param2) {
        CarInfoFragment fragment = new CarInfoFragment();
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
    Button btnEditCar,btnDeleteCar;
    CarAdapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<CarStatus> cars;
    FirebaseAuth mAuth;
    ImageButton btnAddCar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_info, container, false);

        RecyclerView rcvCarInfo = view.findViewById(R.id.rcvCarInfo);

        btnAddCar=view.findViewById(R.id.btnAddCar);
        btnEditCar=view.findViewById(R.id.btnEditCar);
        btnDeleteCar=view.findViewById(R.id.btnDeleteCar);

        Toast.makeText(getContext(), currentUserIn, Toast.LENGTH_SHORT).show();

        cars = new ArrayList<>();
        adapter = new CarAdapter(CarInfoFragment.this,cars);
        rcvCarInfo.setAdapter(adapter);
        manager = new LinearLayoutManager(getContext());
        rcvCarInfo.setLayoutManager(manager);

        FirebaseFirestore.getInstance().collection(currentUserIn+"-car").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful()){
                    cars.clear();
                    for (DocumentSnapshot doc : task.getResult()){
                        CarStatus cs = doc.toObject(CarStatus.class);
                        cars.add(cs);
                    }
                    adapter.notifyDataSetChanged();

                }
            }
        });


        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   Fragment fragment = new CarAddFragment();
                FragmentTransaction fts = getFragmentManager().beginTransaction();
                fts.replace(R.id.frmContent, new CarAddFragment());
                fts.addToBackStack(null);

                // Commit the transaction
                fts.commit();
            }
        });

        btnEditCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fts = getFragmentManager().beginTransaction();
                fts.replace(R.id.frmContent, new CarEditFragment());
                fts.addToBackStack(null);
                fts.commit();
            }
        });

        btnDeleteCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.notifyDataSetChanged();
            }
        });


        return view;
    }



}