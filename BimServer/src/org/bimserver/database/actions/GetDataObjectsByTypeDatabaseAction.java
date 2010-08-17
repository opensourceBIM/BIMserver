package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.shared.DataObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsByTypeDatabaseAction extends BimDatabaseAction<List<DataObject>> {

	private final String className;
	private final long roid;

	public GetDataObjectsByTypeDatabaseAction(AccessMethod accessMethod, long roid, String className) {
		super(accessMethod);
		this.roid = roid;
		this.className = className;
	}

	@Override
	public List<DataObject> execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = bimDatabaseSession.getEClassForName(className);
		
		Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
		IfcModel IfcModel = new IfcModel((int)virtualRevision.getSize());
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			ReadSet readSet = bimDatabaseSession.getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId());
			merge(virtualRevision.getProject(), IfcModel, new IfcModel(readSet.getMap()));
		}
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (Long oid : IfcModel.keySet()) {
			EObject eObject = IfcModel.get(oid);
			if (eClass.isInstance(eObject)) {
				DataObject dataObject = null;
				if (eObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot)eObject;
					String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
					String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
					dataObject = new DataObject(eObject.eClass().getName(), oid, guid, name);
				} else {
					dataObject = new DataObject(eObject.eClass().getName(), oid, "", "");
				}
				GetDataObjectByOidDatabaseAction.fillDataObject(IfcModel.getMap(), eObject, dataObject);
				dataObjects.add(dataObject);
			}
		}
		return dataObjects;
	}
}