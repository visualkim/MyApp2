package com.example.cypri.myapp2.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cypri.myapp2.R;

public class IntroActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ((Button) findViewById(R.id.btWebView)).setOnClickListener(this);
        ((Button) findViewById(R.id.btImageView)).setOnClickListener(this);
        ((Button) findViewById(R.id.btImageViewConvert)).setOnClickListener(this);
        ((Button) findViewById(R.id.btListView)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnGridView)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btWebView:
                startActivity(new Intent(this, WebviewActivity.class));
                break;
            case R.id.btImageView:
                startActivity(new Intent(this, ImageViewActivity.class));
                break;
            case R.id.btImageViewConvert:
                startActivity(new Intent(this, ImageViewConvertActivity.class));
                break;
            case R.id.btListView:
                startActivity(new Intent(this, ImageListActivity.class));
                break;
            case R.id.btnGridView:
                startActivity(new Intent(this, ImageGridActivity.class));
                break;
        }
    }
}
