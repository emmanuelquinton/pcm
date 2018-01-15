/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.batch.cvstomysql;

import org.equinton.pcm.back.entity.CollectionItem;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;

/**
 *
 * @author Emmanuel
 */
public class PcmCvsProcessor implements ItemProcessor<CollectionItem, CollectionItem>{

    @Override
    public CollectionItem process(CollectionItem i) throws Exception {
        return i;
    }
    
}
