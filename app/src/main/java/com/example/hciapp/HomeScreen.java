package com.example.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class HomeScreen extends AppCompatActivity {

    @Override

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        CircleMenu menu = (CircleMenu) findViewById(R.id.circleMenu);
        menu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_menu, R.drawable.ic_remove)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_facebook)
                .addSubMenu(Color.parseColor("#6d4c41"), R.drawable.ic_mentalhealth)
                .addSubMenu(Color.parseColor("#03a9f4"), R.drawable.ic_sports)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.ic_stopwatch)
                .addSubMenu(Color.parseColor("#5dbcd2"), R.drawable.button_ok)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch(index) {
                            case 0: startActivity(new Intent(HomeScreen.this, FirstActivity.class)); break;
                            case 1: startActivity(new Intent(HomeScreen.this, MentalHealthActivity.class)); break;
                            case 2: startActivity(new Intent(HomeScreen.this, WorkoutActivity.class)); break;
                            case 3: startActivity(new Intent(HomeScreen.this, StopWatchActivity.class)); break;
                            case 4: startActivity(new Intent(HomeScreen.this, ToDoActivity.class)); break;
                        }
                    }
                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
            @Override
            public void onMenuOpened() {

            }

            @Override
            public void onMenuClosed() {

            }
        });
    }
}