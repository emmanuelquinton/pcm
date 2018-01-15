/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.batch.cvstomysql;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.equinton.pcm.back.entity.CollectionItem;
import org.equinton.shared.data.Data;
import org.equinton.shared.poi.ExcelFileManager;
import org.equinton.shared.poi.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Emmanuel
 */
public class PcmCvsReader implements ItemReader<CollectionItem> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PcmCvsReader.class);

    
    private Data data ;
    private int dataIndex =1;
    public PcmCvsReader(String filePath) {
        init(filePath);
    }

    private void init(String filePath) {
        Resource resource = new ClassPathResource("films.xls");
        this.dataIndex =0;
        try {
            File file = resource.getFile();
            this.data = ExcelFileManager.getFile(file.getPath());
        } catch (IOException ex) {
          LOGGER.error(ex.getMessage());
        } catch (FileException ex) {
            LOGGER.error(ex.getMessage());
        }
    }

    public CollectionItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        CollectionItem collectionItem = null;
         if (dataIndex < this.data.getRows().size()) {
             
            collectionItem = new CollectionItem(
                    String.valueOf(getValue(getIndexColumn("name"))),
                    String.valueOf(getValue(getIndexColumn("genre"))), 
                    String.valueOf(getValue(getIndexColumn("support"))),
                    String.valueOf(getValue(getIndexColumn("editor"))), 
                    String.valueOf(getValue(getIndexColumn("author"))), 
                    null);
            this.dataIndex++;
            
            LOGGER.info(collectionItem.toString());
        }
 
        return collectionItem;
    }                                                                                                                                                                                                                                                                                                                                                                                                                                           

    private int getIndexColumn(String columnName) {
        return this.data.getColumnTitles().indexOf(columnName);
    }
    
    private Object getValue(int indexColumn) {
        Object object = null;
        if(indexColumn >=0 ) {
            object = this.data.getRows().get(dataIndex).getColumns().get(indexColumn);
        } 
        if(object != null) {
            LOGGER.info(object.toString());
        }
        
        return object;
    }
}
