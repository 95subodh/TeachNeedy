package com.scm.subodhyadav.teachneedy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MovementActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                MovementActivity.this.startActivity(new Intent(MovementActivity.this, ContactActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_slideshow);
        navigationView.setNavigationItemSelectedListener(this);

        Button don = (Button) findViewById(R.id.b_donate);
        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MovementActivity.this.startActivity(new Intent(MovementActivity.this, DonateActivity.class));
                // do something when the corky is clicked
            }
        });

        Button fell = (Button) findViewById(R.id.b_fellow);
        fell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovementActivity.this.startActivity(new Intent(MovementActivity.this, LocationPickActivity.class));
                // do something when the corky is clicked
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.movement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent myIntent = new Intent(MovementActivity.this, HomeActivity.class);
            MovementActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_gallery) {
            Intent myIntent = new Intent(MovementActivity.this, GalleryActivity.class);
            MovementActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(MovementActivity.this, MovementActivity.class);
            MovementActivity.this.startActivity(myIntent);

        }
//        else if (id == R.id.nav_manage) {
//            Intent myIntent = new Intent(HomeActivity.this, Tools.class);
//            HomeActivity.this.startActivity(myIntent);
//        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent myIntent = new Intent(MovementActivity.this, ContactActivity.class);
            MovementActivity.this.startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
