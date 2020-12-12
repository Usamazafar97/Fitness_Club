package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.fitnessclub.Adapter.MyRvAdapterViewSchedule;

import java.util.ArrayList;
import java.util.List;


public class ViewSchedule extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<ViewSceduleData> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        contacts = new ArrayList<>();
        contacts.add(new ViewSceduleData("CARDIO", " 9:00 a.m - 14:00 p.m",R.drawable.ic_monday_calendar_page));
        contacts.add(new ViewSceduleData("RUNNING", "14:00 p.m - 17:00 p.m",R.drawable.ic_tuesday_daily_calendar_page));
        contacts.add(new ViewSceduleData("CARDIO", "17:00 p.m - 20:00 p.m",R.drawable.ic_wednesday_calendar_daily_page));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterViewSchedule adapter = new MyRvAdapterViewSchedule(contacts, this);
        rv.setAdapter(adapter);
    }
}
