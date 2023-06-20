package com.rasit_melih_dincerr.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.rasit_melih_dincerr.R;
import com.rasit_melih_dincerr.model.Question;
import com.rasit_melih_dincerr.utils.Constants;
import com.rasit_melih_dincerr.utils.PrefUtil;
import com.rasit_melih_dincerr.utils.QuestionUtil;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnKategoriAd,btnCevap1, btnCevap2, btnCevap3, btnCevap4;
    TextView txtKacinciSoru, txtPuan, txtSoru;
    Drawable teknolojiIcon, muzikIcon, sporIcon, filmIcon;
    String kategoriTeknolojiRes, kategoriMuzikRes, kategoriSporRes,kategoriFilmRes,kategoriTarihRes;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        init();

        kategoriIconveSoruGetir();
    }

    private void init() {
        txtKacinciSoru =findViewById(R.id.txtKacinciSoru);
        txtPuan =findViewById(R.id.txtPuan);
        txtSoru = findViewById(R.id.txtSoru);


        btnCevap1 = findViewById(R.id.btnCevap1);
        btnCevap2 = findViewById(R.id.btnCevap2);
        btnCevap3 = findViewById(R.id.btnCevap3);
        btnCevap4 = findViewById(R.id.btnCevap4);

        btnCevap1.setOnClickListener(this);
        btnCevap2.setOnClickListener(this);
        btnCevap3.setOnClickListener(this);
        btnCevap4.setOnClickListener(this);

        btnKategoriAd =findViewById(R.id.btnKategoriAdi);

        btnKategoriAd.setText(PrefUtil.getStringPref(getApplicationContext(), Constants.PREF_KATEGORI_ADI_PARAMETRE));


        kategoriTeknolojiRes = getResources().getString(R.string.kategoriTeknoloji);
        kategoriMuzikRes = getResources().getString(R.string.kategoriMuzik);
        kategoriSporRes = getResources().getString(R.string.kategoriSpor);
        kategoriFilmRes = getResources().getString(R.string.kategoriFilm);
        kategoriTarihRes = getResources().getString(R.string.kategoriTarih);

        teknolojiIcon = getResources().getDrawable(R.drawable.teknolojiicon);
        muzikIcon = getResources().getDrawable(R.drawable.muzikicon);
        sporIcon = getResources().getDrawable(R.drawable.sporicon);
        filmIcon = getResources().getDrawable(R.drawable.filmicon);

    }

    private void kategoriIconveSoruGetir() {
        QuestionUtil.sorular.clear();

        if(btnKategoriAd.getText() == kategoriTarihRes) {

            QuestionUtil.tarihSorulariOlustur(getApplicationContext());
        }

        if(btnKategoriAd.getText() == kategoriTeknolojiRes){

            QuestionUtil.teknolojiSorulariOlustur(getApplicationContext());

        }
        if(btnKategoriAd.getText() == kategoriSporRes){

            QuestionUtil.sporSorulariOlustur(getApplicationContext());
        }
        if(btnKategoriAd.getText() == kategoriMuzikRes){

            QuestionUtil.muzikSorulariOlustur(getApplicationContext());
        }
        if(btnKategoriAd.getText() == kategoriFilmRes) {

            QuestionUtil.filmSorulariOlustur(getApplicationContext());
        }



        soruDoldur();


    }

    private void kacinciSoru() {
        int soruNo = QuestionUtil.SORU_INDEX;
        soruNo+=1;
        int toplamSoru = QuestionUtil.sorular.size();
        txtKacinciSoru.setText(getResources().getString(R.string.kacinciSoru) +" "+ soruNo + "/" + toplamSoru);
        PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_SORU_NO_PARAMETRE,txtKacinciSoru.getText().toString());
    }

    private void puan() {
        int puan = QuestionUtil.OYUNCU_PUAN;
        txtPuan.setText(getResources().getString(R.string.puan) +" "+ puan);
        PrefUtil.setStringPref(getApplicationContext(), Constants.PREF_OYUNCU_PUANI_PARAMETRE,txtPuan.getText().toString());
    }

    private void soruDoldur(){
        butonlariResetle();
        Question soru = QuestionUtil.siradakiSoruyuGetir();
        txtSoru.setText(soru.getSoru());
        btnCevap1.setText(soru.getCevap1());
        btnCevap2.setText(soru.getCevap2());
        btnCevap3.setText(soru.getCevap3());
        btnCevap4.setText(soru.getCevap4());
        kacinciSoru();
        puan();
    }

    private void butonlariResetle(){
        btnCevap1.setBackground(getResources().getDrawable(R.drawable.btn_cevap_design));
        btnCevap2.setBackground(getResources().getDrawable(R.drawable.btn_cevap_design));
        btnCevap3.setBackground(getResources().getDrawable(R.drawable.btn_cevap_design));
        btnCevap4.setBackground(getResources().getDrawable(R.drawable.btn_cevap_design));

        btnCevap1.setEnabled(true);
        btnCevap2.setEnabled(true);
        btnCevap3.setEnabled(true);
        btnCevap4.setEnabled(true);

    }

    private void cevapKontrolEt(int tiklananCevap, View btnTiklanan){
        if(QuestionUtil.cevapDogruMu(tiklananCevap)){
            QuestionUtil.OYUNCU_PUAN+=20;
            btnTiklanan.setBackground(getResources().getDrawable(R.drawable.btn_dogru_cevap_design));

            if(QuestionUtil.SORU_INDEX< QuestionUtil.sorular.size()-1){
                dogruCevapZamanlayici();
            }
            if(QuestionUtil.SORU_INDEX== QuestionUtil.sorular.size()-1){
                puan();
                Intent tebriklerIntent = new Intent(GameActivity.this, EndGameActivity.class);
                startActivity(tebriklerIntent);
                finish();
            }
        }

        else{
            btnTiklanan.setBackground(getResources().getDrawable(R.drawable.btn_yanlis_cevap_design));
            yanlisCevapzamanlayici();
        }

    }

    private void dogruCevapZamanlayici() {
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                dogruCevapAlertDialog();
            }
        };
        countDownTimer.start();
    }

    private void dogruCevapButon() {
        Question dogruCevap = new Question();
        int dogruCevapIndex = dogruCevap.getDogruCevap();
        if(dogruCevapIndex==1){
            btnCevap1.setBackground(getResources().getDrawable(R.drawable.btn_dogru_cevap_design));

        }
        else if(dogruCevapIndex==2){
            btnCevap2.setBackground(getResources().getDrawable(R.drawable.btn_dogru_cevap_design));
        }
        else if(dogruCevapIndex==3){
            btnCevap3.setBackground(getResources().getDrawable(R.drawable.btn_dogru_cevap_design));

        }
        else{
            btnCevap4.setBackground(getResources().getDrawable(R.drawable.btn_dogru_cevap_design));
        }
    }

    private void yanlisCevapzamanlayici() {
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {

                Intent hataliCevapIntent = new Intent(GameActivity.this, WrongAnswerActivitiy.class);
                startActivity(hataliCevapIntent);
                finish();
            }
        };
        countDownTimer.start();
    }


    private void dogruCevapAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogTheme);
        builder.setIcon(R.drawable.gulenicon);
        builder.setTitle("Cevap Doğru");
        builder.setNegativeButton("Çıkış", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        Intent kategoriIntent = new Intent(GameActivity.this, CategoriesActivitiy.class);
                        startActivity(kategoriIntent);
                        finish();
                    }
                });
        builder.setPositiveButton("Devam", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        soruDoldur();
                    }
                });
        builder.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCevap1:
                cevapKontrolEt(1,v);
                btnCevap2.setEnabled(false);
                btnCevap3.setEnabled(false);
                btnCevap4.setEnabled(false);
                break;

            case R.id.btnCevap2:
                cevapKontrolEt(2,v);
                btnCevap1.setEnabled(false);
                btnCevap3.setEnabled(false);
                btnCevap4.setEnabled(false);
                break;

            case R.id.btnCevap3:
                cevapKontrolEt(3,v);
                btnCevap1.setEnabled(false);
                btnCevap2.setEnabled(false);
                btnCevap4.setEnabled(false);
                break;

            case R.id.btnCevap4:
                cevapKontrolEt(4,v);
                btnCevap1.setEnabled(false);
                btnCevap3.setEnabled(false);
                btnCevap4.setEnabled(false);
                break;



        }
    }
}