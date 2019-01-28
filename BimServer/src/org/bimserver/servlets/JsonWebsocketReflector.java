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

import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.json.JsonReflector;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonWebsocketReflector extends JsonReflector {

	private StreamingSocketInterface streamingSocket;
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingSocketInterface.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public JsonWebsocketReflector(SServicesMap servicesMap, StreamingSocketInterface streamingSocket) {
		super(servicesMap);
		this.streamingSocket = streamingSocket;
	}

	@Override
	public JsonNode call(ObjectNode request) {
		LoggerFactory.getLogger(JsonWebsocketReflector.class).debug("WS: " + request);
		streamingSocket.send(request);
		return OBJECT_MAPPER.createObjectNode();
	}

	@Override
	protected boolean isOneWay() {
		return true;
	}
}