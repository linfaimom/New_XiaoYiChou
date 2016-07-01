package com.example.marcus.new_xiaoyichou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.new_xiaoyichou.StartProjects.Page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/6/30.
 */
public class Item extends Activity {
    private ListView listView;
    private ImageButton back;
    private String[][] texts = {
            {"微爱通道","传递爱心正能量"},
            {"尝鲜预售","新品上市速尝鲜"},
            {"实现梦想","有梦想大家一起助力"},
            {"达人直播","做你自己的导演"}
    };
    private int[] images = new int[]{R.drawable.love,R.drawable.shop,R.drawable.moon,R.drawable.show};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);
        setListView();
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Item.this,User.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setListView() {
        listView = (ListView) findViewById(R.id.items);
        List<Map<String,String>> items = new ArrayList<>();
        int length = texts.length;
        for (int i=0; i<length; i++) {
            Map<String,String> item = new HashMap<>();
            item.put("image",String.valueOf(images[i]));
            item.put("title",texts[i][0]);
            item.put("content",texts[i][1]);
            items.add(item);
        }
        listView.setAdapter(new SimpleAdapter(Item.this,
                items,
                R.layout.items_list,
                new String[]{"image","title","content"},
                new int[]{R.id.image,R.id.title,R.id.content}));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Item.this,Page1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
