package com.example.cypri.myapp2.Calc;

/**
 * Created by cypri on 2016-06-04.
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divi(int num1, int num2) {
        return num1 / num2;
    }

    @Override
    public int rest(int num1, int num2) {
        return num1 % num2;
    }
}
