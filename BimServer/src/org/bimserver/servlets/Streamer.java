package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.GregorianCalendar;

import org.bimserver.BimServer;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.longaction.LongAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.longaction.LongStreamingDownloadAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.Writer;
import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.utils.GrowingByteBuffer;
import org.bimserver.webservices.InvalidTokenException;
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Streamer implements EndPoint {
	private static final int ONE_MB = 1024 * 1024;
	private static final Logger LOGGER = LoggerFactory.getLogger(Streamer.class);
	private long uoid;
	private long endpointid;
	private BimServer bimServer;
	private NotificationInterface notificationInterface;
	private RemoteServiceInterface remoteServiceInterface;
	private StreamingSocketInterface streamingSocketInterface;
	private String token;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public Streamer(StreamingSocketInterface streamingSocketInterface, BimServer bimServer) {
		this.streamingSocketInterface = streamingSocketInterface;
		this.bimServer = bimServer;
		notificationInterface = bimServer.getReflectorFactory().createReflector(NotificationInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
		remoteServiceInterface = bimServer.getReflectorFactory().createReflector(RemoteServiceInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
	}

	public void onOpen() {
		ObjectNode welcome = OBJECT_MAPPER.createObjectNode();
		welcome.put("welcome", new GregorianCalendar().getTimeInMillis());
		streamingSocketInterface.send(welcome);
	}

	public void onText(Reader reader) {
		try {
			ObjectNode request = OBJECT_MAPPER.readValue(reader, ObjectNode.class);
			if (request.has("hb")) {
				// Heartbeat, ignore
			} else if (request.has("action")) {
				if (request.get("action").asText().equals("download")) {
					final long topicId = request.get("topicId").asLong();
					bimServer.getExecutorService().execute(new Runnable() {
						public void run() {
							Writer writer = null;
							try {
								LongAction<?> longAction = bimServer.getLongActionManager().getLongAction(topicId);
								if (longAction instanceof LongStreamingDownloadAction) {
									LongStreamingDownloadAction longStreamingDownloadAction = (LongStreamingDownloadAction) longAction;
									writer = longStreamingDownloadAction.getMessagingStreamingSerializer();
								} else {
									LongDownloadOrCheckoutAction longDownloadAction = (LongDownloadOrCheckoutAction) longAction;
									// NPE happens here sometimes when using the viewer??
									if (longDownloadAction == null) {
										LOGGER.error("No long download action for " + topicId);
									} else {
										writer = longDownloadAction.getMessagingSerializer();
										return;
									}
								}
								boolean writeMessage = true;
								
								// TODO pool the buffers

								// TODO whenever a large object has been sent,
								// the large buffer stays in memory until
								// websocket closes...
								ReusableLittleEndianDataOutputStream byteArrayOutputStream = new ReusableLittleEndianDataOutputStream();
								GrowingByteBuffer growingByteBuffer = byteArrayOutputStream.getGrowingByteBuffer();
								ProgressReporter progressReporter = new ProgressReporter() {
									@Override
									public void update(long progress, long max) {
										longAction.updateProgress("test", (int) ((progress * 100) / max));
									}

									@Override
									public void setTitle(String title) {
									}
								};
								int messagesSent = 0;
								// streamingSocketInterface.enableBatching();
								int bytesInThisBuffer = 0;
								// long start = System.nanoTime();

								// for (int i=0; i<100; i++) {
								// byteArrayOutputStream.reset();
								// byteArrayOutputStream.writeLongUnchecked(topicId);
								// if (i == 99) {
								// growingByteBuffer.put((byte)6);
								// }
								// growingByteBuffer.put(new byte[10000000]);
								// ByteBuffer newBuffer =
								// ByteBuffer.allocate(growingByteBuffer.usedSize());
								// newBuffer.put(growingByteBuffer.array(), 0,
								// growingByteBuffer.usedSize());
								// streamingSocketInterface.send(newBuffer.array(),
								// 0, newBuffer.capacity());
								// bytes += newBuffer.capacity() + 8;
								// messagesSent++;
								// }

								byteArrayOutputStream.writeLongUnchecked(topicId);
								byteArrayOutputStream.writeLongUnchecked(0);
								do {
									writeMessage = writer.writeMessage(byteArrayOutputStream, progressReporter);
									messagesSent++;
									// TODO we can just keep track of time, and for example always flush when nothing was sent in a second. Need to keep in mind that there could 63 other threads writing...
									if (growingByteBuffer.usedSize() >= ONE_MB || !writeMessage) {
										ByteBuffer newBuffer = ByteBuffer.wrap(growingByteBuffer.array(), 0, growingByteBuffer.usedSize());
										streamingSocketInterface.sendBlocking(newBuffer);
										byteArrayOutputStream.reset();
										byteArrayOutputStream.writeLongUnchecked(topicId);
										byteArrayOutputStream.writeLongUnchecked(0);
									}
								} while (writeMessage);
								
								ByteBuffer endMessage = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
								endMessage.putLong(topicId);
								endMessage.putLong(1);
								endMessage.position(0);
								streamingSocketInterface.sendBlocking(endMessage);
								
								// streamingSocketInterface.flush();
								// long end = System.nanoTime();
								// LOGGER.info(messagesSent + " messages written
								// " + Formatters.bytesToString(bytes) + " in "
								// + ((end - start) / 1000000) + " ms");
							} catch (IOException e) {
								LOGGER.error("", e);
								// Probably closed/F5-ed browser
							} catch (SerializerException e) {
								LOGGER.error("", e);
							} finally {
								try {
									if (writer != null) {
										writer.close();
									}
								} catch (IOException e) {
									LOGGER.error("", e);
								}
							}
						}
					});
				}
			} else if (request.has("request")) {
				bimServer.getExecutorService().execute(new Runnable() {
					@Override
					public void run() {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						OutputStreamWriter outputStreamWriter = new OutputStreamWriter(baos);
						bimServer.getJsonHandler().execute(request, null, outputStreamWriter);
						try {
							outputStreamWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						streamingSocketInterface.sendAsText(baos.toByteArray());
					}
				});
			} else if (request.has("token")) {
				token = request.get("token").asText();
				try {
					ServiceMap serviceMap = bimServer.getServiceFactory().get(token, AccessMethod.JSON);
					uoid = serviceMap.getBimServerAuthInterface().getLoggedInUser().getOid();

					this.endpointid = bimServer.getEndPointManager().register(this);

					ObjectNode endpointMessage = OBJECT_MAPPER.createObjectNode();

					// Next 4 lines are redundant, but added to comply with
					// bimbots interface
					endpointMessage.put("type", "endpoint");
					ObjectNode payload = OBJECT_MAPPER.createObjectNode();
					payload.put("endpointid", endpointid);
					endpointMessage.set("payload", payload);

					endpointMessage.put("endpointid", endpointid);
					streamingSocketInterface.send(endpointMessage);
				} catch (InvalidTokenException e) {
					ObjectNode enpointMessage = OBJECT_MAPPER.createObjectNode();
					enpointMessage.put("error", "Invalid token");
					streamingSocketInterface.send(enpointMessage);
				} catch (UserException e) {
					LOGGER.error("", e);
				} catch (ServerException e) {
					LOGGER.error("", e);
				}
			}
		} catch (JsonParseException e1) {
			LOGGER.error("", e1);
		} catch (JsonMappingException e1) {
			LOGGER.error("", e1);
		} catch (IOException e1) {
			LOGGER.error("", e1);
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
		return "Streamer with endpoint " + endpointid;
	}

	public String getToken() {
		return token;
	}

	public StreamingSocketInterface getStreamingSocketInterface() {
		return streamingSocketInterface;
	}
}