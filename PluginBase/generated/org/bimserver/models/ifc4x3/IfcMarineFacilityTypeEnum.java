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
 * A representation of the literals of the enumeration '<em><b>Ifc Marine Facility Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMarineFacilityTypeEnum()
 * @model
 * @generated
 */
public enum IfcMarineFacilityTypeEnum implements Enumerator {
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
	 * The '<em><b>HYDROLIFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDROLIFT_VALUE
	 * @generated
	 * @ordered
	 */
	HYDROLIFT(1, "HYDROLIFT", "HYDROLIFT"),

	/**
	 * The '<em><b>PORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT_VALUE
	 * @generated
	 * @ordered
	 */
	PORT(2, "PORT", "PORT"),

	/**
	 * The '<em><b>DRYDOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRYDOCK_VALUE
	 * @generated
	 * @ordered
	 */
	DRYDOCK(3, "DRYDOCK", "DRYDOCK"),

	/**
	 * The '<em><b>REVETMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVETMENT_VALUE
	 * @generated
	 * @ordered
	 */
	REVETMENT(4, "REVETMENT", "REVETMENT"),

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
	 * The '<em><b>LAUNCHRECOVERY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAUNCHRECOVERY_VALUE
	 * @generated
	 * @ordered
	 */
	LAUNCHRECOVERY(6, "LAUNCHRECOVERY", "LAUNCHRECOVERY"),

	/**
	 * The '<em><b>MARINEDEFENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARINEDEFENCE_VALUE
	 * @generated
	 * @ordered
	 */
	MARINEDEFENCE(7, "MARINEDEFENCE", "MARINEDEFENCE"),

	/**
	 * The '<em><b>JETTY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JETTY_VALUE
	 * @generated
	 * @ordered
	 */
	JETTY(8, "JETTY", "JETTY"),

	/**
	 * The '<em><b>BARRIERBEACH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARRIERBEACH_VALUE
	 * @generated
	 * @ordered
	 */
	BARRIERBEACH(9, "BARRIERBEACH", "BARRIERBEACH"),

	/**
	 * The '<em><b>SLIPWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIPWAY_VALUE
	 * @generated
	 * @ordered
	 */
	SLIPWAY(10, "SLIPWAY", "SLIPWAY"),

	/**
	 * The '<em><b>WATERWAYSHIPLIFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERWAYSHIPLIFT_VALUE
	 * @generated
	 * @ordered
	 */
	WATERWAYSHIPLIFT(11, "WATERWAYSHIPLIFT", "WATERWAYSHIPLIFT"),

	/**
	 * The '<em><b>SHIPYARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPYARD_VALUE
	 * @generated
	 * @ordered
	 */
	SHIPYARD(12, "SHIPYARD", "SHIPYARD"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(13, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>CANAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANAL_VALUE
	 * @generated
	 * @ordered
	 */
	CANAL(14, "CANAL", "CANAL"),

	/**
	 * The '<em><b>NAVIGATIONALCHANNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAVIGATIONALCHANNEL_VALUE
	 * @generated
	 * @ordered
	 */
	NAVIGATIONALCHANNEL(15, "NAVIGATIONALCHANNEL", "NAVIGATIONALCHANNEL"),

	/**
	 * The '<em><b>FLOATINGDOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOATINGDOCK_VALUE
	 * @generated
	 * @ordered
	 */
	FLOATINGDOCK(16, "FLOATINGDOCK", "FLOATINGDOCK"),

	/**
	 * The '<em><b>SHIPLOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	SHIPLOCK(17, "SHIPLOCK", "SHIPLOCK"),

	/**
	 * The '<em><b>SHIPLIFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPLIFT_VALUE
	 * @generated
	 * @ordered
	 */
	SHIPLIFT(18, "SHIPLIFT", "SHIPLIFT"),

	/**
	 * The '<em><b>QUAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUAY_VALUE
	 * @generated
	 * @ordered
	 */
	QUAY(19, "QUAY", "QUAY"),

	/**
	 * The '<em><b>BREAKWATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKWATER_VALUE
	 * @generated
	 * @ordered
	 */
	BREAKWATER(20, "BREAKWATER", "BREAKWATER"),

	/**
	 * The '<em><b>WATERWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERWAY_VALUE
	 * @generated
	 * @ordered
	 */
	WATERWAY(21, "WATERWAY", "WATERWAY");

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
	 * The '<em><b>HYDROLIFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYDROLIFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HYDROLIFT_VALUE = 1;

	/**
	 * The '<em><b>PORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PORT_VALUE = 2;

	/**
	 * The '<em><b>DRYDOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRYDOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRYDOCK_VALUE = 3;

	/**
	 * The '<em><b>REVETMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVETMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REVETMENT_VALUE = 4;

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
	 * The '<em><b>LAUNCHRECOVERY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAUNCHRECOVERY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LAUNCHRECOVERY_VALUE = 6;

	/**
	 * The '<em><b>MARINEDEFENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARINEDEFENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MARINEDEFENCE_VALUE = 7;

	/**
	 * The '<em><b>JETTY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JETTY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JETTY_VALUE = 8;

	/**
	 * The '<em><b>BARRIERBEACH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARRIERBEACH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BARRIERBEACH_VALUE = 9;

	/**
	 * The '<em><b>SLIPWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIPWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIPWAY_VALUE = 10;

	/**
	 * The '<em><b>WATERWAYSHIPLIFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERWAYSHIPLIFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERWAYSHIPLIFT_VALUE = 11;

	/**
	 * The '<em><b>SHIPYARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPYARD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHIPYARD_VALUE = 12;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 13;

	/**
	 * The '<em><b>CANAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CANAL_VALUE = 14;

	/**
	 * The '<em><b>NAVIGATIONALCHANNEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAVIGATIONALCHANNEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATIONALCHANNEL_VALUE = 15;

	/**
	 * The '<em><b>FLOATINGDOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOATINGDOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLOATINGDOCK_VALUE = 16;

	/**
	 * The '<em><b>SHIPLOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPLOCK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHIPLOCK_VALUE = 17;

	/**
	 * The '<em><b>SHIPLIFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPLIFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHIPLIFT_VALUE = 18;

	/**
	 * The '<em><b>QUAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUAY_VALUE = 19;

	/**
	 * The '<em><b>BREAKWATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKWATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BREAKWATER_VALUE = 20;

	/**
	 * The '<em><b>WATERWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERWAY_VALUE = 21;

	/**
	 * An array of all the '<em><b>Ifc Marine Facility Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcMarineFacilityTypeEnum[] VALUES_ARRAY = new IfcMarineFacilityTypeEnum[] { NULL, HYDROLIFT,
			PORT, DRYDOCK, REVETMENT, USERDEFINED, LAUNCHRECOVERY, MARINEDEFENCE, JETTY, BARRIERBEACH, SLIPWAY,
			WATERWAYSHIPLIFT, SHIPYARD, NOTDEFINED, CANAL, NAVIGATIONALCHANNEL, FLOATINGDOCK, SHIPLOCK, SHIPLIFT, QUAY,
			BREAKWATER, WATERWAY, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Marine Facility Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcMarineFacilityTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Marine Facility Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarineFacilityTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMarineFacilityTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Marine Facility Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarineFacilityTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMarineFacilityTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Marine Facility Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarineFacilityTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case HYDROLIFT_VALUE:
			return HYDROLIFT;
		case PORT_VALUE:
			return PORT;
		case DRYDOCK_VALUE:
			return DRYDOCK;
		case REVETMENT_VALUE:
			return REVETMENT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case LAUNCHRECOVERY_VALUE:
			return LAUNCHRECOVERY;
		case MARINEDEFENCE_VALUE:
			return MARINEDEFENCE;
		case JETTY_VALUE:
			return JETTY;
		case BARRIERBEACH_VALUE:
			return BARRIERBEACH;
		case SLIPWAY_VALUE:
			return SLIPWAY;
		case WATERWAYSHIPLIFT_VALUE:
			return WATERWAYSHIPLIFT;
		case SHIPYARD_VALUE:
			return SHIPYARD;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case CANAL_VALUE:
			return CANAL;
		case NAVIGATIONALCHANNEL_VALUE:
			return NAVIGATIONALCHANNEL;
		case FLOATINGDOCK_VALUE:
			return FLOATINGDOCK;
		case SHIPLOCK_VALUE:
			return SHIPLOCK;
		case SHIPLIFT_VALUE:
			return SHIPLIFT;
		case QUAY_VALUE:
			return QUAY;
		case BREAKWATER_VALUE:
			return BREAKWATER;
		case WATERWAY_VALUE:
			return WATERWAY;
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
	private IfcMarineFacilityTypeEnum(int value, String name, String literal) {
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

} //IfcMarineFacilityTypeEnum
