package com.tertioptus.web;

import java.util.stream.Stream;

public interface WebContentEngineer<T> {

	public Stream<T> stream(String url, String id) throws Exception;
}
