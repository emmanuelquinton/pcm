/**
 * 
 */
package org.equinton.shared.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.equinton.shared.data.Data;
import org.equinton.shared.data.Row;

/**
 * @author Emmanuel Permet la manipulation de fichier de type excel ou autre
 *         tableur
 */
public class ExcelFileManager {

	/**
	 * Constructeur
	 */
	public ExcelFileManager() {

	}

	/**
	 * R�cup�re les donn�es d'un fichier de type tableur
	 * @param filePath- Chemin du fichier � lire
	 * @return Un objet de type data
	 */
	@SuppressWarnings("deprecation")
	public static Data getFile(String filePath) throws FileException {
		Data data = new Data();

		/*
		 * Ouverture du fichier
		 */
		InputStream inp=null;
		try {
			inp = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			throw new FileException();
		}

		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(inp);
		} catch (IOException e) {
			throw new FileException(e.getMessage());
		}
		//Ouverture de la premi�re page
		HSSFSheet sheet = workbook.getSheetAt(0);
		//R�cup�ration du nombre de  ligne
		int rowNumber = sheet.getLastRowNum();
		// R�cup�ration du nombre de collone
		int columnNumber = sheet.getRow(0).getLastCellNum();

		/*
		 * Parcour des donn�es
		 */
		for (int indexRow = 0; indexRow <= rowNumber; indexRow++) {
			HSSFRow row = sheet.getRow(indexRow);
			// parcours la ligne pour r�cup�rer les colonnes
			if (row != null) {
				Row currentRow = null;
				if(indexRow >0){
					currentRow = data.addRow();
				}
				for (int indexColumn = 0; indexColumn < columnNumber; indexColumn++) {					
					
					// Récupère la cellule puis sa valeur
					HSSFCell cell = row.getCell((short) indexColumn);
					Object value = null;
					if (cell == null) {
						value = "";
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
						value = cell.getBooleanCellValue();
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
						value = cell.getErrorCellValue();
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
						value = cell.getCellFormula();
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						value = cell.getNumericCellValue();
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						value = cell.getStringCellValue();
					}
					
					/*
					 *La 1ere colonne sert pour les titre
					 *elle n'est donc pas prise en compte 
					 */
					if(indexRow==0){
						data.getColumnTitles().add(value);
					}else{
						currentRow.addColumn(value);
					}
				}

			}

		}
		try {
			inp.close();
		} catch (IOException e) {
			throw new FileException(e.getMessage());
		}

		// retour
		return data;
	}
	
	public static boolean saveFile(Data data ,String filePath) throws FileException{
		boolean isSaved = false;

		
		//Enregistrement des cellules
		
		//Cr�ation d'un classeur et d'une feuille � l'interieur
		HSSFWorkbook wb = new HSSFWorkbook();
	    HSSFSheet sheet = wb.createSheet();

		/*Parcours des donn�es :
		 * parcours ligne par ligne puis cellules par cellules
		 */
		List<Row> rows = data.getRows();
		//parcours des lignes
		int indexRow = 0;
		for(Row row : rows){
			HSSFRow hssfRow = sheet.createRow(indexRow);
			//parcours des cellules
			List<Object>columns = row.getColumns();
			int indexColum = 0;
			//parcours des colonnes
			for(Object column:columns){
				HSSFCell hssfCell = hssfRow.createCell(indexColum);
				hssfCell.setCellValue((String)column);
				indexColum++;
			}
			//Incr�mentation de l'index de la ligne
			indexRow++;
		}
	    
		//Sauvegarde du fichier
	    try {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			isSaved = false;
			throw new FileException(e.getMessage());
		} catch (IOException e) {
			isSaved = false;
			throw new FileException(e.getMessage());
		}
		
		return isSaved;
	}
}
