package com.project.duchennesebastien;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 21/05/2015.
 */
public class ElectionsEnFranceLV1Fragment extends ListFragment{


    public ElectionsEnFranceLV1Fragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i = 0; i < Data.tab_info_cle1.length; i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("titre", Data.tab_info_cle1[i]);
            aList.add(hm);
        }

        String[] from = {"titre"};
        int[] to = {R.id.tv_info_cle1};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_elections_en_france1, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(position < 4){
            Intent i = new Intent(getActivity(), ElectionsEnFranceDetailsActivity.class);
            i.putExtra("cle", position);
            startActivity(i);
        }
    }


}
