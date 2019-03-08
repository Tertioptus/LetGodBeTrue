package com.tertioptus;

import java.util.logging.LogManager;

/**
 * LetGodBeTrue.com podcast updater entry-point
 *
 */
public class Console extends Sol 
{
    public static void main( String[] args ) throws Exception
    {
    	init();
        		
    	(new LetGodBeTrueApplication()).run(args);
    }
    
    private static void init() {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new LogHandler());
    }
}
