package com.example.forcal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView9, textView10, textView11;
    private Button button5;
    private TextClock textClock;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        button5 = findViewById(R.id.button5);
        textClock = findViewById(R.id.textClock);
        textClock.setFormat12Hour("hh:mm:ss a");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
                String timeString = dateFormat.format(new Date()).toString();
                int tH = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                int th = 0;
                   if(tH<=12){
                       th = tH;
                   }
                   else {
                      th = tH - 12;
                   }
                int tm = Calendar.getInstance().get(Calendar.MINUTE);
                int ts = Calendar.getInstance().get(Calendar.SECOND);
                double d = Math.pow(tm,3) + ts;
                int n = factorial(th);
                double spi = (n/d);
                DecimalFormat df = new DecimalFormat("###.###");
                textView11.setText("The Current time taken is : " + timeString);
                textView10.setText("Corresponding Spi Factor is : " + df.format(spi));
            }
        });
    }
    public int factorial(int n){
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}