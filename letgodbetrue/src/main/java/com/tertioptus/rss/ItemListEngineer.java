package com.tertioptus.rss;

import java.util.List;
import java.util.stream.Stream;

import com.rometools.rome.feed.rss.Item;

/**
 * TODO PU-32 describe responsibility
 *
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
public interface ItemListEngineer {

	/**
	 * TODO PU-32
	 * @param itemStream 
	 * @return
	 */
	List<Item> items(Stream<String[]> itemStream);
}
