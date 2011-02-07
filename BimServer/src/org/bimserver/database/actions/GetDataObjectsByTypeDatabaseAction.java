package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.merging.Merger;
import org.bimserver.settings.ServerSettings;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsByTypeDatabaseAction extends BimDatabaseAction<List<SDataObject>> {

	private final String className;
	private final long roid;

	public GetDataObjectsByTypeDatabaseAction(AccessMethod accessMethod, long roid, String className) {
		super(accessMethod);
		this.roid = roid;
		this.className = className;
	}

	@Override
	public List<SDataObject> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(className);
		Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = bimDatabaseSession.getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId());
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModel ifcModel = new Merger().merge(virtualRevision.getProject(), ifcModelSet, ServerSettings.getSettings().isIntelligentMerging());
		List<SDataObject> dataObjects = new ArrayList<SDataObject>();
		for (Long oid : ifcModel.keySet()) {
			EObject eObject = ifcModel.get(oid);
			if (eClass.isInstance(eObject)) {
				SDataObject dataObject = null;
				if (eObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot)eObject;
					String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
					String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
					dataObject = new SDataObject(eObject.eClass().getName(), oid, guid, name);
				} else {
					dataObject = new SDataObject(eObject.eClass().getName(), oid, "", "");
				}
				GetDataObjectByOidDatabaseAction.fillDataObject(ifcModel.getMap(), eObject, dataObject);
				dataObjects.add(dataObject);
			}
		}
		return dataObjects;
	}
}