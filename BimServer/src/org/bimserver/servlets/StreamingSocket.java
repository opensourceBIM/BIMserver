package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.api.WebSocketException;

import com.google.gson.JsonObject;

public class StreamingSocket extends WebSocketAdapter implements StreamingSocketInterface {

	private Session session;
	private Streamer streamer;

	public void setStreamer(Streamer streamer) {
		this.streamer = streamer;
	}

	@Override
	public void onWebSocketBinary(byte[] payload, int offset, int len) {
	}
	
	@Override
	public void onWebSocketClose(int arg0, String arg1) {
		streamer.onClose();
	}

	@Override
	public void onWebSocketText(String message) {
		streamer.onText(new StringReader(message));
	}
	
	@Override
	public void onWebSocketConnect(Session session) {
		session.setIdleTimeout(1000 * 60 * 60); // 1 hour
		this.session = session;
		streamer.onOpen();
	}
	
	public void send(JsonObject object) {
		try {
			session.getRemote().sendString(object.toString());
		} catch (IOException e) {
		} catch (WebSocketException e) {
		}
	}
}