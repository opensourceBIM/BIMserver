package org.bimserver;

public interface EmbeddedWebServerInterface {

	void shutdown();

	void start();

	void setResourceBase(String string);

}
