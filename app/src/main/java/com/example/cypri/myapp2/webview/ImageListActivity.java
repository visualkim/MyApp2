package com.example.cypri.myapp2.webview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ImageListActivity extends ListActivity {
    static final String[] arr = new String[] {
            "cupcake", "donut", "eclair", "froyo", "gingerbread", "honeycomb", "icecream", "jellybean", "lollipop"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrAdapter(this, arr));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText( this, selectedValue, Toast.LENGTH_LONG ).show();
    }
}
