package org.bimserver.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.interfaces.NotificationInterfaceReflectorImpl;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.json.JsonReflector;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class TomcatStreamInbound extends StreamInbound implements EndPoint, StreamingSocketInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(TomcatStreamInbound.class);
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private NotificationInterfaceReflectorImpl reflectorImpl;
	private WsOutbound outbound;

	public TomcatStreamInbound(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
		JsonReflector jsonReflector = new JsonWebsocketReflector(bimServer.getServicesMap(), this);
		reflectorImpl = new NotificationInterfaceReflectorImpl(jsonReflector);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		this.outbound = outbound;
		try {
			JSONObject welcome = new JSONObject();
			welcome.put("endpointid", endpointid);
			send(welcome);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	public long getEndPointId() {
		return endpointid;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return reflectorImpl;
	}

	@Override
	public void cleanup() {
		bimServer.getNotificationsManager().unregisterEndpoint(uoid, this);
	}

	@Override
	public void send(JSONObject request) {
		CharBuffer charBuffer = CharBuffer.wrap(request.toString().toCharArray());
		try {
			outbound.writeTextMessage(charBuffer);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	protected void onTextData(Reader reader) throws IOException {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(reader, baos);
			JSONObject request = new JSONObject(new JSONTokener(new String(baos.toByteArray(), Charsets.UTF_8)));
			bimServer.getJsonHandler().execute(request, null, null);
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
}