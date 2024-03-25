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
 * A representation of the literals of the enumeration '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMobileTelecommunicationsApplianceTypeEnum()
 * @model
 * @generated
 */
public enum IfcMobileTelecommunicationsApplianceTypeEnum implements Enumerator {
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
	 * The '<em><b>BASETRANSCEIVERSTATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASETRANSCEIVERSTATION_VALUE
	 * @generated
	 * @ordered
	 */
	BASETRANSCEIVERSTATION(1, "BASETRANSCEIVERSTATION", "BASETRANSCEIVERSTATION"),

	/**
	 * The '<em><b>REMOTEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOTEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	REMOTEUNIT(2, "REMOTEUNIT", "REMOTEUNIT"),

	/**
	 * The '<em><b>SERVICE GPRS SUPPORT NODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVICE_GPRS_SUPPORT_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE_GPRS_SUPPORT_NODE(3, "SERVICE_GPRS_SUPPORT_NODE", "SERVICE_GPRS_SUPPORT_NODE"),

	/**
	 * The '<em><b>SUBSCRIBERSERVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSCRIBERSERVER_VALUE
	 * @generated
	 * @ordered
	 */
	SUBSCRIBERSERVER(4, "SUBSCRIBERSERVER", "SUBSCRIBERSERVER"),

	/**
	 * The '<em><b>MOBILESWITCHINGCENTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOBILESWITCHINGCENTER_VALUE
	 * @generated
	 * @ordered
	 */
	MOBILESWITCHINGCENTER(5, "MOBILESWITCHINGCENTER", "MOBILESWITCHINGCENTER"),

	/**
	 * The '<em><b>BASEBANDUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASEBANDUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	BASEBANDUNIT(6, "BASEBANDUNIT", "BASEBANDUNIT"),

	/**
	 * The '<em><b>REMOTERADIOUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOTERADIOUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	REMOTERADIOUNIT(7, "REMOTERADIOUNIT", "REMOTERADIOUNIT"),

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
	 * The '<em><b>MASTERUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTERUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	MASTERUNIT(9, "MASTERUNIT", "MASTERUNIT"),

	/**
	 * The '<em><b>EUTRAN NODE B</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EUTRAN_NODE_B_VALUE
	 * @generated
	 * @ordered
	 */
	EUTRAN_NODE_B(10, "E_UTRAN_NODE_B", "E_UTRAN_NODE_B"),

	/**
	 * The '<em><b>MSCSERVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MSCSERVER_VALUE
	 * @generated
	 * @ordered
	 */
	MSCSERVER(11, "MSCSERVER", "MSCSERVER"),

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
	 * The '<em><b>GATEWAY GPRS SUPPORT NODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEWAY_GPRS_SUPPORT_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	GATEWAY_GPRS_SUPPORT_NODE(13, "GATEWAY_GPRS_SUPPORT_NODE", "GATEWAY_GPRS_SUPPORT_NODE"),

	/**
	 * The '<em><b>ACCESSPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESSPOINT(14, "ACCESSPOINT", "ACCESSPOINT"),

	/**
	 * The '<em><b>PACKETCONTROLUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKETCONTROLUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	PACKETCONTROLUNIT(15, "PACKETCONTROLUNIT", "PACKETCONTROLUNIT");

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
	 * The '<em><b>BASETRANSCEIVERSTATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASETRANSCEIVERSTATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASETRANSCEIVERSTATION_VALUE = 1;

	/**
	 * The '<em><b>REMOTEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOTEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOTEUNIT_VALUE = 2;

	/**
	 * The '<em><b>SERVICE GPRS SUPPORT NODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVICE_GPRS_SUPPORT_NODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_GPRS_SUPPORT_NODE_VALUE = 3;

	/**
	 * The '<em><b>SUBSCRIBERSERVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUBSCRIBERSERVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUBSCRIBERSERVER_VALUE = 4;

	/**
	 * The '<em><b>MOBILESWITCHINGCENTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOBILESWITCHINGCENTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOBILESWITCHINGCENTER_VALUE = 5;

	/**
	 * The '<em><b>BASEBANDUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASEBANDUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASEBANDUNIT_VALUE = 6;

	/**
	 * The '<em><b>REMOTERADIOUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOTERADIOUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOTERADIOUNIT_VALUE = 7;

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
	 * The '<em><b>MASTERUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASTERUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASTERUNIT_VALUE = 9;

	/**
	 * The '<em><b>EUTRAN NODE B</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EUTRAN_NODE_B
	 * @model name="E_UTRAN_NODE_B"
	 * @generated
	 * @ordered
	 */
	public static final int EUTRAN_NODE_B_VALUE = 10;

	/**
	 * The '<em><b>MSCSERVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MSCSERVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MSCSERVER_VALUE = 11;

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
	 * The '<em><b>GATEWAY GPRS SUPPORT NODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEWAY_GPRS_SUPPORT_NODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GATEWAY_GPRS_SUPPORT_NODE_VALUE = 13;

	/**
	 * The '<em><b>ACCESSPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCESSPOINT_VALUE = 14;

	/**
	 * The '<em><b>PACKETCONTROLUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKETCONTROLUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PACKETCONTROLUNIT_VALUE = 15;

	/**
	 * An array of all the '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcMobileTelecommunicationsApplianceTypeEnum[] VALUES_ARRAY = new IfcMobileTelecommunicationsApplianceTypeEnum[] {
			NULL, BASETRANSCEIVERSTATION, REMOTEUNIT, SERVICE_GPRS_SUPPORT_NODE, SUBSCRIBERSERVER,
			MOBILESWITCHINGCENTER, BASEBANDUNIT, REMOTERADIOUNIT, USERDEFINED, MASTERUNIT, EUTRAN_NODE_B, MSCSERVER,
			NOTDEFINED, GATEWAY_GPRS_SUPPORT_NODE, ACCESSPOINT, PACKETCONTROLUNIT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcMobileTelecommunicationsApplianceTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMobileTelecommunicationsApplianceTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMobileTelecommunicationsApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMobileTelecommunicationsApplianceTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMobileTelecommunicationsApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Mobile Telecommunications Appliance Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMobileTelecommunicationsApplianceTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case BASETRANSCEIVERSTATION_VALUE:
			return BASETRANSCEIVERSTATION;
		case REMOTEUNIT_VALUE:
			return REMOTEUNIT;
		case SERVICE_GPRS_SUPPORT_NODE_VALUE:
			return SERVICE_GPRS_SUPPORT_NODE;
		case SUBSCRIBERSERVER_VALUE:
			return SUBSCRIBERSERVER;
		case MOBILESWITCHINGCENTER_VALUE:
			return MOBILESWITCHINGCENTER;
		case BASEBANDUNIT_VALUE:
			return BASEBANDUNIT;
		case REMOTERADIOUNIT_VALUE:
			return REMOTERADIOUNIT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case MASTERUNIT_VALUE:
			return MASTERUNIT;
		case EUTRAN_NODE_B_VALUE:
			return EUTRAN_NODE_B;
		case MSCSERVER_VALUE:
			return MSCSERVER;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case GATEWAY_GPRS_SUPPORT_NODE_VALUE:
			return GATEWAY_GPRS_SUPPORT_NODE;
		case ACCESSPOINT_VALUE:
			return ACCESSPOINT;
		case PACKETCONTROLUNIT_VALUE:
			return PACKETCONTROLUNIT;
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
	private IfcMobileTelecommunicationsApplianceTypeEnum(int value, String name, String literal) {
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

} //IfcMobileTelecommunicationsApplianceTypeEnum
