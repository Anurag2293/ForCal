package com.example.forcal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                double velocity = Double.parseDouble(s);
                double vel = velocity * Math.pow(10,8);
                double vel2 = Math.pow(vel,2);
                double c = 3 * Math.pow(10,8);
                double c2 = Math.pow(c,2);
                double d = Math.sqrt(1 - (vel2/c2));
                double l = (1/d);
                DecimalFormat df = new DecimalFormat("###.##");
                if(velocity < 3){
                    textView.setText("The corresponding Lorentz Factor is " + df.format(l));
//                    editText.setHint("Enter Here");
                }
                else{
                    Toast.makeText(MainActivity2.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity2.this, "a < 3", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void openActivity2A(View view){
        Intent Intent2A = new Intent(this, MainActivity2A.class);
        startActivity(Intent2A);
    }
}