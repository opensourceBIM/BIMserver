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
 * A representation of the literals of the enumeration '<em><b>Ifc Bridge Part Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBridgePartTypeEnum()
 * @model
 * @generated
 */
public enum IfcBridgePartTypeEnum implements Enumerator {
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
	 * The '<em><b>FOUNDATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUNDATION_VALUE
	 * @generated
	 * @ordered
	 */
	FOUNDATION(1, "FOUNDATION", "FOUNDATION"),

	/**
	 * The '<em><b>PYLON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PYLON_VALUE
	 * @generated
	 * @ordered
	 */
	PYLON(2, "PYLON", "PYLON"),

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
	 * The '<em><b>PIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER_VALUE
	 * @generated
	 * @ordered
	 */
	PIER(4, "PIER", "PIER"),

	/**
	 * The '<em><b>DECK SEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK_SEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DECK_SEGMENT(5, "DECK_SEGMENT", "DECK_SEGMENT"),

	/**
	 * The '<em><b>SUPERSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SUPERSTRUCTURE(6, "SUPERSTRUCTURE", "SUPERSTRUCTURE"),

	/**
	 * The '<em><b>DECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK_VALUE
	 * @generated
	 * @ordered
	 */
	DECK(7, "DECK", "DECK"),

	/**
	 * The '<em><b>ABUTMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABUTMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ABUTMENT(8, "ABUTMENT", "ABUTMENT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>PIER SEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER_SEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	PIER_SEGMENT(10, "PIER_SEGMENT", "PIER_SEGMENT"),

	/**
	 * The '<em><b>SURFACESTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURFACESTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SURFACESTRUCTURE(11, "SURFACESTRUCTURE", "SURFACESTRUCTURE"),

	/**
	 * The '<em><b>SUBSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSTRUCTURE(12, "SUBSTRUCTURE", "SUBSTRUCTURE");

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
	 * The '<em><b>FOUNDATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUNDATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOUNDATION_VALUE = 1;

	/**
	 * The '<em><b>PYLON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PYLON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PYLON_VALUE = 2;

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
	 * The '<em><b>PIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIER_VALUE = 4;

	/**
	 * The '<em><b>DECK SEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK_SEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECK_SEGMENT_VALUE = 5;

	/**
	 * The '<em><b>SUPERSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPERSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPERSTRUCTURE_VALUE = 6;

	/**
	 * The '<em><b>DECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECK_VALUE = 7;

	/**
	 * The '<em><b>ABUTMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABUTMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABUTMENT_VALUE = 8;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 9;

	/**
	 * The '<em><b>PIER SEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER_SEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIER_SEGMENT_VALUE = 10;

	/**
	 * The '<em><b>SURFACESTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURFACESTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SURFACESTRUCTURE_VALUE = 11;

	/**
	 * The '<em><b>SUBSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSTRUCTURE_VALUE = 12;

	/**
	 * An array of all the '<em><b>Ifc Bridge Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBridgePartTypeEnum[] VALUES_ARRAY = new IfcBridgePartTypeEnum[] { NULL, FOUNDATION, PYLON,
			NOTDEFINED, PIER, DECK_SEGMENT, SUPERSTRUCTURE, DECK, ABUTMENT, USERDEFINED, PIER_SEGMENT, SURFACESTRUCTURE,
			SUBSTRUCTURE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Bridge Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBridgePartTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Bridge Part Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgePartTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBridgePartTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Bridge Part Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgePartTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBridgePartTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Bridge Part Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBridgePartTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case FOUNDATION_VALUE:
			return FOUNDATION;
		case PYLON_VALUE:
			return PYLON;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case PIER_VALUE:
			return PIER;
		case DECK_SEGMENT_VALUE:
			return DECK_SEGMENT;
		case SUPERSTRUCTURE_VALUE:
			return SUPERSTRUCTURE;
		case DECK_VALUE:
			return DECK;
		case ABUTMENT_VALUE:
			return ABUTMENT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case PIER_SEGMENT_VALUE:
			return PIER_SEGMENT;
		case SURFACESTRUCTURE_VALUE:
			return SURFACESTRUCTURE;
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
	private IfcBridgePartTypeEnum(int value, String name, String literal) {
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

} //IfcBridgePartTypeEnum
