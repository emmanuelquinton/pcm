/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import java.util.List;
import org.equinton.pcm.back.common.CollectionType;
import org.equinton.pcm.back.entity.CollectionList;
import org.equinton.pcm.back.entity.CollectionItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test from CollectionItemService class
 *
 * @author Emmanuel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionItemServiceITest {

    @Autowired
    private CollectionItemService collectionItemService;
    @Autowired
    private CollectionListService collectionService;

    @Test
    public void createAndList() {
        CollectionList collectionDVD = new CollectionList();
        collectionDVD.setName("DVD");
        collectionDVD.setType(CollectionType.DVD);
        this.collectionService.insert(collectionDVD);

        CollectionItem hobbitDVD = new CollectionItem("The Hobbit", "Tolkien", "", collectionDVD);

        // Create collection item
        Long idHobbitDVD = this.collectionItemService.insert(hobbitDVD);
        Assert.assertTrue(idHobbitDVD != null);
        List<CollectionItem> collections = this.collectionItemService.findAll();
        Assert.assertEquals(1, collections.size());
    }
}
