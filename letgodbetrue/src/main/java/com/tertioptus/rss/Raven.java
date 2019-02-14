package com.tertioptus.rss;

/**
 * 
 * Sends rss file out to a desired location.
 *
 * @author Benjamin F. Paige III
 * @since Feb 9, 2019
 */
public interface Raven {

	public void dispatch(String filename);
}
