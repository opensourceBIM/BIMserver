package org.bimserver.demoplugins.service;
import org.bimserver.demoplugins.service.planner.EventLog;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;

import com.google.common.base.Charsets;

public class EventLogService extends AbstractAddExtendedDataService {
	private static final String NAMESPACE = "http://bimserver.org/eventlog";

	public EventLogService() {
		super("EventLog", "EventLog", NAMESPACE);
	}
	
	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
		IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, true);
		
		EventLog eventLog = new EventLog(model);
		
		String csvString = eventLog.toCsvString();
		
		addExtendedData(csvString.getBytes(Charsets.UTF_8), "eventlog.csv", "Eventlog", "text/csv", bimServerClientInterface, roid);
	}
}