package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 01/05/2015.
 */
public class ProgrammeActivity extends Activity {
    private WebView wbProg;
    private ImageView imgvProgramme1;
    private ImageView imgvProgramme2;
    private LinearLayout llProg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme);

        wbProg = (WebView) findViewById(R.id.wv_programme);
        WebView webview = (WebView) findViewById(R.id.wv_programme);
        imgvProgramme1 = (ImageView) findViewById(R.id.imgv_programme1);
        imgvProgramme2 = (ImageView) findViewById(R.id.imgv_programme2);
        llProg = (LinearLayout) findViewById(R.id.ll_prog);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent i = getIntent();
        int prog = i.getIntExtra("cle", 0);


        if(Data.election_choisie == Data.tab_calendrier_election[1][3]) {
            llProg.setVisibility(View.VISIBLE);
            if (prog == 1) {
                imgvProgramme1.setImageResource(R.drawable.prog_ump1);
                imgvProgramme2.setImageResource(R.drawable.prog_ump2);
                getActionBar().setTitle("Programme UMP");
            } else if (prog == 0) {
                imgvProgramme1.setImageResource(R.drawable.prospectus_fn);
                imgvProgramme2.setImageResource(R.drawable.prog_fn);
                getActionBar().setTitle("Programme FN");
            }

        } else if(Data.election_choisie == Data.tab_calendrier_election[0][3]) {
            webview.setVisibility(View.VISIBLE);
            webview.getSettings().setJavaScriptEnabled(true);

            String pdf = null;
            if (prog == 0) {
                pdf = "http://www.parti-socialiste.fr/static/14423/les-60-engagements-pour-la-france-de-francois-hollande.pdf"; // hollande
            } else if (prog == 1){
                pdf = "http://www.u-m-p.org/sites/default/files/fichiers_joints/articles/programme_2012.pdf"; // sarkozy
            } else if (prog == 2) {
                pdf = "http://www.frontnational.com/pdf/projet_mlp2012.pdf"; // le pen
            } else if (prog == 3) {
                pdf = "http://www.jean-luc-melenchon.fr/brochures/humain_dabord.pdf"; // mélenchon
            } else if (prog == 4) {
                pdf = "http://www.mouvementdemocrate.fr/media/PDF/lafrancesolidaire.pdf"; // bayrou
            } else if (prog == 5) {
                pdf = "https://eelv.fr/wp-content/uploads/2012/03/projetpdf.pdf"; // joly
            } else if (prog == 6) {
                pdf = "http://www.debout-la-france.fr/sites/default/files/brochure_37_propositions_web.pdf"; // dupont aignan
            } else if (prog == 7) {
                pdf = "http://npa2009.org/sites/default/files/Programme%20POUTOU%202012.pdf"; // poutou
            } else if (prog == 8) {
                pdf = "http://www.nathalie-arthaud.info/IMG/pdf/brochure.pdf"; // arthaud
            } else if (prog == 9) {
                pdf = "http://www.jacquescheminade.fr/images2012/Cheminade2012-Dossier-de-Presse.pdf"; // cheminade
            }

            actionBar.setTitle("Programme de " + Data.tab_candidats_presidentielles_tour1[prog][0]);

            webview.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);

        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }




}
