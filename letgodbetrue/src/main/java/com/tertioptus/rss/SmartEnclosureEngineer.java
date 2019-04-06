package com.tertioptus.rss;

import com.rometools.rome.feed.rss.Enclosure;

public class SmartEnclosureEngineer implements EnclosureEngineer {

	private static final String RESOURCE = "size-cache.csv";
	private final EnclosureEngineer enclosureEngineer;
	private final LookupReadingEngineer lookupReadingEngineer;
	private final LookupWritingEngineer lookupWritingEngineer;

	public SmartEnclosureEngineer(EnclosureEngineer enclosureEngineer, LookupReadingEngineer lookupReadingEngineer,
			LookupWritingEngineer lookupWritingEngineer) {
		this.enclosureEngineer = enclosureEngineer;
		this.lookupReadingEngineer = lookupReadingEngineer;
		this.lookupWritingEngineer = lookupWritingEngineer;
	}

	@Override
	public Enclosure enclosure(String url) throws Exception {
		String size = lookupReadingEngineer.value(RESOURCE, url);
		Enclosure enclosure;
		if (size.isEmpty()) {
			enclosure = this.enclosureEngineer.enclosure(url);
			size = Long.toString(enclosure.getLength());
			lookupWritingEngineer.record(RESOURCE, url, size);
		} else {
			enclosure = new Enclosure();
			enclosure.setUrl(url);
			enclosure.setType("audio/mpeg");
		}
		enclosure.setLength(Long.parseLong(size));
		return enclosure;
	}
}
