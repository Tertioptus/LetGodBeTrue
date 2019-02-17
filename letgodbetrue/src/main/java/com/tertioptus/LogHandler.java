package com.tertioptus;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LogHandler extends Handler {

	@Override
	public void publish(LogRecord record) {
	      StringBuilder sb = new StringBuilder();
	      sb
	        .append(record.getSourceClassName())
	        .append(":  ")
	        .append(record.getMessage());
	      System.out.println(sb.toString());
	}

	@Override
	public void flush() {
		// TODO release 1

	}

	@Override
	public void close() throws SecurityException {
		// TODO release 1

	}

}
