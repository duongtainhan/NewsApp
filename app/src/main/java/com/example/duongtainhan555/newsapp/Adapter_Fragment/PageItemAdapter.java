package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Activity.MainActivity;
import com.example.duongtainhan555.newsapp.Models.Page.PageItem;
import com.example.duongtainhan555.newsapp.R;

import java.util.List;

public class PageItemAdapter extends RecyclerView.Adapter<PageItemAdapter.ViewHolder> {
    Context context;
    List<PageItem> pageItems;

    public PageItemAdapter(Context context, List<PageItem> pageItems) {
        this.context = context;
        this.pageItems = pageItems;
    }
    @NonNull
    @Override
    public PageItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_page,viewGroup,false);
        return new PageItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PageItem pageItem = pageItems.get(i);
        viewHolder.txtNamePage.setText(pageItem.getNamePage());
        viewHolder.imgThumnailPage.setImageResource(pageItem.getThumnailPage());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String page_selected="";
                switch (viewHolder.getAdapterPosition())
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
                        page_selected="ngoi_sao";
                        break;
                    case 9:
                        page_selected="genk";
                        break;
                    case 10:
                        page_selected="so_ha";
                        break;
                    case 11:
                        page_selected="vov_vn";
                        break;
                }
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("page_selected",page_selected);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return pageItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamePage;
        ImageView imgThumnailPage;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamePage = itemView.findViewById(R.id.txtNamePage);
            imgThumnailPage = itemView.findViewById(R.id.imgThumnailPage);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
