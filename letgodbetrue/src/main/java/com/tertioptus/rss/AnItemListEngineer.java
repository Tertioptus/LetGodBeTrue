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
	public List<Item> items(Stream<String[]> items, String host) {
		List<Item> itemList = new ArrayList<>();
		items.forEach(itemDocument -> {
			try {
				add(itemDocument, itemList, host);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
