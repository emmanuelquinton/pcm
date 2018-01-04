/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.controller.dto;

import org.equinton.pcm.back.dao.CollectionItem;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Emmanuel
 */
public class CollectionItemDTO {
        
    private String name;
    private String author;
    private String editor;
    private CollectionListDTO collection;

    public CollectionItemDTO() {
        super();
    }
    
    /**
     * Allow map Collection in DTO
     * @param collectionItem collection item
     */
    public void map(final CollectionItem collectionItem) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(collectionItem, this);
    }
    
    /**
     * Allow map DTO in  CollectionItem
     * @return  CollectionItem
     */
    public CollectionItem  map() {
        ModelMapper modelMapper = new ModelMapper();
        CollectionItem collectionItem = new CollectionItem();
        modelMapper.map(this,collectionItem);
        return collectionItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public CollectionListDTO getCollection() {
        return collection;
    }

    public void setCollection(CollectionListDTO collection) {
        this.collection = collection;
    }
    
    
}
