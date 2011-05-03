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
 * A representation of the literals of the enumeration '<em><b>Ifc Roof Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRoofTypeEnum()
 * @model
 * @generated
 */
public enum IfcRoofTypeEnum implements Enumerator
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
	 * The '<em><b>HIPPED GABLE ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIPPED_GABLE_ROOF
	 * @generated
	 * @ordered
	 */
	HIPPED_GABLE_ROOF_LITERAL(1, "HIPPED_GABLE_ROOF", "HIPPED_GABLE_ROOF"),

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
	 * The '<em><b>SHED ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHED_ROOF
	 * @generated
	 * @ordered
	 */
	SHED_ROOF_LITERAL(3, "SHED_ROOF", "SHED_ROOF"),

	/**
	 * The '<em><b>HIP ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIP_ROOF
	 * @generated
	 * @ordered
	 */
	HIP_ROOF_LITERAL(4, "HIP_ROOF", "HIP_ROOF"),

	/**
	 * The '<em><b>DOME ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOME_ROOF
	 * @generated
	 * @ordered
	 */
	DOME_ROOF_LITERAL(5, "DOME_ROOF", "DOME_ROOF"),

	/**
	 * The '<em><b>PAVILION ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAVILION_ROOF
	 * @generated
	 * @ordered
	 */
	PAVILION_ROOF_LITERAL(6, "PAVILION_ROOF", "PAVILION_ROOF"),

	/**
	 * The '<em><b>GABLE ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GABLE_ROOF
	 * @generated
	 * @ordered
	 */
	GABLE_ROOF_LITERAL(7, "GABLE_ROOF", "GABLE_ROOF"),

	/**
	 * The '<em><b>BARREL ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BARREL_ROOF
	 * @generated
	 * @ordered
	 */
	BARREL_ROOF_LITERAL(8, "BARREL_ROOF", "BARREL_ROOF"),

	/**
	 * The '<em><b>FREEFORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREEFORM
	 * @generated
	 * @ordered
	 */
	FREEFORM_LITERAL(9, "FREEFORM", "FREEFORM"),

	/**
	 * The '<em><b>MANSARD ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANSARD_ROOF
	 * @generated
	 * @ordered
	 */
	MANSARD_ROOF_LITERAL(10, "MANSARD_ROOF", "MANSARD_ROOF"),

	/**
	 * The '<em><b>FLAT ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLAT_ROOF
	 * @generated
	 * @ordered
	 */
	FLAT_ROOF_LITERAL(11, "FLAT_ROOF", "FLAT_ROOF"),

	/**
	 * The '<em><b>RAINBOW ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAINBOW_ROOF
	 * @generated
	 * @ordered
	 */
	RAINBOW_ROOF_LITERAL(12, "RAINBOW_ROOF", "RAINBOW_ROOF"),

	/**
	 * The '<em><b>GAMBREL ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GAMBREL_ROOF
	 * @generated
	 * @ordered
	 */
	GAMBREL_ROOF_LITERAL(13, "GAMBREL_ROOF", "GAMBREL_ROOF"),

	/**
	 * The '<em><b>BUTTERFLY ROOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUTTERFLY_ROOF
	 * @generated
	 * @ordered
	 */
	BUTTERFLY_ROOF_LITERAL(14, "BUTTERFLY_ROOF", "BUTTERFLY_ROOF");

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
	 * The '<em><b>HIPPED GABLE ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIPPED GABLE ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIPPED_GABLE_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIPPED_GABLE_ROOF = 1;

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
	 * The '<em><b>SHED ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHED ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHED_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHED_ROOF = 3;

	/**
	 * The '<em><b>HIP ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HIP ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HIP_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIP_ROOF = 4;

	/**
	 * The '<em><b>DOME ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOME ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOME_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOME_ROOF = 5;

	/**
	 * The '<em><b>PAVILION ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PAVILION ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAVILION_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PAVILION_ROOF = 6;

	/**
	 * The '<em><b>GABLE ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GABLE ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GABLE_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GABLE_ROOF = 7;

	/**
	 * The '<em><b>BARREL ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BARREL ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BARREL_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BARREL_ROOF = 8;

	/**
	 * The '<em><b>FREEFORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREEFORM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREEFORM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREEFORM = 9;

	/**
	 * The '<em><b>MANSARD ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANSARD ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANSARD_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANSARD_ROOF = 10;

	/**
	 * The '<em><b>FLAT ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLAT ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLAT_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLAT_ROOF = 11;

	/**
	 * The '<em><b>RAINBOW ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RAINBOW ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAINBOW_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAINBOW_ROOF = 12;

	/**
	 * The '<em><b>GAMBREL ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GAMBREL ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GAMBREL_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GAMBREL_ROOF = 13;

	/**
	 * The '<em><b>BUTTERFLY ROOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUTTERFLY ROOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUTTERFLY_ROOF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUTTERFLY_ROOF = 14;

	/**
	 * An array of all the '<em><b>Ifc Roof Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoofTypeEnum[] VALUES_ARRAY =
		new IfcRoofTypeEnum[]
		{
			NULL_LITERAL,
			HIPPED_GABLE_ROOF_LITERAL,
			NOTDEFINED_LITERAL,
			SHED_ROOF_LITERAL,
			HIP_ROOF_LITERAL,
			DOME_ROOF_LITERAL,
			PAVILION_ROOF_LITERAL,
			GABLE_ROOF_LITERAL,
			BARREL_ROOF_LITERAL,
			FREEFORM_LITERAL,
			MANSARD_ROOF_LITERAL,
			FLAT_ROOF_LITERAL,
			RAINBOW_ROOF_LITERAL,
			GAMBREL_ROOF_LITERAL,
			BUTTERFLY_ROOF_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Roof Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcRoofTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcRoofTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcRoofTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcRoofTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcRoofTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Roof Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcRoofTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case HIPPED_GABLE_ROOF: return HIPPED_GABLE_ROOF_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case SHED_ROOF: return SHED_ROOF_LITERAL;
			case HIP_ROOF: return HIP_ROOF_LITERAL;
			case DOME_ROOF: return DOME_ROOF_LITERAL;
			case PAVILION_ROOF: return PAVILION_ROOF_LITERAL;
			case GABLE_ROOF: return GABLE_ROOF_LITERAL;
			case BARREL_ROOF: return BARREL_ROOF_LITERAL;
			case FREEFORM: return FREEFORM_LITERAL;
			case MANSARD_ROOF: return MANSARD_ROOF_LITERAL;
			case FLAT_ROOF: return FLAT_ROOF_LITERAL;
			case RAINBOW_ROOF: return RAINBOW_ROOF_LITERAL;
			case GAMBREL_ROOF: return GAMBREL_ROOF_LITERAL;
			case BUTTERFLY_ROOF: return BUTTERFLY_ROOF_LITERAL;
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
	private IfcRoofTypeEnum(int value, String name, String literal)
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
	
} //IfcRoofTypeEnum
