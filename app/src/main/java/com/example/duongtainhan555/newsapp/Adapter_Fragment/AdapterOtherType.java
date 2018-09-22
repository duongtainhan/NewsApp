package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Models.News.FeedItem;
import com.example.duongtainhan555.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterOtherType extends ArrayAdapter<FeedItem> {
    public AdapterOtherType(@NonNull Context context, int resource, @NonNull List<FeedItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_other_type, null);
        }
        FeedItem feedItem = getItem(position);
        if (feedItem != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = view.findViewById(R.id.txtTypeTitle);
            txtTitle.setText(feedItem.getTitle());
            ImageView imgThumbnail = view.findViewById(R.id.imgTypeThumbnail);
            Picasso.get().load(feedItem.getThumbnail()).into(imgThumbnail);
        }
        return view;
    }
}
