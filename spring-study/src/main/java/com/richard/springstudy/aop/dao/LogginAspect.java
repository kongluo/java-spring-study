package com.richard.springstudy.aop.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 10:39
 **/

@Component //交给IOC容器来管理
@Aspect //声明一个类是切面类
public class LogginAspect
{
    @Before(value = "execution(public int com.richard.springstudy.aop.dao.ArithmeticCalculator.*(int,int))")
    public void beforeLogging(){
        System.out.println("我在方法执行之前执行...");
    }
}
