package com.tertioptus;

import static com.tertioptus.Default.*;

/**
 * LetGodBeTrue.com podcast updater entry-point
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

        System.out.println(
        		Squirrel(
        			UrlReceptionist(
        				PropertiesMapEngineer()
        			)	
        		).html());
    }
}
