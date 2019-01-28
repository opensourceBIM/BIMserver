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

import org.bimserver.interfaces.objects.SCheckout;

public class SCheckoutDateComparator implements Comparator<SCheckout> {

	private final boolean ascending;

	public SCheckoutDateComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(SCheckout o1, SCheckout o2) {
		if (ascending) {
			return o1.getDate().compareTo(o2.getDate());
		} else {
			return o2.getDate().compareTo(o1.getDate());
		}
	}
}