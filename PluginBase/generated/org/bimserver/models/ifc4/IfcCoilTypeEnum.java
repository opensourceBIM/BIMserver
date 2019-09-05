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
 * A representation of the literals of the enumeration '<em><b>Ifc Coil Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCoilTypeEnum()
 * @model
 * @generated
 */
public enum IfcCoilTypeEnum implements Enumerator {
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
	 * The '<em><b>GASHEATINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASHEATINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	GASHEATINGCOIL(1, "GASHEATINGCOIL", "GASHEATINGCOIL"),

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
	 * The '<em><b>DXCOOLINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DXCOOLINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	DXCOOLINGCOIL(3, "DXCOOLINGCOIL", "DXCOOLINGCOIL"),

	/**
	 * The '<em><b>WATERCOOLINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	WATERCOOLINGCOIL(4, "WATERCOOLINGCOIL", "WATERCOOLINGCOIL"),

	/**
	 * The '<em><b>WATERHEATINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERHEATINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	WATERHEATINGCOIL(5, "WATERHEATINGCOIL", "WATERHEATINGCOIL"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(6, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ELECTRICHEATINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICHEATINGCOIL(7, "ELECTRICHEATINGCOIL", "ELECTRICHEATINGCOIL"),

	/**
	 * The '<em><b>HYDRONICCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDRONICCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	HYDRONICCOIL(8, "HYDRONICCOIL", "HYDRONICCOIL"),

	/**
	 * The '<em><b>STEAMHEATINGCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEAMHEATINGCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	STEAMHEATINGCOIL(9, "STEAMHEATINGCOIL", "STEAMHEATINGCOIL");

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
	 * The '<em><b>GASHEATINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASHEATINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASHEATINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASHEATINGCOIL_VALUE = 1;

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
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>DXCOOLINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DXCOOLINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DXCOOLINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DXCOOLINGCOIL_VALUE = 3;

	/**
	 * The '<em><b>WATERCOOLINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLINGCOIL_VALUE = 4;

	/**
	 * The '<em><b>WATERHEATINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERHEATINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERHEATINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERHEATINGCOIL_VALUE = 5;

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
	public static final int USERDEFINED_VALUE = 6;

	/**
	 * The '<em><b>ELECTRICHEATINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICHEATINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICHEATINGCOIL_VALUE = 7;

	/**
	 * The '<em><b>HYDRONICCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HYDRONICCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYDRONICCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HYDRONICCOIL_VALUE = 8;

	/**
	 * The '<em><b>STEAMHEATINGCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEAMHEATINGCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEAMHEATINGCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEAMHEATINGCOIL_VALUE = 9;

	/**
	 * An array of all the '<em><b>Ifc Coil Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCoilTypeEnum[] VALUES_ARRAY = new IfcCoilTypeEnum[] { NULL, GASHEATINGCOIL, NOTDEFINED, DXCOOLINGCOIL, WATERCOOLINGCOIL, WATERHEATINGCOIL, USERDEFINED, ELECTRICHEATINGCOIL, HYDRONICCOIL, STEAMHEATINGCOIL, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Coil Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCoilTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Coil Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoilTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCoilTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Coil Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoilTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCoilTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Coil Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCoilTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case GASHEATINGCOIL_VALUE:
			return GASHEATINGCOIL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case DXCOOLINGCOIL_VALUE:
			return DXCOOLINGCOIL;
		case WATERCOOLINGCOIL_VALUE:
			return WATERCOOLINGCOIL;
		case WATERHEATINGCOIL_VALUE:
			return WATERHEATINGCOIL;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ELECTRICHEATINGCOIL_VALUE:
			return ELECTRICHEATINGCOIL;
		case HYDRONICCOIL_VALUE:
			return HYDRONICCOIL;
		case STEAMHEATINGCOIL_VALUE:
			return STEAMHEATINGCOIL;
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
	private IfcCoilTypeEnum(int value, String name, String literal) {
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

} //IfcCoilTypeEnum
