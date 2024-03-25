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
 * A representation of the literals of the enumeration '<em><b>Ifc Vehicle Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcVehicleTypeEnum()
 * @model
 * @generated
 */
public enum IfcVehicleTypeEnum implements Enumerator {
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
	 * The '<em><b>CARGO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARGO_VALUE
	 * @generated
	 * @ordered
	 */
	CARGO(1, "CARGO", "CARGO"),

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
	 * The '<em><b>VEHICLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLE_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLE(3, "VEHICLE", "VEHICLE"),

	/**
	 * The '<em><b>VEHICLEAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEAIR_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLEAIR(4, "VEHICLEAIR", "VEHICLEAIR"),

	/**
	 * The '<em><b>ROLLINGSTOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGSTOCK_VALUE
	 * @generated
	 * @ordered
	 */
	ROLLINGSTOCK(5, "ROLLINGSTOCK", "ROLLINGSTOCK"),

	/**
	 * The '<em><b>VEHICLEMARINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEMARINE_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLEMARINE(6, "VEHICLEMARINE", "VEHICLEMARINE"),

	/**
	 * The '<em><b>VEHICLETRACKED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLETRACKED_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLETRACKED(7, "VEHICLETRACKED", "VEHICLETRACKED"),

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
	 * The '<em><b>VEHICLEWHEELED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEWHEELED_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLEWHEELED(9, "VEHICLEWHEELED", "VEHICLEWHEELED");

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
	 * The '<em><b>CARGO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARGO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CARGO_VALUE = 1;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>VEHICLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLE_VALUE = 3;

	/**
	 * The '<em><b>VEHICLEAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEAIR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLEAIR_VALUE = 4;

	/**
	 * The '<em><b>ROLLINGSTOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLINGSTOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROLLINGSTOCK_VALUE = 5;

	/**
	 * The '<em><b>VEHICLEMARINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEMARINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLEMARINE_VALUE = 6;

	/**
	 * The '<em><b>VEHICLETRACKED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLETRACKED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLETRACKED_VALUE = 7;

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
	 * The '<em><b>VEHICLEWHEELED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLEWHEELED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLEWHEELED_VALUE = 9;

	/**
	 * An array of all the '<em><b>Ifc Vehicle Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcVehicleTypeEnum[] VALUES_ARRAY = new IfcVehicleTypeEnum[] { NULL, CARGO, NOTDEFINED,
			VEHICLE, VEHICLEAIR, ROLLINGSTOCK, VEHICLEMARINE, VEHICLETRACKED, USERDEFINED, VEHICLEWHEELED, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Vehicle Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcVehicleTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Vehicle Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcVehicleTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcVehicleTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Vehicle Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcVehicleTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcVehicleTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Vehicle Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcVehicleTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case CARGO_VALUE:
			return CARGO;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case VEHICLE_VALUE:
			return VEHICLE;
		case VEHICLEAIR_VALUE:
			return VEHICLEAIR;
		case ROLLINGSTOCK_VALUE:
			return ROLLINGSTOCK;
		case VEHICLEMARINE_VALUE:
			return VEHICLEMARINE;
		case VEHICLETRACKED_VALUE:
			return VEHICLETRACKED;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case VEHICLEWHEELED_VALUE:
			return VEHICLEWHEELED;
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
	private IfcVehicleTypeEnum(int value, String name, String literal) {
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

} //IfcVehicleTypeEnum
