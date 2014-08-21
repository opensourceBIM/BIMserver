package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SExtendedDataSchema implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String url;
	private java.lang.String namespace;
	private java.lang.String description;
	private long fileId = -1;
	private long size;
	private boolean validate;
	private SExtendedDataSchemaType type;
	private List<Long> users = new ArrayList<Long>();
	private List<Long> extendedData = new ArrayList<Long>();

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
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
		SExtendedDataSchema.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("url")) {
			return getUrl();
		}
		if (sField.getName().equals("namespace")) {
			return getNamespace();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("fileId")) {
			return getFileId();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("validate")) {
			return isValidate();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("users")) {
			return getUsers();
		}
		if (sField.getName().equals("extendedData")) {
			return getExtendedData();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("url")) {
			setUrl((String)val);
			return;
		}
		if (sField.getName().equals("namespace")) {
			setNamespace((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("fileId")) {
			setFileId((Long)val);
			return;
		}
		if (sField.getName().equals("size")) {
			setSize((Long)val);
			return;
		}
		if (sField.getName().equals("validate")) {
			setValidate((Boolean)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((SExtendedDataSchemaType)val);
			return;
		}
		if (sField.getName().equals("users")) {
			setUsers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("extendedData")) {
			setExtendedData((List<Long>)val);
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
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	
	public java.lang.String getNamespace() {
		return namespace;
	}

	public void setNamespace(java.lang.String namespace) {
		this.namespace = namespace;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	public SExtendedDataSchemaType getType() {
		return type;
	}

	public void setType(SExtendedDataSchemaType type) {
		this.type = type;
	}
	
	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}
	
	public List<Long> getExtendedData() {
		return extendedData;
	}

	public void setExtendedData(List<Long> extendedData) {
		this.extendedData = extendedData;
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
		SExtendedDataSchema other = (SExtendedDataSchema) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}