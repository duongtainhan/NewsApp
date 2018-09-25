package com.example.duongtainhan555.newsapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import com.example.duongtainhan555.newsapp.Adapter_Fragment.PageItemAdapter;
import com.example.duongtainhan555.newsapp.Models.Page.PageItem;
import com.example.duongtainhan555.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class SelectPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);

        List<PageItem> pageItems = new ArrayList<>();
        pageItems.add(new PageItem(R.string.zing_news,R.drawable.zing_news));
        pageItems.add(new PageItem(R.string.vn_express,R.drawable.vn_express));
        pageItems.add(new PageItem(R.string.dan_tri,R.drawable.dan_tri));
        pageItems.add(new PageItem(R.string.hai_tu_gio,R.drawable.hai_tu_gio));
        pageItems.add(new PageItem(R.string.kenh_14,R.drawable.kenh_14));
        pageItems.add(new PageItem(R.string.vietnam_net,R.drawable.vietnam_net));
        pageItems.add(new PageItem(R.string.doi_song,R.drawable.doisong_phapluat));
        pageItems.add(new PageItem(R.string.nguoi_dua_,R.drawable.nguoi_dua_tin));
        pageItems.add(new PageItem(R.string.ngoi_sao,R.drawable.ngoi_sao));
        pageItems.add(new PageItem(R.string.genk,R.drawable.genk));
        pageItems.add(new PageItem(R.string.so_ha,R.drawable.so_hoa));
        pageItems.add(new PageItem(R.string.vov,R.drawable.vov_vn));
        RecyclerView recyclerView = findViewById(R.id.recycler);
        PageItemAdapter pageItemAdapter = new PageItemAdapter(SelectPageActivity.this, pageItems);
        GridLayoutManager layoutManager = new GridLayoutManager(SelectPageActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pageItemAdapter);
    }
}
