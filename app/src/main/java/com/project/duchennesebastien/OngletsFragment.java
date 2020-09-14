package com.project.duchennesebastien;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 07/05/2015.
 */
public class OngletsFragment extends Fragment {
    private TabHost myTabHost;

    private TextView tv_onglet_departement;
    private TextView tv_onglet_canton;

    private String indication;
    private String resultats;

    // onglet candidats
    private LinearLayout ll_voter;
    private TextView tv_indic_voter;
    private Button bt_voter_onglet_candidats;
    private FrameLayout fl_liste_candidat;
    private FrameLayout fl_liste_candidat_reims;
    private TextView tv_indic_voir_prog;

    // onglet résultats
    private LinearLayout ll_resultats_t1_t2 = null;
    private TextView tv_res_t2_non_dispo = null;
    private TextView tv_res_pas_dispo = null;
    private LinearLayout ll_resultats_t1 = null;
    private LinearLayout ll_resultats_t2 = null;
    private TextView tv_stat_details_tour_1;
    private TextView tv_stat_details_tour_2;
    private FrameLayout fl_resultats_t1;
    private FrameLayout fl_resultats_reims_t1;

    // 3 boutons
    private LinearLayout ll_autres_listes;
    private LinearLayout ll_rechercher;
    private LinearLayout ll_enjeux;

    public OngletsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_onglets, container, false);

        myTabHost = (TabHost) rootView.findViewById(R.id.TabHost01);
        myTabHost.setup();

        ((MainActivity) getActivity()).setTitreActionBar(Data.election_choisie);

        // onglet candidats
        TabHost.TabSpec spec = myTabHost.newTabSpec("tab_candidats");
        spec.setIndicator("Candidats");
        spec.setContent(R.id.onglet1);
        myTabHost.addTab(spec);

        // onglet résultats :
        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab_resultats");
        spec2.setIndicator("Résultats");
        spec2.setContent(R.id.onglet2);
        myTabHost.addTab(spec2);

        for(int i=0; i<myTabHost.getTabWidget().getChildCount(); i++){
            TextView tv = (TextView) myTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources ().getColor (R.color.monRouge));
        }

        ll_resultats_t1_t2 = (LinearLayout) rootView.findViewById(R.id.ll_resultats_t1_t2);
        tv_indic_voter = (TextView) rootView.findViewById(R.id.tv_indic_voter);
        tv_onglet_departement = (TextView) rootView.findViewById(R.id.tv_onglet_departement);
        tv_onglet_canton = (TextView) rootView.findViewById(R.id.tv_onglet_canton);
        tv_res_t2_non_dispo = (TextView) rootView.findViewById(R.id.tv_res_t2_non_dispo);
        ll_voter = (LinearLayout) rootView.findViewById(R.id.ll_voter);
        bt_voter_onglet_candidats = (Button) rootView.findViewById(R.id.bt_voter_onglet_candidats);
        ll_resultats_t1 = (LinearLayout) rootView.findViewById(R.id.ll_resultats_t1);
        ll_resultats_t2 = (LinearLayout) rootView.findViewById(R.id.ll_resultats_t2);
        tv_res_pas_dispo = (TextView) rootView.findViewById(R.id.tv_res_pas_dispo);
        tv_indic_voir_prog = (TextView) rootView.findViewById(R.id.tv_indic_voir_prog);
        fl_liste_candidat = (FrameLayout) rootView.findViewById(R.id.fl_liste_candidat);
        fl_liste_candidat_reims = (FrameLayout) rootView.findViewById(R.id.fl_liste_candidat_reims);
        fl_resultats_t1 = (FrameLayout) rootView.findViewById(R.id.fl_resultats_t1);
        fl_resultats_reims_t1 = (FrameLayout) rootView.findViewById(R.id.fl_resultats_reims_t1);
        tv_stat_details_tour_1 = (TextView) rootView.findViewById(R.id.tv_stat_details_tour_1);
        tv_stat_details_tour_2 = (TextView) rootView.findViewById(R.id.tv_stat_details_tour_2);
        ll_autres_listes = (LinearLayout) rootView.findViewById(R.id.ll_autres_listes);

        bt_voter_onglet_candidats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PageDeConnexionActivity.class);
                startActivity(i);
            }
        });

        ListFragment candidats = new ListeCandidatsAvantVoteFragment();
        FragmentTransaction transactionCandidats = getChildFragmentManager().beginTransaction();
        transactionCandidats.add(R.id.fl_liste_candidat, candidats).commit();

        ListFragment lf = new ListeCandidatsAvantVoteReimsFragment();
        FragmentTransaction trans = getChildFragmentManager().beginTransaction();
        trans.add(R.id.fl_liste_candidat_reims, lf).commit();

        ListFragment lfResultatsT1 = new ResultatsCandidatsT1Fragment();
        FragmentTransaction transactionResultatsT1 = getChildFragmentManager().beginTransaction();
        transactionResultatsT1.add(R.id.fl_resultats_t1, lfResultatsT1).commit();

        ListFragment lfreims = new ResultatsCandidatsReimsT1Fragment();
        FragmentTransaction transreims = getChildFragmentManager().beginTransaction();
        transreims.add(R.id.fl_resultats_reims_t1, lfreims).commit();


        Data.departementChoisi = Data.tab_parametres[2][1];
        Data.cantonChoisi = Data.tab_parametres[3][1];


        ///////  évènements bouton autres listes

        ll_autres_listes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.temps != 1 && (Data.election_choisie == Data.tab_calendrier_election[1][3]) ){
                    Intent i = new Intent(getActivity(), ChoixListeActivity.class);
                    startActivityForResult(i, 0);
                } else {
                    Toast.makeText(getActivity(), "La liste des candidats n'est pas encore disponible.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ///////  évènements bouton rechercher
        ll_rechercher = (LinearLayout) rootView.findViewById(R.id.ll_rechercher);
        ll_rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Data.election_choisie == Data.tab_calendrier_election[1][3] ) {
                    if(Data.temps == 1){
                        Toast.makeText(getActivity(), "La liste des candidats n'est pas encore disponible.", Toast.LENGTH_SHORT).show();

                    } else {
                        if(Data.departementChoisi.equals("51 - Marne")) {
                            Toast.makeText(getActivity(), "Cette fonction ne fonctionne que pour le canton de Claye-Souilly" +
                                    " dans le département de Seine-et-Marne.", Toast.LENGTH_SHORT).show();
                        } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                            Intent candidats = new Intent(getActivity(), RechercherActivity.class);
                            startActivity(candidats);
                        } else {
                            Toast.makeText(getActivity(), "Aucune liste n'a été sélectionné.", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    Toast.makeText(getActivity(), "Cette fonction n'est disponible que pour les élections départementales de 2015.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ll_enjeux = (LinearLayout) rootView.findViewById(R.id.ll_enjeux);
        ll_enjeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( Data.election_choisie == Data.tab_calendrier_election[0][3] || Data.election_choisie == Data.tab_calendrier_election[1][3]) {
                    Intent enjeux = new Intent(getActivity(), EnjeuxExplicationsActivity.class);
                    startActivity(enjeux);
                } else {
                    Toast.makeText(getActivity(), "Cette fonction n'est disponible que pour les élections présidentielles et départementales.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(Data.election_choisie == Data.tab_calendrier_election[0][3]) { // départementales
            Presidentielle2012();
        } else if(Data.election_choisie == Data.tab_calendrier_election[1][3]){ // présidentielles
            Departementales2015();
        } else if(Data.election_choisie == Data.tab_calendrier_election[2][3]){
            regionales2015();
        } else if(Data.election_choisie == Data.tab_calendrier_election[3][3]){
            presidentielles2017();
        } else if(Data.election_choisie == Data.tab_calendrier_election[4][3]){
            européennes2019();
        } else if(Data.election_choisie == Data.tab_calendrier_election[5][3]){
            municipales2020();
        } else if(Data.election_choisie == Data.tab_calendrier_election[6][3]){
            départementales2021();
        }

        Data.acces = 0;

        return rootView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Data.aChoisiListeCandidat) {
            Data.aChoisiListeCandidat = false;
            Departementales2015();
            tv_onglet_departement.setText("Département : " + Data.departementChoisi);
            tv_onglet_canton.setText("Canton : " + Data.cantonChoisi);
        }
    }


    private void Departementales2015(){
        indication = "Sélectionnez un binôme pour voir son programme.";
        resultats = "";

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Département : " + Data.tab_parametres[2][1]);
        tv_onglet_canton.setVisibility(View.VISIBLE);
        tv_onglet_canton.setText("Canton : " + Data.tab_parametres[3][1]);


            if(!Data.tab_parametres[3][1].equals("Non défini")) {

            if (Data.temps == 1) {
                indication = "La liste des candidats n'est pas encore disponible.";
                resultats = "Les résultats ne sont pas encore disponibles.";

            } else if (Data.temps == 2) {
                resultats = "Les résultats seront disponibles le 22 mars à partir de 20h.";

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                }

            } else if (Data.temps == 3) {
                ll_voter.setVisibility(View.VISIBLE);
                resultats = "Les résultats seront disponibles à partir de 20h.";

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                }

            } else if (Data.temps == 4) {
                tv_res_pas_dispo.setVisibility(View.GONE);

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                    AfficherResultatsReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                    AfficherResultatsClaye();
                }

                if(Data.acces == 2){
                    myTabHost.setCurrentTab(0);
                } else {
                    myTabHost.setCurrentTab(1);
                }
            }

        } else {
            indication = "Pour afficher la liste des candidats de votre canton, vous devez indiquer un lieu dans la rubrique \"Paramètres\".";
            resultats = "Pour afficher les résultats de votre canton, vous devez indiquer un lieu dans la rubrique \"Paramètres\".";


            if (Data.temps == 1) {
                indication = "La liste des candidats n'est pas encore disponible.";
                resultats = "Les résultats ne sont pas encore disponibles.";

            } else if (Data.temps == 2) {
                indication = "Pour afficher la liste des candidats de votre canton, vous devez indiquer un lieu dans la rubrique \"Paramètres\".";
                resultats = "Les résultats seront disponibles le 22 mars à partir de 20h. \n\nPour afficher les résultats de votre canton, vous devez indiquer un lieu dans la rubrique \"Paramètres\".";

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                }

            } else if (Data.temps == 3) {
                ll_voter.setVisibility(View.VISIBLE);
                resultats = "Les résultats seront disponibles à partir de 20h. \n\nPour afficher les résultats de votre canton, vous devez indiquer un lieu dans la rubrique \"Paramètres\".";

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                }

            } else if (Data.temps == 4) {
                tv_res_pas_dispo.setVisibility(View.VISIBLE);

                if(Data.departementChoisi.equals("51 - Marne")) {
                    AfficherListeCandidatReims();
                    AfficherResultatsReims();
                } else if(Data.departementChoisi.equals("77 - Seine-et-Marne")){
                    AfficherListeCandidatClaye();
                    AfficherResultatsClaye();
                }

                if(Data.acces == 2){
                    myTabHost.setCurrentTab(0);
                } else {
                    myTabHost.setCurrentTab(1);
                }
            }

        }

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }

    private void AfficherListeCandidatClaye(){
        fl_liste_candidat.setVisibility(View.VISIBLE);
        fl_liste_candidat_reims.setVisibility(View.GONE);
        tv_onglet_departement.setText("Département : 77 - Seine-et-Marne");
        tv_onglet_canton.setText("Canton : Claye-Souilly");

    }

    private void AfficherListeCandidatReims(){
        fl_liste_candidat_reims.setVisibility(View.VISIBLE);
        fl_liste_candidat.setVisibility(View.GONE);
        tv_onglet_departement.setText("Département : 51 - Marne");
        tv_onglet_canton.setText("Canton : Reims - 1");

    }

    private void AfficherResultatsClaye(){
        ll_resultats_t1_t2.setVisibility(View.VISIBLE);
        ll_resultats_t2.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.VISIBLE);
        fl_resultats_t1.setVisibility(View.VISIBLE);
        fl_resultats_t1.getLayoutParams().height = 600;
        fl_resultats_reims_t1.setVisibility(View.GONE);

        tv_stat_details_tour_1.setText(Data.tab_statistiques_départementales_seine_et_marne_canton_claye_souilly[0] + "\n"
                + Data.tab_statistiques_départementales_seine_et_marne_canton_claye_souilly[1] + "\n"
                + Data.tab_statistiques_départementales_seine_et_marne_canton_claye_souilly[2]);
    }

    private void AfficherResultatsReims(){
        ll_resultats_t1_t2.setVisibility(View.VISIBLE);
        ll_resultats_t2.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.VISIBLE);
        fl_resultats_t1.setVisibility(View.GONE);
        fl_resultats_reims_t1.setVisibility(View.VISIBLE);
        fl_resultats_reims_t1.getLayoutParams().height = 600;

        tv_stat_details_tour_1.setText(Data.tab_statistiques_départementales_marne_canton_reims_1[0] + "\n"
                + Data.tab_statistiques_départementales_marne_canton_reims_1[1] + "\n"
                + Data.tab_statistiques_départementales_marne_canton_reims_1[2]);
    }

    private void Presidentielle2012(){
        // afficher la liste des candidats
        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Pays : France");
        tv_onglet_canton.setVisibility(View.GONE);

        String indication = "Sélectionnez un candidat pour voir son programme.";
        tv_indic_voir_prog.setText(indication);

        fl_liste_candidat.setVisibility(View.VISIBLE);
        ll_autres_listes.setVisibility(View.GONE);

        // afficher les résultats
        tv_res_pas_dispo.setVisibility(View.GONE);
        tv_res_t2_non_dispo.setVisibility(View.GONE);
        ll_resultats_t1_t2.setVisibility(View.VISIBLE);
        ll_resultats_t2.setVisibility(View.VISIBLE);
        ll_resultats_t1.setVisibility(View.VISIBLE);
        fl_resultats_t1.setVisibility(View.VISIBLE);
        fl_resultats_t1.getLayoutParams().height = 1500;

        myTabHost.setCurrentTab(1);

        tv_stat_details_tour_1.setText(Data.tab_statistiques_presidentielles_tour1[0] + "\n"
                + Data.tab_statistiques_presidentielles_tour1[1] + "\n"
                + Data.tab_statistiques_presidentielles_tour1[2]);
        tv_stat_details_tour_2.setText(Data.tab_statistiques_presidentielles_tour2[0] + "\n"
                + Data.tab_statistiques_presidentielles_tour2[1] + "\n"
                + Data.tab_statistiques_presidentielles_tour2[2]);
    }

    private void regionales2015(){
        indication = "La liste des candidats n'est pas encore disponible.";
        resultats = "Les résultats ne sont pas encore disponibles.";

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Région : " + Data.tab_parametres[1][1]);
        tv_onglet_canton.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.GONE);
        ll_resultats_t2.setVisibility(View.GONE);
        fl_liste_candidat.setVisibility(View.GONE);

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }

    private void presidentielles2017(){
        indication = "La liste des candidats n'est pas encore disponible.";
        resultats = "Les résultats ne sont pas encore disponibles.";

        ll_autres_listes.setVisibility(View.GONE);

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Pays : France");
        tv_onglet_canton.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.GONE);
        ll_resultats_t2.setVisibility(View.GONE);
        fl_liste_candidat.setVisibility(View.GONE);

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }

    private void européennes2019(){
        indication = "La liste des candidats n'est pas encore disponible.";
        resultats = "Les résultats ne sont pas encore disponibles.";

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Pays : France");
        tv_onglet_canton.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.GONE);
        ll_resultats_t2.setVisibility(View.GONE);
        fl_liste_candidat.setVisibility(View.GONE);

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }

    private void municipales2020(){
        indication = "La liste des candidats n'est pas encore disponible.";
        resultats = "Les résultats ne sont pas encore disponibles.";

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Commune : " + Data.tab_parametres[4][1]);
        tv_onglet_canton.setVisibility(View.GONE);

        ll_resultats_t1.setVisibility(View.GONE);
        ll_resultats_t2.setVisibility(View.GONE);
        fl_liste_candidat.setVisibility(View.GONE);

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }

    private void départementales2021(){
        indication = "La liste des binômes n'est pas encore disponible.";
        resultats = "Les résultats ne sont pas encore disponibles.";

        tv_onglet_departement.setVisibility(View.VISIBLE);
        tv_onglet_departement.setText("Département : " + Data.tab_parametres[2][1]);
        tv_onglet_canton.setVisibility(View.VISIBLE);
        tv_onglet_canton.setText("Canton : " + Data.tab_parametres[3][1]);

        ll_resultats_t1.setVisibility(View.GONE);
        ll_resultats_t2.setVisibility(View.GONE);
        fl_liste_candidat.setVisibility(View.GONE);

        tv_res_pas_dispo.setText(resultats);
        tv_indic_voir_prog.setText(indication);
    }


}
