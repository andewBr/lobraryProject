package com.example.LibraryProject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.LibraryProject.service.BookService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        logger.info("Entering method: " + joinPoint.getSignature().getName() + " with arguments: " + joinPoint.getArgs());

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("Exception in method: " + joinPoint.getSignature().getName(), throwable);
            throw throwable;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Exiting method: " + joinPoint.getSignature().getName() + " with result: " + result + " in " + elapsedTime + "ms");

        return result;
    }
}
