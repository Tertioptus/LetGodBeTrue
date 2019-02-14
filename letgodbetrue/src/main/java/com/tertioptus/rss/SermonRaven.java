package com.tertioptus.rss;

import java.io.FileWriter;
import java.io.Writer;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.io.WireFeedOutput;

/**
 * Creates RSS file with given channel information.
 *
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 */
public final class SermonRaven implements Raven {
	
	private ChannelInformationReceptionist channelInformationReceptionist;
	private ChannelEngineer<String[]> channelEngineer;
	
	public SermonRaven(ChannelInformationReceptionist channelInformationReceptionist, ChannelEngineer<String[]> engineer){
		
		this.channelInformationReceptionist = channelInformationReceptionist;
		this.channelEngineer = engineer;
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
            */
            WireFeedOutput outputter = new WireFeedOutput( );
            Writer writer = new FileWriter("test.rss");
            outputter.output((Channel)channelEngineer.component(channelInformationReceptionist.document()), writer);
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: "+ex.getMessage());
        }	
	}

}
