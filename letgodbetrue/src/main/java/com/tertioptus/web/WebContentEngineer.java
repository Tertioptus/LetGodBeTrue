package com.tertioptus.web;

public interface WebContentEngineer<T> {

	public void loadById(String url, String id, T container) throws Exception;
}
