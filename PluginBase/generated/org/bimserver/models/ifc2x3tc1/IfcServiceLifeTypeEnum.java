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
 * A representation of the literals of the enumeration '<em><b>Ifc Service Life Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcServiceLifeTypeEnum()
 * @model
 * @generated
 */
public enum IfcServiceLifeTypeEnum implements Enumerator {
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
	 * The '<em><b>EXPECTEDSERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPECTEDSERVICELIFE_VALUE
	 * @generated
	 * @ordered
	 */
	EXPECTEDSERVICELIFE(1, "EXPECTEDSERVICELIFE", "EXPECTEDSERVICELIFE"),

	/**
	 * The '<em><b>ACTUALSERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTUALSERVICELIFE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTUALSERVICELIFE(2, "ACTUALSERVICELIFE", "ACTUALSERVICELIFE"),

	/**
	 * The '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PESSIMISTICREFERENCESERVICELIFE_VALUE
	 * @generated
	 * @ordered
	 */
	PESSIMISTICREFERENCESERVICELIFE(3, "PESSIMISTICREFERENCESERVICELIFE", "PESSIMISTICREFERENCESERVICELIFE"),

	/**
	 * The '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIMISTICREFERENCESERVICELIFE_VALUE
	 * @generated
	 * @ordered
	 */
	OPTIMISTICREFERENCESERVICELIFE(4, "OPTIMISTICREFERENCESERVICELIFE", "OPTIMISTICREFERENCESERVICELIFE"),

	/**
	 * The '<em><b>REFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCESERVICELIFE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCESERVICELIFE(5, "REFERENCESERVICELIFE", "REFERENCESERVICELIFE");

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
	 * The '<em><b>EXPECTEDSERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPECTEDSERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPECTEDSERVICELIFE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXPECTEDSERVICELIFE_VALUE = 1;

	/**
	 * The '<em><b>ACTUALSERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTUALSERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTUALSERVICELIFE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTUALSERVICELIFE_VALUE = 2;

	/**
	 * The '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PESSIMISTICREFERENCESERVICELIFE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PESSIMISTICREFERENCESERVICELIFE_VALUE = 3;

	/**
	 * The '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPTIMISTICREFERENCESERVICELIFE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPTIMISTICREFERENCESERVICELIFE_VALUE = 4;

	/**
	 * The '<em><b>REFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCESERVICELIFE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCESERVICELIFE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Ifc Service Life Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcServiceLifeTypeEnum[] VALUES_ARRAY = new IfcServiceLifeTypeEnum[] { NULL,
			EXPECTEDSERVICELIFE, ACTUALSERVICELIFE, PESSIMISTICREFERENCESERVICELIFE, OPTIMISTICREFERENCESERVICELIFE,
			REFERENCESERVICELIFE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Service Life Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcServiceLifeTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcServiceLifeTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcServiceLifeTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case EXPECTEDSERVICELIFE_VALUE:
			return EXPECTEDSERVICELIFE;
		case ACTUALSERVICELIFE_VALUE:
			return ACTUALSERVICELIFE;
		case PESSIMISTICREFERENCESERVICELIFE_VALUE:
			return PESSIMISTICREFERENCESERVICELIFE;
		case OPTIMISTICREFERENCESERVICELIFE_VALUE:
			return OPTIMISTICREFERENCESERVICELIFE;
		case REFERENCESERVICELIFE_VALUE:
			return REFERENCESERVICELIFE;
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
	private IfcServiceLifeTypeEnum(int value, String name, String literal) {
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

} //IfcServiceLifeTypeEnum
