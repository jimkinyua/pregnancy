package com.example.jim.uzazi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity_Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int Week_Inside_Activity_2;
    ViewPager mViewPager;
    SectionsPagerAdapter mSectionsPagerAdapter;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Week_Inside_Activity_2 = Receive_Data_From_ActivityMain();
        Send_Data_To_Fragment();

        setTitle("You are "+ Week_Inside_Activity_2 + " Weeks Pregnant");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);


        mViewPager= findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mSectionsPagerAdapter.addpage(BabyFragment.newInstance(2));
        mSectionsPagerAdapter.addpage(MotherFragment.newInstance(2));
        mSectionsPagerAdapter.addpage(NutritionFragment.newInstance(3));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_camera) {
                    String title = "Doctor Appointment";
                    Intent intent = new Intent(Intent.ACTION_INSERT)
                            .setData(CalendarContract.Events.CONTENT_URI)
                            .putExtra(CalendarContract.Events.TITLE,title);
//                    .putExtra(CalendarContract.Events.EVENT_LOCATION,loation)
//                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,begin)
//                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,end);
                    if (intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }
                    return true;

                } else if (id == R.id.chat) {

                    //Send Message

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto: 0710467646"));
                    if(intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }


                } else if (id == R.id.nav_slideshow) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
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
        getMenuInflater().inflate(R.menu.main2_activity__drawer, menu);
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


//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            String title = "Doctor Appointment";
//            Intent intent = new Intent(Intent.ACTION_INSERT)
//                    .setData(CalendarContract.Events.CONTENT_URI)
//                    .putExtra(CalendarContract.Events.TITLE,title);
////                    .putExtra(CalendarContract.Events.EVENT_LOCATION,loation)
////                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,begin)
////                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,end);
//            if (intent.resolveActivity(getPackageManager())!=null){
//                startActivity(intent);
//            }
//            return true;
//
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return false;
//    }
    public int Receive_Data_From_ActivityMain(){
        int weekfromActivity1 = getIntent().getExtras().getInt("week");

        return  weekfromActivity1;
    }

    public void Send_Data_To_Fragment(){
        Bundle bundle = new Bundle();
        bundle.putInt("weekfromactivity2", Week_Inside_Activity_2);
        BabyFragment fragmentobj  = new BabyFragment();
        fragmentobj.setArguments(bundle);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
