/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.equinton.pcm.config.AspectJConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emmanuel
 */
@Aspect
@Component
@ConditionalOnExpression("${pcm.aop.aspect.log}")
public class LogginAspect extends PcmAspect {


    
    
    @Pointcut("@annotation(org.equinton.pcm.aop.annotation.Log)")
    public void hasLogAnnotion() {}
    
    
    @Before("executionMethod() && hasLogAnnotion()")
    public void beforeExecutionMethodWithLogAnnotation(JoinPoint joinPoint) throws Throwable {
        System.out.println(">>>>> @Inject String field: "
                + joinPoint.getSignature() + " with value: " + joinPoint);
    }
}
