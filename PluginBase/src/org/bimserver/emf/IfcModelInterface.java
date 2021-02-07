package org.bimserver.emf;

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

import java.io.IOException;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.plugins.ObjectAlreadyStoredException;
import org.bimserver.shared.PluginClassLoaderProvider;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.BiMap;

/**
 * @author Ruben de Laat
 *
 * 
 */
public interface IfcModelInterface extends Iterable<IdEObject>, ObjectFactory, AutoCloseable {

	/**
	 * Retrieve an object by its GUID
	 * @param guid
	 * @return An object of a subclass of IfcRoot, or null if the object does not exist in this model
	 */
	IdEObject getByGuid(String guid);

	/**
	 * Retrieve an object by its name
	 * @param eClass The type of the object
	 * @param name The name of the object
	 * @return The object, or null if it is not in the model
	 */
	IdEObject getByName(EClass eClass, String name);

	/**
	 * Retrieve an object by its OID
	 * @param oid
	 * @return The object with the given OID, or null if the object does not exist in this model
	 */
	IdEObject get(long oid);
	
	/**
	 * Retrieve a set of all the GUIDs of the objects of a certain type
	 * @param eClass The type to look for
	 * @return A Set<String> containing all the GUIDs
	 */
	Set<String> getGuids(EClass eClass);

	/**
	 * Retrieve a set of all the names of the objects of a certain type
	 * @param eClass The type to look for
	 * @return A Set<String> containing all the names
	 */
	Set<String> getNames(EClass eClass);
	
	
	/**
	 * Retrieve the size of the model
	 * @return The amount of objects in the model
	 */
	long size();
	
	/**
	 * Tests if this model has a certain GUID
	 * @param referredGuid
	 * @return true if the model has an object with the given GUID, false if it has not
	 */
	boolean containsGuid(String referredGuid);

	/**
	 * Tests whether this model has a certain OID
	 * @param oid
	 * @return true if the model has an object with the given OID, false if it has not
	 */
	boolean contains(long oid);

	/**
	 * Count the amount of objects of the given type
	 * @param eClass The type to query
	 * @return The amount of objects of the given type
	 */
	int count(EClass eClass);
	
	/**
	 * @return All objects in this model as a Collection<IdEObject>
	 */
	Collection<IdEObject> getValues();

	/**
	 * @return A BiMap<Long, IdEObject> with all objects in this model
	 */
	BiMap<Long, IdEObject> getObjects();

	/**
	 * @return All OID's in this model
	 */
	Set<Long> keySet();

	/**
	 * @param clazz The type to query for
	 * @return A List with all the objects in this model of the given type, instances of subtypes are not included
	 */
	<T extends IdEObject> List<T> getAll(Class<T> clazz);

	/**
	 * @param clazz The type to query for
	 * @return A List with all the objects in this model of the given type, instances of subtypes are not included
	 */
	<T extends IdEObject> List<T> getAll(EClass clazz);
	
	/**
	 * @param clazz The type to query for 
	 * @return A List with all the objects in this model of the given type, instances of subtypes are included
	 */
	<T extends IdEObject> List<T> getAllWithSubTypes(Class<T> clazz);

	/**
	 * @param eClass The type to query for
	 * @return A List with all the objects in this model of the given type, instances of subtypes are included
	 */
	<T extends IdEObject> List<T> getAllWithSubTypes(EClass eClass);

	/** Tests whether the given object is part of this model
	 * @param referencedObject
	 * @return Whether the given object is part of this model
	 */
	boolean contains(IdEObject referencedObject);

	/**
	 * Add an object to this model with an explicit OID, only use this method in BIMserver internal code
	 * @param oid The given OID
	 * @param newObject The new object to add to this model
	 * @throws IfcModelInterfaceException
	 * @throws ObjectAlreadyStoredException 
	 */
	void add(long oid, IdEObject newObject) throws ObjectAlreadyExistsException;
	
	/**
	 * Add an object to this model with an explicit OID, allow the object to exist in multiple models, only use this method in BIMserver internal code
	 * @param oid The given OID
	 * @param newObject The new object to add to this model
	 * @throws IfcModelInterfaceException
	 * @throws ObjectAlreadyStoredException 
	 */
	void addAllowMultiModel(long oid, IdEObject newObject) throws IfcModelInterfaceException, ObjectAlreadyExistsException;

	/**
	 * Remove an object
	 * @param objectToRemove The object to remove from this model
	 */
	void remove(IdEObject objectToRemove);

	/**
	 * @return The ModelMetaData of this model
	 */
	ModelMetaData getModelMetaData();
	
	void fixOids(OidProvider oidProvider);
	void fixOidsFlat(OidProvider oidProvider);
	void setObjectOids();
	void indexGuids();
	long getHighestOid();
	void resetOids();
	void resetOidsFlat();
	boolean isValid();
	void checkDoubleOidsPlusReferences();
	void fixOidCounter();
	void setUseDoubleStrings(boolean useDoubleStrings);
	boolean isUseDoubleStrings();
	void changeOid(IdEObject object);
	void fixOids();
	void generateMinimalExpressIds();

	void fixInverseMismatches();
	
	Collection<IdEObject> getUnidentifiedValues();
	int countWithSubtypes(EClass eClass);

	void clear();

	void resetExpressIds();

	IfcModelInterface branch(long poid, boolean recordChanges);

	long commit(String comment) throws ServerException, UserException, PublicInterfaceNotFoundException;

	<T extends IdEObject> T create(Class<T> class1, OidProvider oidProvider) throws IfcModelInterfaceException, ObjectAlreadyExistsException;
	<T extends IdEObject> T create(EClass eClass, OidProvider oidProvider) throws IfcModelInterfaceException, ObjectAlreadyExistsException;
	
	PackageMetaData getPackageMetaData();
	Map<Integer, Long> getPidRoidMap();

	void set(IdEObject idEObject, EStructuralFeature eFeature, Object newValue);

	void checkin(long poid, String comment) throws ServerException, UserException, PublicInterfaceNotFoundException;

	<T extends IdEObject> T create(EClass eClass, long oid) throws IfcModelInterfaceException;

	<T extends IdEObject> T createAndAdd(Class<T> class1) throws IfcModelInterfaceException, ObjectAlreadyExistsException;

	boolean containsNoFetch(long oid);

	IdEObject getNoFetch(long oid);

	void load(IdEObject idEObject);

	Set<EClass> getUsedClasses();

	void query(ObjectNode query, boolean assumeCompletePreload) throws ServerException, UserException, PublicInterfaceNotFoundException, IfcModelInterfaceException, IOException;

	<T extends IdEObject> T createAndAdd(EClass eClass, long oid) throws IfcModelInterfaceException, ObjectAlreadyExistsException;

	<T extends IdEObject> T createAndAdd(EClass eClass) throws IfcModelInterfaceException, ObjectAlreadyExistsException;

	<T extends IdEObject> T getFirst(Class<T> class1);

	<T extends IdEObject> T getFirst(EClass eClass);

	void dumpDebug();
}