package org.bimserver.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StreamingModel {

	private BimServerClient bimServerClient;
	private long roid;

	public StreamingModel(BimServerClient bimServerClient, PackageMetaData packageMetaData, long roid) {
		this.bimServerClient = bimServerClient;
		this.roid = roid;
		
		Query query = new Query("test", packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.setIncludeAllFields(true);

		ObjectNode queryNode = new JsonQueryObjectModelConverter(query.getPackageMetaData()).toJson(query);
		try {
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), queryNode.toString(), bimServerClient.getJsonSerializerOid(), false);
			bimServerClient.waitForDonePreparing(topicId);
			processDownload(topicId);
			bimServerClient.getServiceInterface().cleanupLongAction(topicId);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void processDownload(Long topicId) throws UserException, ServerException, PublicInterfaceNotFoundException, IfcModelInterfaceException, IOException {
		InputStream inputStream = bimServerClient.getDownloadData(topicId);
		if (inputStream == null) {
			throw new IfcModelInterfaceException("No InputStream to read from for topicId " + topicId);
		}
		InputStream downloadData = new org.bimserver.utils.CountingInputStream(inputStream) {
		};
		try {
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jp = jsonFactory.createParser(downloadData);
			// TODO implement
		} catch (Exception e) {
			throw new IfcModelInterfaceException(e);
		} finally {
			if (downloadData != null) {
				downloadData.close();
			}
		}
	}

	
	public ObjectNode getNext() {
		// TODO implement
		return null;
	}
}
