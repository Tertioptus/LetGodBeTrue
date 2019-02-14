package com.tertioptus.rss;

import java.io.OutputStreamWriter;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Enclosure;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.io.WireFeedOutput;
import com.tertioptus.Engineer;

public final class SermonRaven implements Raven {
	
	public SermonRaven(ChannelInformationReceptionist channelInformationReceptionist, Engineer engineer){
		
		
	}

	/**
	 * <p assertion="">Prove that dispatch can be called.</p>
	 * <pre>
	 *  SermonRaven sermonRaven = new SermonRaven();
	 *  sermonRaven.dispatch();
	 * </pre>
	 */
	public void dispatch(String filename) {
        try {
        	/*
            String feedType = "atom_1.0";

            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType(feedType);

            feed.setTitle("Sample Feed (created with ROME)");
            feed.setLink("http://rome.dev.java.net");
            feed.setDescription("This feed has been created using ROME (Java syndication utilities");

            Writer writer = new FileWriter("test.rss");
            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed,writer);
            writer.close();*/

            Channel channel = new Channel("rss_2.0");
            channel.setTitle("Example Podcast Feed");
            channel.setDescription("Example podcast description.");
            channel.setLink("http://www.example.org");
            Item item = new Item( );
            item.setTitle("My First Podcast");
            Description description = new Description( );
            description.setType("text");
            description.setValue("My first attempt at a podcast.");
            item.setDescription(description);
            Enclosure enclosure = new Enclosure( );
            enclosure.setUrl("http://www.example.org/podcast/ep1.mp3");
            enclosure.setType("audio/mpeg");
            enclosure.setLength(4182295);
            item.getEnclosures( ).add(enclosure);
            channel.getItems( ).add(item);
            WireFeedOutput outputter = new WireFeedOutput( );
            outputter.output(channel, new OutputStreamWriter(System.out));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: "+ex.getMessage());
        }	
	}

}
