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
import java.io.InputStream;
import java.io.Reader;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WsOutbound;

import com.google.gson.JsonObject;

public class TomcatStreamInbound extends StreamInbound implements StreamingSocketInterface {
	private WsOutbound outbound;
	private Streamer streamer;

	public void setStreamer(Streamer streamer) {
		this.streamer = streamer;
	}
	
	@Override
	protected void onOpen(WsOutbound outbound) {
		this.outbound = outbound;
		streamer.onOpen();
	}
	
	@Override
	public void send(JsonObject request) {
		String toString = request.toString();
		CharBuffer charBuffer = CharBuffer.wrap(toString.toCharArray());
		try {
			outbound.writeTextMessage(charBuffer);
			outbound.flush();
		} catch (IOException e) {
		}
	}
	
	@Override
	protected void onTextData(Reader reader) throws IOException {
		streamer.onText(reader);
	}
	
	@Override
	protected void onClose(int status) {
		streamer.onClose();
		super.onClose(status);
	}
	
	@Override
	protected void onBinaryData(InputStream arg0) throws IOException {
	}
}