/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.aop;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emmanuel
 */
@Component
@Aspect
@ConditionalOnExpression("${pcm.aop.aspect.monitor}")
public class MonitorAspect extends PcmAspect{
    
    @Pointcut("@within(org.equinton.pcm.aop.annotation.Monitor) || @annotation(org.equinton.pcm.aop.annotation.Monitor)")
    public void hasMonitorAnnotation() {}
    
    
    @Around("executionMethod() && hasMonitorAnnotation()")
    public Object  arroundExecutionMethodWithMonitorAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant startInstant = Instant.now();
        
        Object proceed = joinPoint.proceed();
        
        Instant endInstant = Instant.now();
        
        System.out.println(">>>>>duration execution method ins miliseconds ="+ChronoUnit.MILLIS.between(startInstant, endInstant));
        
        return proceed;
    }
}
