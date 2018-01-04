/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.controller.dto;

import org.equinton.pcm.back.common.CollectionType;
import org.equinton.pcm.back.dao.CollectionList;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Emmanuel
 */
public class CollectionListDTO {
    private String name;
    private CollectionType type;

    /**
     * Constructeur par défaut
     */
    public CollectionListDTO() {
        super();
    }

    /**
     * Allow map Collection in DTO
     * @param collection collection list
     */
    public void map(final CollectionList collection) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(collection, this);
    }
    
        /**
     * Allow map Collection in DTO
     * @param collection collection list
     */
    public CollectionList  map() {
        ModelMapper modelMapper = new ModelMapper();
        CollectionList collection = new CollectionList();
        modelMapper.map(this,collection);
        return collection;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollectionType getType() {
        return type;
    }

    public void setType(CollectionType type) {
        this.type = type;
    }
    
    
}
