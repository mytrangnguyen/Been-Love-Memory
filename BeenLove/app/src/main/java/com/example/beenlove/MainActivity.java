package com.example.beenlove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {

    Button btnGo, btnsetDate;
    EditText edtGirl, edtBoy;
    String nameBoy, nameGirl, dateLove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = findViewById(R.id.btnGo);
        edtBoy = findViewById(R.id.edtBoy);
        edtGirl = findViewById(R.id.edtGirl);
        btnsetDate = findViewById(R.id.btnsetDate);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondScreen();
            }
        });

       btnsetDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showDatePicker();
           }
       });
    }

    private void showDatePicker() {
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {

                btnsetDate = findViewById(R.id.btnsetDate);
                btnsetDate.setText(y + "-" + (m + 1) + "-" + d + " 00:00:00");
            }
        }, 2019, 10, 01);
        date.show();
    }

    private void openSecondScreen(){
        Intent intent = new Intent(MainActivity.this, setUp.class);
        nameBoy = edtBoy.getText().toString();

        nameGirl = edtGirl.getText().toString();
        dateLove = btnsetDate.getText().toString();
        intent.putExtra("Name_Boy", nameBoy);
        intent.putExtra("Name_Girl", nameGirl);
        intent.putExtra("Date_Love",dateLove);
        startActivity(intent);
    }
}
