/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc2x3tc1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Door Style Operation Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcDoorStyleOperationEnum()
 * @model
 * @generated
 */
public enum IfcDoorStyleOperationEnum implements Enumerator {
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
	 * The '<em><b>SINGLE SWING LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE_SWING_LEFT(1, "SINGLE_SWING_LEFT", "SINGLE_SWING_LEFT"),

	/**
	 * The '<em><b>FOLDING TO LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDING_TO_LEFT(2, "FOLDING_TO_LEFT", "FOLDING_TO_LEFT"),

	/**
	 * The '<em><b>SINGLE SWING RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE_SWING_RIGHT(3, "SINGLE_SWING_RIGHT", "SINGLE_SWING_RIGHT"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ROLLINGUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGUP_VALUE
	 * @generated
	 * @ordered
	 */
	ROLLINGUP(5, "ROLLINGUP", "ROLLINGUP"),

	/**
	 * The '<em><b>DOUBLE DOOR FOLDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_FOLDING_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_FOLDING(6, "DOUBLE_DOOR_FOLDING", "DOUBLE_DOOR_FOLDING"),

	/**
	 * The '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_DOUBLE_SWING_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_DOUBLE_SWING(7, "DOUBLE_DOOR_DOUBLE_SWING", "DOUBLE_DOOR_DOUBLE_SWING"),

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SINGLE_SWING(8, "DOUBLE_DOOR_SINGLE_SWING", "DOUBLE_DOOR_SINGLE_SWING"),

	/**
	 * The '<em><b>SLIDING TO LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	SLIDING_TO_LEFT(9, "SLIDING_TO_LEFT", "SLIDING_TO_LEFT"),

	/**
	 * The '<em><b>DOUBLE DOOR SLIDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SLIDING_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SLIDING(10, "DOUBLE_DOOR_SLIDING", "DOUBLE_DOOR_SLIDING"),

	/**
	 * The '<em><b>FOLDING TO RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDING_TO_RIGHT(11, "FOLDING_TO_RIGHT", "FOLDING_TO_RIGHT"), /**
																	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal object.
																	 * <!-- begin-user-doc -->
																	 * <!-- end-user-doc -->
																	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_VALUE
																	 * @generated
																	 * @ordered
																	 */
	DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT(12, "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT", "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT"),

	/**
	 * The '<em><b>REVOLVING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVOLVING_VALUE
	 * @generated
	 * @ordered
	 */
	REVOLVING(13, "REVOLVING", "REVOLVING"),

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT(14, "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT", "DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(15, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SLIDING TO RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	SLIDING_TO_RIGHT(16, "SLIDING_TO_RIGHT", "SLIDING_TO_RIGHT"),

	/**
	 * The '<em><b>DOUBLE SWING LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_SWING_LEFT(17, "DOUBLE_SWING_LEFT", "DOUBLE_SWING_LEFT"),

	/**
	 * The '<em><b>DOUBLE SWING RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_SWING_RIGHT(18, "DOUBLE_SWING_RIGHT", "DOUBLE_SWING_RIGHT");

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
	 * The '<em><b>SINGLE SWING LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE SWING LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_SWING_LEFT_VALUE = 1;

	/**
	 * The '<em><b>FOLDING TO LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDING TO LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDING_TO_LEFT_VALUE = 2;

	/**
	 * The '<em><b>SINGLE SWING RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE SWING RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_SWING_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_SWING_RIGHT_VALUE = 3;

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
	public static final int NOTDEFINED_VALUE = 4;

	/**
	 * The '<em><b>ROLLINGUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLINGUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLINGUP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLINGUP_VALUE = 5;

	/**
	 * The '<em><b>DOUBLE DOOR FOLDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR FOLDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_FOLDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_FOLDING_VALUE = 6;

	/**
	 * The '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR DOUBLE SWING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_DOUBLE_SWING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_DOUBLE_SWING_VALUE = 7;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING_VALUE = 8;

	/**
	 * The '<em><b>SLIDING TO LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDING TO LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDING_TO_LEFT_VALUE = 9;

	/**
	 * The '<em><b>DOUBLE DOOR SLIDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SLIDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SLIDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SLIDING_VALUE = 10;

	/**
	 * The '<em><b>FOLDING TO RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDING TO RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDING_TO_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDING_TO_RIGHT_VALUE = 11;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_VALUE = 12;

	/**
	 * The '<em><b>REVOLVING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REVOLVING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REVOLVING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REVOLVING_VALUE = 13;

	/**
	 * The '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE DOOR SINGLE SWING OPPOSITE LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_VALUE = 14;

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
	public static final int USERDEFINED_VALUE = 15;

	/**
	 * The '<em><b>SLIDING TO RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDING TO RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDING_TO_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDING_TO_RIGHT_VALUE = 16;

	/**
	 * The '<em><b>DOUBLE SWING LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE SWING LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_SWING_LEFT_VALUE = 17;

	/**
	 * The '<em><b>DOUBLE SWING RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE SWING RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_SWING_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_SWING_RIGHT_VALUE = 18;

	/**
	 * An array of all the '<em><b>Ifc Door Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcDoorStyleOperationEnum[] VALUES_ARRAY = new IfcDoorStyleOperationEnum[] { NULL, SINGLE_SWING_LEFT, FOLDING_TO_LEFT, SINGLE_SWING_RIGHT, NOTDEFINED,
			ROLLINGUP, DOUBLE_DOOR_FOLDING, DOUBLE_DOOR_DOUBLE_SWING, DOUBLE_DOOR_SINGLE_SWING, SLIDING_TO_LEFT, DOUBLE_DOOR_SLIDING, FOLDING_TO_RIGHT,
			DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT, REVOLVING, DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT, USERDEFINED, SLIDING_TO_RIGHT, DOUBLE_SWING_LEFT, DOUBLE_SWING_RIGHT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Door Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcDoorStyleOperationEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcDoorStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcDoorStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Door Style Operation Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDoorStyleOperationEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SINGLE_SWING_LEFT_VALUE:
			return SINGLE_SWING_LEFT;
		case FOLDING_TO_LEFT_VALUE:
			return FOLDING_TO_LEFT;
		case SINGLE_SWING_RIGHT_VALUE:
			return SINGLE_SWING_RIGHT;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case ROLLINGUP_VALUE:
			return ROLLINGUP;
		case DOUBLE_DOOR_FOLDING_VALUE:
			return DOUBLE_DOOR_FOLDING;
		case DOUBLE_DOOR_DOUBLE_SWING_VALUE:
			return DOUBLE_DOOR_DOUBLE_SWING;
		case DOUBLE_DOOR_SINGLE_SWING_VALUE:
			return DOUBLE_DOOR_SINGLE_SWING;
		case SLIDING_TO_LEFT_VALUE:
			return SLIDING_TO_LEFT;
		case DOUBLE_DOOR_SLIDING_VALUE:
			return DOUBLE_DOOR_SLIDING;
		case FOLDING_TO_RIGHT_VALUE:
			return FOLDING_TO_RIGHT;
		case DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT_VALUE:
			return DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_RIGHT;
		case REVOLVING_VALUE:
			return REVOLVING;
		case DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT_VALUE:
			return DOUBLE_DOOR_SINGLE_SWING_OPPOSITE_LEFT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case SLIDING_TO_RIGHT_VALUE:
			return SLIDING_TO_RIGHT;
		case DOUBLE_SWING_LEFT_VALUE:
			return DOUBLE_SWING_LEFT;
		case DOUBLE_SWING_RIGHT_VALUE:
			return DOUBLE_SWING_RIGHT;
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
	private IfcDoorStyleOperationEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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

} //IfcDoorStyleOperationEnum
