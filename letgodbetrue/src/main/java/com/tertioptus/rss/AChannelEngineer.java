package com.tertioptus.rss;

import java.util.stream.Stream;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Image;

/**
 * Build and provide ROME channel object
 *
 * @author Benjamin F. Paige III
 * @since Feb 15, 2019
 */
public final class AChannelEngineer implements ChannelEngineer {
	
	private final Channel channel = new Channel("rss_2.0");
	private final ItemListEngineer itemListEngineer;
	
	public AChannelEngineer(ItemListEngineer itemListEngineer) {
		this.itemListEngineer = itemListEngineer;
	}

	@Override
	public Channel component(String[] document, Stream<String[]> itemStream) {
		channel.setLanguage(document[0]);
        channel.setTitle(document[1]);
        channel.setDescription(document[2]);
        channel.setImage(getImage(document[3]));
        channel.setLink(document[4]);
        channel.setItems(itemListEngineer.items(itemStream, document[4]));
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
