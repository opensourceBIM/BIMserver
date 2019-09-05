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
 * A representation of the literals of the enumeration '<em><b>Ifc Switching Device Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSwitchingDeviceTypeEnum()
 * @model
 * @generated
 */
public enum IfcSwitchingDeviceTypeEnum implements Enumerator {
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
	 * The '<em><b>MOMENTARYSWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOMENTARYSWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	MOMENTARYSWITCH(1, "MOMENTARYSWITCH", "MOMENTARYSWITCH"),

	/**
	 * The '<em><b>SELECTORSWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELECTORSWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	SELECTORSWITCH(2, "SELECTORSWITCH", "SELECTORSWITCH"),

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
	 * The '<em><b>DIMMERSWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIMMERSWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	DIMMERSWITCH(4, "DIMMERSWITCH", "DIMMERSWITCH"),

	/**
	 * The '<em><b>TOGGLESWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOGGLESWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	TOGGLESWITCH(5, "TOGGLESWITCH", "TOGGLESWITCH"),

	/**
	 * The '<em><b>CONTACTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTACTOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONTACTOR(6, "CONTACTOR", "CONTACTOR"),

	/**
	 * The '<em><b>KEYPAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEYPAD_VALUE
	 * @generated
	 * @ordered
	 */
	KEYPAD(7, "KEYPAD", "KEYPAD"),

	/**
	 * The '<em><b>STARTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTER_VALUE
	 * @generated
	 * @ordered
	 */
	STARTER(8, "STARTER", "STARTER"),

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
	 * The '<em><b>EMERGENCYSTOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMERGENCYSTOP_VALUE
	 * @generated
	 * @ordered
	 */
	EMERGENCYSTOP(10, "EMERGENCYSTOP", "EMERGENCYSTOP"),

	/**
	 * The '<em><b>SWITCHDISCONNECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWITCHDISCONNECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	SWITCHDISCONNECTOR(11, "SWITCHDISCONNECTOR", "SWITCHDISCONNECTOR");

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
	 * The '<em><b>MOMENTARYSWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOMENTARYSWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOMENTARYSWITCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOMENTARYSWITCH_VALUE = 1;

	/**
	 * The '<em><b>SELECTORSWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SELECTORSWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELECTORSWITCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SELECTORSWITCH_VALUE = 2;

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
	public static final int NOTDEFINED_VALUE = 3;

	/**
	 * The '<em><b>DIMMERSWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIMMERSWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIMMERSWITCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIMMERSWITCH_VALUE = 4;

	/**
	 * The '<em><b>TOGGLESWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOGGLESWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOGGLESWITCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOGGLESWITCH_VALUE = 5;

	/**
	 * The '<em><b>CONTACTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTACTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTACTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTACTOR_VALUE = 6;

	/**
	 * The '<em><b>KEYPAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KEYPAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KEYPAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KEYPAD_VALUE = 7;

	/**
	 * The '<em><b>STARTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STARTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STARTER_VALUE = 8;

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
	public static final int USERDEFINED_VALUE = 9;

	/**
	 * The '<em><b>EMERGENCYSTOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EMERGENCYSTOP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EMERGENCYSTOP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EMERGENCYSTOP_VALUE = 10;

	/**
	 * The '<em><b>SWITCHDISCONNECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SWITCHDISCONNECTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWITCHDISCONNECTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SWITCHDISCONNECTOR_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Switching Device Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSwitchingDeviceTypeEnum[] VALUES_ARRAY = new IfcSwitchingDeviceTypeEnum[] { NULL, MOMENTARYSWITCH, SELECTORSWITCH, NOTDEFINED, DIMMERSWITCH, TOGGLESWITCH, CONTACTOR, KEYPAD, STARTER, USERDEFINED, EMERGENCYSTOP,
			SWITCHDISCONNECTOR, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Switching Device Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSwitchingDeviceTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Switching Device Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSwitchingDeviceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSwitchingDeviceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Switching Device Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSwitchingDeviceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSwitchingDeviceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Switching Device Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSwitchingDeviceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case MOMENTARYSWITCH_VALUE:
			return MOMENTARYSWITCH;
		case SELECTORSWITCH_VALUE:
			return SELECTORSWITCH;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case DIMMERSWITCH_VALUE:
			return DIMMERSWITCH;
		case TOGGLESWITCH_VALUE:
			return TOGGLESWITCH;
		case CONTACTOR_VALUE:
			return CONTACTOR;
		case KEYPAD_VALUE:
			return KEYPAD;
		case STARTER_VALUE:
			return STARTER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case EMERGENCYSTOP_VALUE:
			return EMERGENCYSTOP;
		case SWITCHDISCONNECTOR_VALUE:
			return SWITCHDISCONNECTOR;
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
	private IfcSwitchingDeviceTypeEnum(int value, String name, String literal) {
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

} //IfcSwitchingDeviceTypeEnum
