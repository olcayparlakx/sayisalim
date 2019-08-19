package com.example.olcayparlakx.saysal_beta;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.github.barteksc.pdfviewer.PDFView;
public class defter extends Activity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_defter);

        String Icerik = getIntent().getExtras().getString("Icerik");

        PDFView pdfView = (PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset(Icerik).load();


    }
}
