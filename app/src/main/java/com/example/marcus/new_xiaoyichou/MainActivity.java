package com.example.marcus.new_xiaoyichou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.marcus.new_xiaoyichou.BottomFragments.Discover;
import com.example.marcus.new_xiaoyichou.BottomFragments.Me;
import com.example.marcus.new_xiaoyichou.BottomFragments.They;

/**
 * Created by marcus on 16/6/1.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Button theyTab;
    private Button discoverTab;
    private Button meTab;
    private FrameLayout home;
    private static final int NUM_FRAGMENT = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();
    }

    private void initView() {
        home = (FrameLayout) findViewById(R.id.fragment_content);

        theyTab = (Button) findViewById(R.id.they);
        discoverTab = (Button) findViewById(R.id.discover);
        meTab = (Button) findViewById(R.id.me);

        theyTab.setOnClickListener(this);
        discoverTab.setOnClickListener(this);
        meTab.setOnClickListener(this);
    }

    //Adapter
    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        Fragment fragment = null;

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 :
                    fragment = new They();
                    break;
                case 1 :
                    fragment = new Discover();
                    break;
                case 2 :
                    fragment = new Me();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_FRAGMENT;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        theyTab.setPressed(true);
        theyTab.setSelected(true);
        //设置第一个显示的fragment
        Fragment fragment = (Fragment) adapter.instantiateItem(home,0);
        adapter.setPrimaryItem(home,0,fragment);
        adapter.finishUpdate(home);
    }

    @Override
    public void onClick(View v) {
        //记录点击位置index,根据index的值来启动相应fragment
        int index = 0;
        switch (v.getId()){
            case R.id.they :
                index = 0;
                theyTab.setSelected(true);
                discoverTab.setSelected(false);
                meTab.setSelected(false);
                break;
            case R.id.discover :
                index = 1;
                discoverTab.setSelected(true);
                meTab.setSelected(false);
                theyTab.setSelected(false);
                break;
            case R.id.me :
                index = 2;
                meTab.setSelected(true);
                theyTab.setSelected(false);
                discoverTab.setSelected(false);
                break;
        }

        //设置第一个显示的fragment
        Fragment fragment = (Fragment) adapter.instantiateItem(home,index);
        adapter.setPrimaryItem(home,0,fragment);
        adapter.finishUpdate(home);
    }
}
