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
 * A representation of the literals of the enumeration '<em><b>Ifc BSpline Curve Form</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBSplineCurveForm()
 * @model
 * @generated
 */
public enum IfcBSplineCurveForm implements Enumerator
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
	 * The '<em><b>PARABOLIC ARC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARABOLIC_ARC
	 * @generated
	 * @ordered
	 */
	PARABOLIC_ARC_LITERAL(1, "PARABOLIC_ARC", "PARABOLIC_ARC"),

	/**
	 * The '<em><b>ELLIPTIC ARC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELLIPTIC_ARC
	 * @generated
	 * @ordered
	 */
	ELLIPTIC_ARC_LITERAL(2, "ELLIPTIC_ARC", "ELLIPTIC_ARC"),

	/**
	 * The '<em><b>HYPERBOLIC ARC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HYPERBOLIC_ARC
	 * @generated
	 * @ordered
	 */
	HYPERBOLIC_ARC_LITERAL(3, "HYPERBOLIC_ARC", "HYPERBOLIC_ARC"),

	/**
	 * The '<em><b>UNSPECIFIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(4, "UNSPECIFIED", "UNSPECIFIED"),

	/**
	 * The '<em><b>POLYLINE FORM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POLYLINE_FORM
	 * @generated
	 * @ordered
	 */
	POLYLINE_FORM_LITERAL(5, "POLYLINE_FORM", "POLYLINE_FORM"),

	/**
	 * The '<em><b>CIRCULAR ARC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_ARC
	 * @generated
	 * @ordered
	 */
	CIRCULAR_ARC_LITERAL(6, "CIRCULAR_ARC", "CIRCULAR_ARC");

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
	 * The '<em><b>PARABOLIC ARC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARABOLIC ARC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARABOLIC_ARC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARABOLIC_ARC = 1;

	/**
	 * The '<em><b>ELLIPTIC ARC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELLIPTIC ARC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELLIPTIC_ARC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELLIPTIC_ARC = 2;

	/**
	 * The '<em><b>HYPERBOLIC ARC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HYPERBOLIC ARC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HYPERBOLIC_ARC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HYPERBOLIC_ARC = 3;

	/**
	 * The '<em><b>UNSPECIFIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNSPECIFIED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED = 4;

	/**
	 * The '<em><b>POLYLINE FORM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POLYLINE FORM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POLYLINE_FORM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POLYLINE_FORM = 5;

	/**
	 * The '<em><b>CIRCULAR ARC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CIRCULAR ARC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIRCULAR_ARC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CIRCULAR_ARC = 6;

	/**
	 * An array of all the '<em><b>Ifc BSpline Curve Form</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBSplineCurveForm[] VALUES_ARRAY =
		new IfcBSplineCurveForm[]
		{
			NULL_LITERAL,
			PARABOLIC_ARC_LITERAL,
			ELLIPTIC_ARC_LITERAL,
			HYPERBOLIC_ARC_LITERAL,
			UNSPECIFIED_LITERAL,
			POLYLINE_FORM_LITERAL,
			CIRCULAR_ARC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc BSpline Curve Form</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBSplineCurveForm> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc BSpline Curve Form</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcBSplineCurveForm get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcBSplineCurveForm result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc BSpline Curve Form</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcBSplineCurveForm getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcBSplineCurveForm result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc BSpline Curve Form</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcBSplineCurveForm get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case PARABOLIC_ARC: return PARABOLIC_ARC_LITERAL;
			case ELLIPTIC_ARC: return ELLIPTIC_ARC_LITERAL;
			case HYPERBOLIC_ARC: return HYPERBOLIC_ARC_LITERAL;
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
			case POLYLINE_FORM: return POLYLINE_FORM_LITERAL;
			case CIRCULAR_ARC: return CIRCULAR_ARC_LITERAL;
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
	private IfcBSplineCurveForm(int value, String name, String literal)
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
	
} //IfcBSplineCurveForm
