package com.tertioptus.web.url;

/**
 * Technician of the Apchache UrlValidator
 * 
 *  @see org.apache.commons.validator.routines.UrlValidator
 *
 * @author Benjamin F. Paige III
 * @since Jan 19, 2019
 */
public class ApacheUrlValidatorEngineer implements UrlValidator {
	
	private  org.apache.commons.validator.routines.UrlValidator urlValidator;
	
	public ApacheUrlValidatorEngineer() {
		this.urlValidator = new org.apache.commons.validator.routines.UrlValidator();
	}

	@Override
	public boolean isValid(String url) {
		return this.urlValidator.isValid(url);
	}
}
