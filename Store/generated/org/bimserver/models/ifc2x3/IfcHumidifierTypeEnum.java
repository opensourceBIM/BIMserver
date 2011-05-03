/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Humidifier Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcHumidifierTypeEnum()
 * @model
 * @generated
 */
public enum IfcHumidifierTypeEnum implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(1, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ADIABATICULTRASONIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICULTRASONIC
	 * @generated
	 * @ordered
	 */
	ADIABATICULTRASONIC_LITERAL(2, "ADIABATICULTRASONIC", "ADIABATICULTRASONIC"),

	/**
	 * The '<em><b>STEAMINJECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEAMINJECTION
	 * @generated
	 * @ordered
	 */
	STEAMINJECTION_LITERAL(3, "STEAMINJECTION", "STEAMINJECTION"),

	/**
	 * The '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICWETTEDELEMENT
	 * @generated
	 * @ordered
	 */
	ADIABATICWETTEDELEMENT_LITERAL(4, "ADIABATICWETTEDELEMENT", "ADIABATICWETTEDELEMENT"),

	/**
	 * The '<em><b>ASSISTEDSTEAM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDSTEAM
	 * @generated
	 * @ordered
	 */
	ASSISTEDSTEAM_LITERAL(5, "ASSISTEDSTEAM", "ASSISTEDSTEAM"),

	/**
	 * The '<em><b>ADIABATICATOMIZING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICATOMIZING
	 * @generated
	 * @ordered
	 */
	ADIABATICATOMIZING_LITERAL(6, "ADIABATICATOMIZING", "ADIABATICATOMIZING"),

	/**
	 * The '<em><b>ADIABATICPAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICPAN
	 * @generated
	 * @ordered
	 */
	ADIABATICPAN_LITERAL(7, "ADIABATICPAN", "ADIABATICPAN"),

	/**
	 * The '<em><b>ASSISTEDELECTRIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDELECTRIC
	 * @generated
	 * @ordered
	 */
	ASSISTEDELECTRIC_LITERAL(8, "ASSISTEDELECTRIC", "ASSISTEDELECTRIC"),

	/**
	 * The '<em><b>ASSISTEDBUTANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDBUTANE
	 * @generated
	 * @ordered
	 */
	ASSISTEDBUTANE_LITERAL(9, "ASSISTEDBUTANE", "ASSISTEDBUTANE"),

	/**
	 * The '<em><b>ASSISTEDPROPANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDPROPANE
	 * @generated
	 * @ordered
	 */
	ASSISTEDPROPANE_LITERAL(10, "ASSISTEDPROPANE", "ASSISTEDPROPANE"),

	/**
	 * The '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICRIGIDMEDIA
	 * @generated
	 * @ordered
	 */
	ADIABATICRIGIDMEDIA_LITERAL(11, "ADIABATICRIGIDMEDIA", "ADIABATICRIGIDMEDIA"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(12, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICCOMPRESSEDAIRNOZZLE
	 * @generated
	 * @ordered
	 */
	ADIABATICCOMPRESSEDAIRNOZZLE_LITERAL(13, "ADIABATICCOMPRESSEDAIRNOZZLE", "ADIABATICCOMPRESSEDAIRNOZZLE"),

	/**
	 * The '<em><b>ADIABATICAIRWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADIABATICAIRWASHER
	 * @generated
	 * @ordered
	 */
	ADIABATICAIRWASHER_LITERAL(14, "ADIABATICAIRWASHER", "ADIABATICAIRWASHER"),

	/**
	 * The '<em><b>ASSISTEDNATURALGAS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDNATURALGAS
	 * @generated
	 * @ordered
	 */
	ASSISTEDNATURALGAS_LITERAL(15, "ASSISTEDNATURALGAS", "ASSISTEDNATURALGAS");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED = 1;

	/**
	 * The '<em><b>ADIABATICULTRASONIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICULTRASONIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICULTRASONIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICULTRASONIC = 2;

	/**
	 * The '<em><b>STEAMINJECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEAMINJECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEAMINJECTION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEAMINJECTION = 3;

	/**
	 * The '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICWETTEDELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICWETTEDELEMENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICWETTEDELEMENT = 4;

	/**
	 * The '<em><b>ASSISTEDSTEAM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDSTEAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDSTEAM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDSTEAM = 5;

	/**
	 * The '<em><b>ADIABATICATOMIZING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICATOMIZING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICATOMIZING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICATOMIZING = 6;

	/**
	 * The '<em><b>ADIABATICPAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICPAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICPAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICPAN = 7;

	/**
	 * The '<em><b>ASSISTEDELECTRIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDELECTRIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDELECTRIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDELECTRIC = 8;

	/**
	 * The '<em><b>ASSISTEDBUTANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDBUTANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDBUTANE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDBUTANE = 9;

	/**
	 * The '<em><b>ASSISTEDPROPANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDPROPANE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDPROPANE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDPROPANE = 10;

	/**
	 * The '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICRIGIDMEDIA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICRIGIDMEDIA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICRIGIDMEDIA = 11;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED = 12;

	/**
	 * The '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICCOMPRESSEDAIRNOZZLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICCOMPRESSEDAIRNOZZLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICCOMPRESSEDAIRNOZZLE = 13;

	/**
	 * The '<em><b>ADIABATICAIRWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADIABATICAIRWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADIABATICAIRWASHER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADIABATICAIRWASHER = 14;

	/**
	 * The '<em><b>ASSISTEDNATURALGAS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASSISTEDNATURALGAS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSISTEDNATURALGAS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASSISTEDNATURALGAS = 15;

	/**
	 * An array of all the '<em><b>Ifc Humidifier Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcHumidifierTypeEnum[] VALUES_ARRAY =
		new IfcHumidifierTypeEnum[]
		{
			NULL_LITERAL,
			NOTDEFINED_LITERAL,
			ADIABATICULTRASONIC_LITERAL,
			STEAMINJECTION_LITERAL,
			ADIABATICWETTEDELEMENT_LITERAL,
			ASSISTEDSTEAM_LITERAL,
			ADIABATICATOMIZING_LITERAL,
			ADIABATICPAN_LITERAL,
			ASSISTEDELECTRIC_LITERAL,
			ASSISTEDBUTANE_LITERAL,
			ASSISTEDPROPANE_LITERAL,
			ADIABATICRIGIDMEDIA_LITERAL,
			USERDEFINED_LITERAL,
			ADIABATICCOMPRESSEDAIRNOZZLE_LITERAL,
			ADIABATICAIRWASHER_LITERAL,
			ASSISTEDNATURALGAS_LITERAL,
		};

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
	 * @generated
	 */
	public static IfcHumidifierTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcHumidifierTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Humidifier Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcHumidifierTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcHumidifierTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Humidifier Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcHumidifierTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case ADIABATICULTRASONIC: return ADIABATICULTRASONIC_LITERAL;
			case STEAMINJECTION: return STEAMINJECTION_LITERAL;
			case ADIABATICWETTEDELEMENT: return ADIABATICWETTEDELEMENT_LITERAL;
			case ASSISTEDSTEAM: return ASSISTEDSTEAM_LITERAL;
			case ADIABATICATOMIZING: return ADIABATICATOMIZING_LITERAL;
			case ADIABATICPAN: return ADIABATICPAN_LITERAL;
			case ASSISTEDELECTRIC: return ASSISTEDELECTRIC_LITERAL;
			case ASSISTEDBUTANE: return ASSISTEDBUTANE_LITERAL;
			case ASSISTEDPROPANE: return ASSISTEDPROPANE_LITERAL;
			case ADIABATICRIGIDMEDIA: return ADIABATICRIGIDMEDIA_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case ADIABATICCOMPRESSEDAIRNOZZLE: return ADIABATICCOMPRESSEDAIRNOZZLE_LITERAL;
			case ADIABATICAIRWASHER: return ADIABATICAIRWASHER_LITERAL;
			case ASSISTEDNATURALGAS: return ASSISTEDNATURALGAS_LITERAL;
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
	private IfcHumidifierTypeEnum(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //IfcHumidifierTypeEnum
