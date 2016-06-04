package com.example.cypri.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editName;
    private EditText editWeight;
    private EditText editHeight;
    private Button btnCheck;
    TextView tvResult;

    String txtName, txtResult;
    double txtWeight, txtHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editWeight = (EditText) findViewById(R.id.editWeight);
        editHeight = (EditText) findViewById(R.id.editHeight);
        btnCheck = (Button) findViewById(R.id.btnCheck);

        txtName = editName.getText().toString();
        txtWeight = Double.parseDouble( editWeight.getText().toString() );
        txtHeight = Double.parseDouble( editHeight.getText().toString() );

        int idx = (int)(txtHeight / (txtHeight * txtHeight )) * 10000;

        if( idx >= 30 ) {
            txtResult = "비만";
        } else if( idx >= 24 ) {
            txtResult = "과체중";
        } else if( idx >= 20 ) {
            txtResult = "정상";
        } else if( idx >= 15 ) {
            txtResult = "저체중";
        } else if( idx >= 13 ) {
            txtResult = "마름";
        } else if( idx >= 10 ) {
            txtResult = "영양실조";
        } else {
            txtResult = "소모증";
        }
        tvResult.setText( txtName + "님의 계산결과: " + txtResult );

        btnCheck.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
}
