/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.batch.cvstomysql;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.equinton.pcm.back.entity.CollectionItem;

/**
 *
 * @author Emmanuel
 */
public class PcmCvsReaderMain {
    
    public static void main(String[] args){
        PcmCvsReader reader = new PcmCvsReader("film.xls");
        try {
            CollectionItem collectionItem = reader.read();
        } catch (Exception ex) {
            Logger.getLogger(PcmCvsReaderMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
