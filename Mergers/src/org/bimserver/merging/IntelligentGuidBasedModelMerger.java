package org.bimserver.merging;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;

public class IntelligentGuidBasedModelMerger extends AbstractIntelligentModelMerger {

	@Override
	public String getIdentifier(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot) idEObject;
			if (ifcRoot.getGlobalId() != null) {
				return ifcRoot.getGlobalId().getWrappedValue();
			}
		}
		return null;
	}
}
