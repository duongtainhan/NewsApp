package com.example.duongtainhan555.newsapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imgSelectPage, imgSelectType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        Init();
        SetPagerView();
    }
    private void Init()
    {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        imgSelectPage = findViewById(R.id.imgSelectPage);
        imgSelectType = findViewById(R.id.imgSelectType);

    }
    private void SetPagerView()
    {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("Fragment 1"),"Test Fragment 1");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 2"),"Test Fragment 2");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 3"),"Test Fragment 3");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 4"),"Test Fragment 4");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 5"),"Test Fragment 5");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 6"),"Test Fragment 6");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 7"),"Test Fragment 7");
        pagerAdapter.AddFragment(new NewsFragment("Fragment 8"),"Test Fragment 8");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
