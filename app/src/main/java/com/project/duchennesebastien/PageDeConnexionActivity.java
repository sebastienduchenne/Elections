package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 30/04/2015.
 */
public class PageDeConnexionActivity extends Activity {
    private EditText etIdentifiant = null;
    private EditText etMdp = null;
    private TextView tvErreur = null;
    private Button btSeConnecter = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_de_connexion);

        etIdentifiant = (EditText) findViewById(R.id.et_login);
        etMdp = (EditText) findViewById(R.id.et_mdp);
        tvErreur = (TextView) findViewById(R.id.tv_a_deja_vote);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btSeConnecter = (Button) findViewById(R.id.bt_se_connecter);

        tvErreur.setText("Identifiant : prenom.nom001\nRentrez le mot de passe que vous voulez.");
        tvErreur.setVisibility(View.VISIBLE);

        btSeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etIdentifiant.getText().toString().equals("prenom.nom001") && etMdp.getText().toString().equals("")){

                    if(Data.AVote) {
                        Intent avote = new Intent(PageDeConnexionActivity.this, ADejaVoteActivity.class);
                        startActivity(avote);
                        finish();
                    } else {
                        Intent i = new Intent(PageDeConnexionActivity.this, ListeCandidatsVoteActivity.class);
                        startActivity(i);
                        finish();
                    }

                } else {
                    Toast.makeText(getApplication(), "L'identifiant est incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
