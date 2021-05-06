package me.saiful.age_calculator.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.saiful.age_calculator.R;
import me.saiful.age_calculator.agecalculate.AgeCalculateActivity;
import me.saiful.age_calculator.leapyear.DetectLeapYearActivity;
import me.saiful.age_calculator.splash.SplashActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ageBtn = (Button) findViewById(R.id.ageBtn);
        Button leapYearBtn = (Button) findViewById(R.id.leapYearBtn);

        ageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AgeCalculateActivity.class));
            }
        });

        leapYearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetectLeapYearActivity.class));
            }
        });

    }
}