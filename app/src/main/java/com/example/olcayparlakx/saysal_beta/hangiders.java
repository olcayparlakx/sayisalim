package com.example.olcayparlakx.saysal_beta;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class hangiders extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hangiders);

        new Database(getApplicationContext(),"",null,1).doldur();

        Button btn_matematik = (Button)findViewById(R.id.matematik);
        btn_matematik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),main.class);
                intent.putExtra("DersId","0");
                startActivity(intent);
            }
        });
    }
}
