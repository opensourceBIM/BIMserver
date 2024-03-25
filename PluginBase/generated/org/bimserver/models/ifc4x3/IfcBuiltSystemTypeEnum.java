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
 * A representation of the literals of the enumeration '<em><b>Ifc Built System Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBuiltSystemTypeEnum()
 * @model
 * @generated
 */
public enum IfcBuiltSystemTypeEnum implements Enumerator {
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
	 * The '<em><b>OUTERSHELL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTERSHELL_VALUE
	 * @generated
	 * @ordered
	 */
	OUTERSHELL(1, "OUTERSHELL", "OUTERSHELL"),

	/**
	 * The '<em><b>REINFORCING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REINFORCING_VALUE
	 * @generated
	 * @ordered
	 */
	REINFORCING(2, "REINFORCING", "REINFORCING"),

	/**
	 * The '<em><b>FENESTRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FENESTRATION_VALUE
	 * @generated
	 * @ordered
	 */
	FENESTRATION(3, "FENESTRATION", "FENESTRATION"),

	/**
	 * The '<em><b>RAILWAYLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYLINE_VALUE
	 * @generated
	 * @ordered
	 */
	RAILWAYLINE(4, "RAILWAYLINE", "RAILWAYLINE"),

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
	 * The '<em><b>EROSIONPREVENTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EROSIONPREVENTION_VALUE
	 * @generated
	 * @ordered
	 */
	EROSIONPREVENTION(6, "EROSIONPREVENTION", "EROSIONPREVENTION"),

	/**
	 * The '<em><b>FOUNDATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUNDATION_VALUE
	 * @generated
	 * @ordered
	 */
	FOUNDATION(7, "FOUNDATION", "FOUNDATION"),

	/**
	 * The '<em><b>TRANSPORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORT(8, "TRANSPORT", "TRANSPORT"),

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
	 * The '<em><b>MOORING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOORING_VALUE
	 * @generated
	 * @ordered
	 */
	MOORING(10, "MOORING", "MOORING"),

	/**
	 * The '<em><b>PRESTRESSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESTRESSING_VALUE
	 * @generated
	 * @ordered
	 */
	PRESTRESSING(11, "PRESTRESSING", "PRESTRESSING"),

	/**
	 * The '<em><b>RAILWAYTRACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYTRACK_VALUE
	 * @generated
	 * @ordered
	 */
	RAILWAYTRACK(12, "RAILWAYTRACK", "RAILWAYTRACK"),

	/**
	 * The '<em><b>TRACKCIRCUIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKCIRCUIT_VALUE
	 * @generated
	 * @ordered
	 */
	TRACKCIRCUIT(13, "TRACKCIRCUIT", "TRACKCIRCUIT"),

	/**
	 * The '<em><b>LOADBEARING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADBEARING_VALUE
	 * @generated
	 * @ordered
	 */
	LOADBEARING(14, "LOADBEARING", "LOADBEARING"),

	/**
	 * The '<em><b>SHADING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADING_VALUE
	 * @generated
	 * @ordered
	 */
	SHADING(15, "SHADING", "SHADING");

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
	 * The '<em><b>OUTERSHELL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUTERSHELL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OUTERSHELL_VALUE = 1;

	/**
	 * The '<em><b>REINFORCING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REINFORCING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REINFORCING_VALUE = 2;

	/**
	 * The '<em><b>FENESTRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FENESTRATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FENESTRATION_VALUE = 3;

	/**
	 * The '<em><b>RAILWAYLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAILWAYLINE_VALUE = 4;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 5;

	/**
	 * The '<em><b>EROSIONPREVENTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EROSIONPREVENTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EROSIONPREVENTION_VALUE = 6;

	/**
	 * The '<em><b>FOUNDATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOUNDATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOUNDATION_VALUE = 7;

	/**
	 * The '<em><b>TRANSPORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSPORT_VALUE = 8;

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
	 * The '<em><b>MOORING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOORING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOORING_VALUE = 10;

	/**
	 * The '<em><b>PRESTRESSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESTRESSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESTRESSING_VALUE = 11;

	/**
	 * The '<em><b>RAILWAYTRACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYTRACK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAILWAYTRACK_VALUE = 12;

	/**
	 * The '<em><b>TRACKCIRCUIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKCIRCUIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRACKCIRCUIT_VALUE = 13;

	/**
	 * The '<em><b>LOADBEARING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOADBEARING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOADBEARING_VALUE = 14;

	/**
	 * The '<em><b>SHADING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHADING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHADING_VALUE = 15;

	/**
	 * An array of all the '<em><b>Ifc Built System Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBuiltSystemTypeEnum[] VALUES_ARRAY = new IfcBuiltSystemTypeEnum[] { NULL, OUTERSHELL,
			REINFORCING, FENESTRATION, RAILWAYLINE, USERDEFINED, EROSIONPREVENTION, FOUNDATION, TRANSPORT, NOTDEFINED,
			MOORING, PRESTRESSING, RAILWAYTRACK, TRACKCIRCUIT, LOADBEARING, SHADING, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Built System Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBuiltSystemTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Built System Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBuiltSystemTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBuiltSystemTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Built System Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBuiltSystemTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBuiltSystemTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Built System Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBuiltSystemTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case OUTERSHELL_VALUE:
			return OUTERSHELL;
		case REINFORCING_VALUE:
			return REINFORCING;
		case FENESTRATION_VALUE:
			return FENESTRATION;
		case RAILWAYLINE_VALUE:
			return RAILWAYLINE;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case EROSIONPREVENTION_VALUE:
			return EROSIONPREVENTION;
		case FOUNDATION_VALUE:
			return FOUNDATION;
		case TRANSPORT_VALUE:
			return TRANSPORT;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case MOORING_VALUE:
			return MOORING;
		case PRESTRESSING_VALUE:
			return PRESTRESSING;
		case RAILWAYTRACK_VALUE:
			return RAILWAYTRACK;
		case TRACKCIRCUIT_VALUE:
			return TRACKCIRCUIT;
		case LOADBEARING_VALUE:
			return LOADBEARING;
		case SHADING_VALUE:
			return SHADING;
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
	private IfcBuiltSystemTypeEnum(int value, String name, String literal) {
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

} //IfcBuiltSystemTypeEnum
