package com.example.forcal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openActivity2(View view){
//        Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this,MainActivity2.class);
        startActivity(intent1);
    }
    public void openActivity3(View view) {
//        Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(this, MainActivity3.class);
        startActivity(intent2);
    }
}