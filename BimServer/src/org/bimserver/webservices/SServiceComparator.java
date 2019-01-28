package org.bimserver.webservices;

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

import java.util.Comparator;

import org.bimserver.interfaces.objects.SService;

public class SServiceComparator implements Comparator<SService> {

	@Override
	public int compare(SService o1, SService o2) {
		int r = o1.getServiceName().compareTo(o2.getServiceName());
		if (r == 0) {
			return o1.getProfileName().compareTo(o2.getProfileName());
		}
		return r;
	}
}