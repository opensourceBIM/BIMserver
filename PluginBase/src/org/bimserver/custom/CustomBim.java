package org.bimserver.custom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomBim implements Serializable{

//	private Integer myid;
	private String poid;
	private String oid;
	private String revisionId;
	private String fieldName;
	private String fieldType;
	private String fieldValue;
	
	/*@Id
    @GeneratedValue
    @Column(name="myid")
	public Integer getMyid() {
		return myid;
	}*/
	/*public void setMyid(Integer myid) {
		this.myid = myid;
	}*/
	
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
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getRevisionId() {
		return revisionId;
	}
	public void setRevisionId(String revisionId) {
		this.revisionId = revisionId;
	}
	public CustomBim(String poid, String oid, String fieldName, String fieldType, String fieldValue,String revisionId) {
		super();
		this.poid = poid;
		this.oid = oid;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldValue = fieldValue;
		this.revisionId = revisionId;
	}
	public CustomBim(String poid, String oid, String fieldName) {
		super();
		this.poid = poid;
		this.oid = oid;
		this.fieldName = fieldName;
	}

	public CustomBim()
	{
		
	}
}
