package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView code_tv, output_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        code_tv = findViewById(R.id.code);
        output_tv = findViewById(R.id.output);

        String code = getIntent().getStringExtra("code");
        String output = getIntent().getStringExtra("output");

        code_tv.setText(code);
        output_tv.setText(output);
    }
}