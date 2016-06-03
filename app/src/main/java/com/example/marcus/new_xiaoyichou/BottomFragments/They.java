package com.example.marcus.new_xiaoyichou.BottomFragments;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marcus.new_xiaoyichou.R;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by marcus on 16/6/2.
 */
public class They extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.they,null);
        initView();
        return view;
    }

    private void initView() {
        BGABanner autoPlayImages = (BGABanner) view.findViewById(R.id.auto_play_image);
        // 用Java代码方式设置切换动画
        autoPlayImages.setTransitionEffect(BGABanner.TransitionEffect.Depth);
        // autoPlayImages.setPageTransformer(new RotatePageTransformer());
        // 设置page切换时长
        autoPlayImages.setPageChangeDuration(1000);
        List<View> views = new ArrayList<>();
        views.add(getPageView(R.drawable.image1));
        views.add(getPageView(R.drawable.image2));
        views.add(getPageView(R.drawable.image3));
        autoPlayImages.setViews(views);
    }

    private View getPageView(@DrawableRes int resid) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(resid);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }

}
