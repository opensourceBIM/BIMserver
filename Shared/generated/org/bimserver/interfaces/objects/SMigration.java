package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SMigration implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Migration");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("number", int.class));
		sClass.addField(new SField("description", java.lang.String.class));
		sClass.addField(new SField("executed", boolean.class));
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
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("number")) {
			return getNumber();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("executed")) {
			return isExecuted();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int number;
	private java.lang.String description;
	private boolean executed;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
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
		SMigration other = (SMigration) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}