package org.bimserver.charting.Algorithms.StreamGraph;

/**
 * LayerSort
 * Interface to sorting layers
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public abstract class LayerSort {

	abstract String getName();

	public abstract Layer[] sort(Layer[] layers);

	/**
	 * Creates a 'top' and 'bottom' collection.
	 * Iterating through the previously sorted list of layers, place each layer
	 * in whichever collection has less total mass, arriving at an evenly
	 * weighted graph. Reassemble such that the layers that appeared earliest
	 * end up in the 'center' of the graph.
	 */
	protected Layer[] orderToOutside(Layer[] layers) {
		int j = 0;
		int n = layers.length;
		Layer[] newLayers = new Layer[n];
		int topCount = 0;
		float topSum = 0;
		int[] topList = new int[n];
		int botCount = 0;
		float botSum = 0;
		int[] botList = new int[n];

		// partition to top or bottom containers
		for (int i = 0; i < n; i++) {
			if (topSum < botSum) {
				topList[topCount++] = i;
				topSum += layers[i].sum;
			} else {
				botList[botCount++] = i;
				botSum += layers[i].sum;
			}
		}

		// reassemble into single array
		for (int i = botCount - 1; i >= 0; i--) {
			newLayers[j++] = layers[botList[i]];
		}
		for (int i = 0; i < topCount; i++) {
			newLayers[j++] = layers[topList[i]];
		}

		return newLayers;
	}
}
