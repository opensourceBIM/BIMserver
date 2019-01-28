package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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