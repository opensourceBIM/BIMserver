package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SCheckoutResult extends SDownloadResult implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("CheckoutResult");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("projectName", java.lang.String.class));
		sClass.addField(new SField("revisionNr", int.class));
		sClass.addField(new SField("file", javax.activation.DataHandler.class));
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
		if (sField.getName().equals("projectName")) {
			return getProjectName();
		}
		if (sField.getName().equals("revisionNr")) {
			return getRevisionNr();
		}
		if (sField.getName().equals("file")) {
			return getFile();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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
		SCheckoutResult other = (SCheckoutResult) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}