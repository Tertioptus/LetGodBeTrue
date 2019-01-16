package com.tertioptus;

public interface MapEngineer<T,K> {

	K value(T key) throws Exception;
}
