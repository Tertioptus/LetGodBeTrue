package com.tertioptus.rss;

import com.rometools.rome.feed.rss.Channel;

public interface ChannelEngineer {

	Channel component(String[] document);
}
