package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 30/04/2015.
 */
public class ListeCandidatsVoteActivity extends Activity {
    private ListView liste_candidats;


    int[] logosDepartementale = new int[]{
            R.drawable.logo_fn,
            R.drawable.logo_ump,
            R.drawable.logo_front_gauche,
            R.drawable.logo_eelv,
            R.drawable.vote_blanc,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_candidats_vote);

        liste_candidats = (ListView) findViewById(R.id.lv_liste_candidats_vote);


        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> element;

        for(int i = 0; i < Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly.length; i++) {
            element = new HashMap<String, String>();
            element.put("photo", Integer.toString(logosDepartementale[i]));
            element.put("nom", Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly[i][0]);
            liste.add(element);
        }

        SimpleAdapter mSchedule = new SimpleAdapter(
                this.getBaseContext(),
                liste,
                R.layout.element_liste_candidats_vote,
                new String[] {"photo","nom"},
                new int[] {R.id.imgv_candidat_photo,R.id.tv_candidat_nom}
        );

        liste_candidats.setAdapter(mSchedule);

        // évènement
        liste_candidats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Intent i = new Intent(ListeCandidatsVoteActivity.this, ConfirmationChoixActivity.class);
                    i.putExtra("cle", position);
                    startActivity(i);
                    finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        boiteDeDialogue();
    }



    public boolean onOptionsItemSelected(MenuItem item){
        boiteDeDialogue();
        return true;
    }

    private void boiteDeDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        String message = "Souhaitez-vous vous déconnecter ?";

        builder.setMessage(message);

        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                retourConnexion();
            }
        });

        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void retourConnexion(){
        Intent accueil = new Intent(ListeCandidatsVoteActivity.this, PageDeConnexionActivity.class);
        startActivity(accueil);
        finish();
    }

}
