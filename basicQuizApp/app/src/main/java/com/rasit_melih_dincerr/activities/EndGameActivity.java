package com.rasit_melih_dincerr.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rasit_melih_dincerr.R;
import com.rasit_melih_dincerr.utils.Constants;
import com.rasit_melih_dincerr.utils.PrefUtil;

public class EndGameActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAnasayfa, btnCikisYap;
    TextView txtKacinciSoru, txtToplamPuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonu);

        init();

        oyundanCikis();
    }

    private void init() {
        btnAnasayfa = findViewById(R.id.btnAnasayfayaDon);
        btnCikisYap = findViewById(R.id.buttonCikisYap);
        txtKacinciSoru = findViewById(R.id.txtSoruSayi);
        txtToplamPuan = findViewById(R.id.txtOyunPuani);

        txtKacinciSoru.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_SORU_NO_PARAMETRE));
        txtToplamPuan.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_OYUNCU_PUANI_PARAMETRE));

        btnAnasayfa.setOnClickListener(this);
        btnCikisYap.setOnClickListener(this);
    }


    private void oyundanCikis(){
        btnCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAnasayfayaDon:
                Intent anasayfaIntent = new Intent(EndGameActivity.this, CategoriesActivitiy.class);
                startActivity(anasayfaIntent);
                finish();
                break;

            case R.id.buttonCikisYap:
                oyundanCikis();
                break;

        }
    }


}