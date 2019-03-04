package com.tertioptus.web;

import java.util.stream.Stream;

/**
 * 
 * Gets a stream of data from the web.
 *
 * @author Benjamin F. Paige III
 * @since Feb 6, 2019
 * @param <T> data type to be returned
 */
interface WebContentEngineer<T> {

	/**
	 * Fetch behavior that returns a stream of data 
	 * @param url URL
	 * @param id Containing HTML element id
	 */
	public Stream<T> stream(String url, String id) throws Exception;
}
