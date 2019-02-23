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
/*			squirrel.sermons().forEach(
					s -> System.out.println(s[0] + " " + s[2] + s[4] + s[6] + " " + s[3] + " " + s[5] + " " + s[7]));
			;*/
			wireFeedOutputEngineer.output(filename, 
					channelInformationReceptionist.document(),
					squirrel.sermons());
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}
