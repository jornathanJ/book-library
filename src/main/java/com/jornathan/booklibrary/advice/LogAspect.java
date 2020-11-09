package com.jornathan.booklibrary.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Aspect
@Component
public class LogAspect {

    Logger logger = (Logger) LoggerFactory.getLogger(LogAspect.class);

    //@Around("execution(* com.jornathan.booklibrary.service.redis.MyBookService.*(..))")
    @Around("execution(* com.jornathan.booklibrary.controller.MyBookController.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("start - {} / {}" , pjp.getSignature().getDeclaringTypeName()
                                    , pjp.getSignature().getName() );
        LocalDateTime startTm = LocalDate.now().atStartOfDay();

        Object result = pjp.proceed();

        logger.info("finished - {} / {}" , pjp.getSignature().getDeclaringTypeName()
                , pjp.getSignature().getName() );

        LocalDateTime endTm = LocalDate.now().atStartOfDay();
        logger.info("Duration is : {}:{}", Duration.between(startTm, endTm).getSeconds()
        , Duration.between(startTm, endTm).getNano());

        return result;
    }


    //@Before("execution(* com.jornathan.booklibrary.service.*.get*(..))")
    public void logBeforeService(){
        logger.info("logBeforeService under service and preFix is get.");
    }
}
