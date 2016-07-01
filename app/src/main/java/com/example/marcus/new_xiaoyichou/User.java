package com.example.marcus.new_xiaoyichou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/7/1.
 */
public class User extends Activity {
    private ListView listView1,listView2;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        setListView1();
        setListView2();
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        View click = findViewById(R.id.start_project);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, Item.class);
                startActivity(intent);
            }
        });
    }

    private void setListView1() {
        listView1 = (ListView) findViewById(R.id.listitems_2);
        String[] names = {"我的钱包","微爱大病互助行动"};
        int[] images = {R.drawable.money,R.drawable.love_96};
        List<Map<String,String>> list = new ArrayList<>();
        for (int i=0; i<names.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(images[i]));
            map.put("content",names[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(User.this,list,R.layout.user_listview,
                new String[]{"image","content"},
                new int[]{R.id.image,R.id.content});
        listView1.setAdapter(adapter);
    }

    private void setListView2() {
        listView2 = (ListView) findViewById(R.id.listitems_3);
        String[] names = {"帮助中心","意见反馈","关于校易筹"};
        int[] images = {R.drawable.help,R.drawable.postback,R.drawable.about};
        List<Map<String,String>> list = new ArrayList<>();
        for (int i=0; i<names.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(images[i]));
            map.put("content",names[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(User.this,list,R.layout.user_listview,
                new String[]{"image","content"},
                new int[]{R.id.image,R.id.content});
        listView2.setAdapter(adapter);
    }
}
