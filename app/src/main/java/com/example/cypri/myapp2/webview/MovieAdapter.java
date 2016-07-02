package com.example.cypri.myapp2.webview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cypri.myapp2.R;

/**
 * Created by cypri on 2016-06-25.
 */
public class MovieAdapter extends BaseAdapter {
    private Context context;
    private String[] movieValues;

    public MovieAdapter(Context context, String[] movieValues) {
        this.context = context;
        this.movieValues = movieValues;
    }

    @Override
    public int getCount() {
        return movieValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View gridView;
        if(convertView == null) {
            gridView = new View( context );
            gridView = inflater.inflate(R.layout.movie, null);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
            textView.setText(movieValues[position]);
            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

            String movie = movieValues[position];

            switch (movie) {
                case "mov01" : imageView.setImageResource(R.drawable.mov01); break;
                case "mov02" : imageView.setImageResource(R.drawable.mov02); break;
                case "mov03" : imageView.setImageResource(R.drawable.mov03); break;
                case "mov04" : imageView.setImageResource(R.drawable.mov04); break;
                case "mov05" : imageView.setImageResource(R.drawable.mov05); break;
                case "mov06" : imageView.setImageResource(R.drawable.mov06); break;
                case "mov07" : imageView.setImageResource(R.drawable.mov07); break;
                case "mov08" : imageView.setImageResource(R.drawable.mov08); break;
                case "mov09" : imageView.setImageResource(R.drawable.mov09); break;
                case "mov10" : imageView.setImageResource(R.drawable.mov10); break;
                case "mov11" : imageView.setImageResource(R.drawable.mov11); break;
                case "mov12" : imageView.setImageResource(R.drawable.mov12); break;
                case "mov13" : imageView.setImageResource(R.drawable.mov13); break;
                case "mov14" : imageView.setImageResource(R.drawable.mov14); break;
            }
        } else {
            gridView = (View)convertView;
        }
        return gridView;
    }
}
