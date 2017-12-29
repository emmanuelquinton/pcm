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
import org.equinton.pcm.back.dao.PcmObject;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emmanuel
 * @param <T>
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractService<T extends PcmObject> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> pcmBeanClass;

    @PostConstruct
    private void init() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        pcmBeanClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public long insert(T object) {
        this.entityManager.persist(object);
        return object.getId();
    }

    public T findById(Long Id) {
        return this.entityManager.find(pcmBeanClass, Id);
    }

    public List<T> findAll() {
        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQueryBean = criteriaBuilder.createQuery();
        criteriaQueryBean.select(criteriaQueryBean.from(pcmBeanClass));
        return this.entityManager.createQuery(criteriaQueryBean).getResultList();
    }

}
