package org.bimserver.logging;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.FileAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFileAppender extends FileAppender {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFileAppender.class);
	private static String location;
	private static Set<CustomFileAppender> instances = new HashSet<CustomFileAppender>();
	
	public CustomFileAppender() {
		super();
		instances.add(this);
	}
	
	public static void setLocation(String location) {
		CustomFileAppender.location = location;
		for (CustomFileAppender customFileAppender : instances) {
			LOGGER.info("Setting log location: " + location);
			customFileAppender.setFile(location);
			customFileAppender.activateOptions();
		}
	}
	
	@Override
	public void setFile(String file) {
		// Overriding the file location
		if (location != null) {
			super.setFile(location);
		} else {
			super.setFile(file);
		}
	}
}
