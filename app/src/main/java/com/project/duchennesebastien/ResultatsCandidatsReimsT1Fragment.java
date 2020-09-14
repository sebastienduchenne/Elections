package com.project.duchennesebastien;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 29/05/2015.
 */
public class ResultatsCandidatsReimsT1Fragment extends ListFragment {


    int[] barresClaye = new int[]{
            R.drawable.barre_reims_ump,
            R.drawable.barre_reims_ps,
            R.drawable.barre_reims_fn,
            R.drawable.barre_reims_eelv,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_candidats_départementales_marne_canton_reims_1.length - 1; i++) {
            HashMap<String, String> element;
            element = new HashMap<String, String>();
            element.put("photo", Integer.toString(Data.photosDepartementaleReims1[i]));
            element.put("nom", Data.tab_candidats_départementales_marne_canton_reims_1[i][0]);
            element.put("parti", Data.tab_candidats_départementales_marne_canton_reims_1[i][1]);
            element.put("pourcent", Data.tab_candidats_départementales_marne_canton_reims_1[i][2]);
            element.put("nbvoix", Data.tab_candidats_départementales_marne_canton_reims_1[i][3]);
            element.put("barre", Integer.toString(barresClaye[i]));
            liste.add(element);
        }

        String[] from = { "photo","nom", "parti", "pourcent", "nbvoix", "barre", "barre2" };
        int[] to = { R.id.imgv_resultat_t1_photo, R.id.tv_resultats_candidat , R.id.tv_resultats_parti, R.id.tv_resultats_pourcent, R.id.tv_resultats_nb_voix, R.id.imgv_barre};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), liste, R.layout.element_liste_candidats_resultats, from, to);
        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
