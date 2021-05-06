package me.saiful.age_calculator.agecalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;

import me.saiful.age_calculator.R;

public class AgeCalculateActivity extends AppCompatActivity {

    int birthDay,birthMonth,birthYear;
    int currentDay,currentMonth,currentYear;
    int ageDay,ageMonth,ageYear;
    String storedBirthDate="",storedCurrentDate="";
    TextView finalResultTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculate);
        TextView birthDate = (TextView) findViewById(R.id.birthDate);
        finalResultTv = (TextView) findViewById(R.id.resultTv);
        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(AgeCalculateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                birthDay = dayOfMonth;
                                birthMonth = monthOfYear+1;
                                birthYear = year;
                                storedBirthDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                birthDate.setText(storedBirthDate);

                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());;
                datePickerDialog.show();
            }
        });

        TextView currentDate = (TextView) findViewById(R.id.currentDate);
        currentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog datePickerDialog1 = new DatePickerDialog(AgeCalculateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                currentDay = dayOfMonth;
                                currentMonth = monthOfYear+1;
                                currentYear = year;
                                storedCurrentDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                currentDate.setText(storedCurrentDate);

                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                datePickerDialog1.getDatePicker().setMaxDate(new Date().getTime());;
                datePickerDialog1.show();
            }
        });

        ImageButton calculateBtn = (ImageButton)findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (storedBirthDate.equals("") && storedCurrentDate.equals("")){
                    Toast.makeText(AgeCalculateActivity.this, "Please select required dates.", Toast.LENGTH_LONG).show();
                }else if (storedBirthDate.equals(""))
                    Toast.makeText(AgeCalculateActivity.this, "Please select Birth Date.", Toast.LENGTH_LONG).show();
                else if(storedCurrentDate.equals(""))
                    Toast.makeText(AgeCalculateActivity.this, "Please select Age at the Date of.", Toast.LENGTH_LONG).show();
                else{
                    ageDay = currentDay - birthDay;
                    boolean borrowed = is_borrowed(currentDay , birthDay);
                    if (borrowed){
                        ageDay+=30;
                        currentMonth -= 1;
                    }
                    ageMonth = currentMonth-birthMonth;
                    borrowed = is_borrowed(currentMonth,birthMonth);
                    if(borrowed){
                        ageMonth += 12;
                        currentYear -= 1;
                    }
                    ageYear = currentYear-birthYear;

                    if(ageYear <0 ){
                        Toast.makeText(AgeCalculateActivity.this,"Invalid date selection!! Please try again. Thank You.", Toast.LENGTH_LONG).show();
                    }
                    else{
                        String finalAge = "";
                        String year = " Year";
                        String day = " Day";
                        String month = " Month";
                        if(ageYear >0 ){
                            if(ageYear >1 )
                                year += "s";
                            finalAge = String.valueOf(ageYear) + year + " ";
                        }
                        if(ageMonth >0 || ageYear >0 ){
                            if(ageMonth >1 )
                                month += "s";
                            finalAge = finalAge + String.valueOf(ageMonth)+ month + " ";
                        }
                        finalAge = finalAge + String.valueOf(ageDay)+ day;
                        if(ageDay >1 )
                            finalAge += "s";
                        finalResultTv.setText("Age : "+finalAge);
                }



                    //Toast.makeText(AgeCalculateActivity.this, finalAge, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean is_borrowed(int current, int birth){
        if(current<birth){
            return true;
        }
        return false;
    }
}