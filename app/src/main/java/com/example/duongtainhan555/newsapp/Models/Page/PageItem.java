package com.example.duongtainhan555.newsapp.Models.Page;

public class PageItem {
    private final int namePage;
    private final int thumnailPage;

    public PageItem(int namePage, int thumnailPage) {
        this.namePage = namePage;
        this.thumnailPage = thumnailPage;
    }

    public int getNamePage() {
        return namePage;
    }

    public int getThumnailPage() {
        return thumnailPage;
    }
}
