package org.bimserver.ifc;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class IfcModel {

	private long counter = 1;
	private final BiMap<Long, IdEObject> objects;
	private Map<String, IfcRoot> guidIndexed;
	private byte[] checksum;
	private IdEObject eObject;
	private int revisionNr;
	private String authorizedUser;
	private Date date;

	public IfcModel(BiMap<Long, IdEObject> objects) {
		this.objects = objects;
	}
	
	public IfcModel() {
		this.objects = HashBiMap.create();
	}

	public IfcModel(int size) {
		this.objects = HashBiMap.create(size);
	}
	
	public long size() {
		return objects.size();
	}

	public Set<Long> keySet() {
		return objects.keySet();
	}

	public IdEObject get(Long key) {
		return objects.get(key);
	}

	public Collection<IdEObject> getValues() {
		return objects.values();
	}
	
	public void add(Long key, IdEObject eObject) {
		objects.put(key, eObject);
	}
	
	public Map<Long, IdEObject> getObjects() {
		return objects;
	}

	public BiMap<? extends Long, ? extends IdEObject> getMap() {
		return (BiMap<? extends Long, ? extends IdEObject>) objects;
	}

	public void add(IdEObject newObject) {
		objects.put(((Long)counter++), newObject);
	}

	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}

	public boolean containsKey(Long key) {
		return objects.containsKey(key);
	}

	public IdEObject getMainObject() {
		return eObject;
	}

	public void setMainObject(IdEObject eObject) {
		this.eObject = eObject;
	}

	public int getSize() {
		return objects.size();
	}

	public boolean contains(IdEObject eObject) {
		return objects.inverse().containsKey(eObject);
	}

	public Long get(IdEObject eObject) {
		return objects.inverse().get(eObject);
	}

	public void indexGuids() {
		guidIndexed = new HashMap<String, IfcRoot>();
		for (IdEObject idEObject : objects.values()) {
			if (idEObject instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot)idEObject;
				if (ifcRoot.getGlobalId() != null) {
					guidIndexed.put(ifcRoot.getGlobalId().getWrappedValue(), ifcRoot);
				}
			}
		}
	}
	
	public IfcRoot getByGuid(String guid) {
		if (guidIndexed == null) {
			throw new RuntimeException("Not indexed on guids");
		}
		return guidIndexed.get(guid);
	}

	public String getAuthorizedUser() {
		return authorizedUser;
	}

	public int getRevisionNr() {
		return revisionNr;
	}

	public boolean isValid() {
		return true;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
	
	public void setRevisionNr(int revisionNr) {
		this.revisionNr = revisionNr;
	}
}