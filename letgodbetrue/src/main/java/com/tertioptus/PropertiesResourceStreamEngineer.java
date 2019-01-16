package com.tertioptus;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesResourceStreamEngineer implements ResourceStreamEngineer<Properties> {

	private InputStream inpStream;

	public void load(String resourceName, Properties properties) throws Exception {
		try {
			inpStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
			properties.load(inpStream);
		} finally {
			inpStream.close();
		}
	};
}
