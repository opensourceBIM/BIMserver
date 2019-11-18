package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class LowLevelInterfaceAdaptor implements org.bimserver.shared.interfaces.LowLevelInterface {

	public void abortTransaction(java.lang.Long tid) throws UserException, ServerException {
	}
	
	public void addBooleanAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Boolean value) throws UserException, ServerException {
	}
	
	public void addDoubleAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Double value) throws UserException, ServerException {
	}
	
	public void addIntegerAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer value) throws UserException, ServerException {
	}
	
	public void addReference(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName, java.lang.Long referenceOid) throws UserException, ServerException {
	}
	
	public void addStringAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String value) throws UserException, ServerException {
	}
	
	public java.lang.Long commitTransaction(java.lang.Long tid, java.lang.String comment, java.lang.Boolean regenerateAllGeometry) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer count(java.lang.Long roid, java.lang.String className) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long createObject(java.lang.Long tid, java.lang.String className, java.lang.Boolean generateGuid) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean getBooleanAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean getBooleanAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Boolean> getBooleanAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public byte[] getByteArrayAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<byte[]> getByteArrayAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long roid, java.lang.String guid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long roid, java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjects(java.lang.Long roid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long roid, java.lang.String packageName, java.lang.String className, java.lang.Boolean flat) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Double getDoubleAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Double getDoubleAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Double> getDoubleAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getEnumAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer getIntegerAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Integer getIntegerAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Integer> getIntegerAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getLongAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getLongAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long getReference(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.Long> getReferences(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.String getStringAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<java.lang.String> getStringAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
		return null;
	}
	
	public void removeAllReferences(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName) throws UserException, ServerException {
	}
	
	public void removeAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index) throws UserException, ServerException {
	}
	
	public void removeObject(java.lang.Long tid, java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void removeReference(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName, java.lang.Integer index) throws UserException, ServerException {
	}
	
	public void removeReferenceByOid(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName, java.lang.Long referencedOid) throws UserException, ServerException {
	}
	
	public void setBooleanAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Boolean value) throws UserException, ServerException {
	}
	
	public void setBooleanAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index, java.lang.Boolean value) throws UserException, ServerException {
	}
	
	public void setBooleanAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.util.List<java.lang.Boolean> values) throws UserException, ServerException {
	}
	
	public void setByteArrayAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Byte[] value) throws UserException, ServerException {
	}
	
	public void setDoubleAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Double value) throws UserException, ServerException {
	}
	
	public void setDoubleAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index, java.lang.Double value) throws UserException, ServerException {
	}
	
	public void setDoubleAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.util.List<java.lang.Double> values) throws UserException, ServerException {
	}
	
	public void setEnumAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String value) throws UserException, ServerException {
	}
	
	public void setIntegerAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer value) throws UserException, ServerException {
	}
	
	public void setIntegerAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index, java.lang.Integer value) throws UserException, ServerException {
	}
	
	public void setIntegerAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.util.List<java.lang.Integer> values) throws UserException, ServerException {
	}
	
	public void setLongAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Long value) throws UserException, ServerException {
	}
	
	public void setLongAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index, java.lang.Long value) throws UserException, ServerException {
	}
	
	public void setLongAttributes(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.util.List<java.lang.Long> values) throws UserException, ServerException {
	}
	
	public void setReference(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName, java.lang.Long referenceOid) throws UserException, ServerException {
	}
	
	public void setStringAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String value) throws UserException, ServerException {
	}
	
	public void setStringAttributeAtIndex(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.Integer index, java.lang.String value) throws UserException, ServerException {
	}
	
	public void setWrappedBooleanAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String type, java.lang.Boolean value) throws UserException, ServerException {
	}
	
	public void setWrappedDoubleAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String type, java.lang.Double value) throws UserException, ServerException {
	}
	
	public void setWrappedIntegerAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String type, java.lang.Integer value) throws UserException, ServerException {
	}
	
	public void setWrappedLongAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String type, java.lang.Long value) throws UserException, ServerException {
	}
	
	public void setWrappedStringAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName, java.lang.String type, java.lang.String value) throws UserException, ServerException {
	}
	
	public java.lang.Long startTransaction(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public void unsetAttribute(java.lang.Long tid, java.lang.Long oid, java.lang.String attributeName) throws UserException, ServerException {
	}
	
	public void unsetReference(java.lang.Long tid, java.lang.Long oid, java.lang.String referenceName) throws UserException, ServerException {
	}
	
}