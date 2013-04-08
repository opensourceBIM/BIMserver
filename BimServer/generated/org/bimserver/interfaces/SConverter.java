package org.bimserver.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.interfaces.objects.*;
import java.util.*;
import org.bimserver.models.log.*;
import org.bimserver.models.store.*;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Query;

public class SConverter {
		public SAccessMethod convertToSObject(AccessMethod input) {
			return SAccessMethod.values()[input.ordinal()];
		}
		
		public AccessMethod convertFromSObject(SAccessMethod input) {
			return AccessMethod.values()[input.ordinal()];
		}

	public Set<SLogAction> convertToSSetLogAction(Collection<LogAction> input) {
		Set<SLogAction> result = new HashSet<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LogAction> convertFromSSetLogAction(Collection<SLogAction> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LogAction> result = new HashSet<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLogAction> convertToSListLogAction(Collection<LogAction> input) {
		List<SLogAction> result = new ArrayList<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LogAction> convertFromSListLogAction(Collection<SLogAction> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LogAction> result = new ArrayList<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLogAction convertToSObject(LogAction input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof UserDeleted) {
			return convertToSObject((UserDeleted)input);
		}
		else if (input instanceof RemoteServiceCalled) {
			return convertToSObject((RemoteServiceCalled)input);
		}
		else if (input instanceof ExtendedDataAddedToProject) {
			return convertToSObject((ExtendedDataAddedToProject)input);
		}
		else if (input instanceof GeoTagUpdated) {
			return convertToSObject((GeoTagUpdated)input);
		}
		else if (input instanceof NewCheckoutAdded) {
			return convertToSObject((NewCheckoutAdded)input);
		}
		else if (input instanceof ProjectDeleted) {
			return convertToSObject((ProjectDeleted)input);
		}
		else if (input instanceof ProjectUndeleted) {
			return convertToSObject((ProjectUndeleted)input);
		}
		else if (input instanceof DatabaseCreated) {
			return convertToSObject((DatabaseCreated)input);
		}
		else if (input instanceof SettingsSaved) {
			return convertToSObject((SettingsSaved)input);
		}
		else if (input instanceof PasswordReset) {
			return convertToSObject((PasswordReset)input);
		}
		else if (input instanceof NewUserAdded) {
			return convertToSObject((NewUserAdded)input);
		}
		else if (input instanceof UserChanged) {
			return convertToSObject((UserChanged)input);
		}
		else if (input instanceof UserUndeleted) {
			return convertToSObject((UserUndeleted)input);
		}
		else if (input instanceof PasswordChanged) {
			return convertToSObject((PasswordChanged)input);
		}
		else if (input instanceof UserAddedToProject) {
			return convertToSObject((UserAddedToProject)input);
		}
		else if (input instanceof RevisionBranched) {
			return convertToSObject((RevisionBranched)input);
		}
		else if (input instanceof NewObjectIDMUploaded) {
			return convertToSObject((NewObjectIDMUploaded)input);
		}
		else if (input instanceof ExtendedDataAddedToRevision) {
			return convertToSObject((ExtendedDataAddedToRevision)input);
		}
		else if (input instanceof ProjectUpdated) {
			return convertToSObject((ProjectUpdated)input);
		}
		else if (input instanceof RevisionUpdated) {
			return convertToSObject((RevisionUpdated)input);
		}
		else if (input instanceof NewRevisionAdded) {
			return convertToSObject((NewRevisionAdded)input);
		}
		else if (input instanceof Download) {
			return convertToSObject((Download)input);
		}
		else if (input instanceof NewProjectAdded) {
			return convertToSObject((NewProjectAdded)input);
		}
		else if (input instanceof ServerStarted) {
			return convertToSObject((ServerStarted)input);
		}
		else if (input instanceof UserRemovedFromProject) {
			return convertToSObject((UserRemovedFromProject)input);
		}
		SLogAction result = new SLogAction();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public LogAction convertFromSObject(SLogAction input, DatabaseSession session) throws BimserverDatabaseException {
		LogAction result = convertFromSObject(input, LogFactory.eINSTANCE.createLogAction(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, LogAction result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SUserDeleted) {
			return convertFromSObject((SUserDeleted)input, session);
		}
		else if (input instanceof SRemoteServiceCalled) {
			return convertFromSObject((SRemoteServiceCalled)input, session);
		}
		else if (input instanceof SExtendedDataAddedToProject) {
			return convertFromSObject((SExtendedDataAddedToProject)input, session);
		}
		else if (input instanceof SGeoTagUpdated) {
			return convertFromSObject((SGeoTagUpdated)input, session);
		}
		else if (input instanceof SNewCheckoutAdded) {
			return convertFromSObject((SNewCheckoutAdded)input, session);
		}
		else if (input instanceof SProjectDeleted) {
			return convertFromSObject((SProjectDeleted)input, session);
		}
		else if (input instanceof SProjectUndeleted) {
			return convertFromSObject((SProjectUndeleted)input, session);
		}
		else if (input instanceof SDatabaseCreated) {
			return convertFromSObject((SDatabaseCreated)input, session);
		}
		else if (input instanceof SSettingsSaved) {
			return convertFromSObject((SSettingsSaved)input, session);
		}
		else if (input instanceof SPasswordReset) {
			return convertFromSObject((SPasswordReset)input, session);
		}
		else if (input instanceof SNewUserAdded) {
			return convertFromSObject((SNewUserAdded)input, session);
		}
		else if (input instanceof SUserChanged) {
			return convertFromSObject((SUserChanged)input, session);
		}
		else if (input instanceof SUserUndeleted) {
			return convertFromSObject((SUserUndeleted)input, session);
		}
		else if (input instanceof SPasswordChanged) {
			return convertFromSObject((SPasswordChanged)input, session);
		}
		else if (input instanceof SUserAddedToProject) {
			return convertFromSObject((SUserAddedToProject)input, session);
		}
		else if (input instanceof SRevisionBranched) {
			return convertFromSObject((SRevisionBranched)input, session);
		}
		else if (input instanceof SNewObjectIDMUploaded) {
			return convertFromSObject((SNewObjectIDMUploaded)input, session);
		}
		else if (input instanceof SExtendedDataAddedToRevision) {
			return convertFromSObject((SExtendedDataAddedToRevision)input, session);
		}
		else if (input instanceof SProjectUpdated) {
			return convertFromSObject((SProjectUpdated)input, session);
		}
		else if (input instanceof SRevisionUpdated) {
			return convertFromSObject((SRevisionUpdated)input, session);
		}
		else if (input instanceof SNewRevisionAdded) {
			return convertFromSObject((SNewRevisionAdded)input, session);
		}
		else if (input instanceof SDownload) {
			return convertFromSObject((SDownload)input, session);
		}
		else if (input instanceof SNewProjectAdded) {
			return convertFromSObject((SNewProjectAdded)input, session);
		}
		else if (input instanceof SServerStarted) {
			return convertFromSObject((SServerStarted)input, session);
		}
		else if (input instanceof SUserRemovedFromProject) {
			return convertFromSObject((SUserRemovedFromProject)input, session);
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SServerLog> convertToSSetServerLog(Collection<ServerLog> input) {
		Set<SServerLog> result = new HashSet<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerLog> convertFromSSetServerLog(Collection<SServerLog> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerLog> result = new HashSet<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerLog> convertToSListServerLog(Collection<ServerLog> input) {
		List<SServerLog> result = new ArrayList<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerLog> convertFromSListServerLog(Collection<SServerLog> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerLog> result = new ArrayList<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerLog convertToSObject(ServerLog input) {
		if (input == null) {
			return null;
		}
		
		SServerLog result = new SServerLog();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		List<Long> listactions = new ArrayList<Long>();
		for (LogAction v : input.getActions()) {
			listactions.add(v.getOid());
		}
		result.setActions(listactions);
		return result;
	}
	public ServerLog convertFromSObject(SServerLog input, DatabaseSession session) throws BimserverDatabaseException {
		ServerLog result = convertFromSObject(input, LogFactory.eINSTANCE.createServerLog(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, ServerLog result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<LogAction> listactions = result.getActions();
		for (long oid : input.getActions()) {
			listactions.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SNewUserAdded> convertToSSetNewUserAdded(Collection<NewUserAdded> input) {
		Set<SNewUserAdded> result = new HashSet<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewUserAdded> convertFromSSetNewUserAdded(Collection<SNewUserAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewUserAdded> result = new HashSet<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewUserAdded> convertToSListNewUserAdded(Collection<NewUserAdded> input) {
		List<SNewUserAdded> result = new ArrayList<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewUserAdded> convertFromSListNewUserAdded(Collection<SNewUserAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewUserAdded> result = new ArrayList<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewUserAdded convertToSObject(NewUserAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewUserAdded result = new SNewUserAdded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public NewUserAdded convertFromSObject(SNewUserAdded input, DatabaseSession session) throws BimserverDatabaseException {
		NewUserAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewUserAdded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, NewUserAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SNewProjectAdded> convertToSSetNewProjectAdded(Collection<NewProjectAdded> input) {
		Set<SNewProjectAdded> result = new HashSet<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectAdded> convertFromSSetNewProjectAdded(Collection<SNewProjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewProjectAdded> result = new HashSet<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewProjectAdded> convertToSListNewProjectAdded(Collection<NewProjectAdded> input) {
		List<SNewProjectAdded> result = new ArrayList<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewProjectAdded> convertFromSListNewProjectAdded(Collection<SNewProjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewProjectAdded> result = new ArrayList<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewProjectAdded convertToSObject(NewProjectAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewProjectAdded result = new SNewProjectAdded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Project parentProjectVal = input.getParentProject();
		result.setParentProjectId(parentProjectVal == null ? -1 : parentProjectVal.getOid());
		return result;
	}
	public NewProjectAdded convertFromSObject(SNewProjectAdded input, DatabaseSession session) throws BimserverDatabaseException {
		NewProjectAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewProjectAdded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public NewProjectAdded convertFromSObject(SNewProjectAdded input, NewProjectAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		result.setParentProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SRevisionBranched> convertToSSetRevisionBranched(Collection<RevisionBranched> input) {
		Set<SRevisionBranched> result = new HashSet<SRevisionBranched>();
		for (RevisionBranched o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionBranched> convertFromSSetRevisionBranched(Collection<SRevisionBranched> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionBranched> result = new HashSet<RevisionBranched>();
		for (SRevisionBranched o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionBranched> convertToSListRevisionBranched(Collection<RevisionBranched> input) {
		List<SRevisionBranched> result = new ArrayList<SRevisionBranched>();
		for (RevisionBranched o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionBranched> convertFromSListRevisionBranched(Collection<SRevisionBranched> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionBranched> result = new ArrayList<RevisionBranched>();
		for (SRevisionBranched o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionBranched convertToSObject(RevisionBranched input) {
		if (input == null) {
			return null;
		}
		
		SRevisionBranched result = new SRevisionBranched();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision oldrevisionVal = input.getOldrevision();
		result.setOldrevisionId(oldrevisionVal == null ? -1 : oldrevisionVal.getOid());
		Revision newrevisionVal = input.getNewrevision();
		result.setNewrevisionId(newrevisionVal == null ? -1 : newrevisionVal.getOid());
		return result;
	}
	public RevisionBranched convertFromSObject(SRevisionBranched input, DatabaseSession session) throws BimserverDatabaseException {
		RevisionBranched result = convertFromSObject(input, LogFactory.eINSTANCE.createRevisionBranched(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RevisionBranched convertFromSObject(SRevisionBranched input, RevisionBranched result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setOldrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getOldrevisionId(), Query.getDefault()));
		result.setNewrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getNewrevisionId(), Query.getDefault()));
		return result;
	}

	public Set<SNewRevisionAdded> convertToSSetNewRevisionAdded(Collection<NewRevisionAdded> input) {
		Set<SNewRevisionAdded> result = new HashSet<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewRevisionAdded> convertFromSSetNewRevisionAdded(Collection<SNewRevisionAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewRevisionAdded> result = new HashSet<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewRevisionAdded> convertToSListNewRevisionAdded(Collection<NewRevisionAdded> input) {
		List<SNewRevisionAdded> result = new ArrayList<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewRevisionAdded> convertFromSListNewRevisionAdded(Collection<SNewRevisionAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewRevisionAdded> result = new ArrayList<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewRevisionAdded convertToSObject(NewRevisionAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewRevisionAdded result = new SNewRevisionAdded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, DatabaseSession session) throws BimserverDatabaseException {
		NewRevisionAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewRevisionAdded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, NewRevisionAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SNewCheckoutAdded> convertToSSetNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		Set<SNewCheckoutAdded> result = new HashSet<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewCheckoutAdded> convertFromSSetNewCheckoutAdded(Collection<SNewCheckoutAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewCheckoutAdded> result = new HashSet<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewCheckoutAdded> convertToSListNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		List<SNewCheckoutAdded> result = new ArrayList<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewCheckoutAdded> convertFromSListNewCheckoutAdded(Collection<SNewCheckoutAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewCheckoutAdded> result = new ArrayList<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewCheckoutAdded convertToSObject(NewCheckoutAdded input) {
		if (input == null) {
			return null;
		}
		
		SNewCheckoutAdded result = new SNewCheckoutAdded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}
	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, DatabaseSession session) throws BimserverDatabaseException {
		NewCheckoutAdded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewCheckoutAdded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, NewCheckoutAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setCheckout((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), input.getCheckoutId(), Query.getDefault()));
		return result;
	}

	public Set<SSettingsSaved> convertToSSetSettingsSaved(Collection<SettingsSaved> input) {
		Set<SSettingsSaved> result = new HashSet<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SettingsSaved> convertFromSSetSettingsSaved(Collection<SSettingsSaved> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SettingsSaved> result = new HashSet<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSettingsSaved> convertToSListSettingsSaved(Collection<SettingsSaved> input) {
		List<SSettingsSaved> result = new ArrayList<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SettingsSaved> convertFromSListSettingsSaved(Collection<SSettingsSaved> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SettingsSaved> result = new ArrayList<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSettingsSaved convertToSObject(SettingsSaved input) {
		if (input == null) {
			return null;
		}
		
		SSettingsSaved result = new SSettingsSaved();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public SettingsSaved convertFromSObject(SSettingsSaved input, DatabaseSession session) throws BimserverDatabaseException {
		SettingsSaved result = convertFromSObject(input, LogFactory.eINSTANCE.createSettingsSaved(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, SettingsSaved result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SUserAddedToProject> convertToSSetUserAddedToProject(Collection<UserAddedToProject> input) {
		Set<SUserAddedToProject> result = new HashSet<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserAddedToProject> convertFromSSetUserAddedToProject(Collection<SUserAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserAddedToProject> result = new HashSet<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserAddedToProject> convertToSListUserAddedToProject(Collection<UserAddedToProject> input) {
		List<SUserAddedToProject> result = new ArrayList<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserAddedToProject> convertFromSListUserAddedToProject(Collection<SUserAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserAddedToProject> result = new ArrayList<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserAddedToProject convertToSObject(UserAddedToProject input) {
		if (input == null) {
			return null;
		}
		
		SUserAddedToProject result = new SUserAddedToProject();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public UserAddedToProject convertFromSObject(SUserAddedToProject input, DatabaseSession session) throws BimserverDatabaseException {
		UserAddedToProject result = convertFromSObject(input, LogFactory.eINSTANCE.createUserAddedToProject(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserAddedToProject convertFromSObject(SUserAddedToProject input, UserAddedToProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SNewObjectIDMUploaded> convertToSSetNewObjectIDMUploaded(Collection<NewObjectIDMUploaded> input) {
		Set<SNewObjectIDMUploaded> result = new HashSet<SNewObjectIDMUploaded>();
		for (NewObjectIDMUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewObjectIDMUploaded> convertFromSSetNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<NewObjectIDMUploaded> result = new HashSet<NewObjectIDMUploaded>();
		for (SNewObjectIDMUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewObjectIDMUploaded> convertToSListNewObjectIDMUploaded(Collection<NewObjectIDMUploaded> input) {
		List<SNewObjectIDMUploaded> result = new ArrayList<SNewObjectIDMUploaded>();
		for (NewObjectIDMUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewObjectIDMUploaded> convertFromSListNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<NewObjectIDMUploaded> result = new ArrayList<NewObjectIDMUploaded>();
		for (SNewObjectIDMUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewObjectIDMUploaded convertToSObject(NewObjectIDMUploaded input) {
		if (input == null) {
			return null;
		}
		
		SNewObjectIDMUploaded result = new SNewObjectIDMUploaded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, DatabaseSession session) throws BimserverDatabaseException {
		NewObjectIDMUploaded result = convertFromSObject(input, LogFactory.eINSTANCE.createNewObjectIDMUploaded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, NewObjectIDMUploaded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SDownload> convertToSSetDownload(Collection<Download> input) {
		Set<SDownload> result = new HashSet<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Download> convertFromSSetDownload(Collection<SDownload> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Download> result = new HashSet<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownload> convertToSListDownload(Collection<Download> input) {
		List<SDownload> result = new ArrayList<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Download> convertFromSListDownload(Collection<SDownload> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Download> result = new ArrayList<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDownload convertToSObject(Download input) {
		if (input == null) {
			return null;
		}
		
		SDownload result = new SDownload();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public Download convertFromSObject(SDownload input, DatabaseSession session) throws BimserverDatabaseException {
		Download result = convertFromSObject(input, LogFactory.eINSTANCE.createDownload(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Download convertFromSObject(SDownload input, Download result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SUserRemovedFromProject> convertToSSetUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		Set<SUserRemovedFromProject> result = new HashSet<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserRemovedFromProject> convertFromSSetUserRemovedFromProject(Collection<SUserRemovedFromProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserRemovedFromProject> result = new HashSet<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserRemovedFromProject> convertToSListUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		List<SUserRemovedFromProject> result = new ArrayList<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserRemovedFromProject> convertFromSListUserRemovedFromProject(Collection<SUserRemovedFromProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserRemovedFromProject> result = new ArrayList<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserRemovedFromProject convertToSObject(UserRemovedFromProject input) {
		if (input == null) {
			return null;
		}
		
		SUserRemovedFromProject result = new SUserRemovedFromProject();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, DatabaseSession session) throws BimserverDatabaseException {
		UserRemovedFromProject result = convertFromSObject(input, LogFactory.eINSTANCE.createUserRemovedFromProject(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, UserRemovedFromProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SProjectDeleted> convertToSSetProjectDeleted(Collection<ProjectDeleted> input) {
		Set<SProjectDeleted> result = new HashSet<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectDeleted> convertFromSSetProjectDeleted(Collection<SProjectDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectDeleted> result = new HashSet<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectDeleted> convertToSListProjectDeleted(Collection<ProjectDeleted> input) {
		List<SProjectDeleted> result = new ArrayList<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectDeleted> convertFromSListProjectDeleted(Collection<SProjectDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectDeleted> result = new ArrayList<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectDeleted convertToSObject(ProjectDeleted input) {
		if (input == null) {
			return null;
		}
		
		SProjectDeleted result = new SProjectDeleted();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public ProjectDeleted convertFromSObject(SProjectDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		ProjectDeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectDeleted(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, ProjectDeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SUserDeleted> convertToSSetUserDeleted(Collection<UserDeleted> input) {
		Set<SUserDeleted> result = new HashSet<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserDeleted> convertFromSSetUserDeleted(Collection<SUserDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserDeleted> result = new HashSet<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserDeleted> convertToSListUserDeleted(Collection<UserDeleted> input) {
		List<SUserDeleted> result = new ArrayList<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserDeleted> convertFromSListUserDeleted(Collection<SUserDeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserDeleted> result = new ArrayList<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserDeleted convertToSObject(UserDeleted input) {
		if (input == null) {
			return null;
		}
		
		SUserDeleted result = new SUserDeleted();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public UserDeleted convertFromSObject(SUserDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		UserDeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createUserDeleted(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, UserDeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SPasswordReset> convertToSSetPasswordReset(Collection<PasswordReset> input) {
		Set<SPasswordReset> result = new HashSet<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordReset> convertFromSSetPasswordReset(Collection<SPasswordReset> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PasswordReset> result = new HashSet<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordReset> convertToSListPasswordReset(Collection<PasswordReset> input) {
		List<SPasswordReset> result = new ArrayList<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordReset> convertFromSListPasswordReset(Collection<SPasswordReset> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PasswordReset> result = new ArrayList<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordReset convertToSObject(PasswordReset input) {
		if (input == null) {
			return null;
		}
		
		SPasswordReset result = new SPasswordReset();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public PasswordReset convertFromSObject(SPasswordReset input, DatabaseSession session) throws BimserverDatabaseException {
		PasswordReset result = convertFromSObject(input, LogFactory.eINSTANCE.createPasswordReset(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, PasswordReset result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SDatabaseCreated> convertToSSetDatabaseCreated(Collection<DatabaseCreated> input) {
		Set<SDatabaseCreated> result = new HashSet<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseCreated> convertFromSSetDatabaseCreated(Collection<SDatabaseCreated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseCreated> result = new HashSet<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseCreated> convertToSListDatabaseCreated(Collection<DatabaseCreated> input) {
		List<SDatabaseCreated> result = new ArrayList<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseCreated> convertFromSListDatabaseCreated(Collection<SDatabaseCreated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseCreated> result = new ArrayList<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseCreated convertToSObject(DatabaseCreated input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseCreated result = new SDatabaseCreated();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public DatabaseCreated convertFromSObject(SDatabaseCreated input, DatabaseSession session) throws BimserverDatabaseException {
		DatabaseCreated result = convertFromSObject(input, LogFactory.eINSTANCE.createDatabaseCreated(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, DatabaseCreated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SServerStarted> convertToSSetServerStarted(Collection<ServerStarted> input) {
		Set<SServerStarted> result = new HashSet<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerStarted> convertFromSSetServerStarted(Collection<SServerStarted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerStarted> result = new HashSet<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerStarted> convertToSListServerStarted(Collection<ServerStarted> input) {
		List<SServerStarted> result = new ArrayList<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerStarted> convertFromSListServerStarted(Collection<SServerStarted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerStarted> result = new ArrayList<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerStarted convertToSObject(ServerStarted input) {
		if (input == null) {
			return null;
		}
		
		SServerStarted result = new SServerStarted();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}
	public ServerStarted convertFromSObject(SServerStarted input, DatabaseSession session) throws BimserverDatabaseException {
		ServerStarted result = convertFromSObject(input, LogFactory.eINSTANCE.createServerStarted(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, ServerStarted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		return result;
	}

	public Set<SProjectUpdated> convertToSSetProjectUpdated(Collection<ProjectUpdated> input) {
		Set<SProjectUpdated> result = new HashSet<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUpdated> convertFromSSetProjectUpdated(Collection<SProjectUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectUpdated> result = new HashSet<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUpdated> convertToSListProjectUpdated(Collection<ProjectUpdated> input) {
		List<SProjectUpdated> result = new ArrayList<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUpdated> convertFromSListProjectUpdated(Collection<SProjectUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectUpdated> result = new ArrayList<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUpdated convertToSObject(ProjectUpdated input) {
		if (input == null) {
			return null;
		}
		
		SProjectUpdated result = new SProjectUpdated();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public ProjectUpdated convertFromSObject(SProjectUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		ProjectUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectUpdated(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, ProjectUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SUserUndeleted> convertToSSetUserUndeleted(Collection<UserUndeleted> input) {
		Set<SUserUndeleted> result = new HashSet<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserUndeleted> convertFromSSetUserUndeleted(Collection<SUserUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserUndeleted> result = new HashSet<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserUndeleted> convertToSListUserUndeleted(Collection<UserUndeleted> input) {
		List<SUserUndeleted> result = new ArrayList<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserUndeleted> convertFromSListUserUndeleted(Collection<SUserUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserUndeleted> result = new ArrayList<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserUndeleted convertToSObject(UserUndeleted input) {
		if (input == null) {
			return null;
		}
		
		SUserUndeleted result = new SUserUndeleted();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public UserUndeleted convertFromSObject(SUserUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		UserUndeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createUserUndeleted(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, UserUndeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SProjectUndeleted> convertToSSetProjectUndeleted(Collection<ProjectUndeleted> input) {
		Set<SProjectUndeleted> result = new HashSet<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUndeleted> convertFromSSetProjectUndeleted(Collection<SProjectUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProjectUndeleted> result = new HashSet<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUndeleted> convertToSListProjectUndeleted(Collection<ProjectUndeleted> input) {
		List<SProjectUndeleted> result = new ArrayList<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUndeleted> convertFromSListProjectUndeleted(Collection<SProjectUndeleted> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProjectUndeleted> result = new ArrayList<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUndeleted convertToSObject(ProjectUndeleted input) {
		if (input == null) {
			return null;
		}
		
		SProjectUndeleted result = new SProjectUndeleted();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		ProjectUndeleted result = convertFromSObject(input, LogFactory.eINSTANCE.createProjectUndeleted(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, ProjectUndeleted result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SRevisionUpdated> convertToSSetRevisionUpdated(Collection<RevisionUpdated> input) {
		Set<SRevisionUpdated> result = new HashSet<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionUpdated> convertFromSSetRevisionUpdated(Collection<SRevisionUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionUpdated> result = new HashSet<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionUpdated> convertToSListRevisionUpdated(Collection<RevisionUpdated> input) {
		List<SRevisionUpdated> result = new ArrayList<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionUpdated> convertFromSListRevisionUpdated(Collection<SRevisionUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionUpdated> result = new ArrayList<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionUpdated convertToSObject(RevisionUpdated input) {
		if (input == null) {
			return null;
		}
		
		SRevisionUpdated result = new SRevisionUpdated();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}
	public RevisionUpdated convertFromSObject(SRevisionUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		RevisionUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createRevisionUpdated(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, RevisionUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), Query.getDefault()));
		return result;
	}

	public Set<SGeoTagUpdated> convertToSSetGeoTagUpdated(Collection<GeoTagUpdated> input) {
		Set<SGeoTagUpdated> result = new HashSet<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTagUpdated> convertFromSSetGeoTagUpdated(Collection<SGeoTagUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeoTagUpdated> result = new HashSet<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTagUpdated> convertToSListGeoTagUpdated(Collection<GeoTagUpdated> input) {
		List<SGeoTagUpdated> result = new ArrayList<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTagUpdated> convertFromSListGeoTagUpdated(Collection<SGeoTagUpdated> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeoTagUpdated> result = new ArrayList<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTagUpdated convertToSObject(GeoTagUpdated input) {
		if (input == null) {
			return null;
		}
		
		SGeoTagUpdated result = new SGeoTagUpdated();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		return result;
	}
	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		GeoTagUpdated result = convertFromSObject(input, LogFactory.eINSTANCE.createGeoTagUpdated(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, GeoTagUpdated result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), Query.getDefault()));
		return result;
	}

	public Set<SPasswordChanged> convertToSSetPasswordChanged(Collection<PasswordChanged> input) {
		Set<SPasswordChanged> result = new HashSet<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordChanged> convertFromSSetPasswordChanged(Collection<SPasswordChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PasswordChanged> result = new HashSet<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordChanged> convertToSListPasswordChanged(Collection<PasswordChanged> input) {
		List<SPasswordChanged> result = new ArrayList<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordChanged> convertFromSListPasswordChanged(Collection<SPasswordChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PasswordChanged> result = new ArrayList<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordChanged convertToSObject(PasswordChanged input) {
		if (input == null) {
			return null;
		}
		
		SPasswordChanged result = new SPasswordChanged();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public PasswordChanged convertFromSObject(SPasswordChanged input, DatabaseSession session) throws BimserverDatabaseException {
		PasswordChanged result = convertFromSObject(input, LogFactory.eINSTANCE.createPasswordChanged(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, PasswordChanged result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SUserChanged> convertToSSetUserChanged(Collection<UserChanged> input) {
		Set<SUserChanged> result = new HashSet<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserChanged> convertFromSSetUserChanged(Collection<SUserChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserChanged> result = new HashSet<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserChanged> convertToSListUserChanged(Collection<UserChanged> input) {
		List<SUserChanged> result = new ArrayList<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserChanged> convertFromSListUserChanged(Collection<SUserChanged> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserChanged> result = new ArrayList<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserChanged convertToSObject(UserChanged input) {
		if (input == null) {
			return null;
		}
		
		SUserChanged result = new SUserChanged();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public UserChanged convertFromSObject(SUserChanged input, DatabaseSession session) throws BimserverDatabaseException {
		UserChanged result = convertFromSObject(input, LogFactory.eINSTANCE.createUserChanged(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, UserChanged result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SExtendedDataAddedToRevision> convertToSSetExtendedDataAddedToRevision(Collection<ExtendedDataAddedToRevision> input) {
		Set<SExtendedDataAddedToRevision> result = new HashSet<SExtendedDataAddedToRevision>();
		for (ExtendedDataAddedToRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataAddedToRevision> convertFromSSetExtendedDataAddedToRevision(Collection<SExtendedDataAddedToRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataAddedToRevision> result = new HashSet<ExtendedDataAddedToRevision>();
		for (SExtendedDataAddedToRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataAddedToRevision> convertToSListExtendedDataAddedToRevision(Collection<ExtendedDataAddedToRevision> input) {
		List<SExtendedDataAddedToRevision> result = new ArrayList<SExtendedDataAddedToRevision>();
		for (ExtendedDataAddedToRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataAddedToRevision> convertFromSListExtendedDataAddedToRevision(Collection<SExtendedDataAddedToRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataAddedToRevision> result = new ArrayList<ExtendedDataAddedToRevision>();
		for (SExtendedDataAddedToRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataAddedToRevision convertToSObject(ExtendedDataAddedToRevision input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataAddedToRevision result = new SExtendedDataAddedToRevision();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		ExtendedData extendedDataVal = input.getExtendedData();
		result.setExtendedDataId(extendedDataVal == null ? -1 : extendedDataVal.getOid());
		return result;
	}
	public ExtendedDataAddedToRevision convertFromSObject(SExtendedDataAddedToRevision input, DatabaseSession session) throws BimserverDatabaseException {
		ExtendedDataAddedToRevision result = convertFromSObject(input, LogFactory.eINSTANCE.createExtendedDataAddedToRevision(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ExtendedDataAddedToRevision convertFromSObject(SExtendedDataAddedToRevision input, ExtendedDataAddedToRevision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), Query.getDefault()));
		result.setExtendedData((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), input.getExtendedDataId(), Query.getDefault()));
		return result;
	}

	public Set<SExtendedDataAddedToProject> convertToSSetExtendedDataAddedToProject(Collection<ExtendedDataAddedToProject> input) {
		Set<SExtendedDataAddedToProject> result = new HashSet<SExtendedDataAddedToProject>();
		for (ExtendedDataAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataAddedToProject> convertFromSSetExtendedDataAddedToProject(Collection<SExtendedDataAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataAddedToProject> result = new HashSet<ExtendedDataAddedToProject>();
		for (SExtendedDataAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataAddedToProject> convertToSListExtendedDataAddedToProject(Collection<ExtendedDataAddedToProject> input) {
		List<SExtendedDataAddedToProject> result = new ArrayList<SExtendedDataAddedToProject>();
		for (ExtendedDataAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataAddedToProject> convertFromSListExtendedDataAddedToProject(Collection<SExtendedDataAddedToProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataAddedToProject> result = new ArrayList<ExtendedDataAddedToProject>();
		for (SExtendedDataAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataAddedToProject convertToSObject(ExtendedDataAddedToProject input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataAddedToProject result = new SExtendedDataAddedToProject();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		ExtendedData extendedDataVal = input.getExtendedData();
		result.setExtendedDataId(extendedDataVal == null ? -1 : extendedDataVal.getOid());
		return result;
	}
	public ExtendedDataAddedToProject convertFromSObject(SExtendedDataAddedToProject input, DatabaseSession session) throws BimserverDatabaseException {
		ExtendedDataAddedToProject result = convertFromSObject(input, LogFactory.eINSTANCE.createExtendedDataAddedToProject(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ExtendedDataAddedToProject convertFromSObject(SExtendedDataAddedToProject input, ExtendedDataAddedToProject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		result.setExtendedData((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), input.getExtendedDataId(), Query.getDefault()));
		return result;
	}

	public Set<SRemoteServiceCalled> convertToSSetRemoteServiceCalled(Collection<RemoteServiceCalled> input) {
		Set<SRemoteServiceCalled> result = new HashSet<SRemoteServiceCalled>();
		for (RemoteServiceCalled o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RemoteServiceCalled> convertFromSSetRemoteServiceCalled(Collection<SRemoteServiceCalled> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RemoteServiceCalled> result = new HashSet<RemoteServiceCalled>();
		for (SRemoteServiceCalled o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRemoteServiceCalled> convertToSListRemoteServiceCalled(Collection<RemoteServiceCalled> input) {
		List<SRemoteServiceCalled> result = new ArrayList<SRemoteServiceCalled>();
		for (RemoteServiceCalled o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RemoteServiceCalled> convertFromSListRemoteServiceCalled(Collection<SRemoteServiceCalled> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RemoteServiceCalled> result = new ArrayList<RemoteServiceCalled>();
		for (SRemoteServiceCalled o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRemoteServiceCalled convertToSObject(RemoteServiceCalled input) {
		if (input == null) {
			return null;
		}
		
		SRemoteServiceCalled result = new SRemoteServiceCalled();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setState(SNotifictionResultEnum.values()[input.getState().ordinal()]);
		result.setPercentage(input.getPercentage());
		result.getInfos().addAll(input.getInfos());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Service serviceVal = input.getService();
		result.setServiceId(serviceVal == null ? -1 : serviceVal.getOid());
		return result;
	}
	public RemoteServiceCalled convertFromSObject(SRemoteServiceCalled input, DatabaseSession session) throws BimserverDatabaseException {
		RemoteServiceCalled result = convertFromSObject(input, LogFactory.eINSTANCE.createRemoteServiceCalled(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RemoteServiceCalled convertFromSObject(SRemoteServiceCalled input, RemoteServiceCalled result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setState(NotifictionResultEnum.values()[input.getState().ordinal()]);
		result.setPercentage(input.getPercentage());
		result.getInfos().addAll(input.getInfos());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), Query.getDefault()));
		result.setService((Service)session.get(StorePackage.eINSTANCE.getService(), input.getServiceId(), Query.getDefault()));
		return result;
	}
		public SUserType convertToSObject(UserType input) {
			return SUserType.values()[input.ordinal()];
		}
		
		public UserType convertFromSObject(SUserType input) {
			return UserType.values()[input.ordinal()];
		}
		public SSIPrefix convertToSObject(SIPrefix input) {
			return SSIPrefix.values()[input.ordinal()];
		}
		
		public SIPrefix convertFromSObject(SSIPrefix input) {
			return SIPrefix.values()[input.ordinal()];
		}
		public SObjectState convertToSObject(ObjectState input) {
			return SObjectState.values()[input.ordinal()];
		}
		
		public ObjectState convertFromSObject(SObjectState input) {
			return ObjectState.values()[input.ordinal()];
		}

	public Set<SProject> convertToSSetProject(Collection<Project> input) {
		Set<SProject> result = new HashSet<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Project> convertFromSSetProject(Collection<SProject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Project> result = new HashSet<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProject> convertToSListProject(Collection<Project> input) {
		List<SProject> result = new ArrayList<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Project> convertFromSListProject(Collection<SProject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Project> result = new ArrayList<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProject convertToSObject(Project input) {
		if (input == null) {
			return null;
		}
		
		SProject result = new SProject();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SSIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		List<Long> listhasAuthorizedUsers = new ArrayList<Long>();
		for (User v : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add(v.getOid());
		}
		result.setHasAuthorizedUsers(listhasAuthorizedUsers);
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		Revision lastRevisionVal = input.getLastRevision();
		result.setLastRevisionId(lastRevisionVal == null ? -1 : lastRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		List<Long> listsubProjects = new ArrayList<Long>();
		for (Project v : input.getSubProjects()) {
			listsubProjects.add(v.getOid());
		}
		result.setSubProjects(listsubProjects);
		Project parentVal = input.getParent();
		result.setParentId(parentVal == null ? -1 : parentVal.getOid());
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listservices = new ArrayList<Long>();
		for (Service v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		List<Long> listlogs = new ArrayList<Long>();
		for (LogAction v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		return result;
	}
	public Project convertFromSObject(SProject input, DatabaseSession session) throws BimserverDatabaseException {
		Project result = convertFromSObject(input, StoreFactory.eINSTANCE.createProject(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Project convertFromSObject(SProject input, Project result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		List<User> listhasAuthorizedUsers = result.getHasAuthorizedUsers();
		for (long oid : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, Query.getDefault()));
		}
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, Query.getDefault()));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, Query.getDefault()));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), Query.getDefault()));
		result.setLastRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getLastRevisionId(), Query.getDefault()));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, Query.getDefault()));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), Query.getDefault()));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), Query.getDefault()));
		List<Project> listsubProjects = result.getSubProjects();
		for (long oid : input.getSubProjects()) {
			listsubProjects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, Query.getDefault()));
		}
		result.setParent((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentId(), Query.getDefault()));
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, Query.getDefault()));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, Query.getDefault()));
		}
		List<LogAction> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SUser> convertToSSetUser(Collection<User> input) {
		Set<SUser> result = new HashSet<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<User> convertFromSSetUser(Collection<SUser> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<User> result = new HashSet<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUser> convertToSListUser(Collection<User> input) {
		List<SUser> result = new ArrayList<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<User> convertFromSListUser(Collection<SUser> input, DatabaseSession session) throws BimserverDatabaseException {
		List<User> result = new ArrayList<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUser convertToSObject(User input) {
		if (input == null) {
			return null;
		}
		
		SUser result = new SUser();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(SUserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setToken(input.getToken());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		List<Long> listhasRightsOn = new ArrayList<Long>();
		for (Project v : input.getHasRightsOn()) {
			listhasRightsOn.add(v.getOid());
		}
		result.setHasRightsOn(listhasRightsOn);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		List<Long> listschemas = new ArrayList<Long>();
		for (ExtendedDataSchema v : input.getSchemas()) {
			listschemas.add(v.getOid());
		}
		result.setSchemas(listschemas);
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listservices = new ArrayList<Long>();
		for (Service v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		List<Long> listlogs = new ArrayList<Long>();
		for (LogAction v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		return result;
	}
	public User convertFromSObject(SUser input, DatabaseSession session) throws BimserverDatabaseException {
		User result = convertFromSObject(input, StoreFactory.eINSTANCE.createUser(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public User convertFromSObject(SUser input, User result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(UserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setToken(input.getToken());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		List<Project> listhasRightsOn = result.getHasRightsOn();
		for (long oid : input.getHasRightsOn()) {
			listhasRightsOn.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, Query.getDefault()));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, Query.getDefault()));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		List<ExtendedDataSchema> listschemas = result.getSchemas();
		for (long oid : input.getSchemas()) {
			listschemas.add((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), oid, Query.getDefault()));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, Query.getDefault()));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, Query.getDefault()));
		}
		List<LogAction> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SRevision> convertToSSetRevision(Collection<Revision> input) {
		Set<SRevision> result = new HashSet<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Revision> convertFromSSetRevision(Collection<SRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Revision> result = new HashSet<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevision> convertToSListRevision(Collection<Revision> input) {
		List<SRevision> result = new ArrayList<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Revision> convertFromSListRevision(Collection<SRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Revision> result = new ArrayList<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevision convertToSObject(Revision input) {
		if (input == null) {
			return null;
		}
		
		SRevision result = new SRevision();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setHasGeometry(input.isHasGeometry());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		List<Long> listlogs = new ArrayList<Long>();
		for (LogAction v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		return result;
	}
	public Revision convertFromSObject(SRevision input, DatabaseSession session) throws BimserverDatabaseException {
		Revision result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevision(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Revision convertFromSObject(SRevision input, Revision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setHasGeometry(input.isHasGeometry());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, Query.getDefault()));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), Query.getDefault()));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, Query.getDefault()));
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, Query.getDefault()));
		}
		List<LogAction> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SConcreteRevision> convertToSSetConcreteRevision(Collection<ConcreteRevision> input) {
		Set<SConcreteRevision> result = new HashSet<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ConcreteRevision> convertFromSSetConcreteRevision(Collection<SConcreteRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ConcreteRevision> result = new HashSet<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SConcreteRevision> convertToSListConcreteRevision(Collection<ConcreteRevision> input) {
		List<SConcreteRevision> result = new ArrayList<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ConcreteRevision> convertFromSListConcreteRevision(Collection<SConcreteRevision> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ConcreteRevision> result = new ArrayList<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SConcreteRevision convertToSObject(ConcreteRevision input) {
		if (input == null) {
			return null;
		}
		
		SConcreteRevision result = new SConcreteRevision();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setId(input.getId());
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setClear(input.isClear());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		RevisionSummary summaryVal = input.getSummary();
		result.setSummaryId(summaryVal == null ? -1 : summaryVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public ConcreteRevision convertFromSObject(SConcreteRevision input, DatabaseSession session) throws BimserverDatabaseException {
		ConcreteRevision result = convertFromSObject(input, StoreFactory.eINSTANCE.createConcreteRevision(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, ConcreteRevision result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setId(input.getId());
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setClear(input.isClear());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, Query.getDefault()));
		}
		result.setSummary((RevisionSummary)session.get(StorePackage.eINSTANCE.getRevisionSummary(), input.getSummaryId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SGeoTag> convertToSSetGeoTag(Collection<GeoTag> input) {
		Set<SGeoTag> result = new HashSet<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTag> convertFromSSetGeoTag(Collection<SGeoTag> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<GeoTag> result = new HashSet<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTag> convertToSListGeoTag(Collection<GeoTag> input) {
		List<SGeoTag> result = new ArrayList<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTag> convertFromSListGeoTag(Collection<SGeoTag> input, DatabaseSession session) throws BimserverDatabaseException {
		List<GeoTag> result = new ArrayList<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTag convertToSObject(GeoTag input) {
		if (input == null) {
			return null;
		}
		
		SGeoTag result = new SGeoTag();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setEnabled(input.getEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Long> listprojects = new ArrayList<Long>();
		for (Project v : input.getProjects()) {
			listprojects.add(v.getOid());
		}
		result.setProjects(listprojects);
		return result;
	}
	public GeoTag convertFromSObject(SGeoTag input, DatabaseSession session) throws BimserverDatabaseException {
		GeoTag result = convertFromSObject(input, StoreFactory.eINSTANCE.createGeoTag(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public GeoTag convertFromSObject(SGeoTag input, GeoTag result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setEnabled(input.getEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SCheckout> convertToSSetCheckout(Collection<Checkout> input) {
		Set<SCheckout> result = new HashSet<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Checkout> convertFromSSetCheckout(Collection<SCheckout> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Checkout> result = new HashSet<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckout> convertToSListCheckout(Collection<Checkout> input) {
		List<SCheckout> result = new ArrayList<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Checkout> convertFromSListCheckout(Collection<SCheckout> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Checkout> result = new ArrayList<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckout convertToSObject(Checkout input) {
		if (input == null) {
			return null;
		}
		
		SCheckout result = new SCheckout();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setDate(input.getDate());
		result.setActive(input.getActive());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevision(convertToSObject(revisionVal));
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Revision checkinVal = input.getCheckin();
		result.setCheckin(convertToSObject(checkinVal));
		List<Long> listlogs = new ArrayList<Long>();
		for (LogAction v : input.getLogs()) {
			listlogs.add(v.getOid());
		}
		result.setLogs(listlogs);
		return result;
	}
	public Checkout convertFromSObject(SCheckout input, DatabaseSession session) throws BimserverDatabaseException {
		Checkout result = convertFromSObject(input, StoreFactory.eINSTANCE.createCheckout(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Checkout convertFromSObject(SCheckout input, Checkout result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDate(input.getDate());
		result.setActive(input.getActive());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		result.setRevision(convertFromSObject(input.getRevision(), session));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		result.setCheckin(convertFromSObject(input.getCheckin(), session));
		List<LogAction> listlogs = result.getLogs();
		for (long oid : input.getLogs()) {
			listlogs.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SServerSettings> convertToSSetServerSettings(Collection<ServerSettings> input) {
		Set<SServerSettings> result = new HashSet<SServerSettings>();
		for (ServerSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerSettings> convertFromSSetServerSettings(Collection<SServerSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerSettings> result = new HashSet<ServerSettings>();
		for (SServerSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerSettings> convertToSListServerSettings(Collection<ServerSettings> input) {
		List<SServerSettings> result = new ArrayList<SServerSettings>();
		for (ServerSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerSettings> convertFromSListServerSettings(Collection<SServerSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerSettings> result = new ArrayList<ServerSettings>();
		for (SServerSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerSettings convertToSObject(ServerSettings input) {
		if (input == null) {
			return null;
		}
		
		SServerSettings result = new SServerSettings();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEmailSenderName(input.getEmailSenderName());
		result.setSiteAddress(input.getSiteAddress());
		result.setGenerateGeometryOnCheckin(input.isGenerateGeometryOnCheckin());
		result.setAllowOnlyWhitelisted(input.isAllowOnlyWhitelisted());
		result.getWhitelistedDomains().addAll(input.getWhitelistedDomains());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		List<Long> listwebModules = new ArrayList<Long>();
		for (WebModulePluginConfiguration v : input.getWebModules()) {
			listwebModules.add(v.getOid());
		}
		result.setWebModules(listwebModules);
		WebModulePluginConfiguration webModuleVal = input.getWebModule();
		result.setWebModuleId(webModuleVal == null ? -1 : webModuleVal.getOid());
		return result;
	}
	public ServerSettings convertFromSObject(SServerSettings input, DatabaseSession session) throws BimserverDatabaseException {
		ServerSettings result = convertFromSObject(input, StoreFactory.eINSTANCE.createServerSettings(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServerSettings convertFromSObject(SServerSettings input, ServerSettings result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEmailSenderName(input.getEmailSenderName());
		result.setSiteAddress(input.getSiteAddress());
		result.setGenerateGeometryOnCheckin(input.isGenerateGeometryOnCheckin());
		result.setAllowOnlyWhitelisted(input.isAllowOnlyWhitelisted());
		result.getWhitelistedDomains().addAll(input.getWhitelistedDomains());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		List<WebModulePluginConfiguration> listwebModules = result.getWebModules();
		for (long oid : input.getWebModules()) {
			listwebModules.add((WebModulePluginConfiguration)session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), oid, Query.getDefault()));
		}
		result.setWebModule((WebModulePluginConfiguration)session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), input.getWebModuleId(), Query.getDefault()));
		return result;
	}

	public Set<SUserSettings> convertToSSetUserSettings(Collection<UserSettings> input) {
		Set<SUserSettings> result = new HashSet<SUserSettings>();
		for (UserSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserSettings> convertFromSSetUserSettings(Collection<SUserSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserSettings> result = new HashSet<UserSettings>();
		for (SUserSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserSettings> convertToSListUserSettings(Collection<UserSettings> input) {
		List<SUserSettings> result = new ArrayList<SUserSettings>();
		for (UserSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserSettings> convertFromSListUserSettings(Collection<SUserSettings> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserSettings> result = new ArrayList<UserSettings>();
		for (SUserSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserSettings convertToSObject(UserSettings input) {
		if (input == null) {
			return null;
		}
		
		SUserSettings result = new SUserSettings();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		List<Long> listobjectIDMs = new ArrayList<Long>();
		for (ObjectIDMPluginConfiguration v : input.getObjectIDMs()) {
			listobjectIDMs.add(v.getOid());
		}
		result.setObjectIDMs(listobjectIDMs);
		List<Long> listrenderEngines = new ArrayList<Long>();
		for (RenderEnginePluginConfiguration v : input.getRenderEngines()) {
			listrenderEngines.add(v.getOid());
		}
		result.setRenderEngines(listrenderEngines);
		List<Long> listdeserializers = new ArrayList<Long>();
		for (DeserializerPluginConfiguration v : input.getDeserializers()) {
			listdeserializers.add(v.getOid());
		}
		result.setDeserializers(listdeserializers);
		List<Long> listqueryengines = new ArrayList<Long>();
		for (QueryEnginePluginConfiguration v : input.getQueryengines()) {
			listqueryengines.add(v.getOid());
		}
		result.setQueryengines(listqueryengines);
		List<Long> listmodelmergers = new ArrayList<Long>();
		for (ModelMergerPluginConfiguration v : input.getModelmergers()) {
			listmodelmergers.add(v.getOid());
		}
		result.setModelmergers(listmodelmergers);
		List<Long> listmodelcompares = new ArrayList<Long>();
		for (ModelComparePluginConfiguration v : input.getModelcompares()) {
			listmodelcompares.add(v.getOid());
		}
		result.setModelcompares(listmodelcompares);
		ModelMergerPluginConfiguration defaultModelMergerVal = input.getDefaultModelMerger();
		result.setDefaultModelMergerId(defaultModelMergerVal == null ? -1 : defaultModelMergerVal.getOid());
		ModelComparePluginConfiguration defaultModelCompareVal = input.getDefaultModelCompare();
		result.setDefaultModelCompareId(defaultModelCompareVal == null ? -1 : defaultModelCompareVal.getOid());
		QueryEnginePluginConfiguration defaultQueryEngineVal = input.getDefaultQueryEngine();
		result.setDefaultQueryEngineId(defaultQueryEngineVal == null ? -1 : defaultQueryEngineVal.getOid());
		RenderEnginePluginConfiguration defaultRenderEngineVal = input.getDefaultRenderEngine();
		result.setDefaultRenderEngineId(defaultRenderEngineVal == null ? -1 : defaultRenderEngineVal.getOid());
		SerializerPluginConfiguration defaultSerializerVal = input.getDefaultSerializer();
		result.setDefaultSerializerId(defaultSerializerVal == null ? -1 : defaultSerializerVal.getOid());
		ObjectIDMPluginConfiguration defaultObjectIDMVal = input.getDefaultObjectIDM();
		result.setDefaultObjectIDMId(defaultObjectIDMVal == null ? -1 : defaultObjectIDMVal.getOid());
		List<Long> listservices = new ArrayList<Long>();
		for (InternalServicePluginConfiguration v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		return result;
	}
	public UserSettings convertFromSObject(SUserSettings input, DatabaseSession session) throws BimserverDatabaseException {
		UserSettings result = convertFromSObject(input, StoreFactory.eINSTANCE.createUserSettings(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserSettings convertFromSObject(SUserSettings input, UserSettings result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, Query.getDefault()));
		}
		List<ObjectIDMPluginConfiguration> listobjectIDMs = result.getObjectIDMs();
		for (long oid : input.getObjectIDMs()) {
			listobjectIDMs.add((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), oid, Query.getDefault()));
		}
		List<RenderEnginePluginConfiguration> listrenderEngines = result.getRenderEngines();
		for (long oid : input.getRenderEngines()) {
			listrenderEngines.add((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), oid, Query.getDefault()));
		}
		List<DeserializerPluginConfiguration> listdeserializers = result.getDeserializers();
		for (long oid : input.getDeserializers()) {
			listdeserializers.add((DeserializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), oid, Query.getDefault()));
		}
		List<QueryEnginePluginConfiguration> listqueryengines = result.getQueryengines();
		for (long oid : input.getQueryengines()) {
			listqueryengines.add((QueryEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), oid, Query.getDefault()));
		}
		List<ModelMergerPluginConfiguration> listmodelmergers = result.getModelmergers();
		for (long oid : input.getModelmergers()) {
			listmodelmergers.add((ModelMergerPluginConfiguration)session.get(StorePackage.eINSTANCE.getModelMergerPluginConfiguration(), oid, Query.getDefault()));
		}
		List<ModelComparePluginConfiguration> listmodelcompares = result.getModelcompares();
		for (long oid : input.getModelcompares()) {
			listmodelcompares.add((ModelComparePluginConfiguration)session.get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), oid, Query.getDefault()));
		}
		result.setDefaultModelMerger((ModelMergerPluginConfiguration)session.get(StorePackage.eINSTANCE.getModelMergerPluginConfiguration(), input.getDefaultModelMergerId(), Query.getDefault()));
		result.setDefaultModelCompare((ModelComparePluginConfiguration)session.get(StorePackage.eINSTANCE.getModelComparePluginConfiguration(), input.getDefaultModelCompareId(), Query.getDefault()));
		result.setDefaultQueryEngine((QueryEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration(), input.getDefaultQueryEngineId(), Query.getDefault()));
		result.setDefaultRenderEngine((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), input.getDefaultRenderEngineId(), Query.getDefault()));
		result.setDefaultSerializer((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), input.getDefaultSerializerId(), Query.getDefault()));
		result.setDefaultObjectIDM((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), input.getDefaultObjectIDMId(), Query.getDefault()));
		List<InternalServicePluginConfiguration> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((InternalServicePluginConfiguration)session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SPluginConfiguration> convertToSSetPluginConfiguration(Collection<PluginConfiguration> input) {
		Set<SPluginConfiguration> result = new HashSet<SPluginConfiguration>();
		for (PluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginConfiguration> convertFromSSetPluginConfiguration(Collection<SPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginConfiguration> result = new HashSet<PluginConfiguration>();
		for (SPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginConfiguration> convertToSListPluginConfiguration(Collection<PluginConfiguration> input) {
		List<SPluginConfiguration> result = new ArrayList<SPluginConfiguration>();
		for (PluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginConfiguration> convertFromSListPluginConfiguration(Collection<SPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginConfiguration> result = new ArrayList<PluginConfiguration>();
		for (SPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginConfiguration convertToSObject(PluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ModelMergerPluginConfiguration) {
			return convertToSObject((ModelMergerPluginConfiguration)input);
		}
		else if (input instanceof ObjectIDMPluginConfiguration) {
			return convertToSObject((ObjectIDMPluginConfiguration)input);
		}
		else if (input instanceof ModelComparePluginConfiguration) {
			return convertToSObject((ModelComparePluginConfiguration)input);
		}
		else if (input instanceof RenderEnginePluginConfiguration) {
			return convertToSObject((RenderEnginePluginConfiguration)input);
		}
		else if (input instanceof InternalServicePluginConfiguration) {
			return convertToSObject((InternalServicePluginConfiguration)input);
		}
		else if (input instanceof DeserializerPluginConfiguration) {
			return convertToSObject((DeserializerPluginConfiguration)input);
		}
		else if (input instanceof QueryEnginePluginConfiguration) {
			return convertToSObject((QueryEnginePluginConfiguration)input);
		}
		else if (input instanceof SerializerPluginConfiguration) {
			return convertToSObject((SerializerPluginConfiguration)input);
		}
		else if (input instanceof WebModulePluginConfiguration) {
			return convertToSObject((WebModulePluginConfiguration)input);
		}
		SPluginConfiguration result = new SPluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}
	public PluginConfiguration convertFromSObject(SPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		PluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PluginConfiguration convertFromSObject(SPluginConfiguration input, PluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SModelMergerPluginConfiguration) {
			return convertFromSObject((SModelMergerPluginConfiguration)input, session);
		}
		else if (input instanceof SObjectIDMPluginConfiguration) {
			return convertFromSObject((SObjectIDMPluginConfiguration)input, session);
		}
		else if (input instanceof SModelComparePluginConfiguration) {
			return convertFromSObject((SModelComparePluginConfiguration)input, session);
		}
		else if (input instanceof SRenderEnginePluginConfiguration) {
			return convertFromSObject((SRenderEnginePluginConfiguration)input, session);
		}
		else if (input instanceof SInternalServicePluginConfiguration) {
			return convertFromSObject((SInternalServicePluginConfiguration)input, session);
		}
		else if (input instanceof SDeserializerPluginConfiguration) {
			return convertFromSObject((SDeserializerPluginConfiguration)input, session);
		}
		else if (input instanceof SQueryEnginePluginConfiguration) {
			return convertFromSObject((SQueryEnginePluginConfiguration)input, session);
		}
		else if (input instanceof SSerializerPluginConfiguration) {
			return convertFromSObject((SSerializerPluginConfiguration)input, session);
		}
		else if (input instanceof SWebModulePluginConfiguration) {
			return convertFromSObject((SWebModulePluginConfiguration)input, session);
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SSerializerPluginConfiguration> convertToSSetSerializerPluginConfiguration(Collection<SerializerPluginConfiguration> input) {
		Set<SSerializerPluginConfiguration> result = new HashSet<SSerializerPluginConfiguration>();
		for (SerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SerializerPluginConfiguration> convertFromSSetSerializerPluginConfiguration(Collection<SSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SerializerPluginConfiguration> result = new HashSet<SerializerPluginConfiguration>();
		for (SSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSerializerPluginConfiguration> convertToSListSerializerPluginConfiguration(Collection<SerializerPluginConfiguration> input) {
		List<SSerializerPluginConfiguration> result = new ArrayList<SSerializerPluginConfiguration>();
		for (SerializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SerializerPluginConfiguration> convertFromSListSerializerPluginConfiguration(Collection<SSerializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SerializerPluginConfiguration> result = new ArrayList<SerializerPluginConfiguration>();
		for (SSerializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSerializerPluginConfiguration convertToSObject(SerializerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SSerializerPluginConfiguration result = new SSerializerPluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		ObjectIDMPluginConfiguration objectIDMVal = input.getObjectIDM();
		result.setObjectIDMId(objectIDMVal == null ? -1 : objectIDMVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		RenderEnginePluginConfiguration renderEngineVal = input.getRenderEngine();
		result.setRenderEngineId(renderEngineVal == null ? -1 : renderEngineVal.getOid());
		return result;
	}
	public SerializerPluginConfiguration convertFromSObject(SSerializerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		SerializerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createSerializerPluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public SerializerPluginConfiguration convertFromSObject(SSerializerPluginConfiguration input, SerializerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setObjectIDM((ObjectIDMPluginConfiguration)session.get(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration(), input.getObjectIDMId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		result.setRenderEngine((RenderEnginePluginConfiguration)session.get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), input.getRenderEngineId(), Query.getDefault()));
		return result;
	}

	public Set<SObjectIDMPluginConfiguration> convertToSSetObjectIDMPluginConfiguration(Collection<ObjectIDMPluginConfiguration> input) {
		Set<SObjectIDMPluginConfiguration> result = new HashSet<SObjectIDMPluginConfiguration>();
		for (ObjectIDMPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDMPluginConfiguration> convertFromSSetObjectIDMPluginConfiguration(Collection<SObjectIDMPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectIDMPluginConfiguration> result = new HashSet<ObjectIDMPluginConfiguration>();
		for (SObjectIDMPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectIDMPluginConfiguration> convertToSListObjectIDMPluginConfiguration(Collection<ObjectIDMPluginConfiguration> input) {
		List<SObjectIDMPluginConfiguration> result = new ArrayList<SObjectIDMPluginConfiguration>();
		for (ObjectIDMPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectIDMPluginConfiguration> convertFromSListObjectIDMPluginConfiguration(Collection<SObjectIDMPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectIDMPluginConfiguration> result = new ArrayList<ObjectIDMPluginConfiguration>();
		for (SObjectIDMPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectIDMPluginConfiguration convertToSObject(ObjectIDMPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SObjectIDMPluginConfiguration result = new SObjectIDMPluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public ObjectIDMPluginConfiguration convertFromSObject(SObjectIDMPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectIDMPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectIDMPluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectIDMPluginConfiguration convertFromSObject(SObjectIDMPluginConfiguration input, ObjectIDMPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, Query.getDefault()));
		}
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SRenderEnginePluginConfiguration> convertToSSetRenderEnginePluginConfiguration(Collection<RenderEnginePluginConfiguration> input) {
		Set<SRenderEnginePluginConfiguration> result = new HashSet<SRenderEnginePluginConfiguration>();
		for (RenderEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RenderEnginePluginConfiguration> convertFromSSetRenderEnginePluginConfiguration(Collection<SRenderEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RenderEnginePluginConfiguration> result = new HashSet<RenderEnginePluginConfiguration>();
		for (SRenderEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRenderEnginePluginConfiguration> convertToSListRenderEnginePluginConfiguration(Collection<RenderEnginePluginConfiguration> input) {
		List<SRenderEnginePluginConfiguration> result = new ArrayList<SRenderEnginePluginConfiguration>();
		for (RenderEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RenderEnginePluginConfiguration> convertFromSListRenderEnginePluginConfiguration(Collection<SRenderEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RenderEnginePluginConfiguration> result = new ArrayList<RenderEnginePluginConfiguration>();
		for (SRenderEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRenderEnginePluginConfiguration convertToSObject(RenderEnginePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SRenderEnginePluginConfiguration result = new SRenderEnginePluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		List<Long> listserializers = new ArrayList<Long>();
		for (SerializerPluginConfiguration v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public RenderEnginePluginConfiguration convertFromSObject(SRenderEnginePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		RenderEnginePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createRenderEnginePluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RenderEnginePluginConfiguration convertFromSObject(SRenderEnginePluginConfiguration input, RenderEnginePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		List<SerializerPluginConfiguration> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((SerializerPluginConfiguration)session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), oid, Query.getDefault()));
		}
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SDeserializerPluginConfiguration> convertToSSetDeserializerPluginConfiguration(Collection<DeserializerPluginConfiguration> input) {
		Set<SDeserializerPluginConfiguration> result = new HashSet<SDeserializerPluginConfiguration>();
		for (DeserializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DeserializerPluginConfiguration> convertFromSSetDeserializerPluginConfiguration(Collection<SDeserializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DeserializerPluginConfiguration> result = new HashSet<DeserializerPluginConfiguration>();
		for (SDeserializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDeserializerPluginConfiguration> convertToSListDeserializerPluginConfiguration(Collection<DeserializerPluginConfiguration> input) {
		List<SDeserializerPluginConfiguration> result = new ArrayList<SDeserializerPluginConfiguration>();
		for (DeserializerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DeserializerPluginConfiguration> convertFromSListDeserializerPluginConfiguration(Collection<SDeserializerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DeserializerPluginConfiguration> result = new ArrayList<DeserializerPluginConfiguration>();
		for (SDeserializerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDeserializerPluginConfiguration convertToSObject(DeserializerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SDeserializerPluginConfiguration result = new SDeserializerPluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public DeserializerPluginConfiguration convertFromSObject(SDeserializerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		DeserializerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createDeserializerPluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DeserializerPluginConfiguration convertFromSObject(SDeserializerPluginConfiguration input, DeserializerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SDownloadResult> convertToSSetDownloadResult(Collection<DownloadResult> input) {
		Set<SDownloadResult> result = new HashSet<SDownloadResult>();
		for (DownloadResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DownloadResult> convertFromSSetDownloadResult(Collection<SDownloadResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DownloadResult> result = new HashSet<DownloadResult>();
		for (SDownloadResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownloadResult> convertToSListDownloadResult(Collection<DownloadResult> input) {
		List<SDownloadResult> result = new ArrayList<SDownloadResult>();
		for (DownloadResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DownloadResult> convertFromSListDownloadResult(Collection<SDownloadResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DownloadResult> result = new ArrayList<DownloadResult>();
		for (SDownloadResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDownloadResult convertToSObject(DownloadResult input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof CheckoutResult) {
			return convertToSObject((CheckoutResult)input);
		}
		SDownloadResult result = new SDownloadResult();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}
	public DownloadResult convertFromSObject(SDownloadResult input, DatabaseSession session) throws BimserverDatabaseException {
		DownloadResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createDownloadResult(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input, DownloadResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SCheckoutResult) {
			return convertFromSObject((SCheckoutResult)input, session);
		}
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public Set<SCheckoutResult> convertToSSetCheckoutResult(Collection<CheckoutResult> input) {
		Set<SCheckoutResult> result = new HashSet<SCheckoutResult>();
		for (CheckoutResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckoutResult> convertFromSSetCheckoutResult(Collection<SCheckoutResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CheckoutResult> result = new HashSet<CheckoutResult>();
		for (SCheckoutResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckoutResult> convertToSListCheckoutResult(Collection<CheckoutResult> input) {
		List<SCheckoutResult> result = new ArrayList<SCheckoutResult>();
		for (CheckoutResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CheckoutResult> convertFromSListCheckoutResult(Collection<SCheckoutResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CheckoutResult> result = new ArrayList<CheckoutResult>();
		for (SCheckoutResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckoutResult convertToSObject(CheckoutResult input) {
		if (input == null) {
			return null;
		}
		
		SCheckoutResult result = new SCheckoutResult();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}
	public CheckoutResult convertFromSObject(SCheckoutResult input, DatabaseSession session) throws BimserverDatabaseException {
		CheckoutResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createCheckoutResult(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input, CheckoutResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public Set<SDataValue> convertToSSetDataValue(Collection<DataValue> input) {
		Set<SDataValue> result = new HashSet<SDataValue>();
		for (DataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DataValue> convertFromSSetDataValue(Collection<SDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DataValue> result = new HashSet<DataValue>();
		for (SDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDataValue> convertToSListDataValue(Collection<DataValue> input) {
		List<SDataValue> result = new ArrayList<SDataValue>();
		for (DataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DataValue> convertFromSListDataValue(Collection<SDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DataValue> result = new ArrayList<DataValue>();
		for (SDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDataValue convertToSObject(DataValue input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ReferenceDataValue) {
			return convertToSObject((ReferenceDataValue)input);
		}
		else if (input instanceof ListDataValue) {
			return convertToSObject((ListDataValue)input);
		}
		else if (input instanceof SimpleDataValue) {
			return convertToSObject((SimpleDataValue)input);
		}
		SDataValue result = new SDataValue();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		return result;
	}
	public DataValue convertFromSObject(SDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		DataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createDataValue(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DataValue convertFromSObject(SDataValue input, DataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SReferenceDataValue) {
			return convertFromSObject((SReferenceDataValue)input, session);
		}
		else if (input instanceof SListDataValue) {
			return convertFromSObject((SListDataValue)input, session);
		}
		else if (input instanceof SSimpleDataValue) {
			return convertFromSObject((SSimpleDataValue)input, session);
		}
		result.setFieldName(input.getFieldName());
		return result;
	}

	public Set<SDataObject> convertToSSetDataObject(Collection<DataObject> input) {
		Set<SDataObject> result = new HashSet<SDataObject>();
		for (DataObject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DataObject> convertFromSSetDataObject(Collection<SDataObject> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DataObject> result = new HashSet<DataObject>();
		for (SDataObject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDataObject> convertToSListDataObject(Collection<DataObject> input) {
		List<SDataObject> result = new ArrayList<SDataObject>();
		for (DataObject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DataObject> convertFromSListDataObject(Collection<SDataObject> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DataObject> result = new ArrayList<DataObject>();
		for (SDataObject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDataObject convertToSObject(DataObject input) {
		if (input == null) {
			return null;
		}
		
		SDataObject result = new SDataObject();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setType(input.getType());
		result.setGuid(input.getGuid());
		result.setName(input.getName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}
	public DataObject convertFromSObject(SDataObject input, DatabaseSession session) throws BimserverDatabaseException {
		DataObject result = convertFromSObject(input, StoreFactory.eINSTANCE.createDataObject(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DataObject convertFromSObject(SDataObject input, DataObject result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(input.getType());
		result.setGuid(input.getGuid());
		result.setName(input.getName());
		List<DataValue> listvalues = result.getValues();
		for (SDataValue v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SUserSession> convertToSSetUserSession(Collection<UserSession> input) {
		Set<SUserSession> result = new HashSet<SUserSession>();
		for (UserSession o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserSession> convertFromSSetUserSession(Collection<SUserSession> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<UserSession> result = new HashSet<UserSession>();
		for (SUserSession o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserSession> convertToSListUserSession(Collection<UserSession> input) {
		List<SUserSession> result = new ArrayList<SUserSession>();
		for (UserSession o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserSession> convertFromSListUserSession(Collection<SUserSession> input, DatabaseSession session) throws BimserverDatabaseException {
		List<UserSession> result = new ArrayList<UserSession>();
		for (SUserSession o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserSession convertToSObject(UserSession input) {
		if (input == null) {
			return null;
		}
		
		SUserSession result = new SUserSession();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setType(SUserType.values()[input.getType().ordinal()]);
		result.setRemoteAddress(input.getRemoteAddress());
		result.setActiveSince(input.getActiveSince());
		result.setLastActive(input.getLastActive());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public UserSession convertFromSObject(SUserSession input, DatabaseSession session) throws BimserverDatabaseException {
		UserSession result = convertFromSObject(input, StoreFactory.eINSTANCE.createUserSession(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public UserSession convertFromSObject(SUserSession input, UserSession result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setType(UserType.values()[input.getType().ordinal()]);
		result.setRemoteAddress(input.getRemoteAddress());
		result.setActiveSince(input.getActiveSince());
		result.setLastActive(input.getLastActive());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SMigration> convertToSSetMigration(Collection<Migration> input) {
		Set<SMigration> result = new HashSet<SMigration>();
		for (Migration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Migration> convertFromSSetMigration(Collection<SMigration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Migration> result = new HashSet<Migration>();
		for (SMigration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SMigration> convertToSListMigration(Collection<Migration> input) {
		List<SMigration> result = new ArrayList<SMigration>();
		for (Migration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Migration> convertFromSListMigration(Collection<SMigration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Migration> result = new ArrayList<Migration>();
		for (SMigration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SMigration convertToSObject(Migration input) {
		if (input == null) {
			return null;
		}
		
		SMigration result = new SMigration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.getExecuted());
		return result;
	}
	public Migration convertFromSObject(SMigration input, DatabaseSession session) throws BimserverDatabaseException {
		Migration result = convertFromSObject(input, StoreFactory.eINSTANCE.createMigration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Migration convertFromSObject(SMigration input, Migration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.getExecuted());
		return result;
	}

	public Set<SReferenceDataValue> convertToSSetReferenceDataValue(Collection<ReferenceDataValue> input) {
		Set<SReferenceDataValue> result = new HashSet<SReferenceDataValue>();
		for (ReferenceDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ReferenceDataValue> convertFromSSetReferenceDataValue(Collection<SReferenceDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ReferenceDataValue> result = new HashSet<ReferenceDataValue>();
		for (SReferenceDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SReferenceDataValue> convertToSListReferenceDataValue(Collection<ReferenceDataValue> input) {
		List<SReferenceDataValue> result = new ArrayList<SReferenceDataValue>();
		for (ReferenceDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ReferenceDataValue> convertFromSListReferenceDataValue(Collection<SReferenceDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ReferenceDataValue> result = new ArrayList<ReferenceDataValue>();
		for (SReferenceDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SReferenceDataValue convertToSObject(ReferenceDataValue input) {
		if (input == null) {
			return null;
		}
		
		SReferenceDataValue result = new SReferenceDataValue();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}
	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		ReferenceDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createReferenceDataValue(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, ReferenceDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}

	public Set<SListDataValue> convertToSSetListDataValue(Collection<ListDataValue> input) {
		Set<SListDataValue> result = new HashSet<SListDataValue>();
		for (ListDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ListDataValue> convertFromSSetListDataValue(Collection<SListDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ListDataValue> result = new HashSet<ListDataValue>();
		for (SListDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SListDataValue> convertToSListListDataValue(Collection<ListDataValue> input) {
		List<SListDataValue> result = new ArrayList<SListDataValue>();
		for (ListDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ListDataValue> convertFromSListListDataValue(Collection<SListDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ListDataValue> result = new ArrayList<ListDataValue>();
		for (SListDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SListDataValue convertToSObject(ListDataValue input) {
		if (input == null) {
			return null;
		}
		
		SListDataValue result = new SListDataValue();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}
	public ListDataValue convertFromSObject(SListDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		ListDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createListDataValue(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input, ListDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		List<DataValue> listvalues = result.getValues();
		for (SDataValue v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SSimpleDataValue> convertToSSetSimpleDataValue(Collection<SimpleDataValue> input) {
		Set<SSimpleDataValue> result = new HashSet<SSimpleDataValue>();
		for (SimpleDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SimpleDataValue> convertFromSSetSimpleDataValue(Collection<SSimpleDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SimpleDataValue> result = new HashSet<SimpleDataValue>();
		for (SSimpleDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSimpleDataValue> convertToSListSimpleDataValue(Collection<SimpleDataValue> input) {
		List<SSimpleDataValue> result = new ArrayList<SSimpleDataValue>();
		for (SimpleDataValue o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SimpleDataValue> convertFromSListSimpleDataValue(Collection<SSimpleDataValue> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SimpleDataValue> result = new ArrayList<SimpleDataValue>();
		for (SSimpleDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSimpleDataValue convertToSObject(SimpleDataValue input) {
		if (input == null) {
			return null;
		}
		
		SSimpleDataValue result = new SSimpleDataValue();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}
	public SimpleDataValue convertFromSObject(SSimpleDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		SimpleDataValue result = convertFromSObject(input, StoreFactory.eINSTANCE.createSimpleDataValue(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input, SimpleDataValue result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}

	public Set<SDatabaseInformationItem> convertToSSetDatabaseInformationItem(Collection<DatabaseInformationItem> input) {
		Set<SDatabaseInformationItem> result = new HashSet<SDatabaseInformationItem>();
		for (DatabaseInformationItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformationItem> convertFromSSetDatabaseInformationItem(Collection<SDatabaseInformationItem> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformationItem> result = new HashSet<DatabaseInformationItem>();
		for (SDatabaseInformationItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformationItem> convertToSListDatabaseInformationItem(Collection<DatabaseInformationItem> input) {
		List<SDatabaseInformationItem> result = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformationItem> convertFromSListDatabaseInformationItem(Collection<SDatabaseInformationItem> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformationItem> result = new ArrayList<DatabaseInformationItem>();
		for (SDatabaseInformationItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformationItem convertToSObject(DatabaseInformationItem input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformationItem result = new SDatabaseInformationItem();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}
	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, DatabaseSession session) throws BimserverDatabaseException {
		DatabaseInformationItem result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformationItem(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, DatabaseInformationItem result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}

	public Set<SDatabaseInformationCategory> convertToSSetDatabaseInformationCategory(Collection<DatabaseInformationCategory> input) {
		Set<SDatabaseInformationCategory> result = new HashSet<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformationCategory> convertFromSSetDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformationCategory> result = new HashSet<DatabaseInformationCategory>();
		for (SDatabaseInformationCategory o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformationCategory> convertToSListDatabaseInformationCategory(Collection<DatabaseInformationCategory> input) {
		List<SDatabaseInformationCategory> result = new ArrayList<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformationCategory> convertFromSListDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformationCategory> result = new ArrayList<DatabaseInformationCategory>();
		for (SDatabaseInformationCategory o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformationCategory convertToSObject(DatabaseInformationCategory input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformationCategory result = new SDatabaseInformationCategory();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setTitle(input.getTitle());
		List<SDatabaseInformationItem> listitems = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}
	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, DatabaseSession session) throws BimserverDatabaseException {
		DatabaseInformationCategory result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformationCategory(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, DatabaseInformationCategory result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setTitle(input.getTitle());
		List<DatabaseInformationItem> listitems = result.getItems();
		for (SDatabaseInformationItem v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SDatabaseInformation> convertToSSetDatabaseInformation(Collection<DatabaseInformation> input) {
		Set<SDatabaseInformation> result = new HashSet<SDatabaseInformation>();
		for (DatabaseInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseInformation> convertFromSSetDatabaseInformation(Collection<SDatabaseInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DatabaseInformation> result = new HashSet<DatabaseInformation>();
		for (SDatabaseInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseInformation> convertToSListDatabaseInformation(Collection<DatabaseInformation> input) {
		List<SDatabaseInformation> result = new ArrayList<SDatabaseInformation>();
		for (DatabaseInformation o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseInformation> convertFromSListDatabaseInformation(Collection<SDatabaseInformation> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DatabaseInformation> result = new ArrayList<DatabaseInformation>();
		for (SDatabaseInformation o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseInformation convertToSObject(DatabaseInformation input) {
		if (input == null) {
			return null;
		}
		
		SDatabaseInformation result = new SDatabaseInformation();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setNumberOfProjects(input.getNumberOfProjects());
		result.setNumberOfUsers(input.getNumberOfUsers());
		result.setNumberOfRevisions(input.getNumberOfRevisions());
		result.setNumberOfCheckouts(input.getNumberOfCheckouts());
		result.setDatabaseSizeInBytes(input.getDatabaseSizeInBytes());
		result.setType(input.getType());
		result.setCreated(input.getCreated());
		result.setLocation(input.getLocation());
		result.setSchemaVersion(input.getSchemaVersion());
		List<SDatabaseInformationCategory> listcategories = new ArrayList<SDatabaseInformationCategory>();
		for (DatabaseInformationCategory v : input.getCategories()) {
			listcategories.add(convertToSObject(v));
		}
		result.setCategories(listcategories);
		return result;
	}
	public DatabaseInformation convertFromSObject(SDatabaseInformation input, DatabaseSession session) throws BimserverDatabaseException {
		DatabaseInformation result = convertFromSObject(input, StoreFactory.eINSTANCE.createDatabaseInformation(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DatabaseInformation convertFromSObject(SDatabaseInformation input, DatabaseInformation result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setNumberOfProjects(input.getNumberOfProjects());
		result.setNumberOfUsers(input.getNumberOfUsers());
		result.setNumberOfRevisions(input.getNumberOfRevisions());
		result.setNumberOfCheckouts(input.getNumberOfCheckouts());
		result.setDatabaseSizeInBytes(input.getDatabaseSizeInBytes());
		result.setType(input.getType());
		result.setCreated(input.getCreated());
		result.setLocation(input.getLocation());
		result.setSchemaVersion(input.getSchemaVersion());
		List<DatabaseInformationCategory> listcategories = result.getCategories();
		for (SDatabaseInformationCategory v : input.getCategories()) {
			listcategories.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPluginDescriptor> convertToSSetPluginDescriptor(Collection<PluginDescriptor> input) {
		Set<SPluginDescriptor> result = new HashSet<SPluginDescriptor>();
		for (PluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PluginDescriptor> convertFromSSetPluginDescriptor(Collection<SPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PluginDescriptor> result = new HashSet<PluginDescriptor>();
		for (SPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPluginDescriptor> convertToSListPluginDescriptor(Collection<PluginDescriptor> input) {
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		for (PluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PluginDescriptor> convertFromSListPluginDescriptor(Collection<SPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PluginDescriptor> result = new ArrayList<PluginDescriptor>();
		for (SPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPluginDescriptor convertToSObject(PluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof WebModulePluginDescriptor) {
			return convertToSObject((WebModulePluginDescriptor)input);
		}
		else if (input instanceof QueryEnginePluginDescriptor) {
			return convertToSObject((QueryEnginePluginDescriptor)input);
		}
		else if (input instanceof RenderEnginePluginDescriptor) {
			return convertToSObject((RenderEnginePluginDescriptor)input);
		}
		else if (input instanceof ModelComparePluginDescriptor) {
			return convertToSObject((ModelComparePluginDescriptor)input);
		}
		else if (input instanceof ModelMergerPluginDescriptor) {
			return convertToSObject((ModelMergerPluginDescriptor)input);
		}
		else if (input instanceof SerializerPluginDescriptor) {
			return convertToSObject((SerializerPluginDescriptor)input);
		}
		else if (input instanceof DeserializerPluginDescriptor) {
			return convertToSObject((DeserializerPluginDescriptor)input);
		}
		else if (input instanceof ServicePluginDescriptor) {
			return convertToSObject((ServicePluginDescriptor)input);
		}
		SPluginDescriptor result = new SPluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public PluginDescriptor convertFromSObject(SPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		PluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createPluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input, PluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SWebModulePluginDescriptor) {
			return convertFromSObject((SWebModulePluginDescriptor)input, session);
		}
		else if (input instanceof SQueryEnginePluginDescriptor) {
			return convertFromSObject((SQueryEnginePluginDescriptor)input, session);
		}
		else if (input instanceof SRenderEnginePluginDescriptor) {
			return convertFromSObject((SRenderEnginePluginDescriptor)input, session);
		}
		else if (input instanceof SModelComparePluginDescriptor) {
			return convertFromSObject((SModelComparePluginDescriptor)input, session);
		}
		else if (input instanceof SModelMergerPluginDescriptor) {
			return convertFromSObject((SModelMergerPluginDescriptor)input, session);
		}
		else if (input instanceof SSerializerPluginDescriptor) {
			return convertFromSObject((SSerializerPluginDescriptor)input, session);
		}
		else if (input instanceof SDeserializerPluginDescriptor) {
			return convertFromSObject((SDeserializerPluginDescriptor)input, session);
		}
		else if (input instanceof SServicePluginDescriptor) {
			return convertFromSObject((SServicePluginDescriptor)input, session);
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SSerializerPluginDescriptor> convertToSSetSerializerPluginDescriptor(Collection<SerializerPluginDescriptor> input) {
		Set<SSerializerPluginDescriptor> result = new HashSet<SSerializerPluginDescriptor>();
		for (SerializerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SerializerPluginDescriptor> convertFromSSetSerializerPluginDescriptor(Collection<SSerializerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SerializerPluginDescriptor> result = new HashSet<SerializerPluginDescriptor>();
		for (SSerializerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSerializerPluginDescriptor> convertToSListSerializerPluginDescriptor(Collection<SerializerPluginDescriptor> input) {
		List<SSerializerPluginDescriptor> result = new ArrayList<SSerializerPluginDescriptor>();
		for (SerializerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SerializerPluginDescriptor> convertFromSListSerializerPluginDescriptor(Collection<SSerializerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SerializerPluginDescriptor> result = new ArrayList<SerializerPluginDescriptor>();
		for (SSerializerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSerializerPluginDescriptor convertToSObject(SerializerPluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SSerializerPluginDescriptor result = new SSerializerPluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public SerializerPluginDescriptor convertFromSObject(SSerializerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		SerializerPluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createSerializerPluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public SerializerPluginDescriptor convertFromSObject(SSerializerPluginDescriptor input, SerializerPluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SDeserializerPluginDescriptor> convertToSSetDeserializerPluginDescriptor(Collection<DeserializerPluginDescriptor> input) {
		Set<SDeserializerPluginDescriptor> result = new HashSet<SDeserializerPluginDescriptor>();
		for (DeserializerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DeserializerPluginDescriptor> convertFromSSetDeserializerPluginDescriptor(Collection<SDeserializerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DeserializerPluginDescriptor> result = new HashSet<DeserializerPluginDescriptor>();
		for (SDeserializerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDeserializerPluginDescriptor> convertToSListDeserializerPluginDescriptor(Collection<DeserializerPluginDescriptor> input) {
		List<SDeserializerPluginDescriptor> result = new ArrayList<SDeserializerPluginDescriptor>();
		for (DeserializerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DeserializerPluginDescriptor> convertFromSListDeserializerPluginDescriptor(Collection<SDeserializerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DeserializerPluginDescriptor> result = new ArrayList<DeserializerPluginDescriptor>();
		for (SDeserializerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDeserializerPluginDescriptor convertToSObject(DeserializerPluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SDeserializerPluginDescriptor result = new SDeserializerPluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public DeserializerPluginDescriptor convertFromSObject(SDeserializerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		DeserializerPluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createDeserializerPluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DeserializerPluginDescriptor convertFromSObject(SDeserializerPluginDescriptor input, DeserializerPluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SRevisionSummaryType> convertToSSetRevisionSummaryType(Collection<RevisionSummaryType> input) {
		Set<SRevisionSummaryType> result = new HashSet<SRevisionSummaryType>();
		for (RevisionSummaryType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummaryType> convertFromSSetRevisionSummaryType(Collection<SRevisionSummaryType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummaryType> result = new HashSet<RevisionSummaryType>();
		for (SRevisionSummaryType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummaryType> convertToSListRevisionSummaryType(Collection<RevisionSummaryType> input) {
		List<SRevisionSummaryType> result = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummaryType> convertFromSListRevisionSummaryType(Collection<SRevisionSummaryType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummaryType> result = new ArrayList<RevisionSummaryType>();
		for (SRevisionSummaryType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummaryType convertToSObject(RevisionSummaryType input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummaryType result = new SRevisionSummaryType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setCount(input.getCount());
		return result;
	}
	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, DatabaseSession session) throws BimserverDatabaseException {
		RevisionSummaryType result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummaryType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, RevisionSummaryType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setCount(input.getCount());
		return result;
	}

	public Set<SRevisionSummaryContainer> convertToSSetRevisionSummaryContainer(Collection<RevisionSummaryContainer> input) {
		Set<SRevisionSummaryContainer> result = new HashSet<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummaryContainer> convertFromSSetRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummaryContainer> result = new HashSet<RevisionSummaryContainer>();
		for (SRevisionSummaryContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummaryContainer> convertToSListRevisionSummaryContainer(Collection<RevisionSummaryContainer> input) {
		List<SRevisionSummaryContainer> result = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummaryContainer> convertFromSListRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummaryContainer> result = new ArrayList<RevisionSummaryContainer>();
		for (SRevisionSummaryContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummaryContainer convertToSObject(RevisionSummaryContainer input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummaryContainer result = new SRevisionSummaryContainer();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		List<SRevisionSummaryType> listtypes = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertToSObject(v));
		}
		result.setTypes(listtypes);
		return result;
	}
	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, DatabaseSession session) throws BimserverDatabaseException {
		RevisionSummaryContainer result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummaryContainer(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, RevisionSummaryContainer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		List<RevisionSummaryType> listtypes = result.getTypes();
		for (SRevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SRevisionSummary> convertToSSetRevisionSummary(Collection<RevisionSummary> input) {
		Set<SRevisionSummary> result = new HashSet<SRevisionSummary>();
		for (RevisionSummary o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummary> convertFromSSetRevisionSummary(Collection<SRevisionSummary> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RevisionSummary> result = new HashSet<RevisionSummary>();
		for (SRevisionSummary o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionSummary> convertToSListRevisionSummary(Collection<RevisionSummary> input) {
		List<SRevisionSummary> result = new ArrayList<SRevisionSummary>();
		for (RevisionSummary o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionSummary> convertFromSListRevisionSummary(Collection<SRevisionSummary> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RevisionSummary> result = new ArrayList<RevisionSummary>();
		for (SRevisionSummary o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionSummary convertToSObject(RevisionSummary input) {
		if (input == null) {
			return null;
		}
		
		SRevisionSummary result = new SRevisionSummary();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		List<SRevisionSummaryContainer> listlist = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer v : input.getList()) {
			listlist.add(convertToSObject(v));
		}
		result.setList(listlist);
		return result;
	}
	public RevisionSummary convertFromSObject(SRevisionSummary input, DatabaseSession session) throws BimserverDatabaseException {
		RevisionSummary result = convertFromSObject(input, StoreFactory.eINSTANCE.createRevisionSummary(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input, RevisionSummary result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<RevisionSummaryContainer> listlist = result.getList();
		for (SRevisionSummaryContainer v : input.getList()) {
			listlist.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SLongAction> convertToSSetLongAction(Collection<LongAction> input) {
		Set<SLongAction> result = new HashSet<SLongAction>();
		for (LongAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongAction> convertFromSSetLongAction(Collection<SLongAction> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongAction> result = new HashSet<LongAction>();
		for (SLongAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongAction> convertToSListLongAction(Collection<LongAction> input) {
		List<SLongAction> result = new ArrayList<SLongAction>();
		for (LongAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongAction> convertFromSListLongAction(Collection<SLongAction> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongAction> result = new ArrayList<LongAction>();
		for (SLongAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongAction convertToSObject(LongAction input) {
		if (input == null) {
			return null;
		}
		
		SLongAction result = new SLongAction();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}
	public LongAction convertFromSObject(SLongAction input, DatabaseSession session) throws BimserverDatabaseException {
		LongAction result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongAction(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public LongAction convertFromSObject(SLongAction input, LongAction result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		return result;
	}

	public Set<SObjectIDMPluginDescriptor> convertToSSetObjectIDMPluginDescriptor(Collection<ObjectIDMPluginDescriptor> input) {
		Set<SObjectIDMPluginDescriptor> result = new HashSet<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDMPluginDescriptor> convertFromSSetObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectIDMPluginDescriptor> result = new HashSet<ObjectIDMPluginDescriptor>();
		for (SObjectIDMPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectIDMPluginDescriptor> convertToSListObjectIDMPluginDescriptor(Collection<ObjectIDMPluginDescriptor> input) {
		List<SObjectIDMPluginDescriptor> result = new ArrayList<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectIDMPluginDescriptor> convertFromSListObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectIDMPluginDescriptor> result = new ArrayList<ObjectIDMPluginDescriptor>();
		for (SObjectIDMPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectIDMPluginDescriptor convertToSObject(ObjectIDMPluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SObjectIDMPluginDescriptor result = new SObjectIDMPluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setClassName(input.getClassName());
		return result;
	}
	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectIDMPluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectIDMPluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, ObjectIDMPluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setClassName(input.getClassName());
		return result;
	}
		public SCompareType convertToSObject(CompareType input) {
			return SCompareType.values()[input.ordinal()];
		}
		
		public CompareType convertFromSObject(SCompareType input) {
			return CompareType.values()[input.ordinal()];
		}

	public Set<SCompareItem> convertToSSetCompareItem(Collection<CompareItem> input) {
		Set<SCompareItem> result = new HashSet<SCompareItem>();
		for (CompareItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareItem> convertFromSSetCompareItem(Collection<SCompareItem> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareItem> result = new HashSet<CompareItem>();
		for (SCompareItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareItem> convertToSListCompareItem(Collection<CompareItem> input) {
		List<SCompareItem> result = new ArrayList<SCompareItem>();
		for (CompareItem o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareItem> convertFromSListCompareItem(Collection<SCompareItem> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareItem> result = new ArrayList<CompareItem>();
		for (SCompareItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareItem convertToSObject(CompareItem input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ObjectAdded) {
			return convertToSObject((ObjectAdded)input);
		}
		else if (input instanceof ObjectModified) {
			return convertToSObject((ObjectModified)input);
		}
		else if (input instanceof ObjectRemoved) {
			return convertToSObject((ObjectRemoved)input);
		}
		SCompareItem result = new SCompareItem();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}
	public CompareItem convertFromSObject(SCompareItem input, DatabaseSession session) throws BimserverDatabaseException {
		CompareItem result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareItem(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input, CompareItem result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SObjectAdded) {
			return convertFromSObject((SObjectAdded)input, session);
		}
		else if (input instanceof SObjectModified) {
			return convertFromSObject((SObjectModified)input, session);
		}
		else if (input instanceof SObjectRemoved) {
			return convertFromSObject((SObjectRemoved)input, session);
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectAdded> convertToSSetObjectAdded(Collection<ObjectAdded> input) {
		Set<SObjectAdded> result = new HashSet<SObjectAdded>();
		for (ObjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectAdded> convertFromSSetObjectAdded(Collection<SObjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectAdded> result = new HashSet<ObjectAdded>();
		for (SObjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectAdded> convertToSListObjectAdded(Collection<ObjectAdded> input) {
		List<SObjectAdded> result = new ArrayList<SObjectAdded>();
		for (ObjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectAdded> convertFromSListObjectAdded(Collection<SObjectAdded> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectAdded> result = new ArrayList<ObjectAdded>();
		for (SObjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectAdded convertToSObject(ObjectAdded input) {
		if (input == null) {
			return null;
		}
		
		SObjectAdded result = new SObjectAdded();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}
	public ObjectAdded convertFromSObject(SObjectAdded input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectAdded result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectAdded(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input, ObjectAdded result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectRemoved> convertToSSetObjectRemoved(Collection<ObjectRemoved> input) {
		Set<SObjectRemoved> result = new HashSet<SObjectRemoved>();
		for (ObjectRemoved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectRemoved> convertFromSSetObjectRemoved(Collection<SObjectRemoved> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectRemoved> result = new HashSet<ObjectRemoved>();
		for (SObjectRemoved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectRemoved> convertToSListObjectRemoved(Collection<ObjectRemoved> input) {
		List<SObjectRemoved> result = new ArrayList<SObjectRemoved>();
		for (ObjectRemoved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectRemoved> convertFromSListObjectRemoved(Collection<SObjectRemoved> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectRemoved> result = new ArrayList<ObjectRemoved>();
		for (SObjectRemoved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectRemoved convertToSObject(ObjectRemoved input) {
		if (input == null) {
			return null;
		}
		
		SObjectRemoved result = new SObjectRemoved();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}
	public ObjectRemoved convertFromSObject(SObjectRemoved input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectRemoved result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectRemoved(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input, ObjectRemoved result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SObjectModified> convertToSSetObjectModified(Collection<ObjectModified> input) {
		Set<SObjectModified> result = new HashSet<SObjectModified>();
		for (ObjectModified o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectModified> convertFromSSetObjectModified(Collection<SObjectModified> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectModified> result = new HashSet<ObjectModified>();
		for (SObjectModified o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectModified> convertToSListObjectModified(Collection<ObjectModified> input) {
		List<SObjectModified> result = new ArrayList<SObjectModified>();
		for (ObjectModified o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectModified> convertFromSListObjectModified(Collection<SObjectModified> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectModified> result = new ArrayList<ObjectModified>();
		for (SObjectModified o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectModified convertToSObject(ObjectModified input) {
		if (input == null) {
			return null;
		}
		
		SObjectModified result = new SObjectModified();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}
	public ObjectModified convertFromSObject(SObjectModified input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectModified result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectModified(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input, ObjectModified result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		result.setDataObject(convertFromSObject(input.getDataObject(), session));
		return result;
	}

	public Set<SCompareContainer> convertToSSetCompareContainer(Collection<CompareContainer> input) {
		Set<SCompareContainer> result = new HashSet<SCompareContainer>();
		for (CompareContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareContainer> convertFromSSetCompareContainer(Collection<SCompareContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareContainer> result = new HashSet<CompareContainer>();
		for (SCompareContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareContainer> convertToSListCompareContainer(Collection<CompareContainer> input) {
		List<SCompareContainer> result = new ArrayList<SCompareContainer>();
		for (CompareContainer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareContainer> convertFromSListCompareContainer(Collection<SCompareContainer> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareContainer> result = new ArrayList<CompareContainer>();
		for (SCompareContainer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareContainer convertToSObject(CompareContainer input) {
		if (input == null) {
			return null;
		}
		
		SCompareContainer result = new SCompareContainer();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setType(input.getType());
		List<SCompareItem> listitems = new ArrayList<SCompareItem>();
		for (CompareItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}
	public CompareContainer convertFromSObject(SCompareContainer input, DatabaseSession session) throws BimserverDatabaseException {
		CompareContainer result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareContainer(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input, CompareContainer result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(input.getType());
		List<CompareItem> listitems = result.getItems();
		for (SCompareItem v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SCompareResult> convertToSSetCompareResult(Collection<CompareResult> input) {
		Set<SCompareResult> result = new HashSet<SCompareResult>();
		for (CompareResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompareResult> convertFromSSetCompareResult(Collection<SCompareResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<CompareResult> result = new HashSet<CompareResult>();
		for (SCompareResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareResult> convertToSListCompareResult(Collection<CompareResult> input) {
		List<SCompareResult> result = new ArrayList<SCompareResult>();
		for (CompareResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompareResult> convertFromSListCompareResult(Collection<SCompareResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<CompareResult> result = new ArrayList<CompareResult>();
		for (SCompareResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompareResult convertToSObject(CompareResult input) {
		if (input == null) {
			return null;
		}
		
		SCompareResult result = new SCompareResult();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		List<SCompareContainer> listitems = new ArrayList<SCompareContainer>();
		for (CompareContainer v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}
	public CompareResult convertFromSObject(SCompareResult input, DatabaseSession session) throws BimserverDatabaseException {
		CompareResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createCompareResult(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input, CompareResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<CompareContainer> listitems = result.getItems();
		for (SCompareContainer v : input.getItems()) {
			listitems.add(convertFromSObject(v, session));
		}
		return result;
	}
		public SActionState convertToSObject(ActionState input) {
			return SActionState.values()[input.ordinal()];
		}
		
		public ActionState convertFromSObject(SActionState input) {
			return ActionState.values()[input.ordinal()];
		}

	public Set<SLongActionState> convertToSSetLongActionState(Collection<LongActionState> input) {
		Set<SLongActionState> result = new HashSet<SLongActionState>();
		for (LongActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongActionState> convertFromSSetLongActionState(Collection<SLongActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongActionState> result = new HashSet<LongActionState>();
		for (SLongActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongActionState> convertToSListLongActionState(Collection<LongActionState> input) {
		List<SLongActionState> result = new ArrayList<SLongActionState>();
		for (LongActionState o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongActionState> convertFromSListLongActionState(Collection<SLongActionState> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongActionState> result = new ArrayList<LongActionState>();
		for (SLongActionState o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongActionState convertToSObject(LongActionState input) {
		if (input == null) {
			return null;
		}
		
		SLongActionState result = new SLongActionState();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setProgress(input.getProgress());
		result.setState(SActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		return result;
	}
	public LongActionState convertFromSObject(SLongActionState input, DatabaseSession session) throws BimserverDatabaseException {
		LongActionState result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongActionState(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input, LongActionState result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setProgress(input.getProgress());
		result.setState(ActionState.values()[input.getState().ordinal()]);
		result.setTitle(input.getTitle());
		result.setStage(input.getStage());
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		return result;
	}
		public SServerState convertToSObject(ServerState input) {
			return SServerState.values()[input.ordinal()];
		}
		
		public ServerState convertFromSObject(SServerState input) {
			return ServerState.values()[input.ordinal()];
		}

	public Set<SServerInfo> convertToSSetServerInfo(Collection<ServerInfo> input) {
		Set<SServerInfo> result = new HashSet<SServerInfo>();
		for (ServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerInfo> convertFromSSetServerInfo(Collection<SServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerInfo> result = new HashSet<ServerInfo>();
		for (SServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerInfo> convertToSListServerInfo(Collection<ServerInfo> input) {
		List<SServerInfo> result = new ArrayList<SServerInfo>();
		for (ServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerInfo> convertFromSListServerInfo(Collection<SServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerInfo> result = new ArrayList<ServerInfo>();
		for (SServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerInfo convertToSObject(ServerInfo input) {
		if (input == null) {
			return null;
		}
		
		SServerInfo result = new SServerInfo();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setServerState(SServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		return result;
	}
	public ServerInfo convertFromSObject(SServerInfo input, DatabaseSession session) throws BimserverDatabaseException {
		ServerInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createServerInfo(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input, ServerInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setServerState(ServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		return result;
	}

	public Set<SVersion> convertToSSetVersion(Collection<Version> input) {
		Set<SVersion> result = new HashSet<SVersion>();
		for (Version o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Version> convertFromSSetVersion(Collection<SVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Version> result = new HashSet<Version>();
		for (SVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SVersion> convertToSListVersion(Collection<Version> input) {
		List<SVersion> result = new ArrayList<SVersion>();
		for (Version o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Version> convertFromSListVersion(Collection<SVersion> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Version> result = new ArrayList<Version>();
		for (SVersion o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SVersion convertToSObject(Version input) {
		if (input == null) {
			return null;
		}
		
		SVersion result = new SVersion();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}
	public Version convertFromSObject(SVersion input, DatabaseSession session) throws BimserverDatabaseException {
		Version result = convertFromSObject(input, StoreFactory.eINSTANCE.createVersion(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Version convertFromSObject(SVersion input, Version result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}

	public Set<SRenderEnginePluginDescriptor> convertToSSetRenderEnginePluginDescriptor(Collection<RenderEnginePluginDescriptor> input) {
		Set<SRenderEnginePluginDescriptor> result = new HashSet<SRenderEnginePluginDescriptor>();
		for (RenderEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RenderEnginePluginDescriptor> convertFromSSetRenderEnginePluginDescriptor(Collection<SRenderEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RenderEnginePluginDescriptor> result = new HashSet<RenderEnginePluginDescriptor>();
		for (SRenderEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRenderEnginePluginDescriptor> convertToSListRenderEnginePluginDescriptor(Collection<RenderEnginePluginDescriptor> input) {
		List<SRenderEnginePluginDescriptor> result = new ArrayList<SRenderEnginePluginDescriptor>();
		for (RenderEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RenderEnginePluginDescriptor> convertFromSListRenderEnginePluginDescriptor(Collection<SRenderEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RenderEnginePluginDescriptor> result = new ArrayList<RenderEnginePluginDescriptor>();
		for (SRenderEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRenderEnginePluginDescriptor convertToSObject(RenderEnginePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SRenderEnginePluginDescriptor result = new SRenderEnginePluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public RenderEnginePluginDescriptor convertFromSObject(SRenderEnginePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		RenderEnginePluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createRenderEnginePluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RenderEnginePluginDescriptor convertFromSObject(SRenderEnginePluginDescriptor input, RenderEnginePluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
		public SExtendedDataSchemaType convertToSObject(ExtendedDataSchemaType input) {
			return SExtendedDataSchemaType.values()[input.ordinal()];
		}
		
		public ExtendedDataSchemaType convertFromSObject(SExtendedDataSchemaType input) {
			return ExtendedDataSchemaType.values()[input.ordinal()];
		}

	public Set<SFile> convertToSSetFile(Collection<File> input) {
		Set<SFile> result = new HashSet<SFile>();
		for (File o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<File> convertFromSSetFile(Collection<SFile> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<File> result = new HashSet<File>();
		for (SFile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SFile> convertToSListFile(Collection<File> input) {
		List<SFile> result = new ArrayList<SFile>();
		for (File o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<File> convertFromSListFile(Collection<SFile> input, DatabaseSession session) throws BimserverDatabaseException {
		List<File> result = new ArrayList<File>();
		for (SFile o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SFile convertToSObject(File input) {
		if (input == null) {
			return null;
		}
		
		SFile result = new SFile();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setData(input.getData());
		result.setFilename(input.getFilename());
		result.setMime(input.getMime());
		return result;
	}
	public File convertFromSObject(SFile input, DatabaseSession session) throws BimserverDatabaseException {
		File result = convertFromSObject(input, StoreFactory.eINSTANCE.createFile(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public File convertFromSObject(SFile input, File result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setData(input.getData());
		result.setFilename(input.getFilename());
		result.setMime(input.getMime());
		return result;
	}

	public Set<SExtendedDataSchema> convertToSSetExtendedDataSchema(Collection<ExtendedDataSchema> input) {
		Set<SExtendedDataSchema> result = new HashSet<SExtendedDataSchema>();
		for (ExtendedDataSchema o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedDataSchema> convertFromSSetExtendedDataSchema(Collection<SExtendedDataSchema> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedDataSchema> result = new HashSet<ExtendedDataSchema>();
		for (SExtendedDataSchema o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedDataSchema> convertToSListExtendedDataSchema(Collection<ExtendedDataSchema> input) {
		List<SExtendedDataSchema> result = new ArrayList<SExtendedDataSchema>();
		for (ExtendedDataSchema o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedDataSchema> convertFromSListExtendedDataSchema(Collection<SExtendedDataSchema> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedDataSchema> result = new ArrayList<ExtendedDataSchema>();
		for (SExtendedDataSchema o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedDataSchema convertToSObject(ExtendedDataSchema input) {
		if (input == null) {
			return null;
		}
		
		SExtendedDataSchema result = new SExtendedDataSchema();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setNamespace(input.getNamespace());
		result.setDescription(input.getDescription());
		result.setSize(input.getSize());
		result.setValidate(input.isValidate());
		result.setType(SExtendedDataSchemaType.values()[input.getType().ordinal()]);
		File fileVal = input.getFile();
		result.setFileId(fileVal == null ? -1 : fileVal.getOid());
		List<Long> listusers = new ArrayList<Long>();
		for (User v : input.getUsers()) {
			listusers.add(v.getOid());
		}
		result.setUsers(listusers);
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		return result;
	}
	public ExtendedDataSchema convertFromSObject(SExtendedDataSchema input, DatabaseSession session) throws BimserverDatabaseException {
		ExtendedDataSchema result = convertFromSObject(input, StoreFactory.eINSTANCE.createExtendedDataSchema(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ExtendedDataSchema convertFromSObject(SExtendedDataSchema input, ExtendedDataSchema result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setNamespace(input.getNamespace());
		result.setDescription(input.getDescription());
		result.setSize(input.getSize());
		result.setValidate(input.isValidate());
		result.setType(ExtendedDataSchemaType.values()[input.getType().ordinal()]);
		result.setFile((File)session.get(StorePackage.eINSTANCE.getFile(), input.getFileId(), Query.getDefault()));
		List<User> listusers = result.getUsers();
		for (long oid : input.getUsers()) {
			listusers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, Query.getDefault()));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, Query.getDefault()));
		}
		return result;
	}

	public Set<SExtendedData> convertToSSetExtendedData(Collection<ExtendedData> input) {
		Set<SExtendedData> result = new HashSet<SExtendedData>();
		for (ExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ExtendedData> convertFromSSetExtendedData(Collection<SExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ExtendedData> result = new HashSet<ExtendedData>();
		for (SExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SExtendedData> convertToSListExtendedData(Collection<ExtendedData> input) {
		List<SExtendedData> result = new ArrayList<SExtendedData>();
		for (ExtendedData o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ExtendedData> convertFromSListExtendedData(Collection<SExtendedData> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ExtendedData> result = new ArrayList<ExtendedData>();
		for (SExtendedData o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SExtendedData convertToSObject(ExtendedData input) {
		if (input == null) {
			return null;
		}
		
		SExtendedData result = new SExtendedData();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setUrl(input.getUrl());
		result.setSize(input.getSize());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		File fileVal = input.getFile();
		result.setFileId(fileVal == null ? -1 : fileVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		ExtendedDataSchema schemaVal = input.getSchema();
		result.setSchemaId(schemaVal == null ? -1 : schemaVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}
	public ExtendedData convertFromSObject(SExtendedData input, DatabaseSession session) throws BimserverDatabaseException {
		ExtendedData result = convertFromSObject(input, StoreFactory.eINSTANCE.createExtendedData(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ExtendedData convertFromSObject(SExtendedData input, ExtendedData result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setUrl(input.getUrl());
		result.setSize(input.getSize());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		result.setFile((File)session.get(StorePackage.eINSTANCE.getFile(), input.getFileId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		result.setSchema((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getSchemaId(), Query.getDefault()));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		return result;
	}

	public Set<SQueryEnginePluginDescriptor> convertToSSetQueryEnginePluginDescriptor(Collection<QueryEnginePluginDescriptor> input) {
		Set<SQueryEnginePluginDescriptor> result = new HashSet<SQueryEnginePluginDescriptor>();
		for (QueryEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<QueryEnginePluginDescriptor> convertFromSSetQueryEnginePluginDescriptor(Collection<SQueryEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<QueryEnginePluginDescriptor> result = new HashSet<QueryEnginePluginDescriptor>();
		for (SQueryEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SQueryEnginePluginDescriptor> convertToSListQueryEnginePluginDescriptor(Collection<QueryEnginePluginDescriptor> input) {
		List<SQueryEnginePluginDescriptor> result = new ArrayList<SQueryEnginePluginDescriptor>();
		for (QueryEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<QueryEnginePluginDescriptor> convertFromSListQueryEnginePluginDescriptor(Collection<SQueryEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<QueryEnginePluginDescriptor> result = new ArrayList<QueryEnginePluginDescriptor>();
		for (SQueryEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SQueryEnginePluginDescriptor convertToSObject(QueryEnginePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SQueryEnginePluginDescriptor result = new SQueryEnginePluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public QueryEnginePluginDescriptor convertFromSObject(SQueryEnginePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		QueryEnginePluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createQueryEnginePluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public QueryEnginePluginDescriptor convertFromSObject(SQueryEnginePluginDescriptor input, QueryEnginePluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SQueryEnginePluginConfiguration> convertToSSetQueryEnginePluginConfiguration(Collection<QueryEnginePluginConfiguration> input) {
		Set<SQueryEnginePluginConfiguration> result = new HashSet<SQueryEnginePluginConfiguration>();
		for (QueryEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<QueryEnginePluginConfiguration> convertFromSSetQueryEnginePluginConfiguration(Collection<SQueryEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<QueryEnginePluginConfiguration> result = new HashSet<QueryEnginePluginConfiguration>();
		for (SQueryEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SQueryEnginePluginConfiguration> convertToSListQueryEnginePluginConfiguration(Collection<QueryEnginePluginConfiguration> input) {
		List<SQueryEnginePluginConfiguration> result = new ArrayList<SQueryEnginePluginConfiguration>();
		for (QueryEnginePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<QueryEnginePluginConfiguration> convertFromSListQueryEnginePluginConfiguration(Collection<SQueryEnginePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<QueryEnginePluginConfiguration> result = new ArrayList<QueryEnginePluginConfiguration>();
		for (SQueryEnginePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SQueryEnginePluginConfiguration convertToSObject(QueryEnginePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SQueryEnginePluginConfiguration result = new SQueryEnginePluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public QueryEnginePluginConfiguration convertFromSObject(SQueryEnginePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		QueryEnginePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createQueryEnginePluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public QueryEnginePluginConfiguration convertFromSObject(SQueryEnginePluginConfiguration input, QueryEnginePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SWebModulePluginDescriptor> convertToSSetWebModulePluginDescriptor(Collection<WebModulePluginDescriptor> input) {
		Set<SWebModulePluginDescriptor> result = new HashSet<SWebModulePluginDescriptor>();
		for (WebModulePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<WebModulePluginDescriptor> convertFromSSetWebModulePluginDescriptor(Collection<SWebModulePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<WebModulePluginDescriptor> result = new HashSet<WebModulePluginDescriptor>();
		for (SWebModulePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SWebModulePluginDescriptor> convertToSListWebModulePluginDescriptor(Collection<WebModulePluginDescriptor> input) {
		List<SWebModulePluginDescriptor> result = new ArrayList<SWebModulePluginDescriptor>();
		for (WebModulePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<WebModulePluginDescriptor> convertFromSListWebModulePluginDescriptor(Collection<SWebModulePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<WebModulePluginDescriptor> result = new ArrayList<WebModulePluginDescriptor>();
		for (SWebModulePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SWebModulePluginDescriptor convertToSObject(WebModulePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SWebModulePluginDescriptor result = new SWebModulePluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public WebModulePluginDescriptor convertFromSObject(SWebModulePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		WebModulePluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createWebModulePluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public WebModulePluginDescriptor convertFromSObject(SWebModulePluginDescriptor input, WebModulePluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SWebModulePluginConfiguration> convertToSSetWebModulePluginConfiguration(Collection<WebModulePluginConfiguration> input) {
		Set<SWebModulePluginConfiguration> result = new HashSet<SWebModulePluginConfiguration>();
		for (WebModulePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<WebModulePluginConfiguration> convertFromSSetWebModulePluginConfiguration(Collection<SWebModulePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<WebModulePluginConfiguration> result = new HashSet<WebModulePluginConfiguration>();
		for (SWebModulePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SWebModulePluginConfiguration> convertToSListWebModulePluginConfiguration(Collection<WebModulePluginConfiguration> input) {
		List<SWebModulePluginConfiguration> result = new ArrayList<SWebModulePluginConfiguration>();
		for (WebModulePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<WebModulePluginConfiguration> convertFromSListWebModulePluginConfiguration(Collection<SWebModulePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<WebModulePluginConfiguration> result = new ArrayList<WebModulePluginConfiguration>();
		for (SWebModulePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SWebModulePluginConfiguration convertToSObject(WebModulePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SWebModulePluginConfiguration result = new SWebModulePluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		ServerSettings serverSettingsVal = input.getServerSettings();
		result.setServerSettingsId(serverSettingsVal == null ? -1 : serverSettingsVal.getOid());
		return result;
	}
	public WebModulePluginConfiguration convertFromSObject(SWebModulePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		WebModulePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createWebModulePluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public WebModulePluginConfiguration convertFromSObject(SWebModulePluginConfiguration input, WebModulePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setServerSettings((ServerSettings)session.get(StorePackage.eINSTANCE.getServerSettings(), input.getServerSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SModelMergerPluginDescriptor> convertToSSetModelMergerPluginDescriptor(Collection<ModelMergerPluginDescriptor> input) {
		Set<SModelMergerPluginDescriptor> result = new HashSet<SModelMergerPluginDescriptor>();
		for (ModelMergerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelMergerPluginDescriptor> convertFromSSetModelMergerPluginDescriptor(Collection<SModelMergerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelMergerPluginDescriptor> result = new HashSet<ModelMergerPluginDescriptor>();
		for (SModelMergerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelMergerPluginDescriptor> convertToSListModelMergerPluginDescriptor(Collection<ModelMergerPluginDescriptor> input) {
		List<SModelMergerPluginDescriptor> result = new ArrayList<SModelMergerPluginDescriptor>();
		for (ModelMergerPluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelMergerPluginDescriptor> convertFromSListModelMergerPluginDescriptor(Collection<SModelMergerPluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelMergerPluginDescriptor> result = new ArrayList<ModelMergerPluginDescriptor>();
		for (SModelMergerPluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelMergerPluginDescriptor convertToSObject(ModelMergerPluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SModelMergerPluginDescriptor result = new SModelMergerPluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public ModelMergerPluginDescriptor convertFromSObject(SModelMergerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ModelMergerPluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelMergerPluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ModelMergerPluginDescriptor convertFromSObject(SModelMergerPluginDescriptor input, ModelMergerPluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SModelMergerPluginConfiguration> convertToSSetModelMergerPluginConfiguration(Collection<ModelMergerPluginConfiguration> input) {
		Set<SModelMergerPluginConfiguration> result = new HashSet<SModelMergerPluginConfiguration>();
		for (ModelMergerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelMergerPluginConfiguration> convertFromSSetModelMergerPluginConfiguration(Collection<SModelMergerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelMergerPluginConfiguration> result = new HashSet<ModelMergerPluginConfiguration>();
		for (SModelMergerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelMergerPluginConfiguration> convertToSListModelMergerPluginConfiguration(Collection<ModelMergerPluginConfiguration> input) {
		List<SModelMergerPluginConfiguration> result = new ArrayList<SModelMergerPluginConfiguration>();
		for (ModelMergerPluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelMergerPluginConfiguration> convertFromSListModelMergerPluginConfiguration(Collection<SModelMergerPluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelMergerPluginConfiguration> result = new ArrayList<ModelMergerPluginConfiguration>();
		for (SModelMergerPluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelMergerPluginConfiguration convertToSObject(ModelMergerPluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SModelMergerPluginConfiguration result = new SModelMergerPluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public ModelMergerPluginConfiguration convertFromSObject(SModelMergerPluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		ModelMergerPluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelMergerPluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ModelMergerPluginConfiguration convertFromSObject(SModelMergerPluginConfiguration input, ModelMergerPluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SModelComparePluginDescriptor> convertToSSetModelComparePluginDescriptor(Collection<ModelComparePluginDescriptor> input) {
		Set<SModelComparePluginDescriptor> result = new HashSet<SModelComparePluginDescriptor>();
		for (ModelComparePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelComparePluginDescriptor> convertFromSSetModelComparePluginDescriptor(Collection<SModelComparePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelComparePluginDescriptor> result = new HashSet<ModelComparePluginDescriptor>();
		for (SModelComparePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelComparePluginDescriptor> convertToSListModelComparePluginDescriptor(Collection<ModelComparePluginDescriptor> input) {
		List<SModelComparePluginDescriptor> result = new ArrayList<SModelComparePluginDescriptor>();
		for (ModelComparePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelComparePluginDescriptor> convertFromSListModelComparePluginDescriptor(Collection<SModelComparePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelComparePluginDescriptor> result = new ArrayList<ModelComparePluginDescriptor>();
		for (SModelComparePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelComparePluginDescriptor convertToSObject(ModelComparePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SModelComparePluginDescriptor result = new SModelComparePluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public ModelComparePluginDescriptor convertFromSObject(SModelComparePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ModelComparePluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelComparePluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ModelComparePluginDescriptor convertFromSObject(SModelComparePluginDescriptor input, ModelComparePluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SModelComparePluginConfiguration> convertToSSetModelComparePluginConfiguration(Collection<ModelComparePluginConfiguration> input) {
		Set<SModelComparePluginConfiguration> result = new HashSet<SModelComparePluginConfiguration>();
		for (ModelComparePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelComparePluginConfiguration> convertFromSSetModelComparePluginConfiguration(Collection<SModelComparePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelComparePluginConfiguration> result = new HashSet<ModelComparePluginConfiguration>();
		for (SModelComparePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelComparePluginConfiguration> convertToSListModelComparePluginConfiguration(Collection<ModelComparePluginConfiguration> input) {
		List<SModelComparePluginConfiguration> result = new ArrayList<SModelComparePluginConfiguration>();
		for (ModelComparePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelComparePluginConfiguration> convertFromSListModelComparePluginConfiguration(Collection<SModelComparePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelComparePluginConfiguration> result = new ArrayList<ModelComparePluginConfiguration>();
		for (SModelComparePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelComparePluginConfiguration convertToSObject(ModelComparePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SModelComparePluginConfiguration result = new SModelComparePluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public ModelComparePluginConfiguration convertFromSObject(SModelComparePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		ModelComparePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createModelComparePluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ModelComparePluginConfiguration convertFromSObject(SModelComparePluginConfiguration input, ModelComparePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}
		public STrigger convertToSObject(Trigger input) {
			return STrigger.values()[input.ordinal()];
		}
		
		public Trigger convertFromSObject(STrigger input) {
			return Trigger.values()[input.ordinal()];
		}

	public Set<SProfileDescriptor> convertToSSetProfileDescriptor(Collection<ProfileDescriptor> input) {
		Set<SProfileDescriptor> result = new HashSet<SProfileDescriptor>();
		for (ProfileDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProfileDescriptor> convertFromSSetProfileDescriptor(Collection<SProfileDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ProfileDescriptor> result = new HashSet<ProfileDescriptor>();
		for (SProfileDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProfileDescriptor> convertToSListProfileDescriptor(Collection<ProfileDescriptor> input) {
		List<SProfileDescriptor> result = new ArrayList<SProfileDescriptor>();
		for (ProfileDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProfileDescriptor> convertFromSListProfileDescriptor(Collection<SProfileDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ProfileDescriptor> result = new ArrayList<ProfileDescriptor>();
		for (SProfileDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProfileDescriptor convertToSObject(ProfileDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SProfileDescriptor result = new SProfileDescriptor();
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setPublicProfile(input.isPublicProfile());
		result.setIdentifier(input.getIdentifier());
		return result;
	}
	public ProfileDescriptor convertFromSObject(SProfileDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ProfileDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createProfileDescriptor(), session);
		
		return result;
	}

	public ProfileDescriptor convertFromSObject(SProfileDescriptor input, ProfileDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setPublicProfile(input.isPublicProfile());
		result.setIdentifier(input.getIdentifier());
		return result;
	}

	public Set<SServiceDescriptor> convertToSSetServiceDescriptor(Collection<ServiceDescriptor> input) {
		Set<SServiceDescriptor> result = new HashSet<SServiceDescriptor>();
		for (ServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceDescriptor> convertFromSSetServiceDescriptor(Collection<SServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceDescriptor> result = new HashSet<ServiceDescriptor>();
		for (SServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceDescriptor> convertToSListServiceDescriptor(Collection<ServiceDescriptor> input) {
		List<SServiceDescriptor> result = new ArrayList<SServiceDescriptor>();
		for (ServiceDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceDescriptor> convertFromSListServiceDescriptor(Collection<SServiceDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceDescriptor> result = new ArrayList<ServiceDescriptor>();
		for (SServiceDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceDescriptor convertToSObject(ServiceDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SServiceDescriptor result = new SServiceDescriptor();
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setIdentifier(input.getIdentifier());
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.getReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.getWriteExtendedData());
		result.setProviderName(input.getProviderName());
		return result;
	}
	public ServiceDescriptor convertFromSObject(SServiceDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceDescriptor(), session);
		
		return result;
	}

	public ServiceDescriptor convertFromSObject(SServiceDescriptor input, ServiceDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setIdentifier(input.getIdentifier());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.getReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.getWriteExtendedData());
		result.setProviderName(input.getProviderName());
		return result;
	}

	public Set<SService> convertToSSetService(Collection<Service> input) {
		Set<SService> result = new HashSet<SService>();
		for (Service o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Service> convertFromSSetService(Collection<SService> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Service> result = new HashSet<Service>();
		for (SService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SService> convertToSListService(Collection<Service> input) {
		List<SService> result = new ArrayList<SService>();
		for (Service o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Service> convertFromSListService(Collection<SService> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Service> result = new ArrayList<Service>();
		for (SService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SService convertToSObject(Service input) {
		if (input == null) {
			return null;
		}
		
		SService result = new SService();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setServiceName(input.getServiceName());
		result.setServiceIdentifier(input.getServiceIdentifier());
		result.setProviderName(input.getProviderName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setProfileIdentifier(input.getProfileIdentifier());
		result.setProfileName(input.getProfileName());
		result.setProfileDescription(input.getProfileDescription());
		result.setProfilePublic(input.isProfilePublic());
		ExtendedDataSchema readExtendedDataVal = input.getReadExtendedData();
		result.setReadExtendedDataId(readExtendedDataVal == null ? -1 : readExtendedDataVal.getOid());
		Project writeRevisionVal = input.getWriteRevision();
		result.setWriteRevisionId(writeRevisionVal == null ? -1 : writeRevisionVal.getOid());
		ExtendedDataSchema writeExtendedDataVal = input.getWriteExtendedData();
		result.setWriteExtendedDataId(writeExtendedDataVal == null ? -1 : writeExtendedDataVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		InternalServicePluginConfiguration internalServiceVal = input.getInternalService();
		result.setInternalServiceId(internalServiceVal == null ? -1 : internalServiceVal.getOid());
		return result;
	}
	public Service convertFromSObject(SService input, DatabaseSession session) throws BimserverDatabaseException {
		Service result = convertFromSObject(input, StoreFactory.eINSTANCE.createService(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Service convertFromSObject(SService input, Service result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setServiceName(input.getServiceName());
		result.setServiceIdentifier(input.getServiceIdentifier());
		result.setProviderName(input.getProviderName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setProfileIdentifier(input.getProfileIdentifier());
		result.setProfileName(input.getProfileName());
		result.setProfileDescription(input.getProfileDescription());
		result.setProfilePublic(input.isProfilePublic());
		result.setReadExtendedData((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getReadExtendedDataId(), Query.getDefault()));
		result.setWriteRevision((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getWriteRevisionId(), Query.getDefault()));
		result.setWriteExtendedData((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getWriteExtendedDataId(), Query.getDefault()));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), Query.getDefault()));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), Query.getDefault()));
		result.setInternalService((InternalServicePluginConfiguration)session.get(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), input.getInternalServiceId(), Query.getDefault()));
		return result;
	}

	public Set<SToken> convertToSSetToken(Collection<Token> input) {
		Set<SToken> result = new HashSet<SToken>();
		for (Token o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Token> convertFromSSetToken(Collection<SToken> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Token> result = new HashSet<Token>();
		for (SToken o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SToken> convertToSListToken(Collection<Token> input) {
		List<SToken> result = new ArrayList<SToken>();
		for (Token o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Token> convertFromSListToken(Collection<SToken> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Token> result = new ArrayList<Token>();
		for (SToken o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SToken convertToSObject(Token input) {
		if (input == null) {
			return null;
		}
		
		SToken result = new SToken();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setTokenString(input.getTokenString());
		result.setExpires(input.getExpires());
		return result;
	}
	public Token convertFromSObject(SToken input, DatabaseSession session) throws BimserverDatabaseException {
		Token result = convertFromSObject(input, StoreFactory.eINSTANCE.createToken(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Token convertFromSObject(SToken input, Token result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setTokenString(input.getTokenString());
		result.setExpires(input.getExpires());
		return result;
	}

	public Set<SServicePluginDescriptor> convertToSSetServicePluginDescriptor(Collection<ServicePluginDescriptor> input) {
		Set<SServicePluginDescriptor> result = new HashSet<SServicePluginDescriptor>();
		for (ServicePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServicePluginDescriptor> convertFromSSetServicePluginDescriptor(Collection<SServicePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServicePluginDescriptor> result = new HashSet<ServicePluginDescriptor>();
		for (SServicePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServicePluginDescriptor> convertToSListServicePluginDescriptor(Collection<ServicePluginDescriptor> input) {
		List<SServicePluginDescriptor> result = new ArrayList<SServicePluginDescriptor>();
		for (ServicePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServicePluginDescriptor> convertFromSListServicePluginDescriptor(Collection<SServicePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServicePluginDescriptor> result = new ArrayList<ServicePluginDescriptor>();
		for (SServicePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServicePluginDescriptor convertToSObject(ServicePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SServicePluginDescriptor result = new SServicePluginDescriptor();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
	public ServicePluginDescriptor convertFromSObject(SServicePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		ServicePluginDescriptor result = convertFromSObject(input, StoreFactory.eINSTANCE.createServicePluginDescriptor(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServicePluginDescriptor convertFromSObject(SServicePluginDescriptor input, ServicePluginDescriptor result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setSimpleName(input.getSimpleName());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SInternalServicePluginConfiguration> convertToSSetInternalServicePluginConfiguration(Collection<InternalServicePluginConfiguration> input) {
		Set<SInternalServicePluginConfiguration> result = new HashSet<SInternalServicePluginConfiguration>();
		for (InternalServicePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<InternalServicePluginConfiguration> convertFromSSetInternalServicePluginConfiguration(Collection<SInternalServicePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<InternalServicePluginConfiguration> result = new HashSet<InternalServicePluginConfiguration>();
		for (SInternalServicePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SInternalServicePluginConfiguration> convertToSListInternalServicePluginConfiguration(Collection<InternalServicePluginConfiguration> input) {
		List<SInternalServicePluginConfiguration> result = new ArrayList<SInternalServicePluginConfiguration>();
		for (InternalServicePluginConfiguration o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<InternalServicePluginConfiguration> convertFromSListInternalServicePluginConfiguration(Collection<SInternalServicePluginConfiguration> input, DatabaseSession session) throws BimserverDatabaseException {
		List<InternalServicePluginConfiguration> result = new ArrayList<InternalServicePluginConfiguration>();
		for (SInternalServicePluginConfiguration o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SInternalServicePluginConfiguration convertToSObject(InternalServicePluginConfiguration input) {
		if (input == null) {
			return null;
		}
		
		SInternalServicePluginConfiguration result = new SInternalServicePluginConfiguration();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setRemoteAccessible(input.isRemoteAccessible());
		ObjectType settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		UserSettings userSettingsVal = input.getUserSettings();
		result.setUserSettingsId(userSettingsVal == null ? -1 : userSettingsVal.getOid());
		return result;
	}
	public InternalServicePluginConfiguration convertFromSObject(SInternalServicePluginConfiguration input, DatabaseSession session) throws BimserverDatabaseException {
		InternalServicePluginConfiguration result = convertFromSObject(input, StoreFactory.eINSTANCE.createInternalServicePluginConfiguration(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public InternalServicePluginConfiguration convertFromSObject(SInternalServicePluginConfiguration input, InternalServicePluginConfiguration result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setRemoteAccessible(input.isRemoteAccessible());
		result.setSettings((ObjectType)session.get(StorePackage.eINSTANCE.getObjectType(), input.getSettingsId(), Query.getDefault()));
		result.setUserSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getUserSettingsId(), Query.getDefault()));
		return result;
	}

	public Set<SServiceInterface> convertToSSetServiceInterface(Collection<ServiceInterface> input) {
		Set<SServiceInterface> result = new HashSet<SServiceInterface>();
		for (ServiceInterface o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceInterface> convertFromSSetServiceInterface(Collection<SServiceInterface> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceInterface> result = new HashSet<ServiceInterface>();
		for (SServiceInterface o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceInterface> convertToSListServiceInterface(Collection<ServiceInterface> input) {
		List<SServiceInterface> result = new ArrayList<SServiceInterface>();
		for (ServiceInterface o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceInterface> convertFromSListServiceInterface(Collection<SServiceInterface> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceInterface> result = new ArrayList<ServiceInterface>();
		for (SServiceInterface o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceInterface convertToSObject(ServiceInterface input) {
		if (input == null) {
			return null;
		}
		
		SServiceInterface result = new SServiceInterface();
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		return result;
	}
	public ServiceInterface convertFromSObject(SServiceInterface input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceInterface result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceInterface(), session);
		
		return result;
	}

	public ServiceInterface convertFromSObject(SServiceInterface input, ServiceInterface result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		return result;
	}

	public Set<SServiceMethod> convertToSSetServiceMethod(Collection<ServiceMethod> input) {
		Set<SServiceMethod> result = new HashSet<SServiceMethod>();
		for (ServiceMethod o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceMethod> convertFromSSetServiceMethod(Collection<SServiceMethod> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceMethod> result = new HashSet<ServiceMethod>();
		for (SServiceMethod o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceMethod> convertToSListServiceMethod(Collection<ServiceMethod> input) {
		List<SServiceMethod> result = new ArrayList<SServiceMethod>();
		for (ServiceMethod o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceMethod> convertFromSListServiceMethod(Collection<SServiceMethod> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceMethod> result = new ArrayList<ServiceMethod>();
		for (SServiceMethod o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceMethod convertToSObject(ServiceMethod input) {
		if (input == null) {
			return null;
		}
		
		SServiceMethod result = new SServiceMethod();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setReturnDoc(input.getReturnDoc());
		return result;
	}
	public ServiceMethod convertFromSObject(SServiceMethod input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceMethod result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceMethod(), session);
		
		return result;
	}

	public ServiceMethod convertFromSObject(SServiceMethod input, ServiceMethod result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setReturnDoc(input.getReturnDoc());
		return result;
	}

	public Set<SServiceField> convertToSSetServiceField(Collection<ServiceField> input) {
		Set<SServiceField> result = new HashSet<SServiceField>();
		for (ServiceField o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceField> convertFromSSetServiceField(Collection<SServiceField> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceField> result = new HashSet<ServiceField>();
		for (SServiceField o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceField> convertToSListServiceField(Collection<ServiceField> input) {
		List<SServiceField> result = new ArrayList<SServiceField>();
		for (ServiceField o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceField> convertFromSListServiceField(Collection<SServiceField> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceField> result = new ArrayList<ServiceField>();
		for (SServiceField o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceField convertToSObject(ServiceField input) {
		if (input == null) {
			return null;
		}
		
		SServiceField result = new SServiceField();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		ServiceType typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		ServiceType genericTypeVal = input.getGenericType();
		result.setGenericType(convertToSObject(genericTypeVal));
		return result;
	}
	public ServiceField convertFromSObject(SServiceField input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceField result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceField(), session);
		
		return result;
	}

	public ServiceField convertFromSObject(SServiceField input, ServiceField result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setType(convertFromSObject(input.getType(), session));
		result.setGenericType(convertFromSObject(input.getGenericType(), session));
		return result;
	}

	public Set<SServiceType> convertToSSetServiceType(Collection<ServiceType> input) {
		Set<SServiceType> result = new HashSet<SServiceType>();
		for (ServiceType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceType> convertFromSSetServiceType(Collection<SServiceType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceType> result = new HashSet<ServiceType>();
		for (SServiceType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceType> convertToSListServiceType(Collection<ServiceType> input) {
		List<SServiceType> result = new ArrayList<SServiceType>();
		for (ServiceType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceType> convertFromSListServiceType(Collection<SServiceType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceType> result = new ArrayList<ServiceType>();
		for (SServiceType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceType convertToSObject(ServiceType input) {
		if (input == null) {
			return null;
		}
		
		SServiceType result = new SServiceType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		List<SServiceField> listfields = new ArrayList<SServiceField>();
		for (ServiceField v : input.getFields()) {
			listfields.add(convertToSObject(v));
		}
		result.setFields(listfields);
		return result;
	}
	public ServiceType convertFromSObject(SServiceType input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceType result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ServiceType convertFromSObject(SServiceType input, ServiceType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setSimpleName(input.getSimpleName());
		List<ServiceField> listfields = result.getFields();
		for (SServiceField v : input.getFields()) {
			listfields.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SServiceParameter> convertToSSetServiceParameter(Collection<ServiceParameter> input) {
		Set<SServiceParameter> result = new HashSet<SServiceParameter>();
		for (ServiceParameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServiceParameter> convertFromSSetServiceParameter(Collection<SServiceParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServiceParameter> result = new HashSet<ServiceParameter>();
		for (SServiceParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServiceParameter> convertToSListServiceParameter(Collection<ServiceParameter> input) {
		List<SServiceParameter> result = new ArrayList<SServiceParameter>();
		for (ServiceParameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServiceParameter> convertFromSListServiceParameter(Collection<SServiceParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServiceParameter> result = new ArrayList<ServiceParameter>();
		for (SServiceParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServiceParameter convertToSObject(ServiceParameter input) {
		if (input == null) {
			return null;
		}
		
		SServiceParameter result = new SServiceParameter();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		ServiceType typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		ServiceType genericTypeVal = input.getGenericType();
		result.setGenericType(convertToSObject(genericTypeVal));
		return result;
	}
	public ServiceParameter convertFromSObject(SServiceParameter input, DatabaseSession session) throws BimserverDatabaseException {
		ServiceParameter result = convertFromSObject(input, StoreFactory.eINSTANCE.createServiceParameter(), session);
		
		return result;
	}

	public ServiceParameter convertFromSObject(SServiceParameter input, ServiceParameter result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setType(convertFromSObject(input.getType(), session));
		result.setGenericType(convertFromSObject(input.getGenericType(), session));
		return result;
	}
		public SPrimitiveEnum convertToSObject(PrimitiveEnum input) {
			return SPrimitiveEnum.values()[input.ordinal()];
		}
		
		public PrimitiveEnum convertFromSObject(SPrimitiveEnum input) {
			return PrimitiveEnum.values()[input.ordinal()];
		}

	public Set<STypeDefinition> convertToSSetTypeDefinition(Collection<TypeDefinition> input) {
		Set<STypeDefinition> result = new HashSet<STypeDefinition>();
		for (TypeDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<TypeDefinition> convertFromSSetTypeDefinition(Collection<STypeDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<TypeDefinition> result = new HashSet<TypeDefinition>();
		for (STypeDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<STypeDefinition> convertToSListTypeDefinition(Collection<TypeDefinition> input) {
		List<STypeDefinition> result = new ArrayList<STypeDefinition>();
		for (TypeDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<TypeDefinition> convertFromSListTypeDefinition(Collection<STypeDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<TypeDefinition> result = new ArrayList<TypeDefinition>();
		for (STypeDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public STypeDefinition convertToSObject(TypeDefinition input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ObjectDefinition) {
			return convertToSObject((ObjectDefinition)input);
		}
		else if (input instanceof ArrayDefinition) {
			return convertToSObject((ArrayDefinition)input);
		}
		else if (input instanceof PrimitiveDefinition) {
			return convertToSObject((PrimitiveDefinition)input);
		}
		STypeDefinition result = new STypeDefinition();
		return result;
	}
	public TypeDefinition convertFromSObject(STypeDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		TypeDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createTypeDefinition(), session);
		
		return result;
	}

	public TypeDefinition convertFromSObject(STypeDefinition input, TypeDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SObjectDefinition) {
			return convertFromSObject((SObjectDefinition)input, session);
		}
		else if (input instanceof SArrayDefinition) {
			return convertFromSObject((SArrayDefinition)input, session);
		}
		else if (input instanceof SPrimitiveDefinition) {
			return convertFromSObject((SPrimitiveDefinition)input, session);
		}
		return result;
	}

	public Set<SObjectDefinition> convertToSSetObjectDefinition(Collection<ObjectDefinition> input) {
		Set<SObjectDefinition> result = new HashSet<SObjectDefinition>();
		for (ObjectDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectDefinition> convertFromSSetObjectDefinition(Collection<SObjectDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectDefinition> result = new HashSet<ObjectDefinition>();
		for (SObjectDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectDefinition> convertToSListObjectDefinition(Collection<ObjectDefinition> input) {
		List<SObjectDefinition> result = new ArrayList<SObjectDefinition>();
		for (ObjectDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectDefinition> convertFromSListObjectDefinition(Collection<SObjectDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectDefinition> result = new ArrayList<ObjectDefinition>();
		for (SObjectDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectDefinition convertToSObject(ObjectDefinition input) {
		if (input == null) {
			return null;
		}
		
		SObjectDefinition result = new SObjectDefinition();
		List<SParameterDefinition> listparameters = new ArrayList<SParameterDefinition>();
		for (ParameterDefinition v : input.getParameters()) {
			listparameters.add(convertToSObject(v));
		}
		result.setParameters(listparameters);
		return result;
	}
	public ObjectDefinition convertFromSObject(SObjectDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectDefinition(), session);
		
		return result;
	}

	public ObjectDefinition convertFromSObject(SObjectDefinition input, ObjectDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<ParameterDefinition> listparameters = result.getParameters();
		for (SParameterDefinition v : input.getParameters()) {
			listparameters.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPrimitiveDefinition> convertToSSetPrimitiveDefinition(Collection<PrimitiveDefinition> input) {
		Set<SPrimitiveDefinition> result = new HashSet<SPrimitiveDefinition>();
		for (PrimitiveDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PrimitiveDefinition> convertFromSSetPrimitiveDefinition(Collection<SPrimitiveDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PrimitiveDefinition> result = new HashSet<PrimitiveDefinition>();
		for (SPrimitiveDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPrimitiveDefinition> convertToSListPrimitiveDefinition(Collection<PrimitiveDefinition> input) {
		List<SPrimitiveDefinition> result = new ArrayList<SPrimitiveDefinition>();
		for (PrimitiveDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PrimitiveDefinition> convertFromSListPrimitiveDefinition(Collection<SPrimitiveDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PrimitiveDefinition> result = new ArrayList<PrimitiveDefinition>();
		for (SPrimitiveDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPrimitiveDefinition convertToSObject(PrimitiveDefinition input) {
		if (input == null) {
			return null;
		}
		
		SPrimitiveDefinition result = new SPrimitiveDefinition();
		result.setType(SPrimitiveEnum.values()[input.getType().ordinal()]);
		return result;
	}
	public PrimitiveDefinition convertFromSObject(SPrimitiveDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		PrimitiveDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createPrimitiveDefinition(), session);
		
		return result;
	}

	public PrimitiveDefinition convertFromSObject(SPrimitiveDefinition input, PrimitiveDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(PrimitiveEnum.values()[input.getType().ordinal()]);
		return result;
	}

	public Set<SArrayDefinition> convertToSSetArrayDefinition(Collection<ArrayDefinition> input) {
		Set<SArrayDefinition> result = new HashSet<SArrayDefinition>();
		for (ArrayDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ArrayDefinition> convertFromSSetArrayDefinition(Collection<SArrayDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ArrayDefinition> result = new HashSet<ArrayDefinition>();
		for (SArrayDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SArrayDefinition> convertToSListArrayDefinition(Collection<ArrayDefinition> input) {
		List<SArrayDefinition> result = new ArrayList<SArrayDefinition>();
		for (ArrayDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ArrayDefinition> convertFromSListArrayDefinition(Collection<SArrayDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ArrayDefinition> result = new ArrayList<ArrayDefinition>();
		for (SArrayDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SArrayDefinition convertToSObject(ArrayDefinition input) {
		if (input == null) {
			return null;
		}
		
		SArrayDefinition result = new SArrayDefinition();
		TypeDefinition typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		return result;
	}
	public ArrayDefinition convertFromSObject(SArrayDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		ArrayDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createArrayDefinition(), session);
		
		return result;
	}

	public ArrayDefinition convertFromSObject(SArrayDefinition input, ArrayDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setType(convertFromSObject(input.getType(), session));
		return result;
	}

	public Set<SParameterDefinition> convertToSSetParameterDefinition(Collection<ParameterDefinition> input) {
		Set<SParameterDefinition> result = new HashSet<SParameterDefinition>();
		for (ParameterDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ParameterDefinition> convertFromSSetParameterDefinition(Collection<SParameterDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ParameterDefinition> result = new HashSet<ParameterDefinition>();
		for (SParameterDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SParameterDefinition> convertToSListParameterDefinition(Collection<ParameterDefinition> input) {
		List<SParameterDefinition> result = new ArrayList<SParameterDefinition>();
		for (ParameterDefinition o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ParameterDefinition> convertFromSListParameterDefinition(Collection<SParameterDefinition> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ParameterDefinition> result = new ArrayList<ParameterDefinition>();
		for (SParameterDefinition o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SParameterDefinition convertToSObject(ParameterDefinition input) {
		if (input == null) {
			return null;
		}
		
		SParameterDefinition result = new SParameterDefinition();
		result.setName(input.getName());
		result.setRequired(input.isRequired());
		result.setDescription(input.getDescription());
		TypeDefinition typeVal = input.getType();
		result.setType(convertToSObject(typeVal));
		Type defaultValueVal = input.getDefaultValue();
		result.setDefaultValueId(defaultValueVal == null ? -1 : defaultValueVal.getOid());
		return result;
	}
	public ParameterDefinition convertFromSObject(SParameterDefinition input, DatabaseSession session) throws BimserverDatabaseException {
		ParameterDefinition result = convertFromSObject(input, StoreFactory.eINSTANCE.createParameterDefinition(), session);
		
		return result;
	}

	public ParameterDefinition convertFromSObject(SParameterDefinition input, ParameterDefinition result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setRequired(input.isRequired());
		result.setDescription(input.getDescription());
		result.setType(convertFromSObject(input.getType(), session));
		result.setDefaultValue((Type)session.get(StorePackage.eINSTANCE.getType(), input.getDefaultValueId(), Query.getDefault()));
		return result;
	}

	public Set<SType> convertToSSetType(Collection<Type> input) {
		Set<SType> result = new HashSet<SType>();
		for (Type o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Type> convertFromSSetType(Collection<SType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Type> result = new HashSet<Type>();
		for (SType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SType> convertToSListType(Collection<Type> input) {
		List<SType> result = new ArrayList<SType>();
		for (Type o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Type> convertFromSListType(Collection<SType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Type> result = new ArrayList<Type>();
		for (SType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SType convertToSObject(Type input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof ObjectType) {
			return convertToSObject((ObjectType)input);
		}
		else if (input instanceof ArrayType) {
			return convertToSObject((ArrayType)input);
		}
		else if (input instanceof PrimitiveType) {
			return convertToSObject((PrimitiveType)input);
		}
		SType result = new SType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		return result;
	}
	public Type convertFromSObject(SType input, DatabaseSession session) throws BimserverDatabaseException {
		Type result = convertFromSObject(input, StoreFactory.eINSTANCE.createType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Type convertFromSObject(SType input, Type result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SObjectType) {
			return convertFromSObject((SObjectType)input, session);
		}
		else if (input instanceof SArrayType) {
			return convertFromSObject((SArrayType)input, session);
		}
		else if (input instanceof SPrimitiveType) {
			return convertFromSObject((SPrimitiveType)input, session);
		}
		return result;
	}

	public Set<SObjectType> convertToSSetObjectType(Collection<ObjectType> input) {
		Set<SObjectType> result = new HashSet<SObjectType>();
		for (ObjectType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectType> convertFromSSetObjectType(Collection<SObjectType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ObjectType> result = new HashSet<ObjectType>();
		for (SObjectType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectType> convertToSListObjectType(Collection<ObjectType> input) {
		List<SObjectType> result = new ArrayList<SObjectType>();
		for (ObjectType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectType> convertFromSListObjectType(Collection<SObjectType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ObjectType> result = new ArrayList<ObjectType>();
		for (SObjectType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectType convertToSObject(ObjectType input) {
		if (input == null) {
			return null;
		}
		
		SObjectType result = new SObjectType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		List<SParameter> listparameters = new ArrayList<SParameter>();
		for (Parameter v : input.getParameters()) {
			listparameters.add(convertToSObject(v));
		}
		result.setParameters(listparameters);
		return result;
	}
	public ObjectType convertFromSObject(SObjectType input, DatabaseSession session) throws BimserverDatabaseException {
		ObjectType result = convertFromSObject(input, StoreFactory.eINSTANCE.createObjectType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ObjectType convertFromSObject(SObjectType input, ObjectType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		List<Parameter> listparameters = result.getParameters();
		for (SParameter v : input.getParameters()) {
			listparameters.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SPrimitiveType> convertToSSetPrimitiveType(Collection<PrimitiveType> input) {
		Set<SPrimitiveType> result = new HashSet<SPrimitiveType>();
		for (PrimitiveType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PrimitiveType> convertFromSSetPrimitiveType(Collection<SPrimitiveType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PrimitiveType> result = new HashSet<PrimitiveType>();
		for (SPrimitiveType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPrimitiveType> convertToSListPrimitiveType(Collection<PrimitiveType> input) {
		List<SPrimitiveType> result = new ArrayList<SPrimitiveType>();
		for (PrimitiveType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PrimitiveType> convertFromSListPrimitiveType(Collection<SPrimitiveType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PrimitiveType> result = new ArrayList<PrimitiveType>();
		for (SPrimitiveType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPrimitiveType convertToSObject(PrimitiveType input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof DoubleType) {
			return convertToSObject((DoubleType)input);
		}
		else if (input instanceof ByteArrayType) {
			return convertToSObject((ByteArrayType)input);
		}
		else if (input instanceof StringType) {
			return convertToSObject((StringType)input);
		}
		else if (input instanceof LongType) {
			return convertToSObject((LongType)input);
		}
		else if (input instanceof BooleanType) {
			return convertToSObject((BooleanType)input);
		}
		SPrimitiveType result = new SPrimitiveType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		return result;
	}
	public PrimitiveType convertFromSObject(SPrimitiveType input, DatabaseSession session) throws BimserverDatabaseException {
		PrimitiveType result = convertFromSObject(input, StoreFactory.eINSTANCE.createPrimitiveType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PrimitiveType convertFromSObject(SPrimitiveType input, PrimitiveType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SDoubleType) {
			return convertFromSObject((SDoubleType)input, session);
		}
		else if (input instanceof SByteArrayType) {
			return convertFromSObject((SByteArrayType)input, session);
		}
		else if (input instanceof SStringType) {
			return convertFromSObject((SStringType)input, session);
		}
		else if (input instanceof SLongType) {
			return convertFromSObject((SLongType)input, session);
		}
		else if (input instanceof SBooleanType) {
			return convertFromSObject((SBooleanType)input, session);
		}
		return result;
	}

	public Set<SLongType> convertToSSetLongType(Collection<LongType> input) {
		Set<SLongType> result = new HashSet<SLongType>();
		for (LongType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongType> convertFromSSetLongType(Collection<SLongType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<LongType> result = new HashSet<LongType>();
		for (SLongType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongType> convertToSListLongType(Collection<LongType> input) {
		List<SLongType> result = new ArrayList<SLongType>();
		for (LongType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongType> convertFromSListLongType(Collection<SLongType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<LongType> result = new ArrayList<LongType>();
		for (SLongType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongType convertToSObject(LongType input) {
		if (input == null) {
			return null;
		}
		
		SLongType result = new SLongType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}
	public LongType convertFromSObject(SLongType input, DatabaseSession session) throws BimserverDatabaseException {
		LongType result = convertFromSObject(input, StoreFactory.eINSTANCE.createLongType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public LongType convertFromSObject(SLongType input, LongType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SByteArrayType> convertToSSetByteArrayType(Collection<ByteArrayType> input) {
		Set<SByteArrayType> result = new HashSet<SByteArrayType>();
		for (ByteArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ByteArrayType> convertFromSSetByteArrayType(Collection<SByteArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ByteArrayType> result = new HashSet<ByteArrayType>();
		for (SByteArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SByteArrayType> convertToSListByteArrayType(Collection<ByteArrayType> input) {
		List<SByteArrayType> result = new ArrayList<SByteArrayType>();
		for (ByteArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ByteArrayType> convertFromSListByteArrayType(Collection<SByteArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ByteArrayType> result = new ArrayList<ByteArrayType>();
		for (SByteArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SByteArrayType convertToSObject(ByteArrayType input) {
		if (input == null) {
			return null;
		}
		
		SByteArrayType result = new SByteArrayType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}
	public ByteArrayType convertFromSObject(SByteArrayType input, DatabaseSession session) throws BimserverDatabaseException {
		ByteArrayType result = convertFromSObject(input, StoreFactory.eINSTANCE.createByteArrayType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ByteArrayType convertFromSObject(SByteArrayType input, ByteArrayType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SDoubleType> convertToSSetDoubleType(Collection<DoubleType> input) {
		Set<SDoubleType> result = new HashSet<SDoubleType>();
		for (DoubleType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DoubleType> convertFromSSetDoubleType(Collection<SDoubleType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<DoubleType> result = new HashSet<DoubleType>();
		for (SDoubleType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDoubleType> convertToSListDoubleType(Collection<DoubleType> input) {
		List<SDoubleType> result = new ArrayList<SDoubleType>();
		for (DoubleType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DoubleType> convertFromSListDoubleType(Collection<SDoubleType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<DoubleType> result = new ArrayList<DoubleType>();
		for (SDoubleType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDoubleType convertToSObject(DoubleType input) {
		if (input == null) {
			return null;
		}
		
		SDoubleType result = new SDoubleType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}
	public DoubleType convertFromSObject(SDoubleType input, DatabaseSession session) throws BimserverDatabaseException {
		DoubleType result = convertFromSObject(input, StoreFactory.eINSTANCE.createDoubleType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public DoubleType convertFromSObject(SDoubleType input, DoubleType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SStringType> convertToSSetStringType(Collection<StringType> input) {
		Set<SStringType> result = new HashSet<SStringType>();
		for (StringType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<StringType> convertFromSSetStringType(Collection<SStringType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<StringType> result = new HashSet<StringType>();
		for (SStringType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SStringType> convertToSListStringType(Collection<StringType> input) {
		List<SStringType> result = new ArrayList<SStringType>();
		for (StringType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<StringType> convertFromSListStringType(Collection<SStringType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<StringType> result = new ArrayList<StringType>();
		for (SStringType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SStringType convertToSObject(StringType input) {
		if (input == null) {
			return null;
		}
		
		SStringType result = new SStringType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setValue(input.getValue());
		return result;
	}
	public StringType convertFromSObject(SStringType input, DatabaseSession session) throws BimserverDatabaseException {
		StringType result = convertFromSObject(input, StoreFactory.eINSTANCE.createStringType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public StringType convertFromSObject(SStringType input, StringType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.getValue());
		return result;
	}

	public Set<SBooleanType> convertToSSetBooleanType(Collection<BooleanType> input) {
		Set<SBooleanType> result = new HashSet<SBooleanType>();
		for (BooleanType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<BooleanType> convertFromSSetBooleanType(Collection<SBooleanType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<BooleanType> result = new HashSet<BooleanType>();
		for (SBooleanType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBooleanType> convertToSListBooleanType(Collection<BooleanType> input) {
		List<SBooleanType> result = new ArrayList<SBooleanType>();
		for (BooleanType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<BooleanType> convertFromSListBooleanType(Collection<SBooleanType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<BooleanType> result = new ArrayList<BooleanType>();
		for (SBooleanType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBooleanType convertToSObject(BooleanType input) {
		if (input == null) {
			return null;
		}
		
		SBooleanType result = new SBooleanType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setValue(input.isValue());
		return result;
	}
	public BooleanType convertFromSObject(SBooleanType input, DatabaseSession session) throws BimserverDatabaseException {
		BooleanType result = convertFromSObject(input, StoreFactory.eINSTANCE.createBooleanType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public BooleanType convertFromSObject(SBooleanType input, BooleanType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setValue(input.isValue());
		return result;
	}

	public Set<SArrayType> convertToSSetArrayType(Collection<ArrayType> input) {
		Set<SArrayType> result = new HashSet<SArrayType>();
		for (ArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ArrayType> convertFromSSetArrayType(Collection<SArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ArrayType> result = new HashSet<ArrayType>();
		for (SArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SArrayType> convertToSListArrayType(Collection<ArrayType> input) {
		List<SArrayType> result = new ArrayList<SArrayType>();
		for (ArrayType o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ArrayType> convertFromSListArrayType(Collection<SArrayType> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ArrayType> result = new ArrayList<ArrayType>();
		for (SArrayType o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SArrayType convertToSObject(ArrayType input) {
		if (input == null) {
			return null;
		}
		
		SArrayType result = new SArrayType();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		List<SType> listvalues = new ArrayList<SType>();
		for (Type v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}
	public ArrayType convertFromSObject(SArrayType input, DatabaseSession session) throws BimserverDatabaseException {
		ArrayType result = convertFromSObject(input, StoreFactory.eINSTANCE.createArrayType(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ArrayType convertFromSObject(SArrayType input, ArrayType result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		List<Type> listvalues = result.getValues();
		for (SType v : input.getValues()) {
			listvalues.add(convertFromSObject(v, session));
		}
		return result;
	}

	public Set<SParameter> convertToSSetParameter(Collection<Parameter> input) {
		Set<SParameter> result = new HashSet<SParameter>();
		for (Parameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Parameter> convertFromSSetParameter(Collection<SParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Parameter> result = new HashSet<Parameter>();
		for (SParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SParameter> convertToSListParameter(Collection<Parameter> input) {
		List<SParameter> result = new ArrayList<SParameter>();
		for (Parameter o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Parameter> convertFromSListParameter(Collection<SParameter> input, DatabaseSession session) throws BimserverDatabaseException {
		List<Parameter> result = new ArrayList<Parameter>();
		for (SParameter o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SParameter convertToSObject(Parameter input) {
		if (input == null) {
			return null;
		}
		
		SParameter result = new SParameter();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setName(input.getName());
		Type valueVal = input.getValue();
		result.setValue(convertToSObject(valueVal));
		return result;
	}
	public Parameter convertFromSObject(SParameter input, DatabaseSession session) throws BimserverDatabaseException {
		Parameter result = convertFromSObject(input, StoreFactory.eINSTANCE.createParameter(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public Parameter convertFromSObject(SParameter input, Parameter result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setName(input.getName());
		result.setValue(convertFromSObject(input.getValue(), session));
		return result;
	}
		public SNotifictionResultEnum convertToSObject(NotifictionResultEnum input) {
			return SNotifictionResultEnum.values()[input.ordinal()];
		}
		
		public NotifictionResultEnum convertFromSObject(SNotifictionResultEnum input) {
			return NotifictionResultEnum.values()[input.ordinal()];
		}

	public Set<SImmediateNotificationResult> convertToSSetImmediateNotificationResult(Collection<ImmediateNotificationResult> input) {
		Set<SImmediateNotificationResult> result = new HashSet<SImmediateNotificationResult>();
		for (ImmediateNotificationResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ImmediateNotificationResult> convertFromSSetImmediateNotificationResult(Collection<SImmediateNotificationResult> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ImmediateNotificationResult> result = new HashSet<ImmediateNotificationResult>();
		for (SImmediateNotificationResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SImmediateNotificationResult> convertToSListImmediateNotificationResult(Collection<ImmediateNotificationResult> input) {
		List<SImmediateNotificationResult> result = new ArrayList<SImmediateNotificationResult>();
		for (ImmediateNotificationResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ImmediateNotificationResult> convertFromSListImmediateNotificationResult(Collection<SImmediateNotificationResult> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ImmediateNotificationResult> result = new ArrayList<ImmediateNotificationResult>();
		for (SImmediateNotificationResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SImmediateNotificationResult convertToSObject(ImmediateNotificationResult input) {
		if (input == null) {
			return null;
		}
		
		SImmediateNotificationResult result = new SImmediateNotificationResult();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setResult(SNotifictionResultEnum.values()[input.getResult().ordinal()]);
		result.setDescription(input.getDescription());
		return result;
	}
	public ImmediateNotificationResult convertFromSObject(SImmediateNotificationResult input, DatabaseSession session) throws BimserverDatabaseException {
		ImmediateNotificationResult result = convertFromSObject(input, StoreFactory.eINSTANCE.createImmediateNotificationResult(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public ImmediateNotificationResult convertFromSObject(SImmediateNotificationResult input, ImmediateNotificationResult result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setResult(NotifictionResultEnum.values()[input.getResult().ordinal()]);
		result.setDescription(input.getDescription());
		return result;
	}

	public Set<SRemoteServiceUpdate> convertToSSetRemoteServiceUpdate(Collection<RemoteServiceUpdate> input) {
		Set<SRemoteServiceUpdate> result = new HashSet<SRemoteServiceUpdate>();
		for (RemoteServiceUpdate o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RemoteServiceUpdate> convertFromSSetRemoteServiceUpdate(Collection<SRemoteServiceUpdate> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<RemoteServiceUpdate> result = new HashSet<RemoteServiceUpdate>();
		for (SRemoteServiceUpdate o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRemoteServiceUpdate> convertToSListRemoteServiceUpdate(Collection<RemoteServiceUpdate> input) {
		List<SRemoteServiceUpdate> result = new ArrayList<SRemoteServiceUpdate>();
		for (RemoteServiceUpdate o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RemoteServiceUpdate> convertFromSListRemoteServiceUpdate(Collection<SRemoteServiceUpdate> input, DatabaseSession session) throws BimserverDatabaseException {
		List<RemoteServiceUpdate> result = new ArrayList<RemoteServiceUpdate>();
		for (SRemoteServiceUpdate o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRemoteServiceUpdate convertToSObject(RemoteServiceUpdate input) {
		if (input == null) {
			return null;
		}
		
		if (input instanceof PercentageChange) {
			return convertToSObject((PercentageChange)input);
		}
		SRemoteServiceUpdate result = new SRemoteServiceUpdate();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		return result;
	}
	public RemoteServiceUpdate convertFromSObject(SRemoteServiceUpdate input, DatabaseSession session) throws BimserverDatabaseException {
		RemoteServiceUpdate result = convertFromSObject(input, StoreFactory.eINSTANCE.createRemoteServiceUpdate(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public RemoteServiceUpdate convertFromSObject(SRemoteServiceUpdate input, RemoteServiceUpdate result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		if (input instanceof SPercentageChange) {
			return convertFromSObject((SPercentageChange)input, session);
		}
		return result;
	}

	public Set<SPercentageChange> convertToSSetPercentageChange(Collection<PercentageChange> input) {
		Set<SPercentageChange> result = new HashSet<SPercentageChange>();
		for (PercentageChange o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PercentageChange> convertFromSSetPercentageChange(Collection<SPercentageChange> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<PercentageChange> result = new HashSet<PercentageChange>();
		for (SPercentageChange o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPercentageChange> convertToSListPercentageChange(Collection<PercentageChange> input) {
		List<SPercentageChange> result = new ArrayList<SPercentageChange>();
		for (PercentageChange o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PercentageChange> convertFromSListPercentageChange(Collection<SPercentageChange> input, DatabaseSession session) throws BimserverDatabaseException {
		List<PercentageChange> result = new ArrayList<PercentageChange>();
		for (SPercentageChange o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPercentageChange convertToSObject(PercentageChange input) {
		if (input == null) {
			return null;
		}
		
		SPercentageChange result = new SPercentageChange();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setPercentage(input.getPercentage());
		return result;
	}
	public PercentageChange convertFromSObject(SPercentageChange input, DatabaseSession session) throws BimserverDatabaseException {
		PercentageChange result = convertFromSObject(input, StoreFactory.eINSTANCE.createPercentageChange(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public PercentageChange convertFromSObject(SPercentageChange input, PercentageChange result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setPercentage(input.getPercentage());
		return result;
	}

	public Set<SSystemInfo> convertToSSetSystemInfo(Collection<SystemInfo> input) {
		Set<SSystemInfo> result = new HashSet<SSystemInfo>();
		for (SystemInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SystemInfo> convertFromSSetSystemInfo(Collection<SSystemInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<SystemInfo> result = new HashSet<SystemInfo>();
		for (SSystemInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSystemInfo> convertToSListSystemInfo(Collection<SystemInfo> input) {
		List<SSystemInfo> result = new ArrayList<SSystemInfo>();
		for (SystemInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SystemInfo> convertFromSListSystemInfo(Collection<SSystemInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<SystemInfo> result = new ArrayList<SystemInfo>();
		for (SSystemInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSystemInfo convertToSObject(SystemInfo input) {
		if (input == null) {
			return null;
		}
		
		SSystemInfo result = new SSystemInfo();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setCpucores(input.getCpucores());
		result.setDatetime(input.getDatetime());
		result.setOsname(input.getOsname());
		result.setOsversion(input.getOsversion());
		result.setUserName(input.getUserName());
		result.setUserHome(input.getUserHome());
		result.setUserDir(input.getUserDir());
		return result;
	}
	public SystemInfo convertFromSObject(SSystemInfo input, DatabaseSession session) throws BimserverDatabaseException {
		SystemInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createSystemInfo(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public SystemInfo convertFromSObject(SSystemInfo input, SystemInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setCpucores(input.getCpucores());
		result.setDatetime(input.getDatetime());
		result.setOsname(input.getOsname());
		result.setOsversion(input.getOsversion());
		result.setUserName(input.getUserName());
		result.setUserHome(input.getUserHome());
		result.setUserDir(input.getUserDir());
		return result;
	}

	public Set<SJavaInfo> convertToSSetJavaInfo(Collection<JavaInfo> input) {
		Set<SJavaInfo> result = new HashSet<SJavaInfo>();
		for (JavaInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<JavaInfo> convertFromSSetJavaInfo(Collection<SJavaInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<JavaInfo> result = new HashSet<JavaInfo>();
		for (SJavaInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SJavaInfo> convertToSListJavaInfo(Collection<JavaInfo> input) {
		List<SJavaInfo> result = new ArrayList<SJavaInfo>();
		for (JavaInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<JavaInfo> convertFromSListJavaInfo(Collection<SJavaInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<JavaInfo> result = new ArrayList<JavaInfo>();
		for (SJavaInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SJavaInfo convertToSObject(JavaInfo input) {
		if (input == null) {
			return null;
		}
		
		SJavaInfo result = new SJavaInfo();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setHeapTotal(input.getHeapTotal());
		result.setHeapUsed(input.getHeapUsed());
		result.setHeapFree(input.getHeapFree());
		result.setHeapMax(input.getHeapMax());
		result.setThreads(input.getThreads());
		result.setJavaHome(input.getJavaHome());
		result.setJavaVersion(input.getJavaVersion());
		result.setJavaVendor(input.getJavaVendor());
		result.setJavaVendorurl(input.getJavaVendorurl());
		result.setJavavmVersion(input.getJavavmVersion());
		result.setJavavmVendor(input.getJavavmVendor());
		result.setJavavmName(input.getJavavmName());
		result.setJavaspecVersion(input.getJavaspecVersion());
		result.setJavaspecVendor(input.getJavaspecVendor());
		result.setJavaspecName(input.getJavaspecName());
		result.setJavaClassVersion(input.getJavaClassVersion());
		result.getJavaClasspath().addAll(input.getJavaClasspath());
		result.getJavaLibrarypath().addAll(input.getJavaLibrarypath());
		result.setJavaIoTmp(input.getJavaIoTmp());
		result.setJavaCompiler(input.getJavaCompiler());
		result.setJavaExtdir(input.getJavaExtdir());
		result.setJavaFileSeparator(input.getJavaFileSeparator());
		result.setJavaPathSeparator(input.getJavaPathSeparator());
		result.setJavaLineSeparator(input.getJavaLineSeparator());
		return result;
	}
	public JavaInfo convertFromSObject(SJavaInfo input, DatabaseSession session) throws BimserverDatabaseException {
		JavaInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createJavaInfo(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public JavaInfo convertFromSObject(SJavaInfo input, JavaInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setHeapTotal(input.getHeapTotal());
		result.setHeapUsed(input.getHeapUsed());
		result.setHeapFree(input.getHeapFree());
		result.setHeapMax(input.getHeapMax());
		result.setThreads(input.getThreads());
		result.setJavaHome(input.getJavaHome());
		result.setJavaVersion(input.getJavaVersion());
		result.setJavaVendor(input.getJavaVendor());
		result.setJavaVendorurl(input.getJavaVendorurl());
		result.setJavavmVersion(input.getJavavmVersion());
		result.setJavavmVendor(input.getJavavmVendor());
		result.setJavavmName(input.getJavavmName());
		result.setJavaspecVersion(input.getJavaspecVersion());
		result.setJavaspecVendor(input.getJavaspecVendor());
		result.setJavaspecName(input.getJavaspecName());
		result.setJavaClassVersion(input.getJavaClassVersion());
		result.getJavaClasspath().addAll(input.getJavaClasspath());
		result.getJavaLibrarypath().addAll(input.getJavaLibrarypath());
		result.setJavaIoTmp(input.getJavaIoTmp());
		result.setJavaCompiler(input.getJavaCompiler());
		result.setJavaExtdir(input.getJavaExtdir());
		result.setJavaFileSeparator(input.getJavaFileSeparator());
		result.setJavaPathSeparator(input.getJavaPathSeparator());
		result.setJavaLineSeparator(input.getJavaLineSeparator());
		return result;
	}

	public Set<SBimServerInfo> convertToSSetBimServerInfo(Collection<BimServerInfo> input) {
		Set<SBimServerInfo> result = new HashSet<SBimServerInfo>();
		for (BimServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<BimServerInfo> convertFromSSetBimServerInfo(Collection<SBimServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<BimServerInfo> result = new HashSet<BimServerInfo>();
		for (SBimServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SBimServerInfo> convertToSListBimServerInfo(Collection<BimServerInfo> input) {
		List<SBimServerInfo> result = new ArrayList<SBimServerInfo>();
		for (BimServerInfo o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<BimServerInfo> convertFromSListBimServerInfo(Collection<SBimServerInfo> input, DatabaseSession session) throws BimserverDatabaseException {
		List<BimServerInfo> result = new ArrayList<BimServerInfo>();
		for (SBimServerInfo o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SBimServerInfo convertToSObject(BimServerInfo input) {
		if (input == null) {
			return null;
		}
		
		SBimServerInfo result = new SBimServerInfo();
		result.setOid(input.getOid());
		result.setRid(input.getRid());
		result.setCurrentVersion(input.getCurrentVersion());
		result.setCurrentDate(input.getCurrentDate());
		result.setSchemaVersion(input.getSchemaVersion());
		result.setLatestDate(input.getLatestDate());
		result.setLatestVersion(input.getLatestVersion());
		result.setProjects(input.getProjects());
		result.setRevisions(input.getRevisions());
		result.setUsers(input.getUsers());
		result.setCheckouts(input.getCheckouts());
		result.setServerLogUrl(input.getServerLogUrl());
		result.setStarted(input.getStarted());
		result.setUptime(input.getUptime());
		return result;
	}
	public BimServerInfo convertFromSObject(SBimServerInfo input, DatabaseSession session) throws BimserverDatabaseException {
		BimServerInfo result = convertFromSObject(input, StoreFactory.eINSTANCE.createBimServerInfo(), session);
		
		((IdEObjectImpl)result).setOid(input.getOid());
		((IdEObjectImpl)result).setRid(input.getRid());
		
		return result;
	}

	public BimServerInfo convertFromSObject(SBimServerInfo input, BimServerInfo result, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		result.setCurrentVersion(input.getCurrentVersion());
		result.setCurrentDate(input.getCurrentDate());
		result.setSchemaVersion(input.getSchemaVersion());
		result.setLatestDate(input.getLatestDate());
		result.setLatestVersion(input.getLatestVersion());
		result.setProjects(input.getProjects());
		result.setRevisions(input.getRevisions());
		result.setUsers(input.getUsers());
		result.setCheckouts(input.getCheckouts());
		result.setServerLogUrl(input.getServerLogUrl());
		result.setStarted(input.getStarted());
		result.setUptime(input.getUptime());
		return result;
	}
		public SProgressTopicType convertToSObject(ProgressTopicType input) {
			return SProgressTopicType.values()[input.ordinal()];
		}
		
		public ProgressTopicType convertFromSObject(SProgressTopicType input) {
			return ProgressTopicType.values()[input.ordinal()];
		}
}