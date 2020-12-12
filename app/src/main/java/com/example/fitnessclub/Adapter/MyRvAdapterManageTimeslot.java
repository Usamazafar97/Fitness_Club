package com.example.fitnessclub.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessclub.Model.ManageTimeSlotData;
import com.example.fitnessclub.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class MyRvAdapterManageTimeslot extends RecyclerView.Adapter<MyRvAdapterManageTimeslot.MyViewHolder> {
    List<ManageTimeSlotData> ls;
    Context c;
    ManageTimeAdapterListen listener;

    public MyRvAdapterManageTimeslot(List<ManageTimeSlotData> ls, Context c) {
        this.c = c;
        this.ls = ls;
        this.listener= listener;
    }

    @NonNull
    @Override
    public MyRvAdapterManageTimeslot.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.manage_timeslot_row, parent, false);
        return new MyViewHolder(itemrow);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyRvAdapterManageTimeslot.MyViewHolder holder, final int position) {

        final ManageTimeSlotData currentItem =ls.get(position);

        holder.end_time.setText(currentItem.getEnd_time());
        holder.start_time.setText(currentItem.getStartTime());
        holder.name.setText(currentItem.getName());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, position + "", Toast.LENGTH_SHORT).show();
            }
        });



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemEditClick(currentItem);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemDeleteClick(currentItem);
            }
        });

//        holder.ivPic.setImageDrawable(c.getDrawable(ls.get(position).getPic()));
    }

    public void setContactList( List<ManageTimeSlotData> contactList){
        // ls.clear();
        ls = contactList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, start_time,end_time;
        ImageView delete,edit;
        RelativeLayout row;
//        ImageView ivPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
            row = itemView.findViewById(R.id.row);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
//            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }

    public interface  ManageTimeAdapterListen{
        void onItemDeleteClick(ManageTimeSlotData deletItem);
        void onItemEditClick(ManageTimeSlotData editItem);
    }
}

