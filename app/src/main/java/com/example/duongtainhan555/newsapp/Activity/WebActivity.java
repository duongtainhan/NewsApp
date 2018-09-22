package com.example.duongtainhan555.newsapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duongtainhan555.newsapp.R;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    TextView txtBack;
    ImageView imgBack;
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
        //
        txtBack = findViewById(R.id.txtBack);
        imgBack = findViewById(R.id.imgBack);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
