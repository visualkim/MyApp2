package com.example.cypri.myapp2.member;

/**
 * Created by cypri on 2016-06-11.
 */
public interface MemberService {
    public String singup( MemberBean member );
    public MemberBean login( MemberBean member );
    public MemberBean update( MemberBean member );
    public String delete( MemberBean member );
}
