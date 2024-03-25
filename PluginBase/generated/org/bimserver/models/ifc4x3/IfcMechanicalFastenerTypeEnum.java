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
 * A representation of the literals of the enumeration '<em><b>Ifc Mechanical Fastener Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMechanicalFastenerTypeEnum()
 * @model
 * @generated
 */
public enum IfcMechanicalFastenerTypeEnum implements Enumerator {
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
	 * The '<em><b>SHEARCONNECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEARCONNECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	SHEARCONNECTOR(1, "SHEARCONNECTOR", "SHEARCONNECTOR"),

	/**
	 * The '<em><b>SCREW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCREW_VALUE
	 * @generated
	 * @ordered
	 */
	SCREW(2, "SCREW", "SCREW"),

	/**
	 * The '<em><b>NAILPLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAILPLATE_VALUE
	 * @generated
	 * @ordered
	 */
	NAILPLATE(3, "NAILPLATE", "NAILPLATE"),

	/**
	 * The '<em><b>RIVET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIVET_VALUE
	 * @generated
	 * @ordered
	 */
	RIVET(4, "RIVET", "RIVET"),

	/**
	 * The '<em><b>STAPLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAPLE_VALUE
	 * @generated
	 * @ordered
	 */
	STAPLE(5, "STAPLE", "STAPLE"),

	/**
	 * The '<em><b>ANCHORBOLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANCHORBOLT_VALUE
	 * @generated
	 * @ordered
	 */
	ANCHORBOLT(6, "ANCHORBOLT", "ANCHORBOLT"),

	/**
	 * The '<em><b>BOLT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOLT_VALUE
	 * @generated
	 * @ordered
	 */
	BOLT(7, "BOLT", "BOLT"),

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
	 * The '<em><b>RAILFASTENING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILFASTENING_VALUE
	 * @generated
	 * @ordered
	 */
	RAILFASTENING(9, "RAILFASTENING", "RAILFASTENING"),

	/**
	 * The '<em><b>CHAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAIN_VALUE
	 * @generated
	 * @ordered
	 */
	CHAIN(10, "CHAIN", "CHAIN"),

	/**
	 * The '<em><b>DOWEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOWEL_VALUE
	 * @generated
	 * @ordered
	 */
	DOWEL(11, "DOWEL", "DOWEL"),

	/**
	 * The '<em><b>COUPLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COUPLER_VALUE
	 * @generated
	 * @ordered
	 */
	COUPLER(12, "COUPLER", "COUPLER"),

	/**
	 * The '<em><b>STUDSHEARCONNECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUDSHEARCONNECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	STUDSHEARCONNECTOR(13, "STUDSHEARCONNECTOR", "STUDSHEARCONNECTOR"),

	/**
	 * The '<em><b>NAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAIL_VALUE
	 * @generated
	 * @ordered
	 */
	NAIL(14, "NAIL", "NAIL"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(15, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ROPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROPE_VALUE
	 * @generated
	 * @ordered
	 */
	ROPE(16, "ROPE", "ROPE"),

	/**
	 * The '<em><b>RAILJOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILJOINT_VALUE
	 * @generated
	 * @ordered
	 */
	RAILJOINT(17, "RAILJOINT", "RAILJOINT");

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
	 * The '<em><b>SHEARCONNECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEARCONNECTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHEARCONNECTOR_VALUE = 1;

	/**
	 * The '<em><b>SCREW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCREW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCREW_VALUE = 2;

	/**
	 * The '<em><b>NAILPLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAILPLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAILPLATE_VALUE = 3;

	/**
	 * The '<em><b>RIVET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIVET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RIVET_VALUE = 4;

	/**
	 * The '<em><b>STAPLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STAPLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STAPLE_VALUE = 5;

	/**
	 * The '<em><b>ANCHORBOLT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANCHORBOLT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANCHORBOLT_VALUE = 6;

	/**
	 * The '<em><b>BOLT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOLT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOLT_VALUE = 7;

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
	 * The '<em><b>RAILFASTENING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILFASTENING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAILFASTENING_VALUE = 9;

	/**
	 * The '<em><b>CHAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHAIN_VALUE = 10;

	/**
	 * The '<em><b>DOWEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOWEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOWEL_VALUE = 11;

	/**
	 * The '<em><b>COUPLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COUPLER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COUPLER_VALUE = 12;

	/**
	 * The '<em><b>STUDSHEARCONNECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STUDSHEARCONNECTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STUDSHEARCONNECTOR_VALUE = 13;

	/**
	 * The '<em><b>NAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAIL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAIL_VALUE = 14;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 15;

	/**
	 * The '<em><b>ROPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROPE_VALUE = 16;

	/**
	 * The '<em><b>RAILJOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILJOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAILJOINT_VALUE = 17;

	/**
	 * An array of all the '<em><b>Ifc Mechanical Fastener Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcMechanicalFastenerTypeEnum[] VALUES_ARRAY = new IfcMechanicalFastenerTypeEnum[] { NULL,
			SHEARCONNECTOR, SCREW, NAILPLATE, RIVET, STAPLE, ANCHORBOLT, BOLT, USERDEFINED, RAILFASTENING, CHAIN, DOWEL,
			COUPLER, STUDSHEARCONNECTOR, NAIL, NOTDEFINED, ROPE, RAILJOINT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Mechanical Fastener Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcMechanicalFastenerTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Mechanical Fastener Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMechanicalFastenerTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMechanicalFastenerTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Mechanical Fastener Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMechanicalFastenerTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMechanicalFastenerTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Mechanical Fastener Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMechanicalFastenerTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SHEARCONNECTOR_VALUE:
			return SHEARCONNECTOR;
		case SCREW_VALUE:
			return SCREW;
		case NAILPLATE_VALUE:
			return NAILPLATE;
		case RIVET_VALUE:
			return RIVET;
		case STAPLE_VALUE:
			return STAPLE;
		case ANCHORBOLT_VALUE:
			return ANCHORBOLT;
		case BOLT_VALUE:
			return BOLT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case RAILFASTENING_VALUE:
			return RAILFASTENING;
		case CHAIN_VALUE:
			return CHAIN;
		case DOWEL_VALUE:
			return DOWEL;
		case COUPLER_VALUE:
			return COUPLER;
		case STUDSHEARCONNECTOR_VALUE:
			return STUDSHEARCONNECTOR;
		case NAIL_VALUE:
			return NAIL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case ROPE_VALUE:
			return ROPE;
		case RAILJOINT_VALUE:
			return RAILJOINT;
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
	private IfcMechanicalFastenerTypeEnum(int value, String name, String literal) {
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

} //IfcMechanicalFastenerTypeEnum
