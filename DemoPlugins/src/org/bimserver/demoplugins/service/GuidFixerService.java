package org.bimserver.demoplugins.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.services.AbstractModifyRevisionService;
import org.bimserver.plugins.services.BimServerClientInterface;

public class GuidFixerService extends AbstractModifyRevisionService {

	public GuidFixerService() {
		super("GUID fixer", "GUID fixer");
	}

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
		IfcModelInterface model = bimServerClientInterface.getModel(project, roid, false, false);
		Map<String, List<IfcRoot>> guids = new HashMap<String, List<IfcRoot>>();
		int fixed = 0;
		// Iterate over all objects that can have a GUID
		for (IfcRoot ifcRoot : model.getAllWithSubTypes(IfcRoot.class)) {
			if (ifcRoot.getGlobalId() != null) {
				if (!guids.containsKey(ifcRoot.getGlobalId())) {
					guids.put(ifcRoot.getGlobalId(), new ArrayList<IfcRoot>());
				}
				guids.get(ifcRoot.getGlobalId()).add(ifcRoot);
			}
		}
		for (String guid : guids.keySet()) {
			List<IfcRoot> list = guids.get(guid);
			if (list.size() > 1) {
				int c = 1;
				for (int i=1; i<list.size(); i++) {
					String newGuid = guid + "." + c;
					while (guids.containsKey(newGuid)) {
						c++;
						newGuid = guid + "." + c;
					}
					fixed++;
					list.get(i).setGlobalId(newGuid);
				}
			}
		}
		if (fixed > 0) {
			model.commit("Fixed " + fixed + " GUIDs");
		}		
	}

	@Override
	public ProgressType getProgressType() {
		return ProgressType.UNKNOWN;
	}
}