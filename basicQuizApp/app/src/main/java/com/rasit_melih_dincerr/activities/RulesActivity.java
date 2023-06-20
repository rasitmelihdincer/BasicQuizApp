package com.rasit_melih_dincerr.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.rasit_melih_dincerr.R;

public class RulesActivity extends AppCompatActivity {

    private Button bttn3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_kurallar);


        bttn3 = (Button)findViewById(R.id.button5);
        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RulesActivity.this, CategoriesActivitiy.class);
                startActivity(intent);
            }

        });


}}
