package com.example.fitnessclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitnessclub.Adapter.MyRvAdapterViewSchedule;
import com.example.fitnessclub.Model.ViewSceduleData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ViewSchedule extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<ViewSceduleData> contacts;
    FirebaseUser user;
    String uid;
    DatabaseReference databaseReference;
    MyRvAdapterViewSchedule adapter;

    String monTrain="";
    String tueTrain="";
    String wedTrain="";
    String time="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        contacts = new ArrayList<>();

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("Trainees");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                monTrain = snapshot.child(uid).child("mon_train").getValue(String.class);
                tueTrain = snapshot.child(uid).child("tue_train").getValue(String.class);
                wedTrain = snapshot.child(uid).child("wed_train").getValue(String.class);
                time = snapshot.child(uid).child("selectTimeSlot").getValue(String.class);

                contacts.add(new ViewSceduleData(monTrain, time,R.drawable.ic_monday_calendar_page));
                contacts.add(new ViewSceduleData(tueTrain, time,R.drawable.ic_tuesday_daily_calendar_page));
                contacts.add(new ViewSceduleData(wedTrain, time,R.drawable.ic_wednesday_calendar_daily_page));

                //contacts.setNoti
                adapter.setContactList(contacts);

                Toast.makeText(ViewSchedule.this, monTrain + tueTrain + wedTrain + time, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new MyRvAdapterViewSchedule(contacts, this);
        rv.setAdapter(adapter);
    }
}
