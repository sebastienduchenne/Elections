package com.project.duchennesebastien;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.duchennesebastien.elections.MainActivity;
import com.project.duchennesebastien.elections.R;

/**
 * Created by duchennes on 14/05/2015.
 */
public class ALaUneFragment extends Fragment {
    private Button btPlusDArticle;
    private FrameLayout frame2;

    public ALaUneFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_a_la_une, container, false);

        frame2 = (FrameLayout) rootView.findViewById(R.id.fl_actu2);
        btPlusDArticle = (Button) rootView.findViewById(R.id.bt_plus_darticle);

        if(Data.temps == 3){
            frame2.getLayoutParams().height = 373;
        } else{
            frame2.getLayoutParams().height = 560;
        }


        if(Data.temps == 1 || Data.temps == 2) {
            btPlusDArticle.setVisibility(View.GONE);
        }


        btPlusDArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frame2.setVisibility(View.VISIBLE);
            }
        });


        ListFragment lf1 = new ALaUneActualites1Fragment();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.add(R.id.fl_actu1, lf1).commit();

        ListFragment lf2 = new ALaUneActualites2Fragment();
        FragmentTransaction transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.add(R.id.fl_actu2, lf2).commit();

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);

        return rootView;
    }

    public class ImagePagerAdapter extends PagerAdapter {

        public int getCount() {
            int count = 1;
            if(Data.temps == 1){
                count = 1;
            } else if(Data.temps == 2){
                count = 2;
            } else if(Data.temps == 3){
                count = 3;
            } else if(Data.temps == 4){
                count = 3;
            }
            return count;
        }

        public Object instantiateItem(View collection, int position) {
            LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = null;

            if(position == 0){
                view = inflater.inflate(R.layout.fragment_a_la_une_notification_swipe_1, null);
                ImageView img1 = (ImageView) view.findViewById(R.id.imgv_swipe_1);

                if(Data.temps == 1){
                    img1.setImageResource(Data.img[1]);
                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            autreActivite("changement");
                        }
                    });
                } else if(Data.temps == 2){
                    img1.setImageResource(Data.img[2]);

                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment f = new OngletsFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
                            Data.election_choisie = Data.tab_calendrier_election[1][3];
                            ((MainActivity) getActivity()).swipe();
                        }
                    });

                } else if(Data.temps == 3){
                    img1.setImageResource(Data.img[3]);

                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            autreActivite("connexion");
                        }
                    });

                } else if(Data.temps == 4){
                    img1.setImageResource(Data.img[5]);


                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment f = new OngletsFragment();

                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
                            Data.election_choisie = Data.tab_calendrier_election[1][3];
                            ((MainActivity) getActivity()).swipe();
                        }
                    });

                }

            } else if(position == 1){
                view = inflater.inflate(R.layout.fragment_a_la_une_notification_swipe_2, null);
                ImageView img2 = (ImageView) view.findViewById(R.id.imgv_swipe_2);

                if(Data.temps == 2){
                    img2.setImageResource(Data.img[1]);
                    img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            autreActivite("changement");
                        }
                    });
                } else if(Data.temps == 3){
                    img2.setImageResource(Data.img[2]);

                    img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment f = new OngletsFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
                            Data.election_choisie = Data.tab_calendrier_election[1][3];
                            ((MainActivity) getActivity()).swipe();
                        }
                    });

                } else if(Data.temps == 4){
                    img2.setImageResource(Data.img[3]);

                    img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getActivity(),"Le vote n'est plus disponible.",Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            } else if(position == 2){
                view = inflater.inflate(R.layout.fragment_a_la_une_notification_swipe_3, null);
                ImageView img3 = (ImageView) view.findViewById(R.id.imgv_swipe_3);

                if(Data.temps == 3){
                    img3.setImageResource(Data.img[1]);
                    img3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            autreActivite("changement");
                        }
                    });
                } else if(Data.temps == 4){

                    img3.setImageResource(Data.img[2]);

                    img3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment f = new OngletsFragment();

                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
                            Data.election_choisie = Data.tab_calendrier_election[1][3];
                            ((MainActivity) getActivity()).swipe();
                        }
                    });
                }

            }

            ((ViewPager) collection).addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        private void autreActivite(String act){
            Intent i = null;
            if(act.equals("changement")) {
                i = new Intent(getActivity(), ActualitesActivity.class);
                i.putExtra("cle", 1);
            } else if(act.equals("connexion")) {
                i = new Intent(getActivity(), PageDeConnexionActivity.class);
            }

            startActivity(i);
        }


    }


}
