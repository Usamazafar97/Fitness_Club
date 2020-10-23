package com.example.fitnessclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    TextView signUp;
    TextView logInAdmin;
    TextView logInTrainee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        signUp = findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "Hello", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);

            }
        });

        logInTrainee = findViewById(R.id.login_trainee);
        logInTrainee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "Hello", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), TraineeLog.class);
                startActivity(i);

            }
        });

        logInAdmin = findViewById(R.id.login_admin);
        logInAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "Hello", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), AdminLog.class);
                startActivity(i);

            }
        });


    }
}