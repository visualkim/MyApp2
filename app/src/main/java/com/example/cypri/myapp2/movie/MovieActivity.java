package com.example.cypri.myapp2.movie;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.cypri.myapp2.R;

public class MovieActivity extends Activity {

    GridView gv;
    MovieGridAdapter adapter;

    //final int pos;

    Integer[] posterId = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드뷰 영화 포스터");

        gv = (GridView) findViewById(R.id.gvMovie);
        adapter = new MovieGridAdapter(this);
        gv.setAdapter(adapter);

    }

    public int getCount() {
        return posterId.length;
    }
    public View getView(int position, View view, ViewGroup vg) {
        ImageView iv = new ImageView(MovieActivity.this);
        iv.setLayoutParams( new GridView.LayoutParams(100, 150) );
        iv.setScaleType(ImageView.ScaleType.CENTER );
        iv.setPadding( 5, 5, 5, 5 );

        final int pos = position;

        iv.setImageResource( posterId[pos] );
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = View.inflate( MovieActivity.this, R.layout.dialog, null );
                AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity.this);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource( posterId[0] );
                dlg.setTitle("큰포스터");
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView( dialogView );
                dlg.setNegativeButton( "닫기", null );
                dlg.show();
            }
        });
        return iv;
    }
}
