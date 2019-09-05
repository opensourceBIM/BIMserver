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
package org.bimserver.models.ifc4;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Stair Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcStairTypeEnum()
 * @model
 * @generated
 */
public enum IfcStairTypeEnum implements Enumerator {
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
	 * The '<em><b>QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUARTER_WINDING_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	QUARTER_WINDING_STAIR(1, "QUARTER_WINDING_STAIR", "QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_STRAIGHT_RUN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	TWO_STRAIGHT_RUN_STAIR(2, "TWO_STRAIGHT_RUN_STAIR", "TWO_STRAIGHT_RUN_STAIR"),

	/**
	 * The '<em><b>DOUBLE RETURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_RETURN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_RETURN_STAIR(3, "DOUBLE_RETURN_STAIR", "DOUBLE_RETURN_STAIR"),

	/**
	 * The '<em><b>CURVED RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURVED_RUN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	CURVED_RUN_STAIR(4, "CURVED_RUN_STAIR", "CURVED_RUN_STAIR"),

	/**
	 * The '<em><b>STRAIGHT RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_RUN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	STRAIGHT_RUN_STAIR(5, "STRAIGHT_RUN_STAIR", "STRAIGHT_RUN_STAIR"),

	/**
	 * The '<em><b>HALF WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_WINDING_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	HALF_WINDING_STAIR(6, "HALF_WINDING_STAIR", "HALF_WINDING_STAIR"),

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
	 * The '<em><b>TWO CURVED RUN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_CURVED_RUN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	TWO_CURVED_RUN_STAIR(8, "TWO_CURVED_RUN_STAIR", "TWO_CURVED_RUN_STAIR"),

	/**
	 * The '<em><b>QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUARTER_TURN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	QUARTER_TURN_STAIR(9, "QUARTER_TURN_STAIR", "QUARTER_TURN_STAIR"),

	/**
	 * The '<em><b>THREE QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_TURN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	THREE_QUARTER_TURN_STAIR(10, "THREE_QUARTER_TURN_STAIR", "THREE_QUARTER_TURN_STAIR"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(11, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>SPIRAL STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPIRAL_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	SPIRAL_STAIR(12, "SPIRAL_STAIR", "SPIRAL_STAIR"),

	/**
	 * The '<em><b>HALF TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_TURN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	HALF_TURN_STAIR(13, "HALF_TURN_STAIR", "HALF_TURN_STAIR"),

	/**
	 * The '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_WINDING_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	THREE_QUARTER_WINDING_STAIR(14, "THREE_QUARTER_WINDING_STAIR", "THREE_QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_WINDING_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	TWO_QUARTER_WINDING_STAIR(15, "TWO_QUARTER_WINDING_STAIR", "TWO_QUARTER_WINDING_STAIR"),

	/**
	 * The '<em><b>TWO QUARTER TURN STAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_TURN_STAIR_VALUE
	 * @generated
	 * @ordered
	 */
	TWO_QUARTER_TURN_STAIR(16, "TWO_QUARTER_TURN_STAIR", "TWO_QUARTER_TURN_STAIR");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUARTER_WINDING_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUARTER_WINDING_STAIR_VALUE = 1;

	/**
	 * The '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO STRAIGHT RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_STRAIGHT_RUN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_STRAIGHT_RUN_STAIR_VALUE = 2;

	/**
	 * The '<em><b>DOUBLE RETURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE RETURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_RETURN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_RETURN_STAIR_VALUE = 3;

	/**
	 * The '<em><b>CURVED RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CURVED RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CURVED_RUN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CURVED_RUN_STAIR_VALUE = 4;

	/**
	 * The '<em><b>STRAIGHT RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRAIGHT RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRAIGHT_RUN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRAIGHT_RUN_STAIR_VALUE = 5;

	/**
	 * The '<em><b>HALF WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HALF WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_WINDING_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HALF_WINDING_STAIR_VALUE = 6;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 7;

	/**
	 * The '<em><b>TWO CURVED RUN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO CURVED RUN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_CURVED_RUN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_CURVED_RUN_STAIR_VALUE = 8;

	/**
	 * The '<em><b>QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUARTER_TURN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUARTER_TURN_STAIR_VALUE = 9;

	/**
	 * The '<em><b>THREE QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREE QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_TURN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THREE_QUARTER_TURN_STAIR_VALUE = 10;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 11;

	/**
	 * The '<em><b>SPIRAL STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPIRAL STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPIRAL_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPIRAL_STAIR_VALUE = 12;

	/**
	 * The '<em><b>HALF TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HALF TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_TURN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HALF_TURN_STAIR_VALUE = 13;

	/**
	 * The '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THREE QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THREE_QUARTER_WINDING_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THREE_QUARTER_WINDING_STAIR_VALUE = 14;

	/**
	 * The '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO QUARTER WINDING STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_WINDING_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_QUARTER_WINDING_STAIR_VALUE = 15;

	/**
	 * The '<em><b>TWO QUARTER TURN STAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWO QUARTER TURN STAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWO_QUARTER_TURN_STAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWO_QUARTER_TURN_STAIR_VALUE = 16;

	/**
	 * An array of all the '<em><b>Ifc Stair Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcStairTypeEnum[] VALUES_ARRAY = new IfcStairTypeEnum[] { NULL, QUARTER_WINDING_STAIR, TWO_STRAIGHT_RUN_STAIR, DOUBLE_RETURN_STAIR, CURVED_RUN_STAIR, STRAIGHT_RUN_STAIR, HALF_WINDING_STAIR, USERDEFINED,
			TWO_CURVED_RUN_STAIR, QUARTER_TURN_STAIR, THREE_QUARTER_TURN_STAIR, NOTDEFINED, SPIRAL_STAIR, HALF_TURN_STAIR, THREE_QUARTER_WINDING_STAIR, TWO_QUARTER_WINDING_STAIR, TWO_QUARTER_TURN_STAIR, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Stair Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcStairTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcStairTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcStairTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcStairTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcStairTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Stair Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcStairTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case QUARTER_WINDING_STAIR_VALUE:
			return QUARTER_WINDING_STAIR;
		case TWO_STRAIGHT_RUN_STAIR_VALUE:
			return TWO_STRAIGHT_RUN_STAIR;
		case DOUBLE_RETURN_STAIR_VALUE:
			return DOUBLE_RETURN_STAIR;
		case CURVED_RUN_STAIR_VALUE:
			return CURVED_RUN_STAIR;
		case STRAIGHT_RUN_STAIR_VALUE:
			return STRAIGHT_RUN_STAIR;
		case HALF_WINDING_STAIR_VALUE:
			return HALF_WINDING_STAIR;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case TWO_CURVED_RUN_STAIR_VALUE:
			return TWO_CURVED_RUN_STAIR;
		case QUARTER_TURN_STAIR_VALUE:
			return QUARTER_TURN_STAIR;
		case THREE_QUARTER_TURN_STAIR_VALUE:
			return THREE_QUARTER_TURN_STAIR;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case SPIRAL_STAIR_VALUE:
			return SPIRAL_STAIR;
		case HALF_TURN_STAIR_VALUE:
			return HALF_TURN_STAIR;
		case THREE_QUARTER_WINDING_STAIR_VALUE:
			return THREE_QUARTER_WINDING_STAIR;
		case TWO_QUARTER_WINDING_STAIR_VALUE:
			return TWO_QUARTER_WINDING_STAIR;
		case TWO_QUARTER_TURN_STAIR_VALUE:
			return TWO_QUARTER_TURN_STAIR;
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
	private IfcStairTypeEnum(int value, String name, String literal) {
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

} //IfcStairTypeEnum
