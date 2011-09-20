package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SServerLog implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("ServerLog");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("actions", Long.class, true));
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
		if (sField.getName().equals("actions")) {
			return getActions();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private List<Long> actions = new ArrayList<Long>();
	public List<Long> getActions() {
		return actions;
	}

	public void setActions(List<Long> actions) {
		this.actions = actions;
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
		SServerLog other = (SServerLog) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}