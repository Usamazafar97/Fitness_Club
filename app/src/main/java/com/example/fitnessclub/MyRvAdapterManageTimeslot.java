package com.example.fitnessclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyRvAdapterManageTimeslot extends RecyclerView.Adapter<MyRvAdapterManageTimeslot.MyViewHolder> {
    List<ManageTimeSlotData> ls;
    Context c;

    public MyRvAdapterManageTimeslot(List<ManageTimeSlotData> ls, Context c) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyRvAdapterManageTimeslot.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.manage_timeslot_row, parent, false);
        return new MyViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRvAdapterManageTimeslot.MyViewHolder holder, final int position) {
        holder.name.setText(ls.get(position).getName());
        holder.time.setText(ls.get(position).getTime());
        holder.rowww.setOnClickListener(new View.OnClickListener() {
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
        TextView name, time;
        LinearLayout rowww;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            rowww = itemView.findViewById(R.id.row);
        }
    }
}

