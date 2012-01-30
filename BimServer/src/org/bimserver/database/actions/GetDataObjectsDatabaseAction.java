package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsDatabaseAction extends BimDatabaseAction<List<DataObject>> {

	private final long roid;
	private final BimServer bimServer;

	public GetDataObjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, BimServer bimServer, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
	}

	@Override
	public List<DataObject> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = getVirtualRevision(roid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			getDatabaseSession().getMap(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), true, null);
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(virtualRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().getIntelligentMerging());
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (Long oid : ifcModel.keySet()) {
			EObject eObject = ifcModel.get(oid);
			DataObject dataObject = null;
			if (eObject instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot)eObject;
				String guid = ifcRoot.getGlobalId() != null ? ifcRoot.getGlobalId().getWrappedValue() : "";
				String name = ifcRoot.getName() != null ? ifcRoot.getName() : "";
				dataObject = StoreFactory.eINSTANCE.createDataObject();
				dataObject.setType(eObject.eClass().getName());
				dataObject.setOid(oid);
				dataObject.setGuid(guid);
				dataObject.setName(name);
			} else {
				dataObject = StoreFactory.eINSTANCE.createDataObject();
				dataObject.setType(eObject.eClass().getName());
				dataObject.setOid(oid);
				dataObject.setGuid("");
				dataObject.setName("");
			}
			GetDataObjectByOidDatabaseAction.fillDataObject(ifcModel.getMap(), eObject, dataObject);
			dataObjects.add(dataObject);
		}
		return dataObjects;
	}
}