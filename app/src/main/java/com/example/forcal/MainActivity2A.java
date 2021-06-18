package com.example.forcal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity2A extends AppCompatActivity {
    Vibrator vibe;
    ConstraintLayout layout2A;
    private Button button4, button6;
    private TextView textView4,textView3, textView5, textView6;
    private EditText editTextA, editTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        button4 = findViewById(R.id.button4);
        button6 = findViewById(R.id.button6);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        layout2A = findViewById(R.id.layout2A);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = editTextA.getText().toString();
                String clf = editTextB.getText().toString();
                double clfd = Double.parseDouble(clf);
                double velocityA = Double.parseDouble(s1);
                double velA = velocityA * Math.pow(10, 8);
                double velA2 = Math.pow(velA, 2);
                double cA = 3 * Math.pow(10, 8);
                double cA2 = Math.pow(cA, 2);
                double dA = Math.sqrt(1 - (velA2 / cA2));
                double lA = (1 / dA);
                DecimalFormat dfA = new DecimalFormat("###.##");
                double lfA = Double.parseDouble(dfA.format(lA));
                if (velocityA < 3) {
                    if (lfA == clfd) {
                        textView5.setText("Well Done!, Correct Answer");
                        layout2A.setBackgroundColor(Color.parseColor("#00FF00"));
                        button6.setVisibility(View.VISIBLE);
                        button4.setVisibility(View.INVISIBLE);
                        button6.setText("Once more!");
                        textView4.setText("Value of 'v'");
                        textView3.setText("Calculated Lorentz Value");
                        textView4.setTextColor(Color.parseColor("White"));
                        textView3.setTextColor(Color.parseColor("White"));
                    } else {
                        textView5.setTextColor(Color.parseColor("#FFFF00"));
                        textView6.setTextColor(Color.parseColor("#00FF00"));
                        textView5.setText("Hard Luck! Incorrect Answer");
                        textView6.setText("The Correct Value is : " + lfA);
                        layout2A.setBackgroundColor(Color.parseColor("#FF0000"));
                        vibe.vibrate(200);
                        button6.setVisibility(View.VISIBLE);
                        button4.setVisibility(View.INVISIBLE);
                        button6.setText("Try Again!");
                        textView4.setText("Value of 'v'");
                        textView3.setText("Calculated Lorentz Value");
                        textView4.setTextColor(Color.parseColor("White"));
                        textView3.setTextColor(Color.parseColor("White"));
                    }
                } else {
                    Toast.makeText(MainActivity2A.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity2A.this, "a < 3", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
    }
//    public static void restartActivity(Activity activity) {
//        activity.recreate();
//    }
//
}