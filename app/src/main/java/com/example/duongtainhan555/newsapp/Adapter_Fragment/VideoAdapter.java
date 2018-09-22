package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.Models.Video.Item;
import com.example.duongtainhan555.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Item> {
    public VideoAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        if(view==null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.layout_video,null);
        }
        Item items = getItem(position);
        if(items!=null)
        {
            ImageView imgThumbnails = view.findViewById(R.id.imgThumbnailVideo);
            Picasso.get().load(items.getSnippet().getThumbnails().getMedium().getUrl()).into(imgThumbnails);
            TextView txtTitle = view.findViewById(R.id.txtTitleVideo);
            txtTitle.setText(items.getSnippet().getTitle());
        }
        return view;
    }
}
