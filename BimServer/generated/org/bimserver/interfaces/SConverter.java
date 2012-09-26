package org.bimserver.interfaces;

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
 *****************************************************************************/

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.interfaces.objects.*;
import java.util.*;
import org.bimserver.models.log.*;
import org.bimserver.models.store.*;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDatabaseException;

public class SConverter {
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
		return result;
	}

	public Project convertFromSObject(SProject input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Project result = StoreFactory.eINSTANCE.createProject();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, false, null));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, false, null));
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
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(SUserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
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
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
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
		return result;
	}

	public User convertFromSObject(SUser input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		User result = StoreFactory.eINSTANCE.createUser();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(UserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		List<Project> listhasRightsOn = result.getHasRightsOn();
		for (long oid : input.getHasRightsOn()) {
			listhasRightsOn.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false, null));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), false, null));
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		List<ExtendedDataSchema> listschemas = result.getSchemas();
		for (long oid : input.getSchemas()) {
			listschemas.add((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), oid, false, null));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, false, null));
		}
		List<Service> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((Service)session.get(StorePackage.eINSTANCE.getService(), oid, false, null));
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
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
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
		List<Long> listextendedData = new ArrayList<Long>();
		for (ExtendedData v : input.getExtendedData()) {
			listextendedData.add(v.getOid());
		}
		result.setExtendedData(listextendedData);
		return result;
	}

	public Revision convertFromSObject(SRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Revision result = StoreFactory.eINSTANCE.createRevision();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
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
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, false, null));
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
		result.setId(input.getId());
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
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ConcreteRevision result = StoreFactory.eINSTANCE.createConcreteRevision();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setId(input.getId());
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false, null));
		}
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
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
		if (input == null) {
			return null;
		}
		GeoTag result = StoreFactory.eINSTANCE.createGeoTag();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setEnabled(input.getEnabled());
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
		result.setDate(input.getDate());
		result.setActive(input.getActive());
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

	public Checkout convertFromSObject(SCheckout input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Checkout result = StoreFactory.eINSTANCE.createCheckout();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDate(input.getDate());
		result.setActive(input.getActive());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		result.setCheckin((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getCheckinId(), false, null));
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
		result.setShowVersionUpgradeAvailable(input.getShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.getUseCaching());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		List<Long> listschemas = new ArrayList<Long>();
		for (ExtendedDataSchema v : input.getSchemas()) {
			listschemas.add(v.getOid());
		}
		result.setSchemas(listschemas);
		return result;
	}

	public ServerSettings convertFromSObject(SServerSettings input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServerSettings result = StoreFactory.eINSTANCE.createServerSettings();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setShowVersionUpgradeAvailable(input.getShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.getUseCaching());
		result.setAllowSelfRegistration(input.getAllowSelfRegistration());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.getCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHideUserListForNonAdmin(input.getHideUserListForNonAdmin());
		result.setProtocolBuffersPort(input.getProtocolBuffersPort());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setCacheOutputFiles(input.getCacheOutputFiles());
		result.setServiceRepositoryUrl(input.getServiceRepositoryUrl());
		List<ExtendedDataSchema> listschemas = result.getSchemas();
		for (long oid : input.getSchemas()) {
			listschemas.add((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), oid, false, null));
		}
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
		List<Long> listdeserializers = new ArrayList<Long>();
		for (Deserializer v : input.getDeserializers()) {
			listdeserializers.add(v.getOid());
		}
		result.setDeserializers(listdeserializers);
		List<Long> listqueryengines = new ArrayList<Long>();
		for (QueryEngine v : input.getQueryengines()) {
			listqueryengines.add(v.getOid());
		}
		result.setQueryengines(listqueryengines);
		List<Long> listmodelmergers = new ArrayList<Long>();
		for (ModelMerger v : input.getModelmergers()) {
			listmodelmergers.add(v.getOid());
		}
		result.setModelmergers(listmodelmergers);
		List<Long> listmodelcompares = new ArrayList<Long>();
		for (ModelCompare v : input.getModelcompares()) {
			listmodelcompares.add(v.getOid());
		}
		result.setModelcompares(listmodelcompares);
		ModelMerger defaultModelMergerVal = input.getDefaultModelMerger();
		result.setDefaultModelMergerId(defaultModelMergerVal == null ? -1 : defaultModelMergerVal.getOid());
		ModelCompare defaultModelCompareVal = input.getDefaultModelCompare();
		result.setDefaultModelCompareId(defaultModelCompareVal == null ? -1 : defaultModelCompareVal.getOid());
		QueryEngine defaultQueryEngineVal = input.getDefaultQueryEngine();
		result.setDefaultQueryEngineId(defaultQueryEngineVal == null ? -1 : defaultQueryEngineVal.getOid());
		IfcEngine defaultIfcEngineVal = input.getDefaultIfcEngine();
		result.setDefaultIfcEngineId(defaultIfcEngineVal == null ? -1 : defaultIfcEngineVal.getOid());
		Serializer defaultSerializerVal = input.getDefaultSerializer();
		result.setDefaultSerializerId(defaultSerializerVal == null ? -1 : defaultSerializerVal.getOid());
		ObjectIDM defaultObjectIDMVal = input.getDefaultObjectIDM();
		result.setDefaultObjectIDMId(defaultObjectIDMVal == null ? -1 : defaultObjectIDMVal.getOid());
		List<Long> listservices = new ArrayList<Long>();
		for (EService v : input.getServices()) {
			listservices.add(v.getOid());
		}
		result.setServices(listservices);
		return result;
	}

	public UserSettings convertFromSObject(SUserSettings input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		UserSettings result = StoreFactory.eINSTANCE.createUserSettings();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		List<Deserializer> listdeserializers = result.getDeserializers();
		for (long oid : input.getDeserializers()) {
			listdeserializers.add((Deserializer)session.get(StorePackage.eINSTANCE.getDeserializer(), oid, false, null));
		}
		List<QueryEngine> listqueryengines = result.getQueryengines();
		for (long oid : input.getQueryengines()) {
			listqueryengines.add((QueryEngine)session.get(StorePackage.eINSTANCE.getQueryEngine(), oid, false, null));
		}
		List<ModelMerger> listmodelmergers = result.getModelmergers();
		for (long oid : input.getModelmergers()) {
			listmodelmergers.add((ModelMerger)session.get(StorePackage.eINSTANCE.getModelMerger(), oid, false, null));
		}
		List<ModelCompare> listmodelcompares = result.getModelcompares();
		for (long oid : input.getModelcompares()) {
			listmodelcompares.add((ModelCompare)session.get(StorePackage.eINSTANCE.getModelCompare(), oid, false, null));
		}
		result.setDefaultModelMerger((ModelMerger)session.get(StorePackage.eINSTANCE.getModelMerger(), input.getDefaultModelMergerId(), false, null));
		result.setDefaultModelCompare((ModelCompare)session.get(StorePackage.eINSTANCE.getModelCompare(), input.getDefaultModelCompareId(), false, null));
		result.setDefaultQueryEngine((QueryEngine)session.get(StorePackage.eINSTANCE.getQueryEngine(), input.getDefaultQueryEngineId(), false, null));
		result.setDefaultIfcEngine((IfcEngine)session.get(StorePackage.eINSTANCE.getIfcEngine(), input.getDefaultIfcEngineId(), false, null));
		result.setDefaultSerializer((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), input.getDefaultSerializerId(), false, null));
		result.setDefaultObjectIDM((ObjectIDM)session.get(StorePackage.eINSTANCE.getObjectIDM(), input.getDefaultObjectIDMId(), false, null));
		List<EService> listservices = result.getServices();
		for (long oid : input.getServices()) {
			listservices.add((EService)session.get(StorePackage.eINSTANCE.getEService(), oid, false, null));
		}
		return result;
	}

	public Set<SPlugin> convertToSSetPlugin(Collection<Plugin> input) {
		Set<SPlugin> result = new HashSet<SPlugin>();
		for (Plugin o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Plugin> convertFromSSetPlugin(Collection<SPlugin> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<Plugin> convertFromSListPlugin(Collection<SPlugin> input, DatabaseSession session) throws BimserverDatabaseException {
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
		
		if (input instanceof QueryEngine) {
			return convertToSObject((QueryEngine)input);
		}
		else if (input instanceof EService) {
			return convertToSObject((EService)input);
		}
		else if (input instanceof ModelCompare) {
			return convertToSObject((ModelCompare)input);
		}
		else if (input instanceof Deserializer) {
			return convertToSObject((Deserializer)input);
		}
		else if (input instanceof ObjectIDM) {
			return convertToSObject((ObjectIDM)input);
		}
		else if (input instanceof Serializer) {
			return convertToSObject((Serializer)input);
		}
		else if (input instanceof IfcEngine) {
			return convertToSObject((IfcEngine)input);
		}
		else if (input instanceof ModelMerger) {
			return convertToSObject((ModelMerger)input);
		}
		SPlugin result = new SPlugin();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		return result;
	}

	public Plugin convertFromSObject(SPlugin input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Plugin result = StoreFactory.eINSTANCE.createPlugin();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		return result;
	}

	public Set<SSerializer> convertToSSetSerializer(Collection<Serializer> input) {
		Set<SSerializer> result = new HashSet<SSerializer>();
		for (Serializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Serializer> convertFromSSetSerializer(Collection<SSerializer> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<Serializer> convertFromSListSerializer(Collection<SSerializer> input, DatabaseSession session) throws BimserverDatabaseException {
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
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		ObjectIDM objectIDMVal = input.getObjectIDM();
		result.setObjectIDMId(objectIDMVal == null ? -1 : objectIDMVal.getOid());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		IfcEngine ifcEngineVal = input.getIfcEngine();
		result.setIfcEngineId(ifcEngineVal == null ? -1 : ifcEngineVal.getOid());
		return result;
	}

	public Serializer convertFromSObject(SSerializer input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Serializer result = StoreFactory.eINSTANCE.createSerializer();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		result.setObjectIDM((ObjectIDM)session.get(StorePackage.eINSTANCE.getObjectIDM(), input.getObjectIDMId(), false, null));
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		result.setIfcEngine((IfcEngine)session.get(StorePackage.eINSTANCE.getIfcEngine(), input.getIfcEngineId(), false, null));
		return result;
	}

	public Set<SObjectIDM> convertToSSetObjectIDM(Collection<ObjectIDM> input) {
		Set<SObjectIDM> result = new HashSet<SObjectIDM>();
		for (ObjectIDM o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ObjectIDM> convertFromSSetObjectIDM(Collection<SObjectIDM> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<ObjectIDM> convertFromSListObjectIDM(Collection<SObjectIDM> input, DatabaseSession session) throws BimserverDatabaseException {
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
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public ObjectIDM convertFromSObject(SObjectIDM input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ObjectIDM result = StoreFactory.eINSTANCE.createObjectIDM();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false, null));
		}
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SIfcEngine> convertToSSetIfcEngine(Collection<IfcEngine> input) {
		Set<SIfcEngine> result = new HashSet<SIfcEngine>();
		for (IfcEngine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<IfcEngine> convertFromSSetIfcEngine(Collection<SIfcEngine> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<IfcEngine> convertFromSListIfcEngine(Collection<SIfcEngine> input, DatabaseSession session) throws BimserverDatabaseException {
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
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public IfcEngine convertFromSObject(SIfcEngine input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		IfcEngine result = StoreFactory.eINSTANCE.createIfcEngine();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false, null));
		}
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SDeserializer> convertToSSetDeserializer(Collection<Deserializer> input) {
		Set<SDeserializer> result = new HashSet<SDeserializer>();
		for (Deserializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Deserializer> convertFromSSetDeserializer(Collection<SDeserializer> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<Deserializer> convertFromSListDeserializer(Collection<SDeserializer> input, DatabaseSession session) throws BimserverDatabaseException {
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
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Deserializer convertFromSObject(SDeserializer input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Deserializer result = StoreFactory.eINSTANCE.createDeserializer();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		return result;
	}

	public Set<SCheckinResult> convertToSSetCheckinResult(Collection<CheckinResult> input) {
		Set<SCheckinResult> result = new HashSet<SCheckinResult>();
		for (CheckinResult o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<CheckinResult> convertFromSSetCheckinResult(Collection<SCheckinResult> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<CheckinResult> convertFromSListCheckinResult(Collection<SCheckinResult> input, DatabaseSession session) throws BimserverDatabaseException {
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
		result.setLastError(input.getLastError());
		result.setStatus(SCheckinStatus.values()[input.getStatus().ordinal()]);
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public CheckinResult convertFromSObject(SCheckinResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		CheckinResult result = StoreFactory.eINSTANCE.createCheckinResult();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setProgress(input.getProgress());
		result.setLastError(input.getLastError());
		result.setStatus(CheckinStatus.values()[input.getStatus().ordinal()]);
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
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
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public DownloadResult convertFromSObject(SDownloadResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DownloadResult result = StoreFactory.eINSTANCE.createDownloadResult();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setProjectName(input.getProjectName());
		result.setRevisionNr(input.getRevisionNr());
		result.setFile(input.getFile());
		return result;
	}

	public CheckoutResult convertFromSObject(SCheckoutResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		CheckoutResult result = StoreFactory.eINSTANCE.createCheckoutResult();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		
		if (input instanceof ListDataValue) {
			return convertToSObject((ListDataValue)input);
		}
		else if (input instanceof ReferenceDataValue) {
			return convertToSObject((ReferenceDataValue)input);
		}
		else if (input instanceof SimpleDataValue) {
			return convertToSObject((SimpleDataValue)input);
		}
		SDataValue result = new SDataValue();
		result.setOid(input.getOid());
		result.setFieldName(input.getFieldName());
		return result;
	}

	public DataValue convertFromSObject(SDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DataValue result = StoreFactory.eINSTANCE.createDataValue();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		DataObject result = StoreFactory.eINSTANCE.createDataObject();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		UserSession result = StoreFactory.eINSTANCE.createUserSession();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setNumber(input.getNumber());
		result.setDescription(input.getDescription());
		result.setExecuted(input.getExecuted());
		return result;
	}

	public Migration convertFromSObject(SMigration input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Migration result = StoreFactory.eINSTANCE.createMigration();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setFieldName(input.getFieldName());
		result.setTypeName(input.getTypeName());
		result.setGuid(input.getGuid());
		return result;
	}

	public ReferenceDataValue convertFromSObject(SReferenceDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ReferenceDataValue result = StoreFactory.eINSTANCE.createReferenceDataValue();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setFieldName(input.getFieldName());
		List<SDataValue> listvalues = new ArrayList<SDataValue>();
		for (DataValue v : input.getValues()) {
			listvalues.add(convertToSObject(v));
		}
		result.setValues(listvalues);
		return result;
	}

	public ListDataValue convertFromSObject(SListDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ListDataValue result = StoreFactory.eINSTANCE.createListDataValue();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setFieldName(input.getFieldName());
		result.setStringValue(input.getStringValue());
		return result;
	}

	public SimpleDataValue convertFromSObject(SSimpleDataValue input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		SimpleDataValue result = StoreFactory.eINSTANCE.createSimpleDataValue();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setKey(input.getKey());
		result.setValue(input.getValue());
		return result;
	}

	public DatabaseInformationItem convertFromSObject(SDatabaseInformationItem input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DatabaseInformationItem result = StoreFactory.eINSTANCE.createDatabaseInformationItem();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setTitle(input.getTitle());
		List<SDatabaseInformationItem> listitems = new ArrayList<SDatabaseInformationItem>();
		for (DatabaseInformationItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public DatabaseInformationCategory convertFromSObject(SDatabaseInformationCategory input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DatabaseInformationCategory result = StoreFactory.eINSTANCE.createDatabaseInformationCategory();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		DatabaseInformation result = StoreFactory.eINSTANCE.createDatabaseInformation();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		
		if (input instanceof SerializerPluginDescriptor) {
			return convertToSObject((SerializerPluginDescriptor)input);
		}
		else if (input instanceof ModelComparePluginDescriptor) {
			return convertToSObject((ModelComparePluginDescriptor)input);
		}
		else if (input instanceof ModelMergerPluginDescriptor) {
			return convertToSObject((ModelMergerPluginDescriptor)input);
		}
		else if (input instanceof DeserializerPluginDescriptor) {
			return convertToSObject((DeserializerPluginDescriptor)input);
		}
		else if (input instanceof QueryEnginePluginDescriptor) {
			return convertToSObject((QueryEnginePluginDescriptor)input);
		}
		else if (input instanceof ServicePluginDescriptor) {
			return convertToSObject((ServicePluginDescriptor)input);
		}
		else if (input instanceof IfcEnginePluginDescriptor) {
			return convertToSObject((IfcEnginePluginDescriptor)input);
		}
		SPluginDescriptor result = new SPluginDescriptor();
		result.setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public PluginDescriptor convertFromSObject(SPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		PluginDescriptor result = StoreFactory.eINSTANCE.createPluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		result.setDefaultExtension(input.getDefaultExtension());
		result.setDefaultContentType(input.getDefaultContentType());
		return result;
	}

	public SerializerPluginDescriptor convertFromSObject(SSerializerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		SerializerPluginDescriptor result = StoreFactory.eINSTANCE.createSerializerPluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public DeserializerPluginDescriptor convertFromSObject(SDeserializerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DeserializerPluginDescriptor result = StoreFactory.eINSTANCE.createDeserializerPluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setName(input.getName());
		result.setCount(input.getCount());
		return result;
	}

	public RevisionSummaryType convertFromSObject(SRevisionSummaryType input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		RevisionSummaryType result = StoreFactory.eINSTANCE.createRevisionSummaryType();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setName(input.getName());
		List<SRevisionSummaryType> listtypes = new ArrayList<SRevisionSummaryType>();
		for (RevisionSummaryType v : input.getTypes()) {
			listtypes.add(convertToSObject(v));
		}
		result.setTypes(listtypes);
		return result;
	}

	public RevisionSummaryContainer convertFromSObject(SRevisionSummaryContainer input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		RevisionSummaryContainer result = StoreFactory.eINSTANCE.createRevisionSummaryContainer();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		List<SRevisionSummaryContainer> listlist = new ArrayList<SRevisionSummaryContainer>();
		for (RevisionSummaryContainer v : input.getList()) {
			listlist.add(convertToSObject(v));
		}
		result.setList(listlist);
		return result;
	}

	public RevisionSummary convertFromSObject(SRevisionSummary input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		RevisionSummary result = StoreFactory.eINSTANCE.createRevisionSummary();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		
		if (input instanceof LongCheckinAction) {
			return convertToSObject((LongCheckinAction)input);
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

	public LongAction convertFromSObject(SLongAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		LongAction result = StoreFactory.eINSTANCE.createLongAction();
		((IdEObjectImpl)result).setOid(input.getOid());
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

	public Set<LongCheckinAction> convertFromSSetLongCheckinAction(Collection<SLongCheckinAction> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<LongCheckinAction> convertFromSListLongCheckinAction(Collection<SLongCheckinAction> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public LongCheckinAction convertFromSObject(SLongCheckinAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		LongCheckinAction result = StoreFactory.eINSTANCE.createLongCheckinAction();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setClassName(input.getClassName());
		return result;
	}

	public ObjectIDMPluginDescriptor convertFromSObject(SObjectIDMPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ObjectIDMPluginDescriptor result = StoreFactory.eINSTANCE.createObjectIDMPluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		
		if (input instanceof ObjectModified) {
			return convertToSObject((ObjectModified)input);
		}
		else if (input instanceof ObjectRemoved) {
			return convertToSObject((ObjectRemoved)input);
		}
		else if (input instanceof ObjectAdded) {
			return convertToSObject((ObjectAdded)input);
		}
		SCompareItem result = new SCompareItem();
		result.setOid(input.getOid());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public CompareItem convertFromSObject(SCompareItem input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		CompareItem result = StoreFactory.eINSTANCE.createCompareItem();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectAdded convertFromSObject(SObjectAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ObjectAdded result = StoreFactory.eINSTANCE.createObjectAdded();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectRemoved convertFromSObject(SObjectRemoved input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ObjectRemoved result = StoreFactory.eINSTANCE.createObjectRemoved();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setFieldName(input.getFieldName());
		result.setOldValue(input.getOldValue());
		result.setNewValue(input.getNewValue());
		DataObject dataObjectVal = input.getDataObject();
		result.setDataObject(convertToSObject(dataObjectVal));
		return result;
	}

	public ObjectModified convertFromSObject(SObjectModified input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ObjectModified result = StoreFactory.eINSTANCE.createObjectModified();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setType(input.getType());
		List<SCompareItem> listitems = new ArrayList<SCompareItem>();
		for (CompareItem v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareContainer convertFromSObject(SCompareContainer input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		CompareContainer result = StoreFactory.eINSTANCE.createCompareContainer();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		List<SCompareContainer> listitems = new ArrayList<SCompareContainer>();
		for (CompareContainer v : input.getItems()) {
			listitems.add(convertToSObject(v));
		}
		result.setItems(listitems);
		return result;
	}

	public CompareResult convertFromSObject(SCompareResult input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		CompareResult result = StoreFactory.eINSTANCE.createCompareResult();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setProgress(input.getProgress());
		result.setState(SActionState.values()[input.getState().ordinal()]);
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		return result;
	}

	public LongActionState convertFromSObject(SLongActionState input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		LongActionState result = StoreFactory.eINSTANCE.createLongActionState();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setProgress(input.getProgress());
		result.setState(ActionState.values()[input.getState().ordinal()]);
		result.getErrors().addAll(input.getErrors());
		result.getWarnings().addAll(input.getWarnings());
		result.getInfos().addAll(input.getInfos());
		return result;
	}

	public Set<SNotification> convertToSSetNotification(Collection<Notification> input) {
		Set<SNotification> result = new HashSet<SNotification>();
		for (Notification o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Notification> convertFromSSetNotification(Collection<SNotification> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<Notification> result = new HashSet<Notification>();
		for (SNotification o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNotification> convertToSListNotification(Collection<Notification> input) {
		List<SNotification> result = new ArrayList<SNotification>();
		for (Notification o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Notification> convertFromSListNotification(Collection<SNotification> input, DatabaseSession session) throws BimserverDatabaseException {
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
		
		if (input instanceof NewRevisionNotification) {
			return convertToSObject((NewRevisionNotification)input);
		}
		else if (input instanceof NewProjectNotification) {
			return convertToSObject((NewProjectNotification)input);
		}
		SNotification result = new SNotification();
		result.setOid(input.getOid());
		return result;
	}

	public Notification convertFromSObject(SNotification input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Notification result = StoreFactory.eINSTANCE.createNotification();
		((IdEObjectImpl)result).setOid(input.getOid());
		return result;
	}

	public Set<SNewProjectNotification> convertToSSetNewProjectNotification(Collection<NewProjectNotification> input) {
		Set<SNewProjectNotification> result = new HashSet<SNewProjectNotification>();
		for (NewProjectNotification o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectNotification> convertFromSSetNewProjectNotification(Collection<SNewProjectNotification> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<NewProjectNotification> convertFromSListNewProjectNotification(Collection<SNewProjectNotification> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public NewProjectNotification convertFromSObject(SNewProjectNotification input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewProjectNotification result = StoreFactory.eINSTANCE.createNewProjectNotification();
		((IdEObjectImpl)result).setOid(input.getOid());
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

	public Set<NewRevisionNotification> convertFromSSetNewRevisionNotification(Collection<SNewRevisionNotification> input, DatabaseSession session) throws BimserverDatabaseException {
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

	public List<NewRevisionNotification> convertFromSListNewRevisionNotification(Collection<SNewRevisionNotification> input, DatabaseSession session) throws BimserverDatabaseException {
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
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public NewRevisionNotification convertFromSObject(SNewRevisionNotification input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewRevisionNotification result = StoreFactory.eINSTANCE.createNewRevisionNotification();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
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
		result.setServerState(SServerState.values()[input.getServerState().ordinal()]);
		result.setErrorMessage(input.getErrorMessage());
		return result;
	}

	public ServerInfo convertFromSObject(SServerInfo input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServerInfo result = StoreFactory.eINSTANCE.createServerInfo();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		Version result = StoreFactory.eINSTANCE.createVersion();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setMajor(input.getMajor());
		result.setMinor(input.getMinor());
		result.setRevision(input.getRevision());
		result.setDate(input.getDate());
		result.setDownloadUrl(input.getDownloadUrl());
		result.setSupportUrl(input.getSupportUrl());
		result.setSupportEmail(input.getSupportEmail());
		return result;
	}

	public Set<SIfcEnginePluginDescriptor> convertToSSetIfcEnginePluginDescriptor(Collection<IfcEnginePluginDescriptor> input) {
		Set<SIfcEnginePluginDescriptor> result = new HashSet<SIfcEnginePluginDescriptor>();
		for (IfcEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<IfcEnginePluginDescriptor> convertFromSSetIfcEnginePluginDescriptor(Collection<SIfcEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<IfcEnginePluginDescriptor> result = new HashSet<IfcEnginePluginDescriptor>();
		for (SIfcEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SIfcEnginePluginDescriptor> convertToSListIfcEnginePluginDescriptor(Collection<IfcEnginePluginDescriptor> input) {
		List<SIfcEnginePluginDescriptor> result = new ArrayList<SIfcEnginePluginDescriptor>();
		for (IfcEnginePluginDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<IfcEnginePluginDescriptor> convertFromSListIfcEnginePluginDescriptor(Collection<SIfcEnginePluginDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<IfcEnginePluginDescriptor> result = new ArrayList<IfcEnginePluginDescriptor>();
		for (SIfcEnginePluginDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SIfcEnginePluginDescriptor convertToSObject(IfcEnginePluginDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SIfcEnginePluginDescriptor result = new SIfcEnginePluginDescriptor();
		result.setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public IfcEnginePluginDescriptor convertFromSObject(SIfcEnginePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		IfcEnginePluginDescriptor result = StoreFactory.eINSTANCE.createIfcEnginePluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}
		public SCheckinStatus convertToSObject(CheckinStatus input) {
			return SCheckinStatus.values()[input.ordinal()];
		}
		
		public CheckinStatus convertFromSObject(SCheckinStatus input) {
			return CheckinStatus.values()[input.ordinal()];
		}
		public SExtendedDataSchemaType convertToSObject(ExtendedDataSchemaType input) {
			return SExtendedDataSchemaType.values()[input.ordinal()];
		}
		
		public ExtendedDataSchemaType convertFromSObject(SExtendedDataSchemaType input) {
			return ExtendedDataSchemaType.values()[input.ordinal()];
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
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setNamespace(input.getNamespace());
		result.setData(input.getData());
		result.setValidate(input.isValidate());
		result.setType(SExtendedDataSchemaType.values()[input.getType().ordinal()]);
		ServerSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
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
		if (input == null) {
			return null;
		}
		ExtendedDataSchema result = StoreFactory.eINSTANCE.createExtendedDataSchema();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setNamespace(input.getNamespace());
		result.setData(input.getData());
		result.setValidate(input.isValidate());
		result.setType(ExtendedDataSchemaType.values()[input.getType().ordinal()]);
		result.setSettings((ServerSettings)session.get(StorePackage.eINSTANCE.getServerSettings(), input.getSettingsId(), false, null));
		List<User> listusers = result.getUsers();
		for (long oid : input.getUsers()) {
			listusers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, false, null));
		}
		List<ExtendedData> listextendedData = result.getExtendedData();
		for (long oid : input.getExtendedData()) {
			listextendedData.add((ExtendedData)session.get(StorePackage.eINSTANCE.getExtendedData(), oid, false, null));
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
		result.setUrl(input.getUrl());
		result.setData(input.getData());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		result.setMime(input.getMime());
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
		if (input == null) {
			return null;
		}
		ExtendedData result = StoreFactory.eINSTANCE.createExtendedData();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setUrl(input.getUrl());
		result.setData(input.getData());
		result.setTitle(input.getTitle());
		result.setAdded(input.getAdded());
		result.setMime(input.getMime());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		result.setSchema((ExtendedDataSchema)session.get(StorePackage.eINSTANCE.getExtendedDataSchema(), input.getSchemaId(), false, null));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public QueryEnginePluginDescriptor convertFromSObject(SQueryEnginePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		QueryEnginePluginDescriptor result = StoreFactory.eINSTANCE.createQueryEnginePluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SQueryEngine> convertToSSetQueryEngine(Collection<QueryEngine> input) {
		Set<SQueryEngine> result = new HashSet<SQueryEngine>();
		for (QueryEngine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<QueryEngine> convertFromSSetQueryEngine(Collection<SQueryEngine> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<QueryEngine> result = new HashSet<QueryEngine>();
		for (SQueryEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SQueryEngine> convertToSListQueryEngine(Collection<QueryEngine> input) {
		List<SQueryEngine> result = new ArrayList<SQueryEngine>();
		for (QueryEngine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<QueryEngine> convertFromSListQueryEngine(Collection<SQueryEngine> input, DatabaseSession session) throws BimserverDatabaseException {
		List<QueryEngine> result = new ArrayList<QueryEngine>();
		for (SQueryEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SQueryEngine convertToSObject(QueryEngine input) {
		if (input == null) {
			return null;
		}
		
		SQueryEngine result = new SQueryEngine();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public QueryEngine convertFromSObject(SQueryEngine input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		QueryEngine result = StoreFactory.eINSTANCE.createQueryEngine();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public ModelMergerPluginDescriptor convertFromSObject(SModelMergerPluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ModelMergerPluginDescriptor result = StoreFactory.eINSTANCE.createModelMergerPluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SModelMerger> convertToSSetModelMerger(Collection<ModelMerger> input) {
		Set<SModelMerger> result = new HashSet<SModelMerger>();
		for (ModelMerger o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelMerger> convertFromSSetModelMerger(Collection<SModelMerger> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelMerger> result = new HashSet<ModelMerger>();
		for (SModelMerger o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelMerger> convertToSListModelMerger(Collection<ModelMerger> input) {
		List<SModelMerger> result = new ArrayList<SModelMerger>();
		for (ModelMerger o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelMerger> convertFromSListModelMerger(Collection<SModelMerger> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelMerger> result = new ArrayList<ModelMerger>();
		for (SModelMerger o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelMerger convertToSObject(ModelMerger input) {
		if (input == null) {
			return null;
		}
		
		SModelMerger result = new SModelMerger();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public ModelMerger convertFromSObject(SModelMerger input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ModelMerger result = StoreFactory.eINSTANCE.createModelMerger();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public ModelComparePluginDescriptor convertFromSObject(SModelComparePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ModelComparePluginDescriptor result = StoreFactory.eINSTANCE.createModelComparePluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SModelCompare> convertToSSetModelCompare(Collection<ModelCompare> input) {
		Set<SModelCompare> result = new HashSet<SModelCompare>();
		for (ModelCompare o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ModelCompare> convertFromSSetModelCompare(Collection<SModelCompare> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ModelCompare> result = new HashSet<ModelCompare>();
		for (SModelCompare o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SModelCompare> convertToSListModelCompare(Collection<ModelCompare> input) {
		List<SModelCompare> result = new ArrayList<SModelCompare>();
		for (ModelCompare o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ModelCompare> convertFromSListModelCompare(Collection<SModelCompare> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ModelCompare> result = new ArrayList<ModelCompare>();
		for (SModelCompare o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SModelCompare convertToSObject(ModelCompare input) {
		if (input == null) {
			return null;
		}
		
		SModelCompare result = new SModelCompare();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public ModelCompare convertFromSObject(SModelCompare input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ModelCompare result = StoreFactory.eINSTANCE.createModelCompare();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
		return result;
	}
		public STrigger convertToSObject(Trigger input) {
			return STrigger.values()[input.ordinal()];
		}
		
		public Trigger convertFromSObject(STrigger input) {
			return Trigger.values()[input.ordinal()];
		}

	public Set<SServerDescriptor> convertToSSetServerDescriptor(Collection<ServerDescriptor> input) {
		Set<SServerDescriptor> result = new HashSet<SServerDescriptor>();
		for (ServerDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerDescriptor> convertFromSSetServerDescriptor(Collection<SServerDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<ServerDescriptor> result = new HashSet<ServerDescriptor>();
		for (SServerDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerDescriptor> convertToSListServerDescriptor(Collection<ServerDescriptor> input) {
		List<SServerDescriptor> result = new ArrayList<SServerDescriptor>();
		for (ServerDescriptor o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerDescriptor> convertFromSListServerDescriptor(Collection<SServerDescriptor> input, DatabaseSession session) throws BimserverDatabaseException {
		List<ServerDescriptor> result = new ArrayList<ServerDescriptor>();
		for (SServerDescriptor o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerDescriptor convertToSObject(ServerDescriptor input) {
		if (input == null) {
			return null;
		}
		
		SServerDescriptor result = new SServerDescriptor();
		result.setTitle(input.getTitle());
		result.setUrl(input.getUrl());
		result.setDescription(input.getDescription());
		return result;
	}

	public ServerDescriptor convertFromSObject(SServerDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServerDescriptor result = StoreFactory.eINSTANCE.createServerDescriptor();
		result.setTitle(input.getTitle());
		result.setUrl(input.getUrl());
		result.setDescription(input.getDescription());
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
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.isReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.isWriteExtendedData());
		return result;
	}

	public ServiceDescriptor convertFromSObject(SServiceDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServiceDescriptor result = StoreFactory.eINSTANCE.createServiceDescriptor();
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision(input.isReadRevision());
		result.setReadExtendedData(input.isReadExtendedData());
		result.setWriteRevision(input.isWriteRevision());
		result.setWriteExtendedData(input.isWriteExtendedData());
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
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(SAccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(STrigger.values()[input.getTrigger().ordinal()]);
		Revision readRevisionVal = input.getReadRevision();
		result.setReadRevisionId(readRevisionVal == null ? -1 : readRevisionVal.getOid());
		Revision readExtendedDataVal = input.getReadExtendedData();
		result.setReadExtendedDataId(readExtendedDataVal == null ? -1 : readExtendedDataVal.getOid());
		Project writeRevisionVal = input.getWriteRevision();
		result.setWriteRevisionId(writeRevisionVal == null ? -1 : writeRevisionVal.getOid());
		Revision writeExtendedDataVal = input.getWriteExtendedData();
		result.setWriteExtendedDataId(writeExtendedDataVal == null ? -1 : writeExtendedDataVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public Service convertFromSObject(SService input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Service result = StoreFactory.eINSTANCE.createService();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setUrl(input.getUrl());
		result.setToken(input.getToken());
		result.setNotificationProtocol(AccessMethod.values()[input.getNotificationProtocol().ordinal()]);
		result.setDescription(input.getDescription());
		result.setTrigger(Trigger.values()[input.getTrigger().ordinal()]);
		result.setReadRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getReadRevisionId(), false, null));
		result.setReadExtendedData((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getReadExtendedDataId(), false, null));
		result.setWriteRevision((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getWriteRevisionId(), false, null));
		result.setWriteExtendedData((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getWriteExtendedDataId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
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
		result.setTokenString(input.getTokenString());
		result.setExpires(input.getExpires());
		return result;
	}

	public Token convertFromSObject(SToken input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Token result = StoreFactory.eINSTANCE.createToken();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public ServicePluginDescriptor convertFromSObject(SServicePluginDescriptor input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServicePluginDescriptor result = StoreFactory.eINSTANCE.createServicePluginDescriptor();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDefaultName(input.getDefaultName());
		result.setPluginClassName(input.getPluginClassName());
		result.setDescription(input.getDescription());
		result.setLocation(input.getLocation());
		result.setEnabled(input.getEnabled());
		return result;
	}

	public Set<SEService> convertToSSetEService(Collection<EService> input) {
		Set<SEService> result = new HashSet<SEService>();
		for (EService o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<EService> convertFromSSetEService(Collection<SEService> input, DatabaseSession session) throws BimserverDatabaseException {
		Set<EService> result = new HashSet<EService>();
		for (SEService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SEService> convertToSListEService(Collection<EService> input) {
		List<SEService> result = new ArrayList<SEService>();
		for (EService o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<EService> convertFromSListEService(Collection<SEService> input, DatabaseSession session) throws BimserverDatabaseException {
		List<EService> result = new ArrayList<EService>();
		for (SEService o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SEService convertToSObject(EService input) {
		if (input == null) {
			return null;
		}
		
		SEService result = new SEService();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		UserSettings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public EService convertFromSObject(SEService input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		EService result = StoreFactory.eINSTANCE.createEService();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.getEnabled());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setSettings((UserSettings)session.get(StorePackage.eINSTANCE.getUserSettings(), input.getSettingsId(), false, null));
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
		return result;
	}

	public ServiceInterface convertFromSObject(SServiceInterface input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServiceInterface result = StoreFactory.eINSTANCE.createServiceInterface();
		result.setName(input.getName());
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
		if (input == null) {
			return null;
		}
		ServiceMethod result = StoreFactory.eINSTANCE.createServiceMethod();
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
		if (input == null) {
			return null;
		}
		ServiceField result = StoreFactory.eINSTANCE.createServiceField();
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
		if (input == null) {
			return null;
		}
		ServiceType result = StoreFactory.eINSTANCE.createServiceType();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		ServiceParameter result = StoreFactory.eINSTANCE.createServiceParameter();
		result.setName(input.getName());
		result.setDoc(input.getDoc());
		result.setType(convertFromSObject(input.getType(), session));
		result.setGenericType(convertFromSObject(input.getGenericType(), session));
		return result;
	}
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
		
		if (input instanceof UserChanged) {
			return convertToSObject((UserChanged)input);
		}
		else if (input instanceof ServerStarted) {
			return convertToSObject((ServerStarted)input);
		}
		else if (input instanceof RevisionBranched) {
			return convertToSObject((RevisionBranched)input);
		}
		else if (input instanceof PasswordChanged) {
			return convertToSObject((PasswordChanged)input);
		}
		else if (input instanceof ProjectUndeleted) {
			return convertToSObject((ProjectUndeleted)input);
		}
		else if (input instanceof PasswordReset) {
			return convertToSObject((PasswordReset)input);
		}
		else if (input instanceof UserAddedToProject) {
			return convertToSObject((UserAddedToProject)input);
		}
		else if (input instanceof UserDeleted) {
			return convertToSObject((UserDeleted)input);
		}
		else if (input instanceof NewRevisionAdded) {
			return convertToSObject((NewRevisionAdded)input);
		}
		else if (input instanceof NewObjectIDMUploaded) {
			return convertToSObject((NewObjectIDMUploaded)input);
		}
		else if (input instanceof NewUserAdded) {
			return convertToSObject((NewUserAdded)input);
		}
		else if (input instanceof SettingsSaved) {
			return convertToSObject((SettingsSaved)input);
		}
		else if (input instanceof RevisionUpdated) {
			return convertToSObject((RevisionUpdated)input);
		}
		else if (input instanceof GeoTagUpdated) {
			return convertToSObject((GeoTagUpdated)input);
		}
		else if (input instanceof ProjectUpdated) {
			return convertToSObject((ProjectUpdated)input);
		}
		else if (input instanceof ProjectDeleted) {
			return convertToSObject((ProjectDeleted)input);
		}
		else if (input instanceof NewProjectAdded) {
			return convertToSObject((NewProjectAdded)input);
		}
		else if (input instanceof UserRemovedFromProject) {
			return convertToSObject((UserRemovedFromProject)input);
		}
		else if (input instanceof Download) {
			return convertToSObject((Download)input);
		}
		else if (input instanceof DatabaseCreated) {
			return convertToSObject((DatabaseCreated)input);
		}
		else if (input instanceof UserUndeleted) {
			return convertToSObject((UserUndeleted)input);
		}
		else if (input instanceof NewCheckoutAdded) {
			return convertToSObject((NewCheckoutAdded)input);
		}
		SLogAction result = new SLogAction();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		LogAction result = LogFactory.eINSTANCE.createLogAction();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		List<Long> listactions = new ArrayList<Long>();
		for (LogAction v : input.getActions()) {
			listactions.add(v.getOid());
		}
		result.setActions(listactions);
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServerLog result = LogFactory.eINSTANCE.createServerLog();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewUserAdded result = LogFactory.eINSTANCE.createNewUserAdded();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		NewProjectAdded result = LogFactory.eINSTANCE.createNewProjectAdded();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false, null));
		result.setParentProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentProjectId(), false, null));
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
		if (input == null) {
			return null;
		}
		RevisionBranched result = LogFactory.eINSTANCE.createRevisionBranched();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setOldrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getOldrevisionId(), false, null));
		result.setNewrevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getNewrevisionId(), false, null));
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewRevisionAdded result = LogFactory.eINSTANCE.createNewRevisionAdded();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewCheckoutAdded result = LogFactory.eINSTANCE.createNewCheckoutAdded();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		SettingsSaved result = LogFactory.eINSTANCE.createSettingsSaved();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		UserAddedToProject result = LogFactory.eINSTANCE.createUserAddedToProject();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public NewObjectIDMUploaded convertFromSObject(SNewObjectIDMUploaded input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		NewObjectIDMUploaded result = LogFactory.eINSTANCE.createNewObjectIDMUploaded();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public Download convertFromSObject(SDownload input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		Download result = LogFactory.eINSTANCE.createDownload();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		if (input == null) {
			return null;
		}
		UserRemovedFromProject result = LogFactory.eINSTANCE.createUserRemovedFromProject();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ProjectDeleted result = LogFactory.eINSTANCE.createProjectDeleted();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		UserDeleted result = LogFactory.eINSTANCE.createUserDeleted();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		PasswordReset result = LogFactory.eINSTANCE.createPasswordReset();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		DatabaseCreated result = LogFactory.eINSTANCE.createDatabaseCreated();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ServerStarted result = LogFactory.eINSTANCE.createServerStarted();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ProjectUpdated result = LogFactory.eINSTANCE.createProjectUpdated();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		UserUndeleted result = LogFactory.eINSTANCE.createUserUndeleted();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		ProjectUndeleted result = LogFactory.eINSTANCE.createProjectUndeleted();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		RevisionUpdated result = LogFactory.eINSTANCE.createRevisionUpdated();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		GeoTagUpdated result = LogFactory.eINSTANCE.createGeoTagUpdated();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), false, null));
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		PasswordChanged result = LogFactory.eINSTANCE.createPasswordChanged();
		((IdEObjectImpl)result).setOid(input.getOid());
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
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, DatabaseSession session) throws BimserverDatabaseException {
		if (input == null) {
			return null;
		}
		UserChanged result = LogFactory.eINSTANCE.createUserChanged();
		((IdEObjectImpl)result).setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false, null));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false, null));
		return result;
	}
}