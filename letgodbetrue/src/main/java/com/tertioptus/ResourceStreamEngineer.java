package com.tertioptus;

public interface ResourceStreamEngineer<T> {

	void load(String resourceName, T container) throws Exception;
}
