package com.tertioptus.rss;

import java.util.stream.Stream;

import com.rometools.rome.feed.rss.Channel;

public interface ChannelEngineer {

	Channel component(String[] document, Stream<String[]> items);
}
