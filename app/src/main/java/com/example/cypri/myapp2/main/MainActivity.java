package com.example.cypri.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cypri.myapp2.Calc.CalcActivity;
import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.kaup.KaupActivity;
import com.example.cypri.myapp2.login.LoginActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnKaup;
    private Button btnCalc;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKaup = (Button) findViewById(R.id.btnKaup);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnKaup.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.btnKaup :
                Toast.makeText( this, "Kaup", Toast.LENGTH_SHORT ).show();
                //Intent intent = new Intent( this, KaupActivity.class );
                //startActivity( intent );
                startActivity( new Intent( this, KaupActivity.class ) );
                break;
            case R.id.btnCalc :
                Toast.makeText( this, "Calc", Toast.LENGTH_SHORT ).show();
                startActivity( new Intent( this, CalcActivity.class ) );
                break;
            case R.id.btnLogin :
                Toast.makeText( this, "Login", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, LoginActivity.class ) );
                break;
        }
    }
}











