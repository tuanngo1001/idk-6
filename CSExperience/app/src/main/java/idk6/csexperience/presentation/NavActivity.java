package idk6.csexperience.presentation;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import idk6.csexperience.R;
import idk6.csexperience.business.GameServices;


public class NavActivity extends StartActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_home);


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_activities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ActivitiesFragment()).commit();
                break;

            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalendarFragment()).commit();
                break;

            case R.id.nav_jobs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new JobsFragment()).commit();
                break;

            case R.id.nav_store:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StoreFragment()).commit();
                break;

            case R.id.nav_load:
                //TODO
                //Load game
                Toast.makeText(NavActivity.this,
                        "Slot "+ "getSlotNumber"+ " Loaded!", Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_save:
                //TODO
                //Save game
                GameServices gs = new GameServices();
                gs.save();

                Toast.makeText(NavActivity.this,
                        "Game Saved!", Toast.LENGTH_LONG).show();
                break;
        }
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

