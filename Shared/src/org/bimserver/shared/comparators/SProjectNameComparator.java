package org.bimserver.shared.comparators;

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

import org.bimserver.interfaces.objects.SProject;

public class SProjectNameComparator implements Comparator<SProject> {

	@Override
	public int compare(SProject o1, SProject o2) {
		if (o1 == null || o2 == null) {
			return 0;
		}
		return o1.getName().compareTo(o2.getName());
	}
}