package org.bimserver.database.actions;

import java.util.Arrays;

import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.shared.UserException;

public abstract class GenericCheckinDatabaseAction extends BimDatabaseAction<ConcreteRevision>{

	protected final IfcModel model;

	public GenericCheckinDatabaseAction(AccessMethod accessMethod, IfcModel model) {
		super(accessMethod);
		this.model = model;
	}

	protected void checkCheckSum(Project project) throws UserException {
		if (!project.getConcreteRevisions().isEmpty()) {
			ConcreteRevision concreteRevision = project.getConcreteRevisions().get(project.getConcreteRevisions().size()-1);
			byte[] revisionChecksum = concreteRevision.getChecksum();
			if (Arrays.equals(revisionChecksum, model.getChecksum())) {
				throw new UserException("Uploaded model is the same as last revision (" + (1+project.getConcreteRevisions().indexOf(concreteRevision)) + ") duplicate model not stored");
			}
		}
	}
}