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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SOAuthServer implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String registrationUrl;
	private java.lang.String clientId;
	private java.lang.String clientSecret;
	private java.lang.String clientName;
	private byte[] clientIcon;
	private java.lang.String clientUrl;
	private java.lang.String clientDescription;
	private java.lang.String redirectUrl;
	private java.util.Date expiresAt;
	private java.util.Date issuedAt;
	private boolean incoming;
	private java.lang.String apiUrl;
	private java.lang.String registrationEndpoint;

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
		SOAuthServer.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("registrationUrl")) {
			return getRegistrationUrl();
		}
		if (sField.getName().equals("clientId")) {
			return getClientId();
		}
		if (sField.getName().equals("clientSecret")) {
			return getClientSecret();
		}
		if (sField.getName().equals("clientName")) {
			return getClientName();
		}
		if (sField.getName().equals("clientIcon")) {
			return getClientIcon();
		}
		if (sField.getName().equals("clientUrl")) {
			return getClientUrl();
		}
		if (sField.getName().equals("clientDescription")) {
			return getClientDescription();
		}
		if (sField.getName().equals("redirectUrl")) {
			return getRedirectUrl();
		}
		if (sField.getName().equals("expiresAt")) {
			return getExpiresAt();
		}
		if (sField.getName().equals("issuedAt")) {
			return getIssuedAt();
		}
		if (sField.getName().equals("incoming")) {
			return isIncoming();
		}
		if (sField.getName().equals("apiUrl")) {
			return getApiUrl();
		}
		if (sField.getName().equals("registrationEndpoint")) {
			return getRegistrationEndpoint();
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
		if (sField.getName().equals("registrationUrl")) {
			setRegistrationUrl((String)val);
			return;
		}
		if (sField.getName().equals("clientId")) {
			setClientId((String)val);
			return;
		}
		if (sField.getName().equals("clientSecret")) {
			setClientSecret((String)val);
			return;
		}
		if (sField.getName().equals("clientName")) {
			setClientName((String)val);
			return;
		}
		if (sField.getName().equals("clientIcon")) {
			setClientIcon((byte[])val);
			return;
		}
		if (sField.getName().equals("clientUrl")) {
			setClientUrl((String)val);
			return;
		}
		if (sField.getName().equals("clientDescription")) {
			setClientDescription((String)val);
			return;
		}
		if (sField.getName().equals("redirectUrl")) {
			setRedirectUrl((String)val);
			return;
		}
		if (sField.getName().equals("expiresAt")) {
			setExpiresAt((Date)val);
			return;
		}
		if (sField.getName().equals("issuedAt")) {
			setIssuedAt((Date)val);
			return;
		}
		if (sField.getName().equals("incoming")) {
			setIncoming((Boolean)val);
			return;
		}
		if (sField.getName().equals("apiUrl")) {
			setApiUrl((String)val);
			return;
		}
		if (sField.getName().equals("registrationEndpoint")) {
			setRegistrationEndpoint((String)val);
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
	
	public java.lang.String getRegistrationUrl() {
		return registrationUrl;
	}

	public void setRegistrationUrl(java.lang.String registrationUrl) {
		this.registrationUrl = registrationUrl;
	}
	
	public java.lang.String getClientId() {
		return clientId;
	}

	public void setClientId(java.lang.String clientId) {
		this.clientId = clientId;
	}
	
	public java.lang.String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(java.lang.String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public java.lang.String getClientName() {
		return clientName;
	}

	public void setClientName(java.lang.String clientName) {
		this.clientName = clientName;
	}
	
	public byte[] getClientIcon() {
		return clientIcon;
	}

	public void setClientIcon(byte[] clientIcon) {
		this.clientIcon = clientIcon;
	}
	
	public java.lang.String getClientUrl() {
		return clientUrl;
	}

	public void setClientUrl(java.lang.String clientUrl) {
		this.clientUrl = clientUrl;
	}
	
	public java.lang.String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(java.lang.String clientDescription) {
		this.clientDescription = clientDescription;
	}
	
	public java.lang.String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(java.lang.String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public java.util.Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(java.util.Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	public java.util.Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(java.util.Date issuedAt) {
		this.issuedAt = issuedAt;
	}
	
	public boolean isIncoming() {
		return incoming;
	}

	public void setIncoming(boolean incoming) {
		this.incoming = incoming;
	}
	
	public java.lang.String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(java.lang.String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public java.lang.String getRegistrationEndpoint() {
		return registrationEndpoint;
	}

	public void setRegistrationEndpoint(java.lang.String registrationEndpoint) {
		this.registrationEndpoint = registrationEndpoint;
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
		SOAuthServer other = (SOAuthServer) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}