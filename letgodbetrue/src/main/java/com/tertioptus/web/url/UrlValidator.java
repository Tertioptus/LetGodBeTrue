package com.tertioptus.web.url;

/**
 * Quality control technician for URL resolutions.
 *
 * @author Benjamin F. Paige III
 * @since Jan 19, 2019
 */
public interface UrlValidator {

	/**
	 * Checks the validity of a proposed URL.
	 * @param url
	 * @return true if the give text is a valid URL.
	 */
	boolean isValid(String url);
}
