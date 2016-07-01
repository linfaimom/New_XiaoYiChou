package com.example.marcus.new_xiaoyichou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by marcus on 16/6/5.
 */
public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me);
        Button login = (Button) findViewById(R.id.login);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/custom.ttf");
        login.setTypeface(typeface);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,User.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
