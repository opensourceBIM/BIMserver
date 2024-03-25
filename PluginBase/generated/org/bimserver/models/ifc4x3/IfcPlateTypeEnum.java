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
 * A representation of the literals of the enumeration '<em><b>Ifc Plate Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPlateTypeEnum()
 * @model
 * @generated
 */
public enum IfcPlateTypeEnum implements Enumerator {
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
	 * The '<em><b>GUSSET PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUSSET_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	GUSSET_PLATE(2, "GUSSET_PLATE", "GUSSET_PLATE"),

	/**
	 * The '<em><b>SPLICE PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLICE_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	SPLICE_PLATE(3, "SPLICE_PLATE", "SPLICE_PLATE"),

	/**
	 * The '<em><b>COVER PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COVER_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	COVER_PLATE(4, "COVER_PLATE", "COVER_PLATE"),

	/**
	 * The '<em><b>CURTAIN PANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURTAIN_PANEL_VALUE
	 * @generated
	 * @ordered
	 */
	CURTAIN_PANEL(5, "CURTAIN_PANEL", "CURTAIN_PANEL"),

	/**
	 * The '<em><b>FLANGE PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLANGE_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	FLANGE_PLATE(6, "FLANGE_PLATE", "FLANGE_PLATE"),

	/**
	 * The '<em><b>STIFFENER PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STIFFENER_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	STIFFENER_PLATE(7, "STIFFENER_PLATE", "STIFFENER_PLATE"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(8, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SHEET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEET_VALUE
	 * @generated
	 * @ordered
	 */
	SHEET(9, "SHEET", "SHEET"),

	/**
	 * The '<em><b>BASE PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_PLATE(10, "BASE_PLATE", "BASE_PLATE"),

	/**
	 * The '<em><b>WEB PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEB_PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	WEB_PLATE(11, "WEB_PLATE", "WEB_PLATE");

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
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 1;

	/**
	 * The '<em><b>GUSSET PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUSSET_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUSSET_PLATE_VALUE = 2;

	/**
	 * The '<em><b>SPLICE PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPLICE_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPLICE_PLATE_VALUE = 3;

	/**
	 * The '<em><b>COVER PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COVER_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COVER_PLATE_VALUE = 4;

	/**
	 * The '<em><b>CURTAIN PANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURTAIN_PANEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CURTAIN_PANEL_VALUE = 5;

	/**
	 * The '<em><b>FLANGE PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLANGE_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLANGE_PLATE_VALUE = 6;

	/**
	 * The '<em><b>STIFFENER PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STIFFENER_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STIFFENER_PLATE_VALUE = 7;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 8;

	/**
	 * The '<em><b>SHEET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHEET_VALUE = 9;

	/**
	 * The '<em><b>BASE PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASE_PLATE_VALUE = 10;

	/**
	 * The '<em><b>WEB PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEB_PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEB_PLATE_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Plate Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcPlateTypeEnum[] VALUES_ARRAY = new IfcPlateTypeEnum[] { NULL, NOTDEFINED, GUSSET_PLATE,
			SPLICE_PLATE, COVER_PLATE, CURTAIN_PANEL, FLANGE_PLATE, STIFFENER_PLATE, USERDEFINED, SHEET, BASE_PLATE,
			WEB_PLATE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Plate Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcPlateTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Plate Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPlateTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcPlateTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Plate Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPlateTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcPlateTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Plate Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPlateTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case GUSSET_PLATE_VALUE:
			return GUSSET_PLATE;
		case SPLICE_PLATE_VALUE:
			return SPLICE_PLATE;
		case COVER_PLATE_VALUE:
			return COVER_PLATE;
		case CURTAIN_PANEL_VALUE:
			return CURTAIN_PANEL;
		case FLANGE_PLATE_VALUE:
			return FLANGE_PLATE;
		case STIFFENER_PLATE_VALUE:
			return STIFFENER_PLATE;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case SHEET_VALUE:
			return SHEET;
		case BASE_PLATE_VALUE:
			return BASE_PLATE;
		case WEB_PLATE_VALUE:
			return WEB_PLATE;
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
	private IfcPlateTypeEnum(int value, String name, String literal) {
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

} //IfcPlateTypeEnum
