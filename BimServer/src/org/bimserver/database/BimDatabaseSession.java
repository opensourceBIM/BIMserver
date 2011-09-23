package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 *****************************************************************************/

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.MetaDataManager;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public interface BimDatabaseSession extends OidProvider {

	void addPostCommitAction(PostCommitAction postCommitAction);

	void clearCache();

	void clearProject(int pid, int oldRid, int newRid) throws BimDeadlockException, BimDatabaseException;

	void close();

	void commit() throws BimDeadlockException, BimDatabaseException;

	void commit(ProgressHandler progressHandler) throws BimDeadlockException, BimDatabaseException;

	Object convert(EClassifier type, String string);

	void delete(IdEObject object);

	<T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	<T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	<T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries, ProgressHandler progressHandler) throws BimDatabaseException, UserException;

	<T extends IdEObject> T get(EClass eClass, long oid, boolean deep, GuidanceProvider guidanceProvider);

	<T extends IdEObject> T get(EClass eClass, int pid, int rid, long oid, boolean deep, GuidanceProvider guidanceProvider);

	<T extends IdEObject> T get(short cid, long oid, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	<T extends IdEObject> T  get(short cid, long oid, int pid, int rid, IfcModel model, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	IfcModel getAllOfType(EClass eClass, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	IfcModel getAllOfType(EClass eClass, int pid, int rid, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	IfcModel getAllOfType(String className, int pid, int rid, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	short getCid(EClass eClass) throws BimDatabaseException;

	short getCidForClassName(String className);

	short getCidOfEClass(EClass revision);

	Collection<EClass> getClasses();

	List<String> getClassList();

	int getCount(EClass eClass, IfcModel model, int pid, int rid) throws BimDatabaseException, BimDeadlockException;

	Date getCreatedDate() throws BimDatabaseException, BimDeadlockException;

	DatabaseInformation getDatabaseInformation() throws BimDatabaseException, BimDeadlockException;

	EClass getEClassForCid(short cid);

	EClass getEClassForName(String className);

	void getMap(IfcModel ifcModel, int pid, int rid, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	IfcModel getMapWithObjectIdentifiers(int pid, int rid, Set<ObjectIdentifier> oids, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	IfcModel getMapWithOid(int pid, int rid, short cid, long oid, IfcModel model, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	void getMapWithOids(IfcModel ifcModel, int pid, int rid, Set<Long> oids, boolean deep, GuidanceProvider guidanceProvider) throws BimDeadlockException, BimDatabaseException;

	MetaDataManager getMetaDataManager();

	long getOid(IdEObject originalObject);

	ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	long newOid();

	int newPid();

	BimDatabaseSession newSession(boolean useTransaction);

	void putInCache(RecordIdentifier recordIdentifier, IdEObject object);

	<T extends IdEObject> Map <Long, T> query(Condition condition, Class<T> clazz, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> Map <Long, T> query(int pid, int rid, Condition condition, Class<T> clazz, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz, boolean deep, GuidanceProvider guidanceProvider) throws BimDatabaseException, BimDeadlockException;

	void store(Collection<? extends IdEObject> values) throws BimDeadlockException, BimDatabaseException;

	void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	long store(IdEObject eObject) throws BimDeadlockException, BimDatabaseException;

	long store(IdEObject eObject, int pid, int rid) throws BimDeadlockException, BimDatabaseException;
}