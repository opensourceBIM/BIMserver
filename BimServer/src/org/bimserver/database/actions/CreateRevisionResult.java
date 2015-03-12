package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;

public class CreateRevisionResult {
	private final List<Revision> revisions = new ArrayList<Revision>();
	private ConcreteRevision concreteRevision;
	
	public void addRevision(Revision revision) {
		this.revisions.add(revision);
	}

	public List<Revision> getRevisions() {
		return revisions;
	}
	
	public void setConcreteRevision(ConcreteRevision concreteRevision) {
		this.concreteRevision = concreteRevision;
	}
	
	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}
}