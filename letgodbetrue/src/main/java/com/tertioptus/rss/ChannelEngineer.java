package com.tertioptus.rss;

public interface ChannelEngineer<T> {

	Object component(T payload);
}
