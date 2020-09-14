package com.project.duchennesebastien;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
 * Created by duchennes on 28/05/2015.
 */
public class CantonsFragment extends ListFragment {

    public CantonsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        if(Data.departementChoisi.equals("51 - Marne")){
            for (int i = 0; i < Data.tab_cantons_marne.length; i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("canton", Data.tab_cantons_marne[i]);
                aList.add(hm);
            }

        } else {
            for (int i = 0; i < Data.tab_cantons_seine_et_marne.length; i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("canton", Data.tab_cantons_seine_et_marne[i]);
                aList.add(hm);
            }
        }


        String[] from = {"canton"};
        int[] to = {R.id.tv_lieu};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_lieu, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(Data.departementChoisi.equals("51 - Marne")){
            if(position == 2) {
                ((ChoixListeActivity) getActivity()).communication();
                Data.aChoisiListeCandidat = true;
                Data.cantonChoisi = "Reims - 1";
            } else {
                Toast.makeText(getActivity(),"Seul le canton \"Reims - 1\" est disponible.",Toast.LENGTH_SHORT).show();
            }

        } else {
            if(position == 0) {
                ((ChoixListeActivity) getActivity()).communication();
                Data.aChoisiListeCandidat = true;
                Data.cantonChoisi = "Claye-Souilly";
            } else {
                Toast.makeText(getActivity(),"Seul le canton \"Claye-Souilly\" est disponible.",Toast.LENGTH_SHORT).show();
            }

        }
    }


}