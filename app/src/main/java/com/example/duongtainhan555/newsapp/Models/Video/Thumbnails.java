package com.example.duongtainhan555.newsapp.Models.Video;

import com.example.duongtainhan555.newsapp.Models.Video.Medium;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

@SerializedName("medium")
@Expose
private Medium medium;

public Medium getMedium() {
return medium;
}

public void setMedium(Medium medium) {
this.medium = medium;
}

}