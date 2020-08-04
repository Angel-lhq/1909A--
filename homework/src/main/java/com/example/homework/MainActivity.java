package com.example.homework;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RingProgress ring1;
    private RingProgress ring2;
    private int time = 0;
    private int i = 0;
    private boolean isClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ring1 = findViewById(R.id.ring1);
        ring1.setValue("30");
        ring1.setCurrentPercent(0.3f);
        ring1.setOnClickListener(this);

        ring2 = findViewById(R.id.ring2);
        ring2.setValue("60");
        ring2.setCurrentPercent(0.6f);
        ring2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ring1:
                if (!isClick){
                    handler.postDelayed(runnable,200);
                    isClick = true;
                }
                break;
            case R.id.ring2:
                if (!isClick){
                    isClick = true;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (time<=100){
                                ring2.setValue(time+"");
                                ring2.setCurrentPercent(time*0.01f);
                                time++;
                            }else {
                                isClick = false;
                                time = 0;
                                timer.cancel();
                            }
                        }
                    },200,200);
                }
                break;
        }
    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ring1.setCurrentPercent(i*0.01f);
            ring1.setValue(i+"");
            i++;
            if (i<=100){
                handler.postDelayed(runnable,200);
            }else {
                i = 0;
                isClick = false;
            }
        }
    };
}