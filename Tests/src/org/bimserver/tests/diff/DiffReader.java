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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class DiffReader extends Thread {
	private Path file;
	private Diff diff;
	private Map<String, Set<Model>> sizeMapped;
	private FullModel model;
	private List<Model> subModels;
	private CountDownLatch countDownLatch;
	private int id;

	public DiffReader(int id, Diff diff, CountDownLatch countDownLatch, Path file) {
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
