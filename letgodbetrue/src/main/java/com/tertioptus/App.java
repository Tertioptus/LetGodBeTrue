package com.tertioptus;

import static com.tertioptus.Default.PropertiesMapEngineer;
import static com.tertioptus.Default.Squirrel;
import static com.tertioptus.Default.UrlReceptionist;

import java.util.logging.LogManager;

/**
 * LetGodBeTrue.com podcast updater entry-point
 *
 */
public class App extends Sol 
{
    public static void main( String[] args ) throws Exception
    {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new LogHandler());

        		Squirrel(
        			UrlReceptionist(
        				PropertiesMapEngineer("config.properties")
        			)	
        		).sermons().forEach(s -> System.out.println(s[0] + " " + s[6] + " " + s[7]));
    }
}
