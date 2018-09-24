package com.example.duongtainhan555.newsapp.Activity;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
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
import com.example.duongtainhan555.newsapp.Adapter_Fragment.PagerAdapter;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.TypeAdapter;
import com.example.duongtainhan555.newsapp.Content.Key;
import com.example.duongtainhan555.newsapp.Interface.PositionListView;
import com.example.duongtainhan555.newsapp.Models.News.TypeItem;
import com.example.duongtainhan555.newsapp.R;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;


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
    private String urlPage[];
    private String namePage;

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
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        arrPos = new ArrayList<>();
    }

    private void SetPage() {

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
        titleToolbar = Key.nameTitle.zing_news;
        for (int i = 0; i < Key.length.zing_news; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.zing_news[i], Key.namePage.zing_news), Key.title.zing_news[i]);
        }
        titlePage = Key.title.zing_news;
        urlPage = Key.url.zing_news;
        namePage = Key.namePage.zing_news;
    }

    private void PageVnExpress() {
        titleToolbar = Key.nameTitle.vn_express;
        for (int i = 0; i < Key.length.vn_express; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vn_express[i],Key.namePage.vn_express), Key.title.vn_express[i]);
        }
        titlePage = Key.title.vn_express;
        urlPage = Key.url.vn_express;
        namePage = Key.namePage.vn_express;
    }

    private void PageDanTri() {
        titleToolbar = Key.nameTitle.dan_tri;
        for (int i = 0; i < Key.length.dan_tri; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.dan_tri[i], Key.namePage.dan_tri), Key.title.dan_tri[i]);
        }
        titlePage = Key.title.dan_tri;
        urlPage = Key.url.dan_tri;
        namePage = Key.namePage.dan_tri;
    }

    private void Page24h() {
        titleToolbar = Key.nameTitle.hai_tu_gio;
        for (int i = 0; i < Key.length.hai_tu_gio; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.hai_tu_gio[i], Key.namePage.hai_tu_gio), Key.title.hai_tu_gio[i]);
        }
        titlePage = Key.title.hai_tu_gio;
        urlPage = Key.url.hai_tu_gio;
        namePage = Key.namePage.hai_tu_gio;
    }

    private void PageKenh14() {
        titleToolbar = Key.nameTitle.kenh_14;
        for (int i = 0; i < Key.length.kenh_14; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.kenh_14[i], Key.namePage.kenh_14), Key.title.kenh_14[i]);
        }
        titlePage = Key.title.kenh_14;
        urlPage = Key.url.kenh_14;
        namePage = Key.namePage.kenh_14;
    }

    private void PageVietNameNet() {
        titleToolbar = Key.nameTitle.vietnam_net;
        for (int i = 0; i < Key.length.vietnam_net; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vietnam_net[i], Key.namePage.vietnam_net), Key.title.vietnam_net[i]);
        }
        titlePage = Key.title.vietnam_net;
        urlPage = Key.url.vietnam_net;
        namePage = Key.namePage.vietnam_net;
    }

    private void PageDoiSong() {
        titleToolbar = Key.nameTitle.doi_song;
        for (int i = 0; i < Key.length.doi_song; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.doi_song[i], Key.namePage.doi_song), Key.title.doi_song[i]);
        }
        titlePage = Key.title.doi_song;
        urlPage = Key.url.doi_song;
        namePage = Key.namePage.doi_song;
    }

    private void PageNguoiDuaTin() {
        titleToolbar = Key.nameTitle.nguoi_dua_tin;
        for (int i = 0; i < Key.length.nguoi_dua_tin; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.nguoi_dua_tin[i], Key.namePage.nguoi_dua_tin), Key.title.nguoi_dua_tin[i]);
        }
        titlePage = Key.title.nguoi_dua_tin;
        urlPage = Key.url.nguoi_dua_tin;
        namePage = Key.namePage.nguoi_dua_tin;
    }

    private void PageNgoiSao() {
        titleToolbar = Key.nameTitle.ngoi_sao;
        for (int i = 0; i < Key.length.vn_express; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.ngoi_sao[i], Key.namePage.ngoi_sao), Key.title.ngoi_sao[i]);
        }
        titlePage = Key.title.ngoi_sao;
        urlPage = Key.url.ngoi_sao;
        namePage = Key.namePage.ngoi_sao;
    }

    private void PageGenk() {
        titleToolbar = Key.nameTitle.genk;
        for (int i = 0; i < Key.length.genk; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.genk[i], Key.namePage.genk), Key.title.genk[i]);
        }
        titlePage = Key.title.genk;
        urlPage = Key.url.genk;
        namePage = Key.namePage.genk;
    }

    private void PageSoHa() {
        titleToolbar = Key.nameTitle.so_ha;
        for (int i = 0; i < Key.length.so_ha; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.so_ha[i], Key.namePage.so_ha), Key.title.so_ha[i]);
        }
        titlePage = Key.title.so_ha;
        urlPage = Key.url.so_ha;
        namePage = Key.namePage.so_ha;
    }

    private void PageVov() {
        titleToolbar = Key.nameTitle.vov;
        for (int i = 0; i < Key.length.vov; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vov[i], Key.namePage.vov), Key.title.vov[i]);
        }
        titlePage = Key.title.vov;
        urlPage = Key.url.vov;
        namePage = Key.namePage.vov;
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
        //
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

    public void ClickOKButton(View view) {
        dialog.cancel();
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        if (!arrPos.isEmpty()) {
            for (int i = 0; i < arrPos.size(); i++) {
                pagerAdapter.AddFragment(new NewsFragment(urlPage[arrPos.get(i)], namePage), titlePage[arrPos.get(i)]);
            }
            viewPager.setAdapter(pagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            arrPos.clear();
        }
    }
}
