package com.example.fitnessclub.Manage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitnessclub.Adapter.MyRvAdapterManageTimeslot;
import com.example.fitnessclub.Add.AddTimeslot;
import com.example.fitnessclub.Edit.EditTimeslot;
import com.example.fitnessclub.Model.ManageTimeSlotData;
import com.example.fitnessclub.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManageTimeslot extends AppCompatActivity implements MyRvAdapterManageTimeslot.ManageTimeAdapterListen{
        RecyclerView rv;
        Button add;
        List<ManageTimeSlotData> contacts;
        MyRvAdapterManageTimeslot adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manage_timeslot);
            add=findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ManageTimeslot.this,"floatng button Clicked",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), AddTimeslot.class);
                    startActivity(i);
                }
            });



            contacts=new ArrayList<>();

            //here read from the database

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Timeslots");

            ChildEventListener childEventListener = myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                    ManageTimeSlotData c1 = dataSnapshot.getValue(ManageTimeSlotData.class);
//                Log.d("MainActivity","Name: " + c1.getName());
//                Log.d("MainActivity","Email: " + c1.getEmail());
//                Log.d("MainActivity","Phone number: " + c1.getPhno());
//                Log.d("MainActivity","Previous Post ID: " + prevChildKey);
//
//                Log.d("MainActivity","In database");
                    contacts.add(c1);
                    adapter.setContactList(contacts);
                }

                //added to the recycler list


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                    ManageTimeSlotData c1 = dataSnapshot.getValue(ManageTimeSlotData.class);
                    contacts.add(c1);
                    adapter.setContactList(contacts);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    ManageTimeSlotData c1 = dataSnapshot.getValue(ManageTimeSlotData.class);
                    contacts.add(c1);
                    adapter.setContactList(contacts);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });


//            contacts.add(new ManageTimeSlotData("Hafsa Saqib","9:00 a.m - 14:00 p.m" ));
//            contacts.add(new ManageTimeSlotData("Saqib Elahi","14:00 p.m - 17:00 p.m" ));
//            contacts.add(new ManageTimeSlotData("Ayaan Saqib","17:00 p.m - 20:00 p.m" ));
//            contacts.add(new ManageTimeSlotData("Asad Bokhari","20:00 p.m - 12:00 a.m"));
//            contacts.add(new ManageTimeSlotData("Nazia Ehsan","10:00 a.m - 13:00 p.m" ));

            rv=findViewById(R.id.rv);
            RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
            rv.setLayoutManager(lm);
            adapter = new MyRvAdapterManageTimeslot(contacts,this);
            rv.setAdapter(adapter);
        }

    @Override
    public void onItemDeleteClick(ManageTimeSlotData deletItem) {
        Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemEditClick(ManageTimeSlotData editItem) {
        Intent intent = new Intent(ManageTimeslot.this, EditTimeslot.class);
        startActivity(intent);
    }
}