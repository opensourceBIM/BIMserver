package org.bimserver.tests.diff;

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
