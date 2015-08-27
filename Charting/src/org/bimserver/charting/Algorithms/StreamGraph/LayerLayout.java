package org.bimserver.charting.Algorithms.StreamGraph;


/**
 * LayerLayout
 * Abstract Class for new stacked graph layout algorithms
 *
 * Note: you do not need to worry about scaling to screen dimensions.
 * The display applet will do that automatically for you.
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public abstract class LayerLayout {

	public abstract void layout(Layer[] layers);

	abstract String getName();

	/**
	 * We define our stacked graphs by layers atop a baseline.
	 * This method does the work of assigning the positions of each layer in an
	 * ordered array of layers based on an initial baseline.
	 */
	protected void stackOnBaseline(Layer[] layers, float[] baseline) {
		// Put layers on top of the baseline.
		for (int i = 0; i < layers.length; i++) {
			System.arraycopy(baseline, 0, layers[i].yBottom, 0, baseline.length);
			for (int j = 0; j < baseline.length; j++) {
				baseline[j] -= layers[i].size[j];
			}
			System.arraycopy(baseline, 0, layers[i].yTop, 0, baseline.length);
		}
	}
}
