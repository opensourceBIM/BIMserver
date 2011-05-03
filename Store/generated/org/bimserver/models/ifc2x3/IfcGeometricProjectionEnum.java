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
 * A representation of the literals of the enumeration '<em><b>Ifc Geometric Projection Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcGeometricProjectionEnum()
 * @model
 * @generated
 */
public enum IfcGeometricProjectionEnum implements Enumerator
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
	 * The '<em><b>ELEVATION VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELEVATION_VIEW
	 * @generated
	 * @ordered
	 */
	ELEVATION_VIEW_LITERAL(1, "ELEVATION_VIEW", "ELEVATION_VIEW"),

	/**
	 * The '<em><b>SKETCH VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKETCH_VIEW
	 * @generated
	 * @ordered
	 */
	SKETCH_VIEW_LITERAL(2, "SKETCH_VIEW", "SKETCH_VIEW"),

	/**
	 * The '<em><b>REFLECTED PLAN VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFLECTED_PLAN_VIEW
	 * @generated
	 * @ordered
	 */
	REFLECTED_PLAN_VIEW_LITERAL(3, "REFLECTED_PLAN_VIEW", "REFLECTED_PLAN_VIEW"),

	/**
	 * The '<em><b>PLAN VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAN_VIEW
	 * @generated
	 * @ordered
	 */
	PLAN_VIEW_LITERAL(4, "PLAN_VIEW", "PLAN_VIEW"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(5, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>GRAPH VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAPH_VIEW
	 * @generated
	 * @ordered
	 */
	GRAPH_VIEW_LITERAL(6, "GRAPH_VIEW", "GRAPH_VIEW"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(7, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SECTION VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECTION_VIEW
	 * @generated
	 * @ordered
	 */
	SECTION_VIEW_LITERAL(8, "SECTION_VIEW", "SECTION_VIEW"),

	/**
	 * The '<em><b>MODEL VIEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODEL_VIEW
	 * @generated
	 * @ordered
	 */
	MODEL_VIEW_LITERAL(9, "MODEL_VIEW", "MODEL_VIEW");

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
	 * The '<em><b>ELEVATION VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELEVATION VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELEVATION_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELEVATION_VIEW = 1;

	/**
	 * The '<em><b>SKETCH VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SKETCH VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SKETCH_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SKETCH_VIEW = 2;

	/**
	 * The '<em><b>REFLECTED PLAN VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFLECTED PLAN VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFLECTED_PLAN_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFLECTED_PLAN_VIEW = 3;

	/**
	 * The '<em><b>PLAN VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLAN VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAN_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLAN_VIEW = 4;

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
	public static final int NOTDEFINED = 5;

	/**
	 * The '<em><b>GRAPH VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAPH VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAPH_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAPH_VIEW = 6;

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
	public static final int USERDEFINED = 7;

	/**
	 * The '<em><b>SECTION VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECTION VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECTION_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECTION_VIEW = 8;

	/**
	 * The '<em><b>MODEL VIEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEL VIEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_VIEW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_VIEW = 9;

	/**
	 * An array of all the '<em><b>Ifc Geometric Projection Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcGeometricProjectionEnum[] VALUES_ARRAY =
		new IfcGeometricProjectionEnum[]
		{
			NULL_LITERAL,
			ELEVATION_VIEW_LITERAL,
			SKETCH_VIEW_LITERAL,
			REFLECTED_PLAN_VIEW_LITERAL,
			PLAN_VIEW_LITERAL,
			NOTDEFINED_LITERAL,
			GRAPH_VIEW_LITERAL,
			USERDEFINED_LITERAL,
			SECTION_VIEW_LITERAL,
			MODEL_VIEW_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Geometric Projection Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcGeometricProjectionEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Geometric Projection Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcGeometricProjectionEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcGeometricProjectionEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Geometric Projection Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcGeometricProjectionEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcGeometricProjectionEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Geometric Projection Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcGeometricProjectionEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case ELEVATION_VIEW: return ELEVATION_VIEW_LITERAL;
			case SKETCH_VIEW: return SKETCH_VIEW_LITERAL;
			case REFLECTED_PLAN_VIEW: return REFLECTED_PLAN_VIEW_LITERAL;
			case PLAN_VIEW: return PLAN_VIEW_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case GRAPH_VIEW: return GRAPH_VIEW_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case SECTION_VIEW: return SECTION_VIEW_LITERAL;
			case MODEL_VIEW: return MODEL_VIEW_LITERAL;
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
	private IfcGeometricProjectionEnum(int value, String name, String literal)
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
	
} //IfcGeometricProjectionEnum
