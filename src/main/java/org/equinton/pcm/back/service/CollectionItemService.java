/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import javax.transaction.Transactional;
import org.equinton.pcm.back.dao.CollectionItem;
import org.springframework.stereotype.Repository;

/**
 * Service permettant de manipuler les items d'une collection
 * @author Emmanuel
 */
@Repository
@Transactional
public class CollectionItemService extends AbstractService<CollectionItem> {

    
    
}
