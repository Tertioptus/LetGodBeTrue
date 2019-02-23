package com.tertioptus.rss;

import com.rometools.rome.feed.rss.Item;

/**
 * Responsible for the management of a ROME item.
 *
 * @author Benjamin F. Paige III
 * @since Feb 22, 2019
 */
public interface ItemEngineer {

	Item item(String[] itemDocument, int selection);

}
