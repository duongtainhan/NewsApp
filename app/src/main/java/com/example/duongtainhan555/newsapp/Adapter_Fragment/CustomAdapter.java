package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.support.v7.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Activity.PopupActivity;
import com.example.duongtainhan555.newsapp.Activity.YoutubeActivity;
import com.example.duongtainhan555.newsapp.Models.FeedItem;
import com.example.duongtainhan555.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<FeedItem>{

    private ImageView imgOption;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<FeedItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
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

            imgOption = view.findViewById(R.id.imgOption);
            imgOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final PopupMenu popupMenu = new PopupMenu(getContext(),imgOption);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if(item.getItemId()==R.id.itemSearch)
                            {
                                Intent intent = new Intent(getContext(), YoutubeActivity.class);
                                intent.putExtra("key_search",feedItem.getTitle());
                                getContext().startActivity(intent);
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
            }
            });
        }
        return view;
    }
}