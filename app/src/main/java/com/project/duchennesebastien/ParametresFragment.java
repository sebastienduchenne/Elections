package com.project.duchennesebastien;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.project.duchennesebastien.elections.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duchennes on 29/04/2015.
 */
public class ParametresFragment extends Fragment {

    public ParametresFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_parametres, container, false);

        ListFragment candidats = new DefinitionLieuFragment();
        FragmentTransaction transactionCandidats = getChildFragmentManager().beginTransaction();
        transactionCandidats.add(R.id.fl_parametres, candidats).commit();

        return rootView;
    }



}
