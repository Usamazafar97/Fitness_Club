package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fitnessclub.Model.ManageTrainerData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.StringTokenizer;

public class BookTrainer extends AppCompatActivity {

    Button book;
    Spinner ExcerciseTypeSpinner,timeSpinner;

    FirebaseAuth m_firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trainer);

        ExcerciseTypeSpinner = (Spinner) findViewById(R.id.ExcerciseTypeSpinner);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        book = findViewById(R.id.book);

        m_firebaseAuth =  FirebaseAuth.getInstance();

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Trainees");
                String userId = m_firebaseAuth.getCurrentUser().getUid();

                String excerciseType = "Cardio-Squates-Lunges";
                excerciseType = String.valueOf(ExcerciseTypeSpinner.getSelectedItem());
                String timeslot = "0100-0200 pm";
                timeslot = String.valueOf(timeSpinner.getSelectedItem());

                String mon="";
                String tue="";
                String wed="";
                int count=0;

                StringTokenizer st = new StringTokenizer(excerciseType,"-");
                while (st.hasMoreTokens()) {
                    if(count==0) mon=st.nextToken();
                    if(count==1) tue=st.nextToken();
                    if(count==2) wed=st.nextToken();
                    count++;

                }

                myRef.child(userId).child("selectTimeSlot").setValue(timeslot);
                myRef.child(userId).child("mon_train").setValue(mon);
                myRef.child(userId).child("tue_train").setValue(tue);
                myRef.child(userId).child("wed_train").setValue(wed);
                myRef.child(userId).child("mon_attend").setValue("false");
                myRef.child(userId).child("tue_attend").setValue("false");
                myRef.child(userId).child("wed_attend").setValue("false");

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("Trainers");

                Intent intent = new Intent(BookTrainer.this, TraineeLog.class);
                startActivity(intent);
            }
        });

    }
}