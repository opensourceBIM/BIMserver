package org.bimserver.plugins.services;

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

import java.io.File;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bimserver.bimbots.BimBotsInput;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.plugins.SchemaName;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

public class BimBotClient implements AutoCloseable {
	private String baseAddress;
	private CloseableHttpClient httpClient;
	private String token;

	public static void main(String[] args) {
		try (BimBotClient bimBotCaller = new BimBotClient("http://localhost:8080/services", "a70abb752c5a04f5ccce7ea1b79b85c045c594c3d7fb23d6f28e8e8ad04f2750477ec5706013f2bc07be2b9555fd44df")) {
			BimBotsInput bimBotsInput = new BimBotsInput(SchemaName.IFC_STEP_2X3TC1, Files.toByteArray(new File("C:\\Git\\TestFiles\\TestData\\data\\export3.ifc")));
			BimBotsOutput bimBotsOutput = bimBotCaller.call("3866702", bimBotsInput);
			ObjectNode readValue = new ObjectMapper().readValue(bimBotsOutput.getData(), ObjectNode.class);
			System.out.println(readValue.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BimBotExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public BimBotClient(String baseAddress, String token) {
		this.baseAddress = baseAddress;
		this.token = token;
		httpClient = HttpClients.createDefault();
	}
	
	public BimBotsOutput call(String identifier, BimBotsInput input) throws BimBotExecutionException {
		HttpPost post = new HttpPost(baseAddress + "/" + identifier);
		post.setHeader("Input-Type", input.getSchemaName());
		post.setHeader("Token", token);
		post.setHeader("Accept-Flow", "SYNC");
		post.setEntity(new ByteArrayEntity(input.getData()));
		
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				Header outputType = httpResponse.getFirstHeader("Output-Type");
				if (outputType == null) {
					throw new BimBotExecutionException("No Output-Type given");
				}
				String outputSchema = outputType.getValue();
				BimBotsOutput bimBotsOutput = new BimBotsOutput(outputSchema, ByteStreams.toByteArray(httpResponse.getEntity().getContent()));
				return bimBotsOutput;
			} else {
				throw new BimBotExecutionException("Unexpected HTTP status code " + httpResponse.getStatusLine().toString());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}