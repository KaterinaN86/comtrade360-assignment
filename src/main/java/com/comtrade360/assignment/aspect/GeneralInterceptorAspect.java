package com.comtrade360.assignment.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    @Pointcut("execution(* com.comtrade360.assignment.controllers.TranslateController.*(..))")
    public void loggingPointcut(){

    }

    @Before("loggingPointcut()")
    public void before(JoinPoint joinPoint){
            log.info("Before controller method invoked:"+ joinPoint.getSignature() );
    }

    @After("loggingPointcut()")
    public void after(JoinPoint joinPoint){
        log.info("After controller method invoked:"+ joinPoint.getSignature() );
    }

}
