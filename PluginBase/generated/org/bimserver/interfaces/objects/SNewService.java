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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SNewService implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String provider;
	private java.lang.String description;
	private java.lang.String authorizationUrl;
	private java.lang.String tokenUrl;
	private java.lang.String resourceUrl;
	private java.lang.String registerUrl;
	private java.lang.String input;
	private java.lang.String oauthCode;
	private SServiceStatus status;
	private long serializerId = -1;
	private java.lang.String output;
	private SAction action;
	private java.lang.String accessToken;
	private long projectId = -1;
	private java.lang.String stateJson;

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
		SNewService.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("provider")) {
			return getProvider();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("authorizationUrl")) {
			return getAuthorizationUrl();
		}
		if (sField.getName().equals("tokenUrl")) {
			return getTokenUrl();
		}
		if (sField.getName().equals("resourceUrl")) {
			return getResourceUrl();
		}
		if (sField.getName().equals("registerUrl")) {
			return getRegisterUrl();
		}
		if (sField.getName().equals("input")) {
			return getInput();
		}
		if (sField.getName().equals("oauthCode")) {
			return getOauthCode();
		}
		if (sField.getName().equals("status")) {
			return getStatus();
		}
		if (sField.getName().equals("serializerId")) {
			return getSerializerId();
		}
		if (sField.getName().equals("output")) {
			return getOutput();
		}
		if (sField.getName().equals("action")) {
			return getAction();
		}
		if (sField.getName().equals("accessToken")) {
			return getAccessToken();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("stateJson")) {
			return getStateJson();
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

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("provider")) {
			setProvider((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("authorizationUrl")) {
			setAuthorizationUrl((String)val);
			return;
		}
		if (sField.getName().equals("tokenUrl")) {
			setTokenUrl((String)val);
			return;
		}
		if (sField.getName().equals("resourceUrl")) {
			setResourceUrl((String)val);
			return;
		}
		if (sField.getName().equals("registerUrl")) {
			setRegisterUrl((String)val);
			return;
		}
		if (sField.getName().equals("input")) {
			setInput((String)val);
			return;
		}
		if (sField.getName().equals("oauthCode")) {
			setOauthCode((String)val);
			return;
		}
		if (sField.getName().equals("status")) {
			setStatus((SServiceStatus)val);
			return;
		}
		if (sField.getName().equals("serializerId")) {
			setSerializerId((Long)val);
			return;
		}
		if (sField.getName().equals("output")) {
			setOutput((String)val);
			return;
		}
		if (sField.getName().equals("action")) {
			setAction((SAction)val);
			return;
		}
		if (sField.getName().equals("accessToken")) {
			setAccessToken((String)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("stateJson")) {
			setStateJson((String)val);
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
	
	public java.lang.String getProvider() {
		return provider;
	}

	public void setProvider(java.lang.String provider) {
		this.provider = provider;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public java.lang.String getAuthorizationUrl() {
		return authorizationUrl;
	}

	public void setAuthorizationUrl(java.lang.String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}
	
	public java.lang.String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(java.lang.String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}
	
	public java.lang.String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(java.lang.String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	public java.lang.String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(java.lang.String registerUrl) {
		this.registerUrl = registerUrl;
	}
	
	public java.lang.String getInput() {
		return input;
	}

	public void setInput(java.lang.String input) {
		this.input = input;
	}
	
	public java.lang.String getOauthCode() {
		return oauthCode;
	}

	public void setOauthCode(java.lang.String oauthCode) {
		this.oauthCode = oauthCode;
	}
	
	public SServiceStatus getStatus() {
		return status;
	}

	public void setStatus(SServiceStatus status) {
		this.status = status;
	}
	
	public long getSerializerId() {
		return serializerId;
	}

	public void setSerializerId(long serializerId) {
		this.serializerId = serializerId;
	}
	
	public java.lang.String getOutput() {
		return output;
	}

	public void setOutput(java.lang.String output) {
		this.output = output;
	}
	
	public SAction getAction() {
		return action;
	}

	public void setAction(SAction action) {
		this.action = action;
	}
	
	
	public java.lang.String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(java.lang.String accessToken) {
		this.accessToken = accessToken;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public java.lang.String getStateJson() {
		return stateJson;
	}

	public void setStateJson(java.lang.String stateJson) {
		this.stateJson = stateJson;
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
		SNewService other = (SNewService) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}