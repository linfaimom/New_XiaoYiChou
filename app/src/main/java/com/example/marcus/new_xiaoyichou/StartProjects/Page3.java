package com.example.marcus.new_xiaoyichou.StartProjects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.marcus.new_xiaoyichou.R;

/**
 * Created by marcus on 16/6/30.
 */
public class Page3 extends Activity {
    private ImageButton back;
    private TextView title;
    private TextView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        title = (TextView) findViewById(R.id.money_title);
        content = (TextView) findViewById(R.id.money_content);
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        title.setText("支持"+data.getInt("number",0)+"元");
        content.setText(data.getString("use_content",""));
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page3.this,Page2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
