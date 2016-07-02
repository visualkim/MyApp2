package com.example.cypri.myapp2.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cypri.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener{
    GroupDBHelper  groupHelper = new GroupDBHelper(GroupActivity.this);
    public SQLiteDatabase db;
    EditText etName,etNum,etResult,etID;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        etName = (EditText) findViewById(R.id.etName);
        etNum = (EditText) findViewById(R.id.etNum);
        etResult = (EditText) findViewById(R.id.etResult);
        etID = (EditText) findViewById(R.id.etID);
        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btFind)).setOnClickListener(this);
        ((Button)findViewById(R.id.btUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCount)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id=null,name=null,num=null;
        switch(v.getId()){
            case R.id.btInit : // 초기화버튼
                db = groupHelper.getWritableDatabase();
                groupHelper.onUpgrade(db,1,2);
                db.close();
                break;
            case R.id.btInsert : // 등록
                db = groupHelper.getWritableDatabase();
                db.execSQL("INSERT INTO girl_group(name,num) VALUES('"+etName.getText()+"',"+etNum.getText()+")");
                db.close();
                Toast.makeText(getApplicationContext(),"입력성공", Toast.LENGTH_LONG).show();
                break;
            case R.id.btFind : // 조회
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girl_group WHERE _id = "+etID.getText()+";",null);
                while(cursor.moveToNext()){
                    id = String.valueOf(cursor.getInt(0));
                    name = cursor.getString(1);
                    num = String.valueOf(cursor.getInt(2));
                }
                etResult.setText("NO."+id+", 그룹명 : "+name+", 멤버수 : "+num);
                break;
            case R.id.btUpdate : // 수정
                db = groupHelper.getWritableDatabase();
                db.execSQL("UPDATE girl_group SET num = "+etNum.getText()+" WHERE name = '"+etName.getText()+"';");
                etResult.setText("수정 완료");
                db.close();
                break;
            case R.id.btDelete : // 삭제
                db = groupHelper.getWritableDatabase();
                db.execSQL("DELETE FROM girl_group WHERE _id = "+etID.getText());
                etResult.setText("삭제 완료");
                db.close();
                break;
            case R.id.btList : // 목록
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girl_group;",null);
                id = "NO"+"\r\n"+"-------------"+"\r\n";
                name = "그룹이름"+"\r\n"+"-------------"+"\r\n";
                num = "멤버수"+"\r\n"+"--------------"+"\r\n";
                while (cursor.moveToNext()){
                    name += cursor.getString(1) + "\r\n";
                    num += cursor.getInt(2) + "\r\n";
                }

                etResult.setText(name+num);
                cursor.close();
                db.close();
                break;
            case R.id.btCount : // 갯수
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girl_group;",null);
                int count = cursor.getCount();
                cursor.close();
                etResult.setText("DB에 저장된 값의 갯수 : "+ count);
                db.close();
                break;
        }

    }
}



