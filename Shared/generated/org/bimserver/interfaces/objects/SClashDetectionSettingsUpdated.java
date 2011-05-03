package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SClashDetectionSettingsUpdated extends SLogAction
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
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