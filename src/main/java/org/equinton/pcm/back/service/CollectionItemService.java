/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import javax.transaction.Transactional;
import org.equinton.pcm.back.entity.CollectionItem;
import org.equinton.pcm.back.repository.CollectionItemRepository;
import org.equinton.pcm.back.repository.CollectionListRepository;
import org.equinton.pcm.back.repository.PcmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Service permettant de manipuler les items d'une collection
 * @author Emmanuel
 */
@Repository
@Transactional
public class CollectionItemService extends AbstractService<CollectionItem, CollectionItemRepository> {

    @Autowired
    private CollectionItemRepository collectionItemRepository;

    @Override
    protected CollectionItemRepository getRepository() {
       return this.collectionItemRepository;
    }
    
    
    

    
    
}
