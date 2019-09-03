package org.bimserver.interfaces.objects;

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
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SConcreteRevision implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer id;
	private long projectId = -1;
	private byte[] checksum;
	private List<Long> revisions = new ArrayList<Long>();
	private java.lang.Long size;
	private java.util.Date date;
	private java.lang.String lastError;
	private boolean clear;
	private long summaryId = -1;
	private long userId = -1;
	private long ifcHeaderId = -1;
	private SBounds bounds;
	private SBounds boundsUntransformed;
	private byte[] oidCounters;
	private float multiplierToMm;
	private long densityCollectionId = -1;

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SConcreteRevision.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("id")) {
			return getId();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("checksum")) {
			return getChecksum();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("lastError")) {
			return getLastError();
		}
		if (sField.getName().equals("clear")) {
			return isClear();
		}
		if (sField.getName().equals("summaryId")) {
			return getSummaryId();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("ifcHeaderId")) {
			return getIfcHeaderId();
		}
		if (sField.getName().equals("bounds")) {
			return getBounds();
		}
		if (sField.getName().equals("boundsUntransformed")) {
			return getBoundsUntransformed();
		}
		if (sField.getName().equals("oidCounters")) {
			return getOidCounters();
		}
		if (sField.getName().equals("multiplierToMm")) {
			return getMultiplierToMm();
		}
		if (sField.getName().equals("densityCollectionId")) {
			return getDensityCollectionId();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		if (sField.getName().equals("uuid")) {
			return getUuid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("id")) {
			setId((Integer)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("checksum")) {
			setChecksum((byte[])val);
			return;
		}
		if (sField.getName().equals("revisions")) {
			setRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("size")) {
			setSize((Long)val);
			return;
		}
		if (sField.getName().equals("date")) {
			setDate((Date)val);
			return;
		}
		if (sField.getName().equals("lastError")) {
			setLastError((String)val);
			return;
		}
		if (sField.getName().equals("clear")) {
			setClear((Boolean)val);
			return;
		}
		if (sField.getName().equals("summaryId")) {
			setSummaryId((Long)val);
			return;
		}
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("ifcHeaderId")) {
			setIfcHeaderId((Long)val);
			return;
		}
		if (sField.getName().equals("bounds")) {
			setBounds((SBounds)val);
			return;
		}
		if (sField.getName().equals("boundsUntransformed")) {
			setBoundsUntransformed((SBounds)val);
			return;
		}
		if (sField.getName().equals("oidCounters")) {
			setOidCounters((byte[])val);
			return;
		}
		if (sField.getName().equals("multiplierToMm")) {
			setMultiplierToMm((Float)val);
			return;
		}
		if (sField.getName().equals("densityCollectionId")) {
			setDensityCollectionId((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		if (sField.getName().equals("rid")) {
			setRid((Integer)val);
			return;
		}
		if (sField.getName().equals("uuid")) {
			setUuid((UUID)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}
	
	public List<Long> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Long> revisions) {
		this.revisions = revisions;
	}
	
	public java.lang.Long getSize() {
		return size;
	}

	public void setSize(java.lang.Long size) {
		this.size = size;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public java.lang.String getLastError() {
		return lastError;
	}

	public void setLastError(java.lang.String lastError) {
		this.lastError = lastError;
	}
	
	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}
	
	public long getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(long summaryId) {
		this.summaryId = summaryId;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getIfcHeaderId() {
		return ifcHeaderId;
	}

	public void setIfcHeaderId(long ifcHeaderId) {
		this.ifcHeaderId = ifcHeaderId;
	}
	
	public SBounds getBounds() {
		return bounds;
	}

	public void setBounds(SBounds bounds) {
		this.bounds = bounds;
	}
	
	
	public SBounds getBoundsUntransformed() {
		return boundsUntransformed;
	}

	public void setBoundsUntransformed(SBounds boundsUntransformed) {
		this.boundsUntransformed = boundsUntransformed;
	}
	
	
	public byte[] getOidCounters() {
		return oidCounters;
	}

	public void setOidCounters(byte[] oidCounters) {
		this.oidCounters = oidCounters;
	}
	
	public float getMultiplierToMm() {
		return multiplierToMm;
	}

	public void setMultiplierToMm(float multiplierToMm) {
		this.multiplierToMm = multiplierToMm;
	}
	
	public long getDensityCollectionId() {
		return densityCollectionId;
	}

	public void setDensityCollectionId(long densityCollectionId) {
		this.densityCollectionId = densityCollectionId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SConcreteRevision other = (SConcreteRevision) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}