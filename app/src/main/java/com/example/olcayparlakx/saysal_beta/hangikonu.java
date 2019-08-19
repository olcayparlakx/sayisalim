package com.example.olcayparlakx.saysal_beta;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class hangikonu extends Activity {

    Spinner sKonuAdlari;
    List<String> listKonuAdi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hangikonu);

        final String SinavId = getIntent().getExtras().getString("SinavId");
        final String DersId = getIntent().getExtras().getString("DersId");

        sKonuAdlari = (Spinner)findViewById(R.id.spinner);

        listKonuAdi = new ArrayList<>();

        Database db = new Database(getApplicationContext(),"",null,1);
        SQLiteDatabase db_oku =  db.getReadableDatabase();
        String sql = "select KonuAdi from KONULAR where SinavId="+Integer.parseInt(SinavId)+" AND DersId="+Integer.parseInt(DersId)+" GROUP BY KonuAdi";
        Cursor cursor = db_oku.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            listKonuAdi.add(cursor.getString(0));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listKonuAdi);
        sKonuAdlari.setAdapter(adapter);

        Button btn_getir = (Button)findViewById(R.id.btngetir);
        btn_getir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),notturu.class);
                int index = sKonuAdlari.getSelectedItemPosition();
                String KonuAdi = listKonuAdi.get(index);
                intent.putExtra("KonuAdi",KonuAdi);
                intent.putExtra("SinavId",SinavId);
                intent.putExtra("DersId",DersId);
                startActivity(intent);
            }
        });

    }
}
