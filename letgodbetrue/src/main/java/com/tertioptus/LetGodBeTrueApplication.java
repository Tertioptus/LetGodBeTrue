package com.tertioptus;

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.properties.PropertiesResourceStreamEngineer;
import com.tertioptus.rss.PropertiesChannelInformationReceptionist;
import com.tertioptus.rss.Raven;
import com.tertioptus.rss.SermonRaven;
import com.tertioptus.web.SecretarySquirrel;
import com.tertioptus.web.Squirrel;
import com.tertioptus.web.WebContentSquirrel;
import com.tertioptus.web.url.ApacheUrlValidatorEngineer;
import com.tertioptus.web.url.PropertiesUrlReceptionist;
import com.tertioptus.web.url.QualifyingUrlReceptionist;

public class LetGodBeTrueApplication implements Application {

	private final Raven raven;
	private final MapEngineer<String, String> propertiesMapEngineer;
	private final static PropertiesMapEngineer thePropertiesMapEngineer = new PropertiesMapEngineer("config.properties",
			new PropertiesResourceStreamEngineer());

	public LetGodBeTrueApplication() {
		this(	
				new SermonRaven(scrapeySquirrel(), new PropertiesChannelInformationReceptionist(thePropertiesMapEngineer)),
				thePropertiesMapEngineer
			);
	}

	public LetGodBeTrueApplication(Raven raven, MapEngineer<String, String> propertiesMapEngineer) {
		this.raven = raven;
		this.propertiesMapEngineer = propertiesMapEngineer;
	}

	public void run(String[] args) throws Exception {
		raven.dispatch(propertiesMapEngineer.value("filename"));
	}

	private static Squirrel scrapeySquirrel() {
		return new SecretarySquirrel(new WebContentSquirrel(new QualifyingUrlReceptionist(
				new ApacheUrlValidatorEngineer(), new PropertiesUrlReceptionist(thePropertiesMapEngineer))));
	}
}
