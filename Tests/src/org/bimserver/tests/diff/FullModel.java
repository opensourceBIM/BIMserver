package org.bimserver.tests.diff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FullModel extends AbstractModel {
	private final Diff diff;
	private Set<Model> subModels;

	public FullModel(Diff diff) {
		this.diff = diff;
	}
	
	public FullModel(Diff diff, File file) throws CompareException {
		this.diff = diff;
		System.out.println("Reading model " + file.getName());
		try {
			FileReader in = new FileReader(file);
			BufferedReader reader = new BufferedReader(in);
			String line = reader.readLine();
			while (line != null) {
				ModelObject modelObject = new ModelObject(this.diff, this, line.trim());
				if (modelObject.getId() != -1) {
					add(modelObject);
				}
				line = reader.readLine();
			}
			reader.close();
			in = new FileReader(file);
			reader = new BufferedReader(in);
			try {
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
			} finally {
				reader.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Set<Model> getSubModelsOld() {
		if (subModels == null) {
			subModels = new HashSet<Model>();
			Iterator<? extends ModelObject> iterator = getObjects().iterator();
			while (iterator.hasNext()) {
				ModelObject modelObject = iterator.next();
				if (subModels.isEmpty()) {
					SubModel subModel = new SubModel(this);
					subModels.add(subModel);
					addAll(modelObject, subModel);
				} else {
					boolean found = false;
					for (Model m : subModels) {
						if (m.contains(modelObject)) {
							found = true;
							break;
						}
					}
					if (!found) {
						SubModel subModel = new SubModel(this);
						subModels.add(subModel);
						addAll(modelObject, subModel);
					}
				}
			}
			for (Model subModel : subModels) {
				subModel.indexGuids();
			}
		}
		return subModels;
	}
	
	public Set<Model> getSubModelsNew() {
		if (subModels == null) {
			subModels = new HashSet<Model>();
			Set<ModelObject> unplaced = new HashSet<ModelObject>(getObjects());
			while (!unplaced.isEmpty()) {
				ModelObject firstUnlabelled = unplaced.iterator().next();
				SubModel subModel = new SubModel(this);
				Set<ModelObject> todo = new HashSet<ModelObject>();
				todo.add(firstUnlabelled);
				while (!todo.isEmpty()) {
					System.out.println(unplaced.size() + " " + subModels.size());
					Iterator<ModelObject> iterator = todo.iterator();
					ModelObject item = iterator.next();
					iterator.remove();
					floodFill(subModel, item, unplaced, todo);
				}
				subModels.add(subModel);
			}
		}
		return subModels;
	}

	private void floodFill(SubModel subModel, ModelObject firstUnlabelled, Set<ModelObject> unplaced, Set<ModelObject> todo) {
		subModel.add(firstUnlabelled);
		unplaced.remove(firstUnlabelled);
		for (ModelObject object : firstUnlabelled.getReferencesTo()) {
			if (!subModel.contains(object)) {
				if (!todo.contains(object)) {
					todo.add(object);
				}
			}
		}
		for (ModelObject object : firstUnlabelled.getReferencesFrom()) {
			if (!subModel.contains(object)) {
				if (!todo.contains(object)) {
					todo.add(object);
				}
			}
		}
	}

	private void addAll(ModelObject modelObject, Model model) {
		if (!model.contains(modelObject)) {
			model.add(modelObject);
			modelObject.setModel(model);
			for (ModelObject refFrom : modelObject.getReferencesFrom()) {
				addAll(refFrom, model);
			}
			for (ModelObject refTo : modelObject.getReferencesTo()) {
				addAll(refTo, model);
			}
		}
	}
}