package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SListDataValue extends SDataValue implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("ListDataValue");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("fieldName", java.lang.String.class));
		sClass.addField(new SField("values", SDataValue.class, true));
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
	private List<SDataValue> values = new ArrayList<SDataValue>();
	public List<SDataValue> getValues() {
		return values;
	}

	public void setValues(List<SDataValue> values) {
		this.values = values;
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
		SListDataValue other = (SListDataValue) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}