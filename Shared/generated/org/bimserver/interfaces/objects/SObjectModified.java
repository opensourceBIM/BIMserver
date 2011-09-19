package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SObjectModified extends SCompareItem implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("ObjectModified");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("dataObjectId", SDataObject.class));
		sClass.addField(new SField("fieldName", java.lang.String.class));
		sClass.addField(new SField("oldValue", java.lang.String.class));
		sClass.addField(new SField("newValue", java.lang.String.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	private java.lang.String fieldName;
	private java.lang.String oldValue;
	private java.lang.String newValue;
	public java.lang.String getFieldName() {
		return fieldName;
	}

	public void setFieldName(java.lang.String fieldName) {
		this.fieldName = fieldName;
	}
	public java.lang.String getOldValue() {
		return oldValue;
	}

	public void setOldValue(java.lang.String oldValue) {
		this.oldValue = oldValue;
	}
	public java.lang.String getNewValue() {
		return newValue;
	}

	public void setNewValue(java.lang.String newValue) {
		this.newValue = newValue;
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
		SObjectModified other = (SObjectModified) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}