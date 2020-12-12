package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.fitnessclub.Adapter.MyRvAdapterTransectionInfo;

import java.util.ArrayList;
import java.util.List;


public class TransectionInfo extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<TransectionInfoData> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transection_info);

        contacts = new ArrayList<>();
        contacts.add(new TransectionInfoData("Noor Saqib"  , "id: 2382482928373","Paid", R.drawable.ic_tick_sign));
        contacts.add(new TransectionInfoData("Sami Bukhari", "id: 2382482928373","Not Paid", R.drawable.ic_warning_sign));
        contacts.add(new TransectionInfoData("Sohail Ahmed", "id: 2382482928373","Paid", R.drawable.ic_tick_sign));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterTransectionInfo adapter = new MyRvAdapterTransectionInfo(contacts, this);
        rv.setAdapter(adapter);
    }
}