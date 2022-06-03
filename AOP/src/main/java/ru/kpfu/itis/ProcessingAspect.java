package ru.kpfu.itis;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProcessingAspect {

    @Before("execution(* *..TestController.*(..))")
    public void log(JoinPoint jp) throws Throwable {
        System.out.println("Advice worked");
    }

    @Around("@annotation(ru.kpfu.itis.Process)")
    public String process(ProceedingJoinPoint jp) throws Throwable {
        String result = (String) jp.proceed();
        return result.replace("world", "ITIS");
    }
}
