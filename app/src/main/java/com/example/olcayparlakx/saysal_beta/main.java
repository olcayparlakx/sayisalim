package com.example.olcayparlakx.saysal_beta;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.time.Instant;

public class main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        final String DersId = getIntent().getExtras().getString("DersId");

        Button btn_lys = (Button)findViewById(R.id.lys);
        Button btn_ygs = (Button)findViewById(R.id.ygs);

        btn_lys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),hangikonu.class);
                intent.putExtra("SinavId","0");
                intent.putExtra("DersId",DersId);
                startActivity(intent);
            }
        });

        btn_ygs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),hangikonu.class);
                intent.putExtra("SinavId","1");
                intent.putExtra("DersId",DersId);
                startActivity(intent);
            }
        });






    }
}
