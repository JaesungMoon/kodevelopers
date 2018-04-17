package com.jaesungmoon.javaproject;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    private int mCount = 0;
    private TextView mTextViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();


        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countUp();
                Toast.makeText(getApplicationContext(), "countUp Start!", Toast.LENGTH_SHORT).show();
            }
        });

        mTextViewCount = findViewById(R.id.textViewCount);
    }

    private void countUp() {
        ++mCount;
        if (mCount < 100 ) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    countUp();
                }
            }, 1000);
        } else {

        }
        mTextViewCount.setText(String.format("%02d", mCount));
    }
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void clickBtn(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                break;
            default:
                assert true;
                break;
        }
    }

}
