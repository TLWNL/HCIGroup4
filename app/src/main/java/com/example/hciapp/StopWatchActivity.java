package com.example.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button start, stop;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        start = findViewById(R.id.btnstart);
        stop = findViewById(R.id.btnstop);
        final ImageView anchor = findViewById(R.id.ic_anchor);
        timer = findViewById(R.id.timer);

        stop.setAlpha(0);

        final Animation roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        start.setTypeface(MMedium);
        stop.setTypeface(MMedium);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor.startAnimation(roundingalone);
                stop.animate().alpha(1).translationY(-80).setDuration(300).start();
                start.animate().alpha(0).setDuration(300).start();
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
    }
}