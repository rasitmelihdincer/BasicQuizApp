package com.rasit_melih_dincerr.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rasit_melih_dincerr.R;
import com.rasit_melih_dincerr.utils.Constants;
import com.rasit_melih_dincerr.utils.PrefUtil;

public class CategoriesActivitiy extends AppCompatActivity implements View.OnClickListener{

    Button btnTeknoloji, btnMuzik, btnSpor, btnFilm, btnCikis , btnTarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        init();

        cikisYap();

    }
    private void init() {
        btnTeknoloji = findViewById(R.id.btnKtgTeknoloji);
        btnMuzik = findViewById(R.id.btnKtgYemek);
        btnSpor = findViewById(R.id.btnKtgSpor);
        btnFilm = findViewById(R.id.btnKtgFilm);
        btnTarih = findViewById(R.id.btnKtgTarih);
        btnCikis = findViewById(R.id.btnCikis);


        btnTeknoloji.setOnClickListener(this);
        btnMuzik.setOnClickListener(this);
        btnSpor.setOnClickListener(this);
        btnFilm.setOnClickListener(this);
        btnTarih.setOnClickListener(this);

    }

    private void cikisYap() {
        btnCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cikisAlertDialog();
            }
        });
    }

    private void cikisAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogTheme);
        builder.setIcon(R.drawable.exiticon);
        builder.setTitle(getResources().getString(R.string.alertCikisTitle));
        builder.setMessage(getResources().getString(R.string.alertCikisMessage));
        builder.setNegativeButton(getResources().getString(R.string.alertCikisNegativeButon), null);
        builder.setPositiveButton(getResources().getString(R.string.alertCikisPozitifButon), new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        finish();
                    }
                });
        builder.show();

    }

    public void kategoriIsmiGonder(Button kategori){
        PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_KATEGORI_ADI_PARAMETRE,kategori.getText().toString());
        Intent kategoriAdIntent = new Intent(CategoriesActivitiy.this, GameActivity.class);
        startActivity(kategoriAdIntent);
        finish();

    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnKtgTarih:
                kategoriIsmiGonder(btnTarih);
                break;

            case R.id.btnKtgTeknoloji:
                kategoriIsmiGonder(btnTeknoloji);
                break;

            case R.id.btnKtgYemek:
                kategoriIsmiGonder(btnMuzik);
                break;

            case R.id.btnKtgSpor:
                kategoriIsmiGonder(btnSpor);
                break;

            case R.id.btnKtgFilm:
                kategoriIsmiGonder(btnFilm);
                break;



            case R.id.btnCikis:
                cikisYap();
                break;


        }
    }






}