package com.example.fitnessclub.Edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessclub.Manage.ManageTrainee;
import com.example.fitnessclub.R;

public class EditTrainee extends AppCompatActivity {
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trainee);

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditTrainee.this, ManageTrainee.class);
                startActivity(intent);
            }
        });
    }
}