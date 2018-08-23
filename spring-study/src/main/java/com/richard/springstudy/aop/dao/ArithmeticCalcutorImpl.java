package com.richard.springstudy.aop.dao;

import org.springframework.stereotype.Component;

/**
 * @program: SSM03_Spring
 * @description:
 * @author: Mr.Wang
 * @create: 2018-07-17 11:06
 **/
@Component("arithmeticCalcutor")
public class ArithmeticCalcutorImpl implements ArithmeticCalculator
{
    @Override
    public int add(int a, int b) {
        //开始日志
        int result = a+b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        //开始日志
        int result = a-b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        //开始日志
        int result = a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        //开始日志
        int result = a/b;
        return result;
    }
}
