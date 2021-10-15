package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView play, prev, next, imageView, imgXoay;
    TextView songTitle, songSinger;
    SeekBar mSeekBarTime, mSeekBarVol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgXoay = findViewById(R.id.imageView7);

        Animation xoay = AnimationUtils.loadAnimation(this, R.anim.xoay);
        imgXoay.startAnimation(xoay);
    }
}