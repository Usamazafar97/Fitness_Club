package com.example.fitnessclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyRvAdapterManageTrainee extends RecyclerView.Adapter<MyRvAdapterManageTrainee.MyViewHolder> {
    List<ManageTraineeData> ls;
    Context c;

    public MyRvAdapterManageTrainee(List<ManageTraineeData> ls, Context c) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyRvAdapterManageTrainee.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.manage_trainee_row, parent, false);
        return new MyViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRvAdapterManageTrainee.MyViewHolder holder, final int position) {
        holder.name.setText(ls.get(position).getName());
        holder.phno.setText(ls.get(position).getPhoneNo());
        holder.email.setText(ls.get(position).getEmail());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, phno, email;
        RelativeLayout row;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phno = itemView.findViewById(R.id.phno);
            email = itemView.findViewById(R.id.email);
            row = itemView.findViewById(R.id.row);
        }
    }
}

