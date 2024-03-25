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
 * A representation of the literals of the enumeration '<em><b>Ifc Beam Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBeamTypeEnum()
 * @model
 * @generated
 */
public enum IfcBeamTypeEnum implements Enumerator {
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
	 * The '<em><b>EDGEBEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EDGEBEAM_VALUE
	 * @generated
	 * @ordered
	 */
	EDGEBEAM(1, "EDGEBEAM", "EDGEBEAM"),

	/**
	 * The '<em><b>GIRDER SEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER_SEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	GIRDER_SEGMENT(2, "GIRDER_SEGMENT", "GIRDER_SEGMENT"),

	/**
	 * The '<em><b>TBEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TBEAM_VALUE
	 * @generated
	 * @ordered
	 */
	TBEAM(3, "T_BEAM", "T_BEAM"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(4, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>BEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEAM_VALUE
	 * @generated
	 * @ordered
	 */
	BEAM(5, "BEAM", "BEAM"),

	/**
	 * The '<em><b>DIAPHRAGM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAPHRAGM_VALUE
	 * @generated
	 * @ordered
	 */
	DIAPHRAGM(6, "DIAPHRAGM", "DIAPHRAGM"),

	/**
	 * The '<em><b>JOIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIST_VALUE
	 * @generated
	 * @ordered
	 */
	JOIST(7, "JOIST", "JOIST"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(8, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>HATSTONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HATSTONE_VALUE
	 * @generated
	 * @ordered
	 */
	HATSTONE(9, "HATSTONE", "HATSTONE"),

	/**
	 * The '<em><b>LINTEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINTEL_VALUE
	 * @generated
	 * @ordered
	 */
	LINTEL(10, "LINTEL", "LINTEL"),

	/**
	 * The '<em><b>SPANDREL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPANDREL_VALUE
	 * @generated
	 * @ordered
	 */
	SPANDREL(11, "SPANDREL", "SPANDREL"),

	/**
	 * The '<em><b>PIERCAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIERCAP_VALUE
	 * @generated
	 * @ordered
	 */
	PIERCAP(12, "PIERCAP", "PIERCAP"),

	/**
	 * The '<em><b>CORNICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORNICE_VALUE
	 * @generated
	 * @ordered
	 */
	CORNICE(13, "CORNICE", "CORNICE"),

	/**
	 * The '<em><b>HOLLOWCORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOLLOWCORE_VALUE
	 * @generated
	 * @ordered
	 */
	HOLLOWCORE(14, "HOLLOWCORE", "HOLLOWCORE");

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
	 * The '<em><b>EDGEBEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EDGEBEAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EDGEBEAM_VALUE = 1;

	/**
	 * The '<em><b>GIRDER SEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER_SEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIRDER_SEGMENT_VALUE = 2;

	/**
	 * The '<em><b>TBEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TBEAM
	 * @model name="T_BEAM"
	 * @generated
	 * @ordered
	 */
	public static final int TBEAM_VALUE = 3;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 4;

	/**
	 * The '<em><b>BEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEAM_VALUE = 5;

	/**
	 * The '<em><b>DIAPHRAGM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAPHRAGM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIAPHRAGM_VALUE = 6;

	/**
	 * The '<em><b>JOIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOIST_VALUE = 7;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 8;

	/**
	 * The '<em><b>HATSTONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HATSTONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HATSTONE_VALUE = 9;

	/**
	 * The '<em><b>LINTEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINTEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINTEL_VALUE = 10;

	/**
	 * The '<em><b>SPANDREL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPANDREL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPANDREL_VALUE = 11;

	/**
	 * The '<em><b>PIERCAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIERCAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIERCAP_VALUE = 12;

	/**
	 * The '<em><b>CORNICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORNICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CORNICE_VALUE = 13;

	/**
	 * The '<em><b>HOLLOWCORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOLLOWCORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HOLLOWCORE_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Beam Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBeamTypeEnum[] VALUES_ARRAY = new IfcBeamTypeEnum[] { NULL, EDGEBEAM, GIRDER_SEGMENT, TBEAM,
			USERDEFINED, BEAM, DIAPHRAGM, JOIST, NOTDEFINED, HATSTONE, LINTEL, SPANDREL, PIERCAP, CORNICE,
			HOLLOWCORE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Beam Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBeamTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Beam Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBeamTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBeamTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Beam Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBeamTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBeamTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Beam Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBeamTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case EDGEBEAM_VALUE:
			return EDGEBEAM;
		case GIRDER_SEGMENT_VALUE:
			return GIRDER_SEGMENT;
		case TBEAM_VALUE:
			return TBEAM;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case BEAM_VALUE:
			return BEAM;
		case DIAPHRAGM_VALUE:
			return DIAPHRAGM;
		case JOIST_VALUE:
			return JOIST;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case HATSTONE_VALUE:
			return HATSTONE;
		case LINTEL_VALUE:
			return LINTEL;
		case SPANDREL_VALUE:
			return SPANDREL;
		case PIERCAP_VALUE:
			return PIERCAP;
		case CORNICE_VALUE:
			return CORNICE;
		case HOLLOWCORE_VALUE:
			return HOLLOWCORE;
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
	private IfcBeamTypeEnum(int value, String name, String literal) {
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

} //IfcBeamTypeEnum
