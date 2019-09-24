package org.bimserver.custom;

import java.io.Serializable;

public class customBimId implements Serializable{
	
	private String poid;
	private String oid;
	private String fieldName;
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public customBimId()
	{
		
	}
}
