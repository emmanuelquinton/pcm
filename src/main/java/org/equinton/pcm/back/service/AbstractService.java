/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.equinton.pcm.back.entity.PcmEntity;
import org.equinton.pcm.back.repository.PcmRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emmanuel
 * @param <E>
 * @param <R>
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractService<E extends PcmEntity, R extends PcmRepository> {


    public long insert(E object) {
        this.getRepository().save(object);
        return object.getId();
    }

    public E findById(Long Id) {
        return (E)this.getRepository().findById(Id);
    }

    public List<E> findAll() {
        return this.getRepository().findAll();
    }
    
    protected abstract R getRepository() ;
}
