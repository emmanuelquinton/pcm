/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.aop;

import org.equinton.pcm.aop.annotation.Log;
import org.equinton.pcm.back.service.CollectionListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Emmanuel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogginAspectUTest {
    
    @Autowired
    private CollectionListService collectionListService;
    @Test
    public void testLog(){
        this.collectionListService.findAll();
        this.get();
    }
    
    @Log
    public void get(){
        System.out.println(">>>>>aop.LogginAspectUTest.get()");
    }
}
