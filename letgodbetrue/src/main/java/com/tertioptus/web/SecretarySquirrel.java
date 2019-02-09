package com.tertioptus.web;

import java.util.stream.Stream;

public final class SecretarySquirrel implements Squirrel {
	
	private Squirrel squirrel;
	
	public SecretarySquirrel(Squirrel squirrel) {
		this.squirrel = squirrel;
	}

	@Override
	public Stream<String[]> sermons() throws Exception {
		return squirrel.sermons().map(r->reMap(r)).sorted((o1,o2)->
		-o1[0].compareTo(o2[0])
		);
	}
	
	private String[] reMap(String[] record) {
		record[0] = standardDate(record[0]);
		return record;
	}
	private String standardDate(String dateMeridian) {
		String[] dMs = dateMeridian.split(" ");
		String[] date = dMs[0].split("/");
		return (Integer.parseInt(date[2])>70?"19":"20") + date[2] + String.format("%02d", Integer.parseInt(date[0])) + String.format("%02d", Integer.parseInt(date[1])) + (dMs[1].equals("AM")?"1":"0");
	}
	
	
}
