package org.bimserver.charting.Algorithms.StreamGraph;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.ArrayList;

import org.bimserver.charting.Containers.TreeNode;

public class TreeNodeDataSource implements DataSource {

	public TreeNode Root = null;

	public TreeNodeDataSource(TreeNode root) {
		super();
		Root = root;
	}

	@Override
	public Layer[] make() {
		ArrayList<Layer> layers = new ArrayList<>(); 
		for (TreeNode subChartNode : Root.Children) {
			int childCount = subChartNode.Children.length;
			float[] data = new float[childCount];
			int i = 0;
			for (TreeNode dataPoint : subChartNode.Children) {
				data[i] = dataPoint.Size.floatValue();
				i++;
			}
			Layer layer = new Layer(subChartNode.Name, data);
			layers.add(layer);
		}
		if (layers.size() == 0)
			layers.add(new Layer("Empty", new float[] {0f, 0f, 0f, 0f, 0f, 0f, 0f}));
		return layers.toArray(new Layer[layers.size()]);
	}
}
