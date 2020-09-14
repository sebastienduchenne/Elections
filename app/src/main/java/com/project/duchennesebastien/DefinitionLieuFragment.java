package com.project.duchennesebastien;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
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
 * Created by duchennes on 15/05/2015.
 */
public class DefinitionLieuFragment extends ListFragment {
    private int pos = 0;

    public DefinitionLieuFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        miseAJourParametres();

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(getActivity(), ChoixLieuActivity.class);
        pos = position;

        if(position == 0){
            i.putExtra("cle", position);
            startActivityForResult(i, position);
        } else if(position == 1){
            if(!isUndefined(position - 1)){
                i.putExtra("cle", position);
                startActivityForResult(i, position);
            } else {
                Toast.makeText(getActivity(), "Veuillez configurer le pays.", Toast.LENGTH_SHORT).show();
            }
        } else if(position == 2){
            if(!isUndefined(position - 1)){
                i.putExtra("cle", position);
                startActivityForResult(i, position);
            } else {
                Toast.makeText(getActivity(), "Veuillez configurer la région.", Toast.LENGTH_SHORT).show();
            }
        } else if(position == 3){
            if(!isUndefined(position - 1)){
                i.putExtra("cle", position);
                startActivityForResult(i, position);
            } else {
                Toast.makeText(getActivity(), "Veuillez configurer le département.", Toast.LENGTH_SHORT).show();
            }
        } else if(position == 4){
            if(!isUndefined(position - 1)){
                i.putExtra("cle", position);
                startActivityForResult(i, position);
            } else {
                Toast.makeText(getActivity(), "Veuillez configurer le canton.", Toast.LENGTH_SHORT).show();
            }
        }

    }


    public boolean isUndefined(int nb){
        boolean b = false;
        if(Data.tab_parametres[nb][1].equals("Non défini") || Data.tab_parametres[nb][1].equals("Non définie")){
            b = true;
        }
        return b;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(pos < 4){
            MAJ2(pos + 1);
        }

        miseAJourParametres();
    }

    public void miseAJourParametres() {
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < Data.tab_parametres.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("zone", Data.tab_parametres[i][0]);
            hm.put("nomLieu", Data.tab_parametres[i][1]);
            aList.add(hm);
        }

        String[] from = {"zone", "nomLieu"};
        int[] to = {R.id.tv_zone, R.id.tv_nom_lieu};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.element_definition_lieu, from, to);
        setListAdapter(adapter);
    }

    public void MAJ2(int nb){
        String[] tab = new String[]{
                "Non défini",
                "Non définie",
                "Non défini",
                "Non défini",
                "Non définie"
        };

        for(int i = nb; i < tab.length; i++){
            Data.tab_parametres[i][1] = tab[i];
        }
    }


}