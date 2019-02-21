package com.tertioptus.rss;

import java.util.List;
import java.util.stream.Stream;

import com.rometools.rome.feed.rss.Item;

/**
 * Creates a list of ROME items.
 *
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
public interface ItemListEngineer {

	/**
	 * Provides a list of ROME items.
	 * 
	 * @param itemStream A stream of item documents.
	 * @param host A base URL of media targets.
	 */
	List<Item> items(Stream<String[]> itemStream, String host);
}
