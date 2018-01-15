/**
 * 
 */
package org.equinton.shared.poi;

import org.equinton.framework.exception.BasicException;
/**
 * @author Emmanuel
 *
 */
public class FileException extends Exception implements BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public FileException() {
		super();
	}

	public FileException(String message) {
		super(message);
	}
	
	public FileException(Throwable throwable) {
		super(throwable);
	}
	
	
	public FileException(String message,Throwable throwable) {
		super(throwable);
	}
}
