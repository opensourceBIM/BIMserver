package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.bimserver.shared.meta.*;

@XmlRootElement
public class SCheckout implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Checkout");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("userId", long.class));
		sClass.addField(new SField("revisionId", long.class));
		sClass.addField(new SField("projectId", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("checkinId", long.class));
		sClass.addField(new SField("active", boolean.class));
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
	private long userId;
	private long revisionId;
	private long projectId;
	private java.util.Date date;
	private long checkinId;
	private boolean active;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(long revisionId) {
		this.revisionId = revisionId;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		SCheckout other = (SCheckout) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}