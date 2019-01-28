package org.bimserver.tests.diff;

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

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Model {

	void add(ModelObject modelObject);
	boolean contains(ModelObject modelObject);
	int size();
	int nrEdges();
	int getNrDistinctTypes();
	Set<String> getDistinctTypes();
	int getNrObjectsOfType(String type);
	ModelObject getByGuid(String guid);
	Set<String> getGuids();
	int getNrMatchedObjects();
	Collection<? extends ModelObject> getMatchedObjects();
	Collection<? extends ModelObject> getUnmatchedObjects();
	List<ModelObject> getOfType(String type);
	void indexGuids();
	void addMatchedObject(ModelObject modelObject);
	ModelObject get(long refId);
	void indexGuid(ModelObject modelObject) throws CompareException;
	Fingerprint toCanonicalForm();
	Fingerprint fingerprint();
	ModelObject getByIndex(int i);
}
