package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ManageTimeslot extends AppCompatActivity {
        RecyclerView rv;
        Button add;
        List<ManageTimeSlotData> contacts;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manage_timeslot);
            add=findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ManageTimeslot.this,"floatng button Clicked",Toast.LENGTH_LONG).show();
                }
            });
            contacts=new ArrayList<>();
            contacts.add(new ManageTimeSlotData("Hafsa Saqib","9:00 a.m - 14:00 p.m" ));
            contacts.add(new ManageTimeSlotData("Saqib Elahi","14:00 p.m - 17:00 p.m" ));
            contacts.add(new ManageTimeSlotData("Ayaan Saqib","17:00 p.m - 20:00 p.m" ));
            contacts.add(new ManageTimeSlotData("Asad Bokhari","20:00 p.m - 12:00 a.m"));
            contacts.add(new ManageTimeSlotData("Nazia Ehsan","10:00 a.m - 13:00 p.m" ));

            rv=findViewById(R.id.rv);
            RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
            rv.setLayoutManager(lm);
            MyRvAdapterManageTimeslot adapter=new MyRvAdapterManageTimeslot(contacts,this);
            rv.setAdapter(adapter);
        }
    }