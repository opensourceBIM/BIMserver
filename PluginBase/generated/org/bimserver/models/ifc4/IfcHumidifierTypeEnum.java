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
 * A representation of the literals of the enumeration '<em><b>Ifc Humidifier Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcHumidifierTypeEnum()
 * @model
 * @generated
 */
public enum IfcHumidifierTypeEnum implements Enumerator {
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
	 * The '<em><b>ADIABATICPAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICPAN_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICPAN(1, "ADIABATICPAN", "ADIABATICPAN"),

	/**
	 * The '<em><b>ADIABATICULTRASONIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICULTRASONIC_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICULTRASONIC(2, "ADIABATICULTRASONIC", "ADIABATICULTRASONIC"),

	/**
	 * The '<em><b>ASSISTEDNATURALGAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDNATURALGAS_VALUE
	 * @generated
	 * @ordered
	 */
	ASSISTEDNATURALGAS(3, "ASSISTEDNATURALGAS", "ASSISTEDNATURALGAS"),

	/**
	 * The '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICRIGIDMEDIA_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICRIGIDMEDIA(4, "ADIABATICRIGIDMEDIA", "ADIABATICRIGIDMEDIA"),

	/**
	 * The '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICWETTEDELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICWETTEDELEMENT(5, "ADIABATICWETTEDELEMENT", "ADIABATICWETTEDELEMENT"),

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
	 * The '<em><b>ADIABATICAIRWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICAIRWASHER_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICAIRWASHER(7, "ADIABATICAIRWASHER", "ADIABATICAIRWASHER"),

	/**
	 * The '<em><b>ADIABATICATOMIZING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICATOMIZING_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICATOMIZING(8, "ADIABATICATOMIZING", "ADIABATICATOMIZING"),

	/**
	 * The '<em><b>ASSISTEDELECTRIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDELECTRIC_VALUE
	 * @generated
	 * @ordered
	 */
	ASSISTEDELECTRIC(9, "ASSISTEDELECTRIC", "ASSISTEDELECTRIC"),

	/**
	 * The '<em><b>ASSISTEDPROPANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDPROPANE_VALUE
	 * @generated
	 * @ordered
	 */
	ASSISTEDPROPANE(10, "ASSISTEDPROPANE", "ASSISTEDPROPANE"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(11, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ASSISTEDBUTANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDBUTANE_VALUE
	 * @generated
	 * @ordered
	 */
	ASSISTEDBUTANE(12, "ASSISTEDBUTANE", "ASSISTEDBUTANE"),

	/**
	 * The '<em><b>STEAMINJECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEAMINJECTION_VALUE
	 * @generated
	 * @ordered
	 */
	STEAMINJECTION(13, "STEAMINJECTION", "STEAMINJECTION"),

	/**
	 * The '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICCOMPRESSEDAIRNOZZLE_VALUE
	 * @generated
	 * @ordered
	 */
	ADIABATICCOMPRESSEDAIRNOZZLE(14, "ADIABATICCOMPRESSEDAIRNOZZLE", "ADIABATICCOMPRESSEDAIRNOZZLE"),

	/**
	 * The '<em><b>ASSISTEDSTEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDSTEAM_VALUE
	 * @generated
	 * @ordered
	 */
	ASSISTEDSTEAM(15, "ASSISTEDSTEAM", "ASSISTEDSTEAM");

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
	 * The '<em><b>ADIABATICPAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICPAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICPAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICPAN_VALUE = 1;

	/**
	 * The '<em><b>ADIABATICULTRASONIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICULTRASONIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICULTRASONIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICULTRASONIC_VALUE = 2;

	/**
	 * The '<em><b>ASSISTEDNATURALGAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDNATURALGAS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDNATURALGAS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDNATURALGAS_VALUE = 3;

	/**
	 * The '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICRIGIDMEDIA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICRIGIDMEDIA_VALUE = 4;

	/**
	 * The '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICWETTEDELEMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICWETTEDELEMENT_VALUE = 5;

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
	 * The '<em><b>ADIABATICAIRWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICAIRWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICAIRWASHER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICAIRWASHER_VALUE = 7;

	/**
	 * The '<em><b>ADIABATICATOMIZING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICATOMIZING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICATOMIZING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICATOMIZING_VALUE = 8;

	/**
	 * The '<em><b>ASSISTEDELECTRIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDELECTRIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDELECTRIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDELECTRIC_VALUE = 9;

	/**
	 * The '<em><b>ASSISTEDPROPANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDPROPANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDPROPANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDPROPANE_VALUE = 10;

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
	public static final int NOTDEFINED_VALUE = 11;

	/**
	 * The '<em><b>ASSISTEDBUTANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDBUTANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDBUTANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDBUTANE_VALUE = 12;

	/**
	 * The '<em><b>STEAMINJECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEAMINJECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEAMINJECTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEAMINJECTION_VALUE = 13;

	/**
	 * The '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICCOMPRESSEDAIRNOZZLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICCOMPRESSEDAIRNOZZLE_VALUE = 14;

	/**
	 * The '<em><b>ASSISTEDSTEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDSTEAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDSTEAM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDSTEAM_VALUE = 15;

	/**
	 * An array of all the '<em><b>Ifc Humidifier Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcHumidifierTypeEnum[] VALUES_ARRAY = new IfcHumidifierTypeEnum[] { NULL, ADIABATICPAN, ADIABATICULTRASONIC, ASSISTEDNATURALGAS, ADIABATICRIGIDMEDIA, ADIABATICWETTEDELEMENT, USERDEFINED, ADIABATICAIRWASHER,
			ADIABATICATOMIZING, ASSISTEDELECTRIC, ASSISTEDPROPANE, NOTDEFINED, ASSISTEDBUTANE, STEAMINJECTION, ADIABATICCOMPRESSEDAIRNOZZLE, ASSISTEDSTEAM, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Humidifier Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcHumidifierTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Humidifier Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcHumidifierTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcHumidifierTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Humidifier Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcHumidifierTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcHumidifierTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Humidifier Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcHumidifierTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case ADIABATICPAN_VALUE:
			return ADIABATICPAN;
		case ADIABATICULTRASONIC_VALUE:
			return ADIABATICULTRASONIC;
		case ASSISTEDNATURALGAS_VALUE:
			return ASSISTEDNATURALGAS;
		case ADIABATICRIGIDMEDIA_VALUE:
			return ADIABATICRIGIDMEDIA;
		case ADIABATICWETTEDELEMENT_VALUE:
			return ADIABATICWETTEDELEMENT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ADIABATICAIRWASHER_VALUE:
			return ADIABATICAIRWASHER;
		case ADIABATICATOMIZING_VALUE:
			return ADIABATICATOMIZING;
		case ASSISTEDELECTRIC_VALUE:
			return ASSISTEDELECTRIC;
		case ASSISTEDPROPANE_VALUE:
			return ASSISTEDPROPANE;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case ASSISTEDBUTANE_VALUE:
			return ASSISTEDBUTANE;
		case STEAMINJECTION_VALUE:
			return STEAMINJECTION;
		case ADIABATICCOMPRESSEDAIRNOZZLE_VALUE:
			return ADIABATICCOMPRESSEDAIRNOZZLE;
		case ASSISTEDSTEAM_VALUE:
			return ASSISTEDSTEAM;
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
	private IfcHumidifierTypeEnum(int value, String name, String literal) {
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

} //IfcHumidifierTypeEnum
