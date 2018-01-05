/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.repository;

import java.io.Serializable;
import org.equinton.pcm.back.entity.PcmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Emmanuel
 * @param <E> Entity which extends PcmEntity
 */
@NoRepositoryBean
public interface PcmRepository<E extends PcmEntity> extends JpaRepository<E, Serializable> {
        
    public E findById(Long id);
    
}
