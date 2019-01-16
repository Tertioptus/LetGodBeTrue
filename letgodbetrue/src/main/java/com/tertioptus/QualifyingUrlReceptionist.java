package com.tertioptus;

import java.util.logging.Logger;

import org.apache.commons.validator.routines.UrlValidator;

/**
 * 
 * Considers the quality of the URL.
 *
 * @assertion
 * <pre> 
 * 	TODO implement class assertion
 * </pre>
 *
 * @author Benjamin F. Paige III
 * @since Jan 15, 2019
 */
public class QualifyingUrlReceptionist extends UrlValidator implements UrlReceptionist {
	
	private static final long serialVersionUID = 1L;

	private final UrlReceptionist urlReceptionist;
	
	private final static Logger LOGGER =  
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 	
	
	/**
	 * Default constructor.
	 * 
	 * <pre>
	 * 	badUrlReceptionist = mock(UrlReceptionist);
	 * </pre>
	 * 
	 * @param urlReceptionist
	 */
	public QualifyingUrlReceptionist(UrlReceptionist urlReceptionist) {
		this.urlReceptionist = urlReceptionist;
	}

	/**
	 * @assertion A bad URL receptionist causes an exception to be raised.
	 * <pre>
	 * 	assertException(badUrlReceptionist.url())
	 * </pre>
	 * 
	 * @assertion A good URL receptionist presents a non-empty String.
	 * <pre>
	 * 	assertTrue(goodUrlReceptionist.url().isNotEmpty())
	 * </pre>
	 */
	public String url() throws Exception {
		
		String url = urlReceptionist.url();
		
		if(!isValid(url))
			throw new Exception(this.getClass().getName() + ": URL is invalid");
		
		LOGGER.info(this.getClass().getName() + ": URL is valid");
		
		return url;
	}

}
