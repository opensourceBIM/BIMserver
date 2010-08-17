package org.bimserver.database;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.shared.Addition;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public interface BimDatabaseSession {

	<T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	<T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	void close();

	Collection<Project> getProjectsByName(String name) throws BimDeadlockException, BimDatabaseException;

	int newPid();

	User getAdminUser() throws BimDeadlockException, BimDatabaseException;

	void savePidCounter() throws BimDeadlockException;

	void saveOidCounter() throws BimDeadlockException;

	long store(IdEObject eObject, CommitSet commitSet) throws BimDeadlockException;

	void saveUidCounter() throws BimDeadlockException;

	User getUserByUserName(String name) throws BimDeadlockException, BimDatabaseException;

	Project getProjectById(int pid) throws BimDeadlockException, BimDatabaseException;

	ConcreteRevision createNewConcreteRevision(long size, long poid, long actingUoid, String comment) throws BimDeadlockException, BimDatabaseException;

	void clearProject(int pid, int oldRid, int newRid) throws BimDeadlockException;

	void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException;

	ConcreteRevision getConcreteRevision(long croid) throws BimDeadlockException, BimDatabaseException;

	Revision getVirtualRevision(long roid) throws BimDeadlockException, BimDatabaseException;

	ReadSet getMap(int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	EClass getEClassForName(String className);

	void convertAdditionToEObject(IdEObject object, Addition addition, Map<Long, IdEObject> processedAdditions, Map<Long, IdEObject> map);

	IdEObject get(short cid, long oid, ReadSet readSet) throws BimDeadlockException, BimDatabaseException;

	Object convert(EClassifier type, String string);

	long getOid(IdEObject originalObject);

	void putInCache(RecordIdentifier recordIdentifier, IdEObject object);

	ReadSet getMapWithOid(int pid, int id, long oid) throws BimDeadlockException, BimDatabaseException;

	<T extends IdEObject> Map <Long, T> query(int pid, int rid, Condition condition, Class<T> clazz) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz) throws BimDatabaseException, BimDeadlockException;

	DatabaseInformation getDatabaseInformation() throws BimDatabaseException, BimDeadlockException;

	ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException;

	ReadSet getAllOfType(String className, int pid, int rid) throws BimDatabaseException, BimDeadlockException;

	Collection<EClass> getClasses();

	List<String> getClassList();

	void updateLastActive(long uoid);

	void commit() throws BimDeadlockException, BimDatabaseException;

	int getCount(EClass eClass, ReadSet readSet) throws BimDatabaseException, BimDeadlockException;

	EClass getEClassForCid(short cid);

	short getCidForClassName(String className);

	void clearCache();

	void saveGidCounter() throws BimDeadlockException;

	User getUserByUoid(long uoid);

	Project getProjectByPoid(long poid);

	short getCid(EClass eClass);

	Revision getRevisionByRoid(long roid);

	IdEObject get(EClass geoTag, long oid);

	User getAnonymousUser() throws BimDatabaseException, BimDeadlockException;
}