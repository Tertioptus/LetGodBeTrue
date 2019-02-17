package com.tertioptus;

import static com.tertioptus.Default.PropertiesMapEngineer;
import static com.tertioptus.Default.Squirrel;
import static com.tertioptus.Default.UrlReceptionist;

import java.net.URL;
import java.net.URLConnection;
import java.util.logging.LogManager;

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.rss.AChannelEngineer;
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
    	
        Squirrel(
        	UrlReceptionist(
        		theConfigPropertiesMapEngineer()
        	)	
        ).sermons().forEach(s -> System.out.println(s[0] + " " + s[2]+s[4]+s[6] + " " + s[3] + " " + s[5] + " " + s[7]));
        		
        (new SermonRaven(
        			new PropertiesChannelInformationReceptionist(theConfigPropertiesMapEngineer()),
        			new AChannelEngineer()
       	)).dispatch(theConfigPropertiesMapEngineer().value("filename"));
        
        URL url;
        URLConnection conn;
        int size;

        try {
          url = new URL("http://letgodbetrue.com/media/audio/sermons/2006-04-30/2006-04-30-am-sermon.mp3");
          conn = url.openConnection();
          size = conn.getContentLength();
          if(size < 0)
             System.out.println("Could not determine file size.");
          else
            System.out.println("Size: " + size);
          conn.getInputStream().close();
          } 
        catch(Exception e) {
          e.printStackTrace();
          }
    }
    
    private static void init() {
        LogManager.getLogManager().reset();
        LOGGER.addHandler(new LogHandler());
    }

	public static PropertiesMapEngineer theConfigPropertiesMapEngineer() {
		return PropertiesMapEngineer("config.properties");
	}
}
