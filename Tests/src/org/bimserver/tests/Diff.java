package org.bimserver.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.utils.StringUtils;

public class Diff {
	public static class ModelObject {
		private final Model model;
		private long id = -1;
		private String type;
		private final List<Object> values = new ArrayList<Object>();
		private ModelObject matchedObject;
		private Set<ModelObject> referencesTo = new HashSet<Diff.ModelObject>();
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
				model.addMatchedObject(matchedObject);
				this.matchedObject = matchedObject;
				matchedObject.setMatchedObject(this);
			}
		}

		public ModelObject getMatchedObject() {
			return matchedObject;
		}

		public void fill(String line) throws CompareException {
			if (line.startsWith("#")) {
				if (line.contains("=")) {
					String rest = line.substring(line.indexOf("=") + 1).trim();
					if (rest.contains("(")) {
						rest = rest.substring(rest.indexOf("(") + 1);
						int index = 0;
						int lastIndex = StringUtils.nextString(rest, 0);
						int i=0;
						while (lastIndex < rest.length()) {
							String sub = rest.substring(index, lastIndex - 1).trim();
							values.add(processField(i++, sub));
							index = lastIndex;
							lastIndex = StringUtils.nextString(rest, lastIndex);
						}
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
				reference.addReferenceTo(this);
				return reference;
			} else if (sub.startsWith("(") && sub.endsWith(")")) {
				String subStr = sub.substring(1, sub.length() - 1);
				return processList(index, subStr);
			} else if (sub.equals("$")) {
				return null;
			} else if (sub.startsWith("'") && sub.endsWith("'")) {
				String str = sub.substring(1, sub.length() - 1);
				if (str.length() == 22 && index == 0) {
					setGuid(str);
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
		}
		
		public Set<ModelObject> getReferencesTo() {
			return referencesTo;
		}

		private Object processList(int index, String subStr) throws CompareException {
			int lastIndex = 0;
			List<Object> list = new ArrayList<Object>();
			while (lastIndex != subStr.length() + 1) {
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
	}

	public static class Model {
		private final Map<Long, ModelObject> objects = new HashMap<Long, ModelObject>();
		private final Map<String, List<ModelObject>> objectsByType = new HashMap<String, List<ModelObject>>();
		private final List<ModelObject> matchedObjects = new ArrayList<Diff.ModelObject>();
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

		public List<ModelObject> getMatchedObjects() {
			return matchedObjects;
		}

		public void addMatchedObject(ModelObject matchedObject) {
			this.matchedObjects.add(matchedObject);
		}

		public void add(ModelObject modelObject) {
			objects.put(modelObject.getId(), modelObject);
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

		public List<ModelObject> getOfType(String type) {
			return objectsByType.get(type);
		}

		public ModelObject getByGuid(String guid) {
			return guids.get(guid);
		}

		public Collection<? extends ModelObject> getObjects() {
			return objects.values();
		}
	}

	public static class CompareException extends Exception {
		public CompareException(String message) {
			super(message);
		}
	}

	public static void main(String[] args) {
		try {
			new Diff().start();
		} catch (CompareException e) {
			e.printStackTrace();
		}
	}

	private void start() throws CompareException {
		boolean ignoreIntZeroDollar = true;
		
		Model model1 = new Model(new File("C:\\Users\\Ruben de Laat\\Downloads\\aaa.1 (1).ifc"));
		Model model2 = new Model(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\geheime modellen van statsbygg\\SB_11873_6_ARK_PNN (Original).ifc"));
		if (model1.getSize() != model2.getSize()) {
			throw new CompareException("Models not of same size: " + model1.getSize() + " / " + model2.getSize());
		}
		if (model1.getNrDistinctTypes() != model2.getNrDistinctTypes()) {
			throw new CompareException("Models do not have the same amount of distinct types: " + model1.getNrDistinctTypes() + " / " + model2.getNrDistinctTypes());
		}
		Set<String> typesWithOneInstance = new HashSet<String>();
		for (String type : model1.getDistinctTypes()) {
			int a1 = model1.getNrObjectsOfType(type);
			int a2 = model2.getNrObjectsOfType(type);
			if (a1 != a2) {
				throw new CompareException("Models do not have the same amount of objects for type: " + type + ": " + a1 + " / " + a2);
			} else if (a1 == 1) {
				typesWithOneInstance.add(type);
			}
		}
		for (String type : typesWithOneInstance) {
			for (ModelObject modelObject : model1.getOfType(type)) {
				modelObject.setMatchedObject(model2.getOfType(type).get(0));
			}
		}
		for (String guid : model1.getGuids()) {
			ModelObject o1 = model1.getByGuid(guid);
			ModelObject o2 = model2.getByGuid(guid);
			if (o1.getType().equals(o2.getType())) {
				o1.setMatchedObject(o2);
			} else {
				throw new CompareException("Types");
			}
		}
		int matchedObjects = model1.getMatchedObjects().size();
		int lastMatchedObjects = 0;
		while (lastMatchedObjects != matchedObjects) {
			System.out.println(matchedObjects);
			for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getMatchedObjects())) {
				testValues(ignoreIntZeroDollar, modelObject);
				Set<ModelObject> referencesTo = modelObject.getReferencesTo();
				Set<ModelObject> referencesToRemote = modelObject.getMatchedObject().getReferencesTo();
				if (referencesTo.size() == referencesToRemote.size()) {
					if (referencesTo.size() == 1) {
						ModelObject r1 = referencesTo.iterator().next();
						ModelObject r2 = referencesToRemote.iterator().next();
						if (r1.getType().equals(r2.getType())) {
							r1.setMatchedObject(r2);
						} else {
							throw new CompareException("Types different");
						}
					}
				} else {
					throw new CompareException("References to not equal: " + referencesTo.size() + " / " + referencesToRemote.size());
				}
			}
			for (ModelObject modelObject : new ArrayList<ModelObject>(model1.getObjects())) {
				if (!modelObject.isMatched()) {
					boolean goodToGo = true;
					Object[] fieldsToMatch = new Object[modelObject.values.size()];
					int i=0;
					for (Object value : modelObject.getValues()) {
						if (value != null) {
							if (value instanceof ModelObject) {
								if (!((ModelObject) value).isMatched()) {
									goodToGo = false;
									break;
								}
								fieldsToMatch[i] = ((ModelObject) value).getMatchedObject();
							} else if (value instanceof List) {
								ArrayList<ModelObject> li = new ArrayList<ModelObject>();
								for (Object v : (List<?>)value) {
									if (v instanceof ModelObject) {
										if (!((ModelObject) v).isMatched()) {
											goodToGo = false;
											break;
										}
										li.add(((ModelObject) v).getMatchedObject());
									}
								}
								if (!goodToGo) {
									break;
								}
								fieldsToMatch[i] = li;
							}
						}
						i++;
					}
					if (goodToGo) {
						for (ModelObject object : model2.getObjects()) {
							boolean add = true;
							for (int k=0; k<fieldsToMatch.length; k++) {
								Object fv = fieldsToMatch[k];
								Object value = object.getValue(k);
								if (value == fv || value.equals(fv)) {
								} else {
									add = false;
									break;
								}
							}
							if (add) {
								modelObject.setMatchedObject(object);
							}
						}
					}
				}
			}
			lastMatchedObjects = matchedObjects;
			matchedObjects = model1.getMatchedObjects().size();
		}
	}

	private void testValues(boolean ignoreIntZeroDollar, ModelObject modelObject) throws CompareException {
		int i = 0;
		for (Object value : modelObject.getValues()) {
			Object remoteValue = modelObject.getMatchedObject().getValue(i);
			processValue(ignoreIntZeroDollar, modelObject, value, remoteValue);
			i++;
		}
	}

	private void processValue(boolean ignoreIntZeroDollar, ModelObject modelObject, Object value, Object remoteValue) throws CompareException {
		if (value == null) {
			if (remoteValue != null) {
				if (ignoreIntZeroDollar && remoteValue.equals("0")) {
				} else {
					throw new CompareException("Remote value not null: " + remoteValue + " on " + modelObject.getMatchedObject());
				}
			}
		} else if (value instanceof String) {
			if (remoteValue instanceof String) {
				if (!remoteValue.equals(value)) {
					throw new CompareException("Values not the same: " + value + " / " + remoteValue + " on " + modelObject + " / " + modelObject.getMatchedObject());
				}
			} else {
				if (ignoreIntZeroDollar && value.equals("0")) {
					
				} else {
					throw new CompareException("Remote value not of type String: " + remoteValue + " / " + value);
				}
			}
		} else if (value instanceof ModelObject) {
			ModelObject valueObject = (ModelObject)value;
			if (remoteValue instanceof ModelObject) {
				ModelObject remoteValueObject = (ModelObject)remoteValue;
				if ((remoteValueObject).getType().equals(valueObject.getType())) {
					valueObject.setMatchedObject(remoteValueObject);
				} else {
					throw new CompareException("Objects not of same type: " + valueObject.getType() + " / " + remoteValueObject.getType());
				}
			} else {
				throw new CompareException("Remote object not a ModelObject");
			}
		} else if (value instanceof List) {
			List<?> valueList = (List<?>)value;
			if (remoteValue instanceof List) {
				List<?> remoteList = (List<?>)remoteValue;
				if (valueList.size() != remoteList.size()) {
					throw new CompareException("List sizes not equal: " + valueList.size() + " / " + remoteList.size());
				} else {
					int j=0;
					for (Object o1 : valueList) {
						Object o2 = remoteList.get(j);
						processValue(ignoreIntZeroDollar, modelObject, o1, o2);
						j++;
					}
				}
			} else {
				throw new CompareException("Remote value not of type list");
			}
		} else {
			throw new CompareException("Unimplemented type " + value.getClass().getName());
		}
	}
}