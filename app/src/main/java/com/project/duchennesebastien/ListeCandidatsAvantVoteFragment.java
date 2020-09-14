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
 * Created by duchennes on 05/05/2015.
 */
public class ListeCandidatsAvantVoteFragment extends ListFragment {

    public ListeCandidatsAvantVoteFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(Data.election_choisie == Data.tab_calendrier_election[1][3]) { // departementales de 2015
            departementales();
        } else if(Data.election_choisie == Data.tab_calendrier_election[0][3]) { // présidentielles de 2012
            presidentielle();
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private void departementales(){
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly.length - 1; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("photo", Integer.toString(Data.photosDepartementaleClayeSouilly[i]));
            hm.put("nom", Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly[i][0]);
            //hm.put("parti", Data.tab_candidats_départementales_seine_et_marne_canton_claye_souilly[i][1]);
            aList.add(hm);
        }


        String[] from = {"photo","nom", "parti"};
        int[] to = {R.id.imgv_candidat_photo, R.id.tv_candidat_nom, R.id.tv_candidat_parti};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_liste_candidats_vote, from, to);
        setListAdapter(adapter);
    }


    private void presidentielle(){
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_candidats_presidentielles_tour1.length - 1; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("photo", Integer.toString(Data.photosPresidentielle[i]));
            hm.put("nom", Data.tab_candidats_presidentielles_tour1[i][0]);
            hm.put("parti", Data.tab_candidats_presidentielles_tour1[i][1]);
            aList.add(hm);
        }

        String[] from = {"photo","nom", "parti"};
        int[] to = {R.id.imgv_candidat_photo, R.id.tv_candidat_nom, R.id.tv_candidat_parti};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_liste_candidats_vote_reims, from, to);
        setListAdapter(adapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), ProgrammeActivity.class);
        if(Data.election_choisie == Data.tab_calendrier_election[0][3]) {
            if(((MainActivity) getActivity()).isOnline()) {
                i.putExtra("cle", position);
                startActivity(i);
            } else {
                Toast.makeText(getActivity(),"Pour voir les programmes de cette élection, vous devez être connecté(e) à internet.",Toast.LENGTH_SHORT).show();
            }
        } else if(Data.election_choisie == Data.tab_calendrier_election[1][3]) {
            if(position <= 1) {
                i.putExtra("cle", position);
                startActivity(i);
            } else {
                Toast.makeText(getActivity(),"Seuls les programmes du FN et de l'UMP sont disponibles.",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
