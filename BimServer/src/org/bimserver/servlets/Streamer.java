package org.bimserver.servlets;

import java.io.IOException;
import java.io.Reader;
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

import com.google.common.io.LittleEndianDataOutputStream;
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
				final long topicId = request.get("topicId").getAsLong();
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
							
							// We use async websockets, but don't want to fill the websocket buffer with gigabytes of data that's not processed yet on the client
							// We also don't want to waste any time waiting for the messages to be delivered
							// This future acts as a 1-message buffer, so that we can fill the next buffer while sending the websocket message
							Future<Void> future = null;

							// TODO reuse buffer							
							
							do {
								ReusableByteArrayOutputStream byteArrayOutputStream = new ReusableByteArrayOutputStream();
								LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(byteArrayOutputStream);
								dataOutputStream.writeLong(topicId);
								writeMessage = writer.writeMessage(dataOutputStream, null);
								
								if (future != null) {
									future.get();
								}
								
								if (byteArrayOutputStream.usedSize() > 4) {
									bytes += byteArrayOutputStream.usedSize();
									future = streamingSocketInterface.send(byteArrayOutputStream.getByteArray(), 0, byteArrayOutputStream.usedSize());
									counter++;
								}
							} while (writeMessage);
							long end = System.nanoTime();
							LOGGER.info(counter + " messages written " + Formatters.bytesToString(bytes) + " in " + ((end - start) / 1000000) + " ms");
						} catch (IOException e) {
							// Probably closed/F5-ed browser
						} catch (SerializerException | InterruptedException | ExecutionException e) {
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
		return "Streamer with endpoint " + endpointid;
	}
}