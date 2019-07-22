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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlSeeAlso(value={SMessagingSerializerPluginConfiguration.class})
public class SSerializerPluginConfiguration extends SPluginConfiguration implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long objectIDMId = -1;
	private long userSettingsId = -1;
	private long renderEngineId = -1;
	private boolean streaming;

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
		SSerializerPluginConfiguration.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("enabled")) {
			return getEnabled();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("pluginDescriptorId")) {
			return getPluginDescriptorId();
		}
		if (sField.getName().equals("settingsId")) {
			return getSettingsId();
		}
		if (sField.getName().equals("objectIDMId")) {
			return getObjectIDMId();
		}
		if (sField.getName().equals("userSettingsId")) {
			return getUserSettingsId();
		}
		if (sField.getName().equals("renderEngineId")) {
			return getRenderEngineId();
		}
		if (sField.getName().equals("streaming")) {
			return isStreaming();
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
		if (sField.getName().equals("enabled")) {
			setEnabled((Boolean)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("pluginDescriptorId")) {
			setPluginDescriptorId((Long)val);
			return;
		}
		if (sField.getName().equals("settingsId")) {
			setSettingsId((Long)val);
			return;
		}
		if (sField.getName().equals("objectIDMId")) {
			setObjectIDMId((Long)val);
			return;
		}
		if (sField.getName().equals("userSettingsId")) {
			setUserSettingsId((Long)val);
			return;
		}
		if (sField.getName().equals("renderEngineId")) {
			setRenderEngineId((Long)val);
			return;
		}
		if (sField.getName().equals("streaming")) {
			setStreaming((Boolean)val);
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
	
	public long getObjectIDMId() {
		return objectIDMId;
	}

	public void setObjectIDMId(long objectIDMId) {
		this.objectIDMId = objectIDMId;
	}
	
	public long getUserSettingsId() {
		return userSettingsId;
	}

	public void setUserSettingsId(long userSettingsId) {
		this.userSettingsId = userSettingsId;
	}
	
	public long getRenderEngineId() {
		return renderEngineId;
	}

	public void setRenderEngineId(long renderEngineId) {
		this.renderEngineId = renderEngineId;
	}
	
	public boolean isStreaming() {
		return streaming;
	}

	public void setStreaming(boolean streaming) {
		this.streaming = streaming;
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
		SSerializerPluginConfiguration other = (SSerializerPluginConfiguration) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}