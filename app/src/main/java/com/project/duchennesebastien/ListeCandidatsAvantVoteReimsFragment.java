package com.project.duchennesebastien;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 29/05/2015.
 */
public class ListeCandidatsAvantVoteReimsFragment extends ListFragment {

    public ListeCandidatsAvantVoteReimsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_candidats_départementales_marne_canton_reims_1.length - 1; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("photo", Integer.toString(Data.photosDepartementaleReims1[i]));
            hm.put("nom", Data.tab_candidats_départementales_marne_canton_reims_1[i][0]);
            aList.add(hm);
        }

        String[] from = {"photo","nom", "parti"};
        int[] to = {R.id.imgv_candidat_photo, R.id.tv_candidat_nom, R.id.tv_candidat_parti};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_liste_candidats_vote, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),"Le programme n'est disponible que pour les candidats " +
                "du canton de Claye-Souilly du département Seine-et-Marne.",Toast.LENGTH_SHORT).show();
    }


}

