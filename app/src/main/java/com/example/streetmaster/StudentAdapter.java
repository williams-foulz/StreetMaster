package com.example.streetmaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private StudentsFragment context;
    private ArrayList<Student> studentList;
    private int currentposition;

    public StudentAdapter(StudentsFragment context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_in_list, parent, false);
        StudentViewHolder holder = new StudentViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Student std = studentList.get(position);

        holder.tvStudentFullName.setText(std.getStdFname() + " " + std.getStdLname());
        holder.tvStudentFullName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // student in position
                currentposition = position;
                notifyDataSetChanged();
            }
        });
        // show / hide buttons on click
        if (currentposition == position) {
            holder.tvStudentFullName.setBackgroundColor(Color.parseColor("#2196F3"));
            holder.imgStudentInfo.setVisibility(View.VISIBLE);
            holder.imgStudentCard.setVisibility(View.VISIBLE);
            holder.imgStudentLesson.setVisibility(View.VISIBLE);

        } else {
            holder.tvStudentFullName.setBackgroundColor(Color.TRANSPARENT);
            holder.imgStudentInfo.setVisibility(View.GONE);
            holder.imgStudentCard.setVisibility(View.GONE);
            holder.imgStudentLesson.setVisibility(View.GONE);

        }

        // on-click student info dialog
        holder.imgStudentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(context.getContext());
                builder.setTitle("Student info");
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.setView(R.layout.fragment_student_info);
                //negative btn to go back
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog = builder.create();
                dialog.show();
                dialog.getWindow().setLayout(-1,2000);

                // find view by id in dialog
                TextView tvStuFname = dialog.findViewById(R.id.tvStuFname);
                TextView tvStuLname = dialog.findViewById(R.id.tvStuLname);
                TextView tvStuId = dialog.findViewById(R.id.tvStuId);
                TextView tvStuMobile = dialog.findViewById(R.id.tvStuMobile);
                TextView tvStuAdress = dialog.findViewById(R.id.tvStuAdress);
                TextView tvStuRank = dialog.findViewById(R.id.tvStuRank);
                TextView tvStuMedicalDate = dialog.findViewById(R.id.tvStuMedicalDate);
                TextView tvStuBeginDate = dialog.findViewById(R.id.tvStuBeginDate);
                TextView tvStuTestDate = dialog.findViewById(R.id.tvStuTestDate);
                TextView tvStuEyesDate = dialog.findViewById(R.id.tvStuEyesDate);
                TextView tvStuGlasses = dialog.findViewById(R.id.tvStuGlasses);

                // fill the student data
                tvStuFname.setText(std.getStdFname());
                tvStuLname.setText(std.getStdLname());
                tvStuId.setText(std.getStdId());
                tvStuMobile.setText(std.getStdPhone());
                tvStuAdress.setText(std.getStdAdress());
                tvStuRank.setText(std.getStdLicenseRank());
                tvStuMedicalDate.setText(std.getStdMedicalConfirmationDate());
                tvStuBeginDate.setText(std.getStdStartDate());
                tvStuTestDate.setText(std.getStdTestDate());
                tvStuEyesDate.setText(std.getStdEyesDate());
                tvStuGlasses.setText(std.getStdGlasses());


            }
        });


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView tvStudentFullName;
        ImageView imgStudentInfo, imgStudentCard, imgStudentLesson;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStudentFullName = itemView.findViewById(R.id.tvStudentFullName);
            imgStudentInfo = itemView.findViewById(R.id.imgStudentInfo);
            imgStudentInfo.setVisibility(View.GONE);
            imgStudentCard = itemView.findViewById(R.id.imgStudentCard);
            imgStudentCard.setVisibility(View.GONE);
            imgStudentLesson = itemView.findViewById(R.id.imgStudentLesson);
            imgStudentLesson.setVisibility(View.GONE);
        }
    }
}
