package com.tertioptus.rss;

import com.tertioptus.MapEngineer;

public class PropertiesChannelInformationReceptionist implements ChannelInformationReceptionist {
	
	MapEngineer<String, String> configPropertiesMapEngineer;

	public PropertiesChannelInformationReceptionist(MapEngineer<String,String> configPropertiesMapEngineer) {
		this.configPropertiesMapEngineer = configPropertiesMapEngineer;
	}

	public String[] document() throws Exception {
		String[] document = new String[5];
		
		document[0] = configPropertiesMapEngineer.value("language");
		document[1] = configPropertiesMapEngineer.value("title");
		document[2] = configPropertiesMapEngineer.value("description");
		document[3] = configPropertiesMapEngineer.value("image");
		document[4] = configPropertiesMapEngineer.value("host");
		
		return document;
	}
}
