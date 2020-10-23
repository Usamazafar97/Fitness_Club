package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ReservationInfo extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<ReservationInfoData> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_info);

        contacts = new ArrayList<>();
        contacts.add(new ReservationInfoData("Noor Saqib"  , "GOLD Membersip"  , "Start: 25th aug, 2020" , "End: 25th dec, 2020"  , R.drawable.ic_trophy_gold));
        contacts.add(new ReservationInfoData("Sami Bukhari", "BRONZE Membersip", "Start: 25th oct, 2020" , "End: 25th nov, 2020"  , R.drawable.ic_trophy_bronze));
        contacts.add(new ReservationInfoData("Sohail Ahmed", "SILVER Membersip", "Start: 25th jul, 2020" , "End: 25th oct, 2020"  , R.drawable.ic_trophy_silver));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterReservationInfo adapter = new MyRvAdapterReservationInfo(contacts, this);
        rv.setAdapter(adapter);
    }
}