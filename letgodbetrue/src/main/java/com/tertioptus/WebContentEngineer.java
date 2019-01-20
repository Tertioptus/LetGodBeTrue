package com.tertioptus;

public interface WebContentEngineer<T> {

	public void loadById(String url, String id, T container) throws Exception;
}
