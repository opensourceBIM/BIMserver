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
 * A representation of the literals of the enumeration '<em><b>Ifc Simple Property Template Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSimplePropertyTemplateTypeEnum()
 * @model
 * @generated
 */
public enum IfcSimplePropertyTemplateTypeEnum implements Enumerator {
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
	 * The '<em><b>QTIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTIME_VALUE
	 * @generated
	 * @ordered
	 */
	QTIME(1, "Q_TIME", "Q_TIME"),

	/**
	 * The '<em><b>QLENGTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QLENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	QLENGTH(2, "Q_LENGTH", "Q_LENGTH"),

	/**
	 * The '<em><b>QVOLUME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QVOLUME_VALUE
	 * @generated
	 * @ordered
	 */
	QVOLUME(3, "Q_VOLUME", "Q_VOLUME"),

	/**
	 * The '<em><b>PTABLEVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PTABLEVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PTABLEVALUE(4, "P_TABLEVALUE", "P_TABLEVALUE"),

	/**
	 * The '<em><b>QAREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QAREA_VALUE
	 * @generated
	 * @ordered
	 */
	QAREA(5, "Q_AREA", "Q_AREA"),

	/**
	 * The '<em><b>QCOUNT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QCOUNT_VALUE
	 * @generated
	 * @ordered
	 */
	QCOUNT(6, "Q_COUNT", "Q_COUNT"),

	/**
	 * The '<em><b>QNUMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QNUMBER_VALUE
	 * @generated
	 * @ordered
	 */
	QNUMBER(7, "Q_NUMBER", "Q_NUMBER"),

	/**
	 * The '<em><b>PBOUNDEDVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PBOUNDEDVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PBOUNDEDVALUE(8, "P_BOUNDEDVALUE", "P_BOUNDEDVALUE"),

	/**
	 * The '<em><b>PSINGLEVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSINGLEVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PSINGLEVALUE(9, "P_SINGLEVALUE", "P_SINGLEVALUE"),

	/**
	 * The '<em><b>PLISTVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLISTVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PLISTVALUE(10, "P_LISTVALUE", "P_LISTVALUE"),

	/**
	 * The '<em><b>QWEIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QWEIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	QWEIGHT(11, "Q_WEIGHT", "Q_WEIGHT"),

	/**
	 * The '<em><b>PREFERENCEVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFERENCEVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PREFERENCEVALUE(12, "P_REFERENCEVALUE", "P_REFERENCEVALUE"),

	/**
	 * The '<em><b>PENUMERATEDVALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENUMERATEDVALUE_VALUE
	 * @generated
	 * @ordered
	 */
	PENUMERATEDVALUE(13, "P_ENUMERATEDVALUE", "P_ENUMERATEDVALUE");

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
	 * The '<em><b>QTIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTIME
	 * @model name="Q_TIME"
	 * @generated
	 * @ordered
	 */
	public static final int QTIME_VALUE = 1;

	/**
	 * The '<em><b>QLENGTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QLENGTH
	 * @model name="Q_LENGTH"
	 * @generated
	 * @ordered
	 */
	public static final int QLENGTH_VALUE = 2;

	/**
	 * The '<em><b>QVOLUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QVOLUME
	 * @model name="Q_VOLUME"
	 * @generated
	 * @ordered
	 */
	public static final int QVOLUME_VALUE = 3;

	/**
	 * The '<em><b>PTABLEVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PTABLEVALUE
	 * @model name="P_TABLEVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PTABLEVALUE_VALUE = 4;

	/**
	 * The '<em><b>QAREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QAREA
	 * @model name="Q_AREA"
	 * @generated
	 * @ordered
	 */
	public static final int QAREA_VALUE = 5;

	/**
	 * The '<em><b>QCOUNT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QCOUNT
	 * @model name="Q_COUNT"
	 * @generated
	 * @ordered
	 */
	public static final int QCOUNT_VALUE = 6;

	/**
	 * The '<em><b>QNUMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QNUMBER
	 * @model name="Q_NUMBER"
	 * @generated
	 * @ordered
	 */
	public static final int QNUMBER_VALUE = 7;

	/**
	 * The '<em><b>PBOUNDEDVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PBOUNDEDVALUE
	 * @model name="P_BOUNDEDVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PBOUNDEDVALUE_VALUE = 8;

	/**
	 * The '<em><b>PSINGLEVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSINGLEVALUE
	 * @model name="P_SINGLEVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PSINGLEVALUE_VALUE = 9;

	/**
	 * The '<em><b>PLISTVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLISTVALUE
	 * @model name="P_LISTVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PLISTVALUE_VALUE = 10;

	/**
	 * The '<em><b>QWEIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QWEIGHT
	 * @model name="Q_WEIGHT"
	 * @generated
	 * @ordered
	 */
	public static final int QWEIGHT_VALUE = 11;

	/**
	 * The '<em><b>PREFERENCEVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFERENCEVALUE
	 * @model name="P_REFERENCEVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PREFERENCEVALUE_VALUE = 12;

	/**
	 * The '<em><b>PENUMERATEDVALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PENUMERATEDVALUE
	 * @model name="P_ENUMERATEDVALUE"
	 * @generated
	 * @ordered
	 */
	public static final int PENUMERATEDVALUE_VALUE = 13;

	/**
	 * An array of all the '<em><b>Ifc Simple Property Template Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSimplePropertyTemplateTypeEnum[] VALUES_ARRAY = new IfcSimplePropertyTemplateTypeEnum[] {
			NULL, QTIME, QLENGTH, QVOLUME, PTABLEVALUE, QAREA, QCOUNT, QNUMBER, PBOUNDEDVALUE, PSINGLEVALUE, PLISTVALUE,
			QWEIGHT, PREFERENCEVALUE, PENUMERATEDVALUE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Simple Property Template Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSimplePropertyTemplateTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Simple Property Template Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSimplePropertyTemplateTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSimplePropertyTemplateTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Simple Property Template Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSimplePropertyTemplateTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSimplePropertyTemplateTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Simple Property Template Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSimplePropertyTemplateTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case QTIME_VALUE:
			return QTIME;
		case QLENGTH_VALUE:
			return QLENGTH;
		case QVOLUME_VALUE:
			return QVOLUME;
		case PTABLEVALUE_VALUE:
			return PTABLEVALUE;
		case QAREA_VALUE:
			return QAREA;
		case QCOUNT_VALUE:
			return QCOUNT;
		case QNUMBER_VALUE:
			return QNUMBER;
		case PBOUNDEDVALUE_VALUE:
			return PBOUNDEDVALUE;
		case PSINGLEVALUE_VALUE:
			return PSINGLEVALUE;
		case PLISTVALUE_VALUE:
			return PLISTVALUE;
		case QWEIGHT_VALUE:
			return QWEIGHT;
		case PREFERENCEVALUE_VALUE:
			return PREFERENCEVALUE;
		case PENUMERATEDVALUE_VALUE:
			return PENUMERATEDVALUE;
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
	private IfcSimplePropertyTemplateTypeEnum(int value, String name, String literal) {
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

} //IfcSimplePropertyTemplateTypeEnum
