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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.tests.GuidCompressor;
import org.bimserver.utils.StringUtils;

public class ModelObject {
	private final Diff diff;
	private Model model;
	private long id = -1;
	private String type;
	private final List<Object> values = new ArrayList<Object>();
	private ModelObject matchedObject;
	
	//TODO: References to/from should not be sets! There can and will be multiple references to/from the same object!
	private final Set<ModelObject> referencesTo = new HashSet<ModelObject>();
	private final Set<ModelObject> referencesFrom = new HashSet<ModelObject>();
	private String guid;

	public ModelObject(Diff diff, FullModel model, String line) {
		this.diff = diff;
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
			if (this.diff.getGuidPositions().contains(getType() + "_" + index)) {
				setGuid(GuidCompressor.uncompressGuidString(str));
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

	public long getId() {
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

	public void setModel(Model model) {
		this.model = model;
	}
}