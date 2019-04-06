package com.tertioptus.rss;

import com.tertioptus.Sol;
import com.tertioptus.web.Squirrel;

/**
 * Creates RSS file with given channel information.
 *
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 */
public final class SermonRaven extends Sol implements Raven {

	/**
	 * 
	 * @param squirrel
	 * @param channelInformationReceptionist
	 */
	public SermonRaven(Squirrel squirrel, ChannelInformationReceptionist channelInformationReceptionist) {
		this(squirrel, channelInformationReceptionist,
				new AWireFeedOutputEngineer(new AChannelEngineer(
						new AnItemListEngineer(new AnItemEngineer(new SmartEnclosureEngineer(new AnEnclosureEngineer(),
								new LookupCacheReadingEngineer(), new LookupFileWritingEngineer()))))));

	}

	/**
	 * 
	 * @param squirrel
	 * @param channelInformationReceptionist
	 * @param wireFeedOutputEngineer
	 */
	public SermonRaven(Squirrel squirrel, ChannelInformationReceptionist channelInformationReceptionist,
			WireFeedOutputEngineer wireFeedOutputEngineer) {

		this.channelInformationReceptionist = channelInformationReceptionist;
		this.wireFeedOutputEngineer = wireFeedOutputEngineer;
		this.squirrel = squirrel;
	}

	private ChannelInformationReceptionist channelInformationReceptionist;
	private WireFeedOutputEngineer wireFeedOutputEngineer;
	private Squirrel squirrel;

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
			wireFeedOutputEngineer.output(filename, channelInformationReceptionist.document(), squirrel.sermons());

			LOGGER.info("File generation complete.");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}
