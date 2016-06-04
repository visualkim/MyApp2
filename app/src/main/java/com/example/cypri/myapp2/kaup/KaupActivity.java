package com.example.cypri.myapp2.kaup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.main.MainActivity;

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
        ((Button) findViewById(R.id.btnBack)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.btnBack :
                startActivity( new Intent( this, MainActivity.class ));
                break;
            case R.id.btnCalc :
                txtName = editName.getText().toString();
                txtWeight = Double.parseDouble( editWeight.getText().toString() );
                txtHeight = Double.parseDouble( editHeight.getText().toString() );

                KaupService service = new KaupServiceImpl();
                txtResult = service.getKaup( txtWeight, txtHeight );
                tvResult.setText( txtName + "님의 계산결과: " + txtResult );

                Toast toast = Toast.makeText( KaupActivity.this, " test ", Toast.LENGTH_LONG);
                toast.show();
                Log.d( txtResult, "카우프 지수");
                break;
        }

    }
}
