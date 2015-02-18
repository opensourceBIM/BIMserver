package org.bimserver.charting.Algorithms.StreamGraph;

/**
 * LastFMColorPicker
 * Loads in an image and uses it as a two-dimensional gradient
 * Supply two [0,1) numbers and get the color of the gradient at that point
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public class DefaultColorPicker implements ColorPicker {

	public DefaultColorPicker() {
	}

	public void colorize(Layer[] layers) {
		// find the largest layer to use as a normalizer
		float maxSum = 0;
		for (int i = 0; i < layers.length; i++) {
			maxSum = (float) Math.max(maxSum, layers[i].sum);
		}

		// find the color for each layer
		for (int i = 0; i < layers.length; i++) {
			float normalizedOnset = (float) layers[i].onset / layers[i].size.length;
			float normalizedSum = layers[i].sum / maxSum;
			float shapedSum = (float) (1.0 - Math.sqrt(normalizedSum));

			layers[i].rgb = get(normalizedOnset, shapedSum);
		}
	}

	protected int get(float g1, float g2) {
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
