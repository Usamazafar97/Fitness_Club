package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitnessclub.Adapter.MyRvAdapterAttendedSession;
import com.example.fitnessclub.Model.AttentedSessionData;

import java.util.ArrayList;
import java.util.List;


public class AttendedSessions extends AppCompatActivity {
    RecyclerView rv;
    List<AttentedSessionData> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attended_sessions);
        contacts = new ArrayList<>();
        contacts.add(new AttentedSessionData("CARDIO", "9:00 a.m - 14:00 p.m"));
        contacts.add(new AttentedSessionData("RUNNING", "14:00 p.m - 17:00 p.m"));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterAttendedSession adapter = new MyRvAdapterAttendedSession(contacts, this);
        rv.setAdapter(adapter);
    }
}