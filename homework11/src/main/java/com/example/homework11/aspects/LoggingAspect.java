package com.example.homework11.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(@com.example.homework11.aspects.TrackUserAction *) && execution(* * (..))")
    public void annotatedByTrackUserAction() {
    }

    @Around("annotatedByTrackUserAction()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Calling method %s with parameters %s".formatted(
                joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()))
        );
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long executionTime = System.currentTimeMillis() - start;
        log.info("Execution of method %s finished. Execution time is %d ms."
                .formatted(joinPoint.getSignature(), executionTime));
        return result;
    }
}
