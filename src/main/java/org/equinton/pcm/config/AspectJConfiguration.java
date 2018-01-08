/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Emmanuel
 */
@Configuration
public class AspectJConfiguration {
    
    @Value("${pcm.aop.aspect.log}")
    private boolean log;

    
    
}
