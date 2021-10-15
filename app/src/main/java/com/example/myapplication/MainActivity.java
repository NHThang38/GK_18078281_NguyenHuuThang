package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private MyService myService;
    private boolean isBound = false;
    private ServiceConnection serviceConnection;
    private boolean isConnected;

    ImageView play, prev, next, imageView, imgXoay;
    TextView songTitle, songSinger;
    SeekBar mSeekBarTime, mSeekBarVol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.Play);

        imgXoay = findViewById(R.id.imageView7);
        connectService();
        Animation xoay = AnimationUtils.loadAnimation(this, R.anim.xoay);
        imgXoay.startAnimation(xoay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myService.mp != null && myService.mp.isPlaying()) {
                    myService.Tnghenhac();

                    play.setImageResource(R.drawable.phat);
                } else {

                    myService.nghenhac();
                    play.setImageResource(R.drawable.dunglai);
                    isBound = false;

                }
            }
        });


    }
    private void connectService() {

        Intent intent = new Intent(this, MyService.class);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder myBinder = (MyService.MyBinder) service;

                myService = myBinder.getService();
                isConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isConnected = false;
                myService = null;
            }
        };
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }
}