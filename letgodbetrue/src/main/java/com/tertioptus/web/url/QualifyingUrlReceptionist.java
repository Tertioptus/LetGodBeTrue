package com.tertioptus.web.url;

import com.tertioptus.Sol;

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
public class QualifyingUrlReceptionist extends Sol implements UrlReceptionist {
	
	private final UrlReceptionist urlReceptionist;
	
	private final UrlValidator urlValidator;
	
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
		
		LOGGER.info("URL is valid");
		
		return url;
	}

}
