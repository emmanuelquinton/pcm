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
import org.equinton.pcm.back.entity.CollectionList;
import org.springframework.stereotype.Component;

/**
 * Aspect frol CollectionListService
 * @author Emmanuel
 */
@Aspect
@Component
public class CollectionListAspect {
    
    /**
     * Point cut execute with inster metho
     */
    @Pointcut("execution(* org.equinton.pcm.back.service.AbstractService+.insert(..))")
    public void pointcut() {}
    

    @Before("pointcut()")
    public void beforeInsertEntity(JoinPoint jp) {
        System.out.println("CollectionListAspect JoinPoint =" + jp);
        System.out.println(
                "Entering class: " + jp.getSignature().getDeclaringTypeName() +
                        " - before method: " + jp.getSignature().getName());

        // check for argument type of String 
        Object[] args = jp.getArgs();
        if (args.length == 1) {
            if (args[0] instanceof String) {
                System.out.println("1. parameter type is string");
            } else {
                System.out.println("2. parameter type is not string");
            }
        }
    }
}
