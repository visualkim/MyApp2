package com.example.cypri.myapp2.spinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.cypri.myapp2.R;

public class SpinnerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        setTitle("스피너");

        String[] movie = {"쿵푸팬더", "인사이드아웃", "주토피아", "드래곤볼", "천공의 성 라퓨타", "붉은돼지", "몬스터 주식회사"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, movie);
        spinner.setAdapter(adapter);
    }
}
