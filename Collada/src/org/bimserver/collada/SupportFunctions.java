package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.geometry.Matrix;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.store.SIPrefix;
import org.eclipse.emf.common.util.EList;

public class SupportFunctions {
	public static SIPrefix getLengthUnitPrefix(IfcModelInterface model) {
		SIPrefix lengthUnitPrefix = null;
		boolean prefixFound = false;
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				if (unitsInContext != null) {
					EList<IfcUnit> units = unitsInContext.getUnits();
					for (IfcUnit unit : units) {
						if (unit instanceof IfcSIUnit) {
							IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
							IfcUnitEnum unitType = ifcSIUnit.getUnitType();
							if (unitType == IfcUnitEnum.LENGTHUNIT) {
								prefixFound = true;
								switch (ifcSIUnit.getPrefix()) {
								case EXA:
									lengthUnitPrefix = SIPrefix.EXAMETER;
									break;
								case PETA:
									lengthUnitPrefix = SIPrefix.PETAMETER;
									break;
								case TERA:
									lengthUnitPrefix = SIPrefix.TERAMETER;
									break;
								case GIGA:
									lengthUnitPrefix = SIPrefix.GIGAMETER;
									break;
								case MEGA:
									lengthUnitPrefix = SIPrefix.MEGAMETER;
									break;
								case KILO:
									lengthUnitPrefix = SIPrefix.KILOMETER;
									break;
								case HECTO:
									lengthUnitPrefix = SIPrefix.HECTOMETER;
									break;
								case DECA:
									lengthUnitPrefix = SIPrefix.DECAMETER;
									break;
								case DECI:
									lengthUnitPrefix = SIPrefix.DECIMETER;
									break;
								case CENTI:
									lengthUnitPrefix = SIPrefix.CENTIMETER;
									break;
								case MILLI:
									lengthUnitPrefix = SIPrefix.MILLIMETER;
									break;
								case MICRO:
									lengthUnitPrefix = SIPrefix.MICROMETER;
									break;
								case NANO:
									lengthUnitPrefix = SIPrefix.NANOMETER;
									break;
								case PICO:
									lengthUnitPrefix = SIPrefix.PICOMETER;
									break;
								case FEMTO:
									lengthUnitPrefix = SIPrefix.FEMTOMETER;
									break;
								case ATTO:
									lengthUnitPrefix = SIPrefix.ATTOMETER;
									break;
								case NULL:
									lengthUnitPrefix = SIPrefix.METER;
									break;
								}
								break;
							}
						}
					}
				}
			}
			if (prefixFound)
				break;
		}
		return lengthUnitPrefix;
	}

	/*
	 * Convenience methods for handling raw data (usually in buffers).
	 */
	public static String doubleBufferToFloatingPointSpaceDelimitedString(DoubleBuffer buffer) {
		// For each scalar in the buffer, turn it into a string, adding it to the overall list.
		List<String> stringScalars = SupportFunctions.doubleBufferToStringList(buffer, ColladaSerializer.decimalFormat);
		// Send back a space-delimited list of the strings: 1 2.45 0
		return StringUtils.join(stringScalars, " ");
	}

	public static String byteBufferToFloatingPointSpaceDelimitedString(ByteBuffer buffer) {
		// For each scalar in the buffer, turn it into a string, adding it to the overall list.
		List<String> stringScalars = SupportFunctions.floatBufferToStringList(buffer, ColladaSerializer.decimalFormat);
		// Send back a space-delimited list of the strings: 1 2.45 0
		return StringUtils.join(stringScalars, " ");
	}

	public static String byteBufferToIntPointSpaceDelimitedString(ByteBuffer buffer) {
		// Prepare to store integers as a list of strings.
		List<String> stringScalars = SupportFunctions.intBufferToStringList(buffer, ColladaSerializer.intFormat);
		// Send back a space-delimited list of the strings: 1 2 0
		return StringUtils.join(stringScalars, " ");
	}

	public static List<String> doubleBufferToStringList(DoubleBuffer buffer, Format formatter) {
		// Transform the array into a list.
		List<Float> list = new ArrayList<Float>();
		while (buffer.hasRemaining())
			list.add(new Float(buffer.get()));
		// Get the data as a list of String objects.
		return SupportFunctions.listToStringList(list, formatter);
	}

	public static List<String> floatBufferToStringList(ByteBuffer buffer, Format formatter) {
		// Transform the array into a list.
		List<Float> list = new ArrayList<Float>();
		while (buffer.hasRemaining())
			list.add(new Float(buffer.getFloat()));
		// Get the data as a list of String objects.
		return SupportFunctions.listToStringList(list, formatter);
	}

	public static List<String> intBufferToStringList(ByteBuffer buffer, Format formatter) {
		List<Integer> list = new ArrayList<Integer>();
		while (buffer.hasRemaining())
			list.add(new Integer(buffer.getInt()));
		// Get the data as a list of String objects.
		return SupportFunctions.listToStringList(list, formatter);
	}

	public static String floatArrayToSpaceDelimitedString(float[] matrix) {
		List<Float> floatMatrix = SupportFunctions.floatArrayToFloatList(matrix);
		List<String> list = SupportFunctions.listToStringList(floatMatrix, ColladaSerializer.decimalFormat);
		// Get data as space-delimited string: 1.004 5.0 24.00145
		return StringUtils.join(list, " ");
	}

	public static List<Float> floatArrayToFloatList(float[] array) {
		List<Float> list = new ArrayList<Float>();
		for (float f : array)
			list.add(new Float(f));
		return list;
	}

	public static String listToSpaceDelimitedString(List<?> list, Format formatter) {
		List<String> stringScalars = SupportFunctions.listToStringList(list, formatter);
		return StringUtils.join(stringScalars, " ");
	}

	public static List<String> listToStringList(List<?> list, Format formatter) {
		// Prepare to store floating-points as a list of strings.
		List<String> stringScalars = new ArrayList<String>();
		// For each scalar in the buffer, turn it into a string, adding it to the overall list.
		for (Object scalar : list) {
			String scalarAsString = formatter.format(scalar);
			stringScalars.add(scalarAsString);
		}
		return stringScalars;
	}

	public static final float[] identity = new float[] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
	public static void printMatrix(PrintWriter out, GeometryInfo geometryInfo) {
		ByteBuffer transformation = ByteBuffer.wrap(geometryInfo.getTransformation());
		transformation.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer floatBuffer = transformation.asFloatBuffer();
		// Prepare to create the transform matrix.
		float[] matrix = new float[16];
		// Add the first 16 values of the buffer.
		for (int i = 0; i < matrix.length; i++)
			matrix[i] = floatBuffer.get();
		// Switch from column-major (x.x ... x.y ... x.z ... 0 ...) to row-major orientation (x.x x.y x.z 0 ...)?
		matrix = Matrix.changeOrientation(matrix);
		// List all 16 elements of the matrix as a single space-delimited String object.
		if (!matrix.equals(identity))
			out.println("    <matrix>" + floatArrayToSpaceDelimitedString(matrix) + "</matrix>");
	}
}
