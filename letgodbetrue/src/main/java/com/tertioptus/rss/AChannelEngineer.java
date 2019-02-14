package com.tertioptus.rss;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Image;

/**
 * Build and provide ROME channel object
 *
 * @author Benjamin F. Paige III
 * @since Feb 15, 2019
 */
public final class AChannelEngineer implements ChannelEngineer<String[]> {
	
	private final Channel channel = new Channel("rss_2.0");
	
	@Override
	public Object component(String[] document) {
		channel.setLanguage(document[0]);
        channel.setTitle(document[1]);
        channel.setDescription(document[2]);
        channel.setImage(getImage(document[3]));
        channel.setLink(document[4]);
		return channel;
	}
	
	private Image getImage(String imageValue) {
        Image image = new Image();
        image.setUrl(imageValue);
        image.setTitle("logo");
        image.setDescription("logo");
        return image;
	}

}
