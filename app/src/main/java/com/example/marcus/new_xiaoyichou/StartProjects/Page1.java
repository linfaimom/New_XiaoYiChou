package com.example.marcus.new_xiaoyichou.StartProjects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.example.marcus.new_xiaoyichou.Item;
import com.example.marcus.new_xiaoyichou.R;

/**
 * Created by marcus on 16/6/30.
 */
public class Page1 extends Activity {
    private ImageButton back;
    private SeekBar seekBar;
    private EditText days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page1.this,Item.class);
                startActivity(intent);
                finish();
            }
        });
        days = (EditText) findViewById(R.id.days);
        seekBar = (SeekBar) findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                days.setText(String.valueOf(progress+3));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
