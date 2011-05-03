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
 * A representation of the literals of the enumeration '<em><b>Ifc Service Life Factor Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLifeFactorTypeEnum()
 * @model
 * @generated
 */
public enum IfcServiceLifeFactorTypeEnum implements Enumerator
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
	 * The '<em><b>EOUTDOORENVIRONMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EOUTDOORENVIRONMENT
	 * @generated
	 * @ordered
	 */
	EOUTDOORENVIRONMENT_LITERAL(1, "E_OUTDOORENVIRONMENT", "E_OUTDOORENVIRONMENT"),

	/**
	 * The '<em><b>FINUSECONDITIONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINUSECONDITIONS
	 * @generated
	 * @ordered
	 */
	FINUSECONDITIONS_LITERAL(2, "F_INUSECONDITIONS", "F_INUSECONDITIONS"),

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
	 * The '<em><b>DINDOORENVIRONMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DINDOORENVIRONMENT
	 * @generated
	 * @ordered
	 */
	DINDOORENVIRONMENT_LITERAL(4, "D_INDOORENVIRONMENT", "D_INDOORENVIRONMENT"),

	/**
	 * The '<em><b>GMAINTENANCELEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GMAINTENANCELEVEL
	 * @generated
	 * @ordered
	 */
	GMAINTENANCELEVEL_LITERAL(5, "G_MAINTENANCELEVEL", "G_MAINTENANCELEVEL"),

	/**
	 * The '<em><b>BDESIGNLEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BDESIGNLEVEL
	 * @generated
	 * @ordered
	 */
	BDESIGNLEVEL_LITERAL(6, "B_DESIGNLEVEL", "B_DESIGNLEVEL"),

	/**
	 * The '<em><b>CWORKEXECUTIONLEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CWORKEXECUTIONLEVEL
	 * @generated
	 * @ordered
	 */
	CWORKEXECUTIONLEVEL_LITERAL(7, "C_WORKEXECUTIONLEVEL", "C_WORKEXECUTIONLEVEL"),

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
	 * The '<em><b>AQUALITYOFCOMPONENTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AQUALITYOFCOMPONENTS
	 * @generated
	 * @ordered
	 */
	AQUALITYOFCOMPONENTS_LITERAL(9, "A_QUALITYOFCOMPONENTS", "A_QUALITYOFCOMPONENTS");

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
	 * The '<em><b>EOUTDOORENVIRONMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EOUTDOORENVIRONMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EOUTDOORENVIRONMENT_LITERAL
	 * @model name="E_OUTDOORENVIRONMENT"
	 * @generated
	 * @ordered
	 */
	public static final int EOUTDOORENVIRONMENT = 1;

	/**
	 * The '<em><b>FINUSECONDITIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINUSECONDITIONS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINUSECONDITIONS_LITERAL
	 * @model name="F_INUSECONDITIONS"
	 * @generated
	 * @ordered
	 */
	public static final int FINUSECONDITIONS = 2;

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
	 * The '<em><b>DINDOORENVIRONMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DINDOORENVIRONMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DINDOORENVIRONMENT_LITERAL
	 * @model name="D_INDOORENVIRONMENT"
	 * @generated
	 * @ordered
	 */
	public static final int DINDOORENVIRONMENT = 4;

	/**
	 * The '<em><b>GMAINTENANCELEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GMAINTENANCELEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GMAINTENANCELEVEL_LITERAL
	 * @model name="G_MAINTENANCELEVEL"
	 * @generated
	 * @ordered
	 */
	public static final int GMAINTENANCELEVEL = 5;

	/**
	 * The '<em><b>BDESIGNLEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BDESIGNLEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BDESIGNLEVEL_LITERAL
	 * @model name="B_DESIGNLEVEL"
	 * @generated
	 * @ordered
	 */
	public static final int BDESIGNLEVEL = 6;

	/**
	 * The '<em><b>CWORKEXECUTIONLEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CWORKEXECUTIONLEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CWORKEXECUTIONLEVEL_LITERAL
	 * @model name="C_WORKEXECUTIONLEVEL"
	 * @generated
	 * @ordered
	 */
	public static final int CWORKEXECUTIONLEVEL = 7;

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
	 * The '<em><b>AQUALITYOFCOMPONENTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AQUALITYOFCOMPONENTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AQUALITYOFCOMPONENTS_LITERAL
	 * @model name="A_QUALITYOFCOMPONENTS"
	 * @generated
	 * @ordered
	 */
	public static final int AQUALITYOFCOMPONENTS = 9;

	/**
	 * An array of all the '<em><b>Ifc Service Life Factor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcServiceLifeFactorTypeEnum[] VALUES_ARRAY =
		new IfcServiceLifeFactorTypeEnum[]
		{
			NULL_LITERAL,
			EOUTDOORENVIRONMENT_LITERAL,
			FINUSECONDITIONS_LITERAL,
			NOTDEFINED_LITERAL,
			DINDOORENVIRONMENT_LITERAL,
			GMAINTENANCELEVEL_LITERAL,
			BDESIGNLEVEL_LITERAL,
			CWORKEXECUTIONLEVEL_LITERAL,
			USERDEFINED_LITERAL,
			AQUALITYOFCOMPONENTS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Service Life Factor Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcServiceLifeFactorTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Service Life Factor Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeFactorTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcServiceLifeFactorTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Factor Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeFactorTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcServiceLifeFactorTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Factor Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeFactorTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case EOUTDOORENVIRONMENT: return EOUTDOORENVIRONMENT_LITERAL;
			case FINUSECONDITIONS: return FINUSECONDITIONS_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case DINDOORENVIRONMENT: return DINDOORENVIRONMENT_LITERAL;
			case GMAINTENANCELEVEL: return GMAINTENANCELEVEL_LITERAL;
			case BDESIGNLEVEL: return BDESIGNLEVEL_LITERAL;
			case CWORKEXECUTIONLEVEL: return CWORKEXECUTIONLEVEL_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case AQUALITYOFCOMPONENTS: return AQUALITYOFCOMPONENTS_LITERAL;
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
	private IfcServiceLifeFactorTypeEnum(int value, String name, String literal)
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
	
} //IfcServiceLifeFactorTypeEnum
