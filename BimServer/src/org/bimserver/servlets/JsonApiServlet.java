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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.models.store.ServerState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class JsonApiServlet extends SubServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonApiServlet.class);

	public JsonApiServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getHeader("Origin") != null && (getBimServer().getServerInfo().getServerState() != ServerState.MIGRATION_REQUIRED && !getBimServer().getServerSettingsCache().isHostAllowed(request.getHeader("Origin")))) {
			response.setStatus(403);
			return;
		}
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			return;
		}
		response.setCharacterEncoding("UTF-8");
		try {
			ServletInputStream inputStream = request.getInputStream();
			byte[] bytes = IOUtils.toByteArray(inputStream); // Not streaming here, because we want to be able to show the request-data when it's not valid
			JsonReader jsonReader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
			JsonParser parser = new JsonParser();
			JsonElement parse = parser.parse(jsonReader);
			if (parse instanceof JsonObject) {
				JsonObject jsonRequest = (JsonObject) parse;
				response.setHeader("Content-Type", "application/json");
				getBimServer().getJsonHandler().execute(jsonRequest, request, response.getWriter());
			} else {
				LOGGER.error("Invalid JSON request: " + new String(bytes, Charsets.UTF_8));
				response.setStatus(500);
			}
		} catch (IOException e) {
			LOGGER.error("", e);
			response.setStatus(500);
		}
	}
}