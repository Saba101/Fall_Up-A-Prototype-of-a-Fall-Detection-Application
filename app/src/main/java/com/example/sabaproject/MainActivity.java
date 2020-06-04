package com.example.sabaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button btnNext;
    private String userType;
    private boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();

    }

    private void init() {
        btnNext = findViewById(R.id.btn_main_next);
    }

    private void initListener() {
        btnNext.setOnClickListener(this);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_main_user:
                if (checked) {
                    userType = "user";
                    Toast.makeText(getApplicationContext(), "user", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.rb_main_guardian:
                if (checked) {
                    userType = "guardian";
                    Toast.makeText(getApplicationContext(), "guardian", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_next:
                if (checked) {
                    if (userType.equals("user")) {
                        intent = new Intent(getApplicationContext(), MonitorActivity.class);
                        startActivity(intent);
                    } else if (userType.equals("guardian")) {
                        intent = new Intent(getApplicationContext(), GuardianActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error: select radio button", Toast.LENGTH_SHORT).show();
                }

                break;

            default:
                break;
        }
    }
}
