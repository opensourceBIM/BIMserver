package org.bimserver.demoplugins.service;

import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;

public class HtmlService extends AbstractAddExtendedDataService {
	private static final String NAMESPACE = "htmldemo";

	public HtmlService() {
		super("HTML Demo Service", "HTML Demo Service", NAMESPACE);
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		Path path = getPluginContext().getRootPath().resolve("data").resolve("example.html");
		addExtendedData(Files.readAllBytes(path), "example.html", "HTML Demo Results", "text/html", bimServerClientInterface, roid);
	}
}