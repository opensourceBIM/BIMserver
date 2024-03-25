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
 * A representation of the literals of the enumeration '<em><b>Ifc Surface Feature Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceFeatureTypeEnum()
 * @model
 * @generated
 */
public enum IfcSurfaceFeatureTypeEnum implements Enumerator {
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
	 * The '<em><b>SYMBOLMARKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYMBOLMARKING_VALUE
	 * @generated
	 * @ordered
	 */
	SYMBOLMARKING(1, "SYMBOLMARKING", "SYMBOLMARKING"),

	/**
	 * The '<em><b>HATCHMARKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HATCHMARKING_VALUE
	 * @generated
	 * @ordered
	 */
	HATCHMARKING(2, "HATCHMARKING", "HATCHMARKING"),

	/**
	 * The '<em><b>DEFECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFECT_VALUE
	 * @generated
	 * @ordered
	 */
	DEFECT(3, "DEFECT", "DEFECT"),

	/**
	 * The '<em><b>TRANSVERSERUMBLESTRIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSVERSERUMBLESTRIP_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSVERSERUMBLESTRIP(4, "TRANSVERSERUMBLESTRIP", "TRANSVERSERUMBLESTRIP"),

	/**
	 * The '<em><b>TREATMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TREATMENT_VALUE
	 * @generated
	 * @ordered
	 */
	TREATMENT(5, "TREATMENT", "TREATMENT"),

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
	 * The '<em><b>MARK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARK_VALUE
	 * @generated
	 * @ordered
	 */
	MARK(7, "MARK", "MARK"),

	/**
	 * The '<em><b>RUMBLESTRIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUMBLESTRIP_VALUE
	 * @generated
	 * @ordered
	 */
	RUMBLESTRIP(8, "RUMBLESTRIP", "RUMBLESTRIP"),

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
	 * The '<em><b>LINEMARKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEMARKING_VALUE
	 * @generated
	 * @ordered
	 */
	LINEMARKING(10, "LINEMARKING", "LINEMARKING"),

	/**
	 * The '<em><b>PAVEMENTSURFACEMARKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVEMENTSURFACEMARKING_VALUE
	 * @generated
	 * @ordered
	 */
	PAVEMENTSURFACEMARKING(11, "PAVEMENTSURFACEMARKING", "PAVEMENTSURFACEMARKING"),

	/**
	 * The '<em><b>TAG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG_VALUE
	 * @generated
	 * @ordered
	 */
	TAG(12, "TAG", "TAG"),

	/**
	 * The '<em><b>NONSKIDSURFACING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONSKIDSURFACING_VALUE
	 * @generated
	 * @ordered
	 */
	NONSKIDSURFACING(13, "NONSKIDSURFACING", "NONSKIDSURFACING");

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
	 * The '<em><b>SYMBOLMARKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYMBOLMARKING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYMBOLMARKING_VALUE = 1;

	/**
	 * The '<em><b>HATCHMARKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HATCHMARKING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HATCHMARKING_VALUE = 2;

	/**
	 * The '<em><b>DEFECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEFECT_VALUE = 3;

	/**
	 * The '<em><b>TRANSVERSERUMBLESTRIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSVERSERUMBLESTRIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSVERSERUMBLESTRIP_VALUE = 4;

	/**
	 * The '<em><b>TREATMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TREATMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TREATMENT_VALUE = 5;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 6;

	/**
	 * The '<em><b>MARK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MARK_VALUE = 7;

	/**
	 * The '<em><b>RUMBLESTRIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUMBLESTRIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUMBLESTRIP_VALUE = 8;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 9;

	/**
	 * The '<em><b>LINEMARKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEMARKING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEMARKING_VALUE = 10;

	/**
	 * The '<em><b>PAVEMENTSURFACEMARKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVEMENTSURFACEMARKING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PAVEMENTSURFACEMARKING_VALUE = 11;

	/**
	 * The '<em><b>TAG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TAG_VALUE = 12;

	/**
	 * The '<em><b>NONSKIDSURFACING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONSKIDSURFACING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONSKIDSURFACING_VALUE = 13;

	/**
	 * An array of all the '<em><b>Ifc Surface Feature Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSurfaceFeatureTypeEnum[] VALUES_ARRAY = new IfcSurfaceFeatureTypeEnum[] { NULL,
			SYMBOLMARKING, HATCHMARKING, DEFECT, TRANSVERSERUMBLESTRIP, TREATMENT, USERDEFINED, MARK, RUMBLESTRIP,
			NOTDEFINED, LINEMARKING, PAVEMENTSURFACEMARKING, TAG, NONSKIDSURFACING, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Surface Feature Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSurfaceFeatureTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Surface Feature Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSurfaceFeatureTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSurfaceFeatureTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Surface Feature Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSurfaceFeatureTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSurfaceFeatureTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Surface Feature Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSurfaceFeatureTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SYMBOLMARKING_VALUE:
			return SYMBOLMARKING;
		case HATCHMARKING_VALUE:
			return HATCHMARKING;
		case DEFECT_VALUE:
			return DEFECT;
		case TRANSVERSERUMBLESTRIP_VALUE:
			return TRANSVERSERUMBLESTRIP;
		case TREATMENT_VALUE:
			return TREATMENT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case MARK_VALUE:
			return MARK;
		case RUMBLESTRIP_VALUE:
			return RUMBLESTRIP;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case LINEMARKING_VALUE:
			return LINEMARKING;
		case PAVEMENTSURFACEMARKING_VALUE:
			return PAVEMENTSURFACEMARKING;
		case TAG_VALUE:
			return TAG;
		case NONSKIDSURFACING_VALUE:
			return NONSKIDSURFACING;
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
	private IfcSurfaceFeatureTypeEnum(int value, String name, String literal) {
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

} //IfcSurfaceFeatureTypeEnum
