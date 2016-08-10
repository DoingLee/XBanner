package com.doing.xbannerdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.doing.xbanner.BannerLayout;

public class MainActivity extends AppCompatActivity {

    BannerLayout bannerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bannerLayout = $(R.id.banner);
//        bannerLayout.setViewWithRes(new int[]{com.doing.xbanner.R.drawable.a,
//                com.doing.xbanner.R.drawable.b,
//                com.doing.xbanner.R.drawable.c,
//                com.doing.xbanner.R.drawable.d,
//                com.doing.xbanner.R.drawable.e});
//        bannerLayout.setViewWithDefault();
        bannerLayout.setViewWithUrls(new String[]{"http://img2.3lian.com/2014/c7/12/d/77.jpg",
                "http://pic3.bbzhi.com/fengjingbizhi/gaoqingkuanpingfengguangsheyingps/show_fengjingta_281299_11.jpg",
                "http://paper.taizhou.com.cn/tzwb/res/1/2/2015-01/20/12/res03_attpic_brief.jpg",
                "http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg",
                "http://img3.iqilu.com/data/attachment/forum/201308/21/192654ai88zf6zaa60zddo.jpg"});
        bannerLayout.setImageDescriptions(new String[]{"第 1 张图片",
                "第 2 张图片",
                "第 3 张图片",
                "第 4 张图片",
                "第 5 张图片"});
        bannerLayout.setImageOnClickListeners(new View.OnClickListener[]{
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showCommonAlertDialog("第 1 张图片被点击！");
                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showCommonAlertDialog("第 2 张图片被点击！");
                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showCommonAlertDialog("第 3 张图片被点击！");
                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showCommonAlertDialog("第 4 张图片被点击！");
                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showCommonAlertDialog("第 5 张图片被点击！");
                    }
                },
        });
        bannerLayout.startScroll();
    }

    protected  <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    protected void showCommonAlertDialog(String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name))
                .setMessage(msg)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    @Override
    protected void onDestroy() {
        bannerLayout.cancelScrollThread();
        super.onDestroy();
    }
}
