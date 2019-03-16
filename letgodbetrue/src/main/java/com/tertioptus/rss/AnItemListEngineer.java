package com.tertioptus.rss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.rometools.rome.feed.rss.Item;
import com.tertioptus.Sol;

/**
 * Default item list engineer.
 *
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
final class AnItemListEngineer extends Sol implements ItemListEngineer {

	private final ItemEngineer itemEngineer;

	public AnItemListEngineer(ItemEngineer itemEngineer) {
		this.itemEngineer = itemEngineer;
	}

	@Override
	public List<Item> items(Stream<String[]> items, String host) {
		List<Item> itemList = new ArrayList<>();
		items.forEach(itemDocument -> {
			try {
				add(itemDocument, itemList, host);
				LOGGER.info(itemList.size() + " entries processed." );
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return itemList;
	}

	private Object add(String[] itemDocument, List<Item> itemList, String host) throws Exception {

		for (int i = 0; i < 3; i++) {
			if (!itemDocument[i * 2 + 3].isEmpty()) {
				itemDocument[i * 2 + 3] = host + itemDocument[i * 2 + 3];
				itemList.add(itemEngineer.item(itemDocument, i));
			}
		}

		return null;
	}
}
