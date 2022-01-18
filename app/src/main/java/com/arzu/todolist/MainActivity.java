package com.arzu.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView ic_logo= findViewById(R.id.ic_logo);

        ic_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in));

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ic_logo.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.splash_out));
                Handler handle = new Handler(Looper.getMainLooper());

                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ic_logo.setVisibility(View.GONE);

                        Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                        startActivity(intent);
                    }
                },500);
            }
        },1500);
    }

}