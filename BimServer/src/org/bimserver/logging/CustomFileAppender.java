package org.bimserver.logging;

import org.apache.log4j.FileAppender;

public class CustomFileAppender extends FileAppender {

	public static String location;
	
	public CustomFileAppender() {
		super();
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
