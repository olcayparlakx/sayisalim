package com.example.olcayparlakx.saysal_beta;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class notturu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notturu);



        final String KonuAdi = getIntent().getExtras().getString("KonuAdi");
        final String SinavId = getIntent().getExtras().getString("SinavId");
        final String DersId = getIntent().getExtras().getString("DersId");

        Button btn_video = (Button)findViewById(R.id.video);
        Button btn_defter = (Button)findViewById(R.id.defter);
        Button btn_soru = (Button)findViewById(R.id.soru);

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Database db = new Database(getApplicationContext(), "", null, 1);
                    SQLiteDatabase db_oku = db.getReadableDatabase();
                    String sql = "select Icerik from KONULAR where KonuAdi='" + KonuAdi + "' AND SinavId=" + Integer.parseInt(SinavId) + " AND DersId=" + Integer.parseInt(DersId) + " AND NotTuruId="+0+"";
                    Cursor cursor = db_oku.rawQuery(sql, null);
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "Henüz Videomuz Bulunmuyor .", Toast.LENGTH_LONG).show();
                        return;
                    }
                    cursor.moveToNext();
                    String Icerik = cursor.getString(0);
                    Intent intent = new Intent(getApplicationContext(), Video.class);
                    intent.putExtra("Icerik", Icerik);
                    startActivity(intent);
                }catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(), ex+"", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_defter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Database db = new Database(getApplicationContext(), "", null, 1);
                    SQLiteDatabase db_oku = db.getReadableDatabase();
                    String sql = "select Icerik from KONULAR where KonuAdi='" + KonuAdi + "' AND SinavId=" + Integer.parseInt(SinavId) + " AND DersId=" + Integer.parseInt(DersId) + " AND NotTuruId="+1+"";
                    Cursor cursor = db_oku.rawQuery(sql, null);
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "Henüz Defter Notumuz Bulunmuyor .", Toast.LENGTH_LONG).show();
                        return;
                    }
                    cursor.moveToNext();
                    String Icerik = cursor.getString(0);
                    Intent intent = new Intent(getApplicationContext(), defter.class);
                    intent.putExtra("Icerik", Icerik);
                    startActivity(intent);
                }catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(), ex+"", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_soru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Database db = new Database(getApplicationContext(), "", null, 1);
                    SQLiteDatabase db_oku = db.getReadableDatabase();
                    String sql = "select Icerik from KONULAR where KonuAdi='" + KonuAdi + "' AND SinavId=" + Integer.parseInt(SinavId) + " AND DersId=" + Integer.parseInt(DersId) + " AND NotTuruId="+2+"";
                    Cursor cursor = db_oku.rawQuery(sql, null);
                    if (cursor.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "Henüz Sorularımız Bulunmuyor .", Toast.LENGTH_LONG).show();
                        return;
                    }
                    cursor.moveToNext();
                    String Icerik = cursor.getString(0);
                    Intent intent = new Intent(getApplicationContext(), defter.class);
                    intent.putExtra("Icerik", Icerik);
                    startActivity(intent);
                }catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(), ex+"", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
