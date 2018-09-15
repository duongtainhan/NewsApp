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
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/tin-moi.rss"),"Tin mới ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/thoi-su.rss"),"Thời sự");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/the-gioi.rss"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/kinh-doanh-tai-chinh.rss"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/phap-luat.rss"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/xuat-ban.rss"),"Xuất bản");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/the-thao.rss"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/cong-nghe.rss"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/oto-xe-may.rss"),"Ô tô – Xe máy");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/giai-tri.rss"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/am-nhac.rss"),"Âm nhạc");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/phim-anh.rss"),"Phim ảnh");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/thoi-trang.rss"),"Thời trang");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/song-tre.rss"),"Sống trẻ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/giao-duc.rss"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/du-lich.rss"),"Du lịch");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/suc-khoe.rss"),"Sức khoẻ");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
