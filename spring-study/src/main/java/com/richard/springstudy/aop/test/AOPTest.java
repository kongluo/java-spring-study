package com.richard.springstudy.aop.test;

import com.richard.springstudy.aop.dao.ArithmeticCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 10:54
 **/
public class AOPTest
{
    //创建ioc容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-aop.xml");

    @Test
    void test()
    {
        ArithmeticCalculator acc = (ArithmeticCalculator) ioc.getBean("arithmeticCalcutor");
        int add = acc.add(10, 20);
        System.out.println(add);
        int sub = acc.sub(10, 20);
        System.out.println(sub);
        int mul = acc.mul(10, 20);
        System.out.println(mul);
        int div = acc.div(10, 20);
        System.out.println(div);
    }
}
