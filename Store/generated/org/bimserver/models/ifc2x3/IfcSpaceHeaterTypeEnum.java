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
 * A representation of the literals of the enumeration '<em><b>Ifc Space Heater Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceHeaterTypeEnum()
 * @model
 * @generated
 */
public enum IfcSpaceHeaterTypeEnum implements Enumerator
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
	 * The '<em><b>UNITHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNITHEATER
	 * @generated
	 * @ordered
	 */
	UNITHEATER_LITERAL(1, "UNITHEATER", "UNITHEATER"),

	/**
	 * The '<em><b>BASEBOARDHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASEBOARDHEATER
	 * @generated
	 * @ordered
	 */
	BASEBOARDHEATER_LITERAL(2, "BASEBOARDHEATER", "BASEBOARDHEATER"),

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
	 * The '<em><b>PANELRADIATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PANELRADIATOR
	 * @generated
	 * @ordered
	 */
	PANELRADIATOR_LITERAL(4, "PANELRADIATOR", "PANELRADIATOR"),

	/**
	 * The '<em><b>CONVECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONVECTOR
	 * @generated
	 * @ordered
	 */
	CONVECTOR_LITERAL(5, "CONVECTOR", "CONVECTOR"),

	/**
	 * The '<em><b>TUBULARRADIATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUBULARRADIATOR
	 * @generated
	 * @ordered
	 */
	TUBULARRADIATOR_LITERAL(6, "TUBULARRADIATOR", "TUBULARRADIATOR"),

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
	 * The '<em><b>FINNEDTUBEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINNEDTUBEUNIT
	 * @generated
	 * @ordered
	 */
	FINNEDTUBEUNIT_LITERAL(8, "FINNEDTUBEUNIT", "FINNEDTUBEUNIT"),

	/**
	 * The '<em><b>SECTIONALRADIATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECTIONALRADIATOR
	 * @generated
	 * @ordered
	 */
	SECTIONALRADIATOR_LITERAL(9, "SECTIONALRADIATOR", "SECTIONALRADIATOR");

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
	 * The '<em><b>UNITHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNITHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNITHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNITHEATER = 1;

	/**
	 * The '<em><b>BASEBOARDHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BASEBOARDHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASEBOARDHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BASEBOARDHEATER = 2;

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
	 * The '<em><b>PANELRADIATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PANELRADIATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PANELRADIATOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PANELRADIATOR = 4;

	/**
	 * The '<em><b>CONVECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONVECTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONVECTOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONVECTOR = 5;

	/**
	 * The '<em><b>TUBULARRADIATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUBULARRADIATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUBULARRADIATOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUBULARRADIATOR = 6;

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
	 * The '<em><b>FINNEDTUBEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINNEDTUBEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINNEDTUBEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINNEDTUBEUNIT = 8;

	/**
	 * The '<em><b>SECTIONALRADIATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECTIONALRADIATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECTIONALRADIATOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECTIONALRADIATOR = 9;

	/**
	 * An array of all the '<em><b>Ifc Space Heater Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSpaceHeaterTypeEnum[] VALUES_ARRAY =
		new IfcSpaceHeaterTypeEnum[]
		{
			NULL_LITERAL,
			UNITHEATER_LITERAL,
			BASEBOARDHEATER_LITERAL,
			NOTDEFINED_LITERAL,
			PANELRADIATOR_LITERAL,
			CONVECTOR_LITERAL,
			TUBULARRADIATOR_LITERAL,
			USERDEFINED_LITERAL,
			FINNEDTUBEUNIT_LITERAL,
			SECTIONALRADIATOR_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Space Heater Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSpaceHeaterTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Space Heater Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSpaceHeaterTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSpaceHeaterTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Space Heater Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSpaceHeaterTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSpaceHeaterTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Space Heater Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSpaceHeaterTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case UNITHEATER: return UNITHEATER_LITERAL;
			case BASEBOARDHEATER: return BASEBOARDHEATER_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case PANELRADIATOR: return PANELRADIATOR_LITERAL;
			case CONVECTOR: return CONVECTOR_LITERAL;
			case TUBULARRADIATOR: return TUBULARRADIATOR_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case FINNEDTUBEUNIT: return FINNEDTUBEUNIT_LITERAL;
			case SECTIONALRADIATOR: return SECTIONALRADIATOR_LITERAL;
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
	private IfcSpaceHeaterTypeEnum(int value, String name, String literal)
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
	
} //IfcSpaceHeaterTypeEnum
