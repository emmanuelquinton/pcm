/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.back.dao;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.equinton.pcm.back.common.CollectionType;

/**
 * Collection as DVD Collection or
 *
 * @author Emmanuel
 */
@Entity(name = "COLLECTION")
public class CollectionList extends PcmObject {

    @Column
    private String name;
    @Column
    private CollectionType type;
    
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collection")
    private Set<CollectionItem> items;

    public CollectionList() {
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
