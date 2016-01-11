//package org.bimserver.logging;
//
//import java.io.IOException;
//import java.nio.file.Path;
//
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.PatternLayout;
//
//public class CustomFileAppender extends FileAppender {
//
//	public CustomFileAppender(Path file) throws IOException {
//		super(new PatternLayout("%d{HH:mm:ss} %-5p %-80m (%c.java:%L) %n"), file.toString());
//	}
//}