package net.sourceforge.osexpress.parser;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Vector;

@SuppressWarnings("all")
class EnumerationType {

	private Vector ids;
	public boolean extensible;
	public String typename;
	public String basedOnName;

	public EnumerationType() {
		ids = new Vector();
	}

	public void setTypeName(String name) {
		typename = name;
	}

	public void setExtensible(boolean ext) {
		extensible = ext;
	}

	public void setBasedOn(String bo) {
		basedOnName = bo;
	}

	public void add(String eid) {
		ids.add(eid);
	}

	public void extendWith(EnumerationType et) {
		ids.addAll(et.ids);
	}

	public int getCount() {
		return ids.size();
	}

	public String getEnumerationId(int index) {
		return (String) ids.elementAt(index);
	}
}
