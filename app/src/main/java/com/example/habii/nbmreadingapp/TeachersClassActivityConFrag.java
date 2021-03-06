package com.example.habii.nbmreadingapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeachersClassActivityConFrag extends AppCompatActivity implements StudentFrag.OnFragmentInteractionListener,
        BooksFrag.OnFragmentInteractionListener,UploadFrag.OnFragmentInteractionListener,ApprovalFrag.OnFragmentInteractionListener {


    String post_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_class);


        Bundle extras = getIntent().getExtras();
        if(extras != null){

            post_id = extras.getString("postid");
        }

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Books"));
        tabLayout.addTab(tabLayout.newTab().setText("Upload"));
        tabLayout.addTab(tabLayout.newTab().setText("Student"));
        tabLayout.addTab(tabLayout.newTab().setText("Approve"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount(),post_id);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
