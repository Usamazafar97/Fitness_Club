package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MakeReservation extends AppCompatActivity {

    Spinner membership_type;
    EditText starting_date,ending_date;
    Button reservation;

    FirebaseAuth m_firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);

        membership_type = (Spinner) findViewById(R.id.membership_type);
        starting_date =findViewById(R.id.starting_date);
        ending_date = findViewById(R.id.ending_date);
        reservation = findViewById(R.id.reservation);

        m_firebaseAuth =  FirebaseAuth.getInstance();

        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Trainees");
                String userId = m_firebaseAuth.getCurrentUser().getUid();

                String membership_type_temp = "Gold";
                membership_type_temp = String.valueOf(membership_type.getSelectedItem());

                myRef.child(userId).child("membershiptype").setValue(membership_type_temp);
                myRef.child(userId).child("membershipStartDate").setValue(starting_date.getText().toString());
                myRef.child(userId).child("membershipEndDate").setValue(ending_date.getText().toString());

                Intent intent = new Intent(MakeReservation.this,TraineeLog.class);

            }
        });
    }
}