package com.example.marcus.new_xiaoyichou.BottomFragments;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marcus.new_xiaoyichou.Adapters.MyListRecyclerAdapter;
import com.example.marcus.new_xiaoyichou.R;
import com.example.marcus.new_xiaoyichou.Solutions.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by marcus on 16/6/2.
 */
public class They extends Fragment {
    private View view;
    private static final int VERTICAL_ITEM_SPACE = 16;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.they,null);
        initAutoPlayImages();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        RecyclerView list = (RecyclerView) view.findViewById(R.id.recycler_list);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(manager);
        //list.setHasFixedSize(true);
        RecyclerView.ItemDecoration decoration = new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE);
        list.addItemDecoration(decoration);
        list.setAdapter(new MyListRecyclerAdapter(
                new int[]{R.drawable.item1,R.drawable.item2,R.drawable.item1,R.drawable.item2},
                new String[]{"By 许静","By 苏素","By 许静","By 苏素"},
                new String[]{"守护17棵古茶树","吉他女神爱开课","守护17棵古茶树","吉他女神爱开课"},
                new String[]{"正在进行  农业","已成功     定制","正在进行  农业","已成功     定制"}
        ));
    }

    private void initAutoPlayImages() {
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

