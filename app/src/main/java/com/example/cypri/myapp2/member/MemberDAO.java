package com.example.cypri.myapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cypri on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context ) {
        super(context, "hanbitDB", null, 1);
//        super(context, null, null, 1);
        // DB_NAME, null, DB_VERSION
    }
//    public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL( "create table member(id text, pw text, name text, email text);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String signup( MemberBean member ) {
        String id = member.getId();
        String pw = member.getPw();
        String name = member.getName();
        String email = member.getEmail();

        Log.i( "id", id );
        Log.i( "name", name );
        Log.i( "pw", pw );
        Log.i( "email", email );

        return "회원가입을 축하합니다.";
    }

    public MemberBean login( MemberBean member ) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( "select id, pw, name, email from member where id = '"+member.getId()+"' and pw = '"+member.getPw()+"'", null );

        String cId = "";
        String cPw = "";
        String cName = "";
        String cEmail = "";

        while( cursor.moveToNext() ) {
            cId = cursor.getString(0);
            cPw = cursor.getString(1);
            cName = cursor.getString(2);
            cEmail = cursor.getString(3);
        }

        MemberBean mb = new MemberBean();
        mb.setId( cId );
        mb.setPw( cPw );
        mb.setName( cName );
        mb.setEmail( cEmail );

//        mb.setId( member.getId() );
//        mb.setPw( member.getPw() );
//        mb.setName( "홍길동" );
//        mb.setEmail( "a@a.com" );
//        mb.setName( member.getName() );
//        mb.setEmail( member.getEmail() );
        Log.i( "id", mb.getId() );
        Log.i( "name", mb.getName() );
        Log.i( "pw", mb.getPw() );
        Log.i( "email", mb.getEmail() );

        cursor.close();
        db.close();
        return mb;
    }
    public MemberBean update( MemberBean member ) {
        MemberBean mb = new MemberBean();
        return  mb;
    }
    public String delete( MemberBean member ) {
        return "삭제완료";
    }
}
