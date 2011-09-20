package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SClashDetectionSettingsUpdated extends SLogAction implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("ClashDetectionSettingsUpdated");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("executorId", long.class));
		sClass.addField(new SField("accessMethod", SAccessMethod.class));
		sClass.addField(new SField("clashDetectionSettingsId", long.class));
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
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("executorId")) {
			return getExecutorId();
		}
		if (sField.getName().equals("accessMethod")) {
			return getAccessMethod();
		}
		if (sField.getName().equals("clashDetectionSettingsId")) {
			return getClashDetectionSettingsId();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private long clashDetectionSettingsId;
	public long getClashDetectionSettingsId() {
		return clashDetectionSettingsId;
	}

	public void setClashDetectionSettingsId(long clashDetectionSettingsId) {
		this.clashDetectionSettingsId = clashDetectionSettingsId;
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
		SClashDetectionSettingsUpdated other = (SClashDetectionSettingsUpdated) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}