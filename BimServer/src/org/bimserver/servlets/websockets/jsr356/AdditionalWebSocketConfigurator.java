package org.bimserver.servlets.websockets.jsr356;

import javax.websocket.Session;

public interface AdditionalWebSocketConfigurator {

	void configure(Session websocketSession);
}
