package com.example.cypri.myapp2.signup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.member.MemberBean;
import com.example.cypri.myapp2.member.MemberDAO;
import com.example.cypri.myapp2.member.MemberService;
import com.example.cypri.myapp2.member.MemberServiceImpl;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText editName;
    private EditText editId;
    private EditText editPw;
    private EditText editEmail;
    TextView textResult;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editName = (EditText) findViewById(R.id.editName);
        editId = (EditText) findViewById(R.id.editId);
        editPw = (EditText) findViewById(R.id.editPw);
        editEmail = (EditText) findViewById(R.id.editEmail);

        ((Button) findViewById(R.id.btnSend)).setOnClickListener(this);
        textResult = (TextView)findViewById(R.id.textResult);
    }

    @Override
    public void onClick(View v) {
        String name = editName.getText().toString();
        String id = editId.getText().toString();
        String pw = editPw.getText().toString();
        String email = editEmail.getText().toString();

        MemberBean member = new MemberBean();
        MemberService service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO( this.getApplicationContext() );

        member.setId( id );
        member.setPw( pw );
        member.setName( name );
        member.setEmail( email );

        String msg = dao.signup( member );
        textResult.setText( "화원가입 결과: " + msg) ;

    }
}
