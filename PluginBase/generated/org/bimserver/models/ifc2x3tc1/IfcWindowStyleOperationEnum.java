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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the literals of the enumeration '<em><b>Ifc Window Style Operation Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcWindowStyleOperationEnum()
 * @model
 * @generated
 */
public enum IfcWindowStyleOperationEnum implements Enumerator {
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
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(1, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>DOUBLE PANEL HORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_PANEL_HORIZONTAL_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_PANEL_HORIZONTAL(2, "DOUBLE_PANEL_HORIZONTAL", "DOUBLE_PANEL_HORIZONTAL"),

	/**
	 * The '<em><b>TRIPLE PANEL BOTTOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_BOTTOM_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_BOTTOM(3, "TRIPLE_PANEL_BOTTOM", "TRIPLE_PANEL_BOTTOM"),

	/**
	 * The '<em><b>TRIPLE PANEL LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_LEFT(4, "TRIPLE_PANEL_LEFT", "TRIPLE_PANEL_LEFT"),

	/**
	 * The '<em><b>DOUBLE PANEL VERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_PANEL_VERTICAL_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_PANEL_VERTICAL(5, "DOUBLE_PANEL_VERTICAL", "DOUBLE_PANEL_VERTICAL"),

	/**
	 * The '<em><b>TRIPLE PANEL HORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_HORIZONTAL_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_HORIZONTAL(6, "TRIPLE_PANEL_HORIZONTAL", "TRIPLE_PANEL_HORIZONTAL"),

	/**
	 * The '<em><b>SINGLE PANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_PANEL_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE_PANEL(7, "SINGLE_PANEL", "SINGLE_PANEL"),

	/**
	 * The '<em><b>TRIPLE PANEL RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_RIGHT(8, "TRIPLE_PANEL_RIGHT", "TRIPLE_PANEL_RIGHT"),

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
	 * The '<em><b>TRIPLE PANEL VERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_VERTICAL_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_VERTICAL(10, "TRIPLE_PANEL_VERTICAL", "TRIPLE_PANEL_VERTICAL"),

	/**
	 * The '<em><b>TRIPLE PANEL TOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_TOP_VALUE
	 * @generated
	 * @ordered
	 */
	TRIPLE_PANEL_TOP(11, "TRIPLE_PANEL_TOP", "TRIPLE_PANEL_TOP");

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
	public static final int NOTDEFINED_VALUE = 1;

	/**
	 * The '<em><b>DOUBLE PANEL HORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE PANEL HORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_PANEL_HORIZONTAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_PANEL_HORIZONTAL_VALUE = 2;

	/**
	 * The '<em><b>TRIPLE PANEL BOTTOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL BOTTOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_BOTTOM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_BOTTOM_VALUE = 3;

	/**
	 * The '<em><b>TRIPLE PANEL LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL LEFT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_LEFT_VALUE = 4;

	/**
	 * The '<em><b>DOUBLE PANEL VERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE PANEL VERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_PANEL_VERTICAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_PANEL_VERTICAL_VALUE = 5;

	/**
	 * The '<em><b>TRIPLE PANEL HORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL HORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_HORIZONTAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_HORIZONTAL_VALUE = 6;

	/**
	 * The '<em><b>SINGLE PANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE PANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_PANEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_PANEL_VALUE = 7;

	/**
	 * The '<em><b>TRIPLE PANEL RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL RIGHT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_RIGHT_VALUE = 8;

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
	 * The '<em><b>TRIPLE PANEL VERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL VERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_VERTICAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_VERTICAL_VALUE = 10;

	/**
	 * The '<em><b>TRIPLE PANEL TOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRIPLE PANEL TOP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRIPLE_PANEL_TOP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRIPLE_PANEL_TOP_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Window Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcWindowStyleOperationEnum[] VALUES_ARRAY = new IfcWindowStyleOperationEnum[] { NULL,
			NOTDEFINED, DOUBLE_PANEL_HORIZONTAL, TRIPLE_PANEL_BOTTOM, TRIPLE_PANEL_LEFT, DOUBLE_PANEL_VERTICAL,
			TRIPLE_PANEL_HORIZONTAL, SINGLE_PANEL, TRIPLE_PANEL_RIGHT, USERDEFINED, TRIPLE_PANEL_VERTICAL,
			TRIPLE_PANEL_TOP, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Window Style Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcWindowStyleOperationEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Window Style Operation Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowStyleOperationEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcWindowStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Style Operation Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowStyleOperationEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcWindowStyleOperationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Style Operation Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowStyleOperationEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case DOUBLE_PANEL_HORIZONTAL_VALUE:
			return DOUBLE_PANEL_HORIZONTAL;
		case TRIPLE_PANEL_BOTTOM_VALUE:
			return TRIPLE_PANEL_BOTTOM;
		case TRIPLE_PANEL_LEFT_VALUE:
			return TRIPLE_PANEL_LEFT;
		case DOUBLE_PANEL_VERTICAL_VALUE:
			return DOUBLE_PANEL_VERTICAL;
		case TRIPLE_PANEL_HORIZONTAL_VALUE:
			return TRIPLE_PANEL_HORIZONTAL;
		case SINGLE_PANEL_VALUE:
			return SINGLE_PANEL;
		case TRIPLE_PANEL_RIGHT_VALUE:
			return TRIPLE_PANEL_RIGHT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case TRIPLE_PANEL_VERTICAL_VALUE:
			return TRIPLE_PANEL_VERTICAL;
		case TRIPLE_PANEL_TOP_VALUE:
			return TRIPLE_PANEL_TOP;
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
	private IfcWindowStyleOperationEnum(int value, String name, String literal) {
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

} //IfcWindowStyleOperationEnum
