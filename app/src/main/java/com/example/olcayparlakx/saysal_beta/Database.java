package com.example.olcayparlakx.saysal_beta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sahin on 23.12.2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DbName = "DB";
    private static final int DATABASE_VERSION = 1;


    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DbName, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DERSLER(Id INTEGER , DersAdi TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE SINAVLAR(Id INTEGER , SinavAdi TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE NOTTURU(Id INTEGER , NotTurAdi TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE KONULAR (Id INTEGER PRIMARY KEY AUTOINCREMENT, KonuAdi TEXT, DersId INTEGER , SinavId INTEGER , NotTuruId INTEGER , Icerik TEXT );");



    }
    public void doldur()
    {
        SQLiteDatabase db_oku = this.getReadableDatabase();
        SQLiteDatabase db_yaz = this.getWritableDatabase();
        String sql = "select * from DERSLER ";
        Cursor cursor = db_oku.rawQuery(sql,null);
        if(cursor.getCount()==0)
        {
           String[] dersler = {"Matematik","Geometri","Fizik","Kimya","Biyoloji"};
           for(int i=0;i<dersler.length;i++)
               db_yaz.execSQL("insert into DERSLER(Id,DersAdi) values("+i+",'"+dersler[i]+"');");

        }

         sql = "select * from SINAVLAR ";
         cursor = db_oku.rawQuery(sql,null);
        if(cursor.getCount()==0)
        {
            String[] sinavlar = {"LYS","YGS"};
            for(int i=0;i<sinavlar.length;i++)
                db_yaz.execSQL("insert into SINAVLAR(Id,SinavAdi) values("+i+",'"+sinavlar[i]+"');");

        }

        sql = "select * from NOTTURU ";
        cursor = db_oku.rawQuery(sql,null);
        if(cursor.getCount()==0)
        {
            String[] notturu = {"Video","Defter","Soru"};
            for(int i=0;i<notturu.length;i++)
                db_yaz.execSQL("insert into NOTTURU(Id,NotTurAdi) values("+i+",'"+notturu[i]+"');");

        }

        sql = "select * from KONULAR ";
        cursor = db_oku.rawQuery(sql,null);
        if(cursor.getCount()==0)
        {
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Mantık',0,0,0,'PLfqc-K2yIql_enKkrl7krl1SuEs-mySrY');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Mantık',0,0,1,'lysmat1.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Mantık',0,0,2,'lysmat1soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Modüler Aritmatik',0,0,0,'PLl60UQpkdH09xb0KewbykzZAPAuEFsF1v');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Modüler Aritmatik',0,0,1,'lysmat2.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Modüler Aritmatik',0,0,2,'lysmat2soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Eşitsizlikler',0,0,0,'PLIBjFaUoJJ91eDi05_qBqoff40DefqYGC');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Eşitsizlikler',0,0,1,'lysmat3.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Eşitsizlikler',0,0,2,'lysmat3soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Logaritma',0,0,0,'PLIBjFaUoJJ90YVe8Nh7NF1NQauTAX_tfc');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Logaritma',0,0,1,'lysmat4.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Logaritma',0,0,2,'lysmat4soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Trigonometri',0,0,0,'PLIBjFaUoJJ90HuF3nTISbOTCcpCdoCzf9');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Trigonometri',0,0,1,'lysmat5.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Trigonometri',0,0,2,'lysmat5soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Diziler-Seriler',0,0,0,'PLIBjFaUoJJ92NVuGCBfXWzZ38g7FAx5vN');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Diziler-Seriler',0,0,1,'lysmat6.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Diziler-Seriler',0,0,2,'lysmat6soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Limit ve Süreklilik',0,0,0,'PLIBjFaUoJJ92HEl-Ejmk3zNBCyOKDoiCl');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Limit ve Süreklilik',0,0,1,'lysmat7.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Limit ve Süreklilik',0,0,2,'lysmat7soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Türev',0,0,0,'PLIBjFaUoJJ91hv67isccY-BYesnrIw1Gc');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Türev',0,0,1,'lysmat8.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('Türev',0,0,2,'lysmat8soru.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('İntegral',0,0,0,'PLIBjFaUoJJ90vZJ6Tf0EJp1xlL54jaaeP');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('İntegral',0,0,1,'lysmat9.pdf');");
            db_yaz.execSQL("insert into KONULAR(KonuAdi,DersId,SinavId,NotTuruId,Icerik) values('İntegral',0,0,2,'lysmat9soru.pdf');");

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
