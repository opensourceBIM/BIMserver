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
 * A representation of the literals of the enumeration '<em><b>Ifc Electric Distribution Point Function Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElectricDistributionPointFunctionEnum()
 * @model
 * @generated
 */
public enum IfcElectricDistributionPointFunctionEnum implements Enumerator
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
	 * The '<em><b>CONSUMERUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSUMERUNIT
	 * @generated
	 * @ordered
	 */
	CONSUMERUNIT_LITERAL(1, "CONSUMERUNIT", "CONSUMERUNIT"),

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
	 * The '<em><b>SWITCHBOARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWITCHBOARD
	 * @generated
	 * @ordered
	 */
	SWITCHBOARD_LITERAL(3, "SWITCHBOARD", "SWITCHBOARD"),

	/**
	 * The '<em><b>MIMICPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIMICPANEL
	 * @generated
	 * @ordered
	 */
	MIMICPANEL_LITERAL(4, "MIMICPANEL", "MIMICPANEL"),

	/**
	 * The '<em><b>GASDETECTORPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASDETECTORPANEL
	 * @generated
	 * @ordered
	 */
	GASDETECTORPANEL_LITERAL(5, "GASDETECTORPANEL", "GASDETECTORPANEL"),

	/**
	 * The '<em><b>CONTROLPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROLPANEL
	 * @generated
	 * @ordered
	 */
	CONTROLPANEL_LITERAL(6, "CONTROLPANEL", "CONTROLPANEL"),

	/**
	 * The '<em><b>MOTORCONTROLCENTRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOTORCONTROLCENTRE
	 * @generated
	 * @ordered
	 */
	MOTORCONTROLCENTRE_LITERAL(7, "MOTORCONTROLCENTRE", "MOTORCONTROLCENTRE"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(8, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>INDICATORPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDICATORPANEL
	 * @generated
	 * @ordered
	 */
	INDICATORPANEL_LITERAL(9, "INDICATORPANEL", "INDICATORPANEL"),

	/**
	 * The '<em><b>DISTRIBUTIONBOARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISTRIBUTIONBOARD
	 * @generated
	 * @ordered
	 */
	DISTRIBUTIONBOARD_LITERAL(10, "DISTRIBUTIONBOARD", "DISTRIBUTIONBOARD"),

	/**
	 * The '<em><b>ALARMPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALARMPANEL
	 * @generated
	 * @ordered
	 */
	ALARMPANEL_LITERAL(11, "ALARMPANEL", "ALARMPANEL");

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
	 * The '<em><b>CONSUMERUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONSUMERUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSUMERUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONSUMERUNIT = 1;

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
	 * The '<em><b>SWITCHBOARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SWITCHBOARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWITCHBOARD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SWITCHBOARD = 3;

	/**
	 * The '<em><b>MIMICPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MIMICPANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIMICPANEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MIMICPANEL = 4;

	/**
	 * The '<em><b>GASDETECTORPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASDETECTORPANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASDETECTORPANEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASDETECTORPANEL = 5;

	/**
	 * The '<em><b>CONTROLPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTROLPANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROLPANEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROLPANEL = 6;

	/**
	 * The '<em><b>MOTORCONTROLCENTRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOTORCONTROLCENTRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOTORCONTROLCENTRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOTORCONTROLCENTRE = 7;

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
	public static final int USERDEFINED = 8;

	/**
	 * The '<em><b>INDICATORPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDICATORPANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDICATORPANEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDICATORPANEL = 9;

	/**
	 * The '<em><b>DISTRIBUTIONBOARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISTRIBUTIONBOARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISTRIBUTIONBOARD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISTRIBUTIONBOARD = 10;

	/**
	 * The '<em><b>ALARMPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALARMPANEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALARMPANEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALARMPANEL = 11;

	/**
	 * An array of all the '<em><b>Ifc Electric Distribution Point Function Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElectricDistributionPointFunctionEnum[] VALUES_ARRAY =
		new IfcElectricDistributionPointFunctionEnum[]
		{
			NULL_LITERAL,
			CONSUMERUNIT_LITERAL,
			NOTDEFINED_LITERAL,
			SWITCHBOARD_LITERAL,
			MIMICPANEL_LITERAL,
			GASDETECTORPANEL_LITERAL,
			CONTROLPANEL_LITERAL,
			MOTORCONTROLCENTRE_LITERAL,
			USERDEFINED_LITERAL,
			INDICATORPANEL_LITERAL,
			DISTRIBUTIONBOARD_LITERAL,
			ALARMPANEL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Electric Distribution Point Function Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElectricDistributionPointFunctionEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Electric Distribution Point Function Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricDistributionPointFunctionEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcElectricDistributionPointFunctionEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Distribution Point Function Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricDistributionPointFunctionEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcElectricDistributionPointFunctionEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Distribution Point Function Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricDistributionPointFunctionEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case CONSUMERUNIT: return CONSUMERUNIT_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case SWITCHBOARD: return SWITCHBOARD_LITERAL;
			case MIMICPANEL: return MIMICPANEL_LITERAL;
			case GASDETECTORPANEL: return GASDETECTORPANEL_LITERAL;
			case CONTROLPANEL: return CONTROLPANEL_LITERAL;
			case MOTORCONTROLCENTRE: return MOTORCONTROLCENTRE_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case INDICATORPANEL: return INDICATORPANEL_LITERAL;
			case DISTRIBUTIONBOARD: return DISTRIBUTIONBOARD_LITERAL;
			case ALARMPANEL: return ALARMPANEL_LITERAL;
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
	private IfcElectricDistributionPointFunctionEnum(int value, String name, String literal)
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
	
} //IfcElectricDistributionPointFunctionEnum
