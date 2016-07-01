package com.example.marcus.new_xiaoyichou.StartProjects;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.marcus.new_xiaoyichou.R;

/**
 * Created by marcus on 16/6/30.
 */
public class Page2 extends Activity {
    private ImageButton back;
    private Button forward;
    private EditText moneyTitle;
    private EditText moneyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        moneyTitle = (EditText) findViewById(R.id.number);
        moneyContent = (EditText) findViewById(R.id.use_content);
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2.this,Page1.class);
                startActivity(intent);
            }
        });
        forward = (Button) findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2.this,Page3.class);
                if (!moneyTitle.getText().toString().equals("") && !moneyContent.getText().toString().equals("")) {
                    Bundle data = new Bundle();
                    data.putInt("number",Integer.valueOf(moneyTitle.getText().toString()));
                    data.putString("use_content",moneyContent.getText().toString());
                    intent.putExtras(data);
                    startActivity(intent);
                }
                else {
                    new AlertDialog.Builder(Page2.this)
                            .setMessage("金额及用途不能为空！")
                            .setPositiveButton("确定",null)
                            .show();
                }
            }
        });
    }
}
