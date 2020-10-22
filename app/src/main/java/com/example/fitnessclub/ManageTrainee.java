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


public class ManageTrainee extends AppCompatActivity {
    RecyclerView rv;
    Button add;
    List<ManageTraineeData> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_trainee);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ManageTrainee.this, "floatng button Clicked", Toast.LENGTH_LONG).show();
            }
        });
        contacts = new ArrayList<>();
        contacts.add(new ManageTraineeData("Noor Saqib"    , "03335109701" , "Noor.saqib@nu.edu.pk"));
        contacts.add(new ManageTraineeData("Zara Akhtar"   , "03335109701" , "Zara.akhtar@nu.edu.pk"));
        contacts.add(new ManageTraineeData("Sohail Ahmed"  , "03335109701" , "Sohail.ahmed@nu.edu.pk"));
        contacts.add(new ManageTraineeData("Sami Bokhari"  , "03335109701" , "Sami.bokhari@nu.edu.pk"));
        contacts.add(new ManageTraineeData("Altaf Hussain" , "03335109701" , "Altaf.hussain@nu.edu.pk"));

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        MyRvAdapterManageTrainee adapter = new MyRvAdapterManageTrainee(contacts, this);
        rv.setAdapter(adapter);
    }
}
