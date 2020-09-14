package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 02/05/2015.
 */
public class RechercherActivity extends Activity {
    private EditText etRechercher;
    private ListView recherche;
    private List<HashMap<String, String>> liste;
    private HashMap<String, String> element;
    private TextView tvDep;
    private TextView tvCanton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher);

        ImageView imgvRechercher = (ImageView) findViewById(R.id.imgv_loupe);
        etRechercher = (EditText) findViewById(R.id.et_rechercher);
        tvDep = (TextView) findViewById(R.id.tv_rechercher_departement);
        tvCanton = (TextView) findViewById(R.id.tv_rechercher_canton);

        tvDep.setText("Département : 77 - Seine-et-Marne");
        tvCanton.setText("Canton : Claye-Souilly");

        recherche = (ListView) findViewById(R.id.lv_recherche);
        imgvRechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.election_choisie == Data.tab_calendrier_election[1][3]) {

                    if(etRechercher.getText().toString().equals("sécurité")) {
                        action();
                    } else {
                        Toast.makeText(RechercherActivity.this, "Taper : sécurité", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(RechercherActivity.this, "Non implémenté", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * évènement image rechercher
     */
    public void action() {
        liste = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < 2; i++) {
            element = new HashMap<String, String>();
            element.put("photo", Integer.toString(Data.photosDepartementaleClayeSouilly[i]));
            element.put("nom", Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly[i][0]);
            liste.add(element);
        }

        SimpleAdapter mSchedule = new SimpleAdapter(
                this.getBaseContext(),
                liste,
                R.layout.element_liste_candidats_vote,
                new String[] {"photo","nom"},
                new int[] {R.id.imgv_candidat_photo, R.id.tv_candidat_nom}
        );

        recherche.setAdapter(mSchedule);
        recherche.setClickable(true);
        recherche.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent i = new Intent(getApplication(), ProgrammeActivity.class);
                i.putExtra("cle", position);
                startActivity(i);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
