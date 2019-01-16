package com.tertioptus;

import java.util.Properties;

public final class PropertiesMapEngineer implements MapEngineer<String, String>{
	
	private String propertiesFileName;
	private Properties properties;
	private ResourceStreamEngineer<Properties> resourceStreamEngineer;

	public PropertiesMapEngineer(String fileName, ResourceStreamEngineer<Properties> resourceStreamEngineer) {
		this.propertiesFileName = fileName;
		this.properties = new Properties();
		this.resourceStreamEngineer = resourceStreamEngineer;
	}

	@Override
	public String value(String key) throws Exception {
		resourceStreamEngineer.load(propertiesFileName, properties);
		return properties.getProperty(key);
	}
}
