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
 * A representation of the literals of the enumeration '<em><b>Ifc Procedure Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProcedureTypeEnum()
 * @model
 * @generated
 */
public enum IfcProcedureTypeEnum implements Enumerator
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
	 * The '<em><b>ADVICE NOTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVICE_NOTE
	 * @generated
	 * @ordered
	 */
	ADVICE_NOTE_LITERAL(1, "ADVICE_NOTE", "ADVICE_NOTE"),

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
	 * The '<em><b>SHUTDOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHUTDOWN
	 * @generated
	 * @ordered
	 */
	SHUTDOWN_LITERAL(3, "SHUTDOWN", "SHUTDOWN"),

	/**
	 * The '<em><b>ADVICE CAUTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVICE_CAUTION
	 * @generated
	 * @ordered
	 */
	ADVICE_CAUTION_LITERAL(4, "ADVICE_CAUTION", "ADVICE_CAUTION"),

	/**
	 * The '<em><b>CALIBRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CALIBRATION
	 * @generated
	 * @ordered
	 */
	CALIBRATION_LITERAL(5, "CALIBRATION", "CALIBRATION"),

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
	 * The '<em><b>STARTUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTUP
	 * @generated
	 * @ordered
	 */
	STARTUP_LITERAL(7, "STARTUP", "STARTUP"),

	/**
	 * The '<em><b>ADVICE WARNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADVICE_WARNING
	 * @generated
	 * @ordered
	 */
	ADVICE_WARNING_LITERAL(8, "ADVICE_WARNING", "ADVICE_WARNING"),

	/**
	 * The '<em><b>DIAGNOSTIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAGNOSTIC
	 * @generated
	 * @ordered
	 */
	DIAGNOSTIC_LITERAL(9, "DIAGNOSTIC", "DIAGNOSTIC");

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
	 * The '<em><b>ADVICE NOTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADVICE NOTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVICE_NOTE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADVICE_NOTE = 1;

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
	 * The '<em><b>SHUTDOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHUTDOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHUTDOWN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHUTDOWN = 3;

	/**
	 * The '<em><b>ADVICE CAUTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADVICE CAUTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVICE_CAUTION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADVICE_CAUTION = 4;

	/**
	 * The '<em><b>CALIBRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CALIBRATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CALIBRATION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CALIBRATION = 5;

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
	 * The '<em><b>STARTUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STARTUP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTUP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STARTUP = 7;

	/**
	 * The '<em><b>ADVICE WARNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADVICE WARNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADVICE_WARNING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADVICE_WARNING = 8;

	/**
	 * The '<em><b>DIAGNOSTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIAGNOSTIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIAGNOSTIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIAGNOSTIC = 9;

	/**
	 * An array of all the '<em><b>Ifc Procedure Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcProcedureTypeEnum[] VALUES_ARRAY =
		new IfcProcedureTypeEnum[]
		{
			NULL_LITERAL,
			ADVICE_NOTE_LITERAL,
			NOTDEFINED_LITERAL,
			SHUTDOWN_LITERAL,
			ADVICE_CAUTION_LITERAL,
			CALIBRATION_LITERAL,
			USERDEFINED_LITERAL,
			STARTUP_LITERAL,
			ADVICE_WARNING_LITERAL,
			DIAGNOSTIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Procedure Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcProcedureTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Procedure Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProcedureTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcProcedureTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Procedure Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProcedureTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcProcedureTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Procedure Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcProcedureTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case ADVICE_NOTE: return ADVICE_NOTE_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case SHUTDOWN: return SHUTDOWN_LITERAL;
			case ADVICE_CAUTION: return ADVICE_CAUTION_LITERAL;
			case CALIBRATION: return CALIBRATION_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case STARTUP: return STARTUP_LITERAL;
			case ADVICE_WARNING: return ADVICE_WARNING_LITERAL;
			case DIAGNOSTIC: return DIAGNOSTIC_LITERAL;
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
	private IfcProcedureTypeEnum(int value, String name, String literal)
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
	
} //IfcProcedureTypeEnum
