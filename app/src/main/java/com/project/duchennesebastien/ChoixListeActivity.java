package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.R;


/**
 * Created by duchennes on 02/05/2015.
 */
public class ChoixListeActivity extends Activity {
    public static int etat = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_liste);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Choix du département");

        Fragment f = new DepartementsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_choix_liste, f).commit();

    }

    public void cantons() {
        getActionBar().setTitle("Choix du canton");
        Fragment f = new CantonsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_choix_liste, f).commit();
    }


    public boolean onOptionsItemSelected(MenuItem item){
        if(etat == 0){
            finish();
        } else {
            ChoixListeActivity.etat = 0;
            getActionBar().setTitle("Choix du département");
            Fragment f = new DepartementsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_choix_liste, f).commit();
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        if(etat == 0){
            finish();
        } else {
            ChoixListeActivity.etat = 0;
            getActionBar().setTitle("Choix du département");
            Fragment f = new DepartementsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_choix_liste, f).commit();
        }
    }

    public void communication(){
        Intent result = new Intent();
        setResult(RESULT_OK, result);
        finish();
    }


}
