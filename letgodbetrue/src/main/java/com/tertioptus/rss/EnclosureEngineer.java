package com.tertioptus.rss;

import com.rometools.rome.feed.rss.Enclosure;

public interface EnclosureEngineer {

	Enclosure enclosure(String url);

}
