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
 * A representation of the literals of the enumeration '<em><b>Ifc Service Life Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcServiceLifeTypeEnum()
 * @model
 * @generated
 */
public enum IfcServiceLifeTypeEnum implements Enumerator
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
	 * The '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PESSIMISTICREFERENCESERVICELIFE
	 * @generated
	 * @ordered
	 */
	PESSIMISTICREFERENCESERVICELIFE_LITERAL(1, "PESSIMISTICREFERENCESERVICELIFE", "PESSIMISTICREFERENCESERVICELIFE"),

	/**
	 * The '<em><b>EXPECTEDSERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPECTEDSERVICELIFE
	 * @generated
	 * @ordered
	 */
	EXPECTEDSERVICELIFE_LITERAL(2, "EXPECTEDSERVICELIFE", "EXPECTEDSERVICELIFE"),

	/**
	 * The '<em><b>REFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCESERVICELIFE
	 * @generated
	 * @ordered
	 */
	REFERENCESERVICELIFE_LITERAL(3, "REFERENCESERVICELIFE", "REFERENCESERVICELIFE"),

	/**
	 * The '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIMISTICREFERENCESERVICELIFE
	 * @generated
	 * @ordered
	 */
	OPTIMISTICREFERENCESERVICELIFE_LITERAL(4, "OPTIMISTICREFERENCESERVICELIFE", "OPTIMISTICREFERENCESERVICELIFE"),

	/**
	 * The '<em><b>ACTUALSERVICELIFE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTUALSERVICELIFE
	 * @generated
	 * @ordered
	 */
	ACTUALSERVICELIFE_LITERAL(5, "ACTUALSERVICELIFE", "ACTUALSERVICELIFE");

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
	 * The '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PESSIMISTICREFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PESSIMISTICREFERENCESERVICELIFE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PESSIMISTICREFERENCESERVICELIFE = 1;

	/**
	 * The '<em><b>EXPECTEDSERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPECTEDSERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPECTEDSERVICELIFE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXPECTEDSERVICELIFE = 2;

	/**
	 * The '<em><b>REFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCESERVICELIFE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCESERVICELIFE = 3;

	/**
	 * The '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OPTIMISTICREFERENCESERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPTIMISTICREFERENCESERVICELIFE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPTIMISTICREFERENCESERVICELIFE = 4;

	/**
	 * The '<em><b>ACTUALSERVICELIFE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTUALSERVICELIFE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTUALSERVICELIFE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTUALSERVICELIFE = 5;

	/**
	 * An array of all the '<em><b>Ifc Service Life Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcServiceLifeTypeEnum[] VALUES_ARRAY =
		new IfcServiceLifeTypeEnum[]
		{
			NULL_LITERAL,
			PESSIMISTICREFERENCESERVICELIFE_LITERAL,
			EXPECTEDSERVICELIFE_LITERAL,
			REFERENCESERVICELIFE_LITERAL,
			OPTIMISTICREFERENCESERVICELIFE_LITERAL,
			ACTUALSERVICELIFE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Service Life Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcServiceLifeTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcServiceLifeTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcServiceLifeTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Service Life Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcServiceLifeTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case PESSIMISTICREFERENCESERVICELIFE: return PESSIMISTICREFERENCESERVICELIFE_LITERAL;
			case EXPECTEDSERVICELIFE: return EXPECTEDSERVICELIFE_LITERAL;
			case REFERENCESERVICELIFE: return REFERENCESERVICELIFE_LITERAL;
			case OPTIMISTICREFERENCESERVICELIFE: return OPTIMISTICREFERENCESERVICELIFE_LITERAL;
			case ACTUALSERVICELIFE: return ACTUALSERVICELIFE_LITERAL;
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
	private IfcServiceLifeTypeEnum(int value, String name, String literal)
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
	
} //IfcServiceLifeTypeEnum
