package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.output.NullWriter;
import org.bimserver.BimServer;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.longaction.LongAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.longaction.LongStreamingDownloadAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.Writer;
import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.utils.Formatters;
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;

public class Streamer implements EndPoint {
	private static final Logger LOGGER = LoggerFactory.getLogger(Streamer.class);
	private long uoid;
	private long endpointid;
	private BimServer bimServer;
	private NotificationInterface notificationInterface;
	private RemoteServiceInterface remoteServiceInterface;
	private StreamingSocketInterface streamingSocketInterface;
	private static final int BUFFER_SIZE = 4096; // -1 means just send every message on it's own

	public Streamer(StreamingSocketInterface streamingSocketInterface, BimServer bimServer) {
		this.streamingSocketInterface = streamingSocketInterface;
		this.bimServer = bimServer;
		notificationInterface = bimServer.getReflectorFactory().createReflector(NotificationInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
		remoteServiceInterface = bimServer.getReflectorFactory().createReflector(RemoteServiceInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
	}

	public void onOpen() {
		JsonObject welcome = new JsonObject();
		welcome.add("welcome", new JsonPrimitive(new GregorianCalendar().getTimeInMillis()));
		streamingSocketInterface.send(welcome);
	}
	
	public void onText(Reader reader) {
		JsonReader jsonreader = new JsonReader(reader);
		JsonParser parser = new JsonParser();
		JsonObject request = (JsonObject) parser.parse(jsonreader);
		if (request.has("hb")) {
			// Heartbeat, ignore
		} else if (request.has("action")) {
			if (request.get("action").getAsString().equals("download")) {
				final int topicId = request.get("topicId").getAsInt();
				Thread thread = new Thread(){
					@Override
					public void run() {
						try {
							LongAction<?> longAction = bimServer.getLongActionManager().getLongAction(topicId);
							Writer writer = null;
							if (longAction instanceof LongStreamingDownloadAction) {
								LongStreamingDownloadAction longStreamingDownloadAction = (LongStreamingDownloadAction)longAction;
								writer = longStreamingDownloadAction.getMessagingStreamingSerializer();
							} else {
								
								LongDownloadOrCheckoutAction longDownloadAction = (LongDownloadOrCheckoutAction) longAction;
								writer = longDownloadAction.getMessagingSerializer();
							}
							boolean writeMessage = true;
							int counter = 0;
							long bytes = 0;
							long start = System.nanoTime();
							long totalQT = 0;
							
							// We use async websockets, but don't want to fill the websocket buffer with gigabytes of data that's not processed yet on the client
							// We also don't want to waste any time waiting for the messages to be delivered
							// This future acts as a 1-message buffer, so that we can fill the next buffer while sending the websocket message
							Future<Void> future = null;
							
							do {
								ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
								DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
								dataOutputStream.writeInt(topicId);
								dataOutputStream.writeInt(0); // fake nr messages, to be replaced later
								long s = System.nanoTime();
								writeMessage = writer.writeMessage(byteArrayOutputStream, null);
								int messages = 1;
								while (byteArrayOutputStream.size() < BUFFER_SIZE && writeMessage) {
									messages++;
									writeMessage = writer.writeMessage(byteArrayOutputStream, null);
								}
								long e = System.nanoTime();
								totalQT += (e - s);
								byte[] byteArray = byteArrayOutputStream.toByteArray();
								ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
								byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
								byteBuffer.putInt(4, messages);
								
								if (future != null) {
									future.get();
								}
								
								if (byteArrayOutputStream.size() > 8) {
									bytes += byteArray.length;
									future = streamingSocketInterface.send(byteArray, 0, byteArray.length);
									counter++;
								}
							} while (writeMessage);
							long end = System.nanoTime();
							LOGGER.info("total qt: " + (totalQT / 1000000) + " ms");
							LOGGER.info(counter + " messages written " + Formatters.bytesToString(bytes) + " in " + ((end - start) / 1000000) + " ms");
						} catch (IOException | SerializerException | InterruptedException | ExecutionException e) {
							LOGGER.error("", e);
						}
					}
				};
				thread.setName("Streamer " + topicId);
				thread.start();
			}
		} else if (request.has("token")) {
			String token = request.get("token").getAsString();
			try {
				ServiceMap serviceMap = bimServer.getServiceFactory().get(token, AccessMethod.JSON);
				uoid = serviceMap.getBimServerAuthInterface().getLoggedInUser().getOid();

				this.endpointid = bimServer.getEndPointManager().register(this);
				
				JsonObject enpointMessage = new JsonObject();
				enpointMessage.add("endpointid", new JsonPrimitive(endpointid));
				streamingSocketInterface.send(enpointMessage);
			} catch (UserException e) {
				LOGGER.error("", e);
			} catch (ServerException e) {
				LOGGER.error("", e);
			}
		} else {
			bimServer.getJsonHandler().execute(request, null, new NullWriter());
		}
	}

	@Override
	public void cleanup() {
		bimServer.getEndPointManager().unregister(endpointid);
	}

	public void onClose() {
		LOGGER.debug("onClose, unregistering endpoint " + this.getEndPointId());
		bimServer.getEndPointManager().unregister(this);
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
	public RemoteServiceInterface getRemoteServiceInterface() {
		return remoteServiceInterface;
	}

	@Override
	public long getUoid() {
		return uoid;
	}
	
	@Override
	public String toString() {
		return "" + endpointid;
	}
}