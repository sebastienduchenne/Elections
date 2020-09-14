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
 * Created by duchennes on 28/05/2015.
 */
public class DepartementsFragment extends ListFragment {

    public DepartementsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_departements_champagne_ardennes.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("departement", Data.tab_departements_champagne_ardennes[i]);
            aList.add(hm);
        }

        for (int i = 0; i < Data.tab_departements_ile_de_france.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("departement", Data.tab_departements_ile_de_france[i]);
            aList.add(hm);
        }

        String[] from = {"departement"};
        int[] to = {R.id.tv_lieu};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_lieu, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if(position == 2) {
            ((ChoixListeActivity) getActivity()).cantons();
            ChoixListeActivity.etat = 1;
            Data.departementChoisi = "51 - Marne";
        } else if(position == 5) {
            ((ChoixListeActivity) getActivity()).cantons();
            ChoixListeActivity.etat = 1;
            Data.departementChoisi = "77 - Seine-et-Marne";
        } else {
            Toast.makeText(getActivity(),"Seules la Marne et la Seine et Marne sont disponibles.",Toast.LENGTH_SHORT).show();
        }

    }
}