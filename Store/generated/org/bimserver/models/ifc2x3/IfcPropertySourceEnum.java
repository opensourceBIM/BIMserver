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
 * A representation of the literals of the enumeration '<em><b>Ifc Property Source Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPropertySourceEnum()
 * @model
 * @generated
 */
public enum IfcPropertySourceEnum implements Enumerator
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
	 * The '<em><b>NOTKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTKNOWN
	 * @generated
	 * @ordered
	 */
	NOTKNOWN_LITERAL(1, "NOTKNOWN", "NOTKNOWN"),

	/**
	 * The '<em><b>DESIGN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESIGN
	 * @generated
	 * @ordered
	 */
	DESIGN_LITERAL(2, "DESIGN", "DESIGN"),

	/**
	 * The '<em><b>ASBUILT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASBUILT
	 * @generated
	 * @ordered
	 */
	ASBUILT_LITERAL(3, "ASBUILT", "ASBUILT"),

	/**
	 * The '<em><b>MEASURED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEASURED
	 * @generated
	 * @ordered
	 */
	MEASURED_LITERAL(4, "MEASURED", "MEASURED"),

	/**
	 * The '<em><b>DESIGNMINIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESIGNMINIMUM
	 * @generated
	 * @ordered
	 */
	DESIGNMINIMUM_LITERAL(5, "DESIGNMINIMUM", "DESIGNMINIMUM"),

	/**
	 * The '<em><b>COMMISSIONING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING
	 * @generated
	 * @ordered
	 */
	COMMISSIONING_LITERAL(6, "COMMISSIONING", "COMMISSIONING"),

	/**
	 * The '<em><b>DESIGNMAXIMUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESIGNMAXIMUM
	 * @generated
	 * @ordered
	 */
	DESIGNMAXIMUM_LITERAL(7, "DESIGNMAXIMUM", "DESIGNMAXIMUM"),

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
	 * The '<em><b>SIMULATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIMULATED
	 * @generated
	 * @ordered
	 */
	SIMULATED_LITERAL(9, "SIMULATED", "SIMULATED");

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
	 * The '<em><b>NOTKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTKNOWN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTKNOWN = 1;

	/**
	 * The '<em><b>DESIGN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DESIGN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DESIGN = 2;

	/**
	 * The '<em><b>ASBUILT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ASBUILT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASBUILT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ASBUILT = 3;

	/**
	 * The '<em><b>MEASURED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEASURED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEASURED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEASURED = 4;

	/**
	 * The '<em><b>DESIGNMINIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DESIGNMINIMUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGNMINIMUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DESIGNMINIMUM = 5;

	/**
	 * The '<em><b>COMMISSIONING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMISSIONING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMMISSIONING = 6;

	/**
	 * The '<em><b>DESIGNMAXIMUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DESIGNMAXIMUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESIGNMAXIMUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DESIGNMAXIMUM = 7;

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
	 * The '<em><b>SIMULATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIMULATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIMULATED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIMULATED = 9;

	/**
	 * An array of all the '<em><b>Ifc Property Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcPropertySourceEnum[] VALUES_ARRAY =
		new IfcPropertySourceEnum[]
		{
			NULL_LITERAL,
			NOTKNOWN_LITERAL,
			DESIGN_LITERAL,
			ASBUILT_LITERAL,
			MEASURED_LITERAL,
			DESIGNMINIMUM_LITERAL,
			COMMISSIONING_LITERAL,
			DESIGNMAXIMUM_LITERAL,
			USERDEFINED_LITERAL,
			SIMULATED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Property Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcPropertySourceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Property Source Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcPropertySourceEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcPropertySourceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Property Source Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcPropertySourceEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcPropertySourceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Property Source Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcPropertySourceEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTKNOWN: return NOTKNOWN_LITERAL;
			case DESIGN: return DESIGN_LITERAL;
			case ASBUILT: return ASBUILT_LITERAL;
			case MEASURED: return MEASURED_LITERAL;
			case DESIGNMINIMUM: return DESIGNMINIMUM_LITERAL;
			case COMMISSIONING: return COMMISSIONING_LITERAL;
			case DESIGNMAXIMUM: return DESIGNMAXIMUM_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case SIMULATED: return SIMULATED_LITERAL;
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
	private IfcPropertySourceEnum(int value, String name, String literal)
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
	
} //IfcPropertySourceEnum
