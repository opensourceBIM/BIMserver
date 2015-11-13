/**
 * Copyright (C) 2009-2013 BIMserver.org
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Communications Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcCommunicationsApplianceTypeEnum()
 * @model
 * @generated
 */
public enum IfcCommunicationsApplianceTypeEnum implements Enumerator {
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
	 * The '<em><b>PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	PRINTER(2, "PRINTER", "PRINTER"),

	/**
	 * The '<em><b>ROUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTER_VALUE
	 * @generated
	 * @ordered
	 */
	ROUTER(3, "ROUTER", "ROUTER"),

	/**
	 * The '<em><b>ANTENNA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTENNA_VALUE
	 * @generated
	 * @ordered
	 */
	ANTENNA(4, "ANTENNA", "ANTENNA"),

	/**
	 * The '<em><b>SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	SCANNER(5, "SCANNER", "SCANNER"),

	/**
	 * The '<em><b>NETWORKHUB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKHUB_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKHUB(6, "NETWORKHUB", "NETWORKHUB"),

	/**
	 * The '<em><b>REPEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEATER_VALUE
	 * @generated
	 * @ordered
	 */
	REPEATER(7, "REPEATER", "REPEATER"),

	/**
	 * The '<em><b>GATEWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEWAY_VALUE
	 * @generated
	 * @ordered
	 */
	GATEWAY(8, "GATEWAY", "GATEWAY"),

	/**
	 * The '<em><b>MODEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEM_VALUE
	 * @generated
	 * @ordered
	 */
	MODEM(9, "MODEM", "MODEM"),

	/**
	 * The '<em><b>COMPUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTER(10, "COMPUTER", "COMPUTER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(11, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>NETWORKBRIDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKBRIDGE_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKBRIDGE(12, "NETWORKBRIDGE", "NETWORKBRIDGE"),

	/**
	 * The '<em><b>FAX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAX_VALUE
	 * @generated
	 * @ordered
	 */
	FAX(13, "FAX", "FAX"),

	/**
	 * The '<em><b>NETWORKAPPLIANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKAPPLIANCE_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKAPPLIANCE(14, "NETWORKAPPLIANCE", "NETWORKAPPLIANCE");

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
	public static final int NOTDEFINED_VALUE = 1;

	/**
	 * The '<em><b>PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRINTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRINTER_VALUE = 2;

	/**
	 * The '<em><b>ROUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROUTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROUTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROUTER_VALUE = 3;

	/**
	 * The '<em><b>ANTENNA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTENNA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTENNA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANTENNA_VALUE = 4;

	/**
	 * The '<em><b>SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCANNER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCANNER_VALUE = 5;

	/**
	 * The '<em><b>NETWORKHUB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETWORKHUB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORKHUB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKHUB_VALUE = 6;

	/**
	 * The '<em><b>REPEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REPEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REPEATER_VALUE = 7;

	/**
	 * The '<em><b>GATEWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GATEWAY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GATEWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GATEWAY_VALUE = 8;

	/**
	 * The '<em><b>MODEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEM_VALUE = 9;

	/**
	 * The '<em><b>COMPUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPUTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTER_VALUE = 10;

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
	public static final int USERDEFINED_VALUE = 11;

	/**
	 * The '<em><b>NETWORKBRIDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETWORKBRIDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORKBRIDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKBRIDGE_VALUE = 12;

	/**
	 * The '<em><b>FAX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAX_VALUE = 13;

	/**
	 * The '<em><b>NETWORKAPPLIANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETWORKAPPLIANCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORKAPPLIANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKAPPLIANCE_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Communications Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCommunicationsApplianceTypeEnum[] VALUES_ARRAY = new IfcCommunicationsApplianceTypeEnum[] {
			NULL, NOTDEFINED, PRINTER, ROUTER, ANTENNA, SCANNER, NETWORKHUB, REPEATER, GATEWAY, MODEM, COMPUTER,
			USERDEFINED, NETWORKBRIDGE, FAX, NETWORKAPPLIANCE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Communications Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCommunicationsApplianceTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Communications Appliance Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCommunicationsApplianceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCommunicationsApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Communications Appliance Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCommunicationsApplianceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCommunicationsApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Communications Appliance Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCommunicationsApplianceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case PRINTER_VALUE:
			return PRINTER;
		case ROUTER_VALUE:
			return ROUTER;
		case ANTENNA_VALUE:
			return ANTENNA;
		case SCANNER_VALUE:
			return SCANNER;
		case NETWORKHUB_VALUE:
			return NETWORKHUB;
		case REPEATER_VALUE:
			return REPEATER;
		case GATEWAY_VALUE:
			return GATEWAY;
		case MODEM_VALUE:
			return MODEM;
		case COMPUTER_VALUE:
			return COMPUTER;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case NETWORKBRIDGE_VALUE:
			return NETWORKBRIDGE;
		case FAX_VALUE:
			return FAX;
		case NETWORKAPPLIANCE_VALUE:
			return NETWORKAPPLIANCE;
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
	private IfcCommunicationsApplianceTypeEnum(int value, String name, String literal) {
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

} //IfcCommunicationsApplianceTypeEnum
