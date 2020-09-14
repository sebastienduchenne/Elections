package com.project.duchennesebastien;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 16/05/2015.
 */
public class ElectionsEnFranceFragment extends Fragment {

    public ElectionsEnFranceFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_elections_en_france, container, false);


        ListFragment lf1 = new ElectionsEnFranceLV1Fragment();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.add(R.id.fl_info1, lf1).commit();


        Fragment lf2 = new ElectionsEnFranceLV2Fragment();
        FragmentTransaction transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.add(R.id.fl_info2, lf2).commit();


        return rootView;
    }



}
