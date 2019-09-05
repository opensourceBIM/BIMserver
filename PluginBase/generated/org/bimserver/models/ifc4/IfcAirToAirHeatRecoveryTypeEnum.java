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
package org.bimserver.models.ifc4;

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
 * A representation of the literals of the enumeration '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcAirToAirHeatRecoveryTypeEnum()
 * @model
 * @generated
 */
public enum IfcAirToAirHeatRecoveryTypeEnum implements Enumerator {
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
	 * The '<em><b>RUNAROUNDCOILLOOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNAROUNDCOILLOOP_VALUE
	 * @generated
	 * @ordered
	 */
	RUNAROUNDCOILLOOP(1, "RUNAROUNDCOILLOOP", "RUNAROUNDCOILLOOP"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECOUNTERFLOWEXCHANGER_VALUE
	 * @generated
	 * @ordered
	 */
	FIXEDPLATECOUNTERFLOWEXCHANGER(3, "FIXEDPLATECOUNTERFLOWEXCHANGER", "FIXEDPLATECOUNTERFLOWEXCHANGER"),

	/**
	 * The '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_VALUE
	 * @generated
	 * @ordered
	 */
	THERMOSIPHONSEALEDTUBEHEATEXCHANGERS(4, "THERMOSIPHONSEALEDTUBEHEATEXCHANGERS", "THERMOSIPHONSEALEDTUBEHEATEXCHANGERS"),

	/**
	 * The '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECROSSFLOWEXCHANGER_VALUE
	 * @generated
	 * @ordered
	 */
	FIXEDPLATECROSSFLOWEXCHANGER(5, "FIXEDPLATECROSSFLOWEXCHANGER", "FIXEDPLATECROSSFLOWEXCHANGER"),

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
	 * The '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWINTOWERENTHALPYRECOVERYLOOPS_VALUE
	 * @generated
	 * @ordered
	 */
	TWINTOWERENTHALPYRECOVERYLOOPS(7, "TWINTOWERENTHALPYRECOVERYLOOPS", "TWINTOWERENTHALPYRECOVERYLOOPS"),

	/**
	 * The '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATEPARALLELFLOWEXCHANGER_VALUE
	 * @generated
	 * @ordered
	 */
	FIXEDPLATEPARALLELFLOWEXCHANGER(8, "FIXEDPLATEPARALLELFLOWEXCHANGER", "FIXEDPLATEPARALLELFLOWEXCHANGER"),

	/**
	 * The '<em><b>ROTARYWHEEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARYWHEEL_VALUE
	 * @generated
	 * @ordered
	 */
	ROTARYWHEEL(9, "ROTARYWHEEL", "ROTARYWHEEL"),

	/**
	 * The '<em><b>HEATPIPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATPIPE_VALUE
	 * @generated
	 * @ordered
	 */
	HEATPIPE(10, "HEATPIPE", "HEATPIPE"),

	/**
	 * The '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONCOILTYPEHEATEXCHANGERS_VALUE
	 * @generated
	 * @ordered
	 */
	THERMOSIPHONCOILTYPEHEATEXCHANGERS(11, "THERMOSIPHONCOILTYPEHEATEXCHANGERS", "THERMOSIPHONCOILTYPEHEATEXCHANGERS");

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
	 * The '<em><b>RUNAROUNDCOILLOOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUNAROUNDCOILLOOP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNAROUNDCOILLOOP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUNAROUNDCOILLOOP_VALUE = 1;

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
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECOUNTERFLOWEXCHANGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATECOUNTERFLOWEXCHANGER_VALUE = 3;

	/**
	 * The '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONSEALEDTUBEHEATEXCHANGERS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_VALUE = 4;

	/**
	 * The '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECROSSFLOWEXCHANGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATECROSSFLOWEXCHANGER_VALUE = 5;

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
	 * The '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWINTOWERENTHALPYRECOVERYLOOPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWINTOWERENTHALPYRECOVERYLOOPS_VALUE = 7;

	/**
	 * The '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATEPARALLELFLOWEXCHANGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATEPARALLELFLOWEXCHANGER_VALUE = 8;

	/**
	 * The '<em><b>ROTARYWHEEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARYWHEEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARYWHEEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARYWHEEL_VALUE = 9;

	/**
	 * The '<em><b>HEATPIPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATPIPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATPIPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATPIPE_VALUE = 10;

	/**
	 * The '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONCOILTYPEHEATEXCHANGERS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMOSIPHONCOILTYPEHEATEXCHANGERS_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcAirToAirHeatRecoveryTypeEnum[] VALUES_ARRAY = new IfcAirToAirHeatRecoveryTypeEnum[] { NULL, RUNAROUNDCOILLOOP, NOTDEFINED, FIXEDPLATECOUNTERFLOWEXCHANGER, THERMOSIPHONSEALEDTUBEHEATEXCHANGERS,
			FIXEDPLATECROSSFLOWEXCHANGER, USERDEFINED, TWINTOWERENTHALPYRECOVERYLOOPS, FIXEDPLATEPARALLELFLOWEXCHANGER, ROTARYWHEEL, HEATPIPE, THERMOSIPHONCOILTYPEHEATEXCHANGERS, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcAirToAirHeatRecoveryTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAirToAirHeatRecoveryTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcAirToAirHeatRecoveryTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case RUNAROUNDCOILLOOP_VALUE:
			return RUNAROUNDCOILLOOP;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case FIXEDPLATECOUNTERFLOWEXCHANGER_VALUE:
			return FIXEDPLATECOUNTERFLOWEXCHANGER;
		case THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_VALUE:
			return THERMOSIPHONSEALEDTUBEHEATEXCHANGERS;
		case FIXEDPLATECROSSFLOWEXCHANGER_VALUE:
			return FIXEDPLATECROSSFLOWEXCHANGER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case TWINTOWERENTHALPYRECOVERYLOOPS_VALUE:
			return TWINTOWERENTHALPYRECOVERYLOOPS;
		case FIXEDPLATEPARALLELFLOWEXCHANGER_VALUE:
			return FIXEDPLATEPARALLELFLOWEXCHANGER;
		case ROTARYWHEEL_VALUE:
			return ROTARYWHEEL;
		case HEATPIPE_VALUE:
			return HEATPIPE;
		case THERMOSIPHONCOILTYPEHEATEXCHANGERS_VALUE:
			return THERMOSIPHONCOILTYPEHEATEXCHANGERS;
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
	private IfcAirToAirHeatRecoveryTypeEnum(int value, String name, String literal) {
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

} //IfcAirToAirHeatRecoveryTypeEnum
