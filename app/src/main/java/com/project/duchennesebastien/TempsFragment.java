package com.project.duchennesebastien;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 29/04/2015.
 */
public class TempsFragment extends Fragment {
    private Button btHorsElection = null;
    private Button btListe = null;
    private Button btVoter = null;
    private Button btResultats = null;
    private TextView tv = null;
    private TextView tv2 = null;

    public TempsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_temps, container, false);

        btHorsElection = (Button) rootView.findViewById(R.id.bt_hors_election);
        btListe = (Button) rootView.findViewById(R.id.bt_temps_liste);
        btVoter = (Button) rootView.findViewById(R.id.bt_temps_voter);
        btResultats = (Button) rootView.findViewById(R.id.bt_temps_resultats);
        tv = (TextView) rootView.findViewById(R.id.tv_temps);
        tv2 = (TextView) rootView.findViewById(R.id.tv_temps2);

        setText();

        btHorsElection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.temps = 1;
                Data.aRecuNotification = false;
                setText();
            }
        });

        btListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.temps = 2;
                Data.aRecuNotification = false;
                setText();
            }
        });

        btVoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.temps = 3;
                Data.aRecuNotification = false;
                Data.AVote = false;
                setText();
            }
        });

        btResultats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.temps = 4;
                Data.aRecuNotification = false;
                setText();
            }
        });

        return rootView;
    }

    public void setText() {
        if(Data.temps == 1){
            tv.setText("Temps : Hors élection");
            tv2.setText("Avant les élections départementales 2015");
        } else if(Data.temps == 2) {
            tv.setText("Temps : Liste");
            tv2.setText("Liste des candidats à l'élections départementales 2015 disponible");
        } else if(Data.temps == 3) {
            tv.setText("Temps : vote");
            tv2.setText("Jour du vote du 1er tour des élections départementales 2015." +
                    "\nL'application est configurée pour que vous soyez inscrit sur les listes électorales " +
                    "du canton Claye-Souilly dans le département de Seine-et-Marne.");
        } else if(Data.temps == 4) {
            tv.setText("Temps : Résultats");
            tv2.setText("Résultats du 1er tour des élections départementales 2015 disponibles");
        }
    }


}
