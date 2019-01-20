package com.tertioptus.web.url;

import java.util.logging.Logger;

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
public class QualifyingUrlReceptionist implements UrlReceptionist {
	
	private final UrlReceptionist urlReceptionist;
	
	private final UrlValidator urlValidator;
	
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
	public QualifyingUrlReceptionist(UrlValidator urlValidator, UrlReceptionist urlReceptionist) {
		this.urlValidator = urlValidator;
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
		
		if(!urlValidator.isValid(url))
			throw new Exception(this.getClass().getName() + ": URL is invalid");
		
		LOGGER.info(this.getClass().getName() + ": URL is valid");
		
		return url;
	}

}
