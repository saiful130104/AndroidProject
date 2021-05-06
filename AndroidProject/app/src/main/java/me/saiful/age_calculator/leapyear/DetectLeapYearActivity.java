package me.saiful.age_calculator.leapyear;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import me.saiful.age_calculator.R;
import me.saiful.age_calculator.agecalculate.AgeCalculateActivity;

@SuppressLint("SetTextI18n")
public class DetectLeapYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_leap_year);
        EditText yearTxt = (EditText) findViewById(R.id.target_year);
        TextView resultTxt = (TextView) findViewById(R.id.resultLeapYear);
        Button checkLeapYearBtn = (Button) findViewById(R.id.checkLeapYearBtn);
        checkLeapYearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputYear = yearTxt.getText().toString();
                if(inputYear.isEmpty()){
                    Toast.makeText(DetectLeapYearActivity.this, "Please input any year.", Toast.LENGTH_LONG).show();
                }
                else{
                    int year = Integer.parseInt(inputYear);
                    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
                        resultTxt.setText(year + " is a Leap Year.");
                    }
                    else resultTxt.setText(year + " is not a Leap Year.");
                }
            }
        });
    }
}