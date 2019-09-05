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
 * A representation of the literals of the enumeration '<em><b>Ifc Evaporator Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcEvaporatorTypeEnum()
 * @model
 * @generated
 */
public enum IfcEvaporatorTypeEnum implements Enumerator {
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
	 * The '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONSHELLANDTUBE_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONSHELLANDTUBE(2, "DIRECTEXPANSIONSHELLANDTUBE", "DIRECTEXPANSIONSHELLANDTUBE"),

	/**
	 * The '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONTUBEINTUBE_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONTUBEINTUBE(3, "DIRECTEXPANSIONTUBEINTUBE", "DIRECTEXPANSIONTUBEINTUBE"),

	/**
	 * The '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONBRAZEDPLATE_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSIONBRAZEDPLATE(4, "DIRECTEXPANSIONBRAZEDPLATE", "DIRECTEXPANSIONBRAZEDPLATE"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(5, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>DIRECTEXPANSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSION_VALUE
	 * @generated
	 * @ordered
	 */
	DIRECTEXPANSION(6, "DIRECTEXPANSION", "DIRECTEXPANSION"),

	/**
	 * The '<em><b>SHELLANDCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHELLANDCOIL_VALUE
	 * @generated
	 * @ordered
	 */
	SHELLANDCOIL(7, "SHELLANDCOIL", "SHELLANDCOIL"),

	/**
	 * The '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOODEDSHELLANDTUBE_VALUE
	 * @generated
	 * @ordered
	 */
	FLOODEDSHELLANDTUBE(8, "FLOODEDSHELLANDTUBE", "FLOODEDSHELLANDTUBE");

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
	 * The '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONSHELLANDTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONSHELLANDTUBE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONSHELLANDTUBE_VALUE = 2;

	/**
	 * The '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONTUBEINTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONTUBEINTUBE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONTUBEINTUBE_VALUE = 3;

	/**
	 * The '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSIONBRAZEDPLATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSIONBRAZEDPLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSIONBRAZEDPLATE_VALUE = 4;

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
	public static final int USERDEFINED_VALUE = 5;

	/**
	 * The '<em><b>DIRECTEXPANSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEXPANSION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEXPANSION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEXPANSION_VALUE = 6;

	/**
	 * The '<em><b>SHELLANDCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHELLANDCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHELLANDCOIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHELLANDCOIL_VALUE = 7;

	/**
	 * The '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLOODEDSHELLANDTUBE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOODEDSHELLANDTUBE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOODEDSHELLANDTUBE_VALUE = 8;

	/**
	 * An array of all the '<em><b>Ifc Evaporator Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcEvaporatorTypeEnum[] VALUES_ARRAY = new IfcEvaporatorTypeEnum[] { NULL, NOTDEFINED, DIRECTEXPANSIONSHELLANDTUBE, DIRECTEXPANSIONTUBEINTUBE, DIRECTEXPANSIONBRAZEDPLATE, USERDEFINED, DIRECTEXPANSION, SHELLANDCOIL,
			FLOODEDSHELLANDTUBE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Evaporator Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcEvaporatorTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEvaporatorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcEvaporatorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporator Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcEvaporatorTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case DIRECTEXPANSIONSHELLANDTUBE_VALUE:
			return DIRECTEXPANSIONSHELLANDTUBE;
		case DIRECTEXPANSIONTUBEINTUBE_VALUE:
			return DIRECTEXPANSIONTUBEINTUBE;
		case DIRECTEXPANSIONBRAZEDPLATE_VALUE:
			return DIRECTEXPANSIONBRAZEDPLATE;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case DIRECTEXPANSION_VALUE:
			return DIRECTEXPANSION;
		case SHELLANDCOIL_VALUE:
			return SHELLANDCOIL;
		case FLOODEDSHELLANDTUBE_VALUE:
			return FLOODEDSHELLANDTUBE;
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
	private IfcEvaporatorTypeEnum(int value, String name, String literal) {
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

} //IfcEvaporatorTypeEnum
