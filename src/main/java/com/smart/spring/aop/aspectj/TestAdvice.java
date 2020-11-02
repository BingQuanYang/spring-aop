package com.smart.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 * （定义代理类）
 */
@Component
@Aspect
public class TestAdvice {
    /**
     * 切入点
     * 1、@Pointcut 定义切入点
     * value
     * 表示 切入点表达式(execution)
     * 或者@annotation()
     * <p>
     * 切入表达式格式
     * 方法的可见性  * 返回类型  * void/String 方法的包名+类名（参数（..表示匹配任意参数））
     * 通配符
     * *   匹配任意数量的字符
     * ..  可以匹配任意参数
     * <p>
     * 操作符
     * &&
     * ||
     * ！
     */
    @Pointcut(value = "execution(public * com.smart.spring.aop.service.UserService.register(..))")
    public void point() {

    }


    /**
     * 定义通知
     * 1、前置通知（Before）
     * 2、返回通知（After-returning）
     * 3、异常通知（After-throwing）
     * 4、环绕通知（Around）
     * 5、最终通知（After）
     */


    /**
     * 1、前置通知（Before）
     *
     * @Before() value 切入点
     */

    @Before("point()")
    public void before() {
        System.out.println("1、前置通知（Before）");
    }

    /**
     * 返回通知（After-returning）
     */
    @AfterReturning("point()")
    public void afterReturning() {
        System.out.println("返回通知");
    }

    /**
     * 返回通知带返回值（After-returning）
     */
    @AfterReturning(value = "point()", returning = "username")
    public Object afterReturningObject(String username) {
        System.out.println("返回通知带返回值");
        return username;
    }

    @AfterThrowing(value = "point()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        String message = ex.getMessage();
        System.out.println(message);
    }
    @Around(value = "point()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //method.invoke();
        System.out.println("环绕通知");
        Object proceed = pjp.proceed();
        System.out.println("环绕后");
        return proceed;
    }

    @After("point()")
    public void after(){
        System.out.println("最终通知/后置通知");
    }
}
