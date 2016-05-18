package com.ldd.adbanner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ldd.adbanner.com.ldd.banner.view.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlyBanner mBannerLocal;//加载本地图片

    private FlyBanner mBannerNet;//加载网络图片

    private String[] mImagesUrl = {
            "http://img.blog.csdn.net/20151123175838192",
            "http://www.baidu.com/img/bdlogo.png",
            "http://img.blog.csdn.net/20131130184047953?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHVfZnU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast",
            "http://www.baidu.com/img/bdlogo.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initLocalBanner();
        initNetBanner();
    }

    /**
     * 加载本地图片
     */
    private void initLocalBanner() {
        mBannerLocal = (FlyBanner) findViewById(R.id.banner_1);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.img_1);
        images.add(R.drawable.img_2);
        images.add(R.drawable.img_3);
        images.add(R.drawable.img_4);
        mBannerLocal.setImages(images);

        mBannerLocal.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第" + position + "张图片");
            }
        });
    }

    /**
     * 加载网页图片
     */
    private void initNetBanner() {
        mBannerNet = (FlyBanner) findViewById(R.id.banner_2);

        List<String> imgesUrl = new ArrayList<>();
        for (int i = 0; i < mImagesUrl.length; i++) {
            imgesUrl.add(mImagesUrl[i]);
        }
        mBannerNet.setImagesUrl(imgesUrl);

        mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第" + position + "张图片");
            }
        });
    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}
