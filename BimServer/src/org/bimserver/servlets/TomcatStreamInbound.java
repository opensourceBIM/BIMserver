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
import org.apache.commons.io.output.NullWriter;
import org.bimserver.BimServer;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.json.JsonReflector;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;

public class TomcatStreamInbound extends StreamInbound implements EndPoint, StreamingSocketInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(TomcatStreamInbound.class);
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private NotificationInterface notificationInterface;
	private WsOutbound outbound;
	private RemoteServiceInterface remoteServiceInterface;

	public TomcatStreamInbound(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
		JsonReflector jsonReflector = new JsonWebsocketReflector(bimServer.getServicesMap(), this);
		notificationInterface = bimServer.getReflectorFactory().createReflector(NotificationInterface.class, jsonReflector);
		remoteServiceInterface = bimServer.getReflectorFactory().createReflector(RemoteServiceInterface.class, jsonReflector);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		this.outbound = outbound;
		JsonObject welcome = new JsonObject();
		welcome.add("endpointid", new JsonPrimitive(endpointid));
		send(welcome);
	}
	
	@Override
	public long getEndPointId() {
		return endpointid;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return notificationInterface;
	}

	@Override
	public void cleanup() {
		bimServer.getEndPointManager().unregister(endpointid);
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
		try {
			JsonReader jsonreader = new JsonReader(reader);
			JsonParser parser = new JsonParser();
			JsonObject request = (JsonObject) parser.parse(jsonreader);
			bimServer.getJsonHandler().execute(request, null, new NullWriter());
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	protected void onClose(int status) {
		bimServer.getEndPointManager().unregister(this);
		super.onClose(status);
	}
	
	@Override
	protected void onBinaryData(InputStream arg0) throws IOException {
	}
	
	@Override
	public long getUoid() {
		return uoid;
	}

	@Override
	public RemoteServiceInterface getRemoteServiceInterface() {
		return remoteServiceInterface;
	}
}