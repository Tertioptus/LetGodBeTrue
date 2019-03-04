package com.tertioptus;

import java.util.logging.LogManager;

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.properties.PropertiesResourceStreamEngineer;
import com.tertioptus.rss.PropertiesChannelInformationReceptionist;
import com.tertioptus.rss.SermonRaven;
import com.tertioptus.web.SecretarySquirrel;
import com.tertioptus.web.WebContentSquirrel;
import com.tertioptus.web.url.ApacheUrlValidatorEngineer;
import com.tertioptus.web.url.PropertiesUrlReceptionist;
import com.tertioptus.web.url.QualifyingUrlReceptionist;

/**
 * LetGodBeTrue.com podcast updater entry-point
 *
 */
public class App extends Sol 
{
    public static void main( String[] args ) throws Exception
    {
    	init();
        		
        (new SermonRaven(
        		new SecretarySquirrel(
        				new WebContentSquirrel(
                   			new QualifyingUrlReceptionist(
                   					new ApacheUrlValidatorEngineer(), 
                   					new PropertiesUrlReceptionist(
                   							theConfigPropertiesMapEngineer()
                   					)
                   			)
                   		)
                ),
        		new PropertiesChannelInformationReceptionist(
        				theConfigPropertiesMapEngineer()
        		)
       	)).dispatch(theConfigPropertiesMapEngineer().value("filename"));
    }
    
    private static void init() {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new LogHandler());
    }

	public static PropertiesMapEngineer theConfigPropertiesMapEngineer() {
		return new PropertiesMapEngineer("config.properties", new PropertiesResourceStreamEngineer());
	}
}
