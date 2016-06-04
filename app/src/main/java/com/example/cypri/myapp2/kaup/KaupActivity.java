package com.example.cypri.myapp2.kaup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cypri.myapp2.R;

public class KaupActivity extends Activity implements View.OnClickListener {

    private EditText editName;
    private EditText editWeight;
    private EditText editHeight;
    private Button btnCheck;
    String txtName, txtResult;
    double txtWeight, txtHeight;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);

        editName = (EditText) findViewById(R.id.editName);
        editWeight = (EditText) findViewById(R.id.editWeight);
        editHeight = (EditText) findViewById(R.id.editHeight);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnCheck.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        txtName = editName.getText().toString();
        txtWeight = Double.parseDouble( editWeight.getText().toString() );
        txtHeight = Double.parseDouble( editHeight.getText().toString() );

        KaupService service = new KaupServiceImpl();
        double aa = service.getKaup( txtWeight, txtHeight );
        tvResult.setText( txtName + "님의 계산결과: " + aa );
    }
}
