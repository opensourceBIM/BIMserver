package org.bimserver.tests.diff;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class DiffReader extends Thread {
	private File file;
	private Diff diff;
	private Map<String, Set<Model>> sizeMapped;
	private FullModel model;
	private List<Model> subModels;
	private CountDownLatch countDownLatch;
	private int id;

	public DiffReader(int id, Diff diff, CountDownLatch countDownLatch, File file) {
		this.id = id;
		this.diff = diff;
		this.countDownLatch = countDownLatch;
		this.file = file;
	}
	
	public void run() {
		try {
			model = new FullModel(diff, file);
			System.out.println("Done reading model " + id);
			subModels = new ArrayList<Model>(model.getSubModelsNew());
			System.out.println("Done splitting model " + id);
			Collections.sort(subModels, diff.modelComparator());
			System.out.println("Done sorting model " + id);
			sizeMapped = mapSize(subModels);
			System.out.println("Done mapping size model " + id);
		} catch (CompareException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}
	
	public Map<String, Set<Model>> mapSize(List<Model> models) {
		Map<String, Set<Model>> map = new HashMap<String, Set<Model>>();
		for (Model model : models) {
			if (map.containsKey(model.size() + "_" + model.nrEdges())) {
				map.get(model.size() + "_" + model.nrEdges()).add(model);
			} else {
				HashSet<Model> set = new HashSet<Model>();
				set.add(model);
				map.put(model.size() + "_" + model.nrEdges(), set);
			}
		}
		return map;
	}
	
	public Map<String, Set<Model>> getSizeMapped() {
		return sizeMapped;
	}
	
	public List<Model> getSubModels() {
		return subModels;
	}
	
	public FullModel getModel() {
		return model;
	}
}
