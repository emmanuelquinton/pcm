/**
 * 
 */
package org.equinton.shared.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author validation
 *
 */
public class Row {
	
	//Liste des colonnes de la ligne
	private List<Object> columns =null;
	
	public Row() {
		//Initialisation de la collection de cellules
		columns = new ArrayList<Object>();
	}

	//Retourne la liste des colonnes de la ligne
	public List<Object> getColumns() {
		return columns;
	}

	/**
	 * Ajout une collonne à la ligne
	 * @param columnValue Valeur placé dans la colonne.
	 * @return la ligne 
	 */
	public Row addColumn(Object columnValue){
		//La liste des colonnes est initialisé à l'instanciation
		columns.add(columnValue);
		return this;
	}
	
	public Row updateColumnValue(int columnIndex, Object newColumnValue){
		if(columnIndex > this.columns.size()){
			
			return this;
		}
		this.columns.add(columnIndex, newColumnValue);
		
		return this;
	}
	
	
	
	

}
