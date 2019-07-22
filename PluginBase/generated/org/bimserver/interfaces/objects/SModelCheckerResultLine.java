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
public class SModelCheckerResultLine extends SModelCheckerResultItem implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String fieldOrClass;
	private java.lang.String value;
	private java.lang.String shouldBe;
	private SModelCheckerResultType type;
	private long objectId;

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
		SModelCheckerResultLine.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("fieldOrClass")) {
			return getFieldOrClass();
		}
		if (sField.getName().equals("value")) {
			return getValue();
		}
		if (sField.getName().equals("shouldBe")) {
			return getShouldBe();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("objectId")) {
			return getObjectId();
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
		if (sField.getName().equals("fieldOrClass")) {
			setFieldOrClass((String)val);
			return;
		}
		if (sField.getName().equals("value")) {
			setValue((String)val);
			return;
		}
		if (sField.getName().equals("shouldBe")) {
			setShouldBe((String)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((SModelCheckerResultType)val);
			return;
		}
		if (sField.getName().equals("objectId")) {
			setObjectId((Long)val);
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
	
	public java.lang.String getFieldOrClass() {
		return fieldOrClass;
	}

	public void setFieldOrClass(java.lang.String fieldOrClass) {
		this.fieldOrClass = fieldOrClass;
	}
	
	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}
	
	public java.lang.String getShouldBe() {
		return shouldBe;
	}

	public void setShouldBe(java.lang.String shouldBe) {
		this.shouldBe = shouldBe;
	}
	
	public SModelCheckerResultType getType() {
		return type;
	}

	public void setType(SModelCheckerResultType type) {
		this.type = type;
	}
	
	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
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
		SModelCheckerResultLine other = (SModelCheckerResultLine) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}