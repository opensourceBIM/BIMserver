package org.bimserver;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.web.JspHelper;

public class SProjectComparator implements Comparator<SProject> {

	private final ServiceInterface service;

	public SProjectComparator(ServiceInterface service) {
		this.service = service;
	}
	
	@Override
	public int compare(SProject p1, SProject p2) {
		return JspHelper.completeProjectName(service, p1).compareTo(JspHelper.completeProjectName(service, p2));
	}
}
