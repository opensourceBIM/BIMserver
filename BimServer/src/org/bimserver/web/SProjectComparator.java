package org.bimserver.web;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ServiceInterface;

public class SProjectComparator implements Comparator<SProject> {

	private final ServiceInterface service;
	private final Map<SProject, String> cachedNames = new HashMap<SProject, String>();

	public SProjectComparator(ServiceInterface service) {
		this.service = service;
	}

	@Override
	public int compare(SProject p1, SProject p2) {
		String name1 = cachedNames.get(p1);
		String name2 = cachedNames.get(p2);
		if (name1 == null) {
			name1 = JspHelper.completeProjectName(service, p1);
			cachedNames.put(p1, name1);
		}
		if (name2 == null) {
			name2 = JspHelper.completeProjectName(service, p2);
			cachedNames.put(p2, name2);
		}
		return name1.compareTo(name2);
	}
}