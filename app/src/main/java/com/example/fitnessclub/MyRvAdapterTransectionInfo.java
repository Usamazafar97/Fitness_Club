package com.example.fitnessclub;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class MyRvAdapterTransectionInfo extends RecyclerView.Adapter<MyRvAdapterTransectionInfo.MyViewHolder> {
    List<TransectionInfoData> ls;
    Context c;

    public MyRvAdapterTransectionInfo(List<TransectionInfoData> ls, Context c) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyRvAdapterTransectionInfo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.transection_info_row, parent, false);
        return new MyRvAdapterTransectionInfo.MyViewHolder(itemrow);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyRvAdapterTransectionInfo.MyViewHolder holder, final int position) {
        holder.id.setText(ls.get(position).getId());
        holder.status.setText(ls.get(position).getStatus());
        holder.name.setText(ls.get(position).getName());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivPic.setImageDrawable(c.getDrawable(ls.get(position).getPic()));
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, id, status;
        RelativeLayout row;
        ImageView ivPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            status = itemView.findViewById(R.id.status);
            row = itemView.findViewById(R.id.row);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}

