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
 * A representation of the literals of the enumeration '<em><b>Ifc Communications Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCommunicationsApplianceTypeEnum()
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
	 * The '<em><b>NETWORKAPPLIANCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKAPPLIANCE_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKAPPLIANCE(1, "NETWORKAPPLIANCE", "NETWORKAPPLIANCE"),

	/**
	 * The '<em><b>TELEPHONYEXCHANGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELEPHONYEXCHANGE_VALUE
	 * @generated
	 * @ordered
	 */
	TELEPHONYEXCHANGE(2, "TELEPHONYEXCHANGE", "TELEPHONYEXCHANGE"),

	/**
	 * The '<em><b>TELECOMMAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELECOMMAND_VALUE
	 * @generated
	 * @ordered
	 */
	TELECOMMAND(3, "TELECOMMAND", "TELECOMMAND"),

	/**
	 * The '<em><b>AUTOMATON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTOMATON_VALUE
	 * @generated
	 * @ordered
	 */
	AUTOMATON(4, "AUTOMATON", "AUTOMATON"),

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
	 * The '<em><b>NETWORKBRIDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKBRIDGE_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKBRIDGE(6, "NETWORKBRIDGE", "NETWORKBRIDGE"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(7, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>REPEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEATER_VALUE
	 * @generated
	 * @ordered
	 */
	REPEATER(8, "REPEATER", "REPEATER"),

	/**
	 * The '<em><b>RADIOBLOCKCENTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIOBLOCKCENTER_VALUE
	 * @generated
	 * @ordered
	 */
	RADIOBLOCKCENTER(9, "RADIOBLOCKCENTER", "RADIOBLOCKCENTER"),

	/**
	 * The '<em><b>TRANSPONDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPONDER_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPONDER(10, "TRANSPONDER", "TRANSPONDER"),

	/**
	 * The '<em><b>GATEWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEWAY_VALUE
	 * @generated
	 * @ordered
	 */
	GATEWAY(11, "GATEWAY", "GATEWAY"),

	/**
	 * The '<em><b>ROUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTER_VALUE
	 * @generated
	 * @ordered
	 */
	ROUTER(12, "ROUTER", "ROUTER"),

	/**
	 * The '<em><b>MODEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEM_VALUE
	 * @generated
	 * @ordered
	 */
	MODEM(13, "MODEM", "MODEM"),

	/**
	 * The '<em><b>INTELLIGENTPERIPHERAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTELLIGENTPERIPHERAL_VALUE
	 * @generated
	 * @ordered
	 */
	INTELLIGENTPERIPHERAL(14, "INTELLIGENTPERIPHERAL", "INTELLIGENTPERIPHERAL"),

	/**
	 * The '<em><b>ANTENNA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTENNA_VALUE
	 * @generated
	 * @ordered
	 */
	ANTENNA(15, "ANTENNA", "ANTENNA"),

	/**
	 * The '<em><b>LINESIDEELECTRONICUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINESIDEELECTRONICUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	LINESIDEELECTRONICUNIT(16, "LINESIDEELECTRONICUNIT", "LINESIDEELECTRONICUNIT"),

	/**
	 * The '<em><b>SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	SCANNER(17, "SCANNER", "SCANNER"),

	/**
	 * The '<em><b>OPTICALLINETERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTICALLINETERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OPTICALLINETERMINAL(18, "OPTICALLINETERMINAL", "OPTICALLINETERMINAL"),

	/**
	 * The '<em><b>IPNETWORKEQUIPMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPNETWORKEQUIPMENT_VALUE
	 * @generated
	 * @ordered
	 */
	IPNETWORKEQUIPMENT(19, "IPNETWORKEQUIPMENT", "IPNETWORKEQUIPMENT"),

	/**
	 * The '<em><b>NETWORKHUB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKHUB_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORKHUB(20, "NETWORKHUB", "NETWORKHUB"),

	/**
	 * The '<em><b>TRANSITIONCOMPONENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSITIONCOMPONENT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSITIONCOMPONENT(21, "TRANSITIONCOMPONENT", "TRANSITIONCOMPONENT"),

	/**
	 * The '<em><b>PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	PRINTER(22, "PRINTER", "PRINTER"),

	/**
	 * The '<em><b>COMPUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER_VALUE
	 * @generated
	 * @ordered
	 */
	COMPUTER(23, "COMPUTER", "COMPUTER"),

	/**
	 * The '<em><b>TRANSPORTEQUIPMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORTEQUIPMENT_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORTEQUIPMENT(24, "TRANSPORTEQUIPMENT", "TRANSPORTEQUIPMENT"),

	/**
	 * The '<em><b>OPTICALNETWORKUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTICALNETWORKUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	OPTICALNETWORKUNIT(25, "OPTICALNETWORKUNIT", "OPTICALNETWORKUNIT"),

	/**
	 * The '<em><b>FAX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAX_VALUE
	 * @generated
	 * @ordered
	 */
	FAX(26, "FAX", "FAX");

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
	 * The '<em><b>NETWORKAPPLIANCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKAPPLIANCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKAPPLIANCE_VALUE = 1;

	/**
	 * The '<em><b>TELEPHONYEXCHANGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELEPHONYEXCHANGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TELEPHONYEXCHANGE_VALUE = 2;

	/**
	 * The '<em><b>TELECOMMAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELECOMMAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TELECOMMAND_VALUE = 3;

	/**
	 * The '<em><b>AUTOMATON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTOMATON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUTOMATON_VALUE = 4;

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
	 * The '<em><b>NETWORKBRIDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKBRIDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKBRIDGE_VALUE = 6;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 7;

	/**
	 * The '<em><b>REPEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPEATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REPEATER_VALUE = 8;

	/**
	 * The '<em><b>RADIOBLOCKCENTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIOBLOCKCENTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIOBLOCKCENTER_VALUE = 9;

	/**
	 * The '<em><b>TRANSPONDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPONDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSPONDER_VALUE = 10;

	/**
	 * The '<em><b>GATEWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GATEWAY_VALUE = 11;

	/**
	 * The '<em><b>ROUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROUTER_VALUE = 12;

	/**
	 * The '<em><b>MODEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEM_VALUE = 13;

	/**
	 * The '<em><b>INTELLIGENTPERIPHERAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTELLIGENTPERIPHERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTELLIGENTPERIPHERAL_VALUE = 14;

	/**
	 * The '<em><b>ANTENNA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTENNA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANTENNA_VALUE = 15;

	/**
	 * The '<em><b>LINESIDEELECTRONICUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINESIDEELECTRONICUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINESIDEELECTRONICUNIT_VALUE = 16;

	/**
	 * The '<em><b>SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCANNER_VALUE = 17;

	/**
	 * The '<em><b>OPTICALLINETERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTICALLINETERMINAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPTICALLINETERMINAL_VALUE = 18;

	/**
	 * The '<em><b>IPNETWORKEQUIPMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPNETWORKEQUIPMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IPNETWORKEQUIPMENT_VALUE = 19;

	/**
	 * The '<em><b>NETWORKHUB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORKHUB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETWORKHUB_VALUE = 20;

	/**
	 * The '<em><b>TRANSITIONCOMPONENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSITIONCOMPONENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITIONCOMPONENT_VALUE = 21;

	/**
	 * The '<em><b>PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRINTER_VALUE = 22;

	/**
	 * The '<em><b>COMPUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTER_VALUE = 23;

	/**
	 * The '<em><b>TRANSPORTEQUIPMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORTEQUIPMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSPORTEQUIPMENT_VALUE = 24;

	/**
	 * The '<em><b>OPTICALNETWORKUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTICALNETWORKUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPTICALNETWORKUNIT_VALUE = 25;

	/**
	 * The '<em><b>FAX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAX_VALUE = 26;

	/**
	 * An array of all the '<em><b>Ifc Communications Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCommunicationsApplianceTypeEnum[] VALUES_ARRAY = new IfcCommunicationsApplianceTypeEnum[] {
			NULL, NETWORKAPPLIANCE, TELEPHONYEXCHANGE, TELECOMMAND, AUTOMATON, USERDEFINED, NETWORKBRIDGE, NOTDEFINED,
			REPEATER, RADIOBLOCKCENTER, TRANSPONDER, GATEWAY, ROUTER, MODEM, INTELLIGENTPERIPHERAL, ANTENNA,
			LINESIDEELECTRONICUNIT, SCANNER, OPTICALLINETERMINAL, IPNETWORKEQUIPMENT, NETWORKHUB, TRANSITIONCOMPONENT,
			PRINTER, COMPUTER, TRANSPORTEQUIPMENT, OPTICALNETWORKUNIT, FAX, };

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
		case NETWORKAPPLIANCE_VALUE:
			return NETWORKAPPLIANCE;
		case TELEPHONYEXCHANGE_VALUE:
			return TELEPHONYEXCHANGE;
		case TELECOMMAND_VALUE:
			return TELECOMMAND;
		case AUTOMATON_VALUE:
			return AUTOMATON;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case NETWORKBRIDGE_VALUE:
			return NETWORKBRIDGE;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case REPEATER_VALUE:
			return REPEATER;
		case RADIOBLOCKCENTER_VALUE:
			return RADIOBLOCKCENTER;
		case TRANSPONDER_VALUE:
			return TRANSPONDER;
		case GATEWAY_VALUE:
			return GATEWAY;
		case ROUTER_VALUE:
			return ROUTER;
		case MODEM_VALUE:
			return MODEM;
		case INTELLIGENTPERIPHERAL_VALUE:
			return INTELLIGENTPERIPHERAL;
		case ANTENNA_VALUE:
			return ANTENNA;
		case LINESIDEELECTRONICUNIT_VALUE:
			return LINESIDEELECTRONICUNIT;
		case SCANNER_VALUE:
			return SCANNER;
		case OPTICALLINETERMINAL_VALUE:
			return OPTICALLINETERMINAL;
		case IPNETWORKEQUIPMENT_VALUE:
			return IPNETWORKEQUIPMENT;
		case NETWORKHUB_VALUE:
			return NETWORKHUB;
		case TRANSITIONCOMPONENT_VALUE:
			return TRANSITIONCOMPONENT;
		case PRINTER_VALUE:
			return PRINTER;
		case COMPUTER_VALUE:
			return COMPUTER;
		case TRANSPORTEQUIPMENT_VALUE:
			return TRANSPORTEQUIPMENT;
		case OPTICALNETWORKUNIT_VALUE:
			return OPTICALNETWORKUNIT;
		case FAX_VALUE:
			return FAX;
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

} //IfcCommunicationsApplianceTypeEnum
