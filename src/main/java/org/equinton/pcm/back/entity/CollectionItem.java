/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Collection item
 * @author Emmanuel
 */
@Entity(name="COLLECTION_ITEM")
public class CollectionItem extends PcmEntity {
    
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String editor;
    @ManyToOne
    private CollectionList collection;
    
    
           
    /***
     * Default constructor
     */
    public CollectionItem() {
        super();
    }

    /**
     * Constructor
     * @param name
     * @param author
     * @param editor 
     */
    public CollectionItem(String name, String author, String editor, CollectionList collection) {
        super();
        this.name = name;
        this.author = author;
        this.editor = editor;
        this.collection = collection;
    }
    
    /**
     * Return name of item
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Return author of item
     * @return  String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Return editor of item
     * @return 
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Return collection of item; 
     * an item can belong to one and only one collection
     * @return Collection
     */
    public CollectionList getCollection() {
        return collection;
    }
    
    
}
