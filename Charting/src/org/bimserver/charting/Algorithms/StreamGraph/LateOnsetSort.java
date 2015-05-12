package org.bimserver.charting.Algorithms.StreamGraph;

import java.util.Arrays;

/**
 * LateOnsetSort
 * Sorts by onset, and orders to the outsides of the graph.
 *
 * This is the sort technique preferred when using late-onset data, which the
 * Streamgraph technique is best suited to represent
 *
 * @author Lee Byron
 * @author Martin Wattenberg
 */
public class LateOnsetSort extends LayerSort {

	public String getName() {
		return "Late Onset Sorting, Evenly Weighted";
	}

	public Layer[] sort(Layer[] layers) {
		// first sort by onset
		Arrays.sort(layers, new OnsetComparator(true));

		return orderToOutside(layers);
	}
}
