package com.example.duongtainhan555.newsapp.Interface;

import com.example.duongtainhan555.newsapp.Models.VideoItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    //https://www.googleapis.com/youtube/v3/search?part=snippet&q=lien%20minh&maxResults=50&type=video&key=AIzaSyAsaI7Evp_fk_R_G6LJCBA5I-EBJXA7zIY
    @GET("search")
    Observable<VideoItem> register(@Query("part") String part,
                                   @Query("q") String key_search,
                                   @Query("maxResults") String maxResults,
                                   @Query("type") String type,
                                   @Query("key") String key);
}