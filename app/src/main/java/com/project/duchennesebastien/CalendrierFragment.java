package com.project.duchennesebastien;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 29/04/2015.
 */
public class CalendrierFragment extends ListFragment {

    public CalendrierFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i = 0; i < Data.tab_calendrier_election.length; i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("election", Data.tab_calendrier_election[i][0]);
            hm.put("dates", "" + Data.tab_calendrier_election[i][1] + Data.tab_calendrier_election[i][2] );
            aList.add(hm);
        }

        String[] from = { "election","dates" };

        int[] to = { R.id.calendrier_election,R.id.calendrier_dates};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_calendrier, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Fragment f = new OngletsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
        Data.election_choisie = Data.tab_calendrier_election[position][3];

    }


}
