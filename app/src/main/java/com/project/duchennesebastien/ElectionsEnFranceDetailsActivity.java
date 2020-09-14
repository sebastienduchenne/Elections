package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 20/05/2015.
 */
public class ElectionsEnFranceDetailsActivity extends Activity {
    //private ImageView imgvInfoCle;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations_cles);

        Intent i = getIntent();
        int info = i.getIntExtra("cle", 0);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //imgvInfoCle = (ImageView) findViewById(R.id.imgv_informations_cles);
        webView = (WebView) findViewById(R.id.wv_info_cle);

        if(info == 0) {
            //imgvInfoCle.setVisibility(View.VISIBLE);
            //imgvInfoCle.setImageResource(R.drawable.conditions_pour_etre_electeur);
            webView.setVisibility(View.VISIBLE);
            String customHtml = Data.infoCle3;
            webView.loadData(customHtml, "text/html; charset=utf-8", null);
            actionBar.setTitle("Le système électoral");
        } else if (info == 1) {
            webView.setVisibility(View.VISIBLE);
            String customHtml = Data.infoCle1;
            webView.loadData(customHtml, "text/html; charset=utf-8", null);
            actionBar.setTitle("L'inscription sur les listes électorales");
        } else if (info == 2) {
            webView.setVisibility(View.VISIBLE);
            String customHtml = Data.infoCle2;
            webView.loadData(customHtml, "text/html; charset=utf-8", null);
            actionBar.setTitle("Le vote des français à l'étranger");
        }


    }


    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }



}
