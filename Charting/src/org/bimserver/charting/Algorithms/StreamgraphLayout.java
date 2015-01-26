package org.bimserver.charting.Algorithms;

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
import java.util.Arrays;

import org.bimserver.charting.Algorithms.StreamGraph.BasicLateOnsetSort;
import org.bimserver.charting.Algorithms.StreamGraph.DataSource;
import org.bimserver.charting.Algorithms.StreamGraph.LateOnsetSort;
import org.bimserver.charting.Algorithms.StreamGraph.Layer;
import org.bimserver.charting.Algorithms.StreamGraph.LayerLayout;
import org.bimserver.charting.Algorithms.StreamGraph.LayerSort;
import org.bimserver.charting.Algorithms.StreamGraph.StackLayout;
import org.bimserver.charting.Containers.ChartExtent;
import org.openmali.vecmath2.Vector2d;

public class StreamgraphLayout {

	LayerLayout layout = new StackLayout();
	LayerSort ordering = new LateOnsetSort();

	public Layer[] layers = new Layer[0];
	public boolean onlyProcessOnsetToEndPoints = false;
	public boolean expandValuesAboveBaseLine = false;
	public boolean normalize = false;

	public double left = 0;
	public double top = 0;
	public double bottom = 1000;
	public double right = 1000;
	public double paddingBetweenLines = 0;

	public ChartExtent xExtent = new ChartExtent(0.0, 1.0, 0.0, right);
	public ChartExtent sizeExtent = new ChartExtent(0.0, 1.0, 0.0, bottom);

	/**
	 * @param width
	 * @param height
	 */
	public StreamgraphLayout(double width, double height) {
		super();
		this.bottom = height;
		this.right = width;
		//
		setup();
	}

	public StreamgraphLayout(DataSource data, double width, double height) {
		this(data.make(), width, height);
	}

	public StreamgraphLayout(Layer[] layers, double width, double height) {
		super();
		this.layers = layers;
		this.bottom = height;
		this.right = width;
		//
		setup();
	}

	public StreamgraphLayout(LayerLayout layout, DataSource data, boolean normalize, boolean expandValuesAboveBaseLine, double padding, double left, double top, double width, double height) {
		this(layout, data.make(), normalize, expandValuesAboveBaseLine, padding, left, top, width, height);
	}

	public StreamgraphLayout(LayerLayout layout, Layer[] layers, boolean normalize, boolean expandValuesAboveBaseLine, double padding, double left, double top, double width, double height) {
		super();
		this.layout = layout;
		this.layers = layers;
		this.normalize = normalize;
		this.expandValuesAboveBaseLine = expandValuesAboveBaseLine;
		this.paddingBetweenLines = padding;
		this.left = left;
		this.top = top;
		this.right = width;
		this.bottom = height;
		//
		setup();
	}

	void setup() {
		xExtent = new ChartExtent(0.0, (double) (layers[0].size.length - 1), left, right);
		xExtent.DefaultTickCount = 11;
		//
		sizeExtent.setWorldSpace(top, bottom);
		ordering = new BasicLateOnsetSort();
		// Generate graph.
		layers = ordering.sort(layers);
		//
		layout.layout(layers);
		//
		calculateSizeExtent(top, bottom);
		// Destructively fit graph to viewport.
		scaleLayers();
	}

	public void layout() {
		int n = layers.length;
		int m = layers[0].size.length;
		int lastLayer = n - 1;
		// Clear graph.
		for (int i = 0; i < n; i++)
			layers[i].points.clear();
		// Generate graph.
		generateNonEdgePoints(n, m, lastLayer);
		// Tweak graph appearance.
		if (expandValuesAboveBaseLine)
			expandAboveBaseline(n, m);
		// Draw edge.
		generateEdgePoints(n, m);
	}

	/**
	 * @param n
	 * @param m
	 */
	public void generateEdgePoints(int n, int m) {
		int start;
		int end;
		for (int i = 0; i < n; i++) {
			start = onlyProcessOnsetToEndPoints ? Math.max(0, layers[i].onset - 1) : 0;
			end = onlyProcessOnsetToEndPoints ? Math.min(m - 1, layers[i].end) : m - 1;
			//
			ArrayList<Vector2d> layerPoints = layers[i].points;
			// Draw bottom edge, right to left.
			for (int j = end; j >= start; j--)
				getVertex(j, layers[i].yBottom, layerPoints, false);
		}
	}

	/**
	 * @param n
	 * @param m
	 * @param lastLayer
	 */
	public void generateNonEdgePoints(int n, int m, int lastLayer) {
		int start;
		int end;
		for (int i = 0; i < n; i++) {
			boolean isLastLayer = i == lastLayer;
			start = onlyProcessOnsetToEndPoints ? Math.max(0, layers[i].onset - 1) : 0;
			end = onlyProcessOnsetToEndPoints ? Math.min(m - 1, layers[i].end) : m - 1;
			//
			ArrayList<Vector2d> layerPoints = layers[i].points;
			// Draw top edge, left to right.
			for (int j = start; j <= end; j++)
				getVertex(j, layers[i].yTop, layerPoints, isLastLayer);
		}
	}

	/**
	 * Push upper edge (yTop) to be flatly along the upper axis.
	 * @param n
	 * @param m
	 */
	public void expandAboveBaseline(int n, int m) {
		// Expand.
		double k = 1 / (double) n;
		int i = 0;
		double o = 0;
		// d3: layers[i].points.get(j).y() == data[i][j][1]
		for (int j = 0; j < m; j++) {
			// Sum y values across layers for given point in time, j.
			for (i = 0, o = 0; i < n; i++)
				if (j < layers[i].points.size())
					o += layers[i].points.get(j).y();
			// If sum is not zero, rewrite y values at some time, j, to be a percent of the sum.
			if (o != 0)
				for (i = 0; i < n; i++)
					if (j < layers[i].points.size())
						layers[i].points.get(j).y(layers[i].points.get(j).y() / o);
			// Otherwise, rewrite y values at some time, j, to be n^-1 (a percent of the number of layers).
			else
				for (i = 0; i < n; i++)
					if (j < layers[i].points.size())
						layers[i].points.get(j).y(k);
		}
		// d3: layers[i].yTop[j] == y0[j] 
		// Go through each layer, zeroing the upper component so that there is a flat line across the top of the graph.
		for (i = 0; i < n; i++) {
			// Zero the upper component.
			float[] zeroed = new float[layers[i].yTop.length];
			Arrays.fill(zeroed, (float)top);
			layers[i].yTop = zeroed;
			// Zero the world-space data point.
			for (int j = 0; j < layers[i].points.size(); j++) {
				double y = layers[i].points.get(j).y();
				layers[i].points.get(j).y(Math.max(sizeExtent.WorldSpaceStart, y));
			}
		}
	}

	void getVertex(int point, float[] source, ArrayList<Vector2d> layerPoints, boolean pxl) {
		// Replaces: map(point, 0, layerSize - 1, 0, width);
		double x = xExtent.getLinearWorldSpaceValueAtXGivenActualValue((double) point, false);
		double y = source[point] - (pxl ? 1 : 0);
		layerPoints.add(new Vector2d(x, y));
	}

	void calculateSizeExtent(double screenTop, double screenBottom) {
		sizeExtent = new ChartExtent();
		sizeExtent.DefaultTickCount = 2;
		sizeExtent.setWorldSpace(screenTop, screenBottom);
		// Figure out max and min values of layers.
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < layers[0].size.length; i++) {
			for (int j = 0; j < layers.length; j++) {
				min = Math.min(min, layers[j].yTop[i]);
				max = Math.max(max, layers[j].yBottom[i]);
			}
		}
		sizeExtent.setLower(min);
		sizeExtent.setUpper(max);
	}

	/**
	 * @param layerCount
	 * @param location
	 * @return
	 */
	public double getVerticalSumAtLocation(int layerCount, int location) {
		double sum = 0;
		// Sum all data in size at point.
		for (int i = 0; i < layerCount; i++)
			sum += layers[i].size[location];
		return sum;
	}

	void scaleLayers() {
		double screenTop = sizeExtent.WorldSpaceStart;
		double screenBottom = sizeExtent.WorldSpaceEnd;
		int n = layers[0].size.length;
		int m = layers.length;
		// Figure out max and min values of layers.
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				min = Math.min(min, layers[j].yTop[i]);
				max = Math.max(max, layers[j].yBottom[i]);
			}
		}
		double heightInScreenCoordinates = screenBottom - screenTop;
		double heightInDataCoordinates = Math.max(1.0, max - min);
		// Destructive rescaling of yTop and yBottom values.
		double scale = heightInScreenCoordinates / heightInDataCoordinates;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				layers[j].yTop[i] = (float)(screenTop + scale * (layers[j].yTop[i] - min));
				layers[j].yBottom[i] = (float)(screenTop + scale * (layers[j].yBottom[i] - min));
			}
		}
	}

	public Vector2d getTextOffset(int layerIndex) {
		Vector2d worldSpaceLocation = new Vector2d(xExtent.WorldSpaceStart, sizeExtent.WorldSpaceStart);
		//
		int layerCount = layers.length;
		if (layerIndex < layerCount) {
			Layer layer = layers[layerIndex];
			Integer pointOfMax = layer.pointOfMax;
			// Get X.
			double horizontalOffset = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(pointOfMax);
			// Get Y, bounded by next layer.
			int nextLayer = layerIndex + 1;
			double verticalTop = layer.yTop[pointOfMax];
			if (nextLayer < layerCount)
				verticalTop = Math.max(verticalTop, layers[nextLayer].yBottom[pointOfMax]);
			double verticalOffset = verticalTop + (layer.yBottom[pointOfMax] - verticalTop) / 2.0;
			// Set location.
			worldSpaceLocation = new Vector2d(horizontalOffset, verticalOffset);
		}
		return worldSpaceLocation;
	}

	public double getDistanceConsumedAtMax(double minimumDistance, int layerIndex) {
		double distance = 0.0;
		//
		int layerCount = layers.length;
		if (layerIndex < layerCount) {
			Layer layer = layers[layerIndex];
			Integer pointOfMax = layer.pointOfMax;
			for (int i = 0; i < pointOfMax; i++) {
				int p = i + 1;
				double x1 = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(i);
				double y1 = (layer.yTop[i] + layer.yBottom[i]) / 2.0;
				double x2 = xExtent.getLinearWorldSpaceValueAtXGivenActualValue(p);
				double y2 = (layer.yTop[p] + layer.yBottom[p]) / 2.0;
				// d = (a^2 + b^2)^(-0.5)
				distance += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			}
			distance = Math.max(distance, minimumDistance);
		}
		return distance;
	}
}