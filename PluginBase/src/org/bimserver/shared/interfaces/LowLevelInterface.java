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

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "LowLevelInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface LowLevelInterface extends PublicInterface {
	/**
	 * Start a new transaction. You can commit the transaction with commitTransaction
	 * 
	 * @param poid ObjectID of the Project to start a transaction on
	 * @return A TransactionID (tid) that should be used for subsequent calls
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "startTransaction")
	Long startTransaction(
		@WebParam(name = "poid", partName = "startTransaction.poid") Long poid) throws ServerException, UserException;

	/**
	 * Commit a transaction, changes will be saved, a transaction must be started by startTransaction first
     *
	 * @param tid The TransactionID
	 * @param comment Comment describing what has changed
	 * @return ObjectID of the newly created Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "commitTransaction")
	Long commitTransaction(
		@WebParam(name = "tid", partName = "commitTransaction.tid") Long tid,
		@WebParam(name = "comment", partName = "commitTransaction.comment") String comment,
		@WebParam(name = "regenerateAllGeometry", partName = "commitTransaction.regenerateAllGeometry") Boolean regenerateAllGeometry) throws ServerException, UserException;
	
	/**
	 * Abort a transaction, changes will not be saved
	 * 
	 * @param tid The TransactionID
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "abortTransaction")
	void abortTransaction(
		@WebParam(name = "tid", partName = "abortTransaction.tid") Long tid) throws ServerException, UserException;
	
	/**
	 * Create a new Object
	 * 
	 * @param tid The TransactionID
	 * @param className The type of the new object
	 * @return The ObjectID of the newly created object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "createObject")
	Long createObject(
		@WebParam(name = "tid", partName = "createObject.tid") Long tid,
		@WebParam(name = "className", partName = "createObject.className") String className,
		@WebParam(name = "generateGuid", partName = "createObject.generateGuid") Boolean generateGuid) throws ServerException, UserException;
	
	/**
	 * Remove an object
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeObject")
	void removeObject(
		@WebParam(name = "tid", partName = "removeObject.tid") Long tid,
		@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * Set the String value of an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
		@WebParam(name = "tid", partName = "setStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws ServerException, UserException;

	/**
	 * Set the String value at a certain index in a list of an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setStringAttributeAtIndex")
	void setStringAttributeAtIndex(
		@WebParam(name = "tid", partName = "setStringAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "setStringAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setStringAttributeAtIndex.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "setStringAttributeAtIndex.index") Integer index, 
		@WebParam(name = "value", partName = "setStringAttributeAtIndex.value") String value) throws ServerException, UserException;
	
	/**
	 * Set the wrapped value of a String attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setWrappedStringAttribute")
	void setWrappedStringAttribute(
		@WebParam(name = "tid", partName = "setWrappedStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setWrappedStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setWrappedStringAttribute.attributeName") String attributeName, 
		@WebParam(name = "type", partName = "setWrappedStringAttribute.type") String type, 
		@WebParam(name = "value", partName = "setWrappedStringAttribute.value") String value) throws ServerException, UserException;

	/**
	 * Get the String value of an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return The String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getStringAttribute")
	String getStringAttribute(
		@WebParam(name = "tid", partName = "getStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getStringAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Get a list of attributes of type String
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return A list of Strings
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getStringAttributes")
	List<String> getStringAttributes(
		@WebParam(name = "tid", partName = "getStringAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getStringAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getStringAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Set a double attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttribute")
	void setDoubleAttribute(
		@WebParam(name = "tid", partName = "setDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setDoubleAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * Set a double attribute at a specific index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttributeAtIndex")
	void setDoubleAttributeAtIndex(
		@WebParam(name = "tid", partName = "setDoubleAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "setDoubleAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setDoubleAttributeAtIndex.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "setDoubleAttributeAtIndex.index") Integer index, 
		@WebParam(name = "value", partName = "setDoubleAttributeAtIndex.value") Double value) throws ServerException, UserException;
	
	/**
	 * Set a wrapped attribute's double value
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param type Type of the wrapped value
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setWrappedDoubleAttribute")
	void setWrappedDoubleAttribute(
		@WebParam(name = "tid", partName = "setWrappedDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setWrappedDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setWrappedDoubleAttribute.attributeName") String attributeName, 
		@WebParam(name = "type", partName = "setWrappedDoubleAttribute.type") String type, 
		@WebParam(name = "value", partName = "setWrappedDoubleAttribute.value") Double value) throws ServerException, UserException;
	
	/**
	 * Set a list of double values (for example Coordinates of IfcCartesianPoint)
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param values List of double values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttributes")
	void setDoubleAttributes(
		@WebParam(name = "tid", partName = "setDoubleAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setDoubleAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setDoubleAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setDoubleAttributes.values") List<Double> values) throws ServerException, UserException;
	
	/**
	 * Get a list of double values (for example Coordinates of IfcCartesianPoint)
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return List of double values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDoubleAttribute")
	Double getDoubleAttribute(
		@WebParam(name = "tid", partName = "getDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getDoubleAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * Get a double value of an attribute at a given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index within the list
	 * @return Double value of this attribute
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDoubleAttributeAtIndex")
	Double getDoubleAttributeAtIndex(
		@WebParam(name = "tid", partName = "getDoubleAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "getDoubleAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getDoubleAttributeAtIndex.attributeName") String attributeName,
		@WebParam(name = "index", partName = "getDoubleAttributeAtIndex.index") Integer index) throws ServerException, UserException;
	
	/**
	 * Get a list of double values
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object
	 * @param attributeName Name of the attribute
	 * @return A list of double values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDoubleAttributes")
	List<Double> getDoubleAttributes(
		@WebParam(name = "tid", partName = "getDoubleAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getDoubleAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getDoubleAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Set an enum attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Enum value (name of the enum item)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setEnumAttribute")
	void setEnumAttribute(
		@WebParam(name = "tid", partName = "setEnumAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setEnumAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setEnumAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setEnumAttribute.value") String value) throws ServerException, UserException;

	/**
	 * Get an enum attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return Enum value (as String)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getEnumAttribute")
	String getEnumAttribute(
		@WebParam(name = "tid", partName = "getEnumAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getEnumAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getEnumAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Set an integer attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
		@WebParam(name = "tid", partName = "setIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws ServerException, UserException;

	/**
	 * Set an integer attribute at a given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index within the list
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttributeAtIndex")
	void setIntegerAttributeAtIndex(
		@WebParam(name = "tid", partName = "setIntegerAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "setIntegerAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setIntegerAttributeAtIndex.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "setIntegerAttributeAtIndex.index") Integer index, 
		@WebParam(name = "value", partName = "setIntegerAttributeAtIndex.value") Integer value) throws ServerException, UserException;

	/**
	 * Set a warpped integer attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param type Type of the wrapped object
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setWrappedIntegerAttribute")
	void setWrappedIntegerAttribute(
		@WebParam(name = "tid", partName = "setWrappedIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setWrappedIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setWrappedIntegerAttribute.attributeName") String attributeName, 
		@WebParam(name = "type", partName = "setWrappedIntegerAttribute.type") String type, 
		@WebParam(name = "value", partName = "setWrappedIntegerAttribute.value") Integer value) throws ServerException, UserException;
	
	/**
	 * Set a byte[] attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new ByteArray value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setByteArrayAttribute")
	void setByteArrayAttribute(
		@WebParam(name = "tid", partName = "setByteArrayAttribute.tid") Long tid, 
		@WebParam(name = "oid", partName = "setByteArrayAttribute.oid") Long oid,
		@WebParam(name = "attributeName", partName = "setByteArrayAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setByteArrayAttribute.value") Byte[] value) throws UserException, ServerException;

	/**
	 * Set a list of integer attributes
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param values A list of integer values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttributes")
	void setIntegerAttributes(
		@WebParam(name = "tid", partName = "setIntegerAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setIntegerAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setIntegerAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setIntegerAttributes.value") List<Integer> values) throws ServerException, UserException;
	
	/**
	 * Set a long attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setLongAttribute")
	void setLongAttribute(
		@WebParam(name = "tid", partName = "setLongAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setLongAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setLongAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setLongAttribute.value") Long value) throws ServerException, UserException;

	/**
	 * Set a long attribute at a given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index within the list
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setLongAttributeAtIndex")
	void setLongAttributeAtIndex(
		@WebParam(name = "tid", partName = "setLongAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "setLongAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setLongAttributeAtIndex.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "setLongAttributeAtIndex.index") Integer index, 
		@WebParam(name = "value", partName = "setLongAttributeAtIndex.value") Long value) throws ServerException, UserException;

	/**
	 * Set a wrapped long value
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param type Type of the wrapped object
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setWrappedLongAttribute")
	void setWrappedLongAttribute(
		@WebParam(name = "tid", partName = "setWrappedLongAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setWrappedLongAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setWrappedLongAttribute.attributeName") String attributeName, 
		@WebParam(name = "type", partName = "setWrappedLongAttribute.type") String type, 
		@WebParam(name = "value", partName = "setWrappedLongAttribute.value") Long value) throws ServerException, UserException;
	
	/**
	 * Set a list of long attributes
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param values List of long values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setLongAttributes")
	void setLongAttributes(
		@WebParam(name = "tid", partName = "setLongAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setLongAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setLongAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setLongAttributes.value") List<Long> values) throws ServerException, UserException;
	
	/**
	 * Get an integer attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return Integer value of attribute
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIntegerAttribute")
	Integer getIntegerAttribute(
		@WebParam(name = "tid", partName = "getIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getIntegerAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * Get an integer attribute at the given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index of the value to get
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIntegerAttributeAtIndex")
	Integer getIntegerAttributeAtIndex(
		@WebParam(name = "tid", partName = "getIntegerAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "getIntegerAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getIntegerAttributeAtIndex.attributeName") String attributeName,
		@WebParam(name = "index", partName = "getIntegerAttributeAtIndex.index") Integer index) throws ServerException, UserException;
	
	/**
	 * Get a byte[] attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return byte[] value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getByteArrayAttribute")
	byte[] getByteArrayAttribute(
		@WebParam(name = "tid", partName = "getByteArrayAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getByteArrayAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getByteArrayAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * Get a list of byte[] values
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return List of byte[] values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getByteArrayAttributes")
	List<byte[]> getByteArrayAttributes(
		@WebParam(name = "tid", partName = "getByteArrayAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getByteArrayAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getByteArrayAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Get a list of integer attributes
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return List of integer attributes
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIntegerAttributes")
	List<Integer> getIntegerAttributes(
		@WebParam(name = "tid", partName = "getIntegerAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getIntegerAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getIntegerAttributes.attributeName") String attributeName) throws ServerException, UserException;
		
	/**
	 * Get a long value of an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return Long value of attribute
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLongAttribute")
	Long getLongAttribute(
		@WebParam(name = "tid", partName = "getLongAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getLongAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getLongAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Get a long attribute at a given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return Long value at index
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLongAttributeAtIndex")
	Long getLongAttributeAtIndex(
		@WebParam(name = "tid", partName = "getLongAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "getLongAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getLongAttributeAtIndex.attributeName") String attributeName,
		@WebParam(name = "index", partName = "getLongAttributeAtIndex.index") Integer index) throws ServerException, UserException;
	
	/**
	 * Set a boolean attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
		@WebParam(name = "tid", partName = "setBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * Set a boolean attribute at the given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index within the list
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttributeAtIndex")
	void setBooleanAttributeAtIndex(
		@WebParam(name = "tid", partName = "setBooleanAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "setBooleanAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setBooleanAttributeAtIndex.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "setBooleanAttributeAtIndex.index") Integer index, 
		@WebParam(name = "value", partName = "setBooleanAttributeAtIndex.value") Boolean value) throws ServerException, UserException;

	/**
	 * Set a wrapped boolean attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param type Type of the wrapped object
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setWrappedBooleanAttribute")
	void setWrappedBooleanAttribute(
		@WebParam(name = "tid", partName = "setWrappedBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setWrappedBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setWrappedBooleanAttribute.attributeName") String attributeName, 
		@WebParam(name = "type", partName = "setWrappedBooleanAttribute.type") String type, 
		@WebParam(name = "value", partName = "setWrappedBooleanAttribute.value") Boolean value) throws ServerException, UserException;
	
	/**
	 * Set a list of boolean attributes
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param values A list of boolean values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttributes")
	void setBooleanAttributes(
		@WebParam(name = "tid", partName = "setBooleanAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setBooleanAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setBooleanAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setBooleanAttributes.values") List<Boolean> values) throws ServerException, UserException;

	/**
	 * Get a boolean value of an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object
	 * @param attributeName Name of the attribute
	 * @return Boolean value of attribute
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getBooleanAttribute")
	Boolean getBooleanAttribute(
		@WebParam(name = "tid", partName = "getBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getBooleanAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Retrieve a boolean attribute at the given index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param index Index of the attribute
	 * @return A Boolean value of the given index
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getBooleanAttributeAtIndex")
	Boolean getBooleanAttributeAtIndex(
		@WebParam(name = "tid", partName = "getBooleanAttributeAtIndex.tid") Long tid,
		@WebParam(name = "oid", partName = "getBooleanAttributeAtIndex.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getBooleanAttributeAtIndex.attributeName") String attributeName,
		@WebParam(name = "index", partName = "getBooleanAttributeAtIndex.index") Integer index) throws ServerException, UserException;
	
	/**
	 * Retrieve a list of boolean attributes
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @return A list of boolean values
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getBooleanAttributes")
	List<Boolean> getBooleanAttributes(
		@WebParam(name = "tid", partName = "getBooleanAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getBooleanAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getBooleanAttributes.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * Set a reference
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setReference")
	void setReference(
		@WebParam(name = "tid", partName = "setReference.tid") Long tid,
		@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
		@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid) throws ServerException, UserException;

	/**
	 * Get a reference
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @return ObjectID of the referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getReference")
	Long getReference(
		@WebParam(name = "tid", partName = "getReference.tid") Long tid,
		@WebParam(name = "oid", partName = "getReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "getReference.referenceName") String referenceName) throws ServerException, UserException;

	/**
	 * Get a list of references
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @return A list of ObjectID's
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getReferences")
	List<Long> getReferences(
		@WebParam(name = "tid", partName = "getReferences.tid") Long tid,
		@WebParam(name = "oid", partName = "getReferences.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "getReferences.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * Unset an attribute
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to unset
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
		@WebParam(name = "tid", partName = "unsetAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * Unset a reference
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference to unset (null)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetReference")
	void unsetReference(
		@WebParam(name = "tid", partName = "unsetReference.tid") Long tid,
		@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
		@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * Add a String attribute. Will be added at the end of the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
		@WebParam(name = "tid", partName = "addStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws ServerException, UserException;

	/**
	 * Add a double attribute. Will be added at the end of the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDoubleAttribute")
	void addDoubleAttribute(
		@WebParam(name = "tid", partName = "addDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addDoubleAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * Add an integer attribute. Will be added at the end of the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
		@WebParam(name = "tid", partName = "addIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws ServerException, UserException;

	/**
	 * Add a boolean attribute. Will be added at the end of the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
		@WebParam(name = "tid", partName = "addBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * Add a reference to a list. Will be added at the end of the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference to add a reference to
	 * @param referenceOid ObjectID of the referenced Object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addReference")
	void addReference(
		@WebParam(name = "tid", partName = "addReference.tid") Long tid,
		@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
		@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid) throws ServerException, UserException;
	
	/**
	 * Remove an attribute from a list at a certain index
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
		@WebParam(name = "tid", partName = "removeAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws ServerException, UserException;
	
	/**
	 * Remove a single reference by it's index in the list
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeReference")
	void removeReference(
		@WebParam(name = "tid", partName = "removeReference.tid") Long tid,
		@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
		@WebParam(name = "index", partName = "removeReference.index") Integer index) throws ServerException, UserException;

	/**
	 * Remove a single reference by it's oid
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @param referencedOid Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeReferenceByOid")
	void removeReferenceByOid(
			@WebParam(name = "tid", partName = "removeReference.tid") Long tid,
			@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
			@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
			@WebParam(name = "referencedOid", partName = "removeReference.referencedOid") Long referencedOid) throws ServerException, UserException;

	/**
	 * Remove all references (clear the list of references) of the given object + reference
	 * 
	 * @param tid The TransactionID
	 * @param oid ObjectID of the object
	 * @param referenceName Name of the reference from which to remove all references
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeAllReferences")
	void removeAllReferences(
		@WebParam(name = "tid", partName = "removeAllReferences.tid") Long tid,
		@WebParam(name = "oid", partName = "removeAllReferences.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "removeAllReferences.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * Get an object from the given revision as a Data Object
	 * 
	 * @param roid ObjectID of the Revision
	 * @param oid ObjectID of the object to get
	 * @return An SDataObject
	 * @throws ServerException, UserException
	 */
	@Deprecated
	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(
		@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
		@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid) throws ServerException, UserException;

	/**
	 * Get all the objects matching the given GUIDs as Data Objects
	 * 
	 * @param roid ObjectID of the Revision
	 * @param guid An IFC GUID
	 * @return The object with the given GUID in the given Revision, of null if not found
	 * @throws ServerException, UserException
	 */
	@Deprecated
	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(
		@WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
		@WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws ServerException, UserException;

	/**
	 * Get all the objects of a certain type in Data Objects
	 * 
	 * @param roid ObjectID of the Revision
	 * @param className Name of the class to query (e.g. "IfcWindow")
	 * @return A list of DataObjects from the given Revision matching the given class
	 * @throws ServerException, UserException
	 */
	@Deprecated
	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(
		@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
		@WebParam(name = "packageName", partName = "getDataObjectsByType.packageName") String packageName,
		@WebParam(name = "className", partName = "getDataObjectsByType.className") String className,
		@WebParam(name = "flat", partName = "getDataObjectsByType.flat") Boolean flat) throws ServerException, UserException;

	/**
	 * Get all the objects of a certain revision in Data Objects
	 * 
	 * @param roid ObjectID of the Revision
	 * @return A list of DataObjects from the given Revision
	 * @throws ServerException, UserException
	 */
	@Deprecated
	@WebMethod(action = "getDataObjects")
	List<SDataObject> getDataObjects(
		@WebParam(name = "roid", partName = "getDataObjects.roid") Long roid) throws ServerException, UserException;
	
	/**
	 * Count the amount of object a certain revision has of the given type
	 * 
	 * @param roid ObjectID of the Revision
	 * @param className Name of the type to query
	 * @return The amount of objects found
	 * @throws UserException, ServerException
	 */
	@WebMethod(action = "count")
	Integer count(
		@WebParam(name = "roid", partName = "count.roid") Long roid,
		@WebParam(name = "className", partName = "count.className") String className) throws UserException, ServerException;
}