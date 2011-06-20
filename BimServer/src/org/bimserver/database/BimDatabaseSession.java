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

	<T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries, ProgressHandler progressHandler) throws BimDatabaseException, UserException;

	<T> T executeAndCommitAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	<T> T executeAction(BimDatabaseAction<T> action, int retries) throws BimDatabaseException, UserException;

	void close();

	int newPid();

	long store(IdEObject eObject, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	long store(IdEObject eObject) throws BimDeadlockException, BimDatabaseException;

	void clearProject(int pid, int oldRid, int newRid) throws BimDeadlockException, BimDatabaseException;

	void store(Collection<? extends IdEObject> values, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	void store(Collection<? extends IdEObject> values) throws BimDeadlockException, BimDatabaseException;

	void getMap(IfcModel ifcModel, int pid, int rid, boolean deep) throws BimDeadlockException, BimDatabaseException;

	EClass getEClassForName(String className);

	IdEObject get(short cid, long oid, boolean deep) throws BimDeadlockException, BimDatabaseException;

	IdEObject get(short cid, long oid, int pid, int rid, IfcModel model, boolean deep) throws BimDeadlockException, BimDatabaseException;

	Object convert(EClassifier type, String string);

	long getOid(IdEObject originalObject);

	void putInCache(RecordIdentifier recordIdentifier, IdEObject object);

	IfcModel getMapWithOid(int pid, int rid, short cid, long oid, IfcModel model, boolean deep) throws BimDeadlockException, BimDatabaseException;

	void getMapWithOids(IfcModel ifcModel, int pid, int rid, Set<Long> oids, boolean deep) throws BimDeadlockException, BimDatabaseException;

	IfcModel getMapWithObjectIdentifiers(int pid, int rid, Set<ObjectIdentifier> oids, boolean deep) throws BimDeadlockException, BimDatabaseException;

	<T extends IdEObject> Map <Long, T> query(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> Map <Long, T> query(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	<T extends IdEObject> T querySingle(int pid, int rid, Condition condition, Class<T> clazz, boolean deep) throws BimDatabaseException, BimDeadlockException;

	DatabaseInformation getDatabaseInformation() throws BimDatabaseException, BimDeadlockException;

	Date getCreatedDate() throws BimDatabaseException, BimDeadlockException;

	ObjectIdentifier getOidOfGuid(String guid, int pid, int rid) throws BimDeadlockException, BimDatabaseException;

	IfcModel getAllOfType(String className, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException;

	IfcModel getAllOfType(EClass eClass, int pid, int rid, boolean deep) throws BimDatabaseException, BimDeadlockException;

	Collection<EClass> getClasses();

	List<String> getClassList();

	void commit(ProgressHandler progressHandler) throws BimDeadlockException, BimDatabaseException;

	int getCount(EClass eClass, IfcModel model, int pid, int rid) throws BimDatabaseException, BimDeadlockException;

	EClass getEClassForCid(short cid);

	short getCidForClassName(String className);

	void clearCache();

	short getCid(EClass eClass) throws BimDatabaseException;

	<T extends IdEObject> T get(EClass eClass, long oid, boolean deep);

	void addPostCommitAction(PostCommitAction postCommitAction);

	long newOid();

	short getCidOfEClass(EClass revision);

	IfcModel getAllOfType(EClass settings, boolean deep) throws BimDatabaseException, BimDeadlockException;

	void commit() throws BimDeadlockException, BimDatabaseException;

	BimDatabaseSession newSession(boolean useTransaction);

	void delete(IdEObject object);

	MetaDataManager getMetaDataManager();
}