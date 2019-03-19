package com.tertioptus.rss;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.rometools.modules.itunes.EntryInformation;
import com.rometools.modules.itunes.EntryInformationImpl;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Enclosure;
import com.rometools.rome.feed.rss.Item;

/**
 * Default instance responsible for the management of a ROME item.
 * 
 * @author Benjamin F. Paige III
 * @since Feb 21, 2019
 */
final class AnItemEngineer implements ItemEngineer {

	public AnItemEngineer(EnclosureEngineer enclosureEngineer) {
		this.enclosureEngineer = enclosureEngineer;
	}

	private final EnclosureEngineer enclosureEngineer;

	private final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	@Override
	public Item item(String[] itemDocument, int selection) throws Exception {
		Item item = new Item();
		item.setTitle(itemDocument[selection * 2 + 2] + ": " + itemDocument[1]);
		item.setDescription(description(itemDocument));
		item.setEnclosures(enclosures(itemDocument, selection));
		item.setPubDate(format.parse(itemDocument[0].substring(0, 8)));
		EntryInformation entryInfo = new EntryInformationImpl();
		entryInfo.setKeywords(new String[] { "Sermon" });
		entryInfo.setAuthor("Jonathan Crosby");
		entryInfo.setSummary(itemDocument[8]);
		entryInfo.setSubtitle(itemDocument[8]);
		item.getModules().add(entryInfo);
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
