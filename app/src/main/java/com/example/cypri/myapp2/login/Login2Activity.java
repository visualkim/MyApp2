package com.example.cypri.myapp2.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cypri.myapp2.R;
import com.example.cypri.myapp2.member.MemberBean;
import com.example.cypri.myapp2.member.MemberDAO;
import com.example.cypri.myapp2.member.MemberService;
import com.example.cypri.myapp2.member.MemberServiceImpl;

public class Login2Activity extends Activity implements View.OnClickListener {

    private EditText editId;
    private EditText editPw;
    private TextView textResult;
    private Button btnSend;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editId = (EditText) findViewById(R.id.editId);
        editPw = (EditText) findViewById(R.id.editPw);
        textResult = (TextView) findViewById(R.id.textResult);
        (btnSend = (Button) findViewById(R.id.btnSend)).setOnClickListener( this );


    }

    @Override
    public void onClick(View v) {
        String id = editId.getText().toString();
        String pw = editPw.getText().toString();

        MemberBean member = new MemberBean();
//        MemberService service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO( this.getApplicationContext() );

        member.setId( id );
        member.setPw( pw );

        member = dao.login( member );

        Log.i( "DB 다녀온 결과 ID : ", member.getId() );
        if( member == null ) {
            textResult.setText( "로그인 결과: 실패");
        } else {
            textResult.setText( "로그인 결과: " + member.getName() );
        }
    }
}

