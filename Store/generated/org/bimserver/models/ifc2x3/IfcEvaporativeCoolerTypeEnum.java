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
 * A representation of the literals of the enumeration '<em><b>Ifc Evaporative Cooler Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcEvaporativeCoolerTypeEnum()
 * @model
 * @generated
 */
public enum IfcEvaporativeCoolerTypeEnum implements Enumerator
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
	 * The '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_LITERAL(1, "DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER", "DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTDIRECTCOMBINATION
	 * @generated
	 * @ordered
	 */
	INDIRECTDIRECTCOMBINATION_LITERAL(3, "INDIRECTDIRECTCOMBINATION", "INDIRECTDIRECTCOMBINATION"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_LITERAL(4, "DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER", "DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_LITERAL(5, "DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER", "DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(6, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEPACKAGEAIRCOOLER
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_LITERAL(7, "INDIRECTEVAPORATIVEPACKAGEAIRCOOLER", "INDIRECTEVAPORATIVEPACKAGEAIRCOOLER"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_LITERAL(8, "INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER", "INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER"),

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEWETCOIL
	 * @generated
	 * @ordered
	 */
	INDIRECTEVAPORATIVEWETCOIL_LITERAL(9, "INDIRECTEVAPORATIVEWETCOIL", "INDIRECTEVAPORATIVEWETCOIL"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEAIRWASHER
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVEAIRWASHER_LITERAL(10, "DIRECTEVAPORATIVEAIRWASHER", "DIRECTEVAPORATIVEAIRWASHER"),

	/**
	 * The '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER
	 * @generated
	 * @ordered
	 */
	DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_LITERAL(11, "DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER", "DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER");

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
	 * The '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER = 1;

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
	public static final int NOTDEFINED = 2;

	/**
	 * The '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTDIRECTCOMBINATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTDIRECTCOMBINATION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTDIRECTCOMBINATION = 3;

	/**
	 * The '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER = 4;

	/**
	 * The '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER = 5;

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
	public static final int USERDEFINED = 6;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVEPACKAGEAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVEPACKAGEAIRCOOLER = 7;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER = 8;

	/**
	 * The '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTEVAPORATIVEWETCOIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTEVAPORATIVEWETCOIL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTEVAPORATIVEWETCOIL = 9;

	/**
	 * The '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVEAIRWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEAIRWASHER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVEAIRWASHER = 10;

	/**
	 * The '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER = 11;

	/**
	 * An array of all the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcEvaporativeCoolerTypeEnum[] VALUES_ARRAY =
		new IfcEvaporativeCoolerTypeEnum[]
		{
			NULL_LITERAL,
			DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_LITERAL,
			NOTDEFINED_LITERAL,
			INDIRECTDIRECTCOMBINATION_LITERAL,
			DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_LITERAL,
			DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_LITERAL,
			USERDEFINED_LITERAL,
			INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_LITERAL,
			INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_LITERAL,
			INDIRECTEVAPORATIVEWETCOIL_LITERAL,
			DIRECTEVAPORATIVEAIRWASHER_LITERAL,
			DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcEvaporativeCoolerTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcEvaporativeCoolerTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcEvaporativeCoolerTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Evaporative Cooler Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcEvaporativeCoolerTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER: return DIRECTEVAPORATIVERANDOMMEDIAAIRCOOLER_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case INDIRECTDIRECTCOMBINATION: return INDIRECTDIRECTCOMBINATION_LITERAL;
			case DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER: return DIRECTEVAPORATIVERIGIDMEDIAAIRCOOLER_LITERAL;
			case DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER: return DIRECTEVAPORATIVESLINGERSPACKAGEDAIRCOOLER_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case INDIRECTEVAPORATIVEPACKAGEAIRCOOLER: return INDIRECTEVAPORATIVEPACKAGEAIRCOOLER_LITERAL;
			case INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER: return INDIRECTEVAPORATIVECOOLINGTOWERORCOILCOOLER_LITERAL;
			case INDIRECTEVAPORATIVEWETCOIL: return INDIRECTEVAPORATIVEWETCOIL_LITERAL;
			case DIRECTEVAPORATIVEAIRWASHER: return DIRECTEVAPORATIVEAIRWASHER_LITERAL;
			case DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER: return DIRECTEVAPORATIVEPACKAGEDROTARYAIRCOOLER_LITERAL;
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
	private IfcEvaporativeCoolerTypeEnum(int value, String name, String literal)
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
	
} //IfcEvaporativeCoolerTypeEnum
