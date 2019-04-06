package com.tertioptus.rss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class LookupCacheReadingEngineer implements LookupReadingEngineer {

	private Map<String, String> lookup = new HashMap<>();

	@Override
	public String value(String resource, String key) throws Exception {
		if (lookup.isEmpty() && new File(resource).exists()) {
			File file = new File(resource);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				String[] tokens = st.split(" ");
				lookup.put(tokens[0], tokens[1]);
			}
			br.close();
		}
		String value = lookup.get(key);
		return  value == null ? "" :  value;
	}

}
