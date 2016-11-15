package com.scm.subodhyadav.teachneedy;

import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GalleryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @SuppressWarnings("deprecation")
    Gallery Imagegallery;
    Integer[] GalleryImagesList =
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
                    R.drawable.six,
                    R.drawable.seven
            };
    ImageView imgGalleryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                GalleryActivity.this.startActivity(new Intent(GalleryActivity.this, ContactActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_gallery);
        navigationView.setNavigationItemSelectedListener(this);

        imgGalleryImage = (ImageView)findViewById(R.id.imgGalleryImage);
        imgGalleryImage.setImageResource(R.drawable.one);

        Imagegallery = (Gallery)findViewById(R.id.gallery);
        Imagegallery.setAdapter(new ImageAdapter(this));
        Imagegallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                imgGalleryImage.setImageResource(GalleryImagesList[position]);
            }
        });
    }

    private class ImageAdapter extends BaseAdapter
    {
        Context context;
        public ImageAdapter(Context context)
        {
            this.context = context;
        }
        @Override
        public int getCount()
        {
            return GalleryImagesList.length;
        }

        @Override
        public Object getItem(int position)
        {
            return GalleryImagesList[position];
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(this.context);
            imageView.setImageResource(GalleryImagesList[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            return imageView;
        }

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
        getMenuInflater().inflate(R.menu.gallery, menu);
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
            Intent myIntent = new Intent(GalleryActivity.this, HomeActivity.class);
            GalleryActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_gallery) {
            Intent myIntent = new Intent(GalleryActivity.this, GalleryActivity.class);
            GalleryActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(GalleryActivity.this, MovementActivity.class);
            GalleryActivity.this.startActivity(myIntent);

        }
//        else if (id == R.id.nav_manage) {
//            Intent myIntent = new Intent(HomeActivity.this, Tools.class);
//            HomeActivity.this.startActivity(myIntent);
//        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent myIntent = new Intent(GalleryActivity.this, ContactActivity.class);
            GalleryActivity.this.startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
