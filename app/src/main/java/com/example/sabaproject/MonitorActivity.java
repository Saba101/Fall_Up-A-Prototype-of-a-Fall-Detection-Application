package com.example.sabaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MonitorActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button btnStopMonitoring;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        init();
        initListener();
        onFallDetection();

    }

    private void init() {
        btnStopMonitoring = findViewById(R.id.btn_monitor_stop);
    }

    private void initListener() {
        btnStopMonitoring.setOnClickListener(this);
    }

    private void onFallDetection() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), FallActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_monitor_stop:
                finish();
                break;

            default:
                break;
        }
    }
}
