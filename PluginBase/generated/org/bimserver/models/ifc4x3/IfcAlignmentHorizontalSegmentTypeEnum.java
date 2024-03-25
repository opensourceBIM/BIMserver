/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.ifc4x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcAlignmentHorizontalSegmentTypeEnum()
 * @model
 * @generated
 */
public enum IfcAlignmentHorizontalSegmentTypeEnum implements Enumerator {
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NULL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>COSINECURVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSINECURVE_VALUE
	 * @generated
	 * @ordered
	 */
	COSINECURVE(1, "COSINECURVE", "COSINECURVE"),

	/**
	 * The '<em><b>SINECURVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINECURVE_VALUE
	 * @generated
	 * @ordered
	 */
	SINECURVE(2, "SINECURVE", "SINECURVE"),

	/**
	 * The '<em><b>CIRCULARARC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULARARC_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCULARARC(3, "CIRCULARARC", "CIRCULARARC"),

	/**
	 * The '<em><b>BLOSSCURVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOSSCURVE_VALUE
	 * @generated
	 * @ordered
	 */
	BLOSSCURVE(4, "BLOSSCURVE", "BLOSSCURVE"),

	/**
	 * The '<em><b>LINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE_VALUE
	 * @generated
	 * @ordered
	 */
	LINE(5, "LINE", "LINE"),

	/**
	 * The '<em><b>CLOTHOID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOTHOID_VALUE
	 * @generated
	 * @ordered
	 */
	CLOTHOID(6, "CLOTHOID", "CLOTHOID"),

	/**
	 * The '<em><b>HELMERTCURVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HELMERTCURVE_VALUE
	 * @generated
	 * @ordered
	 */
	HELMERTCURVE(7, "HELMERTCURVE", "HELMERTCURVE"),

	/**
	 * The '<em><b>CUBIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUBIC_VALUE
	 * @generated
	 * @ordered
	 */
	CUBIC(8, "CUBIC", "CUBIC"),

	/**
	 * The '<em><b>VIENNESEBEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIENNESEBEND_VALUE
	 * @generated
	 * @ordered
	 */
	VIENNESEBEND(9, "VIENNESEBEND", "VIENNESEBEND");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>COSINECURVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COSINECURVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COSINECURVE_VALUE = 1;

	/**
	 * The '<em><b>SINECURVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINECURVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINECURVE_VALUE = 2;

	/**
	 * The '<em><b>CIRCULARARC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULARARC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIRCULARARC_VALUE = 3;

	/**
	 * The '<em><b>BLOSSCURVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOSSCURVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLOSSCURVE_VALUE = 4;

	/**
	 * The '<em><b>LINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINE_VALUE = 5;

	/**
	 * The '<em><b>CLOTHOID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLOTHOID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLOTHOID_VALUE = 6;

	/**
	 * The '<em><b>HELMERTCURVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HELMERTCURVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HELMERTCURVE_VALUE = 7;

	/**
	 * The '<em><b>CUBIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUBIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUBIC_VALUE = 8;

	/**
	 * The '<em><b>VIENNESEBEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIENNESEBEND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VIENNESEBEND_VALUE = 9;

	/**
	 * An array of all the '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcAlignmentHorizontalSegmentTypeEnum[] VALUES_ARRAY = new IfcAlignmentHorizontalSegmentTypeEnum[] {
			NULL, COSINECURVE, SINECURVE, CIRCULARARC, BLOSSCURVE, LINE, CLOTHOID, HELMERTCURVE, CUBIC, VIENNESEBEND, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcAlignmentHorizontalSegmentTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAlignmentHorizontalSegmentTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAlignmentHorizontalSegmentTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAlignmentHorizontalSegmentTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAlignmentHorizontalSegmentTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Alignment Horizontal Segment Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAlignmentHorizontalSegmentTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case COSINECURVE_VALUE:
			return COSINECURVE;
		case SINECURVE_VALUE:
			return SINECURVE;
		case CIRCULARARC_VALUE:
			return CIRCULARARC;
		case BLOSSCURVE_VALUE:
			return BLOSSCURVE;
		case LINE_VALUE:
			return LINE;
		case CLOTHOID_VALUE:
			return CLOTHOID;
		case HELMERTCURVE_VALUE:
			return HELMERTCURVE;
		case CUBIC_VALUE:
			return CUBIC;
		case VIENNESEBEND_VALUE:
			return VIENNESEBEND;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IfcAlignmentHorizontalSegmentTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //IfcAlignmentHorizontalSegmentTypeEnum
