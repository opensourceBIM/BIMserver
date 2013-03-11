package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.eclipse.jetty.websocket.WebSocket;

import com.google.gson.JsonObject;

public class StreamingSocket implements WebSocket.OnTextMessage, StreamingSocketInterface {

	private Connection connection;
	private Streamer streamer;

	public void setStreamer(Streamer streamer) {
		this.streamer = streamer;
	}

	@Override
	public void onClose(int arg0, String arg1) {
		streamer.onClose();
	}

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		streamer.onOpen();
	}

	@Override
	public void onMessage(String message) {
		streamer.onText(new StringReader(message));
	}

	public void send(JsonObject object) {
		try {
			connection.sendMessage(object.toString());
		} catch (IOException e) {
		}
	}
}