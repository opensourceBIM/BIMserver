package org.bimserver.interfaces;

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

import org.bimserver.interfaces.objects.*;
import java.util.*;
import org.bimserver.models.log.*;
import org.bimserver.models.store.*;
import org.bimserver.database.BimDatabaseSession;

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
		if (o instanceof UserDeleted) {
			result.add(convertToSObject((UserDeleted)o));		
		}
		else if (o instanceof ProjectUndeleted) {
			result.add(convertToSObject((ProjectUndeleted)o));		
		}
		else if (o instanceof ClashDetectionSettingsUpdated) {
			result.add(convertToSObject((ClashDetectionSettingsUpdated)o));		
		}
		else if (o instanceof GeoTagUpdated) {
			result.add(convertToSObject((GeoTagUpdated)o));		
		}
		else if (o instanceof NewCheckoutAdded) {
			result.add(convertToSObject((NewCheckoutAdded)o));		
		}
		else if (o instanceof ProjectUpdated) {
			result.add(convertToSObject((ProjectUpdated)o));		
		}
		else if (o instanceof UserUndeleted) {
			result.add(convertToSObject((UserUndeleted)o));		
		}
		else if (o instanceof NewProjectAdded) {
			result.add(convertToSObject((NewProjectAdded)o));		
		}
		else if (o instanceof NewRevisionAdded) {
			result.add(convertToSObject((NewRevisionAdded)o));		
		}
		else if (o instanceof DatabaseCreated) {
			result.add(convertToSObject((DatabaseCreated)o));		
		}
		else if (o instanceof PasswordChanged) {
			result.add(convertToSObject((PasswordChanged)o));		
		}
		else if (o instanceof NewUserAdded) {
			result.add(convertToSObject((NewUserAdded)o));		
		}
		else if (o instanceof Download) {
			result.add(convertToSObject((Download)o));		
		}
		else if (o instanceof UserRemovedFromProject) {
			result.add(convertToSObject((UserRemovedFromProject)o));		
		}
		else if (o instanceof RevisionUpdated) {
			result.add(convertToSObject((RevisionUpdated)o));		
		}
		else if (o instanceof SettingsSaved) {
			result.add(convertToSObject((SettingsSaved)o));		
		}
		else if (o instanceof NewObjectIDMUploaded) {
			result.add(convertToSObject((NewObjectIDMUploaded)o));		
		}
		else if (o instanceof PasswordReset) {
			result.add(convertToSObject((PasswordReset)o));		
		}
		else if (o instanceof ServerStarted) {
			result.add(convertToSObject((ServerStarted)o));		
		}
		else if (o instanceof ProjectDeleted) {
			result.add(convertToSObject((ProjectDeleted)o));		
		}
		else if (o instanceof UserAddedToProject) {
			result.add(convertToSObject((UserAddedToProject)o));		
		}
		else if (o instanceof UserChanged) {
			result.add(convertToSObject((UserChanged)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<LogAction> convertFromSSetLogAction(Collection<SLogAction> input, BimDatabaseSession session) {
		Set<LogAction> result = new HashSet<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLogAction> convertToSListLogAction(Collection<LogAction> input) {
		List<SLogAction> result = new ArrayList<SLogAction>();
		for (LogAction o : input) {
		if (o instanceof UserDeleted) {
			result.add(convertToSObject((UserDeleted)o));		
		}
		else if (o instanceof ProjectUndeleted) {
			result.add(convertToSObject((ProjectUndeleted)o));		
		}
		else if (o instanceof ClashDetectionSettingsUpdated) {
			result.add(convertToSObject((ClashDetectionSettingsUpdated)o));		
		}
		else if (o instanceof GeoTagUpdated) {
			result.add(convertToSObject((GeoTagUpdated)o));		
		}
		else if (o instanceof NewCheckoutAdded) {
			result.add(convertToSObject((NewCheckoutAdded)o));		
		}
		else if (o instanceof ProjectUpdated) {
			result.add(convertToSObject((ProjectUpdated)o));		
		}
		else if (o instanceof UserUndeleted) {
			result.add(convertToSObject((UserUndeleted)o));		
		}
		else if (o instanceof NewProjectAdded) {
			result.add(convertToSObject((NewProjectAdded)o));		
		}
		else if (o instanceof NewRevisionAdded) {
			result.add(convertToSObject((NewRevisionAdded)o));		
		}
		else if (o instanceof DatabaseCreated) {
			result.add(convertToSObject((DatabaseCreated)o));		
		}
		else if (o instanceof PasswordChanged) {
			result.add(convertToSObject((PasswordChanged)o));		
		}
		else if (o instanceof NewUserAdded) {
			result.add(convertToSObject((NewUserAdded)o));		
		}
		else if (o instanceof Download) {
			result.add(convertToSObject((Download)o));		
		}
		else if (o instanceof UserRemovedFromProject) {
			result.add(convertToSObject((UserRemovedFromProject)o));		
		}
		else if (o instanceof RevisionUpdated) {
			result.add(convertToSObject((RevisionUpdated)o));		
		}
		else if (o instanceof SettingsSaved) {
			result.add(convertToSObject((SettingsSaved)o));		
		}
		else if (o instanceof NewObjectIDMUploaded) {
			result.add(convertToSObject((NewObjectIDMUploaded)o));		
		}
		else if (o instanceof PasswordReset) {
			result.add(convertToSObject((PasswordReset)o));		
		}
		else if (o instanceof ServerStarted) {
			result.add(convertToSObject((ServerStarted)o));		
		}
		else if (o instanceof ProjectDeleted) {
			result.add(convertToSObject((ProjectDeleted)o));		
		}
		else if (o instanceof UserAddedToProject) {
			result.add(convertToSObject((UserAddedToProject)o));		
		}
		else if (o instanceof UserChanged) {
			result.add(convertToSObject((UserChanged)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<LogAction> convertFromSListLogAction(Collection<SLogAction> input, BimDatabaseSession session) {
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
		SLogAction result = new SLogAction();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		LogAction result = LogFactory.eINSTANCE.createLogAction();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SServerLog> convertToSSetServerLog(Collection<ServerLog> input) {
		Set<SServerLog> result = new HashSet<SServerLog>();
		for (ServerLog o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerLog> convertFromSSetServerLog(Collection<SServerLog> input, BimDatabaseSession session) {
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

	public List<ServerLog> convertFromSListServerLog(Collection<SServerLog> input, BimDatabaseSession session) {
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
		List<Long> listactions = new ArrayList<Long>();
		for (LogAction v : input.getActions()) {
			listactions.add(v.getOid());
		}
		result.setActions(listactions);
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ServerLog result = LogFactory.eINSTANCE.createServerLog();
		result.setOid(input.getOid());
		List<LogAction> listactions = result.getActions();
		for (long oid : input.getActions()) {
			listactions.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, false, null));
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

	public Set<NewUserAdded> convertFromSSetNewUserAdded(Collection<SNewUserAdded> input, BimDatabaseSession session) {
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

	public List<NewUserAdded> convertFromSListNewUserAdded(Collection<SNewUserAdded> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewUserAdded result = LogFactory.eINSTANCE.createNewUserAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SNewProjectAdded> convertToSSetNewProjectAdded(Collection<NewProjectAdded> input) {
		Set<SNewProjectAdded> result = new HashSet<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectAdded> convertFromSSetNewProjectAdded(Collection<SNewProjectAdded> input, BimDatabaseSession session) {
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

	public List<NewProjectAdded> convertFromSListNewProjectAdded(Collection<SNewProjectAdded> input, BimDatabaseSession session) {
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

	public NewProjectAdded convertFromSObject(SNewProjectAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewProjectAdded result = LogFactory.eINSTANCE.createNewProjectAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		result.setParentProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentProjectId(), false, null));
		return result;
	}

	public Set<SNewRevisionAdded> convertToSSetNewRevisionAdded(Collection<NewRevisionAdded> input) {
		Set<SNewRevisionAdded> result = new HashSet<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewRevisionAdded> convertFromSSetNewRevisionAdded(Collection<SNewRevisionAdded> input, BimDatabaseSession session) {
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

	public List<NewRevisionAdded> convertFromSListNewRevisionAdded(Collection<SNewRevisionAdded> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewRevisionAdded result = LogFactory.eINSTANCE.createNewRevisionAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		return result;
	}

	public Set<SNewCheckoutAdded> convertToSSetNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		Set<SNewCheckoutAdded> result = new HashSet<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewCheckoutAdded> convertFromSSetNewCheckoutAdded(Collection<SNewCheckoutAdded> input, BimDatabaseSession session) {
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

	public List<NewCheckoutAdded> convertFromSListNewCheckoutAdded(Collection<SNewCheckoutAdded> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewCheckoutAdded result = LogFactory.eINSTANCE.createNewCheckoutAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setCheckout((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), input.getCheckoutId(), false, null));
		return result;
	}

	public Set<SSettingsSaved> convertToSSetSettingsSaved(Collection<SettingsSaved> input) {
		Set<SSettingsSaved> result = new HashSet<SSettingsSaved>();
		for (SettingsSaved o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SettingsSaved> convertFromSSetSettingsSaved(Collection<SSettingsSaved> input, BimDatabaseSession session) {
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

	public List<SettingsSaved> convertFromSListSettingsSaved(Collection<SSettingsSaved> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		SettingsSaved result = LogFactory.eINSTANCE.createSettingsSaved();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SUserAddedToProject> convertToSSetUserAddedToProject(Collection<UserAddedToProject> input) {
		Set<SUserAddedToProject> result = new HashSet<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserAddedToProject> convertFromSSetUserAddedToProject(Collection<SUserAddedToProject> input, BimDatabaseSession session) {
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

	public List<UserAddedToProject> convertFromSListUserAddedToProject(Collection<SUserAddedToProject> input, BimDatabaseSession session) {
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

	public UserAddedToProject convertFromSObject(SUserAddedToProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserAddedToProject result = LogFactory.eINSTANCE.createUserAddedToProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SNewObjectIDMUploaded> convertToSSetNewObjectIDMUploaded(Collection<NewObjectIDMUploaded> input) {
		Set<SNewObjectIDMUploaded> result = new HashSet<SNewObjectIDMUploaded>();
		for (NewObjectIDMUploaded o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewObjectIDMUploaded> convertFromSSetNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, BimDatabaseSession session) {
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

	public List<NewObjectIDMUploaded> convertFromSListNewObjectIDMUploaded(Collection<SNewObjectIDMUploaded> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewObjectIDMUploaded result = LogFactory.eINSTANCE.createNewObjectIDMUploaded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SDownload> convertToSSetDownload(Collection<Download> input) {
		Set<SDownload> result = new HashSet<SDownload>();
		for (Download o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Download> convertFromSSetDownload(Collection<SDownload> input, BimDatabaseSession session) {
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

	public List<Download> convertFromSListDownload(Collection<SDownload> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public Download convertFromSObject(SDownload input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Download result = LogFactory.eINSTANCE.createDownload();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SUserRemovedFromProject> convertToSSetUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		Set<SUserRemovedFromProject> result = new HashSet<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserRemovedFromProject> convertFromSSetUserRemovedFromProject(Collection<SUserRemovedFromProject> input, BimDatabaseSession session) {
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

	public List<UserRemovedFromProject> convertFromSListUserRemovedFromProject(Collection<SUserRemovedFromProject> input, BimDatabaseSession session) {
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

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserRemovedFromProject result = LogFactory.eINSTANCE.createUserRemovedFromProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SProjectDeleted> convertToSSetProjectDeleted(Collection<ProjectDeleted> input) {
		Set<SProjectDeleted> result = new HashSet<SProjectDeleted>();
		for (ProjectDeleted o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectDeleted> convertFromSSetProjectDeleted(Collection<SProjectDeleted> input, BimDatabaseSession session) {
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

	public List<ProjectDeleted> convertFromSListProjectDeleted(Collection<SProjectDeleted> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectDeleted result = LogFactory.eINSTANCE.createProjectDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SUserDeleted> convertToSSetUserDeleted(Collection<UserDeleted> input) {
		Set<SUserDeleted> result = new HashSet<SUserDeleted>();
		for (UserDeleted o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserDeleted> convertFromSSetUserDeleted(Collection<SUserDeleted> input, BimDatabaseSession session) {
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

	public List<UserDeleted> convertFromSListUserDeleted(Collection<SUserDeleted> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserDeleted result = LogFactory.eINSTANCE.createUserDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SPasswordReset> convertToSSetPasswordReset(Collection<PasswordReset> input) {
		Set<SPasswordReset> result = new HashSet<SPasswordReset>();
		for (PasswordReset o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordReset> convertFromSSetPasswordReset(Collection<SPasswordReset> input, BimDatabaseSession session) {
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

	public List<PasswordReset> convertFromSListPasswordReset(Collection<SPasswordReset> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		PasswordReset result = LogFactory.eINSTANCE.createPasswordReset();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SDatabaseCreated> convertToSSetDatabaseCreated(Collection<DatabaseCreated> input) {
		Set<SDatabaseCreated> result = new HashSet<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseCreated> convertFromSSetDatabaseCreated(Collection<SDatabaseCreated> input, BimDatabaseSession session) {
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

	public List<DatabaseCreated> convertFromSListDatabaseCreated(Collection<SDatabaseCreated> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DatabaseCreated result = LogFactory.eINSTANCE.createDatabaseCreated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SServerStarted> convertToSSetServerStarted(Collection<ServerStarted> input) {
		Set<SServerStarted> result = new HashSet<SServerStarted>();
		for (ServerStarted o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerStarted> convertFromSSetServerStarted(Collection<SServerStarted> input, BimDatabaseSession session) {
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

	public List<ServerStarted> convertFromSListServerStarted(Collection<SServerStarted> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ServerStarted result = LogFactory.eINSTANCE.createServerStarted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		return result;
	}

	public Set<SProjectUpdated> convertToSSetProjectUpdated(Collection<ProjectUpdated> input) {
		Set<SProjectUpdated> result = new HashSet<SProjectUpdated>();
		for (ProjectUpdated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUpdated> convertFromSSetProjectUpdated(Collection<SProjectUpdated> input, BimDatabaseSession session) {
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

	public List<ProjectUpdated> convertFromSListProjectUpdated(Collection<SProjectUpdated> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectUpdated result = LogFactory.eINSTANCE.createProjectUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SUserUndeleted> convertToSSetUserUndeleted(Collection<UserUndeleted> input) {
		Set<SUserUndeleted> result = new HashSet<SUserUndeleted>();
		for (UserUndeleted o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserUndeleted> convertFromSSetUserUndeleted(Collection<SUserUndeleted> input, BimDatabaseSession session) {
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

	public List<UserUndeleted> convertFromSListUserUndeleted(Collection<SUserUndeleted> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserUndeleted result = LogFactory.eINSTANCE.createUserUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SProjectUndeleted> convertToSSetProjectUndeleted(Collection<ProjectUndeleted> input) {
		Set<SProjectUndeleted> result = new HashSet<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUndeleted> convertFromSSetProjectUndeleted(Collection<SProjectUndeleted> input, BimDatabaseSession session) {
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

	public List<ProjectUndeleted> convertFromSListProjectUndeleted(Collection<SProjectUndeleted> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectUndeleted result = LogFactory.eINSTANCE.createProjectUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SRevisionUpdated> convertToSSetRevisionUpdated(Collection<RevisionUpdated> input) {
		Set<SRevisionUpdated> result = new HashSet<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionUpdated> convertFromSSetRevisionUpdated(Collection<SRevisionUpdated> input, BimDatabaseSession session) {
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

	public List<RevisionUpdated> convertFromSListRevisionUpdated(Collection<SRevisionUpdated> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RevisionUpdated result = LogFactory.eINSTANCE.createRevisionUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		return result;
	}

	public Set<SGeoTagUpdated> convertToSSetGeoTagUpdated(Collection<GeoTagUpdated> input) {
		Set<SGeoTagUpdated> result = new HashSet<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTagUpdated> convertFromSSetGeoTagUpdated(Collection<SGeoTagUpdated> input, BimDatabaseSession session) {
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

	public List<GeoTagUpdated> convertFromSListGeoTagUpdated(Collection<SGeoTagUpdated> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GeoTagUpdated result = LogFactory.eINSTANCE.createGeoTagUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), false, null));
		return result;
	}

	public Set<SClashDetectionSettingsUpdated> convertToSSetClashDetectionSettingsUpdated(Collection<ClashDetectionSettingsUpdated> input) {
		Set<SClashDetectionSettingsUpdated> result = new HashSet<SClashDetectionSettingsUpdated>();
		for (ClashDetectionSettingsUpdated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ClashDetectionSettingsUpdated> convertFromSSetClashDetectionSettingsUpdated(Collection<SClashDetectionSettingsUpdated> input, BimDatabaseSession session) {
		Set<ClashDetectionSettingsUpdated> result = new HashSet<ClashDetectionSettingsUpdated>();
		for (SClashDetectionSettingsUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClashDetectionSettingsUpdated> convertToSListClashDetectionSettingsUpdated(Collection<ClashDetectionSettingsUpdated> input) {
		List<SClashDetectionSettingsUpdated> result = new ArrayList<SClashDetectionSettingsUpdated>();
		for (ClashDetectionSettingsUpdated o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ClashDetectionSettingsUpdated> convertFromSListClashDetectionSettingsUpdated(Collection<SClashDetectionSettingsUpdated> input, BimDatabaseSession session) {
		List<ClashDetectionSettingsUpdated> result = new ArrayList<ClashDetectionSettingsUpdated>();
		for (SClashDetectionSettingsUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClashDetectionSettingsUpdated convertToSObject(ClashDetectionSettingsUpdated input) {
		if (input == null) {
			return null;
		}
		SClashDetectionSettingsUpdated result = new SClashDetectionSettingsUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		ClashDetectionSettings clashDetectionSettingsVal = input.getClashDetectionSettings();
		result.setClashDetectionSettingsId(clashDetectionSettingsVal == null ? -1 : clashDetectionSettingsVal.getOid());
		return result;
	}

	public ClashDetectionSettingsUpdated convertFromSObject(SClashDetectionSettingsUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ClashDetectionSettingsUpdated result = LogFactory.eINSTANCE.createClashDetectionSettingsUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setClashDetectionSettings((ClashDetectionSettings)session.get(StorePackage.eINSTANCE.getClashDetectionSettings(), input.getClashDetectionSettingsId(), false, null));
		return result;
	}

	public Set<SPasswordChanged> convertToSSetPasswordChanged(Collection<PasswordChanged> input) {
		Set<SPasswordChanged> result = new HashSet<SPasswordChanged>();
		for (PasswordChanged o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordChanged> convertFromSSetPasswordChanged(Collection<SPasswordChanged> input, BimDatabaseSession session) {
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

	public List<PasswordChanged> convertFromSListPasswordChanged(Collection<SPasswordChanged> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		PasswordChanged result = LogFactory.eINSTANCE.createPasswordChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SUserChanged> convertToSSetUserChanged(Collection<UserChanged> input) {
		Set<SUserChanged> result = new HashSet<SUserChanged>();
		for (UserChanged o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserChanged> convertFromSSetUserChanged(Collection<SUserChanged> input, BimDatabaseSession session) {
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

	public List<UserChanged> convertFromSListUserChanged(Collection<SUserChanged> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserChanged result = LogFactory.eINSTANCE.createUserChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}
		public SUserType convertToSObject(UserType input) {
			return SUserType.values()[input.ordinal()];
		}
		
		public UserType convertFromSObject(SUserType input) {
			return UserType.values()[input.ordinal()];
		}
		public SCheckinState convertToSObject(CheckinState input) {
			return SCheckinState.values()[input.ordinal()];
		}
		
		public CheckinState convertFromSObject(SCheckinState input) {
			return CheckinState.values()[input.ordinal()];
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

	public Set<Project> convertFromSSetProject(Collection<SProject> input, BimDatabaseSession session) {
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

	public List<Project> convertFromSListProject(Collection<SProject> input, BimDatabaseSession session) {
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
		ClashDetectionSettings clashDetectionSettingsVal = input.getClashDetectionSettings();
		result.setClashDetectionSettingsId(clashDetectionSettingsVal == null ? -1 : clashDetectionSettingsVal.getOid());
		return result;
	}

	public Project convertFromSObject(SProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Project result = StoreFactory.eINSTANCE.createProject();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		List<User> listhasAuthorizedUsers = result.getHasAuthorizedUsers();
		for (long oid : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, false, null));
		}
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, false, null));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), false, null));
		result.setLastRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getLastRevisionId(), false, null));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, false, null));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), false, null));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), false, null));
		List<Project> listsubProjects = result.getSubProjects();
		for (long oid : input.getSubProjects()) {
			listsubProjects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false, null));
		}
		result.setParent((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentId(), false, null));
		result.setClashDetectionSettings((ClashDetectionSettings)session.get(StorePackage.eINSTANCE.getClashDetectionSettings(), input.getClashDetectionSettingsId(), false, null));
		return result;
	}

	public Set<SUser> convertToSSetUser(Collection<User> input) {
		Set<SUser> result = new HashSet<SUser>();
		for (User o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<User> convertFromSSetUser(Collection<SUser> input, BimDatabaseSession session) {
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

	public List<User> convertFromSListUser(Collection<SUser> input, BimDatabaseSession session) {
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
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(SUserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		result.setNotificationUrl(input.getNotificationUrl());
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
		return result;
	}

	public User convertFromSObject(SUser input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		User result = StoreFactory.eINSTANCE.createUser();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(UserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		result.setNotificationUrl(input.getNotificationUrl());
		List<Project> listhasRightsOn = result.getHasRightsOn();
		for (long oid : input.getHasRightsOn()) {
			listhasRightsOn.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false, null));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), false, null));
		return result;
	}

	public Set<SClash> convertToSSetClash(Collection<Clash> input) {
		Set<SClash> result = new HashSet<SClash>();
		for (Clash o : input) {
		if (o instanceof GuidClash) {
			result.add(convertToSObject((GuidClash)o));		
		}
		else if (o instanceof EidClash) {
			result.add(convertToSObject((EidClash)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<Clash> convertFromSSetClash(Collection<SClash> input, BimDatabaseSession session) {
		Set<Clash> result = new HashSet<Clash>();
		for (SClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClash> convertToSListClash(Collection<Clash> input) {
		List<SClash> result = new ArrayList<SClash>();
		for (Clash o : input) {
		if (o instanceof GuidClash) {
			result.add(convertToSObject((GuidClash)o));		
		}
		else if (o instanceof EidClash) {
			result.add(convertToSObject((EidClash)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<Clash> convertFromSListClash(Collection<SClash> input, BimDatabaseSession session) {
		List<Clash> result = new ArrayList<Clash>();
		for (SClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClash convertToSObject(Clash input) {
		if (input == null) {
			return null;
		}
		SClash result = new SClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public Clash convertFromSObject(SClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Clash result = StoreFactory.eINSTANCE.createClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false, null));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false, null));
		return result;
	}

	public Set<SEidClash> convertToSSetEidClash(Collection<EidClash> input) {
		Set<SEidClash> result = new HashSet<SEidClash>();
		for (EidClash o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<EidClash> convertFromSSetEidClash(Collection<SEidClash> input, BimDatabaseSession session) {
		Set<EidClash> result = new HashSet<EidClash>();
		for (SEidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SEidClash> convertToSListEidClash(Collection<EidClash> input) {
		List<SEidClash> result = new ArrayList<SEidClash>();
		for (EidClash o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<EidClash> convertFromSListEidClash(Collection<SEidClash> input, BimDatabaseSession session) {
		List<EidClash> result = new ArrayList<EidClash>();
		for (SEidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SEidClash convertToSObject(EidClash input) {
		if (input == null) {
			return null;
		}
		SEidClash result = new SEidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setEid1(input.getEid1());
		result.setEid2(input.getEid2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public EidClash convertFromSObject(SEidClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		EidClash result = StoreFactory.eINSTANCE.createEidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setEid1(input.getEid1());
		result.setEid2(input.getEid2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false, null));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false, null));
		return result;
	}

	public Set<SGuidClash> convertToSSetGuidClash(Collection<GuidClash> input) {
		Set<SGuidClash> result = new HashSet<SGuidClash>();
		for (GuidClash o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GuidClash> convertFromSSetGuidClash(Collection<SGuidClash> input, BimDatabaseSession session) {
		Set<GuidClash> result = new HashSet<GuidClash>();
		for (SGuidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGuidClash> convertToSListGuidClash(Collection<GuidClash> input) {
		List<SGuidClash> result = new ArrayList<SGuidClash>();
		for (GuidClash o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GuidClash> convertFromSListGuidClash(Collection<SGuidClash> input, BimDatabaseSession session) {
		List<GuidClash> result = new ArrayList<GuidClash>();
		for (SGuidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGuidClash convertToSObject(GuidClash input) {
		if (input == null) {
			return null;
		}
		SGuidClash result = new SGuidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setGuid1(input.getGuid1());
		result.setGuid2(input.getGuid2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public GuidClash convertFromSObject(SGuidClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GuidClash result = StoreFactory.eINSTANCE.createGuidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setGuid1(input.getGuid1());
		result.setGuid2(input.getGuid2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false, null));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false, null));
		return result;
	}

	public Set<SClashDetectionSettings> convertToSSetClashDetectionSettings(Collection<ClashDetectionSettings> input) {
		Set<SClashDetectionSettings> result = new HashSet<SClashDetectionSettings>();
		for (ClashDetectionSettings o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ClashDetectionSettings> convertFromSSetClashDetectionSettings(Collection<SClashDetectionSettings> input, BimDatabaseSession session) {
		Set<ClashDetectionSettings> result = new HashSet<ClashDetectionSettings>();
		for (SClashDetectionSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClashDetectionSettings> convertToSListClashDetectionSettings(Collection<ClashDetectionSettings> input) {
		List<SClashDetectionSettings> result = new ArrayList<SClashDetectionSettings>();
		for (ClashDetectionSettings o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ClashDetectionSettings> convertFromSListClashDetectionSettings(Collection<SClashDetectionSettings> input, BimDatabaseSession session) {
		List<ClashDetectionSettings> result = new ArrayList<ClashDetectionSettings>();
		for (SClashDetectionSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClashDetectionSettings convertToSObject(ClashDetectionSettings input) {
		if (input == null) {
			return null;
		}
		SClashDetectionSettings result = new SClashDetectionSettings();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setMargin(input.getMargin());
		result.getIgnoredClasses().addAll(input.getIgnoredClasses());
		List<Long> listprojects = new ArrayList<Long>();
		for (Project v : input.getProjects()) {
			listprojects.add(v.getOid());
		}
		result.setProjects(listprojects);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		return result;
	}

	public ClashDetectionSettings convertFromSObject(SClashDetectionSettings input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ClashDetectionSettings result = StoreFactory.eINSTANCE.createClashDetectionSettings();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setMargin(input.getMargin());
		result.getIgnoredClasses().addAll(input.getIgnoredClasses());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false, null));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
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

	public Set<Revision> convertFromSSetRevision(Collection<SRevision> input, BimDatabaseSession session) {
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

	public List<Revision> convertFromSListRevision(Collection<SRevision> input, BimDatabaseSession session) {
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
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setState(SCheckinState.values()[input.getState().ordinal()]);
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setNrClashes(input.getNrClashes());
		result.setLaid(input.getLaid());
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
		List<Long> listlastClashes = new ArrayList<Long>();
		for (Clash v : input.getLastClashes()) {
			listlastClashes.add(v.getOid());
		}
		result.setLastClashes(listlastClashes);
		return result;
	}

	public Revision convertFromSObject(SRevision input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Revision result = StoreFactory.eINSTANCE.createRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setState(CheckinState.values()[input.getState().ordinal()]);
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setNrClashes(input.getNrClashes());
		result.setLaid(input.getLaid());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, false, null));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), false, null));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, false, null));
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		List<Clash> listlastClashes = result.getLastClashes();
		for (long oid : input.getLastClashes()) {
			listlastClashes.add((Clash)session.get(StorePackage.eINSTANCE.getClash(), oid, false, null));
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

	public Set<ConcreteRevision> convertFromSSetConcreteRevision(Collection<SConcreteRevision> input, BimDatabaseSession session) {
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

	public List<ConcreteRevision> convertFromSListConcreteRevision(Collection<SConcreteRevision> input, BimDatabaseSession session) {
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
		result.setId(input.getId());
		result.setState(SCheckinState.values()[input.getState().ordinal()]);
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ConcreteRevision result = StoreFactory.eINSTANCE.createConcreteRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setState(CheckinState.values()[input.getState().ordinal()]);
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		return result;
	}

	public Set<SGeoTag> convertToSSetGeoTag(Collection<GeoTag> input) {
		Set<SGeoTag> result = new HashSet<SGeoTag>();
		for (GeoTag o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTag> convertFromSSetGeoTag(Collection<SGeoTag> input, BimDatabaseSession session) {
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

	public List<GeoTag> convertFromSListGeoTag(Collection<SGeoTag> input, BimDatabaseSession session) {
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
		result.setEnabled(input.isEnabled());
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

	public GeoTag convertFromSObject(SGeoTag input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GeoTag result = StoreFactory.eINSTANCE.createGeoTag();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false, null));
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

	public Set<Checkout> convertFromSSetCheckout(Collection<SCheckout> input, BimDatabaseSession session) {
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

	public List<Checkout> convertFromSListCheckout(Collection<SCheckout> input, BimDatabaseSession session) {
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
		result.setDate(input.getDate());
		result.setActive(input.isActive());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Revision checkinVal = input.getCheckin();
		result.setCheckinId(checkinVal == null ? -1 : checkinVal.getOid());
		return result;
	}

	public Checkout convertFromSObject(SCheckout input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Checkout result = StoreFactory.eINSTANCE.createCheckout();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setActive(input.isActive());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		result.setCheckin((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getCheckinId(), false, null));
		return result;
	}

	public Set<SSettings> convertToSSetSettings(Collection<Settings> input) {
		Set<SSettings> result = new HashSet<SSettings>();
		for (Settings o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Settings> convertFromSSetSettings(Collection<SSettings> input, BimDatabaseSession session) {
		Set<Settings> result = new HashSet<Settings>();
		for (SSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSettings> convertToSListSettings(Collection<Settings> input) {
		List<SSettings> result = new ArrayList<SSettings>();
		for (Settings o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Settings> convertFromSListSettings(Collection<SSettings> input, BimDatabaseSession session) {
		List<Settings> result = new ArrayList<Settings>();
		for (SSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSettings convertToSObject(Settings input) {
		if (input == null) {
			return null;
		}
		SSettings result = new SSettings();
		result.setOid(input.getOid());
		result.setShowVersionUpgradeAvailable(input.isShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.isUseCaching());
		result.setAllowSelfRegistration(input.isAllowSelfRegistration());
		result.setAutoTestClashes(input.isAutoTestClashes());
		result.setIntelligentMerging(input.isIntelligentMerging());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.isCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHideUserListForNonAdmin(input.isHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setMergeIdentifier(SMergeIdentifier.values()[input.getMergeIdentifier().ordinal()]);
		result.setCacheOutputFiles(input.isCacheOutputFiles());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		List<Long> listobjectIDMs = new ArrayList<Long>();
		for (ObjectIDM v : input.getObjectIDMs()) {
			listobjectIDMs.add(v.getOid());
		}
		result.setObjectIDMs(listobjectIDMs);
		List<Long> listifcEngines = new ArrayList<Long>();
		for (IfcEngine v : input.getIfcEngines()) {
			listifcEngines.add(v.getOid());
		}
		result.setIfcEngines(listifcEngines);
		List<Long> listplugins = new ArrayList<Long>();
		for (Plugin v : input.getPlugins()) {
			listplugins.add(v.getOid());
		}
		result.setPlugins(listplugins);
		List<Long> listdeserializers = new ArrayList<Long>();
		for (Deserializer v : input.getDeserializers()) {
			listdeserializers.add(v.getOid());
		}
		result.setDeserializers(listdeserializers);
		return result;
	}

	public Settings convertFromSObject(SSettings input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Settings result = StoreFactory.eINSTANCE.createSettings();
		result.setOid(input.getOid());
		result.setShowVersionUpgradeAvailable(input.isShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.isUseCaching());
		result.setAllowSelfRegistration(input.isAllowSelfRegistration());
		result.setAutoTestClashes(input.isAutoTestClashes());
		result.setIntelligentMerging(input.isIntelligentMerging());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.isCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHideUserListForNonAdmin(input.isHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setMergeIdentifier(MergeIdentifier.values()[input.getMergeIdentifier().ordinal()]);
		result.setCacheOutputFiles(input.isCacheOutputFiles());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false, null));
		}
		List<ObjectIDM> listobjectIDMs = result.getObjectIDMs();
		for (long oid : input.getObjectIDMs()) {
			listobjectIDMs.add((ObjectIDM)session.get(StorePackage.eINSTANCE.getObjectIDM(), oid, false, null));
		}
		List<IfcEngine> listifcEngines = result.getIfcEngines();
		for (long oid : input.getIfcEngines()) {
			listifcEngines.add((IfcEngine)session.get(StorePackage.eINSTANCE.getIfcEngine(), oid, false, null));
		}
		List<Plugin> listplugins = result.getPlugins();
		for (long oid : input.getPlugins()) {
			listplugins.add((Plugin)session.get(StorePackage.eINSTANCE.getPlugin(), oid, false, null));
		}
		List<Deserializer> listdeserializers = result.getDeserializers();
		for (long oid : input.getDeserializers()) {
			listdeserializers.add((Deserializer)session.get(StorePackage.eINSTANCE.getDeserializer(), oid, false, null));
		}
		return result;
	}

	public Set<SSerializer> convertToSSetSerializer(Collection<Serializer> input) {
		Set<SSerializer> result = new HashSet<SSerializer>();
		for (Serializer o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Serializer> convertFromSSetSerializer(Collection<SSerializer> input, BimDatabaseSession session) {
		Set<Serializer> result = new HashSet<Serializer>();
		for (SSerializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSerializer> convertToSListSerializer(Collection<Serializer> input) {
		List<SSerializer> result = new ArrayList<SSerializer>();
		for (Serializer o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Serializer> convertFromSListSerializer(Collection<SSerializer> input, BimDatabaseSession session) {
		List<Serializer> result = new ArrayList<Serializer>();
		for (SSerializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSerializer convertToSObject(Serializer input) {
		if (input == null) {
			return null;
		}
		SSerializer result = new SSerializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultSerializer(input.isDefaultSerializer());
		ObjectIDM objectIDMVal = input.getObjectIDM();
		result.setObjectIDMId(objectIDMVal == null ? -1 : objectIDMVal.getOid());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Serializer convertFromSObject(SSerializer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Serializer result = StoreFactory.eINSTANCE.createSerializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultSerializer(input.isDefaultSerializer());
		result.setObjectIDM((ObjectIDM)session.get(StorePackage.eINSTANCE.getObjectIDM(), input.getObjectIDMId(), false, null));
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SObjectIDM> convertToSSetObjectIDM(Collection<ObjectIDM> input) {
		Set<SObjectIDM> result = new HashSet<SObjectIDM>();
		for (ObjectIDM o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDM> convertFromSSetObjectIDM(Collection<SObjectIDM> input, BimDatabaseSession session) {
		Set<ObjectIDM> result = new HashSet<ObjectIDM>();
		for (SObjectIDM o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SObjectIDM> convertToSListObjectIDM(Collection<ObjectIDM> input) {
		List<SObjectIDM> result = new ArrayList<SObjectIDM>();
		for (ObjectIDM o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ObjectIDM> convertFromSListObjectIDM(Collection<SObjectIDM> input, BimDatabaseSession session) {
		List<ObjectIDM> result = new ArrayList<ObjectIDM>();
		for (SObjectIDM o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SObjectIDM convertToSObject(ObjectIDM input) {
		if (input == null) {
			return null;
		}
		SObjectIDM result = new SObjectIDM();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public ObjectIDM convertFromSObject(SObjectIDM input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ObjectIDM result = StoreFactory.eINSTANCE.createObjectIDM();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false, null));
		}
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false, null));
		return result;
	}
		public SMergeIdentifier convertToSObject(MergeIdentifier input) {
			return SMergeIdentifier.values()[input.ordinal()];
		}
		
		public MergeIdentifier convertFromSObject(SMergeIdentifier input) {
			return MergeIdentifier.values()[input.ordinal()];
		}

	public Set<SIfcEngine> convertToSSetIfcEngine(Collection<IfcEngine> input) {
		Set<SIfcEngine> result = new HashSet<SIfcEngine>();
		for (IfcEngine o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<IfcEngine> convertFromSSetIfcEngine(Collection<SIfcEngine> input, BimDatabaseSession session) {
		Set<IfcEngine> result = new HashSet<IfcEngine>();
		for (SIfcEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SIfcEngine> convertToSListIfcEngine(Collection<IfcEngine> input) {
		List<SIfcEngine> result = new ArrayList<SIfcEngine>();
		for (IfcEngine o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<IfcEngine> convertFromSListIfcEngine(Collection<SIfcEngine> input, BimDatabaseSession session) {
		List<IfcEngine> result = new ArrayList<IfcEngine>();
		for (SIfcEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SIfcEngine convertToSObject(IfcEngine input) {
		if (input == null) {
			return null;
		}
		SIfcEngine result = new SIfcEngine();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setActive(input.isActive());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public IfcEngine convertFromSObject(SIfcEngine input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		IfcEngine result = StoreFactory.eINSTANCE.createIfcEngine();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setActive(input.isActive());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SPlugin> convertToSSetPlugin(Collection<Plugin> input) {
		Set<SPlugin> result = new HashSet<SPlugin>();
		for (Plugin o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Plugin> convertFromSSetPlugin(Collection<SPlugin> input, BimDatabaseSession session) {
		Set<Plugin> result = new HashSet<Plugin>();
		for (SPlugin o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPlugin> convertToSListPlugin(Collection<Plugin> input) {
		List<SPlugin> result = new ArrayList<SPlugin>();
		for (Plugin o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Plugin> convertFromSListPlugin(Collection<SPlugin> input, BimDatabaseSession session) {
		List<Plugin> result = new ArrayList<Plugin>();
		for (SPlugin o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPlugin convertToSObject(Plugin input) {
		if (input == null) {
			return null;
		}
		SPlugin result = new SPlugin();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.isEnabled());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Plugin convertFromSObject(SPlugin input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Plugin result = StoreFactory.eINSTANCE.createPlugin();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.isEnabled());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SDeserializer> convertToSSetDeserializer(Collection<Deserializer> input) {
		Set<SDeserializer> result = new HashSet<SDeserializer>();
		for (Deserializer o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Deserializer> convertFromSSetDeserializer(Collection<SDeserializer> input, BimDatabaseSession session) {
		Set<Deserializer> result = new HashSet<Deserializer>();
		for (SDeserializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDeserializer> convertToSListDeserializer(Collection<Deserializer> input) {
		List<SDeserializer> result = new ArrayList<SDeserializer>();
		for (Deserializer o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Deserializer> convertFromSListDeserializer(Collection<SDeserializer> input, BimDatabaseSession session) {
		List<Deserializer> result = new ArrayList<Deserializer>();
		for (SDeserializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDeserializer convertToSObject(Deserializer input) {
		if (input == null) {
			return null;
		}
		SDeserializer result = new SDeserializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultDeserializer(input.isDefaultDeserializer());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Deserializer convertFromSObject(SDeserializer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Deserializer result = StoreFactory.eINSTANCE.createDeserializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultDeserializer(input.isDefaultDeserializer());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SCheckinResult> convertToSSetCheckinResult(Collection<CheckinResult> input) {
		Set<SCheckinResult> result = new HashSet<SCheckinResult>();
		for (CheckinResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckinResult> convertFromSSetCheckinResult(Collection<SCheckinResult> input, BimDatabaseSession session) {
		Set<CheckinResult> result = new HashSet<CheckinResult>();
		for (SCheckinResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckinResult> convertToSListCheckinResult(Collection<CheckinResult> input) {
		List<SCheckinResult> result = new ArrayList<SCheckinResult>();
		for (CheckinResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CheckinResult> convertFromSListCheckinResult(Collection<SCheckinResult> input, BimDatabaseSession session) {
		List<CheckinResult> result = new ArrayList<CheckinResult>();
		for (SCheckinResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckinResult convertToSObject(CheckinResult input) {
		if (input == null) {
			return null;
		}
		SCheckinResult result = new SCheckinResult();
		result.setOid(input.getOid());
		result.setProgress(input.getProgress());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public CheckinResult convertFromSObject(SCheckinResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CheckinResult result = StoreFactory.eINSTANCE.createCheckinResult();
		result.setOid(input.getOid());
		result.setProgress(input.getProgress());
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SDownloadResult> convertToSSetDownloadResult(Collection<DownloadResult> input) {
		Set<SDownloadResult> result = new HashSet<SDownloadResult>();
		for (DownloadResult o : input) {
		if (o instanceof CheckoutResult) {
			result.add(convertToSObject((CheckoutResult)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<DownloadResult> convertFromSSetDownloadResult(Collection<SDownloadResult> input, BimDatabaseSession session) {
		Set<DownloadResult> result = new HashSet<DownloadResult>();
		for (SDownloadResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownloadResult> convertToSListDownloadResult(Collection<DownloadResult> input) {
		List<SDownloadResult> result = new ArrayList<SDownloadResult>();
		for (DownloadResult o : input) {
		if (o instanceof CheckoutResult) {
			result.add(convertToSObject((CheckoutResult)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<DownloadResult> convertFromSListDownloadResult(Collection<SDownloadResult> input, BimDatabaseSession session) {
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
		SDownloadResult result = new SDownloadResult();
		result.setOid(input.getOid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DownloadResult result = StoreFactory.eINSTANCE.createDownloadResult();
		result.setOid(input.getOid());
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

	public Set<CheckoutResult> convertFromSSetCheckoutResult(Collection<SCheckoutResult> input, BimDatabaseSession session) {
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

	public List<CheckoutResult> convertFromSListCheckoutResult(Collection<SCheckoutResult> input, BimDatabaseSession session) {
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
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CheckoutResult result = StoreFactory.eINSTANCE.createCheckoutResult();
		result.setOid(input.getOid());
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public Set<SDataValue> convertToSSetDataValue(Collection<DataValue> input) {
		Set<SDataValue> result = new HashSet<SDataValue>();
		for (DataValue o : input) {
		if (o instanceof SimpleDataValue) {
			result.add(convertToSObject((SimpleDataValue)o));		
		}
		else if (o instanceof ListDataValue) {
			result.add(convertToSObject((ListDataValue)o));		
		}
		else if (o instanceof ReferenceDataValue) {
			result.add(convertToSObject((ReferenceDataValue)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<DataValue> convertFromSSetDataValue(Collection<SDataValue> input, BimDatabaseSession session) {
		Set<DataValue> result = new HashSet<DataValue>();
		for (SDataValue o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDataValue> convertToSListDataValue(Collection<DataValue> input) {
		List<SDataValue> result = new ArrayList<SDataValue>();
		for (DataValue o : input) {
		if (o instanceof SimpleDataValue) {
			result.add(convertToSObject((SimpleDataValue)o));		
		}
		else if (o instanceof ListDataValue) {
			result.add(convertToSObject((ListDataValue)o));		
		}
		else if (o instanceof ReferenceDataValue) {
			result.add(convertToSObject((ReferenceDataValue)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<DataValue> convertFromSListDataValue(Collection<SDataValue> input, BimDatabaseSession session) {
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
		SDataValue result = new SDataValue();
		result.setOid(input.getOid());
		result.setFieldName(input.getFieldName());
		return result;
	}

	public DataValue convertFromSObject(SDataValue input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DataValue result = StoreFactory.eINSTANCE.createDataValue();
		result.setOid(input.getOid());
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

	public Set<DataObject> convertFromSSetDataObject(Collection<SDataObject> input, BimDatabaseSession session) {
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

	public List<DataObject> convertFromSListDataObject(Collection<SDataObject> input, BimDatabaseSession session) {
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

	public DataObject convertFromSObject(SDataObject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DataObject result = StoreFactory.eINSTANCE.createDataObject();
		result.setOid(input.getOid());
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

	public Set<UserSession> convertFromSSetUserSession(Collection<SUserSession> input, BimDatabaseSession session) {
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

	public List<UserSession> convertFromSListUserSession(Collection<SUserSession> input, BimDatabaseSession session) {
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

	public UserSession convertFromSObject(SUserSession input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserSession result = StoreFactory.eINSTANCE.createUserSession();
		result.setOid(input.getOid());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setType(UserType.values()[input.getType().ordinal()]);
		result.setRemoteAddress(input.getRemoteAddress());
		result.setActiveSince(input.getActiveSince());
		result.setLastActive(input.getLastActive());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SMigration> convertToSSetMigration(Collection<Migration> input) {
		Set<SMigration> result = new HashSet<SMigration>();
		for (Migration o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Migration> convertFromSSetMigration(Collection<SMigration> input, BimDatabaseSession session) {
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

	public List<Migration> convertFromSListMigration(Collection<SMigration> input, BimDatabaseSession session) {
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
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.isExecuted());
		return result;
	}

	public Migration convertFromSObject(SMigration input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Migration result = StoreFactory.eINSTANCE.createMigration();
		result.setOid(input.getOid());
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.isExecuted());
		return result;
	}

	public Set<SReferenceDataValue> convertToSSetReferenceDataValue(Collection<ReferenceDataValue> input) {
		Set<SReferenceDataValue> result = new HashSet<SReferenceDataValue>();
		for (ReferenceDataValue o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ReferenceDataValue> convertFromSSetReferenceDataValue(Collection<SReferenceDataValue> input, BimDatabaseSession session) {
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

	public List<ReferenceDataValue> convertFromSListReferenceDataValue(Collection<SReferenceDataValue> input, BimDatabaseSession session) {
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
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ReferenceDataValue result = StoreFactory.eINSTANCE.createReferenceDataValue();
		result.setOid(input.getOid());
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

	public Set<ListDataValue> convertFromSSetListDataValue(Collection<SListDataValue> input, BimDatabaseSession session) {
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

	public List<ListDataValue> convertFromSListListDataValue(Collection<SListDataValue> input, BimDatabaseSession session) {
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
		result.setFieldName(input.getFieldName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ListDataValue result = StoreFactory.eINSTANCE.createListDataValue();
		result.setOid(input.getOid());
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

	public Set<SimpleDataValue> convertFromSSetSimpleDataValue(Collection<SSimpleDataValue> input, BimDatabaseSession session) {
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

	public List<SimpleDataValue> convertFromSListSimpleDataValue(Collection<SSimpleDataValue> input, BimDatabaseSession session) {
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
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		SimpleDataValue result = StoreFactory.eINSTANCE.createSimpleDataValue();
		result.setOid(input.getOid());
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

	public Set<DatabaseInformationItem> convertFromSSetDatabaseInformationItem(Collection<SDatabaseInformationItem> input, BimDatabaseSession session) {
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

	public List<DatabaseInformationItem> convertFromSListDatabaseInformationItem(Collection<SDatabaseInformationItem> input, BimDatabaseSession session) {
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
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DatabaseInformationItem result = StoreFactory.eINSTANCE.createDatabaseInformationItem();
		result.setOid(input.getOid());
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

	public Set<DatabaseInformationCategory> convertFromSSetDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, BimDatabaseSession session) {
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

	public List<DatabaseInformationCategory> convertFromSListDatabaseInformationCategory(Collection<SDatabaseInformationCategory> input, BimDatabaseSession session) {
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
		result.setTitle(input.getTitle());
		List<SDatabaseInformationItem> listitems = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DatabaseInformationCategory result = StoreFactory.eINSTANCE.createDatabaseInformationCategory();
		result.setOid(input.getOid());
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

	public Set<DatabaseInformation> convertFromSSetDatabaseInformation(Collection<SDatabaseInformation> input, BimDatabaseSession session) {
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

	public List<DatabaseInformation> convertFromSListDatabaseInformation(Collection<SDatabaseInformation> input, BimDatabaseSession session) {
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

	public DatabaseInformation convertFromSObject(SDatabaseInformation input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DatabaseInformation result = StoreFactory.eINSTANCE.createDatabaseInformation();
		result.setOid(input.getOid());
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

	public Set<SSerializerPluginDescriptor> convertToSSetSerializerPluginDescriptor(Collection<SerializerPluginDescriptor> input) {
		Set<SSerializerPluginDescriptor> result = new HashSet<SSerializerPluginDescriptor>();
		for (SerializerPluginDescriptor o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SerializerPluginDescriptor> convertFromSSetSerializerPluginDescriptor(Collection<SSerializerPluginDescriptor> input, BimDatabaseSession session) {
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

	public List<SerializerPluginDescriptor> convertFromSListSerializerPluginDescriptor(Collection<SSerializerPluginDescriptor> input, BimDatabaseSession session) {
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
		result.setPluginClassName(input.getPluginClassName());
		result.setDefaultName(input.getDefaultName());
		result.setDefaultExtension(input.getDefaultExtension());
		result.setDefaultContentType(input.getDefaultContentType());
		return result;
	}

	public SerializerPluginDescriptor convertFromSObject(SSerializerPluginDescriptor input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		SerializerPluginDescriptor result = StoreFactory.eINSTANCE.createSerializerPluginDescriptor();
		result.setOid(input.getOid());
		result.setPluginClassName(input.getPluginClassName());
		result.setDefaultName(input.getDefaultName());
		result.setDefaultExtension(input.getDefaultExtension());
		result.setDefaultContentType(input.getDefaultContentType());
		return result;
	}

	public Set<SDeserializerPluginDescriptor> convertToSSetDeserializerPluginDescriptor(Collection<DeserializerPluginDescriptor> input) {
		Set<SDeserializerPluginDescriptor> result = new HashSet<SDeserializerPluginDescriptor>();
		for (DeserializerPluginDescriptor o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DeserializerPluginDescriptor> convertFromSSetDeserializerPluginDescriptor(Collection<SDeserializerPluginDescriptor> input, BimDatabaseSession session) {
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

	public List<DeserializerPluginDescriptor> convertFromSListDeserializerPluginDescriptor(Collection<SDeserializerPluginDescriptor> input, BimDatabaseSession session) {
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
		result.setPluginClassName(input.getPluginClassName());
		result.setDefaultName(input.getDefaultName());
		return result;
	}

	public DeserializerPluginDescriptor convertFromSObject(SDeserializerPluginDescriptor input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DeserializerPluginDescriptor result = StoreFactory.eINSTANCE.createDeserializerPluginDescriptor();
		result.setOid(input.getOid());
		result.setPluginClassName(input.getPluginClassName());
		result.setDefaultName(input.getDefaultName());
		return result;
	}

	public Set<SRevisionSummaryType> convertToSSetRevisionSummaryType(Collection<RevisionSummaryType> input) {
		Set<SRevisionSummaryType> result = new HashSet<SRevisionSummaryType>();
		for (RevisionSummaryType o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionSummaryType> convertFromSSetRevisionSummaryType(Collection<SRevisionSummaryType> input, BimDatabaseSession session) {
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

	public List<RevisionSummaryType> convertFromSListRevisionSummaryType(Collection<SRevisionSummaryType> input, BimDatabaseSession session) {
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
		result.setName(input.getName());
		result.setCount(input.getCount());
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RevisionSummaryType result = StoreFactory.eINSTANCE.createRevisionSummaryType();
		result.setOid(input.getOid());
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

	public Set<RevisionSummaryContainer> convertFromSSetRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, BimDatabaseSession session) {
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

	public List<RevisionSummaryContainer> convertFromSListRevisionSummaryContainer(Collection<SRevisionSummaryContainer> input, BimDatabaseSession session) {
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
		result.setName(input.getName());
		List<SRevisionSummaryType> listtypes = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertToSObject(v));
		}
		result.setTypes(listtypes);
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RevisionSummaryContainer result = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		result.setOid(input.getOid());
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

	public Set<RevisionSummary> convertFromSSetRevisionSummary(Collection<SRevisionSummary> input, BimDatabaseSession session) {
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

	public List<RevisionSummary> convertFromSListRevisionSummary(Collection<SRevisionSummary> input, BimDatabaseSession session) {
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
		List<SRevisionSummaryContainer> listlist = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer v : input.getList()) {
			listlist.add(convertToSObject(v));
		}
		result.setList(listlist);
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RevisionSummary result = StoreFactory.eINSTANCE.createRevisionSummary();
		result.setOid(input.getOid());
		List<RevisionSummaryContainer> listlist = result.getList();
		for (SRevisionSummaryContainer v : input.getList()) {
			listlist.add(convertFromSObject(v, session));
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

	public Set<PluginDescriptor> convertFromSSetPluginDescriptor(Collection<SPluginDescriptor> input, BimDatabaseSession session) {
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

	public List<PluginDescriptor> convertFromSListPluginDescriptor(Collection<SPluginDescriptor> input, BimDatabaseSession session) {
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
		SPluginDescriptor result = new SPluginDescriptor();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.isEnabled());
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		PluginDescriptor result = StoreFactory.eINSTANCE.createPluginDescriptor();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.isEnabled());
		return result;
	}

	public Set<SLongAction> convertToSSetLongAction(Collection<LongAction> input) {
		Set<SLongAction> result = new HashSet<SLongAction>();
		for (LongAction o : input) {
		if (o instanceof LongCheckinAction) {
			result.add(convertToSObject((LongCheckinAction)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<LongAction> convertFromSSetLongAction(Collection<SLongAction> input, BimDatabaseSession session) {
		Set<LongAction> result = new HashSet<LongAction>();
		for (SLongAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongAction> convertToSListLongAction(Collection<LongAction> input) {
		List<SLongAction> result = new ArrayList<SLongAction>();
		for (LongAction o : input) {
		if (o instanceof LongCheckinAction) {
			result.add(convertToSObject((LongCheckinAction)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<LongAction> convertFromSListLongAction(Collection<SLongAction> input, BimDatabaseSession session) {
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
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public LongAction convertFromSObject(SLongAction input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		LongAction result = StoreFactory.eINSTANCE.createLongAction();
		result.setOid(input.getOid());
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}

	public Set<SLongCheckinAction> convertToSSetLongCheckinAction(Collection<LongCheckinAction> input) {
		Set<SLongCheckinAction> result = new HashSet<SLongCheckinAction>();
		for (LongCheckinAction o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LongCheckinAction> convertFromSSetLongCheckinAction(Collection<SLongCheckinAction> input, BimDatabaseSession session) {
		Set<LongCheckinAction> result = new HashSet<LongCheckinAction>();
		for (SLongCheckinAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLongCheckinAction> convertToSListLongCheckinAction(Collection<LongCheckinAction> input) {
		List<SLongCheckinAction> result = new ArrayList<SLongCheckinAction>();
		for (LongCheckinAction o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LongCheckinAction> convertFromSListLongCheckinAction(Collection<SLongCheckinAction> input, BimDatabaseSession session) {
		List<LongCheckinAction> result = new ArrayList<LongCheckinAction>();
		for (SLongCheckinAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLongCheckinAction convertToSObject(LongCheckinAction input) {
		if (input == null) {
			return null;
		}
		SLongCheckinAction result = new SLongCheckinAction();
		result.setOid(input.getOid());
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		return result;
	}

	public LongCheckinAction convertFromSObject(SLongCheckinAction input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		LongCheckinAction result = StoreFactory.eINSTANCE.createLongCheckinAction();
		result.setOid(input.getOid());
		result.setIdentification(input.getIdentification());
		result.setStart(input.getStart());
		result.setUsername(input.getUsername());
		result.setName(input.getName());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		return result;
	}

	public Set<SObjectIDMPluginDescriptor> convertToSSetObjectIDMPluginDescriptor(Collection<ObjectIDMPluginDescriptor> input) {
		Set<SObjectIDMPluginDescriptor> result = new HashSet<SObjectIDMPluginDescriptor>();
		for (ObjectIDMPluginDescriptor o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDMPluginDescriptor> convertFromSSetObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, BimDatabaseSession session) {
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

	public List<ObjectIDMPluginDescriptor> convertFromSListObjectIDMPluginDescriptor(Collection<SObjectIDMPluginDescriptor> input, BimDatabaseSession session) {
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
		result.setClassName(input.getClassName());
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ObjectIDMPluginDescriptor result = StoreFactory.eINSTANCE.createObjectIDMPluginDescriptor();
		result.setOid(input.getOid());
		result.setClassName(input.getClassName());
		return result;
	}
		public SCompareIdentifier convertToSObject(CompareIdentifier input) {
			return SCompareIdentifier.values()[input.ordinal()];
		}
		
		public CompareIdentifier convertFromSObject(SCompareIdentifier input) {
			return CompareIdentifier.values()[input.ordinal()];
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
		if (o instanceof ObjectRemoved) {
			result.add(convertToSObject((ObjectRemoved)o));		
		}
		else if (o instanceof ObjectModified) {
			result.add(convertToSObject((ObjectModified)o));		
		}
		else if (o instanceof ObjectAdded) {
			result.add(convertToSObject((ObjectAdded)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<CompareItem> convertFromSSetCompareItem(Collection<SCompareItem> input, BimDatabaseSession session) {
		Set<CompareItem> result = new HashSet<CompareItem>();
		for (SCompareItem o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompareItem> convertToSListCompareItem(Collection<CompareItem> input) {
		List<SCompareItem> result = new ArrayList<SCompareItem>();
		for (CompareItem o : input) {
		if (o instanceof ObjectRemoved) {
			result.add(convertToSObject((ObjectRemoved)o));		
		}
		else if (o instanceof ObjectModified) {
			result.add(convertToSObject((ObjectModified)o));		
		}
		else if (o instanceof ObjectAdded) {
			result.add(convertToSObject((ObjectAdded)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<CompareItem> convertFromSListCompareItem(Collection<SCompareItem> input, BimDatabaseSession session) {
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
		SCompareItem result = new SCompareItem();
		result.setOid(input.getOid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CompareItem result = StoreFactory.eINSTANCE.createCompareItem();
		result.setOid(input.getOid());
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

	public Set<ObjectAdded> convertFromSSetObjectAdded(Collection<SObjectAdded> input, BimDatabaseSession session) {
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

	public List<ObjectAdded> convertFromSListObjectAdded(Collection<SObjectAdded> input, BimDatabaseSession session) {
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
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ObjectAdded result = StoreFactory.eINSTANCE.createObjectAdded();
		result.setOid(input.getOid());
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

	public Set<ObjectRemoved> convertFromSSetObjectRemoved(Collection<SObjectRemoved> input, BimDatabaseSession session) {
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

	public List<ObjectRemoved> convertFromSListObjectRemoved(Collection<SObjectRemoved> input, BimDatabaseSession session) {
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
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ObjectRemoved result = StoreFactory.eINSTANCE.createObjectRemoved();
		result.setOid(input.getOid());
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

	public Set<ObjectModified> convertFromSSetObjectModified(Collection<SObjectModified> input, BimDatabaseSession session) {
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

	public List<ObjectModified> convertFromSListObjectModified(Collection<SObjectModified> input, BimDatabaseSession session) {
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
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ObjectModified result = StoreFactory.eINSTANCE.createObjectModified();
		result.setOid(input.getOid());
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

	public Set<CompareContainer> convertFromSSetCompareContainer(Collection<SCompareContainer> input, BimDatabaseSession session) {
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

	public List<CompareContainer> convertFromSListCompareContainer(Collection<SCompareContainer> input, BimDatabaseSession session) {
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
		result.setType(input.getType());
		List<SCompareItem> listitems = new ArrayList<SCompareItem>();
		for (CompareItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CompareContainer result = StoreFactory.eINSTANCE.createCompareContainer();
		result.setOid(input.getOid());
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

	public Set<CompareResult> convertFromSSetCompareResult(Collection<SCompareResult> input, BimDatabaseSession session) {
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

	public List<CompareResult> convertFromSListCompareResult(Collection<SCompareResult> input, BimDatabaseSession session) {
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
		List<SCompareContainer> listitems = new ArrayList<SCompareContainer>();
		for (CompareContainer v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CompareResult result = StoreFactory.eINSTANCE.createCompareResult();
		result.setOid(input.getOid());
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

	public Set<LongActionState> convertFromSSetLongActionState(Collection<SLongActionState> input, BimDatabaseSession session) {
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

	public List<LongActionState> convertFromSListLongActionState(Collection<SLongActionState> input, BimDatabaseSession session) {
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
		result.setProgress(input.getProgress());
		result.setState(SActionState.values()[input.getState().ordinal()]);
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		LongActionState result = StoreFactory.eINSTANCE.createLongActionState();
		result.setOid(input.getOid());
		result.setProgress(input.getProgress());
		result.setState(ActionState.values()[input.getState().ordinal()]);
		return result;
	}

	public Set<SNotification> convertToSSetNotification(Collection<Notification> input) {
		Set<SNotification> result = new HashSet<SNotification>();
		for (Notification o : input) {
		if (o instanceof NewProjectNotification) {
			result.add(convertToSObject((NewProjectNotification)o));		
		}
		else if (o instanceof NewRevisionNotification) {
			result.add(convertToSObject((NewRevisionNotification)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public Set<Notification> convertFromSSetNotification(Collection<SNotification> input, BimDatabaseSession session) {
		Set<Notification> result = new HashSet<Notification>();
		for (SNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNotification> convertToSListNotification(Collection<Notification> input) {
		List<SNotification> result = new ArrayList<SNotification>();
		for (Notification o : input) {
		if (o instanceof NewProjectNotification) {
			result.add(convertToSObject((NewProjectNotification)o));		
		}
		else if (o instanceof NewRevisionNotification) {
			result.add(convertToSObject((NewRevisionNotification)o));		
		}
	else {
		result.add(convertToSObject(o));
	}
		}
		return result;
	}

	public List<Notification> convertFromSListNotification(Collection<SNotification> input, BimDatabaseSession session) {
		List<Notification> result = new ArrayList<Notification>();
		for (SNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNotification convertToSObject(Notification input) {
		if (input == null) {
			return null;
		}
		SNotification result = new SNotification();
		result.setOid(input.getOid());
		return result;
	}

	public Notification convertFromSObject(SNotification input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Notification result = StoreFactory.eINSTANCE.createNotification();
		result.setOid(input.getOid());
		return result;
	}

	public Set<SNewProjectNotification> convertToSSetNewProjectNotification(Collection<NewProjectNotification> input) {
		Set<SNewProjectNotification> result = new HashSet<SNewProjectNotification>();
		for (NewProjectNotification o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectNotification> convertFromSSetNewProjectNotification(Collection<SNewProjectNotification> input, BimDatabaseSession session) {
		Set<NewProjectNotification> result = new HashSet<NewProjectNotification>();
		for (SNewProjectNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewProjectNotification> convertToSListNewProjectNotification(Collection<NewProjectNotification> input) {
		List<SNewProjectNotification> result = new ArrayList<SNewProjectNotification>();
		for (NewProjectNotification o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewProjectNotification> convertFromSListNewProjectNotification(Collection<SNewProjectNotification> input, BimDatabaseSession session) {
		List<NewProjectNotification> result = new ArrayList<NewProjectNotification>();
		for (SNewProjectNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewProjectNotification convertToSObject(NewProjectNotification input) {
		if (input == null) {
			return null;
		}
		SNewProjectNotification result = new SNewProjectNotification();
		result.setOid(input.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public NewProjectNotification convertFromSObject(SNewProjectNotification input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewProjectNotification result = StoreFactory.eINSTANCE.createNewProjectNotification();
		result.setOid(input.getOid());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		return result;
	}

	public Set<SNewRevisionNotification> convertToSSetNewRevisionNotification(Collection<NewRevisionNotification> input) {
		Set<SNewRevisionNotification> result = new HashSet<SNewRevisionNotification>();
		for (NewRevisionNotification o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewRevisionNotification> convertFromSSetNewRevisionNotification(Collection<SNewRevisionNotification> input, BimDatabaseSession session) {
		Set<NewRevisionNotification> result = new HashSet<NewRevisionNotification>();
		for (SNewRevisionNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewRevisionNotification> convertToSListNewRevisionNotification(Collection<NewRevisionNotification> input) {
		List<SNewRevisionNotification> result = new ArrayList<SNewRevisionNotification>();
		for (NewRevisionNotification o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewRevisionNotification> convertFromSListNewRevisionNotification(Collection<SNewRevisionNotification> input, BimDatabaseSession session) {
		List<NewRevisionNotification> result = new ArrayList<NewRevisionNotification>();
		for (SNewRevisionNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewRevisionNotification convertToSObject(NewRevisionNotification input) {
		if (input == null) {
			return null;
		}
		SNewRevisionNotification result = new SNewRevisionNotification();
		result.setOid(input.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public NewRevisionNotification convertFromSObject(SNewRevisionNotification input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewRevisionNotification result = StoreFactory.eINSTANCE.createNewRevisionNotification();
		result.setOid(input.getOid());
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		return result;
	}

	public Set<SCompileResult> convertToSSetCompileResult(Collection<CompileResult> input) {
		Set<SCompileResult> result = new HashSet<SCompileResult>();
		for (CompileResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CompileResult> convertFromSSetCompileResult(Collection<SCompileResult> input, BimDatabaseSession session) {
		Set<CompileResult> result = new HashSet<CompileResult>();
		for (SCompileResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCompileResult> convertToSListCompileResult(Collection<CompileResult> input) {
		List<SCompileResult> result = new ArrayList<SCompileResult>();
		for (CompileResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<CompileResult> convertFromSListCompileResult(Collection<SCompileResult> input, BimDatabaseSession session) {
		List<CompileResult> result = new ArrayList<CompileResult>();
		for (SCompileResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCompileResult convertToSObject(CompileResult input) {
		if (input == null) {
			return null;
		}
		SCompileResult result = new SCompileResult();
		result.setOid(input.getOid());
		result.setCompileOke(input.isCompileOke());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		return result;
	}

	public CompileResult convertFromSObject(SCompileResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		CompileResult result = StoreFactory.eINSTANCE.createCompileResult();
		result.setOid(input.getOid());
		result.setCompileOke(input.isCompileOke());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		return result;
	}

	public Set<SRunResult> convertToSSetRunResult(Collection<RunResult> input) {
		Set<SRunResult> result = new HashSet<SRunResult>();
		for (RunResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RunResult> convertFromSSetRunResult(Collection<SRunResult> input, BimDatabaseSession session) {
		Set<RunResult> result = new HashSet<RunResult>();
		for (SRunResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRunResult> convertToSListRunResult(Collection<RunResult> input) {
		List<SRunResult> result = new ArrayList<SRunResult>();
		for (RunResult o : input) {
		result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RunResult> convertFromSListRunResult(Collection<SRunResult> input, BimDatabaseSession session) {
		List<RunResult> result = new ArrayList<RunResult>();
		for (SRunResult o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRunResult convertToSObject(RunResult input) {
		if (input == null) {
			return null;
		}
		SRunResult result = new SRunResult();
		result.setOid(input.getOid());
		result.setRunOke(input.isRunOke());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		result.setOutput(input.getOutput());
		return result;
	}

	public RunResult convertFromSObject(SRunResult input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RunResult result = StoreFactory.eINSTANCE.createRunResult();
		result.setOid(input.getOid());
		result.setRunOke(input.isRunOke());
		result.getWarnings().addAll(input.getWarnings());
		result.getErrors().addAll(input.getErrors());
		result.setOutput(input.getOutput());
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

	public Set<ServerInfo> convertFromSSetServerInfo(Collection<SServerInfo> input, BimDatabaseSession session) {
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

	public List<ServerInfo> convertFromSListServerInfo(Collection<SServerInfo> input, BimDatabaseSession session) {
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
		result.setServerState(SServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ServerInfo result = StoreFactory.eINSTANCE.createServerInfo();
		result.setOid(input.getOid());
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

	public Set<Version> convertFromSSetVersion(Collection<SVersion> input, BimDatabaseSession session) {
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

	public List<Version> convertFromSListVersion(Collection<SVersion> input, BimDatabaseSession session) {
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
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}

	public Version convertFromSObject(SVersion input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Version result = StoreFactory.eINSTANCE.createVersion();
		result.setOid(input.getOid());
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}
}