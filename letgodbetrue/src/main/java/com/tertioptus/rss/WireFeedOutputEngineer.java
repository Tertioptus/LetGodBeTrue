package com.tertioptus.rss;

import java.util.stream.Stream;

/**
 * Responsible for operating an instance of ROME's WireFeedOutput component.
 * @author Benjamin F. Paige III
 * @since Feb 16, 2019
 * @see com.rometools.rome.io.WireFeedOutput
 */
interface WireFeedOutputEngineer {

	/**
	 * Will attempt to generate RSS file at the specified target.
	 * 
	 * @param channelDocument
	 * <ol>
	 * 	<li>language</li>
	 * 	<li>title</li>
	 * 	<li>description</li>
	 * 	<li>image</li>
	 * 	<li>host</li>
	 * </ol>
	 * @param items
	 * <ol>
	 * <li>Title</li>
	 * <li>Audio title #1</li>
	 * <li>Audio href #1</li>
	 * <li>Audio title #2</li>
	 * <li>Audio href #2</li>
	 * </ol>
	 * @throws Exception Handles exceptions due to the anticipation of external resource operation failure
	 */
	void output(String target, String[] channelDocument, Stream<String[]> items) throws Exception;
}
