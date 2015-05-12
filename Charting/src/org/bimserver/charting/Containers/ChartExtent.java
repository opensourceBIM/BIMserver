package org.bimserver.charting.Containers;

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

public class ChartExtent {

	public Double Lower = null;
	public Double Upper = null;
	public boolean LowerBoundIsZero = false;
	// The scale of this data in some other context. By default, it's a standard percentage from 0..1.
	public double WorldSpaceStart = 0;
	public double WorldSpaceEnd = 1;
	// If world-space values are not explicitly supplied to world-space translation methods, this value will be used to auto-generate values.
	public double DefaultTickCount = 10;
	// Tell other objects the data should be cast as java.util.Date, treating it as a the milliseconds from January 1, 1970 00:00:00.
	public boolean ShouldFormatAsDate = false; 

	/**
	 * @return the defaultTickCount
	 */
	public double getDefaultTickCount() {
		return DefaultTickCount;
	}

	/**
	 * @param defaultTickCount the defaultTickCount to set
	 */
	public void setDefaultTickCount(double defaultTickCount) {
		DefaultTickCount = defaultTickCount;
	}

	/**
	 * @return the lower
	 */
	public double getLower() {
		return (LowerBoundIsZero || Lower == null) ? 0 : Lower;
	}

	/**
	 * @param lower the lower to set
	 */
	public void setLower(Double lower) {
		Lower = lower;
	}

	/**
	 * @return the upper
	 */
	public Double getUpper() {
		return Upper;
	}

	/**
	 * @param upper the upper to set
	 */
	public void setUpper(Double upper) {
		Upper = upper;
	}

	public boolean isValid()
	{
		Double lower = getLower();
		Double upper = getUpper();
		return (lower != null && upper != null);
	}

	public ChartExtent() {
		super();
		// Prepare to include values (on a single input basis).
		Lower = null;
		Upper = null;
	}

	public void includeValue(Double value) {
		if (Lower == null || Lower > value)
			Lower = value;
		if (Upper == null || Upper < value)
			Upper = value;
	}

	/**
	 * Container for lower and upper double values.
	 *
	 * @param lower
	 * @param upper
	 * @param lowerBoundIsZero
	 */
	public ChartExtent(Double lower, Double upper, boolean lowerBoundIsZero) {
		super();
		// Set lower and upper values explicitly.
		this.Lower = lower;
		this.Upper = upper;
		this.LowerBoundIsZero = lowerBoundIsZero;
	}

	/**
	 * Integer to Double conversion.
	 *
	 * @param lower
	 * @param upper
	 * @param lowerBoundIsZero
	 */
	public ChartExtent(Integer lower, Integer upper, boolean lowerBoundIsZero) {
		super();
		// Set lower and upper values explicitly.
		this.Lower = (double)lower;
		this.Upper = (double)upper;
		this.LowerBoundIsZero = lowerBoundIsZero;
	}

	/**
	 * Double sequence-based constructor meant to yield a lower and an upper value.
	 *
	 * @param args
	 */
	public ChartExtent(boolean lowerBoundIsZero, Double[] args) {
		super();
		for (Double arg : args) {
			if (Lower == null || Lower > arg)
				Lower = arg;
			if (Upper == null || Upper < arg)
				Upper = arg;
		}
		this.LowerBoundIsZero = lowerBoundIsZero;
	}

	/**
	 * Integer sequence-based constructor meant to yield a lower and an upper value.
	 *
	 * @param args
	 */
	public ChartExtent(boolean lowerBoundIsZero, Integer[] args) {
		super();
		for (Integer arg : args) {
			if (Lower == null || Lower > arg)
				Lower = (double)arg;
			if (Upper == null || Upper < arg)
				Upper = (double)arg;
		}
		this.LowerBoundIsZero = lowerBoundIsZero;
	}

	/**
	 * Number sequence-based constructor meant to yield a lower and an upper value. WARN: Do not use with BigInteger, because equivalence is not exact.
	 *
	 * @param args
	 */
	public ChartExtent(boolean lowerBoundIsZero, ArrayList<Number> args) {
		super();
		for (Number arg : args) {
			Double thisArg = arg.doubleValue();
			if (Lower == null || Lower > thisArg)
				Lower = thisArg;
			if (Upper == null || Upper < thisArg)
				Upper = thisArg;
		}
		this.LowerBoundIsZero = lowerBoundIsZero;
	}

	/**
	 * Number sequence-based constructor meant to yield a lower and an upper value. WARN: Do not use with BigInteger, because equivalence is not exact.
	 *
	 * @param args
	 */
	public ChartExtent(boolean lowerBoundIsZero, boolean shouldFormatAsDate, ArrayList<Number> args) {
		this(lowerBoundIsZero, args);
		this.ShouldFormatAsDate = shouldFormatAsDate;
	}

	/**
	 * @param lower
	 * @param upper
	 * @param worldSpaceStart
	 * @param worldSpaceEnd
	 */
	public ChartExtent(Double lower, Double upper, double worldSpaceStart, double worldSpaceEnd) {
		super();
		Lower = lower;
		Upper = upper;
		WorldSpaceStart = worldSpaceStart;
		WorldSpaceEnd = worldSpaceEnd;
	}

	/**
	 * Set the context these values exist in. Default is 0..1. Expected replacements are something like 23..980.
	 *
	 * @param start
	 * @param end
	 */
	public void setWorldSpace(double start, double end) {
		WorldSpaceStart = start;
		WorldSpaceEnd = end;
	}

	/**
	 * @return
	 */
	public ArrayList<Double> getWorldSpaceValuesFromDefaultTickValue() {
		// Prepare a place to store the world-space values.
		ArrayList<Double> worldSpaceValuesList = new ArrayList<Double>();
		// If there are enough ticks to break the range into values, figure out the walking distance per step. Then, use it.
		if (DefaultTickCount >= 2) {
			// Calculate the walking distance.
			double advance = (WorldSpaceEnd - WorldSpaceStart) / Math.max(1, DefaultTickCount - 1);
			// Use the walking distance to step along with the iteration.
			for (int i = 0; i < DefaultTickCount; i++)
				worldSpaceValuesList.add(WorldSpaceStart + i * advance);
		}
		// Send the world-space values back.
		return worldSpaceValuesList;
	}

	/**
	 * Use a world space value (like a location, specified in pixels), to calculate a percentage to be used to obtain a corresponding real value (in range of lower to upper).
	 *
	 * @param worldSpaceValue
	 * @return
	 */
	public double getLinearValueAtXGivenWorldSpaceValue(final double worldSpaceValue, boolean reverseTransformedDataOrder) {
		ArrayList<Double> wrappedValue = new ArrayList<Double>() {{
			add((Double)worldSpaceValue);
		}};
		Double[] list = getLinearScheduleGivenWorldSpaceValues(wrappedValue, reverseTransformedDataOrder);
		// Obtain a value in range of lower to upper given a value in range of the stored start to end values.
		return (list.length >= 1) ? list[0] : getLower();
	}

	/**
	 * Use a world space value (like a location, specified in pixels), to calculate a percentage to be used to obtain a corresponding real value (in range of lower to upper). Convenience method.
	 *
	 * @param worldSpaceValue
	 * @return
	 */
	public double getLinearValueAtXGivenWorldSpaceValue(final double worldSpaceValue) {
		return getLinearValueAtXGivenWorldSpaceValue(worldSpaceValue, false);
	}

	/**
	 * Get the default linear scale, using the default tick count to subdivide this range and the world space range.
	 *
	 * @param reverseTransformedDataOrder
	 * @return
	 */
	public Double[] getLinearSchedule(boolean reverseTransformedDataOrder) {
		ArrayList<Double> worldSpaceValues = getWorldSpaceValuesFromDefaultTickValue();
		return getLinearScheduleGivenWorldSpaceValues(worldSpaceValues, reverseTransformedDataOrder);
	}

	/**
	 * Get the default linear scale, using the default tick count to subdivide this range and the world space range. Convenience method.
	 *
	 * @return
	 */
	public Double[] getLinearSchedule() {
		return getLinearSchedule(false);
	}

	public ArrayList<Pair<Double, Double>> getWorldSpaceToActualValuePairsLinearSchedule() {
		return getWorldSpaceToActualValuePairsLinearSchedule(false);
	}

	/**
	 * Get sets of data in the form Pair(world space value, actual value), representing the translation between the world space and actual values.
	 *
	 * @param reverseTransformedDataOrder
	 * @return
	 */
	public ArrayList<Pair<Double, Double>> getWorldSpaceToActualValuePairsLinearSchedule(boolean reverseTransformedDataOrder) {
		// Get world-space values.
		ArrayList<Double> worldSpaceValuesList = getWorldSpaceValuesFromDefaultTickValue();
		Double[] worldSpaceValues = worldSpaceValuesList.toArray(new Double[worldSpaceValuesList.size()]);
		// Translate the world-space values into actual values.
		Double[] valuesInNonWorldRange = getLinearScheduleGivenWorldSpaceValues(worldSpaceValuesList, reverseTransformedDataOrder);
		// Pair the two values up so that they can be used to draw an axis. 
		ArrayList<Pair<Double, Double>> list = new ArrayList<Pair<Double, Double>>();
		if (worldSpaceValues.length == valuesInNonWorldRange.length)
			for (int i = 0; i < valuesInNonWorldRange.length; i++)
				list.add(new Pair<Double, Double>(worldSpaceValues[i], valuesInNonWorldRange[i]));
		// Return the list.
		return list;
	}

	/**
	 * Use a series of world space values (like locations, specified in pixels), to calculate percentages to be used to obtain corresponding real values (in range of lower to upper).
	 *
	 * @param worldSpaceValues
	 * @param reverseTransformedDataOrder
	 * @return
	 */
	public Double[] getLinearScheduleGivenWorldSpaceValues(ArrayList<Double> worldSpaceValues, boolean reverseTransformedDataOrder) {
		ArrayList<Double> list = new ArrayList<>();
		// Get this range (distance between lower and upper).
		double thisRange = getDelta();
		// If the distance is non-trivial, calculate where the world value would fall in this range.
		if (thisRange != 0) {
			// Get the world range.
			double worldRange = getWorldSpaceDelta();
			// If the distance in the world is non-trivial, calculate where the world value would fall in this range.
			if (worldRange != 0) {
				// Get the lower value in this range.
				double lower = getLower();
				// Iterate the world space values, transforming them to values in this range.
				for (Double value : worldSpaceValues) {
					double linearPercent = (value - WorldSpaceStart) / worldRange;
					// Reverse if requested.
					if (reverseTransformedDataOrder)
						linearPercent = 1.0 - linearPercent;
					// Obtain a value in range of lower to upper given a value in range of the stored start to end values.
					double linearlyInterploatedValue = lower + linearPercent * thisRange;
					// Add the value.
					list.add(linearlyInterploatedValue);
				}
			}
		}
		// Return an array of double values.
		return list.toArray(new Double[list.size()]);
	}

	/**
	 * @return
	 */
	public double getDelta() {
		if (isValid())
		{
			// Get values. Includes check for zero as lower bound.
			double lower = getLower();
			double upper = getUpper();
			// Derive the range.
			double range = upper - lower;
			// Send it back.
			return range;
		} else
			return 0;
	}

	/**
	 * @return
	 */
	public double getWorldSpaceDelta() {
		return WorldSpaceEnd - WorldSpaceStart;
	}

	/**
	 * Use an actual value (like a raw data position), to calculate a percentage to be used to obtain a corresponding world-space value.
	 *
	 * @param actualValue
	 * @return
	 */
	public double getLinearWorldSpaceValueAtXGivenActualValue(final double actualValue) {
		return getLinearWorldSpaceValueAtXGivenActualValue(actualValue, false);
	}

	/**
	 * Use an actual value (like a raw data position), to calculate a percentage to be used to obtain a corresponding world-space value.
	 *
	 * @param actualValue
	 * @return
	 */
	public double getLinearWorldSpaceValueAtXGivenActualValue(final double actualValue, boolean reverseTransformedDataOrder) {
		ArrayList<Double> wrappedValue = new ArrayList<Double>() {{
			add((Double)actualValue);
		}};
		Double[] list = getLinearWorldSpaceScheduleGivenActualValues(wrappedValue, reverseTransformedDataOrder);
		// Obtain a value in range of start to end given a value in range of the stored lower to upper values.
		return (list.length >= 1) ? list[0] : WorldSpaceStart;
	}

	/**
	 * Use a series of actual values (like raw data positions), to calculate percentages to be used to obtain corresponding world-space values.
	 *
	 * @param actualValues
	 * @param reverseTransformedDataOrder
	 * @return
	 */
	public Double[] getLinearWorldSpaceScheduleGivenActualValues(ArrayList<Double> actualValues, boolean reverseTransformedDataOrder) {
		
		ArrayList<Double> list = new ArrayList<>();
		// Get the world range.
		double worldRange = getWorldSpaceDelta();
		// If the distance is non-trivial, calculate where the world value would fall in this range.
		if (worldRange != 0) {
			// Get this range (distance between lower and upper).
			double thisRange = getDelta();
			// If the distance in the world is non-trivial, calculate where the world value would fall in this range.
			if (thisRange != 0) {
				// Get the lower value in this range.
				double lower = getLower();
				// Iterate the world space values, transforming them to values in this range.
				for (Double value : actualValues) {
					double linearPercent = (value - lower) / thisRange;
					// Reverse if requested.
					if (reverseTransformedDataOrder)
						linearPercent = 1.0 - linearPercent;
					// Obtain a value in range of start to end given a value in range of the stored lower to upper values.
					double linearlyInterploatedValue = WorldSpaceStart + linearPercent * worldRange;
					// Add the value.
					list.add(linearlyInterploatedValue);
				}
			}
		}
		// Return an array of double values.
		return list.toArray(new Double[list.size()]);
	}
}
