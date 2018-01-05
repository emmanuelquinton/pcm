/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.controller;

import java.util.ArrayList;
import java.util.List;
import org.equinton.pcm.back.entity.CollectionList;
import org.equinton.pcm.back.service.CollectionListService;
import org.equinton.pcm.controller.dto.CollectionListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller  
 * @author Emmanuel QUINTON
 */
@RestController
@RequestMapping("/api/collection")
public class CollectionListController  {
    
        @Autowired
        private CollectionListService collectionService;
        
        /**
         * Allow to get a CollectionListDTO
         * @return List
         */
	@RequestMapping(method = RequestMethod.GET)
	public List<CollectionListDTO> findAll() {
            List<CollectionList> collections = this.collectionService.findAll();
            List<CollectionListDTO> collectionDTOs = new ArrayList<>();
            for (CollectionList collection : collections) {
                CollectionListDTO collectionListDTO = new CollectionListDTO();
                collectionListDTO.map(collection);
                collectionDTOs.add(collectionListDTO);
            }
            return collectionDTOs;
	}
        
        /**
         * Allow to insert a CollectionListDTO
         * @return CollectionListDTO
         */
	@RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<CollectionListDTO> create(@RequestBody final CollectionListDTO dto) {
            CollectionList collection = dto.map();
            Long id = this.collectionService.insert(collection);
            collection.setId(id);
            dto.map(collection);
            return ResponseEntity.ok().body(dto);
	}
}
