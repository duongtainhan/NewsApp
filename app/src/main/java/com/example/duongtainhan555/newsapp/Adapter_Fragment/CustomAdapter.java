package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Models.FeedItem;
import com.example.duongtainhan555.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<FeedItem> {

    CustomAdapter(Context context, int resource, List<FeedItem> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_news, null);
        }
        FeedItem feedItem = getItem(position);
        if (feedItem != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = view.findViewById(R.id.txtTitle);
            txtTitle.setText(feedItem.getTitle());
            ImageView imgThumbnail = view.findViewById(R.id.imgThumbnail);
            Picasso.get().load(feedItem.getThumbnail()).into(imgThumbnail);
            TextView txtDescription = view.findViewById(R.id.txtDescription);
            txtDescription.setText(feedItem.getDescription());
        }
        return view;
    }

}