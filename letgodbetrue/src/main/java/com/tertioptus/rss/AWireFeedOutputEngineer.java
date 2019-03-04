package com.tertioptus.rss;

import java.io.FileWriter;
import java.io.Writer;
import java.util.stream.Stream;

import com.rometools.rome.io.WireFeedOutput;

/**
 * Handles a Rome wire feed output object
 *
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 */
final class AWireFeedOutputEngineer implements WireFeedOutputEngineer {
	
	private final WireFeedOutput outputter = new WireFeedOutput();
	private final ChannelEngineer channelEngineer;
	
	AWireFeedOutputEngineer(ChannelEngineer channelEngineer) {
		this.channelEngineer = channelEngineer;
	}

	@Override
	public void output(String filename, String[] channelDocument, Stream<String[]> items) throws Exception {
		Writer writer = new FileWriter(filename);
		outputter.output(channelEngineer.component(channelDocument, items), writer);
		writer.close();
	}
}
