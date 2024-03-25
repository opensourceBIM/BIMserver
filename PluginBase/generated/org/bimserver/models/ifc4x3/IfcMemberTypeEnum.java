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
 * A representation of the literals of the enumeration '<em><b>Ifc Member Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMemberTypeEnum()
 * @model
 * @generated
 */
public enum IfcMemberTypeEnum implements Enumerator {
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
	 * The '<em><b>SUSPENDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENDER_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDER(1, "SUSPENDER", "SUSPENDER"),

	/**
	 * The '<em><b>POST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_VALUE
	 * @generated
	 * @ordered
	 */
	POST(2, "POST", "POST"),

	/**
	 * The '<em><b>RAFTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAFTER_VALUE
	 * @generated
	 * @ordered
	 */
	RAFTER(3, "RAFTER", "RAFTER"),

	/**
	 * The '<em><b>STRUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUT_VALUE
	 * @generated
	 * @ordered
	 */
	STRUT(4, "STRUT", "STRUT"),

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
	 * The '<em><b>SUSPENSION CABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSION_CABLE_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENSION_CABLE(6, "SUSPENSION_CABLE", "SUSPENSION_CABLE"),

	/**
	 * The '<em><b>COLLAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLAR_VALUE
	 * @generated
	 * @ordered
	 */
	COLLAR(7, "COLLAR", "COLLAR"),

	/**
	 * The '<em><b>CHORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHORD_VALUE
	 * @generated
	 * @ordered
	 */
	CHORD(8, "CHORD", "CHORD"),

	/**
	 * The '<em><b>MEMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBER_VALUE
	 * @generated
	 * @ordered
	 */
	MEMBER(9, "MEMBER", "MEMBER"),

	/**
	 * The '<em><b>STAY CABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAY_CABLE_VALUE
	 * @generated
	 * @ordered
	 */
	STAY_CABLE(10, "STAY_CABLE", "STAY_CABLE"),

	/**
	 * The '<em><b>STIFFENING RIB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STIFFENING_RIB_VALUE
	 * @generated
	 * @ordered
	 */
	STIFFENING_RIB(11, "STIFFENING_RIB", "STIFFENING_RIB"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(12, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>PURLIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURLIN_VALUE
	 * @generated
	 * @ordered
	 */
	PURLIN(13, "PURLIN", "PURLIN"),

	/**
	 * The '<em><b>STUD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUD_VALUE
	 * @generated
	 * @ordered
	 */
	STUD(14, "STUD", "STUD"),

	/**
	 * The '<em><b>ARCH SEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCH_SEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ARCH_SEGMENT(15, "ARCH_SEGMENT", "ARCH_SEGMENT"),

	/**
	 * The '<em><b>BRACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRACE_VALUE
	 * @generated
	 * @ordered
	 */
	BRACE(16, "BRACE", "BRACE"),

	/**
	 * The '<em><b>PLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLATE_VALUE
	 * @generated
	 * @ordered
	 */
	PLATE(17, "PLATE", "PLATE"),

	/**
	 * The '<em><b>STRINGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRINGER_VALUE
	 * @generated
	 * @ordered
	 */
	STRINGER(18, "STRINGER", "STRINGER"),

	/**
	 * The '<em><b>MULLION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULLION_VALUE
	 * @generated
	 * @ordered
	 */
	MULLION(19, "MULLION", "MULLION"),

	/**
	 * The '<em><b>STRUCTURALCABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALCABLE_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURALCABLE(20, "STRUCTURALCABLE", "STRUCTURALCABLE"),

	/**
	 * The '<em><b>TIEBAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIEBAR_VALUE
	 * @generated
	 * @ordered
	 */
	TIEBAR(21, "TIEBAR", "TIEBAR");

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
	 * The '<em><b>SUSPENDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDER_VALUE = 1;

	/**
	 * The '<em><b>POST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POST_VALUE = 2;

	/**
	 * The '<em><b>RAFTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAFTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAFTER_VALUE = 3;

	/**
	 * The '<em><b>STRUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUT_VALUE = 4;

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
	 * The '<em><b>SUSPENSION CABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSION_CABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENSION_CABLE_VALUE = 6;

	/**
	 * The '<em><b>COLLAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLLAR_VALUE = 7;

	/**
	 * The '<em><b>CHORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHORD_VALUE = 8;

	/**
	 * The '<em><b>MEMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEMBER_VALUE = 9;

	/**
	 * The '<em><b>STAY CABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAY_CABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STAY_CABLE_VALUE = 10;

	/**
	 * The '<em><b>STIFFENING RIB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STIFFENING_RIB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STIFFENING_RIB_VALUE = 11;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 12;

	/**
	 * The '<em><b>PURLIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PURLIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PURLIN_VALUE = 13;

	/**
	 * The '<em><b>STUD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STUD_VALUE = 14;

	/**
	 * The '<em><b>ARCH SEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCH_SEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCH_SEGMENT_VALUE = 15;

	/**
	 * The '<em><b>BRACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRACE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRACE_VALUE = 16;

	/**
	 * The '<em><b>PLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLATE_VALUE = 17;

	/**
	 * The '<em><b>STRINGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRINGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRINGER_VALUE = 18;

	/**
	 * The '<em><b>MULLION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULLION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MULLION_VALUE = 19;

	/**
	 * The '<em><b>STRUCTURALCABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURALCABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURALCABLE_VALUE = 20;

	/**
	 * The '<em><b>TIEBAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIEBAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIEBAR_VALUE = 21;

	/**
	 * An array of all the '<em><b>Ifc Member Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcMemberTypeEnum[] VALUES_ARRAY = new IfcMemberTypeEnum[] { NULL, SUSPENDER, POST, RAFTER,
			STRUT, USERDEFINED, SUSPENSION_CABLE, COLLAR, CHORD, MEMBER, STAY_CABLE, STIFFENING_RIB, NOTDEFINED, PURLIN,
			STUD, ARCH_SEGMENT, BRACE, PLATE, STRINGER, MULLION, STRUCTURALCABLE, TIEBAR, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Member Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcMemberTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Member Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMemberTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMemberTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Member Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMemberTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMemberTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Member Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMemberTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SUSPENDER_VALUE:
			return SUSPENDER;
		case POST_VALUE:
			return POST;
		case RAFTER_VALUE:
			return RAFTER;
		case STRUT_VALUE:
			return STRUT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case SUSPENSION_CABLE_VALUE:
			return SUSPENSION_CABLE;
		case COLLAR_VALUE:
			return COLLAR;
		case CHORD_VALUE:
			return CHORD;
		case MEMBER_VALUE:
			return MEMBER;
		case STAY_CABLE_VALUE:
			return STAY_CABLE;
		case STIFFENING_RIB_VALUE:
			return STIFFENING_RIB;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case PURLIN_VALUE:
			return PURLIN;
		case STUD_VALUE:
			return STUD;
		case ARCH_SEGMENT_VALUE:
			return ARCH_SEGMENT;
		case BRACE_VALUE:
			return BRACE;
		case PLATE_VALUE:
			return PLATE;
		case STRINGER_VALUE:
			return STRINGER;
		case MULLION_VALUE:
			return MULLION;
		case STRUCTURALCABLE_VALUE:
			return STRUCTURALCABLE;
		case TIEBAR_VALUE:
			return TIEBAR;
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
	private IfcMemberTypeEnum(int value, String name, String literal) {
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

} //IfcMemberTypeEnum
