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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.GregorianCalendar;

import javax.activation.DataSource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullWriter;
import org.bimserver.BimServer;
import org.bimserver.cache.FileInputStreamDataSource;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.AligningOutputStream;
import org.bimserver.plugins.serializers.EmfSerializerDataSource;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
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
	private Bimsie1NotificationInterface notificationInterface;
	private Bimsie1RemoteServiceInterface remoteServiceInterface;
	private StreamingSocketInterface streamingSocketInterface;

	public Streamer(StreamingSocketInterface streamingSocketInterface, BimServer bimServer) {
		this.streamingSocketInterface = streamingSocketInterface;
		this.bimServer = bimServer;
		notificationInterface = bimServer.getReflectorFactory().createReflector(Bimsie1NotificationInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
		remoteServiceInterface = bimServer.getReflectorFactory().createReflector(Bimsie1RemoteServiceInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), streamingSocketInterface));
	}

	public void onOpen() {
		JsonObject welcome = new JsonObject();
		welcome.add("welcome", new JsonPrimitive(new GregorianCalendar().getTimeInMillis()));
		streamingSocketInterface.send(welcome);
	}
	
	public static class WebSocketifier extends OutputStream implements AligningOutputStream {
		private byte[] buffer = new byte[1024 * 1024 * 100];
		private int pos = 0;
		private StreamingSocketInterface streamingSocketInterface;
		
		public WebSocketifier(StreamingSocketInterface streamingSocketInterface) {
			this.streamingSocketInterface = streamingSocketInterface;
		}

		@Override
		public void write(int val) throws IOException {
			buffer[pos] = (byte) val;
			pos++;
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			System.arraycopy(b, off, buffer, pos, len);
			pos += len;
		}
		
		public void align4() {
			int skip = 4 - (pos % 4);
			if(skip != 0 && skip != 4) {
				pos += skip;
			}
		}
		
		@Override
		public void flush() throws IOException {
			streamingSocketInterface.send(buffer, 0, pos);
			pos = 0;
		}
	}
	
	public void onText(Reader reader) {
		JsonReader jsonreader = new JsonReader(reader);
		JsonParser parser = new JsonParser();
		JsonObject request = (JsonObject) parser.parse(jsonreader);
		if (request.has("hb")) {
			// Heartbeat, ignore
		} else if (request.has("action")) {
			if (request.get("action").getAsString().equals("download")) {
				String token = request.get("token").getAsString();
				try {
					ServiceMap serviceMap = bimServer.getServiceFactory().get(token, AccessMethod.INTERNAL);
					long downloadId = request.get("longActionId").getAsLong();
					SDownloadResult checkoutResult = serviceMap.getBimsie1ServiceInterface().getDownloadData(downloadId);
					DataSource dataSource = checkoutResult.getFile().getDataSource();
					OutputStream outputStream = new WebSocketifier(streamingSocketInterface);
					if (dataSource instanceof FileInputStreamDataSource) {
						InputStream inputStream = ((FileInputStreamDataSource) dataSource).getInputStream();
						IOUtils.copy(inputStream, outputStream);
						inputStream.close();
					} else {
						((EmfSerializerDataSource) dataSource).writeToOutputStream(outputStream);
					}
				} catch (UserException e) {
					e.printStackTrace();
				} catch (ServerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SerializerException e) {
					e.printStackTrace();
				}
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
		bimServer.getEndPointManager().unregister(this);
	}

	@Override
	public long getEndPointId() {
		return endpointid;
	}

	@Override
	public Bimsie1NotificationInterface getNotificationInterface() {
		return notificationInterface;
	}

	@Override
	public Bimsie1RemoteServiceInterface getRemoteServiceInterface() {
		return remoteServiceInterface;
	}

	@Override
	public long getUoid() {
		return uoid;
	}
}