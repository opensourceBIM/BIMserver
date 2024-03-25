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
 * A representation of the literals of the enumeration '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcElectricFlowStorageDeviceTypeEnum()
 * @model
 * @generated
 */
public enum IfcElectricFlowStorageDeviceTypeEnum implements Enumerator {
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
	 * The '<em><b>BATTERY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BATTERY_VALUE
	 * @generated
	 * @ordered
	 */
	BATTERY(1, "BATTERY", "BATTERY"),

	/**
	 * The '<em><b>CAPACITORBANK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPACITORBANK_VALUE
	 * @generated
	 * @ordered
	 */
	CAPACITORBANK(2, "CAPACITORBANK", "CAPACITORBANK"),

	/**
	 * The '<em><b>COMPENSATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPENSATOR_VALUE
	 * @generated
	 * @ordered
	 */
	COMPENSATOR(3, "COMPENSATOR", "COMPENSATOR"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>CAPACITOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPACITOR_VALUE
	 * @generated
	 * @ordered
	 */
	CAPACITOR(5, "CAPACITOR", "CAPACITOR"),

	/**
	 * The '<em><b>INDUCTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTOR_VALUE
	 * @generated
	 * @ordered
	 */
	INDUCTOR(6, "INDUCTOR", "INDUCTOR"),

	/**
	 * The '<em><b>HARMONICFILTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARMONICFILTER_VALUE
	 * @generated
	 * @ordered
	 */
	HARMONICFILTER(7, "HARMONICFILTER", "HARMONICFILTER"),

	/**
	 * The '<em><b>UPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPS_VALUE
	 * @generated
	 * @ordered
	 */
	UPS(8, "UPS", "UPS"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>INDUCTORBANK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTORBANK_VALUE
	 * @generated
	 * @ordered
	 */
	INDUCTORBANK(10, "INDUCTORBANK", "INDUCTORBANK"),

	/**
	 * The '<em><b>RECHARGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECHARGER_VALUE
	 * @generated
	 * @ordered
	 */
	RECHARGER(11, "RECHARGER", "RECHARGER");

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
	 * The '<em><b>BATTERY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BATTERY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BATTERY_VALUE = 1;

	/**
	 * The '<em><b>CAPACITORBANK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPACITORBANK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAPACITORBANK_VALUE = 2;

	/**
	 * The '<em><b>COMPENSATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPENSATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPENSATOR_VALUE = 3;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 4;

	/**
	 * The '<em><b>CAPACITOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPACITOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAPACITOR_VALUE = 5;

	/**
	 * The '<em><b>INDUCTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDUCTOR_VALUE = 6;

	/**
	 * The '<em><b>HARMONICFILTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARMONICFILTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HARMONICFILTER_VALUE = 7;

	/**
	 * The '<em><b>UPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPS_VALUE = 8;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 9;

	/**
	 * The '<em><b>INDUCTORBANK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTORBANK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDUCTORBANK_VALUE = 10;

	/**
	 * The '<em><b>RECHARGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECHARGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECHARGER_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElectricFlowStorageDeviceTypeEnum[] VALUES_ARRAY = new IfcElectricFlowStorageDeviceTypeEnum[] {
			NULL, BATTERY, CAPACITORBANK, COMPENSATOR, NOTDEFINED, CAPACITOR, INDUCTOR, HARMONICFILTER, UPS,
			USERDEFINED, INDUCTORBANK, RECHARGER, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElectricFlowStorageDeviceTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricFlowStorageDeviceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElectricFlowStorageDeviceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricFlowStorageDeviceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElectricFlowStorageDeviceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Flow Storage Device Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElectricFlowStorageDeviceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case BATTERY_VALUE:
			return BATTERY;
		case CAPACITORBANK_VALUE:
			return CAPACITORBANK;
		case COMPENSATOR_VALUE:
			return COMPENSATOR;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case CAPACITOR_VALUE:
			return CAPACITOR;
		case INDUCTOR_VALUE:
			return INDUCTOR;
		case HARMONICFILTER_VALUE:
			return HARMONICFILTER;
		case UPS_VALUE:
			return UPS;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case INDUCTORBANK_VALUE:
			return INDUCTORBANK;
		case RECHARGER_VALUE:
			return RECHARGER;
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
	private IfcElectricFlowStorageDeviceTypeEnum(int value, String name, String literal) {
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

} //IfcElectricFlowStorageDeviceTypeEnum
