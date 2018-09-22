package com.example.duongtainhan555.newsapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Adapter_Fragment.VideoAdapter;
import com.example.duongtainhan555.newsapp.Interface.RequestInterface;
import com.example.duongtainhan555.newsapp.Models.Video.Item;
import com.example.duongtainhan555.newsapp.Models.Video.VideoItem;
import com.example.duongtainhan555.newsapp.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;
    private VideoItem videoItem;
    private ArrayList<Item> arrayItems;
    private VideoAdapter videoAdapter;
    private String key_search;
    private ListView listVideo;
    private static final String base_url="https://www.googleapis.com/youtube/v3/";
    private static final String key="AIzaSyAsaI7Evp_fk_R_G6LJCBA5I-EBJXA7zIY";
    private ImageView imgBack;
    private TextView txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        //Init
        Init();
        //LoadJson
        loadJSON(base_url);
        //Event
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Init()
    {
        compositeDisposable = new CompositeDisposable();
        videoItem = new VideoItem();
        arrayItems = new ArrayList<>();
        listVideo = findViewById(R.id.listVideo);
        key_search = getIntent().getStringExtra("key_search");
        txtBack = findViewById(R.id.txtBackMain);
        imgBack = findViewById(R.id.imgBackMain);
    }
    private void loadJSON(String url)
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        RequestInterface requestInterface = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);
        Disposable disposable = requestInterface.register("snippet",key_search,"20","video",key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError, this::handleSuccess);
        compositeDisposable.add(disposable);
    }
    private void handleResponse(VideoItem itemVideo) {
        videoItem = itemVideo;
        for(int i=0;i<videoItem.getItems().size();i++)
        {
            Item item = new Item();
            item.setSnippet(videoItem.getItems().get(i).getSnippet());
            item.setId(videoItem.getItems().get(i).getId());
            arrayItems.add(item);
            //Log.d("BBB",videoItems2.getItems().get(i).getSnippet().getThumbnails().getMedium().getUrl());
        }
        //Log.d("CCC",arrayItems.get(1).getId().getVideoId());
        videoAdapter = new VideoAdapter(YoutubeActivity.this,R.layout.layout_video,arrayItems);
        listVideo.setAdapter(videoAdapter);
    }
    private void handleError(Throwable error) {

        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void handleSuccess() {
        Toast.makeText(this, "Kết nối thành công! ", Toast.LENGTH_SHORT).show();
    }
}
