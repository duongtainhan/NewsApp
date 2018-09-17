package com.example.duongtainhan555.newsapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.example.duongtainhan555.newsapp.R;

public class SelectPageActivity extends AppCompatActivity {

    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);
        mainGrid = findViewById(R.id.mainGrid);
        //Set Event
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                String page_selected;
                @Override
                public void onClick(View view) {
                    switch (finalI)
                    {
                        case 0:
                            page_selected="zing_news";
                            break;
                        case 1:
                            page_selected="vn_express";
                            break;
                        case 2:
                            page_selected="dan_tri";
                            break;
                        case 3:
                            page_selected="24_h";
                            break;
                        case 4:
                            page_selected="kenh_14";
                            break;
                        case 5:
                            page_selected="vietnam_net";
                            break;
                        case 6:
                            page_selected="doisong_phapluat";
                            break;
                        case 7:
                            page_selected="nguoi_dua_tin";
                            break;
                        case 8:
                            page_selected="tuoi_tre";
                            break;
                        case 9:
                            page_selected="genk";
                            break;
                        case 10:
                            page_selected="so_hoa";
                            break;
                        case 11:
                            page_selected="vov_vn";
                            break;
                    }
                    Intent intent = new Intent(SelectPageActivity.this,MainActivity.class);
                    intent.putExtra("page_selected",page_selected);
                    startActivity(intent);
                }
            });
        }
    }
}
