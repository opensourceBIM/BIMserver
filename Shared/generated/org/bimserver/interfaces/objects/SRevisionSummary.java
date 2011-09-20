package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SRevisionSummary implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("RevisionSummary");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("list", SRevisionSummaryContainer.class, true));
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
		if (sField.getName().equals("list")) {
			return getList();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private List<SRevisionSummaryContainer> list = new ArrayList<SRevisionSummaryContainer>();
	public List<SRevisionSummaryContainer> getList() {
		return list;
	}

	public void setList(List<SRevisionSummaryContainer> list) {
		this.list = list;
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
		SRevisionSummary other = (SRevisionSummary) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}