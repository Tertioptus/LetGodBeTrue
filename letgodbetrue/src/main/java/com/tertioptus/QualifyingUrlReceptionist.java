package com.tertioptus;

import java.util.logging.Logger;

import org.apache.commons.validator.routines.UrlValidator;


/**
 * 
 * @author P1836
 *
 */
public class QualifyingUrlReceptionist extends UrlValidator implements UrlReceptionist {
	
	private static final long serialVersionUID = 1L;

	private final UrlReceptionist urlReceptionist;
	
	private final static Logger LOGGER =  
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 	
	
	public QualifyingUrlReceptionist(UrlReceptionist urlReceptionist) {
		this.urlReceptionist = urlReceptionist;
	}

	/**
	 * 
	 */
	@Override
	public String url() throws Exception {
		
		String url = urlReceptionist.url();
		
		if(!isValid(url))
			throw new Exception(this.getClass().getName() + ": URL is invalid");
		
		LOGGER.info(this.getClass().getName() + ": URL is valid");
		
		return url;
	}

}
