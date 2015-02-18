package org.bimserver.charting.Algorithms.StreamGraph;

/**
 * MinimizedWiggleLayout
 * Minimizes the sum of squares of the layer slopes at each value
 *
 * We present this as a reasonable alternative to the Stream Graph for
 * real-time use. While it has some drawbacks compared to StreamLayout, it is
 * much faster to execute and is reasonable for real-time applications.
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public class MinimizedWiggleLayout extends LayerLayout {

	public String getName() {
		return "Minimized Wiggle Layout";
	}

	public void layout(Layer[] layers) {
		int n = layers[0].size.length;
		int m = layers.length;
		float[] baseline = new float[n];

		// Set shape of baseline values.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				baseline[i] += (m - j - 0.5) * layers[j].size[i];
			}
			baseline[i] /= m;
		}

		// Put layers on top of the baseline.
		stackOnBaseline(layers, baseline);
	}
}
