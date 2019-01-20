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

        System.out.println(
        		Squirrel(
        			UrlReceptionist(
        				PropertiesMapEngineer()
        			)	
        		).html()
        );
    }
}
