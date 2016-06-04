package com.example.marcus.new_xiaoyichou.BottomFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.new_xiaoyichou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/6/2.
 */
public class Discover extends Fragment {
    private View view;
    private int[] images = {R.drawable.grid1,R.drawable.grid2,R.drawable.grid3,
            R.drawable.grid4,R.drawable.grid5,R.drawable.grid6,
            R.drawable.grid7,R.drawable.grid8,R.drawable.grid9};
    private String[] keyWords = {"好玩","小鲜肉","分红","诗歌","韩寒","民宿",
            "龙虾","旧","米","换个","红","王","张"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.discover,null);
        initGridView();
        initListViewItems();
        return view;
    }

    private void initGridView() {
        GridView grid = (GridView) view.findViewById(R.id.grid_view);
        List<Map<String,Integer>> datas = new ArrayList<>();
        int imagesLength = images.length;
        for (int i=0; i<imagesLength; i++) {
            Map<String,Integer> map = new HashMap<>();
            map.put("images",images[i]);
            datas.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),datas,R.layout.grid_list,
                new String[]{"images"},
                new int[]{R.id.grid_image});
        grid.setAdapter(adapter);
    }

    private void initListViewItems() {
        ListView list = (ListView) view.findViewById(R.id.listview_item);
        list.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,keyWords));
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
