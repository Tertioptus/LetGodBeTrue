package com.tertioptus.rss;

import com.tertioptus.web.Squirrel;

/**
 * Creates RSS file with given channel information.
 *
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 */
public final class SermonRaven implements Raven {

	private ChannelInformationReceptionist channelInformationReceptionist;
	private WireFeedOutputEngineer wireFeedOutputEngineer;
	private Squirrel squirrel;

	public SermonRaven(Squirrel squirrel, ChannelInformationReceptionist channelInformationReceptionist,
			WireFeedOutputEngineer wireFeedOutputEngineer) {

		this.channelInformationReceptionist = channelInformationReceptionist;
		this.wireFeedOutputEngineer = wireFeedOutputEngineer;
		this.squirrel = squirrel;
	}

	/**
	 * <p assertion="">
	 * Prove that dispatch can be called.
	 * </p>
	 * 
	 * <pre>
	 * SermonRaven sermonRaven = new SermonRaven();
	 * sermonRaven.dispatch();
	 * </pre>
	 */
	public void dispatch(String filename) {
		try {

			/*
			 * Item item = new Item( ); item.setTitle("My First Podcast");
			 * Description description = new Description( );
			 * description.setType("text");
			 * description.setValue("My first attempt at a podcast.");
			 * item.setDescription(description); Enclosure enclosure = new
			 * Enclosure( );
			 * enclosure.setUrl("http://www.example.org/podcast/ep1.mp3");
			 * enclosure.setType("audio/mpeg"); enclosure.setLength(4182295);
			 * item.getEnclosures( ).add(enclosure); channel.getItems(
			 * ).add(item);
			 */
			squirrel.sermons().forEach(
					s -> System.out.println(s[0] + " " + s[2] + s[4] + s[6] + " " + s[3] + " " + s[5] + " " + s[7]));
			;
			wireFeedOutputEngineer.output(filename, 
					channelInformationReceptionist.document(),
					squirrel.sermons());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
