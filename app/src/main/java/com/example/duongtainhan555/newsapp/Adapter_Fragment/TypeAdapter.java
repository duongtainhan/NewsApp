package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Interface.PositionListView;
import com.example.duongtainhan555.newsapp.Models.News.TypeItem;
import com.example.duongtainhan555.newsapp.R;

import java.util.ArrayList;


public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {
    Context context;
    ArrayList<TypeItem> arrTypeNews;
    PositionListView positionListView;

    public TypeAdapter(Context context, ArrayList<TypeItem> arrTypeNews) {
        this.context = context;
        this.arrTypeNews = arrTypeNews;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_type_news,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TypeItem typeItem = arrTypeNews.get(i);
        viewHolder.txtTypeNews.setText(typeItem.getTypeNews());
        viewHolder.cbTypeNews.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked())
                {
                    positionListView = (PositionListView) buttonView.getContext();
                    positionListView.PosList(viewHolder.getAdapterPosition());
                }
                else if(!buttonView.isChecked())
                {
                    positionListView = (PositionListView) buttonView.getContext();
                    positionListView.RemovePos(viewHolder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrTypeNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTypeNews;
        CheckBox cbTypeNews;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTypeNews = itemView.findViewById(R.id.txtTypeNews);
            cbTypeNews = itemView.findViewById(R.id.cbTypeNews);
        }
    }
}
