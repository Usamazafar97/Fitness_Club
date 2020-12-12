package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fitnessclub.Model.ManageTimeSlotData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTimeslot extends AppCompatActivity {
    Button add;
    EditText name,start_time,end_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timeslot);

        name=findViewById(R.id.name);
        start_time=findViewById(R.id.start_time);
        end_time=findViewById(R.id.end_time);

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Timeslots");

                myRef.push().setValue(new ManageTimeSlotData(name.getText().toString(),start_time.getText().toString(),end_time.getText().toString()));

                Intent intent = new Intent(AddTimeslot.this,ManageTimeslot.class);
                startActivity(intent);
            }
        });
    }
}