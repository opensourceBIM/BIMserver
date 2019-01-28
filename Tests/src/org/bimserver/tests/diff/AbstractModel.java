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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public abstract class AbstractModel implements Model {
	private final BiMap<Long, ModelObject> objects = HashBiMap.create();
	private final List<ModelObject> objectsAsList = new ArrayList<ModelObject>();
	private final Map<String, List<ModelObject>> objectsByType = new HashMap<String, List<ModelObject>>();
	private final Set<ModelObject> matchedObjects = new LinkedHashSet<ModelObject>();
	private final Set<ModelObject> unmatchedObjects = new LinkedHashSet<ModelObject>();
	private final Map<String, ModelObject> guids = new HashMap<String, ModelObject>();
	private int nrEdges = -1;
	
	public void add(ModelObject modelObject) {
		objectsAsList.add(modelObject);
		objects.put(modelObject.getId(), modelObject);
		unmatchedObjects.add(modelObject);
		if (objectsByType.containsKey(modelObject.getType())) {
			objectsByType.get(modelObject.getType()).add(modelObject);
		} else {
			ArrayList<ModelObject> list = new ArrayList<ModelObject>();
			list.add(modelObject);
			objectsByType.put(modelObject.getType(), list);
		}
	}

	@Override
	public boolean contains(ModelObject modelObject) {
		return objects.containsValue(modelObject);
	}

	@Override
	public int size() {
		return objects.size();
	}

	public Set<ModelObject> getObjects() {
		return new HashSet<ModelObject>(objects.values());
	}
	
	@Override
	public int nrEdges() {
		if (nrEdges == -1) {
			nrEdges = 0;
			for (ModelObject modelObject : objects.values()) {
				nrEdges += modelObject.getReferencesFrom().size() + modelObject.getReferencesTo().size();
			}
			nrEdges /= 2;
		}
		return nrEdges;
	}

	public ModelObject get(long id) {
		return objects.get(id);
	}
	
	public Set<String> getGuids() {
		return guids.keySet();
	}

	public void indexGuid(ModelObject modelObject) throws CompareException {
		if (guids.containsKey(modelObject.getGuid())) {
			throw new CompareException("Guid " + modelObject.getGuid() + " already stored");
		}
		guids.put(modelObject.getGuid(), modelObject);
	}

	public void addMatchedObject(ModelObject matchedObject) {
		this.unmatchedObjects.remove(matchedObject);
		this.matchedObjects.add(matchedObject);
	}

	public int getNrDistinctTypes() {
		return objectsByType.size();
	}

	public Set<String> getDistinctTypes() {
		return objectsByType.keySet();
	}

	public int getNrObjectsOfType(String type) {
		List<ModelObject> list = objectsByType.get(type);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	public int getNrObjectsOfTypeUnmatched(String type) {
		if (objectsByType.get(type) == null) {
			return 0;
		}
		int nr = 0;
		for (ModelObject modelObject : objectsByType.get(type)) {
			if (!modelObject.isMatched()) {
				nr++;
			}
		}
		return nr;
	}
	
	public List<ModelObject> getOfType(String type) {
		return objectsByType.get(type);
	}

	public ModelObject getByGuid(String guid) {
		return guids.get(guid);
	}

	public int getNrMatchedObjects() {
		return matchedObjects.size();
	}

	public Collection<? extends ModelObject> getMatchedObjects() {
		return matchedObjects;
	}

	public Set<ModelObject> getUnmatchedObjects() {
		return unmatchedObjects;
	}
	
	@Override
	public void indexGuids() {
		guids.clear();
		for (ModelObject modelObject : getObjects()) {
			if (modelObject.getGuid() != null) {
				guids.put(modelObject.getGuid(), modelObject);
			}
		}
	}

	private long factorial(int n) {
		long f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}
	
	public Iterable<Fingerprint> getAllPermutations() {
		Iterable<Fingerprint> iterable = new Iterable<Fingerprint>() {
			@Override
			public Iterator<Fingerprint> iterator() {
				Iterator<Fingerprint> iterator = new Iterator<Fingerprint>() {
					private long counter = 0;
					private int[] curr = new int[AbstractModel.this.size()];
					private long totalPerms = factorial(AbstractModel.this.size());
					private int size = AbstractModel.this.size();
					
					{
						for (int i=0; i<AbstractModel.this.size(); i++) {
							curr[i] = i;
						}
					}

					@Override
					public boolean hasNext() {
						return counter < totalPerms;
					}

					@Override
					public Fingerprint next() {
						counter++;
						if (counter == 1) {
							return fingerprint();
						} else if (counter > totalPerms) {
							throw new NoSuchElementException();
						}

						int i = size - 1;

						while (curr[i - 1] >= curr[i]) {
							i--;
						}

						int j = size;

						while (curr[j - 1] <= curr[i - 1]) {
							j--;
						}

						swap(i - 1, j - 1);

						i++;
						j = size;

						while (i < j) {
							swap(i - 1, j - 1);
							i++;
							j--;
						}

						return AbstractModel.this.createFingerprintForPermutation(curr);
					}
					
					private void swap(int idx1, int idx2) {
				        int tmp;
				        tmp = curr[idx1];
				        curr[idx1] = curr[idx2];
				        curr[idx2] = tmp;
				    }

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
				return iterator;
			}
		};
		return iterable;
	}
	
	protected Fingerprint createFingerprintForPermutation(int[] curr) {
		Fingerprint fingerprint = new Fingerprint(curr, objects.size());
		for (int index : curr) {
			ModelObject m1 = objectsAsList.get(index);
			for (int index2 : curr) {
				ModelObject m2 = objectsAsList.get(index2);
				fingerprint.add(m1.getReferencesTo().contains(m2) ? 1 : 0);
			}
		}
		return fingerprint;
	}

	@Override
	public Fingerprint fingerprint() {
		Fingerprint fingerprint = new Fingerprint(objects.size());
		for (int index = 0; index<objects.size(); index++) {
			ModelObject m1 = objectsAsList.get(index);
			for (int index2=0; index2<objects.size(); index2++) {
				ModelObject m2 = objectsAsList.get(index2);
				fingerprint.add(m1.getReferencesTo().contains(m2) ? 1 : 0);
			}			
		}
		return fingerprint;
	}

	@Override
	public Fingerprint toCanonicalForm() {
		Fingerprint highest = null;
		for (Fingerprint fingerprint : getAllPermutations()) {
			System.out.println(fingerprint);
			if (highest == null || fingerprint.isHigher(highest)) {
				highest = fingerprint;
			}
		}
		return highest;
	}
	
	@Override
	public ModelObject getByIndex(int i) {
		return objectsAsList.get(i);
	}
}