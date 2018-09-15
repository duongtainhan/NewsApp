package com.example.duongtainhan555.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //
        webView = findViewById(R.id.webView);
        Intent intentNews = getIntent();
        String linkURL = intentNews.getStringExtra("link");
        webView.loadUrl(linkURL);
        webView.setWebViewClient(new WebViewClient());
    }
}
