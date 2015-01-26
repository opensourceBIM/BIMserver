package org.bimserver.charting.Algorithms.StreamGraph;

/**
 * ThemeRiverLayout
 * Layout used by the authors of the ThemeRiver paper
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public class ThemeRiverLayout extends LayerLayout {

	public String getName() {
		return "ThemeRiver";
	}

	public void layout(Layer[] layers) {
		// Set shape of baseline values.
		int n = layers[0].size.length;
		int m = layers.length;
		float[] baseline = new float[n];
		// ThemeRiver is perfectly symmetrical. The baseline is 1/2 of the total height at any point.
		for (int i = 0; i < n; i++) {
			baseline[i] = 0;
			for (int j = 0; j < m; j++)
				baseline[i] += layers[j].size[i];
			baseline[i] *= 0.5;
		}
		// Put layers on top of the baseline.
		stackOnBaseline(layers, baseline);
	}
}
