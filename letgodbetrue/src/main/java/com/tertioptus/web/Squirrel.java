package com.tertioptus.web;

import java.util.stream.Stream;

public interface Squirrel {

	/**
	 * @return String[]
	 * <ol>
	 * <li>Title</li>
	 * <li>Audio title #1</li>
	 * <li>Audio href #1</li>
	 * <li>Audio title #2</li>
	 * <li>Audio href #2</li>
	 * </ol>
	 * 
	 * @throws Exception due to probable network call
	 */
	public Stream<String[]> sermons() throws Exception;
}
