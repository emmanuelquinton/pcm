/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.shared.poi;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Emmanuel
 */
public class ExcelFileFilter implements FileFilter {

    public boolean accept(File file) {
        return file.isFile()
                && file.getName().toLowerCase().endsWith(".xls");
    }
}
