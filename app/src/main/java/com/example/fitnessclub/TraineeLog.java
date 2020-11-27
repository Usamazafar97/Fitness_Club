package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TraineeLog extends AppCompatActivity {

    Button makeReservation;
    Button cancelReservation;
    Button bookTrainer;
    Button viewSession;
    Button viewSchedule;
    Button giveFeedback;
    Button sign_out;

    private FirebaseAuth.AuthStateListener m_AuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainee_log);


    makeReservation = findViewById(R.id.make_reservation);
        makeReservation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), MakeReservation.class);
            startActivity(i);

        }
    });
        cancelReservation = findViewById(R.id.cancel_reservation);
        cancelReservation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), CancelReservation.class);
            startActivity(i);

        }
    });
        bookTrainer = findViewById(R.id.book_trainer);
        bookTrainer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), BookTrainer.class);
            startActivity(i);

        }
    });
        viewSession = findViewById(R.id.view_session);
        viewSession.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), AttendedSessions.class);
            startActivity(i);

        }
    });
        viewSchedule = findViewById(R.id.view_schedule);
        viewSchedule.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), ViewSchedule.class);
            startActivity(i);

        }
    });
        giveFeedback = findViewById(R.id.give_feedback);
        giveFeedback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(TraineeLog.this, "Hello", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getApplicationContext(), Feedback.class);
            startActivity(i);

        }
    });

        sign_out = findViewById(R.id.sign_out);

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(TraineeLog.this,LogIn.class);
                startActivity(intent);

            }
        });

    }
}