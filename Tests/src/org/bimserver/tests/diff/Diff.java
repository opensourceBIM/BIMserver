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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class Diff {
	private final boolean ignoreIntegerZeroDollar;
	private final boolean ignoreDoubleZeroDollar;
	private final boolean ignoreListEmptyDollar;
	private final Set<String> guidPositions = new HashSet<String>();
	private int addedBySingleInstance = 0;
	private int addedByGuid = 0;
	private int addedByReferencesTo = 0;
	private int addedByReferencesFrom = 0;
	private int addedByHashMatch = 0;
	private int valueMatches = 0;
	private int addedByGraphIsomorphing = 0;
	private Path file1;
	private Path file2;

	public static void main(String[] args) {
		try {
			new Diff(false, false, false, Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc"), Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc")).start();
		} catch (CompareException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public Diff(boolean ignoreIntegerZeroDollar, boolean ignoreDoubleZeroDollar, boolean ignoreListEmptyDollar, Path file1, Path file2) {
		this.ignoreIntegerZeroDollar = ignoreIntegerZeroDollar;
		this.ignoreDoubleZeroDollar = ignoreDoubleZeroDollar;
		this.ignoreListEmptyDollar = ignoreListEmptyDollar;
		this.file1 = file1;
		this.file2 = file2;
		for (EClassifier eClassifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (Ifc2x3tc1Package.eINSTANCE.getIfcRoot().isSuperTypeOf(eClass)) {
					guidPositions.add(eClass.getName().toUpperCase() + "_" + eClass.getEAllStructuralFeatures().indexOf(eClass.getEStructuralFeature("GlobalId")));
				}
			} 
		}
	}

	public void start() throws CompareException, NoSuchAlgorithmException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		DiffReader diffReader1 = new DiffReader(1, this, countDownLatch, file1);
		DiffReader diffReader2 = new DiffReader(2, this, countDownLatch, file2);

		diffReader1.start();
		diffReader2.start();
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<Model> subModels1 = diffReader1.getSubModels();
		List<Model> subModels2 = diffReader2.getSubModels();

		Map<String, Set<Model>> sizeMapped1 = diffReader1.getSizeMapped();
		Map<String, Set<Model>> sizeMapped2 = diffReader2.getSizeMapped();
		
		FullModel model1 = diffReader1.getModel();
		FullModel model2 = diffReader2.getModel();
		
		if (diffReader1.getSubModels().size() != diffReader2.getSubModels().size()) {
			throw new CompareException("Submodels not of same size: " + model1.size() + " / " + model2.size());
		}

		Set<Model> unmatchedModels1 = new HashSet<Model>(subModels1);
		Set<Model> unmatchedModels2 = new HashSet<Model>(subModels2);
		for (String key : sizeMapped1.keySet()) {
			Set<Model> set1 = sizeMapped1.get(key);
			if (!sizeMapped2.containsKey(key)) {
				dumpSizeMapped(sizeMapped1);
				dumpSizeMapped(sizeMapped2);
				throw new CompareException("Key " + key + " not found in 2nd model");
			}
			Set<Model> set2 = sizeMapped2.get(key);
			if (set1.size() == 1 && set2.size() == 1) {
				Model m1 = set1.iterator().next();
				Model m2 = set2.iterator().next();
				compareModels(m1, m2);
				unmatchedModels1.remove(m1);
				unmatchedModels2.remove(m2);
			}
		}
		Map<Fingerprint, Set<Model>> canonicals1 = toCanonicals(unmatchedModels1);
		Map<Fingerprint, Set<Model>> canonicals2 = toCanonicals(unmatchedModels2);
		
		for (Fingerprint fingerprint : canonicals1.keySet()) {
			Set<Model> set1 = canonicals1.get(fingerprint);
			Set<Model> set2 = canonicals2.get(fingerprint);
			if (set2 == null) {
				throw new CompareException("Set2.size != Set1.size");
			}
			if (set1.size() == set2.size()) {
				Iterator<Model> iterator1 = set1.iterator();
				Iterator<Model> iterator2 = set2.iterator();
				while (iterator1.hasNext() && iterator2.hasNext()) {
					Model m1 = iterator1.next();
					Model m2 = iterator2.next();
					// We know m1 and m2 are isomorph, so just get their canonical form, and then match all objects
					Fingerprint f1 = m1.toCanonicalForm();
					Fingerprint f2 = m2.toCanonicalForm();
					if (f1.getPermutationIndices().length != f2.getPermutationIndices().length) {
						throw new CompareException("Not the same amount of permutation indices " + f1.getPermutationIndices().length + " / " + f2.getPermutationIndices().length);
					}
					for (int i=0; i<m1.size(); i++) {
						addedByGraphIsomorphing++;
						match(m1.getByIndex(f1.getPermutationIndices()[i]), m2.getByIndex(f2.getPermutationIndices()[i]));
					}
				}
				unmatchedModels1.removeAll(set1);
				unmatchedModels2.removeAll(set2);
			}
		}
		
		System.out.println("Unmatched submodels: " + unmatchedModels1.size() + " / " + unmatchedModels2.size());
		
		System.out.println("addedBySingleInstance: " + addedBySingleInstance);
		System.out.println("addedByGuid:" + addedByGuid);
		System.out.println("addedByReferencesTo: " + addedByReferencesTo);
		System.out.println("addedByReferencesFrom: " + addedByReferencesFrom);
		System.out.println("addedByHashMatch: " + addedByHashMatch);
		System.out.println("addedByGraphIsomorphing: " + addedByGraphIsomorphing);
		System.out.println("addedByValue: " + valueMatches);
		System.out.println("matched: " + model1.getNrMatchedObjects() + " / " + model1.size() + " which is "
				+ DecimalFormat.getPercentInstance().format((float) model1.getNrMatchedObjects() / model1.size()));

		for (ModelObject modelObject : model1.getUnmatchedObjects()) {
			System.out.println(modelObject);
		}
	}

	private void dumpSizeMapped(Map<String, Set<Model>> sizeMapped) {
		for (String key : sizeMapped.keySet()) {
			System.out.println(key + sizeMapped.get(key).size());
		}
	}

	private Map<Fingerprint, Set<Model>> toCanonicals(Set<Model> unmatchedModels1) {
		Map<Fingerprint, Set<Model>> canonicals = new HashMap<Fingerprint, Set<Model>>();
		for (Model model : unmatchedModels1) {
			Fingerprint fingerprint = model.toCanonicalForm();
			if (canonicals.containsKey(fingerprint)) {
				canonicals.get(fingerprint).add(model);
			} else {
				HashSet<Model> set = new HashSet<Model>();
				set.add(model);
				canonicals.put(fingerprint, set);
			}
		}
		return canonicals;
	}

	private void compareModels(Model model1, Model model2) throws CompareException {
		System.out.println("Going to compare 2 submodels: " + model1.size() + " / " + model2.size());
		if (model1.size() != model2.size()) {
			throw new CompareException("Models not of same size: " + model1.size() + " / " + model2.size());
		}
		if (model1.getNrDistinctTypes() != model2.getNrDistinctTypes()) {
			throw new CompareException("Models do not have the same amount of distinct types: " + model1.getNrDistinctTypes() + " / " + model2.getNrDistinctTypes());
		}
		if (model1.getGuids().size() != model2.getGuids().size()) {
			throw new CompareException("Models do not have the same amount of GUIDs: " + model1.getGuids().size() + " / " + model2.getGuids().size());
		}

		for (String guid : model1.getGuids()) {
			ModelObject o1 = model1.getByGuid(guid);
			ModelObject o2 = model2.getByGuid(guid);
			if (o2 == null) {
				throw new CompareException("Guid " + guid + " not found in m2");
			}
			if (o1.getType().equals(o2.getType())) {
				if (!o1.isMatched() && !o2.isMatched()) {
					addedByGuid++;
					match(o1, o2);
				}
			} else {
				throw new CompareException("Types");
			}
		}

		int matchedObjects = model1.getNrMatchedObjects();
		int lastMatchedObjects = 0;
		while (lastMatchedObjects != matchedObjects) {
			System.out.println(matchedObjects);
			for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getMatchedObjects())) {
				valueMatches += expandModelObject(modelObject);
			}
			addedBySingleInstance += testSingleOfType(model1, model2);
			addedByReferencesTo += testSingleOutgoingReferences(model1);
			addedByReferencesFrom += testSingleIncomingReferences(model1);
			addedByHashMatch += testOutgoingReferences(model1, model2);

			lastMatchedObjects = matchedObjects;
			matchedObjects = model1.getNrMatchedObjects();
		}
	}

	public Comparator<Model> modelComparator() {
		return new Comparator<Model>() {
			@Override
			public int compare(Model o1, Model o2) {
				return (o1.size() - o2.size()) * 1000000000 - (o1.nrEdges() - o2.nrEdges());
			}
		};
	}

	private ModelObject findSingleUnmatched(Set<ModelObject> set) {
		ModelObject s = null;
		for (ModelObject modelObject : set) {
			if (!modelObject.isMatched()) {
				if (s == null) {
					s = modelObject;
				} else {
					return null;
				}
			}
		}
		return s;
	}

	private int testSingleIncomingReferences(Model model1) throws CompareException {
		int addedByReferencesFrom = 0;
		for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getMatchedObjects())) {
			Set<ModelObject> referencesFrom = modelObject.getReferencesFrom();
			Set<ModelObject> referencesFromRemote = modelObject.getMatchedObject().getReferencesFrom();
			ModelObject in1 = findSingleUnmatched(referencesFrom);
			ModelObject in2 = findSingleUnmatched(referencesFromRemote);
			if (in1 != null && in2 != null) {
				if (in1.getType().equals(in2.getType())) {
					addedByReferencesFrom++;
					match(in1, in2);
				} else {
					throw new CompareException("Types different");
				}
			}
		}
		return addedByReferencesFrom;
	}

	private int testSingleOutgoingReferences(Model model1) throws CompareException {
		int addedByReferencesTo = 0;
		for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getMatchedObjects())) {
			Set<ModelObject> referencesTo = modelObject.getReferencesTo();
			Set<ModelObject> referencesToRemote = modelObject.getMatchedObject().getReferencesTo();
			ModelObject in1 = findSingleUnmatched(referencesTo);
			ModelObject in2 = findSingleUnmatched(referencesToRemote);
			if (in1 != null && in2 != null) {
				if (in1.getType().equals(in2.getType())) {
					addedByReferencesTo++;
					match(in1, in2);
				} else {
					throw new CompareException("Types different");
				}
			}
		}
		return addedByReferencesTo;
	}

	private int testSingleOfType(Model model1, Model model2) throws CompareException {
		int addedBySingleInstance = 0;
		for (String type : model1.getDistinctTypes()) {
			int a1 = model1.getNrObjectsOfType(type);
			int a2 = model2.getNrObjectsOfType(type);
			if (a1 == a2 && a1 == 1) {
				List<ModelObject> ofType1 = model1.getOfType(type);
				List<ModelObject> ofType2 = model2.getOfType(type);
				ModelObject first1 = null;
				for (ModelObject modelObject : ofType1) {
					if (!modelObject.isMatched()) {
						if (first1 != null) {
							first1 = modelObject;
						} else {
							first1 = null;
						}
					}
				}
				ModelObject first2 = null;
				for (ModelObject modelObject : ofType2) {
					if (!modelObject.isMatched()) {
						if (first2 != null) {
							first2 = modelObject;
						} else {
							first2 = null;
						}
					}
				}
				if (first1 != null && first2 != null) {
					match(first1, first2);
					addedBySingleInstance++;
				}
			}
		}
		return addedBySingleInstance;
	}

	private int testOutgoingReferences(Model model1, Model model2) throws CompareException {
		int addedByHashMatch = 0;
		Map<String, ModelObject> remoteMarked = new HashMap<String, ModelObject>();
		for (ModelObject modelObject : model2.getUnmatchedObjects()) {
			boolean goodToGo = true;
			StringBuilder sb = new StringBuilder();
			sb.append(modelObject.getType());
			for (Object value : modelObject.getValues()) {
				if (value != null) {
					if (value instanceof ModelObject) {
						if (!((ModelObject) value).isMatched()) {
							goodToGo = false;
							break;
						}
						sb.append(((ModelObject) value).getType() + value.hashCode());
					} else if (value instanceof List) {
						for (Object v : (List<?>) value) {
							if (v instanceof ModelObject) {
								if (!((ModelObject) v).isMatched()) {
									goodToGo = false;
									break;
								} else {
									sb.append(((ModelObject) v).getType() + v.hashCode());
								}
							} else if (v instanceof String) {
								sb.append((String) v);
							}
						}
						if (!goodToGo) {
							break;
						}
					} else if (value instanceof String) {
						sb.append((String) value);
					}
				} else {
					sb.append("-1");
				}
			}
			String str = sb.toString();
			if (remoteMarked.containsKey(str)) {
				remoteMarked.put(str, null);
			} else {
				remoteMarked.put(str, modelObject);
			}
		}

		Map<String, ModelObject> localMarked = new HashMap<String, ModelObject>();
		for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getUnmatchedObjects())) {
			StringBuilder sb = new StringBuilder();
			sb.append(modelObject.getType());
			if (!modelObject.isMatched()) {
				boolean goodToGo = true;
				for (Object value : modelObject.getValues()) {
					if (value != null) {
						if (value instanceof ModelObject) {
							if (!((ModelObject) value).isMatched()) {
								goodToGo = false;
								break;
							} else {
								sb.append(((ModelObject) value).getMatchedObject().getType() + ((ModelObject) value).getMatchedObject().hashCode());
							}
						} else if (value instanceof List) {
							for (Object v : (List<?>) value) {
								if (v instanceof ModelObject) {
									if (!((ModelObject) v).isMatched()) {
										goodToGo = false;
										break;
									} else {
										sb.append(((ModelObject) v).getMatchedObject().getType() + ((ModelObject) v).getMatchedObject().hashCode());
									}
								} else if (v instanceof String) {
									sb.append((String) v);
								}
							}
							if (!goodToGo) {
								break;
							}
						} else if (value instanceof String) {
							sb.append((String) value);
						}
					} else {
						sb.append("-1");
					}
				}
				if (goodToGo) {
					String s = sb.toString();
					if (localMarked.containsKey(s)) {
						localMarked.put(s, null);
					} else {
						localMarked.put(s, modelObject);
					}
				}
			}
		}
		for (String key : remoteMarked.keySet()) {
			ModelObject remoteObject = remoteMarked.get(key);
			ModelObject localObject = localMarked.get(key);
			if (remoteObject != null && localObject != null) {
				addedByHashMatch++;
				match(localObject, remoteObject);
			}
		}
		return addedByHashMatch;
	}

	public void match(ModelObject modelObject1, ModelObject modelObject2) throws CompareException {
		if (!modelObject1.getType().equals(modelObject2.getType())) {
			throw new CompareException("Types not the same: " + modelObject1.getType() + "/" + modelObject2.getType());
		}
		if (modelObject1.getId() != modelObject2.getId()) {
			System.out.println(modelObject1.getId() + "/" + modelObject2.getId());
		}
		int i = 0;
		for (Object value : modelObject1.getValues()) {
			Object remoteValue = modelObject2.getValue(i);
			matchValue(i, modelObject1, modelObject2, value, remoteValue);
			i++;
		}
		modelObject1.setMatchedObject(modelObject2);
	}

	private void matchValue(int index, ModelObject modelObject1, ModelObject modelObject2, Object value, Object remoteValue) throws CompareException {
		if (value == null) {
			if (remoteValue != null) {
				if (ignoreIntegerZeroDollar && remoteValue.equals("0")) {
				} else if (ignoreListEmptyDollar && remoteValue instanceof List && ((List<?>) remoteValue).isEmpty()) {
				} else if (ignoreDoubleZeroDollar && remoteValue.equals("0.0")) {
				} else {
					throw new CompareException("Remote value not null: " + remoteValue + " on " + modelObject1 + " / " + modelObject2 + "." + index);
				}
			}
		} else if (value instanceof String) {
			String valueString = (String) value;
			if (remoteValue instanceof String) {
				if (!remoteValue.equals(value)) {
					if (((String) remoteValue).endsWith(".") && valueString.endsWith(".0") || (((String) valueString).endsWith(".") && ((String) remoteValue).endsWith(".0"))) {

					} else {
						// throw new CompareException("Values not the same: " +
						// value + " / " + remoteValue + " on " + modelObject +
						// " / " + modelObject.getMatchedObject());
					}
				}
			} else {
				if (ignoreIntegerZeroDollar && value.equals("0")) {
				} else if (ignoreListEmptyDollar && value instanceof List && ((List<?>) value).isEmpty()) {
				} else if (ignoreDoubleZeroDollar && value.equals("0.0")) {
				} else {
					throw new CompareException("Remote value not of type String: " + remoteValue + " / " + value + " on " + modelObject1 + " / " + modelObject2 + "." + index);
				}
			}
		} else if (value instanceof ModelObject) {
			ModelObject valueObject = (ModelObject) value;
			if (remoteValue instanceof ModelObject) {
				ModelObject remoteValueObject = (ModelObject) remoteValue;
				if ((remoteValueObject).getType().equals(valueObject.getType())) {
					if (!valueObject.isMatched() && !remoteValueObject.isMatched()) {
					} else if (valueObject.isMatched() && remoteValueObject.isMatched()) {
						if (valueObject.getMatchedObject() != remoteValueObject) {
							throw new CompareException("Matched objects not the same");
						}
					} else {
						throw new CompareException("One object matched, the other not");
					}
				} else {
					throw new CompareException("Objects not of same type: " + valueObject.getType() + " / " + remoteValueObject.getType());
				}
			} else {
				throw new CompareException("Remote object not a ModelObject: " + remoteValue);
			}
		} else if (value instanceof List) {
			List<?> valueList = (List<?>) value;
			if (remoteValue instanceof List) {
				List<?> remoteList = (List<?>) remoteValue;
				if (valueList.size() != remoteList.size()) {
					throw new CompareException("List sizes not equal: " + valueList.size() + " / " + remoteList.size());
				} else {
					int j = 0;
					for (Object o1 : valueList) {
						Object o2 = remoteList.get(j);
						if (o1 instanceof ModelObject && o2 instanceof ModelObject) {
						} else {
							matchValue(j, modelObject1, modelObject2, o1, o2);
						}
						j++;
					}
				}
			} else if (ignoreListEmptyDollar && remoteValue == null && valueList.isEmpty()) {
			} else {
				throw new CompareException("Remote value not of type list on " + modelObject1 + " / " + modelObject2);
			}
		} else {
			throw new CompareException("Unimplemented type " + value.getClass().getName());
		}
	}

	private int expandModelObject(ModelObject modelObject) throws CompareException {
		int i = 0;
		int matches = 0;
		for (Object value : modelObject.getValues()) {
			Object remoteValue = modelObject.getMatchedObject().getValue(i);
			matches += expandValue(i, modelObject, value, remoteValue);
			i++;
		}
		return matches;
	}

	private int expandValue(int index, ModelObject modelObject, Object value, Object remoteValue) throws CompareException {
		int result = 0;
		if (value == null) {
		} else if (value instanceof String) {
		} else if (value instanceof ModelObject) {
			ModelObject valueObject = (ModelObject) value;
			if (remoteValue instanceof ModelObject) {
				ModelObject remoteValueObject = (ModelObject) remoteValue;
				if ((remoteValueObject).getType().equals(valueObject.getType())) {
					if (!valueObject.isMatched() && !remoteValueObject.isMatched()) {
						match(valueObject, remoteValueObject);
						result++;
					}
				} else {
					throw new CompareException("Objects not of same type: " + valueObject.getType() + " / " + remoteValueObject.getType());
				}
			} else {
				throw new CompareException("Remote object not a ModelObject");
			}
		} else if (value instanceof List) {
			List<?> valueList = (List<?>) value;
			if (remoteValue instanceof List) {
				List<?> remoteList = (List<?>) remoteValue;
				if (valueList.size() != remoteList.size()) {
					throw new CompareException("List sizes not equal: " + valueList.size() + " / " + remoteList.size());
				} else {
					int j = 0;
					for (Object o1 : valueList) {
						Object o2 = remoteList.get(j);
						if (o1 instanceof ModelObject && o2 instanceof ModelObject) {
							match((ModelObject) o1, (ModelObject) o2);
						}
						j++;
					}
				}
			} else if (ignoreListEmptyDollar && remoteValue == null && valueList.isEmpty()) {
			} else {
				throw new CompareException("Remote value not of type list on " + modelObject + " / " + modelObject.getMatchedObject());
			}
		} else {
			throw new CompareException("Unimplemented type " + value.getClass().getName());
		}
		return result;
	}

	public Set<String> getGuidPositions() {
		return guidPositions;
	}
}