package com.example.sabaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FallActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button btnNeedHelp, btnOkay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall);
        init();
        initListener();

    }

    private void init() {
        btnNeedHelp = findViewById(R.id.btn_fall_need_help);
        btnOkay = findViewById(R.id.btn_fall_ok);
    }

    private void initListener() {
        btnNeedHelp.setOnClickListener(this);
        btnOkay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fall_need_help:
                Toast.makeText(getApplicationContext(), "Help needed", Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_fall_ok:
                Toast.makeText(getApplicationContext(), "Okay", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }
}
