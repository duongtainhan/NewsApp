package com.example.duongtainhan555.newsapp.Models;

public class FeedItem {
    private String title;
    private String description;
    private String pubDate;
    private String thumbnail;
    private String link;
    private String name;

    public FeedItem(String title, String description, String pubDate, String thumbnail, String link,String name) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.thumbnail = thumbnail;
        this.link = link;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLink() {
        return link;
    }

    public String getName(){return name;}
}
