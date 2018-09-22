package com.example.duongtainhan555.newsapp.Models.Video;

import java.util.List;

import com.example.duongtainhan555.newsapp.Models.Video.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoItem {

@SerializedName("items")
@Expose
private List<Item> items = null;

public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

}