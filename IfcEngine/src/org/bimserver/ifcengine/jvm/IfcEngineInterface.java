package org.bimserver.ifcengine.jvm;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * @author wspa
 * 
 */
public interface IfcEngineInterface extends Library {
	IfcEngineInterface INSTANCE = (IfcEngineInterface) Native.loadLibrary(
			"IFCEngine", IfcEngineInterface.class);
	// Optional: wraps every call to the native library in a
	// synchronized block, limiting native calls to one at a time
	// IfcEngineInterface SYNC_INSTANCE = (IfcEngineInterface) Native
	// .synchronizedLibrary(INSTANCE);

	interface StreamCallback extends Callback {
		int invoke(Pointer pointer);
	}

	Pointer xxxxOpenModelByStream(int repository, StreamCallback callbackAddress, String schemaName);

	/**
	 * Change the number of segments a circle should be represented as.
	 * 
	 * @param circles
	 *            The count of segments for each circle or circle part (by
	 *            default 30). 0 is ignored.
	 * @param smallCircles
	 *            The count of segments for less important circle(parts), like
	 *            circles between the legs in a I, T, U or L profile structure
	 *            (by default 5). 0 is ignored.
	 */
	void circleSegments(int circles, int smallCircles);

	/**
	 * Returns a data field in the actual aggregate element.
	 * 
	 * @param aggregate
	 *            Existing aggregation
	 * @param elementIndex
	 *            Position in the existing aggregation, first position is 0
	 * @param valueType
	 *            Type of output value
	 * @param ptr
	 *            Output value of the specific element in the aggregation
	 */
	void engiGetAggrElement(Pointer aggregate, int elementIndex, int valueType,
			PointerByReference ptr);

	void engiGetAggrElement(Pointer aggregate, int elementIndex, int valueType,
			DoubleByReference ptr);

	void engiGetAggrElement(Pointer aggregate, int elementIndex, int valueType,
			IntByReference ptr);

	/**
	 * Returns the class name as used in the SPFF file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance
	 * @return class name
	 */
	String engiGetInstanceClassInfo(Pointer instance);

	/**
	 * Returns the UPPER CASE version of the class name as used in the Schema
	 * file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return UPPER CASE version of the class name
	 */
	String engiGetInstanceClassInfoUC(Pointer instance);

	/**
	 * Returns the line number as used for this instance in the SPFF file.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return line number
	 */
	int engiGetInstanceLocalId(Pointer instance);

	/**
	 * Returns 'meta' information from a specific instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param localId
	 *            number used for this instance in the SPFF file.
	 * @param className
	 *            as used in the SPFF file.
	 * @param classNameUC
	 *            UPPER CASE version of the class name (as used in the schema).
	 * @return
	 */
	int engiGetInstanceMetaInfo(Pointer instance, IntByReference localId,
			PointerByReference className, PointerByReference classNameUC);

	/**
	 * @param modelId
	 * @param pG1
	 * @param pG2
	 */
	void finalizeClashesByGuid(Pointer modelId, Pointer pG1, Pointer pG2);

	/**
	 * @param modelId
	 * @param pG1
	 * @param pG2
	 */
	void finalizeClashesByEI(Pointer modelId, Pointer pG1, Pointer pG2);

	/**
	 * @param model
	 * @param pV
	 * @param pI
	 * @param scale
	 * @param instance
	 * @return
	 */
	int initializeModellingInstance(Pointer model, IntByReference pV,
			IntByReference pI, double scale, Pointer instance);

	int initializeModelling(Pointer model, IntByReference pV,
			IntByReference pI, double scale);

	void initializeClashes(Pointer model, IntByReference pV, double diff);

	void setPostProcessing(Pointer model, int on);

	public int internalGetP21Line(Pointer instanceId);

	public Pointer internalGetInstanceFromP21Line(int expressId);

	
	/**
	 * @param model
	 * @param pV
	 * @param pI
	 * @param scale
	 * @param instance
	 * @param instanceList
	 * @return
	 */
	int initializeModellingInstanceEx(Pointer model, IntByReference pV,
			IntByReference pI, double scale, Pointer instance,
			Pointer instanceList);

	/**
	 * @param model
	 * @param pV
	 * @param pI
	 * @param fvf
	 * @return
	 */
	int finalizeModelling(Pointer model, Pointer pV, Pointer pI, int fvf);

	/**
	 * @param model
	 * @param instance
	 * @param mode
	 * @param pV
	 * @param pI
	 * @param pC
	 * @return
	 */
	Pointer getInstanceInModelling(Pointer model, Pointer instance, int mode,
			IntByReference pV, IntByReference pI, IntByReference pC);

	/**
	 * Returns an integer representing internal 'clock'.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @return an integer representing internal 'clock'.
	 */
	int getTimeStamp(Pointer model);

	/**
	 * @param model
	 * @param timeStamp
	 * @return
	 */
	String getChangedData(Pointer model, int timeStamp);

	/**
	 * @param model
	 * @param timeStamp
	 * @param changedData
	 */
	void setChangedData(Pointer model, int timeStamp, String changedData);

	/**
	 * @param unicode
	 * @return
	 */
	int setStringUnicode(boolean unicode);

	/**
	 * @param model
	 * @param instance
	 * @return
	 */
	Pointer internalGetBoundingBox(Pointer model, Pointer instance);

	/**
	 * @param model
	 * @param instance
	 * @return
	 */
	Pointer internalGetCenter(Pointer model, Pointer instance);

	/**
	 * @param instance
	 * @param attributeName
	 * @param linked_id
	 */
	void internalSetLink(Pointer instance, String attributeName, int linked_id);

	void internalAddAggrLink(int list, int linked_id);

	/**
	 * @param model
	 * @param instance
	 * @param pH
	 * @param pW
	 * @param pT
	 * @return
	 */
	int getInstanceDerivedPropertiesInModelling(int model, Pointer instance,
			DoubleByReference pH, DoubleByReference pW, DoubleByReference pT);

	/**
	 * @param model
	 * @param instance
	 * @param pOx
	 * @param pOy
	 * @param pOz
	 * @param pVx
	 * @param pVy
	 * @param pVz
	 * @return
	 */
	int _getInstanceDerivedBoundingBox(Pointer model, Pointer instance,
			DoubleByReference pOx, DoubleByReference pOy,
			DoubleByReference pOz, DoubleByReference pVx,
			DoubleByReference pVy, DoubleByReference pVz);

	/**
	 * @param model
	 * @param instance
	 * @param p_11
	 * @param p_12
	 * @param p_13
	 * @param p_14
	 * @param p_21
	 * @param p_22
	 * @param p_23
	 * @param p_24
	 * @param p_31
	 * @param p_32
	 * @param p_33
	 * @param p_34
	 * @param p_41
	 * @param p_42
	 * @param p_43
	 * @param p_44
	 * @return
	 */
	int getInstanceDerivedTransformationMatrix(Pointer model, Pointer instance,
			DoubleByReference p_11, DoubleByReference p_12,
			DoubleByReference p_13, DoubleByReference p_14,
			DoubleByReference p_21, DoubleByReference p_22,
			DoubleByReference p_23, DoubleByReference p_24,
			DoubleByReference p_31, DoubleByReference p_32,
			DoubleByReference p_33, DoubleByReference p_34,
			DoubleByReference p_41, DoubleByReference p_42,
			DoubleByReference p_43, DoubleByReference p_44);

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 */
	int sdaiGetAggregationAttrBN(Pointer instance, String attributeName);

	/**
	 * Returns the data value of the specified attribute in the actual instance.
	 * The actual instance is specified by a numeric instanceID that uniquely
	 * identifies an instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @param attributeName
	 *            A character that contains an attribute name existing in the
	 *            mentioned instance.
	 * @param valueType
	 *            Type of output value.
	 * @param ptr
	 *            Output value of the specific element in the aggregation.
	 */
	void sdaiGetAttrBN(Pointer instance, String attributeName, int valueType,
			PointerByReference ptr);

	/**
	 * Returns a numeric entityID that uniquely identifies an entity definition
	 * instance.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric entityID
	 */
	Pointer sdaiGetEntity(Pointer model, String entityName);

	/**
	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
	 * holds all instances of one particular type in a model.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric aggregateID
	 */
	Pointer sdaiGetEntityExtentBN(Pointer model, String entityName);

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 */
	int sdaiGetInstanceAttrBN(Pointer instance, String attributeName);

	/**
	 * Return the instance type of the specified instance. The instance type is
	 * returned as an entityID that uniquely identifies the entity definition
	 * instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 * @return the instance type
	 */
	Pointer sdaiGetInstanceType(Pointer instance);

	/**
	 * Returns the number of elements in the specified aggregate.
	 * 
	 * @param aggregate
	 *            Existing aggregation.
	 * @return the number of elements
	 */
	int sdaiGetMemberCount(Pointer aggregate);

	/**
	 * @param instance
	 * @param attributeName
	 * @return
	 */
	String sdaiGetStringAttrBN(Pointer instance, String attributeName);

	/**
	 * Opens a model and its belonging schema. This functions differs slightly
	 * from the official SDAI definition because the IFC Engine DLL is able to
	 * open repository, model and schema in 1 call. It returns the modelID or
	 * zero if the model could not be created.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model.
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            opened.
	 * @param schemaName
	 *            String containing the name of the schema belonging to the file
	 *            mentioned in fileName. If this string is referring to a
	 *            non-existing file no schema will be loaded, preferred use is
	 *            in that case '' (empty string). If this pointer is empty the
	 *            default schema for this file is loaded (using the knowledge of
	 *            the IFC Engine Viewer).
	 * 
	 * @return modelID
	 */
	Pointer sdaiOpenModelBN(int repository, String fileName, String schemaName);

	/**
	 * Creates a new model instantiated from a specific schema. It returns the
	 * modelID, zero if the model could not be created.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model.
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            created.
	 * @param schemaName
	 *            String containing the name of the schema belonging to the file
	 *            mentioned in fileName. If this string is referring to a
	 *            non-existing file no schema will be loaded, preferred use is
	 *            in that case '' (empty string). If this pointer is empty the
	 *            default schema for this file is loaded (using the knowledge of
	 *            the IFC Engine Viewer).
	 * 
	 * @return modelID
	 */
	int sdaiCreateModelBN(int repository, String fileName, String schemaName);

	/**
	 * Saves an 'in memory' model.
	 * 
	 * @param repository
	 *            Unused, the IFC Engine DLL currently (8 March 2006) only
	 *            supports exactly 1 repository for each model
	 * @param fileName
	 *            String containing the name and path of the file that will be
	 *            saved.
	 */
	void sdaiSaveModelBN(int repository, String fileName);

	/**
	 * @param model
	 * @param fileName
	 */
	void sdaiSaveModelAsXmlBN(Pointer model, String fileName);

	/**
	 * Closes a SPFF (possibly IFC) file. The file will NOT be saved.
	 * 
	 * @param model
	 *            ModelID referring to the model.
	 */
	void sdaiCloseModel(Pointer model);

	void sdaiAppend(int list, int valueType, IntByReference value);

	void sdaiAppend(int list, int valueType, DoubleByReference value);

	void sdaiAppend(int list, int valueType, String value);

	void sdaiAppend(int list, int valueType, Pointer value);

	/**
	 * @param iterator
	 */
	void sdaiBeginning(int iterator);

	Pointer sdaiCreateADB(int valueType, IntByReference value);

	Pointer sdaiCreateADB(int valueType, DoubleByReference value);

	Pointer sdaiCreateADB(int valueType, String value);

	Pointer sdaiCreateADB(int valueType, Pointer value);

	Pointer sdaiCreateAggr(Pointer instance, int attribute);

	Pointer sdaiCreateAggrBN(Pointer instance, String attributeName);

	Pointer sdaiCreateInstance(Pointer model, int entity);

	/**
	 * Creates an instance of a specific schema entity.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            A string that contains a (schema) entity name existing in the
	 *            mentioned model.
	 * @return
	 */
	Pointer sdaiCreateInstanceBN(Pointer model, String entityName);

	/**
	 * Creates an instance of a specific schema entity.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            A string that contains a (schema) entity name existing in the
	 *            mentioned model.
	 * @param express_id
	 * @return
	 */
	Pointer sdaiCreateInstanceBNEI(Pointer model, String entityName,
			int express_id);

	/**
	 * Creates an iterator for an existing aggregation.
	 * 
	 * @param aggregate
	 *            Existing aggregation.
	 * @return
	 */
	Pointer sdaiCreateIterator(Pointer aggregate);

	/**
	 * Deletes an existing instance.
	 * 
	 * @param instance
	 *            A numeric instanceID that uniquely identifies an instance.
	 */
	void sdaiDeleteInstance(Pointer instance);

	/**
	 * Deletes an existing iterator.
	 * 
	 * @param iterator
	 *            Existing iterator.
	 */
	void sdaiDeleteIterator(Pointer iterator);

	/**
	 * Moves the active position in an iterator to the last object.
	 * 
	 * @param iterator
	 *            Existing iterator.
	 */
	void sdaiEnd(Pointer iterator);

	/**
	 * Implementation postponed till version 1.10
	 * 
	 * @return
	 */
	int sdaiErrorQuery();

	void sdaiGetAggrByIterator(Pointer iterator, int valueType,
			IntByReference value);

	void sdaiGetAggrByIterator(Pointer iterator, int valueType,
			DoubleByReference value);

	void sdaiGetAggrByIterator(Pointer iterator, int valueType, String value);

	void sdaiGetAggrByIterator(Pointer iterator, int valueType,
			PointerByReference value);

	void sdaiGetAttr(Pointer instance, int attribute, int valueType,
			IntByReference value);

	void sdaiGetAttr(Pointer instance, int attribute, int valueType,
			DoubleByReference value);

	void sdaiGetAttr(Pointer instance, int attribute, int valueType,
			String value);

	void sdaiGetAttr(Pointer instance, int attribute, int valueType,
			PointerByReference value);

	/**
	 * Returns a numeric attributeID that uniquely identifies an attribute
	 * definition instance.
	 * 
	 * @param entity
	 *            A numeric entityID that uniquely identifies a (schema) entity
	 *            existing in the mentioned model.
	 * @param attributeName
	 *            A string that contains an attribute name existing in the
	 *            mentioned instance.
	 * @return a numeric attributeID
	 */
	Pointer sdaiGetAttrDefinition(Pointer entity, String attributeName);
	
	/**
	 * Returns a numeric aggregateID that uniquely identifies the aggregate that
	 * holds all instances of one particular type and its sub-types in a model.
	 * 
	 * @param model
	 *            Unique number identifying the model in the opened file.
	 * @param entityName
	 *            Name of the Entity.
	 * @return a numeric aggregateID
	 */
	Pointer xxxxGetEntityAndSubTypesExtentBN(Pointer model, String entityName);
}
