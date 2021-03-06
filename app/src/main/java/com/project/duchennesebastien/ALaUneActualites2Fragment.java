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
 * Created by duchennes on 26/05/2015.
 */
public class ALaUneActualites2Fragment extends ListFragment {
    public int nb = 1;

    public ALaUneActualites2Fragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        List<HashMap<String, String>> aListActu = new ArrayList<HashMap<String, String>>();


        for (int i = premierArticle(); i >= dernierArticle(); i--) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("img", Integer.toString(Data.img[i]));
            hm.put("date", Data.tab_actualites[i][0]);
            hm.put("titre", Data.tab_actualites[i][1]);
            aListActu.add(hm);
        }

        String[] fromActu = {"img", "date", "titre"};
        int[] toActu = {R.id.imgv_une_lv, R.id.tv_une_date, R.id.tv_une_titre};
        SimpleAdapter adapterActu = new SimpleAdapter(getActivity().getBaseContext(), aListActu, R.layout.element_a_la_une_actu, fromActu, toActu);
        setListAdapter(adapterActu);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private int premierArticle(){
        int premier = 0;
        if(Data.temps == 3){
            premier = 1;
        } else if(Data.temps == 4){
            premier = 2;
        }
        return premier;
    }

    private int dernierArticle(){
        int dernier = 0;
        if(Data.temps == 3){
            dernier = 0;
        } else if(Data.temps == 4){
            dernier = 0;
        }
        return dernier;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), ActualitesActivity.class);

        if(Data.temps == 3){

            if(position == 0){
                i.putExtra("cle", 1);
            } else if(position == 1){
                i.putExtra("cle", 0);
            }

        } else if(Data.temps == 4){//enlever 5 à la position puis prendre la valeur absolue

            if(position == 0){
                i.putExtra("cle", 2);
                Data.actuAvecLien = true;
            } else if(position == 1){
                i.putExtra("cle", 1);
            } else if(position == 2){
                i.putExtra("cle", 0);
            }
        }

        if(position != 10) {
            startActivity(i);
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }



}

