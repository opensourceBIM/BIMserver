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
 * A representation of the literals of the enumeration '<em><b>Ifc Valve Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcValveTypeEnum()
 * @model
 * @generated
 */
public enum IfcValveTypeEnum implements Enumerator {
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
	 * The '<em><b>COMMISSIONING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING_VALUE
	 * @generated
	 * @ordered
	 */
	COMMISSIONING(1, "COMMISSIONING", "COMMISSIONING"),

	/**
	 * The '<em><b>CHANGEOVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGEOVER_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGEOVER(2, "CHANGEOVER", "CHANGEOVER"),

	/**
	 * The '<em><b>DIVERTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVERTING_VALUE
	 * @generated
	 * @ordered
	 */
	DIVERTING(3, "DIVERTING", "DIVERTING"),

	/**
	 * The '<em><b>GASTAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASTAP_VALUE
	 * @generated
	 * @ordered
	 */
	GASTAP(4, "GASTAP", "GASTAP"),

	/**
	 * The '<em><b>ANTIVACUUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTIVACUUM_VALUE
	 * @generated
	 * @ordered
	 */
	ANTIVACUUM(5, "ANTIVACUUM", "ANTIVACUUM"),

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
	 * The '<em><b>AIRRELEASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIRRELEASE_VALUE
	 * @generated
	 * @ordered
	 */
	AIRRELEASE(7, "AIRRELEASE", "AIRRELEASE"),

	/**
	 * The '<em><b>REGULATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGULATING_VALUE
	 * @generated
	 * @ordered
	 */
	REGULATING(8, "REGULATING", "REGULATING"),

	/**
	 * The '<em><b>PRESSUREREDUCING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSUREREDUCING_VALUE
	 * @generated
	 * @ordered
	 */
	PRESSUREREDUCING(9, "PRESSUREREDUCING", "PRESSUREREDUCING"),

	/**
	 * The '<em><b>STEAMTRAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEAMTRAP_VALUE
	 * @generated
	 * @ordered
	 */
	STEAMTRAP(10, "STEAMTRAP", "STEAMTRAP"),

	/**
	 * The '<em><b>DOUBLECHECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLECHECK_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLECHECK(11, "DOUBLECHECK", "DOUBLECHECK"),

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
	 * The '<em><b>MIXING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIXING_VALUE
	 * @generated
	 * @ordered
	 */
	MIXING(13, "MIXING", "MIXING"),

	/**
	 * The '<em><b>PRESSURERELIEF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSURERELIEF_VALUE
	 * @generated
	 * @ordered
	 */
	PRESSURERELIEF(14, "PRESSURERELIEF", "PRESSURERELIEF"),

	/**
	 * The '<em><b>STOPCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOPCOCK_VALUE
	 * @generated
	 * @ordered
	 */
	STOPCOCK(15, "STOPCOCK", "STOPCOCK"),

	/**
	 * The '<em><b>FLUSHING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLUSHING_VALUE
	 * @generated
	 * @ordered
	 */
	FLUSHING(16, "FLUSHING", "FLUSHING"),

	/**
	 * The '<em><b>ISOLATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ISOLATING_VALUE
	 * @generated
	 * @ordered
	 */
	ISOLATING(17, "ISOLATING", "ISOLATING"),

	/**
	 * The '<em><b>FAUCET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAUCET_VALUE
	 * @generated
	 * @ordered
	 */
	FAUCET(18, "FAUCET", "FAUCET"),

	/**
	 * The '<em><b>SAFETYCUTOFF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAFETYCUTOFF_VALUE
	 * @generated
	 * @ordered
	 */
	SAFETYCUTOFF(19, "SAFETYCUTOFF", "SAFETYCUTOFF"),

	/**
	 * The '<em><b>CHECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHECK_VALUE
	 * @generated
	 * @ordered
	 */
	CHECK(20, "CHECK", "CHECK"),

	/**
	 * The '<em><b>DRAWOFFCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAWOFFCOCK_VALUE
	 * @generated
	 * @ordered
	 */
	DRAWOFFCOCK(21, "DRAWOFFCOCK", "DRAWOFFCOCK"),

	/**
	 * The '<em><b>GASCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASCOCK_VALUE
	 * @generated
	 * @ordered
	 */
	GASCOCK(22, "GASCOCK", "GASCOCK"),

	/**
	 * The '<em><b>DOUBLEREGULATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLEREGULATING_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLEREGULATING(23, "DOUBLEREGULATING", "DOUBLEREGULATING");

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
	 * The '<em><b>COMMISSIONING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMISSIONING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMMISSIONING_VALUE = 1;

	/**
	 * The '<em><b>CHANGEOVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGEOVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGEOVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGEOVER_VALUE = 2;

	/**
	 * The '<em><b>DIVERTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIVERTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVERTING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIVERTING_VALUE = 3;

	/**
	 * The '<em><b>GASTAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASTAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASTAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASTAP_VALUE = 4;

	/**
	 * The '<em><b>ANTIVACUUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTIVACUUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTIVACUUM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANTIVACUUM_VALUE = 5;

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
	public static final int USERDEFINED_VALUE = 6;

	/**
	 * The '<em><b>AIRRELEASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIRRELEASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIRRELEASE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIRRELEASE_VALUE = 7;

	/**
	 * The '<em><b>REGULATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGULATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGULATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGULATING_VALUE = 8;

	/**
	 * The '<em><b>PRESSUREREDUCING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSUREREDUCING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSUREREDUCING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSUREREDUCING_VALUE = 9;

	/**
	 * The '<em><b>STEAMTRAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEAMTRAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEAMTRAP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEAMTRAP_VALUE = 10;

	/**
	 * The '<em><b>DOUBLECHECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLECHECK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLECHECK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLECHECK_VALUE = 11;

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
	public static final int NOTDEFINED_VALUE = 12;

	/**
	 * The '<em><b>MIXING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MIXING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIXING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MIXING_VALUE = 13;

	/**
	 * The '<em><b>PRESSURERELIEF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSURERELIEF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSURERELIEF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSURERELIEF_VALUE = 14;

	/**
	 * The '<em><b>STOPCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOPCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOPCOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STOPCOCK_VALUE = 15;

	/**
	 * The '<em><b>FLUSHING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLUSHING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLUSHING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLUSHING_VALUE = 16;

	/**
	 * The '<em><b>ISOLATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ISOLATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ISOLATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ISOLATING_VALUE = 17;

	/**
	 * The '<em><b>FAUCET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAUCET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAUCET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAUCET_VALUE = 18;

	/**
	 * The '<em><b>SAFETYCUTOFF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAFETYCUTOFF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAFETYCUTOFF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAFETYCUTOFF_VALUE = 19;

	/**
	 * The '<em><b>CHECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHECK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHECK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHECK_VALUE = 20;

	/**
	 * The '<em><b>DRAWOFFCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DRAWOFFCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRAWOFFCOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRAWOFFCOCK_VALUE = 21;

	/**
	 * The '<em><b>GASCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASCOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASCOCK_VALUE = 22;

	/**
	 * The '<em><b>DOUBLEREGULATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLEREGULATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLEREGULATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLEREGULATING_VALUE = 23;

	/**
	 * An array of all the '<em><b>Ifc Valve Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcValveTypeEnum[] VALUES_ARRAY = new IfcValveTypeEnum[] { NULL, COMMISSIONING, CHANGEOVER,
			DIVERTING, GASTAP, ANTIVACUUM, USERDEFINED, AIRRELEASE, REGULATING, PRESSUREREDUCING, STEAMTRAP,
			DOUBLECHECK, NOTDEFINED, MIXING, PRESSURERELIEF, STOPCOCK, FLUSHING, ISOLATING, FAUCET, SAFETYCUTOFF, CHECK,
			DRAWOFFCOCK, GASCOCK, DOUBLEREGULATING, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Valve Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcValveTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcValveTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcValveTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcValveTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcValveTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcValveTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case COMMISSIONING_VALUE:
			return COMMISSIONING;
		case CHANGEOVER_VALUE:
			return CHANGEOVER;
		case DIVERTING_VALUE:
			return DIVERTING;
		case GASTAP_VALUE:
			return GASTAP;
		case ANTIVACUUM_VALUE:
			return ANTIVACUUM;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case AIRRELEASE_VALUE:
			return AIRRELEASE;
		case REGULATING_VALUE:
			return REGULATING;
		case PRESSUREREDUCING_VALUE:
			return PRESSUREREDUCING;
		case STEAMTRAP_VALUE:
			return STEAMTRAP;
		case DOUBLECHECK_VALUE:
			return DOUBLECHECK;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case MIXING_VALUE:
			return MIXING;
		case PRESSURERELIEF_VALUE:
			return PRESSURERELIEF;
		case STOPCOCK_VALUE:
			return STOPCOCK;
		case FLUSHING_VALUE:
			return FLUSHING;
		case ISOLATING_VALUE:
			return ISOLATING;
		case FAUCET_VALUE:
			return FAUCET;
		case SAFETYCUTOFF_VALUE:
			return SAFETYCUTOFF;
		case CHECK_VALUE:
			return CHECK;
		case DRAWOFFCOCK_VALUE:
			return DRAWOFFCOCK;
		case GASCOCK_VALUE:
			return GASCOCK;
		case DOUBLEREGULATING_VALUE:
			return DOUBLEREGULATING;
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
	private IfcValveTypeEnum(int value, String name, String literal) {
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

} //IfcValveTypeEnum
