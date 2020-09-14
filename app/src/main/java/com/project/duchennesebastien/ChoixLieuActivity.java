package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 28/05/2015.
 */
public class ChoixLieuActivity extends Activity {
    private ListView liste_lieu;
    private int choix = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_lieu);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        liste_lieu = (ListView) findViewById(R.id.lv_choix_lieu);

        Intent i = getIntent();
        choix = i.getIntExtra("cle", 0);

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> element;

        if(choix == 0){
            getActionBar().setTitle("Choix du pays");
            for(int j = 0; j < Data.tab_pays.length; j++) {
                element = new HashMap<String, String>();
                element.put("lieu", Data.tab_pays[j]);
                liste.add(element);
            }

        } else if(choix == 1) {
            getActionBar().setTitle("Choix de la région");
            for(int j = 0; j < Data.tab_regions.length; j++) {
                element = new HashMap<String, String>();
                element.put("lieu", Data.tab_regions[j]);
                liste.add(element);
            }

        } else if(choix == 2) {
            getActionBar().setTitle("Choix du département");

            if(Data.tab_parametres[choix-1][1].equals("Champagne-Ardenne")) {
                for(int j = 0; j < Data.tab_departements_champagne_ardennes.length; j++) {
                    element = new HashMap<String, String>();
                    element.put("lieu", Data.tab_departements_champagne_ardennes[j]);
                    liste.add(element);
                }
            } else if(Data.tab_parametres[choix-1][1].equals("Ile-de-France")){
                for(int j = 0; j < Data.tab_departements_ile_de_france.length; j++) {
                    element = new HashMap<String, String>();
                    element.put("lieu", Data.tab_departements_ile_de_france[j]);
                    liste.add(element);
                }
            }

        } else if(choix == 3) {
            getActionBar().setTitle("Choix du canton");

            if(Data.tab_parametres[choix-1][1].equals("51 - Marne")) {
                for(int j = 0; j < Data.tab_cantons_marne.length; j++) {
                    element = new HashMap<String, String>();
                    element.put("lieu", Data.tab_cantons_marne[j]);
                    liste.add(element);
                }
            } else if(Data.tab_parametres[choix-1][1].equals("77 - Seine-et-Marne")){
                for(int j = 0; j < Data.tab_cantons_seine_et_marne.length; j++) {
                    element = new HashMap<String, String>();
                    element.put("lieu", Data.tab_cantons_seine_et_marne[j]);
                    liste.add(element);
                }
            }

        } else if(choix == 4) {
            getActionBar().setTitle("Choix de la commune");

            if(Data.tab_parametres[choix-1][1].equals("Reims - 1")) {
                element = new HashMap<String, String>();
                element.put("lieu", "Reims");
                liste.add(element);
            } else if(Data.tab_parametres[choix-1][1].equals("Claye-Souilly")){
                for(int j = 0; j < Data.tab_communes_canton_claye_souilly.length; j++) {
                    element = new HashMap<String, String>();
                    element.put("lieu", Data.tab_communes_canton_claye_souilly[j]);
                    liste.add(element);
                }
            }

        }

        SimpleAdapter mSchedule = new SimpleAdapter(
                this.getBaseContext(),
                liste,
                R.layout.element_lieu,
                new String[] {"lieu"},
                new int[] {R.id.tv_lieu}
        );

        liste_lieu.setAdapter(mSchedule);


        // évènement
        liste_lieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent i = new Intent();
                i.putExtra("cle", "1");
                setResult(RESULT_OK, i);

                if (choix == 0) { // pays
                    if (position == 2) {
                        Data.tab_parametres[0][1] = Data.tab_pays[position];
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Seule la France est disponible.", Toast.LENGTH_SHORT).show();
                    }

                } else if (choix == 1) { // régions
                    if (position == 1) {
                        Data.tab_parametres[1][1] = Data.tab_regions[position];
                        finish();
                    } else if(position == 2) {
                        Data.tab_parametres[1][1] = Data.tab_regions[position];
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Seule l'île-de-France et la Champagne-Ardenne sont disponibles.", Toast.LENGTH_SHORT).show();
                    }

                } else if (choix == 2) { // départements

                    if(Data.tab_parametres[choix-1][1].equals("Champagne-Ardenne")) {
                        if (position == 2) {
                            Data.tab_parametres[2][1] = Data.tab_departements_champagne_ardennes[position];
                            Data.departementChoisi = Data.tab_departements_champagne_ardennes[position];
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Seule la Marne est disponible.", Toast.LENGTH_SHORT).show();
                        }

                    } else if(Data.tab_parametres[choix-1][1].equals("Ile-de-France")){
                        if (position == 1) {
                            Data.tab_parametres[2][1] = Data.tab_departements_ile_de_france[position];
                            Data.departementChoisi = Data.tab_departements_ile_de_france[position];
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Seule la Seine-et-Marne est disponible.", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (choix == 3) { // cantons

                    if(Data.tab_parametres[choix-1][1].equals("51 - Marne")) {
                        if (position == 2) {
                            Data.tab_parametres[3][1] = Data.tab_cantons_marne[position];
                            Data.cantonChoisi = Data.tab_cantons_marne[position];
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Seule Reims - 1 est disponible.", Toast.LENGTH_SHORT).show();
                        }

                    } else if(Data.tab_parametres[choix-1][1].equals("77 - Seine-et-Marne")){
                        if (position == 0) {
                            Data.tab_parametres[3][1] = Data.tab_cantons_seine_et_marne[position];
                            Data.cantonChoisi = Data.tab_cantons_seine_et_marne[position];
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Seule Claye-Souilly est disponible.", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (choix == 4) { // communes
                    if(Data.tab_parametres[choix-1][1].equals("Reims - 1")) {
                        Data.tab_parametres[4][1] = "Reims";
                        finish();
                    } else if(Data.tab_parametres[choix-1][1].equals("Claye-Souilly")){
                        Data.tab_parametres[4][1] = Data.tab_communes_canton_claye_souilly[position];
                        finish();
                    }

                }
            }
        });
    }



    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

}
