package com.project.duchennesebastien;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 06/05/2015.
 */
public class ADejaVoteActivity extends Activity {
    private TextView tvIndications = null;
    private Button bt = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_deja_vote);

        tvIndications = (TextView) findViewById(R.id.tv_a_deja_vote);
        bt = (Button) findViewById(R.id.bt);

        tvIndications.setText("Vous avez déjà voté. Les résultats seront disponibles dès 20h.");
        bt.setText("Retour");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
