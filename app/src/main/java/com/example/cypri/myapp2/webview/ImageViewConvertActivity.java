package com.example.cypri.myapp2.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cypri.myapp2.R;

public class ImageViewConvertActivity extends Activity implements View.OnClickListener{
    ImageView imageView;
    Button btnNextImage, btnPrevImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_convert);

        imageView = (ImageView) findViewById(R.id.imageView);
        btnNextImage = (Button) findViewById(R.id.btnNextImage);
        btnNextImage.setOnClickListener(this);
        btnPrevImage = (Button) findViewById(R.id.btnPrevImage);
        btnPrevImage.setOnClickListener(this);
        btnPrevImage.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrevImage:
                imageView.setImageResource(R.drawable.jellyfish);
                btnPrevImage.setVisibility(View.INVISIBLE);
                btnNextImage.setVisibility(View.VISIBLE);
                break;
            case R.id.btnNextImage:
                imageView.setImageResource(R.drawable.tulips);
                btnPrevImage.setVisibility(View.VISIBLE);
                btnNextImage.setVisibility(View.INVISIBLE);
                break;
        }

    }
}