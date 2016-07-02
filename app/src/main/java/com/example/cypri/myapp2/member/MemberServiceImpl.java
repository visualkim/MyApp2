package com.example.cypri.myapp2.member;

import android.app.Activity;

/**
 * Created by cypri on 2016-06-11.
 */
public class MemberServiceImpl extends Activity implements MemberService {
    MemberDAO dao = null;
//    MemberDAO dao = new MemberDAO( this.getApplicationContext() );

    @Override
    public String singup(MemberBean member) {
//        String msg = dao.signup( member );
//        return msg;
        return dao.signup( member );
    }

    @Override
    public MemberBean login( MemberBean member ) {
        return dao.login( member );
    }
    @Override
    public MemberBean update( MemberBean member ) {
        return dao.update( member );
    }
    @Override
    public String delete( MemberBean member ) {
        return dao.delete( member );

    }
}
