package org.bimserver.webservices.impl;

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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.changes.AddAttributeChange;
import org.bimserver.changes.AddReferenceChange;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveAllReferencesChange;
import org.bimserver.changes.RemoveAttributeChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.RemoveReferenceChange;
import org.bimserver.changes.SetAttributeChange;
import org.bimserver.changes.SetAttributeChangeAtIndex;
import org.bimserver.changes.SetReferenceChange;
import org.bimserver.changes.SetWrappedAttributeChange;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.CommitTransactionDatabaseAction;
import org.bimserver.database.actions.CountDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByGuidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectByOidDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsByTypeDatabaseAction;
import org.bimserver.database.actions.GetDataObjectsDatabaseAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.webservices.LongTransaction;
import org.bimserver.webservices.NoTransactionException;
import org.bimserver.webservices.ServiceMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowLevelServiceImpl extends GenericServiceImpl implements LowLevelInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(LowLevelServiceImpl.class);
	
	public LowLevelServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long startTransaction(Long poid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		int pid = -1;
		int rid = -1;
		long roid = -1;
		try {
			Project project = (Project) session.get(poid, OldQuery.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}
			pid = project.getId();
			if (project.getLastRevision() != null) {
				Revision revision = project.getLastRevision();
				ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
				rid = lastConcreteRevision.getId();
				roid = revision.getOid();
			}
			LongTransaction longTransaction = getBimServer().getLongTransactionManager().newLongTransaction(getBimServer().getMetaDataManager().getPackageMetaData(project.getSchema()), poid, pid, rid, roid);
			return longTransaction.getTid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long commitTransaction(Long tid, String comment, Boolean regenerateAllGeometry) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			LongTransaction longTransaction = getBimServer().getLongTransactionManager().get(tid);
			if (longTransaction == null) {
				throw new UserException("No transaction with tid " + tid + " was found");
			}
			CommitTransactionDatabaseAction action = new CommitTransactionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), longTransaction, comment, regenerateAllGeometry);
			try {
				session.executeAndCommitAction(action);
				return action.getRevision().getOid();
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}
		} catch (NoTransactionException e) {
			LOGGER.error("", e);
		}
		return -1L;
	}

	@Override
	public void abortTransaction(Long tid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).close();
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void addStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void addIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void addDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setDoubleAttributes(Long tid, Long oid, String attributeName, List<Double> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setDoubleAttributeAtIndex(Long tid,	Long oid, String attributeName, Integer index, Double value) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChangeAtIndex(oid, attributeName, index, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void setBooleanAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index, Boolean value) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChangeAtIndex(oid, attributeName, index, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setIntegerAttributes(Long tid, Long oid, String attributeName, List<Integer> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setIntegerAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index, Integer value) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChangeAtIndex(oid, attributeName, index, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void setLongAttributes(Long tid, Long oid, String attributeName, List<Long> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void setBooleanAttributes(Long tid, Long oid, String attributeName, List<Boolean> values) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, values));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void addBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new AddAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void addReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new AddReferenceChange(oid, referenceName, referenceOid));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public Long createObject(Long tid, String className, Boolean generateGuid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			LongTransaction longTransaction = getBimServer().getLongTransactionManager().get(tid);
			if (longTransaction == null) {
				throw new UserException("No transaction with tid " + tid + " was found");
			}
			try {
				EClass eClass = ((Database) getBimServer().getDatabase()).getEClass(longTransaction.getPackageMetaData().getEPackage().getName(), className);
				Long oid = getBimServer().getDatabase().newOid(eClass);
				CreateObjectChange createObject = new CreateObjectChange(className, oid, eClass, generateGuid);
				longTransaction.add(createObject);
				return oid;
			} catch (BimserverDatabaseException e) {
				throw new UserException("Unknown type: \"" + className + "\"");
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public void removeAttribute(Long tid, Long oid, String attributeName, Integer index) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new RemoveAttributeChange(oid, attributeName, index));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void removeObject(Long tid, Long oid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new RemoveObjectChange(oid, getBimServer().getDatabase().getEClassForOid(oid)));
		} catch (NoTransactionException e) {
			handleException(e);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		}
	}

	@Override
	public void removeReference(Long tid, Long oid, String referenceName, Integer index) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new RemoveReferenceChange(oid, referenceName, index));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void removeReferenceByOid(Long tid, Long oid, String referenceName, Long referencedOid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new RemoveReferenceChange(oid, referenceName, referencedOid));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void removeAllReferences(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new RemoveAllReferencesChange(oid, referenceName));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void setStringAttribute(Long tid, Long oid, String attributeName, String value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setStringAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index, String value) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChangeAtIndex(oid, attributeName, index, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setWrappedStringAttribute(Long tid, Long oid, String attributeName, String type, String value)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetWrappedAttributeChange(oid, attributeName, type, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public String getStringAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return (String)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public void setIntegerAttribute(Long tid, Long oid, String attributeName, Integer value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void setWrappedIntegerAttribute(Long tid, Long oid, String attributeName, String type, Integer value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetWrappedAttributeChange(oid, attributeName, type, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setByteArrayAttribute(Long tid, Long oid, String attributeName, Byte[] value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setLongAttribute(Long tid, Long oid, String attributeName, Long value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setLongAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index,Long value) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChangeAtIndex(oid, attributeName, index, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setWrappedLongAttribute(Long tid, Long oid, String attributeName, String type, Long value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetWrappedAttributeChange(oid, attributeName, type, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	public Integer getIntegerAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Integer)getAttribute(tid, oid, attributeName);
	}

	public Integer getIntegerAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index) throws ServerException ,UserException {
		return (Integer)getAttributeAtIndex(tid, oid, attributeName, index);
	}

	public Long getLongAttribute(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (Long)getAttribute(tid, oid, attributeName);
	}

	public Long getLongAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index) throws ServerException ,UserException {
		return (Long)getAttributeAtIndex(tid, oid, attributeName, index);
	}
	
	@Override
	public void setBooleanAttribute(Long tid, Long oid, String attributeName, Boolean value) throws UserException, ServerException {
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setWrappedBooleanAttribute(Long tid, Long oid, String attributeName, String type, Boolean value) throws UserException, ServerException {
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetWrappedAttributeChange(oid, attributeName, type, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public Boolean getBooleanAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Boolean)getAttribute(tid, oid, attributeName);
	}

	@Override
	public Boolean getBooleanAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index) throws ServerException, UserException {
		return (Boolean)getAttributeAtIndex(tid, oid, attributeName, index);
	}

	@Override
	public void setDoubleAttribute(Long tid, Long oid, String attributeName, Double value) throws UserException, ServerException {
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public void setWrappedDoubleAttribute(Long tid, Long oid, String attributeName, String type, Double value) throws UserException, ServerException {
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetWrappedAttributeChange(oid, attributeName, type, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public Double getDoubleAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (Double)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public Double getDoubleAttributeAtIndex(Long tid, Long oid, String attributeName, Integer index) throws ServerException, UserException {
		return (Double)getAttributeAtIndex(tid, oid, attributeName, index);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Double> getDoubleAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Double>)getAttribute(tid, oid, attributeName);
	}

	@SuppressWarnings("unchecked")
	public List<Boolean> getBooleanAttributes(Long tid, Long oid, String attributeName) throws ServerException ,UserException {
		return (List<Boolean>)getAttribute(tid, oid, attributeName);
	}
	
	@Override
	public byte[] getByteArrayAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (byte[])getAttribute(tid, oid, attributeName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<byte[]> getByteArrayAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<byte[]>)getAttribute(tid, oid, attributeName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getIntegerAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<Integer>)getAttribute(tid, oid, attributeName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getStringAttributes(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		return (List<String>)getAttribute(tid, oid, attributeName);
	}
	
	private Object getAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new OldQuery(transaction.getPackageMetaData(), transaction.getPid(), transaction.getRid(), transaction.getRoid(), Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			EStructuralFeature eStructuralFeature = object.eClass().getEStructuralFeature(attributeName);
			if (eStructuralFeature == null) {
				throw new UserException(eClass.getName() + " does not have a field called " + attributeName);
			}
			Object eGet = object.eGet(eStructuralFeature);
			if (eGet instanceof IdEObject) {
				IdEObject refObject = (IdEObject)eGet;
				return refObject.eGet(refObject.eClass().getEStructuralFeature("wrappedValue"));
			}
			return eGet;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	private Object getAttributeAtIndex(Long tid, Long oid, String attributeName, int index) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new OldQuery(transaction.getPackageMetaData(), transaction.getPid(), transaction.getRid(), transaction.getRoid(), Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			Object eGet = object.eGet(object.eClass().getEStructuralFeature(attributeName));
			if (eGet instanceof List) {
				List<?> list = (List<?>)eGet;
				return list.get(index);
			}
			return eGet;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setEnumAttribute(Long tid, Long oid, String attributeName, String value) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, value));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public String getEnumAttribute(Long tid, Long oid, String attributeName) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return getAttribute(tid, oid, attributeName).toString();
	}

	@Override
	public void setReference(Long tid, Long oid, String referenceName, Long referenceOid) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, referenceOid));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public Long getReference(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new OldQuery(transaction.getPackageMetaData(), transaction.getPid(), transaction.getRid(), transaction.getRoid(), Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			EStructuralFeature eStructuralFeature = object.eClass().getEStructuralFeature(referenceName);
			if (eStructuralFeature == null) {
				throw new UserException("No feature with name " + referenceName + " found on class " + object.eClass().getName());
			}
			IdEObject ref = (IdEObject) object.eGet(eStructuralFeature);
			if (ref == null) {
				return -1L;
			}
			return ref.getOid();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getReferences(Long tid, Long oid, String referenceName) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			LongTransaction transaction = getBimServer().getLongTransactionManager().get(tid);
			EClass eClass = session.getEClassForOid(oid);
			IdEObject object = session.get(eClass, oid, new OldQuery(transaction.getPackageMetaData(), transaction.getPid(), transaction.getRid(), transaction.getRoid(), Deep.NO));
			if (object == null) {
				throw new UserException("No object of type " + eClass.getName() + " with oid " + oid + " found");
			}
			List<IdEObject> list = (List<IdEObject>) object.eGet(object.eClass().getEStructuralFeature(referenceName));
			List<Long> oidList = new ArrayList<Long>();
			for (IdEObject idEObject : list) {
				oidList.add(idEObject.getOid());
			}
			return oidList;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void unsetAttribute(Long tid, Long oid, String attributeName) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetAttributeChange(oid, attributeName, null));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}

	@Override
	public void unsetReference(Long tid, Long oid, String referenceName) throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		try {
			getBimServer().getLongTransactionManager().get(tid).add(new SetReferenceChange(oid, referenceName, -1));
		} catch (NoTransactionException e) {
			handleException(e);
		}
	}
	
	@Override
	public List<SDataObject> getDataObjects(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<DataObject>> action = new GetDataObjectsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), roid, getAuthorization());
			return getBimServer().getSConverter().convertToSListDataObject(session.executeAndCommitAction(action));
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	
	@Override
	public SDataObject getDataObjectByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByGuidDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, guid, getAuthorization());
			SDataObject dataObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDataObject> getDataObjectsByType(Long roid, String packageName, String className, Boolean flat) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		BimDatabaseAction<List<DataObject>> action = new GetDataObjectsByTypeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, packageName, className, getAuthorization(), flat);
		try {
			return getBimServer().getSConverter().convertToSListDataObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SDataObject getDataObjectByOid(Long roid, Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<DataObject> action = new GetDataObjectByOidDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			SDataObject dataObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return dataObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public Integer count(Long roid, String className) throws UserException ,ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			CountDatabaseAction action = new CountDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, className, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}