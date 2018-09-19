package com.example.duongtainhan555.newsapp.Adapter_Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Activity.WebActivity;
import com.example.duongtainhan555.newsapp.Models.FeedItem;
import com.example.duongtainhan555.newsapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class NewsFragment extends Fragment {

    private List<FeedItem> feedItems = new ArrayList<>();
    View view;
    CustomAdapter customAdapter;
    String url;
    String page_name;
    ListView listView;

    public NewsFragment(String url, String page_name) {
        this.url = url;
        this.page_name = page_name;
        Log.d("AAA",this.url);
        Log.d("BBB",this.page_name);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        listView = view.findViewById(R.id.listView);
        feedItems = new ArrayList<>();
        new LoadRss().execute(url);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentNews = new Intent(view.getContext(), WebActivity.class);
                intentNews.putExtra("link", feedItems.get(position).getLink());
                startActivity(intentNews);
            }
        });
        return view;
    }

    private class LoadRss extends AsyncTask<String, Void, ArrayList<FeedItem>> {
        @Override
        protected ArrayList<FeedItem> doInBackground(String... params) {

            String url_rss = params[0];

            switch (page_name) {
                case "zing_news":
                    SetPageZing(url_rss);
                    break;
                case "vn_express":
                    SetPageVnExpress(url_rss);
                    break;
                case "dan_tri":
                    SetPageDanTri(url_rss);
                    break;
                case "24h":
                    SetPage24h(url_rss);
                    break;
                case "kenh_14":
                    SetPageKenh14(url_rss);
                    break;
                case "vietnam_net":
                    SetPageVietNam(url_rss);
                    break;
            }

            return (ArrayList<FeedItem>) feedItems;
        }

        @Override
        protected void onPostExecute(ArrayList<FeedItem> feedItems) {
            customAdapter = new CustomAdapter(getActivity(), android.R.layout.simple_list_item_1, feedItems);
            listView.setAdapter(customAdapter);
            super.onPostExecute(feedItems);
        }
    }

    private void SetPageZing(String url_rss) {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                String imageUrl = "";
                try {
                    imageUrl = item.select("enclosure").get(0).attr("url");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link, page_name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SetPageVnExpress(String url_rss) {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link, page_name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SetPageDanTri(String url_rss) {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link, page_name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SetPage24h(String url_rss) {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text().replaceAll("&#34;", "\"");
                String link = item.select("link").text();
                String description = item.select("description").html().replaceAll("&lt;", "<");
                description = description.replaceAll("&gt;", ">");
                description = description.replaceAll("&amp;amp;#34;", "\"");
                description = description.replaceAll("<br />", "");
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                if (!imageUrl.isEmpty())
                    feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link, page_name));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void SetPageKenh14(String url_rss)
    {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                }catch (Exception ex){}

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link,page_name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void SetPageVietNam(String url_rss)
    {
        try {
            Document doc = Jsoup.connect(url_rss).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                }catch (Exception ex){}

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");

                feedItems.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link,page_name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
