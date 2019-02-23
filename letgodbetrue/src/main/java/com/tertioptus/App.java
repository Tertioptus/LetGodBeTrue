package com.tertioptus;

import static com.tertioptus.Default.PropertiesMapEngineer;
import static com.tertioptus.Default.Squirrel;
import static com.tertioptus.Default.UrlReceptionist;

import java.util.logging.LogManager;

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.rss.AChannelEngineer;
import com.tertioptus.rss.AWireFeedOutputEngineer;
import com.tertioptus.rss.AnEnclosureEngineer;
import com.tertioptus.rss.AnItemEngineer;
import com.tertioptus.rss.AnItemListEngineer;
import com.tertioptus.rss.PropertiesChannelInformationReceptionist;
import com.tertioptus.rss.SermonRaven;

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
                Squirrel(
                   	UrlReceptionist(
                   		theConfigPropertiesMapEngineer()
                   	)	
                ),
        		new PropertiesChannelInformationReceptionist(theConfigPropertiesMapEngineer()),
        		new AWireFeedOutputEngineer(
        				new AChannelEngineer(
        						new AnItemListEngineer(
        								new AnItemEngineer(
        										new AnEnclosureEngineer()
        								)
        						)
        				)
        		)
       	)).dispatch(theConfigPropertiesMapEngineer().value("filename"));
    }
    
    private static void init() {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new LogHandler());
    }

	public static PropertiesMapEngineer theConfigPropertiesMapEngineer() {
		return PropertiesMapEngineer("config.properties");
	}
}
