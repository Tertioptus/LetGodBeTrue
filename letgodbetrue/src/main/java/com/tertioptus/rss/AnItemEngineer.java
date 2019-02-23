package com.tertioptus.rss;

import java.util.Arrays;
import java.util.List;

import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Enclosure;
import com.rometools.rome.feed.rss.Item;

/**
 * Default instance responsible for the management of a ROME item.
 * 
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
public class AnItemEngineer implements ItemEngineer {
	
	private final EnclosureEngineer enclosureEngineer;

	public AnItemEngineer(EnclosureEngineer enclosureEngineer) {

		this.enclosureEngineer = enclosureEngineer;
	}

	@Override
	public Item item(String[] itemDocument, int selection) {
		Item item = new Item();
		item.setTitle(itemDocument[selection * 2 + 2] + ": " + itemDocument[1]);
		item.setDescription(description(itemDocument));
		item.setEnclosures(enclosures(itemDocument, selection));
		return item;
	}

	private List<Enclosure> enclosures(String[] itemDocument, int selection) {
		return Arrays.asList(enclosureEngineer.enclosure(itemDocument[selection * 2 + 3]));
	}

	private Description description(String[] itemDocument) {
		Description description = new Description();
		description.setType("text");
		description.setValue(itemDocument[8]);
		return description;
	}
}
