 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import javax.transaction.Transactional;
import org.equinton.pcm.aop.annotation.Monitor;
import org.equinton.pcm.back.entity.CollectionList;
import org.equinton.pcm.back.repository.CollectionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Emmanuel
 */
@Service
@Transactional
@Monitor
public class CollectionListService extends AbstractService<CollectionList, CollectionListRepository> {

    @Autowired
    private CollectionListRepository collectionListRepository;
    
    @Override
    protected CollectionListRepository getRepository() {
      return this.collectionListRepository;
    }

    

    

}
