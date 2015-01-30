package org.bimserver.charting.Algorithms.StreamGraph;

import java.util.Arrays;

/**
 * StackLayout
 * Standard stacked graph layout, with a straight baseline
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public class StackLayout extends LayerLayout {

	public String getName() {
		return "Stacked Layout";
	}

	public void layout(Layer[] layers) {
		int n = 0;
		if (layers.length > 0)
			n = layers[0].size.length;
		// Lay out layers, top to bottom.
		float[] baseline = new float[n];
		Arrays.fill(baseline, 0);
		// Put layers on top of the baseline.
		stackOnBaseline(layers, baseline);
	}
}
