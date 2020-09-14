package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 16/05/2015.
 */
public class ActualitesActivity extends Activity {
    private ImageView imgvPhoto;
    private TextView tvDate;
    private TextView tvTitre;
    private TextView tvTexte;
    private TextView tvLien;

    public static int actu2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualites);

        Intent i = getIntent();
        int actu = i.getIntExtra("cle", 0);
        actu2 = actu;

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imgvPhoto = (ImageView) findViewById(R.id.imgv_actu_photo);
        tvDate = (TextView) findViewById(R.id.tv_actu_date);
        tvTitre = (TextView) findViewById(R.id.tv_actu_titre);
        tvTexte = (TextView) findViewById(R.id.tv_actu_texte);
        tvLien = (TextView) findViewById(R.id.tv_actu_lien);


        if(Data.actuAvecLien){
            tvTexte.setVisibility(View.GONE);
            tvLien.setVisibility(View.VISIBLE);
            tvLien.setText("" + Data.tab_actualites[actu][2]);
        } else {
            tvTexte.setVisibility(View.VISIBLE);
            tvLien.setVisibility(View.GONE);
        }

        imgvPhoto.setImageResource(Data.img[actu]);
        tvDate.setText("Publié le " + Data.tab_actualites[actu][0]);
        tvTitre.setText("" + Data.tab_actualites[actu][1]);
        tvTexte.setText("" + Data.tab_actualites[actu][2]);


        tvLien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(actu2 == 2){ // liste candidat
                    Data.acces = 2;
                    finish();
                } else if(actu2 == 3){ // vote
                    Intent i = new Intent(ActualitesActivity.this, PageDeConnexionActivity.class);
                    startActivity(i);
                    finish();
                } else if(actu2 == 5){ // résultats
                    Data.acces = 4;
                    finish();
                }
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }


}
