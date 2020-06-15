package com.example.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WorkoutActivity extends AppCompatActivity {

    TextView btnexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        btnexercise = (TextView) findViewById(R.id.btnexercise);

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(WorkoutActivity.this, StartWorkoutActivity.class);
                start.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(start);
            }
        });
    }
}