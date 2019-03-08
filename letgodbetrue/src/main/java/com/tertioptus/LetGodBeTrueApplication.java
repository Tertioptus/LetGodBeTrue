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

public class LetGodBeTrueApplication {
	
	public LetGodBeTrueApplication() {
		this(new SermonRaven(
        		new SecretarySquirrel(
        				new WebContentSquirrel(
                   			new QualifyingUrlReceptionist(
                   					new ApacheUrlValidatorEngineer(), 
                   					new PropertiesUrlReceptionist(
                   							new PropertiesMapEngineer("config.properties", new PropertiesResourceStreamEngineer())
                   					)
                   			)
                   		)
                ),
        		new PropertiesChannelInformationReceptionist(
        				new PropertiesMapEngineer("config.properties", new PropertiesResourceStreamEngineer())
        		)
       	));
	}

	public LetGodBeTrueApplication(Raven raven) {
		this.raven = raven;
	}
	
	private final Raven raven;

	public void run(String[] args) throws Exception{
		raven.dispatch(new PropertiesMapEngineer("config.properties", new PropertiesResourceStreamEngineer()).value("filename"));
	}
}
