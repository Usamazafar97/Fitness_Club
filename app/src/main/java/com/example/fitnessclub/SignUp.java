package com.example.fitnessclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText email, password;
    TextView sign_up;
    TextView sign_in_option;
    FirebaseAuth m_firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sign_up = findViewById(R.id.register);
        sign_in_option = findViewById(R.id.sign_in);

        m_firebaseAuth =  FirebaseAuth.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp_email = email.getText().toString();
                String temp_password = password.getText().toString();

                if (temp_email.isEmpty()){
                    email.setError("please enter the email");
                    email.requestFocus();
                }

                if (temp_password.isEmpty()){
                    password.setError("please enter the password");
                    password.requestFocus();
                }
                else if (temp_email.isEmpty() && temp_password.isEmpty()){
                    Toast.makeText(SignUp.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(temp_email.isEmpty() && temp_password.isEmpty())){
                    m_firebaseAuth.createUserWithEmailAndPassword(temp_email,temp_password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(SignUp.this, "SignUp unsuccessfull, Please try again", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(SignUp.this,LogIn.class));

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUp.this, "Error occured!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sign_in_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LogIn.class);
                startActivity(intent);

            }
        });


    }
}