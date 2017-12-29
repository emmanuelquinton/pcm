/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import java.util.List;
import org.equinton.pcm.back.common.CollectionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.equinton.pcm.back.dao.Collection;
/**
 *
 * @author Emmanuel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionServiceITest {
    
    @Autowired
     private CollectionService collectionService;


    
    @Test
    public void createAndList() {
        Collection collectionDVD = new Collection();
        collectionDVD.setName("DVD");
        collectionDVD.setType(CollectionType.DVD);
        
        Collection collectionBook = new Collection();
        collectionBook.setName("LIVRES");
        collectionBook.setType(CollectionType.BOOK);
        
        Long idCollectionDVD = this.collectionService.insert(collectionDVD);
        Assert.assertTrue(idCollectionDVD != null);
        
        Long idCollectionBook = this.collectionService.insert(collectionBook);
        Assert.assertTrue(idCollectionBook != null);
        
        
        List<Collection> collections = this.collectionService.findAll();
        Assert.assertEquals(2, collections.size());
    }

}
