package com.common.utils.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LogManager.getLogger();

    @Pointcut("within(com..*)")
    public void logAll() {}

    @Before(value = "logAll()")
    public void logMethodStart(JoinPoint jp) {
        String methodSig = extractMethodSignature(jp);
        String methodArgs = Arrays.toString(jp.getArgs());
        logger.info("{} invoked with provided arguments: {}", methodSig, methodArgs);
    }

    @AfterReturning(value = "logAll()", returning = "returnedObj")
    public void logMethodReturn(JoinPoint jp, Object returnedObj) {
        String methodSig = extractMethodSignature(jp);
        logger.info("{} successfully returned with the value: {}", methodSig, returnedObj);
    }

    @AfterThrowing(value = "logAll()", throwing = "t")
    public void logMethodException(JoinPoint jp, Throwable t) {
        String methodSig = extractMethodSignature(jp);
        String exceptionName = t.getClass().getSimpleName();
        logger.warn("{} was thrown in method {} with the message \"{}\"", exceptionName, methodSig, t.getMessage());
    }

    private String extractMethodSignature(JoinPoint jp) {
        return jp.getTarget().getClass().getSimpleName() + "#" + jp.getSignature().getName();
    }
}
