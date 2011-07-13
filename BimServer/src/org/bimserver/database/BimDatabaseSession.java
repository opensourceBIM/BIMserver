package org.bimserver.database;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.MetaDataManager;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.PostCommitAction;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.plugins.serializers.OidProvider;
import org.bimserver.shared.DatabaseInformation;
import org.bimserver.shared.UserException;
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

	<T extends IdEObject> T get(EClass eClass, long oid, boolean deep);

	<T extends IdEObject> T get(EClass eClass, int pid, int rid, long oid, boolean deep);

	<T extends IdEObject> T get(short cid, long oid, boolean deep) throws BimDeadlockException, BimDatabaseException;

	<T extends IdEObject> T  get(short cid, long oid, int pid, int rid, IfcModel model, boolean deep) throws BimDeadlockException, BimDatabaseException;

	IfcModel getAllOfType(EClass settings, boolean deep) throws BimDatabaseException, BimDeadlockException;

	IfcModel getAllOfType(EClass eClass, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException;

	IfcModel getAllOfType(String className, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException;

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

	void getMap(IfcModel ifcModel, int pid, int rid, boolean deep) throws BimDeadlockException, BimDatabaseException;

	IfcModel getMapWithObjectIdentifiers(int pid, int rid, Set<ObjectIdentifier> oids, boolean deep) throws BimDeadlockException, BimDatabaseException;

	IfcModel getMapWithOid(int pid, int rid, short cid, long oid, IfcModel model, boolean deep) throws BimDeadlockException, BimDatabaseException;

	void getMapWithOids(IfcModel ifcModel, int pid, int rid, Set<Long> oids, boolean deep) throws BimDeadlockException, BimDatabaseException;

	MetaDataManager getMetaDataManager();

	long getOid(IdEObject originalObject);

	ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	long newOid();

	int newPid();

	BimDatabaseSession newSession(boolean useTransaction);

	void putInCache(RecordIdentifier recordIdentifier, IdEObject object);

	<T extends IdEObject> Map <Long, T> query(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> Map <Long, T> query(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	void store(Collection<? extends IdEObject> values) throws BimDeadlockException, BimDatabaseException;

	void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	long store(IdEObject eObject) throws BimDeadlockException, BimDatabaseException;

	long store(IdEObject eObject, int pid, int rid) throws BimDeadlockException, BimDatabaseException;
}