package com.tertioptus.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
	public List<Item> items(Stream<String[]> items) {
		List<Item> itemList = new ArrayList<>();
		items.forEach(itemDocument -> add(itemDocument, itemList, 0));
		return itemList;
	}

	private Object add(String[] itemDocument, List<Item> itemList, int selection) {

		itemList.add(itemEngineer.item(itemDocument, selection));
		
		if(!itemDocument[selection * 2 + 3].isEmpty() || selection > 1)
			add(itemDocument, itemList, selection++);
		
		return null;
	}
}
