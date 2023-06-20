  package com.rasit_melih_dincerr.utils;

import android.content.Context;

import com.rasit_melih_dincerr.R;
import com.rasit_melih_dincerr.model.Question;

import java.util.ArrayList;

public class QuestionUtil {
    public static ArrayList<Question> sorular = new ArrayList<>();
    public static int SORU_INDEX = -1;
    public static int OYUNCU_PUAN = 0;

    public static void tarihSorulariOlustur(Context context){
        SORU_INDEX = -1;
        OYUNCU_PUAN =0;
        Question tarihSoru1 = new Question(
                context.getResources().getString(R.string.soruTarih1),
                context.getResources().getString(R.string.soru1Cevap1Tarih),
                context.getResources().getString(R.string.soru1Cevap2Tarih),
                context.getResources().getString(R.string.soru1Cevap3Tarih),
                context.getResources().getString(R.string.soru1Cevap4Tarih),
                1
        );
        sorular.add(tarihSoru1);
    }
    public static void teknolojiSorulariOlustur(Context context) {

        SORU_INDEX = -1;
        OYUNCU_PUAN =0;
        Question teknolojiSoru1 = new Question(
                context.getResources().getString(R.string.soruTeknoloji1),
                context.getResources().getString(R.string.soru1Cevap1Teknoloji),
                context.getResources().getString(R.string.soru1Cevap2Teknoloji),
                context.getResources().getString(R.string.soru1Cevap3Teknoloji),
                context.getResources().getString(R.string.soru1Cevap4Teknoloji),
                3
        );

        Question teknolojiSoru2 = new Question(
                context.getResources().getString(R.string.soruTeknoloji2),
                context.getResources().getString(R.string.soru2Cevap1Teknoloji),
                context.getResources().getString(R.string.soru2Cevap2Teknoloji),
                context.getResources().getString(R.string.soru2Cevap3Teknoloji),
                context.getResources().getString(R.string.soru2Cevap4Teknoloji),
                2
        );

        Question teknolojiSoru3 = new Question(
                context.getResources().getString(R.string.soruTeknoloji3),
                context.getResources().getString(R.string.soru3Cevap1Teknoloji),
                context.getResources().getString(R.string.soru3Cevap2Teknoloji),
                context.getResources().getString(R.string.soru3Cevap3Teknoloji),
                context.getResources().getString(R.string.soru3Cevap4Teknoloji),
                1
        );

        Question teknolojiSoru4 = new Question(
                context.getResources().getString(R.string.soruTeknoloji4),
                context.getResources().getString(R.string.soru4Cevap1Teknoloji),
                context.getResources().getString(R.string.soru4Cevap2Teknoloji),
                context.getResources().getString(R.string.soru4Cevap3Teknoloji),
                context.getResources().getString(R.string.soru4Cevap4Teknoloji),
                4
        );

        Question teknolojiSoru5 = new Question(
                context.getResources().getString(R.string.soruTeknoloji5),
                context.getResources().getString(R.string.soru5Cevap1Teknoloji),
                context.getResources().getString(R.string.soru5Cevap2Teknoloji),
                context.getResources().getString(R.string.soru5Cevap3Teknoloji),
                context.getResources().getString(R.string.soru5Cevap4Teknoloji),
                4
        );


        sorular.add(teknolojiSoru1);
        sorular.add(teknolojiSoru2);
        sorular.add(teknolojiSoru3);
        sorular.add(teknolojiSoru4);
        sorular.add(teknolojiSoru5);
    }

    public static void muzikSorulariOlustur(Context context) {
        SORU_INDEX = -1;
        OYUNCU_PUAN =0;
        Question muzikSoru1 = new Question(
                context.getResources().getString(R.string.soruMuzik1),
                context.getResources().getString(R.string.soru1Cevap1Muzik),
                context.getResources().getString(R.string.soru1Cevap2Muzik),
                context.getResources().getString(R.string.soru1Cevap3Muzik),
                context.getResources().getString(R.string.soru1Cevap4Muzik),
                4
        );

        Question muzikSoru2 = new Question(
                context.getResources().getString(R.string.soruMuzik2),
                context.getResources().getString(R.string.soru2Cevap1Muzik),
                context.getResources().getString(R.string.soru2Cevap2Muzik),
                context.getResources().getString(R.string.soru2Cevap3Muzik),
                context.getResources().getString(R.string.soru2Cevap4Muzik),
                1
        );

        Question muzikSoru3 = new Question(
                context.getResources().getString(R.string.soruMuzik3),
                context.getResources().getString(R.string.soru3Cevap1Muzik),
                context.getResources().getString(R.string.soru3Cevap2Muzik),
                context.getResources().getString(R.string.soru3Cevap3Muzik),
                context.getResources().getString(R.string.soru3Cevap4Muzik),
                3
        );

        Question muzikSoru4 = new Question(
                context.getResources().getString(R.string.soruMuzik4),
                context.getResources().getString(R.string.soru4Cevap1Muzik),
                context.getResources().getString(R.string.soru4Cevap2Muzik),
                context.getResources().getString(R.string.soru4Cevap3Muzik),
                context.getResources().getString(R.string.soru4Cevap4Muzik),
                1
        );

        Question muzikSoru5 = new Question(
                context.getResources().getString(R.string.soruMuzik5),
                context.getResources().getString(R.string.soru5Cevap1Muzik),
                context.getResources().getString(R.string.soru5Cevap2Muzik),
                context.getResources().getString(R.string.soru5Cevap3Muzik),
                context.getResources().getString(R.string.soru5Cevap4Muzik),
                2
        );


        sorular.add(muzikSoru1);
        sorular.add(muzikSoru2);
        sorular.add(muzikSoru3);
        sorular.add(muzikSoru4);
        sorular.add(muzikSoru5);
    }

    public static void sporSorulariOlustur(Context context) {
        SORU_INDEX = -1;
        OYUNCU_PUAN =0;

        Question sporSoru1 = new Question(
                context.getResources().getString(R.string.soruSpor1),
                context.getResources().getString(R.string.soru1Cevap1Spor),
                context.getResources().getString(R.string.soru1Cevap2Spor),
                context.getResources().getString(R.string.soru1Cevap3Spor),
                context.getResources().getString(R.string.soru1Cevap4Spor),
                3
        );

        Question sporSoru2 = new Question(
                context.getResources().getString(R.string.soruSpor2),
                context.getResources().getString(R.string.soru2Cevap1Spor),
                context.getResources().getString(R.string.soru2Cevap2Spor),
                context.getResources().getString(R.string.soru2Cevap3Spor),
                context.getResources().getString(R.string.soru2Cevap4Spor),
                1
        );

        Question sporSoru3 = new Question(
                context.getResources().getString(R.string.soruSpor3),
                context.getResources().getString(R.string.soru3Cevap1Spor),
                context.getResources().getString(R.string.soru3Cevap2Spor),
                context.getResources().getString(R.string.soru3Cevap3Spor),
                context.getResources().getString(R.string.soru3Cevap4Spor),
                4
        );

        Question sporSoru4 = new Question(
                context.getResources().getString(R.string.soruSpor4),
                context.getResources().getString(R.string.soru4Cevap1Spor),
                context.getResources().getString(R.string.soru4Cevap2Spor),
                context.getResources().getString(R.string.soru4Cevap3Spor),
                context.getResources().getString(R.string.soru4Cevap4Spor),
                2
        );

        Question sporSoru5 = new Question(
                context.getResources().getString(R.string.soruSpor5),
                context.getResources().getString(R.string.soru5Cevap1Spor),
                context.getResources().getString(R.string.soru5Cevap2Spor),
                context.getResources().getString(R.string.soru5Cevap3Spor),
                context.getResources().getString(R.string.soru5Cevap4Spor),
                1
        );


        sorular.add(sporSoru1);
        sorular.add(sporSoru2);
        sorular.add(sporSoru3);
        sorular.add(sporSoru4);
        sorular.add(sporSoru5);
    }

    public static void filmSorulariOlustur(Context context) {
        SORU_INDEX = -1;
        OYUNCU_PUAN =0;

        Question filmSoru1 = new Question(
                context.getResources().getString(R.string.soruFilm1),
                context.getResources().getString(R.string.soru1Cevap1Film),
                context.getResources().getString(R.string.soru1Cevap2Film),
                context.getResources().getString(R.string.soru1Cevap3Film),
                context.getResources().getString(R.string.soru1Cevap4Film),
                1
        );

        Question filmSoru2 = new Question(
                context.getResources().getString(R.string.soruFilm2),
                context.getResources().getString(R.string.soru2Cevap1Film),
                context.getResources().getString(R.string.soru2Cevap2Film),
                context.getResources().getString(R.string.soru2Cevap3Film),
                context.getResources().getString(R.string.soru2Cevap4Film),
                3
        );

        Question filmSoru3 = new Question(
                context.getResources().getString(R.string.soruFilm3),
                context.getResources().getString(R.string.soru3Cevap1Film),
                context.getResources().getString(R.string.soru3Cevap2Film),
                context.getResources().getString(R.string.soru3Cevap3Film),
                context.getResources().getString(R.string.soru3Cevap4Film),
                4
        );

        Question filmSoru4 = new Question(
                context.getResources().getString(R.string.soruFilm4),
                context.getResources().getString(R.string.soru4Cevap1Film),
                context.getResources().getString(R.string.soru4Cevap2Film),
                context.getResources().getString(R.string.soru4Cevap3Film),
                context.getResources().getString(R.string.soru4Cevap4Film),
                2
        );

        Question filmSoru5 = new Question(
                context.getResources().getString(R.string.soruFilm5),
                context.getResources().getString(R.string.soru5Cevap1Film),
                context.getResources().getString(R.string.soru5Cevap2Film),
                context.getResources().getString(R.string.soru5Cevap3Film),
                context.getResources().getString(R.string.soru5Cevap4Film),
                3
        );


        sorular.add(filmSoru1);
        sorular.add(filmSoru2);
        sorular.add(filmSoru3);
        sorular.add(filmSoru4);
        sorular.add(filmSoru5);
    }



    public static Question siradakiSoruyuGetir() {

        if (SORU_INDEX < sorular.size()-1) {
            SORU_INDEX++;
        }
        else{
            OYUNCU_PUAN+=20;
        }

        return sorular.get(SORU_INDEX);
    }

    public static Boolean cevapDogruMu(int cevap) {
        if (sorular.get(SORU_INDEX).getDogruCevap() == cevap) {
            return true;
        }
        else {
            return false;
        }
    }


}
