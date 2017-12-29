/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.dao;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.equinton.pcm.back.common.CollectionType;

/**
 * Collection as DVD Collection or
 *
 * @author Emmanuel
 */
@Entity(name = "COLLECTION")
public class Collection extends PcmObject {

    @Column
    private String name;
    @Column
    private CollectionType type;
    
    @Column
//    @ElementCollection(targetClass=CollectionItem.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collection")
    private Set<CollectionItem> items;

    public Collection() {
        super();
        this.items = new TreeSet<>();

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

    public void addItem(CollectionItem item) {
        this.items.add(item);
    }

}
