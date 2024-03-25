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
 * A representation of the literals of the enumeration '<em><b>Ifc Track Element Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcTrackElementTypeEnum()
 * @model
 * @generated
 */
public enum IfcTrackElementTypeEnum implements Enumerator {
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
	 * The '<em><b>TRACKENDOFALIGNMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKENDOFALIGNMENT_VALUE
	 * @generated
	 * @ordered
	 */
	TRACKENDOFALIGNMENT(1, "TRACKENDOFALIGNMENT", "TRACKENDOFALIGNMENT"),

	/**
	 * The '<em><b>DERAILER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DERAILER_VALUE
	 * @generated
	 * @ordered
	 */
	DERAILER(2, "DERAILER", "DERAILER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>HALF SET OF BLADES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_SET_OF_BLADES_VALUE
	 * @generated
	 * @ordered
	 */
	HALF_SET_OF_BLADES(4, "HALF_SET_OF_BLADES", "HALF_SET_OF_BLADES"),

	/**
	 * The '<em><b>FROG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FROG_VALUE
	 * @generated
	 * @ordered
	 */
	FROG(5, "FROG", "FROG"),

	/**
	 * The '<em><b>SLEEPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLEEPER_VALUE
	 * @generated
	 * @ordered
	 */
	SLEEPER(6, "SLEEPER", "SLEEPER"),

	/**
	 * The '<em><b>BLOCKINGDEVICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCKINGDEVICE_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCKINGDEVICE(7, "BLOCKINGDEVICE", "BLOCKINGDEVICE"),

	/**
	 * The '<em><b>VEHICLESTOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLESTOP_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLESTOP(8, "VEHICLESTOP", "VEHICLESTOP"),

	/**
	 * The '<em><b>SPEEDREGULATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPEEDREGULATOR_VALUE
	 * @generated
	 * @ordered
	 */
	SPEEDREGULATOR(9, "SPEEDREGULATOR", "SPEEDREGULATOR"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(10, "USERDEFINED", "USERDEFINED");

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
	 * The '<em><b>TRACKENDOFALIGNMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKENDOFALIGNMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRACKENDOFALIGNMENT_VALUE = 1;

	/**
	 * The '<em><b>DERAILER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DERAILER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DERAILER_VALUE = 2;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 3;

	/**
	 * The '<em><b>HALF SET OF BLADES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_SET_OF_BLADES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HALF_SET_OF_BLADES_VALUE = 4;

	/**
	 * The '<em><b>FROG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FROG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FROG_VALUE = 5;

	/**
	 * The '<em><b>SLEEPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLEEPER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLEEPER_VALUE = 6;

	/**
	 * The '<em><b>BLOCKINGDEVICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCKINGDEVICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLOCKINGDEVICE_VALUE = 7;

	/**
	 * The '<em><b>VEHICLESTOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLESTOP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLESTOP_VALUE = 8;

	/**
	 * The '<em><b>SPEEDREGULATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPEEDREGULATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPEEDREGULATOR_VALUE = 9;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 10;

	/**
	 * An array of all the '<em><b>Ifc Track Element Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcTrackElementTypeEnum[] VALUES_ARRAY = new IfcTrackElementTypeEnum[] { NULL,
			TRACKENDOFALIGNMENT, DERAILER, NOTDEFINED, HALF_SET_OF_BLADES, FROG, SLEEPER, BLOCKINGDEVICE, VEHICLESTOP,
			SPEEDREGULATOR, USERDEFINED, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Track Element Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcTrackElementTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Track Element Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTrackElementTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcTrackElementTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Track Element Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTrackElementTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcTrackElementTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Track Element Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcTrackElementTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case TRACKENDOFALIGNMENT_VALUE:
			return TRACKENDOFALIGNMENT;
		case DERAILER_VALUE:
			return DERAILER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case HALF_SET_OF_BLADES_VALUE:
			return HALF_SET_OF_BLADES;
		case FROG_VALUE:
			return FROG;
		case SLEEPER_VALUE:
			return SLEEPER;
		case BLOCKINGDEVICE_VALUE:
			return BLOCKINGDEVICE;
		case VEHICLESTOP_VALUE:
			return VEHICLESTOP;
		case SPEEDREGULATOR_VALUE:
			return SPEEDREGULATOR;
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
	private IfcTrackElementTypeEnum(int value, String name, String literal) {
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

} //IfcTrackElementTypeEnum
