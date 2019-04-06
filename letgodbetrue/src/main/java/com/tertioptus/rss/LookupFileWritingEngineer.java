package com.tertioptus.rss;

import java.io.FileWriter;

public class LookupFileWritingEngineer implements LookupWritingEngineer {

	@Override
	public void record(String resource, String key, String value) throws Exception {
		    FileWriter fw = new FileWriter(resource,true); //the true will append the new data
		    fw.write(key + " " + value + "\n");//appends the string to the file
		    fw.close();
	}

}
