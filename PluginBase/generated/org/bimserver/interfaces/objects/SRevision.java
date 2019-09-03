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
public class SRevision implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer id;
	private long userId = -1;
	private java.util.Date date;
	private java.lang.String comment;
	private java.lang.Long size;
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private long lastConcreteRevisionId = -1;
	private List<Long> checkouts = new ArrayList<Long>();
	private long projectId = -1;
	private java.lang.String tag;
	private java.lang.String lastError;
	private java.lang.Integer bmi;
	private List<Long> extendedData = new ArrayList<Long>();
	private List<Long> logs = new ArrayList<Long>();
	private long serviceId = -1;
	private boolean hasGeometry;
	private SBounds bounds;
	private SBounds boundsUntransformed;
	private SBounds boundsMm;
	private SBounds boundsUntransformedMm;
	private List<Long> servicesLinked = new ArrayList<Long>();
	private long densityCollectionId = -1;
	private long nrPrimitives;

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
		SRevision.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("id")) {
			return getId();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("comment")) {
			return getComment();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("concreteRevisions")) {
			return getConcreteRevisions();
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			return getLastConcreteRevisionId();
		}
		if (sField.getName().equals("checkouts")) {
			return getCheckouts();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("tag")) {
			return getTag();
		}
		if (sField.getName().equals("lastError")) {
			return getLastError();
		}
		if (sField.getName().equals("bmi")) {
			return getBmi();
		}
		if (sField.getName().equals("extendedData")) {
			return getExtendedData();
		}
		if (sField.getName().equals("logs")) {
			return getLogs();
		}
		if (sField.getName().equals("serviceId")) {
			return getServiceId();
		}
		if (sField.getName().equals("hasGeometry")) {
			return isHasGeometry();
		}
		if (sField.getName().equals("bounds")) {
			return getBounds();
		}
		if (sField.getName().equals("boundsUntransformed")) {
			return getBoundsUntransformed();
		}
		if (sField.getName().equals("boundsMm")) {
			return getBoundsMm();
		}
		if (sField.getName().equals("boundsUntransformedMm")) {
			return getBoundsUntransformedMm();
		}
		if (sField.getName().equals("servicesLinked")) {
			return getServicesLinked();
		}
		if (sField.getName().equals("densityCollectionId")) {
			return getDensityCollectionId();
		}
		if (sField.getName().equals("nrPrimitives")) {
			return getNrPrimitives();
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
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("date")) {
			setDate((Date)val);
			return;
		}
		if (sField.getName().equals("comment")) {
			setComment((String)val);
			return;
		}
		if (sField.getName().equals("size")) {
			setSize((Long)val);
			return;
		}
		if (sField.getName().equals("concreteRevisions")) {
			setConcreteRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			setLastConcreteRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("checkouts")) {
			setCheckouts((List<Long>)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("tag")) {
			setTag((String)val);
			return;
		}
		if (sField.getName().equals("lastError")) {
			setLastError((String)val);
			return;
		}
		if (sField.getName().equals("bmi")) {
			setBmi((Integer)val);
			return;
		}
		if (sField.getName().equals("extendedData")) {
			setExtendedData((List<Long>)val);
			return;
		}
		if (sField.getName().equals("logs")) {
			setLogs((List<Long>)val);
			return;
		}
		if (sField.getName().equals("serviceId")) {
			setServiceId((Long)val);
			return;
		}
		if (sField.getName().equals("hasGeometry")) {
			setHasGeometry((Boolean)val);
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
		if (sField.getName().equals("boundsMm")) {
			setBoundsMm((SBounds)val);
			return;
		}
		if (sField.getName().equals("boundsUntransformedMm")) {
			setBoundsUntransformedMm((SBounds)val);
			return;
		}
		if (sField.getName().equals("servicesLinked")) {
			setServicesLinked((List<Long>)val);
			return;
		}
		if (sField.getName().equals("densityCollectionId")) {
			setDensityCollectionId((Long)val);
			return;
		}
		if (sField.getName().equals("nrPrimitives")) {
			setNrPrimitives((Long)val);
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
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public java.lang.String getComment() {
		return comment;
	}

	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}
	
	public java.lang.Long getSize() {
		return size;
	}

	public void setSize(java.lang.Long size) {
		this.size = size;
	}
	
	public List<Long> getConcreteRevisions() {
		return concreteRevisions;
	}

	public void setConcreteRevisions(List<Long> concreteRevisions) {
		this.concreteRevisions = concreteRevisions;
	}
	
	public long getLastConcreteRevisionId() {
		return lastConcreteRevisionId;
	}

	public void setLastConcreteRevisionId(long lastConcreteRevisionId) {
		this.lastConcreteRevisionId = lastConcreteRevisionId;
	}
	
	public List<Long> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Long> checkouts) {
		this.checkouts = checkouts;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public java.lang.String getTag() {
		return tag;
	}

	public void setTag(java.lang.String tag) {
		this.tag = tag;
	}
	
	public java.lang.String getLastError() {
		return lastError;
	}

	public void setLastError(java.lang.String lastError) {
		this.lastError = lastError;
	}
	
	public java.lang.Integer getBmi() {
		return bmi;
	}

	public void setBmi(java.lang.Integer bmi) {
		this.bmi = bmi;
	}
	
	public List<Long> getExtendedData() {
		return extendedData;
	}

	public void setExtendedData(List<Long> extendedData) {
		this.extendedData = extendedData;
	}
	
	public List<Long> getLogs() {
		return logs;
	}

	public void setLogs(List<Long> logs) {
		this.logs = logs;
	}
	
	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	
	public boolean isHasGeometry() {
		return hasGeometry;
	}

	public void setHasGeometry(boolean hasGeometry) {
		this.hasGeometry = hasGeometry;
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
	
	
	public SBounds getBoundsMm() {
		return boundsMm;
	}

	public void setBoundsMm(SBounds boundsMm) {
		this.boundsMm = boundsMm;
	}
	
	
	public SBounds getBoundsUntransformedMm() {
		return boundsUntransformedMm;
	}

	public void setBoundsUntransformedMm(SBounds boundsUntransformedMm) {
		this.boundsUntransformedMm = boundsUntransformedMm;
	}
	
	
	public List<Long> getServicesLinked() {
		return servicesLinked;
	}

	public void setServicesLinked(List<Long> servicesLinked) {
		this.servicesLinked = servicesLinked;
	}
	
	public long getDensityCollectionId() {
		return densityCollectionId;
	}

	public void setDensityCollectionId(long densityCollectionId) {
		this.densityCollectionId = densityCollectionId;
	}
	
	public long getNrPrimitives() {
		return nrPrimitives;
	}

	public void setNrPrimitives(long nrPrimitives) {
		this.nrPrimitives = nrPrimitives;
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
		SRevision other = (SRevision) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}