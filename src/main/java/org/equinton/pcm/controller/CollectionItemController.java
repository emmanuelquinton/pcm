/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.controller;

import java.util.ArrayList;
import java.util.List;
import org.equinton.pcm.back.entity.CollectionItem;
import org.equinton.pcm.back.service.CollectionItemService;
import org.equinton.pcm.controller.dto.CollectionItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Emmanuel
 */
@RestController
@RequestMapping("/api/item")
public class CollectionItemController {

    @Autowired
    private CollectionItemService collectionItemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CollectionItemDTO> findAll() {
        List<CollectionItemDTO> collectionItemDTOs = new ArrayList<>();
        List<CollectionItem> collectionItems = this.collectionItemService.findAll();
        collectionItems.stream().forEach(collectionItem -> {
            CollectionItemDTO collectionItemDTO = new CollectionItemDTO();
            collectionItemDTO.map(collectionItem);
            collectionItemDTOs.add(collectionItemDTO);
        });
        return collectionItemDTOs;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CollectionItemDTO> create(@RequestBody final CollectionItemDTO dto) {
        CollectionItem collectionItem = dto.map();
        Long id = this.collectionItemService.insert(collectionItem);
        collectionItem.setId(id);
        dto.map(collectionItem);
        return ResponseEntity.ok().body(dto);
    }
}
