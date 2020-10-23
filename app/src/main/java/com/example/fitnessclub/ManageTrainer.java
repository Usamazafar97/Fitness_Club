package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ManageTrainer extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<ManageTrainerData> contacts;

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
        contacts.add(new ManageTrainerData("Hafsa Saqib" , "03335109701" , "hafsa.saqib@nu.edu.pk"));
        contacts.add(new ManageTrainerData("Saqib Elahi" , "03335109701" , "saqib.elahi@nu.edu.pk"));
        contacts.add(new ManageTrainerData("Ayaan Saqib" , "03335109701" , "ayaan.saqib@nu.edu.pk"));
        contacts.add(new ManageTrainerData("Asad Bokhari", "03335109701" , "asad.bukhari@nu.edu.pk"));
        contacts.add(new ManageTrainerData("Nazia Ehsan" , "03335109701" , "nazia.ehsan@nu.edu.pk"));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterManageTrainer adapter = new MyRvAdapterManageTrainer(contacts, this);
        rv.setAdapter(adapter);
    }
}
