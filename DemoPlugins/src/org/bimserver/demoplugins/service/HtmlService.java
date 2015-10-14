package org.bimserver.demoplugins.service;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;

public class HtmlService extends AbstractAddExtendedDataService {
	private static final String NAMESPACE = "text/html";

	public HtmlService() {
		super("HTML Demo Service", "HTML Demo Service");
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		byte[] bytes = IOUtils.toByteArray(getPluginContext().getResourceAsInputStream("data/example.html"));
		addExtendedData(bytes, "example.html", "HTML Demo Results", "text/html", bimServerClientInterface, roid, NAMESPACE);
	}

	@Override
	public ProgressType getProgressType() {
		return ProgressType.UNKNOWN;
	}
}