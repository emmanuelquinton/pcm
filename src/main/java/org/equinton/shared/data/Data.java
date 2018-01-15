/**
 * 
 */
package org.equinton.shared.data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Emmanuel QUINTON
 *
 */
public class Data {
	
	protected final AbstractList<Row> rows;
	protected final AbstractList<Object>columnTitles;
	
	public Data() {
		rows = new ArrayList<>();
		columnTitles= new ArrayList<>();
	}
	
	/**
	 * Add row to the structure
	 */
	public Row addRow(){
		Row row = new Row();
		rows.add(row);
		return row;
	}
	

	/**
	 * @return the columnTitles
	 */
	public List<Object> getColumnTitles() {
		return columnTitles;
	}

	/**
	 * @return the rows
	 */
	public List<Row> getRows() {
		return rows;
	}

	/**
	 * Modifie une ligne
	 * @param rowIndex
	 * @param newRow
	 */
	public void updateRow(int rowIndex, Row newRow){
		if(rowIndex > this.rows.size()){
		//TODO gérer une exception	
		}
		
		this.rows.add(rowIndex, newRow);
	}
	
	
	/**
	 * Supprime une ligne
	 * @param rowIndex index de la ligne à supprimer
	 */
	public void deleteRow(int rowIndex){
		if(rowIndex > this.rows.size()){
		//TODO gérer une exception	
		}
		
		this.rows.remove(rowIndex);
	}
	
	/**
	 * Supprime une ligne
	 * @param row Ligne à supprimer
	 */
	public void deleteRow(Row row){
		this.rows.remove(row);
	}

}
