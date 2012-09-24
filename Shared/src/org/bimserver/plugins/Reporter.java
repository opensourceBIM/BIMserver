package org.bimserver.plugins;

public interface Reporter {
	void error(String error);
	void warning(String warning);
	void info(String info);
}