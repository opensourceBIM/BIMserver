package org.bimserver;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.AuthenticatedServiceWrapper;
import org.bimserver.shared.UserException;

public class SProjectComparator implements Comparator<SProject> {

	private final AuthenticatedServiceWrapper service;

	public SProjectComparator(AuthenticatedServiceWrapper service) {
		this.service = service;
	}
	
	@Override
	public int compare(SProject p1, SProject p2) {
		try {
			return JspHelper.completeProjectName(service, p1).compareTo(JspHelper.completeProjectName(service, p2));
		} catch (UserException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
