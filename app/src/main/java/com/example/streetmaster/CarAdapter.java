package com.example.streetmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {


    private CarInfoFragment context;
    private ArrayList<CarStatus> carsList;
    public CarAdapter( CarInfoFragment context,ArrayList<CarStatus> carsList) {
        this.carsList = carsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CarAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_in_list,parent,false);

        CarViewHolder holder = new CarViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.CarViewHolder holder, int position) {

        CarStatus carSt = carsList.get(position);

        holder.tvModel.setText(carSt.getModel());
        holder.tvNumber.setText(carSt.getNumber());
        holder.tvYear.setText(carSt.getYear());
        holder.tvKm.setText(carSt.getKm());
        holder.tvExLicense.setText(carSt.getExLicense());
        holder.tvExInsurance.setText(carSt.getExInsurance());
        holder.tvTransmission.setText(carSt.getTransmission());
        holder.tvSchool.setText(carSt.getSchool());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder  {

        TextView tvModel,tvNumber,tvYear,tvKm,tvExLicense,tvExInsurance,tvTransmission,tvSchool;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);

            tvModel=itemView.findViewById(R.id.etModel);
            tvNumber=itemView.findViewById(R.id.etNumber);
            tvYear=itemView.findViewById(R.id.etYear);
            tvKm=itemView.findViewById(R.id.etKm);
            tvExLicense=itemView.findViewById(R.id.etExLicense);
            tvExInsurance=itemView.findViewById(R.id.etExInsurance);
            tvTransmission=itemView.findViewById(R.id.etTransmission);
            tvSchool=itemView.findViewById(R.id.etSchool);


        }
    }
}
