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

import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 21/05/2015.
 */
public class ElectionsEnFranceLV2Fragment extends ListFragment {

    public ElectionsEnFranceLV2Fragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i = 0; i < Data.tab_info_cle2.length; i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("titre", Data.tab_info_cle2[i]);
            aList.add(hm);
        }

        String[] from = {"titre"};
        int[] to = {R.id.tv_info_cle2};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_elections_en_france2, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), EnjeuxExplicationsActivity.class);

        if(position == 1){
            Data.election_choisie = Data.tab_calendrier_election[0][3];
            startActivity(i);
        } else if(position == 3){
            Data.election_choisie = Data.tab_calendrier_election[1][3];
            startActivity(i);
        } else {
            Toast.makeText(getActivity(), "Seules les élections départementales et présidentielles sont disponibles.", Toast.LENGTH_SHORT).show();
        }
    }

}
