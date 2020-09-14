package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 30/04/2015.
 */
public class ConfirmationChoixActivity extends Activity{
    private TextView tvChoix = null;
    private TextView tv_info = null;
    private ImageView imgvPhoto = null;
    private Switch switchConfirmation = null;
    private Button btValider = null;
    private Button btAnnuler = null;


    int[] photosDepartementale = new int[]{
            R.drawable.logo_fn,
            R.drawable.logo_ump,
            R.drawable.logo_front_gauche,
            R.drawable.logo_eelv,
            R.drawable.vote_blanc,
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_choix);


        btAnnuler = (Button) findViewById(R.id.bt_annuler);
        tvChoix = (TextView) findViewById(R.id.textView_prenom_nom);
        btValider = (Button) findViewById(R.id.bt_valider);
        tv_info = (TextView) findViewById(R.id.tv_info_confirmation);
        switchConfirmation = (Switch) findViewById(R.id.switch1);
        imgvPhoto = (ImageView) findViewById(R.id.imgv_choix_photo);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        String info = "Le vote est anonyme, votre choix ne sera donc pas mémorisé. Chaque électeur ne peut voter qu'une seule fois. \n\n" +
                "Après validation, le vote ne sera pas modifiable.";
        tv_info.setText(info);

        Intent i = getIntent();
        int choix = i.getIntExtra("cle", 0);

        imgvPhoto.setImageResource(photosDepartementale[choix]);


        tvChoix.setText(Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly[choix][0]);

        switchConfirmation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    btValider.setBackgroundResource(R.drawable.bt_bleu);
                } else {
                    btValider.setBackgroundResource(R.drawable.img_valider2_clair);
                }
            }
        });


        btAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent candidats = new Intent(ConfirmationChoixActivity.this, ListeCandidatsVoteActivity.class);
                startActivity(candidats);
                finish();
            }
        });


        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchConfirmation.isChecked()) {
                    Intent avote = new Intent(ConfirmationChoixActivity.this, AVoteActivity.class);
                    startActivity(avote);
                    finish();
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        Intent accueil = new Intent(ConfirmationChoixActivity.this, ListeCandidatsVoteActivity.class);
        startActivity(accueil);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent accueil = new Intent(ConfirmationChoixActivity.this, ListeCandidatsVoteActivity.class);
        startActivity(accueil);
        finish();
        return true;
    }


}
