package org.bimserver.charting.Algorithms.StreamGraph;

import java.util.Arrays;
import java.util.Comparator;

import org.bimserver.charting.Dimensions.ModelDimension;

public class BumpLayout extends LayerLayout {

	public static class LayerComparator implements Comparator<Layer> {

		public int Index = 0;
		public boolean Descending = true;

		public LayerComparator(int index, boolean descending) {
			this.Index = index;
			this.Descending = descending;
		}

		public int compare(Layer l1, Layer l2) {
			double a = l1.size[Index];
			double b = l2.size[Index];
			// Sort larger values to end of collection. Sort smaller values to start of collection.
			if (!Descending) {
				if (a < b)
					return 1;
				else if (a > b)
					return -1;
				else
					return 0;
			} else {
				if (a > b)
					return 1;
				else if (a < b)
					return -1;
				else
					return 0;
			}
		}
	}

	public static Comparator<Layer> byName = new Comparator<Layer>() {
		@Override
		public int compare(Layer l1, Layer l2) {
			String a = l1.name.toLowerCase();
			String b = l2.name.toLowerCase();
			return -1 * ModelDimension.compareNatural(a, b);
		}
	};

	public boolean normalize = false;
	public double padding = 0;
	public double screenTop = 0;
	public Boolean sortDescending = true;

	/**
	 * @param normalize
	 * @param padding
	 * @param screenTop
	 */
	public BumpLayout(String sort, boolean normalize, double padding, double screenTop) {
		super();
		if (sort.equals("value (descending)"))
			this.sortDescending = true;
		else if (sort.equals("value (ascending)"))
			this.sortDescending = false;
		else
			this.sortDescending = null;
		this.normalize = normalize;
		this.padding = padding;
		this.screenTop = screenTop;
	}

	public String getName() {
		return "Bump Layout";
	}

	public void layout(Layer[] layers) {
		// Set shape of baseline values.
		int n = layers[0].size.length;
		int m = layers.length;
		// Sort groups by name using a reversed natural sort.
		if (sortDescending == null)
			Arrays.sort(layers, byName);
		// First pass.
		for (int i = 0; i < n; i++) {
			// Sort values first.
			if (sortDescending != null) {
				Comparator<Layer> sortValuesAtPoint = new LayerComparator(i, sortDescending);
				Arrays.sort(layers, sortValuesAtPoint);
			}
			// Prepare to normalize the size value.
			float multiplier = 1;
			if (normalize)
				multiplier = 100f / (float) getVerticalSumAtLocation(layers, m, i);
			// Prepare to adjust the yTop value to be in data-space coordinates. 
			float y0 = 0;
			// Apply to all layers at this point. NOTE: Sorting is responsible for the bumping.
			for (int j = 0; j < m; j++) {
				layers[j].size[i] *= multiplier;
				layers[j].yTop[i] = y0;
				layers[j].yBottom[i] = y0 + layers[j].size[i];
				y0 += layers[j].size[i] + padding;
			}
		}
		// Second pass.
		for (int i = 0; i < n; i++) {
			// Sort values first.
			if (sortDescending != null) {
				Comparator<Layer> sortValuesAtPoint = new LayerComparator(i, sortDescending);
				Arrays.sort(layers, sortValuesAtPoint);
			}
			// Get sum at this point across all layers.
			float sum = (float) getVerticalSumAtLocation(layers, m, i);
			// Prepare to normalize the size value.
			float multiplier = 1f;
			if (normalize)
				multiplier = 100f / sum;
			// Prepare to adjust the yTop value to be in world-space coordinates. 
			float y0 = 0;
			if (!normalize)
				y0 = (float) (-sum / 2.0 + screenTop - padding * (m - 1) / 2.0);
			// Apply to all layers at this point. NOTE: Sorting is responsible for the bumping.
			for (int j = 0; j < m; j++) {
				layers[j].size[i] *= multiplier;
				layers[j].yTop[i] = y0;
				layers[j].yBottom[i] = y0 + layers[j].size[i];
				y0 += layers[j].size[i] + padding;
			}
		}
	}

	/**
	 * @param layers
	 * @param layerCount
	 * @param location
	 * @return
	 */
	public double getVerticalSumAtLocation(Layer[] layers, int layerCount, int location) {
		double sum = 0;
		// Sum all data in size at point.
		for (int i = 0; i < layerCount; i++)
			sum += layers[i].size[location];
		return sum;
	}
}
