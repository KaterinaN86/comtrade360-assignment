package com.comtrade360.assignment.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Component class for logging information with AOP
 */
@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

    //pointcut annotation with a pointcut expression
    @Pointcut("execution(* com.comtrade360.assignment.controllers.TranslateController.*(..))")
    //pointcut signature for logging controller methods
    public void loggingControllerPointcut() {

    }

    /**
     * Adding advice that runs before joinPoint with loggingControllerPointcut() signature
     *
     * @param joinPoint
     */
    @Before("loggingControllerPointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("Before translateController method invoked:" + joinPoint.getSignature());
    }

    /**
     * Adding advice that runs after joinPoint with loggingControllerPointcut() signature
     *
     * @param joinPoint
     */
    @After("loggingControllerPointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("After translateController method invoked:" + joinPoint.getSignature());
    }


}
