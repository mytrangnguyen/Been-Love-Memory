package com.example.beenlove;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.widget.Button;


public class setUp extends AppCompatActivity {

    TextView edtBoy, edtGirl, totalDays, dateOfLove, tvTotalDays;
    Button btnYear, btnMonth, btnDay, btnMinute, btnHour, btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        edtBoy = findViewById(R.id.nameBoy);
        edtGirl = findViewById(R.id.nameGirl);
        dateOfLove = findViewById(R.id.DateOfLove);
        totalDays = findViewById(R.id.totalDays);
        getName(edtBoy, edtGirl);
        btnYear = findViewById(R.id.btnYear);
    }

    public void getName(TextView edtBoy, TextView edtGirl) {
        try {
            Intent intent = getIntent();
            String namBoy = intent.getStringExtra("Name_Boy");
            String namGirl = intent.getStringExtra("Name_Girl");
            String dateLove = intent.getStringExtra("Date_Love");
            dateOfLove.setText(dateLove);
            edtBoy.setText(namBoy);
            edtGirl.setText(namGirl);
            btnYear = findViewById(R.id.btnYear);
            btnMonth = findViewById(R.id.btnMonth);
            btnDay = findViewById(R.id.btnDay);
            btnHour = findViewById(R.id.btnHour);
            btnMinute = findViewById(R.id.btnMinute);
            btnSecond = findViewById(R.id.btnSecond);



            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentDate = new Date();
            dateFormat.format(currentDate);
            Date oldDate = dateFormat.parse(dateLove);

            long days = (currentDate.getTime() - oldDate.getTime()) / (24 * 3600 * 1000);
            long year = ((currentDate.getTime() - oldDate.getTime()) / (24 * 3600 * 1000)) / 365;
            long month = (((currentDate.getTime() - oldDate.getTime()) / (24 * 3600 * 1000)) % 365) / 30;
            long day = (((currentDate.getTime() - oldDate.getTime()) / (24 * 3600 * 1000)) % 365) % 30;
            long hours = ((currentDate.getTime() - oldDate.getTime()) / (3600 * 1000)) % 24;
            long minute = ((currentDate.getTime() - oldDate.getTime()) / (60 * 1000)) % 60;
            long second = ((currentDate.getTime() - oldDate.getTime()) / 1000) % 60;

            totalDays.setText(String.valueOf(days));
            btnYear.setText(String.valueOf(year));
            btnMonth.setText(String.valueOf(month));
            btnDay.setText(String.valueOf(day));
            btnHour.setText(String.valueOf(hours));
            btnMinute.setText(String.valueOf(minute));
            btnSecond.setText(String.valueOf(second));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }




}
