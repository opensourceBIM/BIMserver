package org.bimserver.logging;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

public class CustomFileAppender extends FileAppender {

	public CustomFileAppender(File file) throws IOException {
		super(new PatternLayout("%d{HH:mm:ss} %-5p %-80m (%c.java:%L) %n"), file.getAbsolutePath());
	}
}
