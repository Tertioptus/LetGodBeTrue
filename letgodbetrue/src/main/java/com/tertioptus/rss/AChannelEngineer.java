package com.tertioptus.rss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import com.rometools.modules.itunes.FeedInformation;
import com.rometools.modules.itunes.FeedInformationImpl;
import com.rometools.modules.itunes.types.Category;
import com.rometools.modules.itunes.types.Subcategory;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Image;

/**
 * Build and provide ROME channel object
 *
 * @author Benjamin F. Paige III
 * @since Feb 15, 2019
 */
final class AChannelEngineer implements ChannelEngineer {

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
		FeedInformation feedInfo = new FeedInformationImpl();
		channel.getModules().add(feedInfo);
		feedInfo.setKeywords(new String[] { "Bible", "KJV", "King James Version", "Plain preaching",
				"The Church of Greenville", "Church", "Greenville", "SC" });
		feedInfo.setOwnerEmailAddress("benpaigeiii@hotmail.com");
		feedInfo.setOwnerName("Ben Paige");
		Category category = new Category("Religion & Spirituality");
		category.setSubcategory(new Subcategory("Christianity"));
		feedInfo.getCategories().add(category);
		feedInfo.setAuthor("Church of Greenville");
		feedInfo.setSubtitle("Let God be true, but every man a liar as it is written... Romans 3:4");
		feedInfo.setSummary("Let God be true, but every man a liar as it is written... Romans 3:4");
		feedInfo.setExplicit(false);
		try {
			feedInfo.setImage(new URL(document[3]));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return channel;
	}

	private Image getImage(String imageValue) {
		Image image = new Image();
		image.setUrl(imageValue);
		image.setTitle("Let God Be True");
		image.setDescription("Let God be true, but every man a liar as it is written... Romans 3:4");
		image.setHeight(1446);
		image.setWidth(1446);
		return image;
	}
}
