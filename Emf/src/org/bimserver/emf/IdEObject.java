package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.eclipse.emf.ecore.EObject;

public interface IdEObject extends EObject {
	void setOid(long oid);
	long getOid();
	void setRid(int rid);
	int getRid();
	void setPid(int pid);
	int getPid();
	void setLazyLoader(LazyLoader lazyLoader);
	void setLoaded();
	void load();
	boolean isLoadedOrLoading();
	void setLoading();
}