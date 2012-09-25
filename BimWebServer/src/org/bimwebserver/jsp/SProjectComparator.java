package org.bimwebserver.jsp;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.interfaces.ServiceInterface;

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