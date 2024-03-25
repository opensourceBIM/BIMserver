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
 * A representation of the literals of the enumeration '<em><b>Ifc Referent Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcReferentTypeEnum()
 * @model
 * @generated
 */
public enum IfcReferentTypeEnum implements Enumerator {
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
	 * The '<em><b>POSITION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITION_VALUE
	 * @generated
	 * @ordered
	 */
	POSITION(1, "POSITION", "POSITION"),

	/**
	 * The '<em><b>SUPERELEVATIONEVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERELEVATIONEVENT_VALUE
	 * @generated
	 * @ordered
	 */
	SUPERELEVATIONEVENT(2, "SUPERELEVATIONEVENT", "SUPERELEVATIONEVENT"),

	/**
	 * The '<em><b>WIDTHEVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDTHEVENT_VALUE
	 * @generated
	 * @ordered
	 */
	WIDTHEVENT(3, "WIDTHEVENT", "WIDTHEVENT"),

	/**
	 * The '<em><b>LANDMARK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANDMARK_VALUE
	 * @generated
	 * @ordered
	 */
	LANDMARK(4, "LANDMARK", "LANDMARK"),

	/**
	 * The '<em><b>REFERENCEMARKER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCEMARKER_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCEMARKER(5, "REFERENCEMARKER", "REFERENCEMARKER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(6, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>STATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATION_VALUE
	 * @generated
	 * @ordered
	 */
	STATION(7, "STATION", "STATION"),

	/**
	 * The '<em><b>INTERSECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERSECTION_VALUE
	 * @generated
	 * @ordered
	 */
	INTERSECTION(8, "INTERSECTION", "INTERSECTION"),

	/**
	 * The '<em><b>MILEPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILEPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	MILEPOINT(9, "MILEPOINT", "MILEPOINT"),

	/**
	 * The '<em><b>KILOPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILOPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	KILOPOINT(10, "KILOPOINT", "KILOPOINT"),

	/**
	 * The '<em><b>BOUNDARY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOUNDARY_VALUE
	 * @generated
	 * @ordered
	 */
	BOUNDARY(11, "BOUNDARY", "BOUNDARY"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(12, "USERDEFINED", "USERDEFINED");

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
	 * The '<em><b>POSITION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POSITION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POSITION_VALUE = 1;

	/**
	 * The '<em><b>SUPERELEVATIONEVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERELEVATIONEVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPERELEVATIONEVENT_VALUE = 2;

	/**
	 * The '<em><b>WIDTHEVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIDTHEVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIDTHEVENT_VALUE = 3;

	/**
	 * The '<em><b>LANDMARK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANDMARK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LANDMARK_VALUE = 4;

	/**
	 * The '<em><b>REFERENCEMARKER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCEMARKER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCEMARKER_VALUE = 5;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 6;

	/**
	 * The '<em><b>STATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATION_VALUE = 7;

	/**
	 * The '<em><b>INTERSECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERSECTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTERSECTION_VALUE = 8;

	/**
	 * The '<em><b>MILEPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILEPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MILEPOINT_VALUE = 9;

	/**
	 * The '<em><b>KILOPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILOPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KILOPOINT_VALUE = 10;

	/**
	 * The '<em><b>BOUNDARY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOUNDARY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOUNDARY_VALUE = 11;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 12;

	/**
	 * An array of all the '<em><b>Ifc Referent Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcReferentTypeEnum[] VALUES_ARRAY = new IfcReferentTypeEnum[] { NULL, POSITION,
			SUPERELEVATIONEVENT, WIDTHEVENT, LANDMARK, REFERENCEMARKER, NOTDEFINED, STATION, INTERSECTION, MILEPOINT,
			KILOPOINT, BOUNDARY, USERDEFINED, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Referent Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcReferentTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Referent Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcReferentTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcReferentTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Referent Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcReferentTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcReferentTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Referent Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcReferentTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case POSITION_VALUE:
			return POSITION;
		case SUPERELEVATIONEVENT_VALUE:
			return SUPERELEVATIONEVENT;
		case WIDTHEVENT_VALUE:
			return WIDTHEVENT;
		case LANDMARK_VALUE:
			return LANDMARK;
		case REFERENCEMARKER_VALUE:
			return REFERENCEMARKER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case STATION_VALUE:
			return STATION;
		case INTERSECTION_VALUE:
			return INTERSECTION;
		case MILEPOINT_VALUE:
			return MILEPOINT;
		case KILOPOINT_VALUE:
			return KILOPOINT;
		case BOUNDARY_VALUE:
			return BOUNDARY;
		case USERDEFINED_VALUE:
			return USERDEFINED;
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
	private IfcReferentTypeEnum(int value, String name, String literal) {
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

} //IfcReferentTypeEnum
