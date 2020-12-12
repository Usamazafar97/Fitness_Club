package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitnessclub.Adapter.MyRvAdapterManageTimeslot;
import com.example.fitnessclub.Adapter.MyRvAdapterManageTrainer;
import com.example.fitnessclub.Model.ManageTimeSlotData;
import com.example.fitnessclub.Model.ManageTrainerData;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ManageTrainer extends AppCompatActivity implements MyRvAdapterManageTrainer.ManageTimeAdapterListen {
    RecyclerView rv;
    Button add;
    List<ManageTrainerData> contacts;
    //List<String,String,String> contacts;

    MyRvAdapterManageTrainer adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_trainer);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManageTrainer.this, "floatng button Clicked", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), AddTrainer.class);
                startActivity(i);
            }
        });
        contacts = new ArrayList<>();

        System.out.println("before getting the data");
        Log.d("ManageTrainer","inbetween getting the data");


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Trainers");

        ChildEventListener childEventListener = myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                ManageTrainerData c1 = dataSnapshot.getValue(ManageTrainerData.class);

                System.out.println("inbetween getting the data");
                Log.d("ManageTrainer","inbetween getting the data");
                //Toast.makeText(ManageTrainer.this, c1.getName() + c1.getPhno() + c1.getEmail(), Toast.LENGTH_SHORT).show();
//                Log.d("MainActivity","Name: " + c1.getName());
//                Log.d("MainActivity","Email: " + c1.getEmail());
//                Log.d("MainActivity","Phone number: " + c1.getPhno());
//                Log.d("MainActivity","Previous Post ID: " + prevChildKey);
//
//                Log.d("MainActivity","In database");
                //contacts.add(c1);
                contacts.add(new ManageTrainerData(c1.getName() , c1.getPhno() , c1.getEmail()));
                adapter.setContactList(contacts);
            }

            //added to the recycler list


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                ManageTrainerData c1 = dataSnapshot.getValue(ManageTrainerData.class);
                contacts.add(new ManageTrainerData(c1.getName() , c1.getPhno() , c1.getEmail()));
                adapter.setContactList(contacts);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                ManageTrainerData c1 = dataSnapshot.getValue(ManageTrainerData.class);
                contacts.add(new ManageTrainerData(c1.getName() , c1.getPhno() , c1.getEmail()));
                adapter.setContactList(contacts);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        System.out.println("after getting the data");


//        contacts.add(new ManageTrainerData("Hafsa Saqib" , "03335109701" , "hafsa.saqib@nu.edu.pk"));
//        contacts.add(new ManageTrainerData("Saqib Elahi" , "03335109701" , "saqib.elahi@nu.edu.pk"));
//        contacts.add(new ManageTrainerData("Ayaan Saqib" , "03335109701" , "ayaan.saqib@nu.edu.pk"));
//        contacts.add(new ManageTrainerData("Asad Bokhari", "03335109701" , "asad.bukhari@nu.edu.pk"));
//        contacts.add(new ManageTrainerData("Nazia Ehsan" , "03335109701" , "nazia.ehsan@nu.edu.pk"));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new MyRvAdapterManageTrainer(contacts, this, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemDeleteClick(ManageTrainerData deletItem) {
        Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemEditClick(ManageTrainerData editItem) {
        Intent intent = new Intent(ManageTrainer.this,EditTrainer.class);
        startActivity(intent);
    }
}
