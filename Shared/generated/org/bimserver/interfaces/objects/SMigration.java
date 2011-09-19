package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

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