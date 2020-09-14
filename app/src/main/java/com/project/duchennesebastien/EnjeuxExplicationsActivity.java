package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 04/05/2015.
 */
public class EnjeuxExplicationsActivity extends Activity {
    private ImageView imgvEnjeux = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enjeux_explications);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imgvEnjeux = (ImageView) findViewById(R.id.imgv_enjeux_explications);

        if(Data.election_choisie == Data.tab_calendrier_election[0][3]){ // présidentielle
            actionBar.setTitle("Enjeux des élections présidentielles");
            imgvEnjeux.setImageResource(R.drawable.enjeux_presidentielles);
        } else if(Data.election_choisie == Data.tab_calendrier_election[1][3]){ // départementales
            actionBar.setTitle("Enjeux des élections départementales");
            imgvEnjeux.setImageResource(R.drawable.enjeux_departementales);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
