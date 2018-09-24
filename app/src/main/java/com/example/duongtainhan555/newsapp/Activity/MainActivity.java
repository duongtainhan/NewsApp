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
import android.view.View;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Adapter_Fragment.NewsFragment;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.PagerAdapter;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.TypeAdapter;
import com.example.duongtainhan555.newsapp.Content.Key;
import com.example.duongtainhan555.newsapp.Interface.PositionListView;
import com.example.duongtainhan555.newsapp.Models.News.TypeItem;
import com.example.duongtainhan555.newsapp.Models.Page.PageNews;
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
    private String title = "";
    private Dialog dialog;
    private PagerAdapter pagerAdapter;
    private ArrayList<Integer> arrPos;
    private PageNews pageNews;

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
        toolbar.setTitle(title);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void PageZingNews() {
        title = Key.namePage.zing_news;
        for (int i = 0; i < Key.length.zing_news; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.zing_news[i], "zing_news"), Key.title.zing_news[i]);
        }
    }

    private void PageVnExpress() {
        title = Key.namePage.vn_express;
        for (int i = 0; i < Key.length.vn_express; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vn_express[i], "vn_express"), Key.title.vn_express[i]);
        }
    }

    private void PageDanTri() {
        title = Key.namePage.dan_tri;
        for (int i = 0; i < Key.length.dan_tri; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.dan_tri[i], "dan_tri"), Key.title.dan_tri[i]);
        }
    }

    private void Page24h() {
        title = Key.namePage.hai_tu_gio;
        for (int i = 0; i < Key.length.hai_tu_gio; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.hai_tu_gio[i], "24h"), Key.title.hai_tu_gio[i]);
        }

    }

    private void PageKenh14() {
        title = Key.namePage.kenh_14;
        for (int i = 0; i < Key.length.kenh_14; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.kenh_14[i], "kenh_14"), Key.title.kenh_14[i]);
        }

    }

    private void PageVietNameNet() {
        title = Key.namePage.vietnam_net;
        for (int i = 0; i < Key.length.vietnam_net; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vietnam_net[i], "vietnam_net"), Key.title.vietnam_net[i]);
        }

    }

    private void PageDoiSong() {
        title = Key.namePage.doi_song;
        for (int i = 0; i < Key.length.doi_song; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.doi_song[i], "doisong_phapluat"), Key.title.doi_song[i]);
        }

    }

    private void PageNguoiDuaTin() {
        title = Key.namePage.nguoi_dua_tin;
        for (int i = 0; i < Key.length.nguoi_dua_tin; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.nguoi_dua_tin[i], "nguoi_dua_tin"), Key.title.nguoi_dua_tin[i]);
        }
    }

    private void PageNgoiSao() {
        title = Key.namePage.ngoi_sao;
        for (int i = 0; i < Key.length.vn_express; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.ngoi_sao[i], "ngoi_sao"), Key.title.ngoi_sao[i]);
        }
    }

    private void PageGenk() {
        title = Key.namePage.genk;
        for (int i = 0; i < Key.length.genk; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.genk[i], "genk"), Key.title.genk[i]);
        }

    }

    private void PageSoHa() {
        title = Key.namePage.so_ha;
        for (int i = 0; i < Key.length.so_ha; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.so_ha[i], "so_ha"), Key.title.so_ha[i]);
        }
    }

    private void PageVov() {
        title = Key.namePage.vov;
        for (int i = 0; i < Key.length.vov; i++) {
            pagerAdapter.AddFragment(new NewsFragment(Key.url.vov[i], "vov"), Key.title.vov[i]);
        }
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
                        if (buttonIndex == 1) {
                            FilterTypeNews();
                        } else if (buttonIndex == 2) {
                        }
                    }
                })
                .init(boomMenuButton);
    }

    private void FilterTypeNews() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_type_news);
        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        ArrayList<TypeItem> arrTypeNews = new ArrayList<>();
        int lenghtTitle = 0;
        switch (title) {
        }
        for (int i = 0; i <= 27; i++) {
            TypeItem typeItem = new TypeItem();
            typeItem.setTypeNews("View " + i);
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
        Toast.makeText(this, pos + "", Toast.LENGTH_SHORT).show();
    }

    public void ClickOKButton(View view) {
        dialog.cancel();
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        if (!arrPos.isEmpty()) {
            for (int i = 1; i <= arrPos.size(); i++) {
                //pagerAdapter.AddFragment();
            }
            viewPager.setAdapter(pagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}
