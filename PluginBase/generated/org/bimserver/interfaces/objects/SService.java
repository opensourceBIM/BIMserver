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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SService implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String serviceName;
	private java.lang.String serviceIdentifier;
	private java.lang.String providerName;
	private java.lang.String url;
	private java.lang.String token;
	private SAccessMethod notificationProtocol;
	private java.lang.String description;
	private STrigger trigger;
	private boolean readRevision;
	private long readExtendedDataId = -1;
	private long writeRevisionId = -1;
	private long writeExtendedDataId = -1;
	private java.lang.String profileIdentifier;
	private java.lang.String profileName;
	private java.lang.String profileDescription;
	private boolean profilePublic;
	private long projectId = -1;
	private long userId = -1;
	private long internalServiceId = -1;
	private List<Long> modelCheckers = new ArrayList<Long>();

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
		SService.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("serviceName")) {
			return getServiceName();
		}
		if (sField.getName().equals("serviceIdentifier")) {
			return getServiceIdentifier();
		}
		if (sField.getName().equals("providerName")) {
			return getProviderName();
		}
		if (sField.getName().equals("url")) {
			return getUrl();
		}
		if (sField.getName().equals("token")) {
			return getToken();
		}
		if (sField.getName().equals("notificationProtocol")) {
			return getNotificationProtocol();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("trigger")) {
			return getTrigger();
		}
		if (sField.getName().equals("readRevision")) {
			return isReadRevision();
		}
		if (sField.getName().equals("readExtendedDataId")) {
			return getReadExtendedDataId();
		}
		if (sField.getName().equals("writeRevisionId")) {
			return getWriteRevisionId();
		}
		if (sField.getName().equals("writeExtendedDataId")) {
			return getWriteExtendedDataId();
		}
		if (sField.getName().equals("profileIdentifier")) {
			return getProfileIdentifier();
		}
		if (sField.getName().equals("profileName")) {
			return getProfileName();
		}
		if (sField.getName().equals("profileDescription")) {
			return getProfileDescription();
		}
		if (sField.getName().equals("profilePublic")) {
			return isProfilePublic();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("internalServiceId")) {
			return getInternalServiceId();
		}
		if (sField.getName().equals("modelCheckers")) {
			return getModelCheckers();
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
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("serviceName")) {
			setServiceName((String)val);
			return;
		}
		if (sField.getName().equals("serviceIdentifier")) {
			setServiceIdentifier((String)val);
			return;
		}
		if (sField.getName().equals("providerName")) {
			setProviderName((String)val);
			return;
		}
		if (sField.getName().equals("url")) {
			setUrl((String)val);
			return;
		}
		if (sField.getName().equals("token")) {
			setToken((String)val);
			return;
		}
		if (sField.getName().equals("notificationProtocol")) {
			setNotificationProtocol((SAccessMethod)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("trigger")) {
			setTrigger((STrigger)val);
			return;
		}
		if (sField.getName().equals("readRevision")) {
			setReadRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("readExtendedDataId")) {
			setReadExtendedDataId((Long)val);
			return;
		}
		if (sField.getName().equals("writeRevisionId")) {
			setWriteRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("writeExtendedDataId")) {
			setWriteExtendedDataId((Long)val);
			return;
		}
		if (sField.getName().equals("profileIdentifier")) {
			setProfileIdentifier((String)val);
			return;
		}
		if (sField.getName().equals("profileName")) {
			setProfileName((String)val);
			return;
		}
		if (sField.getName().equals("profileDescription")) {
			setProfileDescription((String)val);
			return;
		}
		if (sField.getName().equals("profilePublic")) {
			setProfilePublic((Boolean)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("internalServiceId")) {
			setInternalServiceId((Long)val);
			return;
		}
		if (sField.getName().equals("modelCheckers")) {
			setModelCheckers((List<Long>)val);
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
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getServiceName() {
		return serviceName;
	}

	public void setServiceName(java.lang.String serviceName) {
		this.serviceName = serviceName;
	}
	
	public java.lang.String getServiceIdentifier() {
		return serviceIdentifier;
	}

	public void setServiceIdentifier(java.lang.String serviceIdentifier) {
		this.serviceIdentifier = serviceIdentifier;
	}
	
	public java.lang.String getProviderName() {
		return providerName;
	}

	public void setProviderName(java.lang.String providerName) {
		this.providerName = providerName;
	}
	
	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	
	public java.lang.String getToken() {
		return token;
	}

	public void setToken(java.lang.String token) {
		this.token = token;
	}
	
	public SAccessMethod getNotificationProtocol() {
		return notificationProtocol;
	}

	public void setNotificationProtocol(SAccessMethod notificationProtocol) {
		this.notificationProtocol = notificationProtocol;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public STrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(STrigger trigger) {
		this.trigger = trigger;
	}
	
	public boolean isReadRevision() {
		return readRevision;
	}

	public void setReadRevision(boolean readRevision) {
		this.readRevision = readRevision;
	}
	
	public long getReadExtendedDataId() {
		return readExtendedDataId;
	}

	public void setReadExtendedDataId(long readExtendedDataId) {
		this.readExtendedDataId = readExtendedDataId;
	}
	
	public long getWriteRevisionId() {
		return writeRevisionId;
	}

	public void setWriteRevisionId(long writeRevisionId) {
		this.writeRevisionId = writeRevisionId;
	}
	
	public long getWriteExtendedDataId() {
		return writeExtendedDataId;
	}

	public void setWriteExtendedDataId(long writeExtendedDataId) {
		this.writeExtendedDataId = writeExtendedDataId;
	}
	
	public java.lang.String getProfileIdentifier() {
		return profileIdentifier;
	}

	public void setProfileIdentifier(java.lang.String profileIdentifier) {
		this.profileIdentifier = profileIdentifier;
	}
	
	public java.lang.String getProfileName() {
		return profileName;
	}

	public void setProfileName(java.lang.String profileName) {
		this.profileName = profileName;
	}
	
	public java.lang.String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(java.lang.String profileDescription) {
		this.profileDescription = profileDescription;
	}
	
	public boolean isProfilePublic() {
		return profilePublic;
	}

	public void setProfilePublic(boolean profilePublic) {
		this.profilePublic = profilePublic;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getInternalServiceId() {
		return internalServiceId;
	}

	public void setInternalServiceId(long internalServiceId) {
		this.internalServiceId = internalServiceId;
	}
	
	public List<Long> getModelCheckers() {
		return modelCheckers;
	}

	public void setModelCheckers(List<Long> modelCheckers) {
		this.modelCheckers = modelCheckers;
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
		SService other = (SService) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}