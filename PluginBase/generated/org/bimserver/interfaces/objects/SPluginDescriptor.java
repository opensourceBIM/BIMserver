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
public class SPluginDescriptor implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String pluginClassName;
	private java.lang.String description;
	private java.lang.String location;
	private java.lang.Boolean enabled;
	private java.lang.String pluginInterfaceClassName;
	private List<Long> configurations = new ArrayList<Long>();
	private java.lang.String identifier;
	private boolean installForNewUsers;
	private long pluginBundleVersionId = -1;
	private long settingsId = -1;

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
		SPluginDescriptor.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("pluginClassName")) {
			return getPluginClassName();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("location")) {
			return getLocation();
		}
		if (sField.getName().equals("enabled")) {
			return getEnabled();
		}
		if (sField.getName().equals("pluginInterfaceClassName")) {
			return getPluginInterfaceClassName();
		}
		if (sField.getName().equals("configurations")) {
			return getConfigurations();
		}
		if (sField.getName().equals("identifier")) {
			return getIdentifier();
		}
		if (sField.getName().equals("installForNewUsers")) {
			return isInstallForNewUsers();
		}
		if (sField.getName().equals("pluginBundleVersionId")) {
			return getPluginBundleVersionId();
		}
		if (sField.getName().equals("settingsId")) {
			return getSettingsId();
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
		if (sField.getName().equals("pluginClassName")) {
			setPluginClassName((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("location")) {
			setLocation((String)val);
			return;
		}
		if (sField.getName().equals("enabled")) {
			setEnabled((Boolean)val);
			return;
		}
		if (sField.getName().equals("pluginInterfaceClassName")) {
			setPluginInterfaceClassName((String)val);
			return;
		}
		if (sField.getName().equals("configurations")) {
			setConfigurations((List<Long>)val);
			return;
		}
		if (sField.getName().equals("identifier")) {
			setIdentifier((String)val);
			return;
		}
		if (sField.getName().equals("installForNewUsers")) {
			setInstallForNewUsers((Boolean)val);
			return;
		}
		if (sField.getName().equals("pluginBundleVersionId")) {
			setPluginBundleVersionId((Long)val);
			return;
		}
		if (sField.getName().equals("settingsId")) {
			setSettingsId((Long)val);
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
	
	public java.lang.String getPluginClassName() {
		return pluginClassName;
	}

	public void setPluginClassName(java.lang.String pluginClassName) {
		this.pluginClassName = pluginClassName;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public java.lang.String getLocation() {
		return location;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	
	public java.lang.Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(java.lang.Boolean enabled) {
		this.enabled = enabled;
	}
	
	public java.lang.String getPluginInterfaceClassName() {
		return pluginInterfaceClassName;
	}

	public void setPluginInterfaceClassName(java.lang.String pluginInterfaceClassName) {
		this.pluginInterfaceClassName = pluginInterfaceClassName;
	}
	
	public List<Long> getConfigurations() {
		return configurations;
	}

	public void setConfigurations(List<Long> configurations) {
		this.configurations = configurations;
	}
	
	public java.lang.String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}
	
	public boolean isInstallForNewUsers() {
		return installForNewUsers;
	}

	public void setInstallForNewUsers(boolean installForNewUsers) {
		this.installForNewUsers = installForNewUsers;
	}
	
	public long getPluginBundleVersionId() {
		return pluginBundleVersionId;
	}

	public void setPluginBundleVersionId(long pluginBundleVersionId) {
		this.pluginBundleVersionId = pluginBundleVersionId;
	}
	
	public long getSettingsId() {
		return settingsId;
	}

	public void setSettingsId(long settingsId) {
		this.settingsId = settingsId;
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
		SPluginDescriptor other = (SPluginDescriptor) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}