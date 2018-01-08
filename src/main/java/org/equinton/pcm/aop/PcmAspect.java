/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emmanuel
 */
@Component
public class PcmAspect {
    
    @Pointcut("execution(* org.equinton.pcm..*(..))")
    public void executionMethod() {}
    
    
}
