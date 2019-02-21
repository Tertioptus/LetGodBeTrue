package com.tertioptus.rss;

import java.io.FileWriter;
import java.io.Writer;
import java.util.stream.Stream;

import com.rometools.rome.io.WireFeedOutput;

/**
 * TODO PU-32 describe responsibility
 *
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 */
public final class AWireFeedOutputEngineer implements WireFeedOutputEngineer {
	
	private final WireFeedOutput outputter = new WireFeedOutput();
	private final ChannelEngineer channelEngineer;
	
	public AWireFeedOutputEngineer(ChannelEngineer channelEngineer) {
		this.channelEngineer = channelEngineer;
	}

	@Override
	public void output(String filename, String[] channelDocument, Stream<String[]> items) throws Exception {
		Writer writer = new FileWriter(filename);
		outputter.output(channelEngineer.component(channelDocument), writer);
		writer.close();
	}
}
