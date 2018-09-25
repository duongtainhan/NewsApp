package com.example.duongtainhan555.newsapp.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Adapter_Fragment.NewsFragment;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.PageItemAdapter;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.PagerAdapter;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.TypeAdapter;
import com.example.duongtainhan555.newsapp.Content.Key;
import com.example.duongtainhan555.newsapp.Interface.PositionListView;
import com.example.duongtainhan555.newsapp.Models.News.TypeItem;
import com.example.duongtainhan555.newsapp.Models.Page.PageItem;
import com.example.duongtainhan555.newsapp.R;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PositionListView {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean init = false;
    private BoomMenuButton boomMenuButton;
    private String titleToolbar = "";
    private Dialog dialog;
    private PagerAdapter pagerAdapter;
    private ArrayList<Integer> arrPos;
    private String titlePage[];
    private List<Fragment> listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        Init();
        SetPage();

    }

    private void Init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        boomMenuButton = findViewById(R.id.boom);
        arrPos = new ArrayList<>();
    }

    private void SetPage() {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        listFragment = new ArrayList<>();
        String page_selected = "";
        if (getIntent() != null) {
            page_selected = getIntent().getStringExtra("page_selected");
        }
        switch (page_selected) {
            case "zing_news":
                PageZingNews();
                break;
            case "vn_express":
                PageVnExpress();
                break;
            case "dan_tri":
                PageDanTri();
                break;
            case "24_h":
                Page24h();
                break;
            case "kenh_14":
                PageKenh14();
                break;
            case "vietnam_net":
                PageVietNameNet();
                break;
            case "doisong_phapluat":
                PageDoiSong();
                break;
            case "nguoi_dua_tin":
                PageNguoiDuaTin();
                break;
            case "ngoi_sao":
                PageNgoiSao();
                break;
            case "genk":
                PageGenk();
                break;
            case "so_ha":
                PageSoHa();
                break;
            case "vov_vn":
                PageVov();
                break;
        }
        toolbar.setTitle(titleToolbar);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void PageZingNews() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.zing_news;
        for (int i = 0; i < Key.length.zing_news; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.zing_news[i], Key.namePage.zing_news);
            pagerAdapter.AddFragment(newsFragment, Key.title.zing_news[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.zing_news;
    }

    private void PageVnExpress() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.vn_express;
        for (int i = 0; i < Key.length.vn_express; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.vn_express[i], Key.namePage.vn_express);
            pagerAdapter.AddFragment(newsFragment, Key.title.vn_express[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.vn_express;
    }

    private void PageDanTri() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.dan_tri;
        for (int i = 0; i < Key.length.dan_tri; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.dan_tri[i], Key.namePage.dan_tri);
            pagerAdapter.AddFragment(newsFragment, Key.title.dan_tri[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.dan_tri;
    }

    private void Page24h() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.hai_tu_gio;
        for (int i = 0; i < Key.length.hai_tu_gio; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.hai_tu_gio[i], Key.namePage.hai_tu_gio);
            pagerAdapter.AddFragment(newsFragment, Key.title.hai_tu_gio[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.hai_tu_gio;
    }

    private void PageKenh14() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.kenh_14;
        for (int i = 0; i < Key.length.kenh_14; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.kenh_14[i], Key.namePage.kenh_14);
            pagerAdapter.AddFragment(newsFragment, Key.title.kenh_14[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.kenh_14;
    }

    private void PageVietNameNet() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.vietnam_net;
        for (int i = 0; i < Key.length.vietnam_net; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.vietnam_net[i], Key.namePage.vietnam_net);
            pagerAdapter.AddFragment(newsFragment, Key.title.vietnam_net[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.vietnam_net;
    }

    private void PageDoiSong() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.doi_song;
        for (int i = 0; i < Key.length.doi_song; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.doi_song[i], Key.namePage.doi_song);
            pagerAdapter.AddFragment(newsFragment, Key.title.doi_song[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.doi_song;
    }

    private void PageNguoiDuaTin() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.nguoi_dua_tin;
        for (int i = 0; i < Key.length.nguoi_dua_tin; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.nguoi_dua_tin[i], Key.namePage.nguoi_dua_tin);
            pagerAdapter.AddFragment(newsFragment, Key.title.nguoi_dua_tin[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.nguoi_dua_tin;
    }

    private void PageNgoiSao() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.ngoi_sao;
        for (int i = 0; i < Key.length.ngoi_sao; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.ngoi_sao[i], Key.namePage.ngoi_sao);
            pagerAdapter.AddFragment(newsFragment, Key.title.ngoi_sao[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.ngoi_sao;
    }

    private void PageGenk() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.genk;
        for (int i = 0; i < Key.length.genk; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.genk[i], Key.namePage.genk);
            pagerAdapter.AddFragment(newsFragment, Key.title.genk[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.genk;
    }

    private void PageSoHa() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.so_ha;
        for (int i = 0; i < Key.length.so_ha; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.so_ha[i], Key.namePage.so_ha);
            pagerAdapter.AddFragment(newsFragment, Key.title.so_ha[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.so_ha;
    }

    private void PageVov() {
        listFragment.clear();
        titleToolbar = Key.nameTitle.vov;
        for (int i = 0; i < Key.length.vov; i++) {
            NewsFragment newsFragment = new NewsFragment(Key.url.vov[i], Key.namePage.vov);
            pagerAdapter.AddFragment(newsFragment, Key.title.vov[i]);
            listFragment.add(newsFragment);
        }
        titlePage = Key.title.vov;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (init) return;
        init = true;

        Drawable[] subButtonDrawables = new Drawable[3];
        int[] drawablesResource = new int[]{
                R.drawable.ic_select_page,
                R.drawable.ic_filter,
                R.drawable.ic_seen
        };
        for (int i = 0; i < 3; i++)
            subButtonDrawables[i] = ContextCompat.getDrawable(this, drawablesResource[i]);

        String[] subButtonTexts = new String[]{"Chọn trang báo", "Lọc thể loại yêu thích", "Tin tức đã xem"};

        int[][] subButtonColors = new int[3][2];
        for (int i = 0; i < 3; i++) {
            subButtonColors[i][1] = ContextCompat.getColor(this, R.color.color_blue);
            subButtonColors[i][0] = Util.getInstance().getPressedColor(subButtonColors[i][1]);
        }

        new BoomMenuButton.Builder()
                .subButtons(subButtonDrawables, subButtonColors, subButtonTexts)
                .button(ButtonType.HAM)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.HAM_3_1)
                .subButtonTextColor(ContextCompat.getColor(this, R.color.colorDarkGray))
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                    @Override
                    public void onClick(int buttonIndex) {
                        if(buttonIndex == 0)
                        {
                            SelectPageNews();
                        }
                        else
                        if (buttonIndex == 1) {
                            FilterTypeNews();
                        } else if (buttonIndex == 2) {
                        }
                    }
                })
                .init(boomMenuButton);
    }
    private void SelectPageNews()
    {
        Intent intent = new Intent(MainActivity.this,SelectPageActivity.class);
        startActivity(intent);
    }
    private void FilterTypeNews() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_type_news);
        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        ArrayList<TypeItem> arrTypeNews = new ArrayList<>();
        for (int i = 0; i < titlePage.length; i++) {
            TypeItem typeItem = new TypeItem();
            typeItem.setTypeNews(titlePage[i]);
            arrTypeNews.add(typeItem);
        }
        TypeAdapter typeAdapter = new TypeAdapter(MainActivity.this, arrTypeNews);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(typeAdapter);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    @Override
    public void PosList(int pos) {
        if (arrPos.isEmpty()) {
            arrPos.add(pos);
        } else {
            if (!arrPos.contains(pos)) {
                arrPos.add(pos);
            }
        }
    }

    @Override
    public void RemovePos(int pos) {
        arrPos.remove((Integer) pos);
    }

    public void ClickOKButton(View view) {
        dialog.cancel();
        if (!arrPos.isEmpty()) {
            PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
            for (int i = 0; i < arrPos.size(); i++) {
                pagerAdapter.AddFragment(listFragment.get(i), titlePage[arrPos.get(i)]);
            }
            viewPager.setAdapter(pagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            arrPos.clear();
        }
    }
}
