package com.example.cypri.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cypri.myapp2.Calc.CalcActivity;
import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.group.GroupActivity;
import com.example.cypri.myapp2.kaup.KaupActivity;
import com.example.cypri.myapp2.login.Login2Activity;
import com.example.cypri.myapp2.movie.MovieActivity;
import com.example.cypri.myapp2.signup.SignupActivity;
import com.example.cypri.myapp2.spinner.SpinnerActivity;
import com.example.cypri.myapp2.webview.IntroActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnKaup;
    private Button btnCalc;
    private Button btnLogin;
    private Button btnSign;
    private Button btnGroup;
    private Button btnMovie;
    private Button btnSpinner;
    private Button btnIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKaup = (Button) findViewById(R.id.btnKaup);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSign = (Button) findViewById(R.id.btnSignup);
        btnGroup = (Button) findViewById(R.id.btnGroup);
        btnMovie = (Button) findViewById(R.id.btnMovie);
        btnSpinner = (Button) findViewById(R.id.btnSpinner);
        btnIntro = (Button) findViewById(R.id.btnIntro);

        btnKaup.setOnClickListener( this );
        btnCalc.setOnClickListener( this );
        btnSign.setOnClickListener( this );
        btnLogin.setOnClickListener( this );
        btnGroup.setOnClickListener( this );
        btnMovie.setOnClickListener( this );
        btnSpinner.setOnClickListener( this );
        btnIntro.setOnClickListener( this );
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
                startActivity( new Intent( this, Login2Activity.class ) );
                break;
            case R.id.btnSignup :
                Toast.makeText( this, "Signup", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, SignupActivity.class ) );
                break;
            case R.id.btnGroup :
                Toast.makeText( this, "Group", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, GroupActivity.class ) );
                break;
            case R.id.btnMovie :
                Toast.makeText( this, "Movie", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, MovieActivity.class ) );
                break;
            case R.id.btnSpinner :
                Toast.makeText( this, "Spinner", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, SpinnerActivity.class ) );
                break;
            case R.id.btnIntro :
                Toast.makeText( this, "Intro", Toast.LENGTH_LONG ).show();
                startActivity( new Intent( this, IntroActivity.class ) );
                break;
        }
    }
}











