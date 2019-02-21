package com.tertioptus.rss;

import java.util.List;

import com.rometools.rome.feed.rss.Item;

/**
 * TODO PU-32 describe responsibility
 *
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
public class AnItemListEngineer implements ItemListEngineer {

	private final ItemEngineer itemEngineer;
	
	public AnItemListEngineer(ItemEngineer itemEngineer) {
		this.itemEngineer = itemEngineer;
	}

	@Override
	public List<Item> items() {

		// TODO PU-32
		return null;
	}

}
