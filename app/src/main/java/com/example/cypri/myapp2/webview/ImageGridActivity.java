package com.example.cypri.myapp2.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.cypri.myapp2.R;

public class ImageGridActivity extends Activity {
    GridView gridView;
    static final String[] movies = new String[] {
            "mov01", "mov02", "mov03", "mov04", "mov05", "mov06", "mov07", "mov08", "mov09", "mov10", "mov11", "mov12", "mov13", "mov14"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new MovieAdapter(this, movies));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        "테스트값",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });
    }
}
