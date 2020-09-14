package com.project.duchennesebastien.elections;

import com.project.duchennesebastien.ALaUneFragment;
import com.project.duchennesebastien.CalendrierFragment;
import com.project.duchennesebastien.Data;
import com.project.duchennesebastien.ElectionsEnFranceFragment;
import com.project.duchennesebastien.FAQFragment;
import com.project.duchennesebastien.OngletsFragment;
import com.project.duchennesebastien.PageDeConnexionActivity;
import com.project.duchennesebastien.ParametresFragment;
import com.project.duchennesebastien.TempsFragment;
import com.project.duchennesebastien.adapter.NavDrawerListAdapter;
import com.project.duchennesebastien.model.NavDrawerItem;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data.temps = 1;
        Data.election_choisie = Data.tab_calendrier_election[1][3];
        Data.departementChoisi = Data.tab_parametres[2][1];
        Data.cantonChoisi = Data.tab_parametres[3][1];

        mTitle = mDrawerTitle = getTitle();

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));// a la une
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));// ma prochaine élection
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1))); // calendrier
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1))); // informations clé
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));// faq
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1))); // paramètres
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));// quitter
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1)));// temps

        //navDrawerItems.set(1, new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));// ma prochaine élection

        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            if(Data.acces == 1){
                Data.acces = 0;
                displayView(1);

            } else if(Data.acces == 3){
                Data.acces = 0;
                displayView(1);
            } else {
                displayView(0);
            }

        }



    }

    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        Fragment fragment = null;

        String MessageNotif;
        String DetailsNotif;

        switch (position) {
            case 0:
                fragment = new ALaUneFragment();

                if(Data.temps == 2){
                    MessageNotif = "La liste des candidats est disponible.";
                    DetailsNotif = "";

                    createNotification(MessageNotif, MessageNotif, DetailsNotif);

                } else if(Data.temps == 3){
                    MessageNotif = "Vous êtes appelé à voter.";
                    DetailsNotif = "";

                    createNotification(MessageNotif, MessageNotif, DetailsNotif);

                } else if(Data.temps == 4){
                    MessageNotif = "Les résultats sont disponibles.";
                    DetailsNotif = "";

                    createNotification(MessageNotif, MessageNotif, DetailsNotif);
                }


                break;

            case 1:
                Data.election_choisie = Data.tab_calendrier_election[1][3];
                fragment = new OngletsFragment();

                break;
            case 2:
                fragment = new CalendrierFragment();
                break;
            case 3:
                fragment = new ElectionsEnFranceFragment();
                break;
            case 4:
                fragment = new FAQFragment();
                break;
            case 5:
                fragment = new ParametresFragment();
                break;
            case 6:
                System.exit(0);
                break;
            case 7:
                fragment = new TempsFragment();
                break;

            default:
                break;
        }


        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        }

        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        setTitle(navMenuTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    private static final int MY_NOTIFICATION_ID=1;

    public final void createNotification(String titre, String message, String details){
        /*final NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        final Notification notification = new Notification(R.mipmap.ic_launcher, titre, System.currentTimeMillis());
        PendingIntent pendingIntent = null;
        if(Data.temps == 2){
            pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        } else if(Data.temps == 3){
            pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, PageDeConnexionActivity.class), 0);
        } else if(Data.temps == 4){
            pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, MainActivity.class), 0);
        }
        notification.setLatestEventInfo(this, message, details, pendingIntent);

        notificationManager.notify(NOTIFICATION_ID, notification);
*/
        if(!Data.aRecuNotification){
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Notification myNotification = new Notification(R.mipmap.ic_launcher, titre, System.currentTimeMillis());
            Context context = getApplicationContext();
            String notificationTitle = message;
            String notificationText = details;
            Intent myIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,   myIntent, Intent.FILL_IN_ACTION);
            myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
            myNotification.setLatestEventInfo(context, notificationTitle, notificationText, pendingIntent);
            myNotification.vibrate = new long[] {0,200,100,200,100,200};
            notificationManager.notify(MY_NOTIFICATION_ID, myNotification);
        }
        Data.aRecuNotification = true;

    }

    protected void onNewIntent(Intent intent) {
        if(Data.temps == 2 || Data.temps == 4){
            Fragment f = new OngletsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
            Data.election_choisie = Data.tab_calendrier_election[1][3];
        } else if(Data.temps == 3){
            Intent i = new Intent(this, PageDeConnexionActivity.class);
            startActivity(i);
        }

    }

    public void swipe() {
        getActionBar().setTitle(Data.election_choisie);
        mDrawerList.setItemChecked(1, true);
        mDrawerList.setSelection(1);
        mTitle = Data.election_choisie;
    }

    public void setTitreActionBar(String titre){
        getActionBar().setTitle(titre);
        mTitle = Data.election_choisie;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


    @Override
    public void onResume(){
        super.onResume();
        if(Data.acces == 2 || Data.acces == 4){
            Fragment f = new OngletsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, f).commit();
            Data.election_choisie = Data.tab_calendrier_election[1][3];

            mDrawerList.setItemChecked(1, true);
            mDrawerList.setSelection(1);
        }

    }


}