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
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.SDataObject;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class GetDataObjectsByTypeDatabaseAction extends BimDatabaseAction<List<SDataObject>> {

	private final String className;
	private final long roid;
	private final BimServer bimServer;

	public GetDataObjectsByTypeDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, String className) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.className = className;
	}

	@Override
	public List<SDataObject> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		EClass eClass = getDatabaseSession().getEClassForName(className);
		Revision virtualRevision = getVirtualRevision(roid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = getDatabaseSession().getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId(), false);
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(virtualRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
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