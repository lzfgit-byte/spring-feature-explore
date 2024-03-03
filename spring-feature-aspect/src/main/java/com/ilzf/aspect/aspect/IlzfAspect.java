package com.ilzf.aspect.aspect;


import com.ilzf.aspect.annotation.ILzfLog;
import com.ilzf.util.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class IlzfAspect {

    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
     * 修饰符匹配（modifier-pattern?）
     * 返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     * 类路径匹配（declaring-type-pattern?）
     * 方法名匹配（name-pattern）可以指定方法名 或者 代表所有, set 代表以set开头的所有方法
     * 参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(…)表示零个或多个任意参数
     * 异常类型匹配（throws-pattern?）
     * 其中后面跟着“?”的是可选项
     * (* com.ilzf.aspect.controller.*.*(..))
     * 返回值任意  文件任意,方法任意，参数任意
     * <p>
     * "execution (String com.ilzf.aspect.controller.*.*(..))"
     */

    @Pointcut("execution (* com.ilzf.aspect.controller.*.*(..))")
    public void test() {
    }

    @Before("test()")
    public void before() {
        LogUtil.log("test() --> before");
    }

    @Before("execution (* com.ilzf.aspect.controller.*.*(..)) && args(a1)")
    public void before2(JoinPoint joinPoint, String a1) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        Method method = signature.getMethod();
        ILzfLog iLzfLog = method.getAnnotation(ILzfLog.class);
        if (iLzfLog != null) {
            LogUtil.log("before记录的日志-->", iLzfLog.value());
        }

        LogUtil.log("参数before --> before  ", a1, " ", "方法名", name);
    }


    @After("test()")
    public void after() {
        LogUtil.log("test() --> after");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        LogUtil.log("around", "before");
        Object o = null;
        try {
            o = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            LogUtil.log("aop catch");
        }
        LogUtil.log("around", "after");
        return o == null ? "返回时null" : o;
    }

    @AfterReturning(pointcut = "test()", returning = "retVal")
    public void afterReturning(JoinPoint jp, Object retVal) {
        LogUtil.log("afterReturning", retVal.toString());
    }


    @AfterThrowing(pointcut = "test()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        LogUtil.log("afterThrowing", error.getMessage());
    }
}
