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
 * A representation of the literals of the enumeration '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAirToAirHeatRecoveryTypeEnum()
 * @model
 * @generated
 */
public enum IfcAirToAirHeatRecoveryTypeEnum implements Enumerator
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
	 * The '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONCOILTYPEHEATEXCHANGERS
	 * @generated
	 * @ordered
	 */
	THERMOSIPHONCOILTYPEHEATEXCHANGERS_LITERAL(1, "THERMOSIPHONCOILTYPEHEATEXCHANGERS", "THERMOSIPHONCOILTYPEHEATEXCHANGERS"),

	/**
	 * The '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWINTOWERENTHALPYRECOVERYLOOPS
	 * @generated
	 * @ordered
	 */
	TWINTOWERENTHALPYRECOVERYLOOPS_LITERAL(2, "TWINTOWERENTHALPYRECOVERYLOOPS", "TWINTOWERENTHALPYRECOVERYLOOPS"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>HEATPIPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATPIPE
	 * @generated
	 * @ordered
	 */
	HEATPIPE_LITERAL(4, "HEATPIPE", "HEATPIPE"),

	/**
	 * The '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECROSSFLOWEXCHANGER
	 * @generated
	 * @ordered
	 */
	FIXEDPLATECROSSFLOWEXCHANGER_LITERAL(5, "FIXEDPLATECROSSFLOWEXCHANGER", "FIXEDPLATECROSSFLOWEXCHANGER"),

	/**
	 * The '<em><b>RUNAROUNDCOILLOOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNAROUNDCOILLOOP
	 * @generated
	 * @ordered
	 */
	RUNAROUNDCOILLOOP_LITERAL(6, "RUNAROUNDCOILLOOP", "RUNAROUNDCOILLOOP"),

	/**
	 * The '<em><b>ROTARYWHEEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTARYWHEEL
	 * @generated
	 * @ordered
	 */
	ROTARYWHEEL_LITERAL(7, "ROTARYWHEEL", "ROTARYWHEEL"),

	/**
	 * The '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECOUNTERFLOWEXCHANGER
	 * @generated
	 * @ordered
	 */
	FIXEDPLATECOUNTERFLOWEXCHANGER_LITERAL(8, "FIXEDPLATECOUNTERFLOWEXCHANGER", "FIXEDPLATECOUNTERFLOWEXCHANGER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(9, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATEPARALLELFLOWEXCHANGER
	 * @generated
	 * @ordered
	 */
	FIXEDPLATEPARALLELFLOWEXCHANGER_LITERAL(10, "FIXEDPLATEPARALLELFLOWEXCHANGER", "FIXEDPLATEPARALLELFLOWEXCHANGER"),

	/**
	 * The '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONSEALEDTUBEHEATEXCHANGERS
	 * @generated
	 * @ordered
	 */
	THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_LITERAL(11, "THERMOSIPHONSEALEDTUBEHEATEXCHANGERS", "THERMOSIPHONSEALEDTUBEHEATEXCHANGERS");

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
	 * The '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMOSIPHONCOILTYPEHEATEXCHANGERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONCOILTYPEHEATEXCHANGERS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMOSIPHONCOILTYPEHEATEXCHANGERS = 1;

	/**
	 * The '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWINTOWERENTHALPYRECOVERYLOOPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWINTOWERENTHALPYRECOVERYLOOPS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWINTOWERENTHALPYRECOVERYLOOPS = 2;

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
	public static final int NOTDEFINED = 3;

	/**
	 * The '<em><b>HEATPIPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATPIPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATPIPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATPIPE = 4;

	/**
	 * The '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATECROSSFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECROSSFLOWEXCHANGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATECROSSFLOWEXCHANGER = 5;

	/**
	 * The '<em><b>RUNAROUNDCOILLOOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUNAROUNDCOILLOOP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNAROUNDCOILLOOP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUNAROUNDCOILLOOP = 6;

	/**
	 * The '<em><b>ROTARYWHEEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTARYWHEEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTARYWHEEL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTARYWHEEL = 7;

	/**
	 * The '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATECOUNTERFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATECOUNTERFLOWEXCHANGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATECOUNTERFLOWEXCHANGER = 8;

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
	public static final int USERDEFINED = 9;

	/**
	 * The '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDPLATEPARALLELFLOWEXCHANGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDPLATEPARALLELFLOWEXCHANGER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDPLATEPARALLELFLOWEXCHANGER = 10;

	/**
	 * The '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMOSIPHONSEALEDTUBEHEATEXCHANGERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMOSIPHONSEALEDTUBEHEATEXCHANGERS = 11;

	/**
	 * An array of all the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcAirToAirHeatRecoveryTypeEnum[] VALUES_ARRAY =
		new IfcAirToAirHeatRecoveryTypeEnum[]
		{
			NULL_LITERAL,
			THERMOSIPHONCOILTYPEHEATEXCHANGERS_LITERAL,
			TWINTOWERENTHALPYRECOVERYLOOPS_LITERAL,
			NOTDEFINED_LITERAL,
			HEATPIPE_LITERAL,
			FIXEDPLATECROSSFLOWEXCHANGER_LITERAL,
			RUNAROUNDCOILLOOP_LITERAL,
			ROTARYWHEEL_LITERAL,
			FIXEDPLATECOUNTERFLOWEXCHANGER_LITERAL,
			USERDEFINED_LITERAL,
			FIXEDPLATEPARALLELFLOWEXCHANGER_LITERAL,
			THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcAirToAirHeatRecoveryTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcAirToAirHeatRecoveryTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcAirToAirHeatRecoveryTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Air To Air Heat Recovery Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcAirToAirHeatRecoveryTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case THERMOSIPHONCOILTYPEHEATEXCHANGERS: return THERMOSIPHONCOILTYPEHEATEXCHANGERS_LITERAL;
			case TWINTOWERENTHALPYRECOVERYLOOPS: return TWINTOWERENTHALPYRECOVERYLOOPS_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case HEATPIPE: return HEATPIPE_LITERAL;
			case FIXEDPLATECROSSFLOWEXCHANGER: return FIXEDPLATECROSSFLOWEXCHANGER_LITERAL;
			case RUNAROUNDCOILLOOP: return RUNAROUNDCOILLOOP_LITERAL;
			case ROTARYWHEEL: return ROTARYWHEEL_LITERAL;
			case FIXEDPLATECOUNTERFLOWEXCHANGER: return FIXEDPLATECOUNTERFLOWEXCHANGER_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case FIXEDPLATEPARALLELFLOWEXCHANGER: return FIXEDPLATEPARALLELFLOWEXCHANGER_LITERAL;
			case THERMOSIPHONSEALEDTUBEHEATEXCHANGERS: return THERMOSIPHONSEALEDTUBEHEATEXCHANGERS_LITERAL;
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
	private IfcAirToAirHeatRecoveryTypeEnum(int value, String name, String literal)
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
	
} //IfcAirToAirHeatRecoveryTypeEnum
