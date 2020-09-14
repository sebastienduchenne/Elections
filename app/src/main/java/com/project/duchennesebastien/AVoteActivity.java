package com.project.duchennesebastien;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 30/04/2015.
 */
public class AVoteActivity extends Activity {
    private TextView tvAVote = null;
    private TextView tvIndications = null;
    private Button btRetourALaUne = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_vote);

        tvAVote = (TextView) findViewById(R.id.tv_a_vote);
        tvIndications = (TextView) findViewById(R.id.tv_indication_a_vote);
        btRetourALaUne = (Button) findViewById(R.id.bt_se_deconnecter);

        if (Data.AVote) {
            tvAVote.setVisibility(View.INVISIBLE);
            tvIndications.setText("Vous avez déjà voté. Les résultats seront disponibles dès 20h.");
            btRetourALaUne.setVisibility(View.INVISIBLE);
        } else {
            Data.AVote = true;
        }

        btRetourALaUne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
