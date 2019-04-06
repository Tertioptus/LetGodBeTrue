package com.tertioptus.rss;

public interface LookupWritingEngineer {

	void record(String resource, String key, String value) throws Exception;
}
