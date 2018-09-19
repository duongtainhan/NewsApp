package com.example.duongtainhan555.newsapp.Activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.duongtainhan555.newsapp.Adapter_Fragment.NewsFragment;
import com.example.duongtainhan555.newsapp.Adapter_Fragment.PagerAdapter;
import com.example.duongtainhan555.newsapp.R;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;


public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean init = false;
    private BoomMenuButton boomMenuButton;
    private String title="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init
        Init();
        SetPage();

    }
    private void Init()
    {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        boomMenuButton = findViewById(R.id.boom);

    }
    private void SetPage()
    {

        String page_selected="";
        if(getIntent() != null)
        {
            page_selected = getIntent().getStringExtra("page_selected");
        }
        switch (page_selected)
        {
            case "zing_news":
                PageZingNews();
                break;
            case "vn_express":
                PageVnExpress();
                break;
            case "dan_tri":
                PageDanTri();
                break;
            case "24_h":
                Page24h();
                break;
            case "kenh_14":
                PageKenh14();
                break;
            case "vietnam_net":
                PageVietNameNet();
                break;
            case "doisong_phapluat":
                PageDoiSong();
                break;
            case "nguoi_dua_tin":
                PageNguoiDuaTin();
                break;
            case "ngoi_sao":
                PageNgoiSao();
                break;
            case "genk":
                PageGenk();
                break;
            case "so_ha":
                PageSoHa();
                break;
            case "vov_vn":
                PageVov();
                break;
        }
        toolbar.setTitle(title);
    }
    private void PageZingNews()
    {
        title="ZING NEWS";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/tin-moi.rss","zing_news"),"Tin mới ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/thoi-su.rss","zing_news"),"Thời sự");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/the-gioi.rss","zing_news"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/kinh-doanh-tai-chinh.rss","zing_news"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/phap-luat.rss","zing_news"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/xuat-ban.rss","zing_news"),"Xuất bản");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/the-thao.rss","zing_news"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/cong-nghe.rss","zing_news"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/oto-xe-may.rss","zing_news"),"Ô tô – Xe máy");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/giai-tri.rss","zing_news"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/am-nhac.rss","zing_news"),"Âm nhạc");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/phim-anh.rss","zing_news"),"Phim ảnh");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/thoi-trang.rss","zing_news"),"Thời trang");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/song-tre.rss","zing_news"),"Sống trẻ");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/giao-duc.rss","zing_news"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/du-lich.rss","zing_news"),"Du lịch");
        pagerAdapter.AddFragment(new NewsFragment("https://news.zing.vn/rss/suc-khoe.rss","zing_news"),"Sức khoẻ");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageVnExpress()
    {
        title="VN EXPRESS";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/tin-moi-nhat.rss","vn_express"),"Tin mới");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/thoi-su.rss","vn_express"),"Thời sự");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/the-gioi.rss","vn_express"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/kinh-doanh.rss","vn_express"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/startup.rss","vn_express"),"Start up");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/giai-tri.rss","vn_express"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/the-thao.rss","vn_express"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/phap-luat.rss","vn_express"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/giao-duc.rss","vn_express"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/suc-khoe.rss","vn_express"),"Sức khỏe");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/gia-dinh.rss","vn_express"),"Gia đình");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/du-lich.rss","vn_express"),"Du lịch");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/khoa-hoc.rss","vn_express"),"Khóa học");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/so-hoa.rss","vn_express"),"Số hóa");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/oto-xe-may.rss","vn_express"),"Xe");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/cong-dong.rss","vn_express"),"Cộng đồng");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/tam-su.rss","vn_express"),"Tâm sự");
        pagerAdapter.AddFragment(new NewsFragment("https://vnexpress.net/rss/cuoi.rss","vn_express"),"Cười");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageDanTri()
    {
        title="DÂN TRÍ";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/trangchu.rss","dan_tri"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/suc-khoe.rss","dan_tri"),"Sức khỏe");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/xa-hoi.rss","dan_tri"),"Xã hội");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/giai-tri.rss","dan_tri"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/giao-duc-khuyen-hoc.rss","dan_tri"),"Khuyến học");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/the-thao.rss","dan_tri"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/the-gioi.rss","dan_tri"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/kinh-doanh.rss","dan_tri"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/o-to-xe-may.rss","dan_tri"),"Xe");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/suc-manh-so.rss","dan_tri"),"Sức mạnh số");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/tinh-yeu-gioi-tinh.rss","dan_tri"),"Giới ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/chuyen-la.rss","dan_tri"),"Chuyện lạ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/viec-lam.rss","dan_tri"),"Việc làm");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/nhip-song-tre.rss","dan_tri"),"Nhịp sống trẻ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/tam-long-nhan-ai.rss","dan_tri"),"Nhân ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/phap-luat.rss","dan_tri"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/ban-doc.rss","dan_tri"),"Bạn đọc");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/dien-dan.rss","dan_tri"),"Diễn đạt");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/tuyen-sinh.rss","dan_tri"),"Tuyển sinh");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/blog.rss","dan_tri"),"Blog");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/van-hoa.rss","dan_tri"),"Văn ");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/du-hoc.rss","dan_tri"),"Du học");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/du-lich.rss","dan_tri"),"Du lịch");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/doi-song.rss","dan_tri"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/khoa-hoc-cong-nghe.rss","dan_tri"),"Khoa học");
        pagerAdapter.AddFragment(new NewsFragment("https://dantri.com.vn/sea-games-28.rss","dan_tri"),"Sea game");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void Page24h()
    {
        title="24H";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/trangchu24h.rss","24h"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/tintuctrongngay.rss","24h"),"Trong ngày");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/bongda.rss","24h"),"Bóng đá");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/worldcup2018.rss","24h"),"World cup");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/anninhhinhsu.rss","24h"),"An ninh");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/thoitrang.rss","24h"),"Thời trang");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/thoitranghitech.rss","24h"),"Hi-tech");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss","24h"),"Tài chính ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/amthuc.rss","24h"),"Ẩm thực");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/lamdep.rss","24h"),"Làm đẹp");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/phim.rss","24h"),"Phim");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/giaoducduhoc.rss","24h"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/bantrecuocsong.rss","24h"),"Bạn trẻ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/canhacmtv.rss","24h"),"Ca nhạc");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/thethao.rss","24h"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/phithuongkyquac.rss","24h"),"Phi thường");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/congnghethongtin.rss","24h"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/oto.rss","24h"),"Ô tô");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/thitruongtieudung.rss","24h"),"Thị trường");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/dulich24h.rss","24h"),"Du lịch");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/suckhoedoisong.rss","24h"),"Sức khỏe");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/cuoi24h.rss","24h"),"Cười 24");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/tintucquocte.rss","24h"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/doisongshowbiz.rss","24h"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("https://www.24h.com.vn/upload/rss/giaitri.rss","24h"),"Giải trí");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageKenh14()
    {
        title="KÊNH 14";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/trang-chu.rss","kenh_14"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/tv-show.rss","kenh_14"),"TV Show");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/cine.rss","kenh_14"),"Cine");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/musik.rss","kenh_14"),"Musik");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/fashion.rss","kenh_14"),"Fashion");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/doi-song.rss","kenh_14"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/xa-hoi.rss","kenh_14"),"Xã hội");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/the-gioi.rss","kenh_14"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/tram-yeu.rss","kenh_14"),"Trạm yêu");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/la-cool.rss","kenh_14"),"Cool");
        pagerAdapter.AddFragment(new NewsFragment("https://kenh14.vn/hoc-duong.rss","kenh_14"),"Học đường");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageVietNameNet()
    {
        title="VIETNAM.NET";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/home.rss","vietnam_net"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/tin-moi-nong.rss","vietnam_net"),"Tin mới nóng");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/tin-noi-bat.rss","vietnam_net"),"Tin nổi bật");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/phap-luat.rss","vietnam_net"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/cong-nghe.rss","vietnam_net"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/kinh-doanh.rss","vietnam_net"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/giao-duc.rss","vietnam_net"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/giai-tri.rss","vietnam_net"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/suc-khoe.rss","vietnam_net"),"Sức khỏe");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/the-thao.rss","vietnam_net"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/doi-song.rss","vietnam_net"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/thoi-su.rss","vietnam_net"),"Thời sự");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/the-gioi.rss","vietnam_net"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/bat-dong-san.rss","vietnam_net"),"Bất động sản");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/ban-doc.rss","vietnam_net"),"Bạn đọc");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/tuanvietnam.rss","vietnam_net"),"Tuần việt nam");
        pagerAdapter.AddFragment(new NewsFragment("http://vietnamnet.vn/rss/goc-nhin-thang.rss","vietnam_net"),"Góc nhìn thẳng");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageDoiSong()
    {
        title="ĐỜI SỐNG & PHÁP LUẬT";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/trang-chu.rss","doisong_phapluat"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/tin-the-gioi.rss","doisong_phapluat"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/tin-trong-nuoc.rss","doisong_phapluat"),"Trong nước");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/tam-diem-du-luan.rss","doisong_phapluat"),"Tâm điểm");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/nhip-cau-tieu-dung.rss","doisong_phapluat"),"Tiêu dùng");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/xa-hoi.rss","doisong_phapluat"),"Xã hộ");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/toan-canh.rss","doisong_phapluat"),"Toàn cảnh");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/phap-luat.rss","doisong_phapluat"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/su-kien-luat-su.rss","doisong_phapluat"),"Sự kiện");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/kinh-doanh.rss","doisong_phapluat"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/to-quoc-xanh.rss","doisong_phapluat"),"Tổ quốc xanh");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/the-thao.rss","doisong_phapluat"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/cong-nghe.rss","doisong_phapluat"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/giao-duc.rss","doisong_phapluat"),"Giáo dục");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/oto-xemay.rss","doisong_phapluat"),"Xe");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/tu-thien.rss","doisong_phapluat"),"Nhân ái");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/dia-phuong.rss","doisong_phapluat"),"Địa phương");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/doi-song.rss","doisong_phapluat"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/san-pham.rss","doisong_phapluat"),"Sản phẩm");
        pagerAdapter.AddFragment(new NewsFragment("http://www.doisongphapluat.com/can-biet.rss","doisong_phapluat"),"Cần biết");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageNguoiDuaTin()
    {
        title="NGƯỜI ĐƯA TIN";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/trang-chu.rss","nguoi_dua_tin"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/phap-luat.rss","nguoi_dua_tin"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/nhip-song.rss","nguoi_dua_tin"),"Nhịp sống");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/kinh-doanh.rss","nguoi_dua_tin"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/the-gioi.rss","nguoi_dua_tin"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/nguoi-tre.rss","nguoi_dua_tin"),"Người trẻ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/dia-phuong.rss","nguoi_dua_tin"),"Địa phương");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/can-biet.rss","nguoi_dua_tin"),"Cần biết");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/chinh-tri-xa-hoi.rss","nguoi_dua_tin"),"Xã hội");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/giai-tri.rss","nguoi_dua_tin"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/doi-song.rss","nguoi_dua_tin"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/nghe-xem.rss","nguoi_dua_tin"),"Nghe/Xem");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/da-chieu.rss","nguoi_dua_tin"),"Đa chiều");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/cong-nghe.rss","nguoi_dua_tin"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("https://www.nguoiduatin.vn/tin-cu.rss","nguoi_dua_tin"),"Tin cũ");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void PageNgoiSao()
    {
        title="NGÔI SAO";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/hau-truong.rss","ngoi_sao"),"Hậu trường");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/ben-le.rss","ngoi_sao"),"Bên lề");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/thoi-cuoc.rss","ngoi_sao"),"Thời cuộc");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/phong-cach.rss","ngoi_sao"),"Phong cách");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/thu-gian.rss","ngoi_sao"),"Thư giản");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/cuoi-hoi.rss","ngoi_sao"),"Cưới hỏi");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/showbiz-viet.rss","ngoi_sao"),"Showbiz Việt");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/chau-a.rss","ngoi_sao"),"Châu Á");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/hollywood.rss","ngoi_sao"),"HollyWood");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/khoe-dep.rss","ngoi_sao"),"Khỏe đẹp");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/24h.rss","ngoi_sao"),"24h");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/chuyen-la.rss","ngoi_sao"),"Chuyện lạ");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/hinh-su.rss","ngoi_sao"),"Hình sự");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/thuong-truong.rss","ngoi_sao"),"Thương trường");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/thoi-trang.rss","ngoi_sao"),"Thời trang");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/lam-dep.rss","ngoi_sao"),"Làm đẹp");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/trac-nghiem.rss","ngoi_sao"),"Trắc nghiệm");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/an-choi.rss","ngoi_sao"),"Ăn chơi");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/dan-choi.rss","ngoi_sao"),"Dân chơi");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/cuoi.rss","ngoi_sao"),"Cười");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/game.rss","ngoi_sao"),"Game");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/choi-blog.rss","ngoi_sao"),"Blog");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/thi-anh.rss","ngoi_sao"),"Thi ảnh");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/miss.rss","ngoi_sao"),"Miss");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/co-dau.rss","ngoi_sao"),"Cô dâu");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/cam-nang.rss","ngoi_sao"),"Cẩm nang");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/anh-cuoi.rss","ngoi_sao"),"Ảnh cưới");
        pagerAdapter.AddFragment(new NewsFragment("https://ngoisao.net/rss/chia-se.rss","ngoi_sao"),"Chia sẻ");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void PageGenk()
    {
        title="GENK";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/trang-chu.rss","genk"),"Trang chủ");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/mmo.rss","genk"),"MMO");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/thi-truong.rss","genk"),"Thị trường");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/pc-console.rss","genk"),"PC Console");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/esport.rss","genk"),"Esport");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/mobile-social.rss","genk"),"Mobile");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/gaming-gear.rss","genk"),"Gaming Gear");
        pagerAdapter.AddFragment(new NewsFragment("http://gamek.vn/manga-film.rss","genk"),"Manga Film");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageSoHa()
    {
        title="SOHA";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/giai-tri.rss","so_ha"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/the-thao.rss","so_ha"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/thoi-su.rss","so_ha"),"Thời sự");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/phap-luat.rss","so_ha"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/kinh-doanh.rss","so_ha"),"Kinh doanh");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/quoc-te.rss","so_ha"),"Quốc tế");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/song-khoe.rss","so_ha"),"Sống khỏe");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/quan-su.rss","so_ha"),"Quân sự");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/cu-dan-mang.rss","so_ha"),"Cư dân mạng");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/infographic.rss","so_ha"),"Info Graphic");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/kham-pha.rss","so_ha"),"Khám phá");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/doi-song.rss","so_ha"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("http://soha.vn/apec-viet-nam-2017.rss","so_hoa"),"Apec Việt Nam");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void PageVov()
    {
        title="VOV.VN";
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/chinh-tri-209.rss","vov"),"Chính trị");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/doi-song-218.rss","vov"),"Đời sống");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/vov-binh-luan-352.rss","vov"),"Bình luận");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/xa-hoi-314.rss","vov"),"Xã hội");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/kinh-te-212.rss","vov"),"Kinh tế");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/the-gioi-213.rss","vov"),"Thế giới");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/phap-luat-237.rss","vov"),"Pháp luật");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/quan-su-quoc-phong-445.rss","vov"),"Quân sự");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/cong-nghe-449.rss","vov"),"Công nghệ");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/the-thao-214.rss","vov"),"Thể thao");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/van-hoa-giai-tri-215.rss","vov"),"Giải trí");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/nguoi-viet-287.rss","vov"),"Người việt");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/suc-khoe-311.rss","vov"),"Sức khỏe");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/media-357.rss","vov"),"Media");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/oto-xe-may-423.rss","vov"),"Xe");
        pagerAdapter.AddFragment(new NewsFragment("https://vov.vn/rss/e-magazine-470.rss","vov"),"E-Magazine");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (init) return;
        init = true;

        Drawable[] subButtonDrawables = new Drawable[3];
        int[] drawablesResource = new int[]{
                R.drawable.ic_select_page,
                R.drawable.ic_filter,
                R.drawable.ic_seen
        };
        for (int i = 0; i < 3; i++)
            subButtonDrawables[i] = ContextCompat.getDrawable(this, drawablesResource[i]);

        String[] subButtonTexts = new String[]{"Chọn trang báo", "Lọc thể loại yêu thích", "Tin tức đã xem"};

        int[][] subButtonColors = new int[3][2];
        for (int i = 0; i < 3; i++) {
            subButtonColors[i][1] = ContextCompat.getColor(this, R.color.colorDarkGray);
            subButtonColors[i][0] = Util.getInstance().getPressedColor(subButtonColors[i][1]);
        }

        new BoomMenuButton.Builder()
                .subButtons(subButtonDrawables,subButtonColors,subButtonTexts)
                .button(ButtonType.HAM)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.HAM_3_1)
                .subButtonTextColor(ContextCompat.getColor(this, R.color.colorDarkGray))
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                    @Override
                    public void onClick(int buttonIndex) {
                        String click = "On Click "+String.valueOf(buttonIndex);
                        Toast.makeText(
                                MainActivity.this,
                                click,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .init(boomMenuButton);
    }

}
