package com.example.marcus.new_xiaoyichou;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.bingoogolapple.bgabanner.BGABanner;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        BGABanner banner = (BGABanner)findViewById(R.id.banner_splash_pager);
        // 用Java代码方式设置切换动画
        banner.setTransitionEffect(BGABanner.TransitionEffect.Rotate);
        // banner.setPageTransformer(new RotatePageTransformer());
        // 设置page切换时长
        banner.setPageChangeDuration(1000);
        List<View> views = new ArrayList<>();
        views.add(getPageView(R.drawable.guide1));
        views.add(getPageView(R.drawable.guide2));
        views.add(getPageView(R.drawable.guide3));
        View lastView = getLayoutInflater().inflate(R.layout.last_guide, null);
        views.add(lastView);
        lastView.findViewById(R.id.btn_last_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
        banner.setViews(views);
        // banner.setCurrentItem(1);
    }

    private View getPageView(@DrawableRes int resid) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resid);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
