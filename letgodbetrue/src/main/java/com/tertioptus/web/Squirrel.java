package com.tertioptus.web;

import java.util.stream.Stream;

public interface Squirrel {

	/**
	 * @return A string array that adheres to the "Item Document Schema".
	 * 
	 * <p>
	 * The values are indexed as stated:
	 * <ol start="0">
	 * <li>Date</li>
	 * <li>Title</li>
	 * <li>Audio title #1</li>
	 * <li>Audio href #1</li>
	 * <li>Audio title #2</li>
	 * <li>Audio href #2</li>
	 * <li>Audio title #3</li>
	 * <li>Audio href #3</li>
	 * <li>Description</li>
	 * </ol>
	 * </p>
	 * @throws Exception due to probable network call
	 */
	public Stream<String[]> sermons() throws Exception;
}
