package com.example.cypri.myapp2.Calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.main.MainActivity;

public class CalcActivity extends Activity implements View.OnClickListener {


    private Button btnPlus,  btnMinus;
    private Button btnMulti, btnDivi, btnRest;
    private TextView textResult;
    private EditText input01, input02;
    int num1, num2;
    Integer result;

    CalcService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        service = new CalcServiceImpl();

        /*btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDivi = (Button) findViewById(R.id.btnDivi);
        btnRest = (Button) findViewById(R.id.btnDivi);*/

        textResult = (TextView) findViewById(R.id.textResult);

        ((Button) findViewById(R.id.btnPlus)).setOnClickListener( this );
        ((Button) findViewById(R.id.btnMinus)).setOnClickListener( this );
        ((Button) findViewById(R.id.btnMulti)).setOnClickListener( this );
        ((Button) findViewById(R.id.btnDivi)).setOnClickListener( this );
        ((Button) findViewById(R.id.btnDivi)).setOnClickListener( this );
        ((Button) findViewById(R.id.btnBack)).setOnClickListener( this );

    }
    @Override
    public void onClick(View v) {
        if( v.getId() == R.id.btnBack ) {
            startActivity( new Intent( this, MainActivity.class ));
        } else {
            input01 = (EditText) findViewById(R.id.input01);
            input02 = (EditText) findViewById(R.id.input02);
            num1 = Integer.parseInt(input01.getText().toString());
            num2 = Integer.parseInt(input02.getText().toString());
            int result = 0;

            switch (v.getId()) {
                case R.id.btnPlus:
                    result = service.plus(num1, num2);
                    break;
                case R.id.btnMinus:
                    result = service.minus(num1, num2);
                    break;
                case R.id.btnMulti:
                    result = service.multi(num1, num2);
                    break;
                case R.id.btnDivi:
                    result = service.divi(num1, num2);
                    break;
                case R.id.btnRest:
                    result = service.rest(num1, num2);
                    break;
            }
            textResult.setText("계산결과: " + result);
        }
    }
}
