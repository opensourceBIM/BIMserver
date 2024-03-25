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
 * A representation of the literals of the enumeration '<em><b>Ifc Facility Part Common Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcFacilityPartCommonTypeEnum()
 * @model
 * @generated
 */
public enum IfcFacilityPartCommonTypeEnum implements Enumerator {
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
	 * The '<em><b>TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINAL(1, "TERMINAL", "TERMINAL"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>SEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	SEGMENT(3, "SEGMENT", "SEGMENT"),

	/**
	 * The '<em><b>SUPERSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SUPERSTRUCTURE(4, "SUPERSTRUCTURE", "SUPERSTRUCTURE"),

	/**
	 * The '<em><b>ABOVEGROUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABOVEGROUND_VALUE
	 * @generated
	 * @ordered
	 */
	ABOVEGROUND(5, "ABOVEGROUND", "ABOVEGROUND"),

	/**
	 * The '<em><b>BELOWGROUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELOWGROUND_VALUE
	 * @generated
	 * @ordered
	 */
	BELOWGROUND(6, "BELOWGROUND", "BELOWGROUND"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(7, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>LEVELCROSSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEVELCROSSING_VALUE
	 * @generated
	 * @ordered
	 */
	LEVELCROSSING(8, "LEVELCROSSING", "LEVELCROSSING"),

	/**
	 * The '<em><b>JUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	JUNCTION(9, "JUNCTION", "JUNCTION"),

	/**
	 * The '<em><b>SUBSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSTRUCTURE(10, "SUBSTRUCTURE", "SUBSTRUCTURE");

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
	 * The '<em><b>TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINAL_VALUE = 1;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>SEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEGMENT_VALUE = 3;

	/**
	 * The '<em><b>SUPERSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPERSTRUCTURE_VALUE = 4;

	/**
	 * The '<em><b>ABOVEGROUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABOVEGROUND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABOVEGROUND_VALUE = 5;

	/**
	 * The '<em><b>BELOWGROUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELOWGROUND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BELOWGROUND_VALUE = 6;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 7;

	/**
	 * The '<em><b>LEVELCROSSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEVELCROSSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LEVELCROSSING_VALUE = 8;

	/**
	 * The '<em><b>JUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JUNCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JUNCTION_VALUE = 9;

	/**
	 * The '<em><b>SUBSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTRUCTURE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Ifc Facility Part Common Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcFacilityPartCommonTypeEnum[] VALUES_ARRAY = new IfcFacilityPartCommonTypeEnum[] { NULL,
			TERMINAL, NOTDEFINED, SEGMENT, SUPERSTRUCTURE, ABOVEGROUND, BELOWGROUND, USERDEFINED, LEVELCROSSING,
			JUNCTION, SUBSTRUCTURE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Facility Part Common Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcFacilityPartCommonTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Facility Part Common Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcFacilityPartCommonTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcFacilityPartCommonTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Facility Part Common Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcFacilityPartCommonTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcFacilityPartCommonTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Facility Part Common Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcFacilityPartCommonTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case TERMINAL_VALUE:
			return TERMINAL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case SEGMENT_VALUE:
			return SEGMENT;
		case SUPERSTRUCTURE_VALUE:
			return SUPERSTRUCTURE;
		case ABOVEGROUND_VALUE:
			return ABOVEGROUND;
		case BELOWGROUND_VALUE:
			return BELOWGROUND;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case LEVELCROSSING_VALUE:
			return LEVELCROSSING;
		case JUNCTION_VALUE:
			return JUNCTION;
		case SUBSTRUCTURE_VALUE:
			return SUBSTRUCTURE;
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
	private IfcFacilityPartCommonTypeEnum(int value, String name, String literal) {
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

} //IfcFacilityPartCommonTypeEnum
