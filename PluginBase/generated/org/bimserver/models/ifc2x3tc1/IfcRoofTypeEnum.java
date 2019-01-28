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
 * A representation of the literals of the enumeration '<em><b>Ifc Roof Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcRoofTypeEnum()
 * @model
 * @generated
 */
public enum IfcRoofTypeEnum implements Enumerator {
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
	 * The '<em><b>SHED ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHED_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	SHED_ROOF(1, "SHED_ROOF", "SHED_ROOF"),

	/**
	 * The '<em><b>HIP ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIP_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	HIP_ROOF(2, "HIP_ROOF", "HIP_ROOF"),

	/**
	 * The '<em><b>FLAT ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLAT_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	FLAT_ROOF(3, "FLAT_ROOF", "FLAT_ROOF"),

	/**
	 * The '<em><b>BUTTERFLY ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUTTERFLY_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	BUTTERFLY_ROOF(4, "BUTTERFLY_ROOF", "BUTTERFLY_ROOF"),

	/**
	 * The '<em><b>RAINBOW ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAINBOW_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	RAINBOW_ROOF(5, "RAINBOW_ROOF", "RAINBOW_ROOF"),

	/**
	 * The '<em><b>BARREL ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARREL_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	BARREL_ROOF(6, "BARREL_ROOF", "BARREL_ROOF"),

	/**
	 * The '<em><b>FREEFORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREEFORM_VALUE
	 * @generated
	 * @ordered
	 */
	FREEFORM(7, "FREEFORM", "FREEFORM"),

	/**
	 * The '<em><b>HIPPED GABLE ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIPPED_GABLE_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	HIPPED_GABLE_ROOF(8, "HIPPED_GABLE_ROOF", "HIPPED_GABLE_ROOF"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(9, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>PAVILION ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVILION_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	PAVILION_ROOF(10, "PAVILION_ROOF", "PAVILION_ROOF"),

	/**
	 * The '<em><b>GABLE ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GABLE_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	GABLE_ROOF(11, "GABLE_ROOF", "GABLE_ROOF"),

	/**
	 * The '<em><b>GAMBREL ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GAMBREL_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	GAMBREL_ROOF(12, "GAMBREL_ROOF", "GAMBREL_ROOF"),

	/**
	 * The '<em><b>DOME ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOME_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	DOME_ROOF(13, "DOME_ROOF", "DOME_ROOF"),

	/**
	 * The '<em><b>MANSARD ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANSARD_ROOF_VALUE
	 * @generated
	 * @ordered
	 */
	MANSARD_ROOF(14, "MANSARD_ROOF", "MANSARD_ROOF");

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
	 * The '<em><b>SHED ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHED ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHED_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHED_ROOF_VALUE = 1;

	/**
	 * The '<em><b>HIP ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIP ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIP_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIP_ROOF_VALUE = 2;

	/**
	 * The '<em><b>FLAT ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLAT ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLAT_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLAT_ROOF_VALUE = 3;

	/**
	 * The '<em><b>BUTTERFLY ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUTTERFLY ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUTTERFLY_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUTTERFLY_ROOF_VALUE = 4;

	/**
	 * The '<em><b>RAINBOW ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RAINBOW ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAINBOW_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAINBOW_ROOF_VALUE = 5;

	/**
	 * The '<em><b>BARREL ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BARREL ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BARREL_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BARREL_ROOF_VALUE = 6;

	/**
	 * The '<em><b>FREEFORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREEFORM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREEFORM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREEFORM_VALUE = 7;

	/**
	 * The '<em><b>HIPPED GABLE ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIPPED GABLE ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIPPED_GABLE_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIPPED_GABLE_ROOF_VALUE = 8;

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
	public static final int NOTDEFINED_VALUE = 9;

	/**
	 * The '<em><b>PAVILION ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAVILION ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAVILION_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PAVILION_ROOF_VALUE = 10;

	/**
	 * The '<em><b>GABLE ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GABLE ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GABLE_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GABLE_ROOF_VALUE = 11;

	/**
	 * The '<em><b>GAMBREL ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GAMBREL ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GAMBREL_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GAMBREL_ROOF_VALUE = 12;

	/**
	 * The '<em><b>DOME ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOME ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOME_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOME_ROOF_VALUE = 13;

	/**
	 * The '<em><b>MANSARD ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANSARD ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANSARD_ROOF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANSARD_ROOF_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Roof Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoofTypeEnum[] VALUES_ARRAY = new IfcRoofTypeEnum[] { NULL, SHED_ROOF, HIP_ROOF, FLAT_ROOF,
			BUTTERFLY_ROOF, RAINBOW_ROOF, BARREL_ROOF, FREEFORM, HIPPED_GABLE_ROOF, NOTDEFINED, PAVILION_ROOF,
			GABLE_ROOF, GAMBREL_ROOF, DOME_ROOF, MANSARD_ROOF, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Roof Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcRoofTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoofTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoofTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoofTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoofTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoofTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SHED_ROOF_VALUE:
			return SHED_ROOF;
		case HIP_ROOF_VALUE:
			return HIP_ROOF;
		case FLAT_ROOF_VALUE:
			return FLAT_ROOF;
		case BUTTERFLY_ROOF_VALUE:
			return BUTTERFLY_ROOF;
		case RAINBOW_ROOF_VALUE:
			return RAINBOW_ROOF;
		case BARREL_ROOF_VALUE:
			return BARREL_ROOF;
		case FREEFORM_VALUE:
			return FREEFORM;
		case HIPPED_GABLE_ROOF_VALUE:
			return HIPPED_GABLE_ROOF;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case PAVILION_ROOF_VALUE:
			return PAVILION_ROOF;
		case GABLE_ROOF_VALUE:
			return GABLE_ROOF;
		case GAMBREL_ROOF_VALUE:
			return GAMBREL_ROOF;
		case DOME_ROOF_VALUE:
			return DOME_ROOF;
		case MANSARD_ROOF_VALUE:
			return MANSARD_ROOF;
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
	private IfcRoofTypeEnum(int value, String name, String literal) {
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

} //IfcRoofTypeEnum
