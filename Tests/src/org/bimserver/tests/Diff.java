package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.utils.StringUtils;

public class Diff {
	private SchemaDefinition schema;
	private final boolean ignoreIntegerZeroDollar;
	private final boolean ignoreDoubleZeroDollar;
	private final boolean ignoreListEmptyDollar;

	public static void main(String[] args) {
		try {
			new Diff(false, false, false).start();
		} catch (CompareException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public Diff(boolean ignoreIntegerZeroDollar, boolean ignoreDoubleZeroDollar, boolean ignoreListEmptyDollar) {
		this.ignoreIntegerZeroDollar = ignoreIntegerZeroDollar;
		this.ignoreDoubleZeroDollar = ignoreDoubleZeroDollar;
		this.ignoreListEmptyDollar = ignoreListEmptyDollar;
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			schema = pluginManager.requireSchemaDefinition();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
	
	public class ModelObject {
		private final Model model;
		private long id = -1;
		private String type;
		private final List<Object> values = new ArrayList<Object>();
		private ModelObject matchedObject;
		private final Set<ModelObject> referencesTo = new HashSet<Diff.ModelObject>();
		private final Set<ModelObject> referencesFrom = new HashSet<Diff.ModelObject>();
		private String guid;

		public ModelObject(Model model, String line) {
			this.model = model;
			if (line.startsWith("#")) {
				if (line.contains("=")) {
					String idString = line.substring(1, line.indexOf("="));
					this.id = Long.parseLong(idString);
					if (line.indexOf("(", line.indexOf("=")) != -1) {
						type = line.substring(line.indexOf("=") + 1, line.indexOf("(", line.indexOf("="))).trim();
					}
				}
			}
		}

		@Override
		public String toString() {
			return id + " " + type;
		}

		public List<Object> getValues() {
			return values;
		}

		public void setMatchedObject(ModelObject matchedObject) {
			if (this.matchedObject != matchedObject) {
				this.matchedObject = matchedObject;
				model.addMatchedObject(this);
				matchedObject.setMatchedObject(this);
			}
		}

		public ModelObject getMatchedObject() {
			return matchedObject;
		}

		public void fill(String line) throws CompareException {
			if (line.startsWith("#")) {
				if (line.contains("=")) {
					int lastIndexOfSemiColon = line.lastIndexOf(";");
					int indexOfFirstParen = line.indexOf("(");
					String rest = line.substring(indexOfFirstParen + 1, lastIndexOfSemiColon - 1);
					int lastIndex = 0;
					int i = 0;
					while (lastIndex < rest.length()) {
						int nextIndex = StringUtils.nextString(rest, lastIndex);
						String sub = rest.substring(lastIndex, nextIndex - 1).trim();
						values.add(processField(i++, sub));
						lastIndex = nextIndex;
					}
				}
			}
		}

		private Object processField(int index, String sub) throws CompareException {
			if (sub.startsWith("#")) {
				long refId = Long.parseLong(sub.substring(1));
				ModelObject reference = model.get(refId);
				if (reference == null) {
					System.out.println("Reference to " + refId + " not found");
				}
				this.addReferenceTo(reference);
				return reference;
			} else if (sub.startsWith("(") && sub.endsWith(")")) {
				String subStr = sub.substring(1, sub.length() - 1);
				return processList(index, subStr);
			} else if (sub.equals("$")) {
				return null;
			} else if (sub.startsWith("'") && sub.endsWith("'")) {
				String str = sub.substring(1, sub.length() - 1);
				EntityDefinition entityBN = schema.getEntityBN(getType());
				if (entityBN != null) {
					if (entityBN.getAttributes(true).size() > index) {
						Attribute attribute = entityBN.getAttributes(true).get(index);
						if (attribute != null) {
							if (attribute.getName().equals("GlobalId")) {
								setGuid(GuidCompressor.uncompressGuidString(str));
							}
						}
					}
				}
				return str;
			} else if (sub.startsWith(".")) {
				return sub;
			} else {
				return sub;
			}
		}

		public String getGuid() {
			return guid;
		}

		private void setGuid(String guid) throws CompareException {
			this.guid = guid;
			model.indexGuid(this);
		}

		private void addReferenceTo(ModelObject referenceTo) {
			referencesTo.add(referenceTo);
			referenceTo.addReferenceFrom(this);
		}

		private void addReferenceFrom(ModelObject modelObject) {
			referencesFrom.add(modelObject);
		}

		public Set<ModelObject> getReferencesTo() {
			return referencesTo;
		}

		private Object processList(int index, String subStr) throws CompareException {
			int lastIndex = 0;
			List<Object> list = new ArrayList<Object>();
			while (lastIndex < subStr.length()) {
				int nextIndex = StringUtils.nextString(subStr, lastIndex);
				String stringValue = subStr.substring(lastIndex, nextIndex - 1).trim();
				list.add(processField(index, stringValue));
				lastIndex = nextIndex;
				
			}
			return list;
		}

		public Long getId() {
			return id;
		}

		public String getType() {
			return type;
		}

		public Object getValue(int i) {
			return values.get(i);
		}

		public boolean isMatched() {
			return matchedObject != null;
		}

		public int size() {
			return values.size();
		}

		public Set<ModelObject> getReferencesFrom() {
			return referencesFrom;
		}
	}

	public class Model {
		private final Map<Long, ModelObject> objects = new HashMap<Long, ModelObject>();
		private final Map<String, List<ModelObject>> objectsByType = new HashMap<String, List<ModelObject>>();
		private final Set<ModelObject> matchedObjects = new LinkedHashSet<Diff.ModelObject>();
		private final Set<ModelObject> unmatchedObjects = new LinkedHashSet<Diff.ModelObject>();
		private final Map<String, ModelObject> guids = new HashMap<String, Diff.ModelObject>();

		public Model(File file) throws CompareException {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				while (line != null) {
					ModelObject modelObject = new ModelObject(this, line.trim());
					if (modelObject.getId() != -1) {
						add(modelObject);
					}
					line = reader.readLine();
				}

				reader = new BufferedReader(new FileReader(file));
				line = reader.readLine();
				while (line != null) {
					if (line.startsWith("#")) {
						if (line.contains("=")) {
							String idString = line.substring(1, line.indexOf("="));
							long id = Long.parseLong(idString);
							ModelObject modelObject = get(id);
							modelObject.fill(line);
						}
					}
					line = reader.readLine();
				}

				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
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

		public void add(ModelObject modelObject) {
			objects.put(modelObject.getId(), modelObject);
			unmatchedObjects.add(modelObject);
			if (objectsByType.containsKey(modelObject.getType())) {
				objectsByType.get(modelObject.getType()).add(modelObject);
			} else {
				ArrayList<ModelObject> list = new ArrayList<Diff.ModelObject>();
				list.add(modelObject);
				objectsByType.put(modelObject.getType(), list);
			}
		}

		public ModelObject get(long id) {
			return objects.get(id);
		}

		public long getSize() {
			return objects.size();
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

		public Collection<? extends ModelObject> getObjects() {
			return objects.values();
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

		public int getNrObjects() {
			return objects.size();
		}
	}

	public static class CompareException extends Exception {
		private static final long serialVersionUID = -7361111719968741063L;

		public CompareException(String message) {
			super(message);
		}
	}

	public static class ByteArrayWrapper {
		private byte[] bytes;

		public ByteArrayWrapper(byte[] bytes) {
			this.bytes = bytes;
		}

		public byte[] getBytes() {
			return bytes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(bytes);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ByteArrayWrapper other = (ByteArrayWrapper) obj;
			if (!Arrays.equals(bytes, other.bytes))
				return false;
			return true;
		}
	}

	private void start() throws CompareException, NoSuchAlgorithmException {
		Model model1 = new Model(new File("C:\\Users\\Ruben de  Laat\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
		Model model2 = new Model(new File("C:\\Users\\Ruben de  Laat\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
//		Model model1 = new Model(new File("C:\\Users\\Ruben de Laat\\Workspaces\\BIMserverNewest\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
//		Model model2 = new Model(new File("C:\\Users\\Ruben de Laat\\Downloads\\test.1 (10).ifc"));
		if (model1.getSize() != model2.getSize()) {
			throw new CompareException("Models not of same size: " + model1.getSize() + " / " + model2.getSize());
		}
		if (model1.getNrDistinctTypes() != model2.getNrDistinctTypes()) {
			throw new CompareException("Models do not have the same amount of distinct types: " + model1.getNrDistinctTypes() + " / " + model2.getNrDistinctTypes());
		}
		if (model1.getGuids().size() != model2.getGuids().size()) {
			throw new CompareException("Models do not have the same amount of GUIDs: " + model1.getGuids().size() + " / " + model2.getGuids().size());
		}
		Set<String> typesWithOneInstance = new HashSet<String>();

		int addedBySingleInstance = 0;
		int addedByGuid = 0;
		int addedByReferencesTo = 0;
		int addedByReferencesFrom = 0;
		int addedByHashMatch = 0;
		int valueMatches = 0;
		
		for (String type : model1.getDistinctTypes()) {
			int a1 = model1.getNrObjectsOfType(type);
			int a2 = model2.getNrObjectsOfType(type);
			if (a1 != a2) {
				throw new CompareException("Models do not have the same amount of objects for type: " + type + ": " + a1 + " / " + a2);
			} else if (a1 == 1) {
				typesWithOneInstance.add(type);
			}
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
			addedByReferencesTo += testSingleOutgoingReferences(model1);
			addedByReferencesFrom += testSingleIncomingReferences(model1);
			addedBySingleInstance += testSingleOfType(model1, model2);
			addedByHashMatch += testOutgoingReferences(model1, model2);
			
			lastMatchedObjects = matchedObjects;
			matchedObjects = model1.getNrMatchedObjects();
		}
		System.out.println("nrGuids: " + model1.getGuids().size());
		System.out.println("addedBySingleInstance: " + addedBySingleInstance);
		System.out.println("addedByGuid:" + addedByGuid);
		System.out.println("addedByReferencesTo: " + addedByReferencesTo);
		System.out.println("addedByReferencesFrom: " + addedByReferencesFrom);
		System.out.println("addedByHashMatch: " + addedByHashMatch);
		System.out.println("addedByValue: " + valueMatches);
		System.out.println("matched: " + model1.getNrMatchedObjects() + " / " + model1.getNrObjects());
		
		for (ModelObject modelObject : model1.getUnmatchedObjects()) {
			if (modelObject.getReferencesFrom().isEmpty()) {
				System.out.println(modelObject);
			}
		}
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
					if (!in1.isMatched()) {
						addedByReferencesFrom++;
						match(in1, in2);
					}
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
			if (referencesTo.size() == referencesToRemote.size()) {
				if (referencesTo.size() == 1) {
					ModelObject r1 = referencesTo.iterator().next();
					ModelObject r2 = referencesToRemote.iterator().next();
					if (r1.getType().equals(r2.getType())) {
						if (!r1.isMatched()) {
							addedByReferencesTo++;
							match(r1, r2);
						}
					} else {
						throw new CompareException("Types different");
					}
				}
			} else {
				throw new CompareException("References to not equal: " + referencesTo.size() + " / " + referencesToRemote.size() + " on " + modelObject + " / "
						+ modelObject.getMatchedObject());
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
		Map<String, ModelObject> remoteMarked = new HashMap<String, Diff.ModelObject>();
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
								sb.append((String)v);
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
			remoteMarked.put(sb.toString(), modelObject);
		}

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
								sb.append(((ModelObject) value).getMatchedObject().getType() + ((ModelObject)value).getMatchedObject().hashCode());
							}
						} else if (value instanceof List) {
							for (Object v : (List<?>) value) {
								if (v instanceof ModelObject) {
									if (!((ModelObject) v).isMatched()) {
										goodToGo = false;
										break;
									} else {
										sb.append(((ModelObject) v).getMatchedObject().getType() + ((ModelObject)v).getMatchedObject().hashCode());
									}
								} else if (v instanceof String) {
									sb.append((String)v);
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
					if (remoteMarked.containsKey(s)) {
						addedByHashMatch++;
						ModelObject object = remoteMarked.get(s);
						match(modelObject, object);
					}
				}
			}
		}
		return addedByHashMatch;
	}

	public void match(ModelObject modelObject1, ModelObject modelObject2) throws CompareException {
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
				} else if (ignoreListEmptyDollar && remoteValue instanceof List && ((List<?>)remoteValue).isEmpty()) {
				} else if (ignoreDoubleZeroDollar && remoteValue.equals("0.0")) {
				} else {
					throw new CompareException("Remote value not null: " + remoteValue + " on " + modelObject1 + " / " + modelObject2 + "." + index);
				}
			}
		} else if (value instanceof String) {
			String valueString = (String)value;
			if (remoteValue instanceof String) {
				if (!remoteValue.equals(value)) {
					if (((String) remoteValue).endsWith(".") && valueString.endsWith(".0") || (((String) valueString).endsWith(".") && ((String) remoteValue).endsWith(".0"))) {
						
					} else {
//						throw new CompareException("Values not the same: " + value + " / " + remoteValue + " on " + modelObject + " / " + modelObject.getMatchedObject());
					}
				}
			} else {
				if (ignoreIntegerZeroDollar && value.equals("0")) {
				} else if (ignoreListEmptyDollar && value instanceof List && ((List<?>)value).isEmpty()) {
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
					} else if (valueObject.isMatched() && remoteValueObject.isMatched()){
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
							match((ModelObject)o1, (ModelObject)o2);
							j++;
						}
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
}