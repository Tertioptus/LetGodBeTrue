package com.tertioptus;

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.properties.PropertiesResourceStreamEngineer;
import com.tertioptus.rss.PropertiesChannelInformationReceptionist;
import com.tertioptus.rss.Raven;
import com.tertioptus.rss.SermonRaven;
import com.tertioptus.web.SecretarySquirrel;
import com.tertioptus.web.WebContentSquirrel;
import com.tertioptus.web.url.ApacheUrlValidatorEngineer;
import com.tertioptus.web.url.PropertiesUrlReceptionist;
import com.tertioptus.web.url.QualifyingUrlReceptionist;

public class LetGodBeTrueApplication implements Application {
	
	private static final PropertiesMapEngineer thePropertiesMapEngineer  = 
			new PropertiesMapEngineer("config.properties", new PropertiesResourceStreamEngineer());
	
	public LetGodBeTrueApplication() {
		this(new SermonRaven(
        		new SecretarySquirrel(
        				new WebContentSquirrel(
                   			new QualifyingUrlReceptionist(
                   					new ApacheUrlValidatorEngineer(), 
                   					new PropertiesUrlReceptionist(
                   						thePropertiesMapEngineer	
                   					)
                   			)
                   		)
                ),
        		new PropertiesChannelInformationReceptionist(thePropertiesMapEngineer)
       	)
		,thePropertiesMapEngineer);
	}

	public LetGodBeTrueApplication(Raven raven, MapEngineer<String,String> propertiesMapEngineer) {
		this.raven = raven;
		this.propertiesMapEngineer = propertiesMapEngineer;
	}
	
	private final Raven raven;
	private final MapEngineer<String, String> propertiesMapEngineer;

	public void run(String[] args) throws Exception{
		raven.dispatch(propertiesMapEngineer.value("filename"));
	}
}
