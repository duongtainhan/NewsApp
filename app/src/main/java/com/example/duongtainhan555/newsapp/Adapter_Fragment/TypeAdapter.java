package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Interface.PositionListView;
import com.example.duongtainhan555.newsapp.Models.TypeItem;
import com.example.duongtainhan555.newsapp.R;

import java.util.List;

public class TypeAdapter extends ArrayAdapter<TypeItem> {
    PositionListView positionListView;
    public TypeAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_type_news, null);
        }
        TypeItem typeItem = getItem(position);
        if(typeItem!=null)
        {
            TextView txtTypeNews = view.findViewById(R.id.txtTypeNews);
            txtTypeNews.setText(typeItem.getTypeNews());
            CheckBox cbTypeNews = view.findViewById(R.id.cbTypeNews);
            cbTypeNews.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(cbTypeNews.isChecked())
                    {
                        positionListView = (PositionListView) getContext();
                        positionListView.PosList(position);
                    }
                }
            });
        }
        return view;
    }
}
