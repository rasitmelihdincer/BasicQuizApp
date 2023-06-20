package com.rasit_melih_dincerr.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.rasit_melih_dincerr.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SplashActivity extends AppCompatActivity {

    private Button bttn;
    private Button bttn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bttn = (Button)findViewById(R.id.button4);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, CategoriesActivitiy.class);
                startActivity(intent);
            }

        });

         bttn2 = (Button)findViewById(R.id.button5);
         bttn2.setOnClickListener( new View.OnClickListener(){
             public void onClick(View v) {
                 Intent intent = new Intent(SplashActivity.this, RulesActivity.class);
                 startActivity(intent);
             }
         });



}}